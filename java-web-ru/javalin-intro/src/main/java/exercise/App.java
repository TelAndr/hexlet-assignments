package exercise;

// BEGIN
//package org.example.hexlet;
//package com.huongdanjava.javalin;

import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        //app.start(7070); // Стартуем веб-сервер
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
