package com.cronbase;

import com.cronbase.common.JsonTransformer;
import com.cronbase.common.Route;
import com.cronbase.common.Server;
import com.cronbase.usecase.user.User;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Server.init();
        JsonTransformer jsonTransformer = new JsonTransformer();
        path("/users", () -> {
            get("", User::getAll, jsonTransformer);
            get("/:id", User::getById, jsonTransformer);
            post("", User::create, jsonTransformer);
            delete("/:id", User::delete, jsonTransformer);
        });
    }
}
