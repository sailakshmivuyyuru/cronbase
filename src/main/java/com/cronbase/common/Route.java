package com.cronbase.common;

import com.cronbase.usecase.user.User;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

public final class Route {

    private Route() {
    }

    public static void init() {

        get("/health", (request, response) -> "OK");

        path(
                "/api",
                () ->
                        path(
                                "/users",
                                () -> {
                                    post("", User::create);
                                    get("", User::getAll);
                                    put("", User::create);
                                    delete("", User::delete);
                                }
                        )
        );
    }
}
