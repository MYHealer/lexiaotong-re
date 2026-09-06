package com.hihonor.adsdk.base.j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.g.j.d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {
    private static final String hnadsa = "GsonUtil";
    private static Gson hnadsb;

    static {
        TypeAdapterFactory typeAdapterFactoryHnadsb = hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getGeneratedImplementation ClassNotFoundExceptiontypeAdapterFactory======" + typeAdapterFactoryHnadsb, new Object[0]);
        if (typeAdapterFactoryHnadsb == null) {
            hnadsb = new Gson();
        } else {
            hnadsb = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactoryHnadsb).create();
        }
    }

    public static Gson hnadsa() {
        return hnadsb;
    }

    private static TypeAdapterFactory hnadsb() {
        try {
            return (TypeAdapterFactory) Class.forName("com.hihonor.adsdk.base.apt.adapter.GsonTypeAdapterFactory").newInstance();
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getGeneratedImplementation ClassNotFoundException", new Object[0]);
            return null;
        } catch (IllegalAccessException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getGeneratedImplementation IllegalAccessException", new Object[0]);
            return null;
        } catch (InstantiationException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getGeneratedImplementation InstantiationException", new Object[0]);
            return null;
        }
    }

    public static <T> List<T> hnadsc(String str, Class<T> cls) {
        try {
            return (List) hnadsb.fromJson(str, TypeToken.getParameterized(List.class, cls).getType());
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "fromJson, gson fromJson error, Exception: " + e.getMessage(), new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_UTIL_GSON_ERR, "AD use gson has Exception.in fromJson msg : " + e.getMessage()).hnadse();
            return null;
        }
    }

    public static <T> List<Map<String, T>> hnadsd(String str, Class<T> cls) {
        return (List) hnadsb.fromJson(str, TypeToken.getParameterized(List.class, TypeToken.getParameterized(Map.class, String.class, cls).getType()).getType());
    }

    public static <T> Map<String, T> hnadse(String str, Class<T> cls) {
        return (Map) hnadsb.fromJson(str, TypeToken.getParameterized(Map.class, String.class, cls).getType());
    }

    public static void hnadsa(TypeAdapterFactory typeAdapterFactory) {
        if (Objects.isNull(hnadsb)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "addFactory gson is null", new Object[0]);
        } else if (Objects.isNull(typeAdapterFactory)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "addFactory typeAdapterFactory is null", new Object[0]);
        } else {
            hnadsb = hnadsb.newBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();
        }
    }

    public static String hnadsa(Object obj) {
        try {
            return hnadsb.toJson(obj);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "toJson, gson toJson error, Exception: " + e.getMessage(), new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_UTIL_GSON_ERR, "AD use gson has Exception.in toJson msg : " + e.getMessage()).hnadse();
            return "{}";
        }
    }

    public static <T> List<T> hnadsb(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = JsonParser.parseString(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(hnadsb.fromJson(it.next(), (Class) cls));
        }
        return arrayList;
    }

    public static <T> T hnadsa(String str, Class<T> cls) {
        try {
            return (T) hnadsb.fromJson(str, (Class) cls);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "fromJson, gson fromJson error, Exception: " + e.getMessage(), new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_UTIL_GSON_ERR, "AD use gson has Exception.in fromJson msg : " + e.getMessage()).hnadse();
            return null;
        }
    }
}
