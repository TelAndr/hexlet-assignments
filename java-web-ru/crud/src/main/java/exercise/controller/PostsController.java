package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.util.List;
public class PostsController {

    // BEGIN
    //public static void index(Context ctx) {
    //    app.routes(() -> {
	//	   path("posts", () -> {
	//		   get(PostController.listPosts);
	//		   path("{id}", () -> {
	//			   get(PostController.showPost);
	//		   });
	//	   });
	//	});
	//	app.get("/posts", ctx -> {
	//		var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
	//		var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
	//		var offset = (page - 1) * per;
	//		var sublistPosts = listPosts.subList(offset, offset + per);
	//		ctx.json(sublistPosts);
	//	});
    //}

	public static void show(Context ctx) {
		var id = ctx.pathParamAsClass("id", Long.class).get();
		var post = PostRepository.find(id)
				.orElseThrow(() -> new NotFoundResponse("Page not found"));
		var page = new PostPage(post);
		ctx.render("posts/show.jte", model("page", page));
		//ctx.render(posts/show.jte);
		//var posts = PostRepository.getEntities();
		//var page = new PostPage(post);
		//ctx.render("posts/index.jte", model("page", page));
		//app.error(404, ctx -> { ctx.result("Page not found") });
	}
	public static void posts(Context ctx) {
		Integer currPageNum = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
		List<Post> posts = PostRepository.findAll(currPageNum, 5);
		PostsPage page = new PostsPage(posts, currPageNum);
		ctx.render("posts/index.jte", model("page", page));
	}
    // END
}
