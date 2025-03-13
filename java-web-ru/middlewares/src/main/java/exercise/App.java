package exercise;

import io.javalin.Javalin;
import exercise.controller.PostsController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.codec.digest.DigestUtils;

public final class App {

    public static Javalin getApp() {

        private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
		
		var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        app.get(NamedRoutes.buildPostPath(), PostsController::build);
        app.post(NamedRoutes.postsPath(), PostsController::create);

        app.get(NamedRoutes.postsPath(), PostsController::index);
        app.get(NamedRoutes.postPath("{id}"), PostsController::show);

        app.get(NamedRoutes.editPostPath("{id}"), PostsController::edit);
        app.post(NamedRoutes.postPath("{id}"), PostsController::update);

        // BEGIN
        app.before(ctx -> {
            String id = ctx.queryParam("id");
            if (id == null || id.isEmpty()) {
                ctx.status(400).result("Bad Request: Missing 'id' parameter");
                ctx.skipRemainingHandlers(); // Завершаем обработку
            }
        });

        // Эта мидлвара и обработчики не будет выполнены, если параметр "id" отсутствует
        app.before(ctx -> {
            var path = ctx.path();
            System.out.println("Request path: " + path);
        });

		app.before(ctx -> {
            ctx.header("X-Response-Digest", "value");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(
			  value.getBytes(StandardCharsets.UTF_8));
			 String hashString = bytesToHex(encodedhash);
        });

        app.get("/resource", ctx -> {
            String id = ctx.queryParam("id");
            ctx.result("Resource with id: " + id);
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}



