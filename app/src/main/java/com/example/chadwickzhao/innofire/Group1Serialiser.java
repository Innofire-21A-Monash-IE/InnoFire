package com.example.chadwickzhao.innofire;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by chadwickzhao on 23/09/16.
 */
public class Group1Serialiser implements JsonSerializer<Group1> {
    @Override
    public JsonElement serialize(Group1 src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("group_user_id", src.getGroupUserId());
        jsonObject.addProperty("group_id", src.getGroupId());
        jsonObject.addProperty("groupname", src.getGroupname());
        jsonObject.addProperty("groupcapacity", src.getGroupcapacity());

        final JsonElement jsonUsername = context.serialize(src.getUsername());
        jsonObject.add("username", jsonUsername);
        return jsonObject;
    }
}
