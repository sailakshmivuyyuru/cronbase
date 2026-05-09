package com.cronbase.usecase.user;

import com.cronbase.common.JsonTransformer;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class User {

    private static final UserRepository userRepository = new UserRepository();
    private static final Gson gson = new Gson();

    public static Response getAll(Request request, Response response) {
        response.type("application/json");
        response.body(gson.toJson(userRepository.findAll()));
        return response;
    }

    public static Response getById(Request request, Response response) {
        response.type("application/json");
        Long id = Long.parseLong(request.params(":id"));
        userRepository.findById(id)
                .ifPresent(user -> response.body(gson.toJson(user)));
        return response;
    }

    public static Response create(Request request, Response response) {
        response.type("application/json");
        com.cronbase.schema.tables.pojos.User user = gson.fromJson(request.body(), com.cronbase.schema.tables.pojos.User.class);
        response.body(gson.toJson(userRepository.save(user)));
        return response;
    }

    public static Response delete(Request request, Response response) {
        Long id = Long.parseLong(request.params(":id"));
        userRepository.deleteById(id);
        response.status(204);
        return response;
    }
}
