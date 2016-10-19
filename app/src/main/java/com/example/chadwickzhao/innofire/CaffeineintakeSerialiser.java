package com.example.chadwickzhao.innofire;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.sql.Date;

/**
 * Created by chadwickzhao on 4/09/16.
 * The foreign key of username in Caffeine table
 */
public class CaffeineintakeSerialiser implements JsonSerializer<Caffeineintake> {


    @Override
    public JsonElement serialize(Caffeineintake src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("caffeineintakeid", src.getCaffeineintakeid());
        jsonObject.addProperty("caffeinetake", src.getCaffeinetake());
        jsonObject.addProperty("date",src.getDate());
       //jsonObject.addProperty("date",context.serialize(src.getDate()));
        jsonObject.addProperty("totalcaffeinetake", src.getTotalcaffeinetake());
        final JsonElement jsonUsername = context.serialize(src.getUsername());
        jsonObject.add("username", jsonUsername);
        return jsonObject;
    }
}
