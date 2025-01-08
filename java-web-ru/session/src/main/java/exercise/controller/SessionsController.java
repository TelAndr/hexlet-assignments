package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    //app.get("/sessions/build", SessionsController::build);
	public static void build(Context ctx) {
        LoginPage page = new LoginPage(ctx.sessionAttribute("auth"), null);
		ctx.render("build.jte", model("page", page));
    }
	public static void index(Context ctx) {
		LoginPage page = new LoginPage(ctx.sessionAttribute("auth"), null);
		ctx.render("index.jte", model("page", page));
	}
	//app.post("/sessions", SessionsController::create);
	public static void create(Context ctx) {
        String name = ctx.formParam("name");
		String password = ctx.formParam("password");
		String encryptPassword = Security.encrypt(password);
		var user = UsersRepository.findByName(name);
		if (user == null || !user.getPassword().equals(encryptPassword)) {
			LoginPage page = new LoginPage(name, "Wrong username or password");
			ctx.render("build.jte", model("page", page)).status(302);
		} else {
			ctx.sessionAttribute("auth", name);
			ctx.redirect(NamedRoutes.rootPath());
		}
		//SecureRandom random = new SecureRandom();
		//byte[] salt = new byte[16];
		//random.nextBytes(salt);
		//KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		//SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        //ctx.sessionAttribute("currentUser", nickname);
        //ctx.redirect("/");
    }
	public static void destroy(Context ctx) {
        ctx.sessionAttribute("auth", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
