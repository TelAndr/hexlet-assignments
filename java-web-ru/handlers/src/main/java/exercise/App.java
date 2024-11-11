package exercise;

import io.javalin.Javalin;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;


public final class App {

    public static Javalin getApp() throws IOException { //  Exception

        // BEGIN
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArrayPhones = objectMapper.writeValueAsString(phones);
        String jsonArrayDomains = objectMapper.writeValueAsString(domains);
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.result(jsonArrayPhones));
        app.get("/domains", ctx -> ctx.result(jsonArrayDomains));
        return app;
        // END
    }

    @NotNull
    public static void main(String[] args) throws IOException {
        Javalin app = getApp();
        app.start(7070);
    }
}
