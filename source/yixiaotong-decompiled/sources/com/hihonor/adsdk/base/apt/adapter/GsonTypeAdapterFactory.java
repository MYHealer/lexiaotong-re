package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.hihonor.adsdk.base.bean.Address;
import com.hihonor.adsdk.base.net.request.AdUnit;
import com.hihonor.adsdk.base.net.request.BaseRequest;
import com.hihonor.adsdk.base.net.request.DeviceData;
import com.hihonor.adsdk.base.net.request.MediaData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class GsonTypeAdapterFactory implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (rawType == Address.class) {
            return new b(gson);
        }
        if (rawType == AdUnit.class) {
            return new a(gson);
        }
        if (rawType == MediaData.class) {
            return new e(gson);
        }
        if (rawType == DeviceData.class) {
            return new d(gson);
        }
        if (rawType == BaseRequest.class) {
            return new c(gson);
        }
        return null;
    }
}
