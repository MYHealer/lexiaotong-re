package com.yfanads.android.libs.thirdpart.gson;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.yfanads.android.libs.thirdpart.gson.LongSerializationPolicy.1
        @Override // com.yfanads.android.libs.thirdpart.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return l == null ? JsonNull.INSTANCE : new JsonPrimitive(l);
        }
    },
    STRING { // from class: com.yfanads.android.libs.thirdpart.gson.LongSerializationPolicy.2
        @Override // com.yfanads.android.libs.thirdpart.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return l == null ? JsonNull.INSTANCE : new JsonPrimitive(l.toString());
        }
    };

    public abstract JsonElement serialize(Long l);
}
