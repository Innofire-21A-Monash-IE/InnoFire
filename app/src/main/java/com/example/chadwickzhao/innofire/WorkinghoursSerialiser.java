package com.example.chadwickzhao.innofire;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by chadwickzhao on 5/09/16.
 */
public class WorkinghoursSerialiser implements JsonSerializer<Workinghours> {
    @Override
    public JsonElement serialize(Workinghours src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        final JsonElement jsonUsername = context.serialize(src.getUsername());
        jsonObject.add("username", jsonUsername);
        jsonObject.addProperty("wdate",src.getWdate());
        jsonObject.addProperty("wduration", src.getWduration());
        jsonObject.addProperty("workinghourid", src.getWorkinghourid());
        return jsonObject;
    }
}
