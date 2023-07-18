package com.iw.jarosandroid.gson;

import com.google.gson.*;

import java.lang.reflect.Type;

public final class Serialize<T> implements JsonSerializer<T>, JsonDeserializer<T> {
    private final Class<T> implementation;

    public Serialize(Class<T> implementation) {
        this.implementation = implementation;
    }

    @Override
    public JsonElement serialize(final T value, final Type type, final JsonSerializationContext context) {
        final Type targetType = value != null ? value.getClass() : type;
        return context.serialize(value, targetType);
    }

    @Override
    public T deserialize(final JsonElement jsonElement, final Type typeOfT, final JsonDeserializationContext context) {
        return context.deserialize(jsonElement, implementation);
    }
}