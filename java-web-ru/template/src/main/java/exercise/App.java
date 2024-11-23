package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Objects;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users/{id}", ctx -> {
            //var id = ctx.pathParam("id");
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = USERS.stream().filter((USER -> USER.getId() == id).orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);
			if(Objects.isNull(user)) {
                //var id = ctx.pathParamAsClass("id", Long.class).get();
                //var user = UserRepository.find(id) // Ищем пользователя в базе по id
                //        .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
			} else {
				ctx.render("users/show.jte", model("page", page));
			}
        });
		
		app.get("/users", ctx -> {
            //var users = USERS;
            var page = new UsersPage(USERS);
			for (User curUser : USERS) {
				if (Objects.isNull(curUser)) {
					ctx.render();
				} else {
					ctx.render("users/index.jte", model("page", page));
				}
			}
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
