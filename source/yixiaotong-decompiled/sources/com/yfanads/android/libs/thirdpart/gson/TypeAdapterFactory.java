package com.yfanads.android.libs.thirdpart.gson;

import com.yfanads.android.libs.thirdpart.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
