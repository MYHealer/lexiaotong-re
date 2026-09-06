package com.miui.zeus.mimo.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GsonHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Gson f5639a;

    public static class IntegerDeserializer implements JsonDeserializer<Integer> {
        public Integer a(JsonElement jsonElement) {
            int i = 0;
            try {
                return jsonElement.isJsonPrimitive() ? Integer.valueOf(jsonElement.getAsInt()) : i;
            } catch (Exception unused) {
                return i;
            }
        }

        @Override // com.google.gson.JsonDeserializer
        public /* bridge */ /* synthetic */ Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return a(jsonElement);
        }
    }
}
