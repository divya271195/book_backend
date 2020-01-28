package com.jwt.jwtauth.model;

import java.lang.reflect.Type;
import java.util.Objects;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonStringSerializer implements JsonSerializer<String>, JsonDeserializer<String> {

	@Override
	public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
		if (Objects.isNull(src) && src.length() == 0) {
			return null;
		}
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(src).getAsJsonObject();
		return obj;
	}

	@Override
	public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		if (Objects.isNull(json)) {
			return null;
		}
		return json.toString();
	}

}
