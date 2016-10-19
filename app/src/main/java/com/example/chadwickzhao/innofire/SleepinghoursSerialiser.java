package com.example.chadwickzhao.innofire;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by chadwickzhao on 5/09/16.
 */
public class SleepinghoursSerialiser implements JsonSerializer<Sleepinghours> {
    @Override
    public JsonElement serialize(Sleepinghours src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("sdate", src.getSdate());
        jsonObject.addProperty("sduration", src.getSduration());
        jsonObject.addProperty("sleepingHourId", src.getSleepingHourId());

        final JsonElement jsonUsername = context.serialize(src.getUsername());
        jsonObject.add("username", jsonUsername);
        return jsonObject;
    }
}
