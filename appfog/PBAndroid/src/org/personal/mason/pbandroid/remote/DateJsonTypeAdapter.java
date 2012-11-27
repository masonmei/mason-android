package org.personal.mason.pbandroid.remote;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateJsonTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

@Override
public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
	return new JsonPrimitive(date.getTime());
}

@Override
public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
	long time = element.getAsJsonPrimitive().getAsLong();
	if (time > 0) {
		return new Date(time);
	}
	return null;
}
}