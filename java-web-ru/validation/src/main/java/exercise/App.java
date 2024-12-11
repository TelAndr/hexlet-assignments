package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
		app.get("/articles/build", ctx -> {
			BuildArticlePage page = new BuildArticlePage();
			ctx.render("articles/build.jte", model("page", page));
		});
		app.post("/articles", ctx -> {
		  try {
			  var title = ctx.formParamAsClass("title", String.class)
					  .check(value -> value.trim().length() >= 2, "У названия статьи недостаточная длина" )
					  .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
					  .get(); //!Assert.IsTrue(verifyTextPresent("title")))
			  var content = ctx.formParamAsClass("content", String.class)
						.check(value -> value.length() >= 10, "У содержимого статьи недостаточная длина")
						.get();
			  var article = new Article(title, content);
			  ArticleRepository.save(article);
			  ctx.redirect("/articles");
		  } catch (ValidationException e) {
			  var title = ctx.formParam("title").trim();
			  var content = ctx.formParam("content").trim();
			  var page = new BuildArticlePage(title, content, e.getErrors());
			  ctx.render("articles/build.jte", model("page", page)).status(422);
		  }
	  });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}