package com.cronbase.common;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public final class JsonTransformer implements ResponseTransformer {

    private static final Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
}
