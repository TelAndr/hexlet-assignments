package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("firstName");
            List<User> processedUsers = new ArrayList<>();
            // Фильтруем, только если была отправлена форма
            if (term != null && !term.isEmpty()) {
                processedUsers = USERS.stream()
                         .filter(user -> { return StringUtils.startsWithIgnoreCase(user.getFirstName(), term);} )
                         .toList();/* Фильтруем курсы по term */
            } else {
                processedUsers = USERS;
            }
            var usersPage = new UsersPage(processedUsers, term);
            ctx.render("users/index.jte", model("usersPage", usersPage));
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
