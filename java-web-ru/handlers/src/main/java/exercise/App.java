package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.javalin.Javalin;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;


public final class App {

    public static Javalin getApp()  { // throws IOException  Exception

        // BEGIN
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArrayPhones = null;
        try {
            jsonArrayPhones = objectMapper.writeValueAsString(phones);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String jsonArrayDomains = null;
        try {
            jsonArrayDomains = objectMapper.writeValueAsString(domains);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        String finalJsonArrayPhones = jsonArrayPhones;
        app.get("/phones", ctx -> ctx.result(finalJsonArrayPhones));
        String finalJsonArrayDomains = jsonArrayDomains;
        app.get("/domains", ctx -> ctx.result(finalJsonArrayDomains));
        return app;
        // END
    }

    @NotNull
    public static void main(String[] args) throws IOException {
        Javalin app = getApp();
        app.start(7070);
    }
}
