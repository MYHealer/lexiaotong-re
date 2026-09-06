package client.android.yixiaotong.util;

import client.android.yixiaotong.exception.ClientException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GsonUtils {
    private Gson mGson;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.GsonUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public Gson getGson() {
        return this.mGson;
    }

    /* synthetic */ GsonUtils(AnonymousClass1 anonymousClass1) {
        this();
    }

    private GsonUtils() {
        this.mGson = new GsonBuilder().serializeNulls().create();
    }

    private static class SingletonHolder {
        public static final GsonUtils INSTANCE = new GsonUtils(null);

        private SingletonHolder() {
        }
    }

    public static GsonUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T parseIfNull(Type type, String str) {
        try {
            return (T) this.mGson.fromJson(str, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Type type, String str) throws ClientException {
        try {
            return (T) this.mGson.fromJson(str, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> T parseIfNull(Type type, Reader reader) {
        try {
            return (T) this.mGson.fromJson(reader, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Type type, Reader reader) throws ClientException {
        try {
            return (T) this.mGson.fromJson(reader, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> T parseIfNull(Class<T> cls, String str) {
        try {
            return (T) this.mGson.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Class<T> cls, String str) throws ClientException {
        try {
            return (T) this.mGson.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> String parseIfNull(T t) {
        try {
            return this.mGson.toJson(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> String parse(T t) throws ClientException {
        try {
            return this.mGson.toJson(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> List<T> parseString2List(String str, Class cls) {
        return (List) new Gson().fromJson(str, new ParameterizedTypeImpl(cls));
    }

    public <T> List<T> objToList(Object obj, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(cls.cast(it.next()));
        }
        return arrayList;
    }

    private class ParameterizedTypeImpl implements ParameterizedType {
        Class clazz;

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        public ParameterizedTypeImpl(Class cls) {
            this.clazz = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.clazz};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return List.class;
        }
    }
}
