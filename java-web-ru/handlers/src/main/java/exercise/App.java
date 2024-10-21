package exercise;

import io.javalin.Javalin;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
		List<String> phones = Data.getPhones();
		List<String> domains = Data.getDomains();
        Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        this.get("/phones", ctx -> ctx.result(phones));
		this.get("/domains", ctx -> ctx.result(domains));
        this.start(7070);
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
