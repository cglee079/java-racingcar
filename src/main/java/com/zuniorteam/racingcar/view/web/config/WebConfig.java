package com.zuniorteam.racingcar.view.web.config;

import com.zuniorteam.racingcar.view.web.route.NameRoute;
import com.zuniorteam.racingcar.view.web.route.ResultRoute;
import spark.Spark;

import static spark.Spark.*;
import static spark.Spark.post;

public final class WebConfig {

    private static final String RESOURCE_DIRECTORY = "/templates";

    private WebConfig() {
    }

    public static void initConfig() {
        port(8080);
        staticFiles.location(RESOURCE_DIRECTORY);

        initRoute();
        initExceptionHandler();
    }

    private static void initRoute() {
        post("/name", new NameRoute.post());
        post("/result", new ResultRoute.post());
    }

    private static void initExceptionHandler() {
        Spark.exception(Exception.class, (exception, request, response) -> response.body("Error - " + exception.getMessage()));
    }
}
