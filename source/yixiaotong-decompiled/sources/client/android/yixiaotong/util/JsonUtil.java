package client.android.yixiaotong.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JsonUtil {
    public static <T> T getBean(String str, Class<T> cls) {
        if (CheckUtil.isJson(str)) {
            return (T) new Gson().fromJson(str, (Class) cls);
        }
        return null;
    }

    public static <T> List<T> getList(String str, TypeToken<List<T>> typeToken) {
        if (CheckUtil.isJsonArray(str)) {
            return (List) new Gson().fromJson(str, typeToken.getType());
        }
        return null;
    }

    public static String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static <T> Map<String, T> getGoodsMap(String str, Class<T> cls) {
        return (Map) new Gson().fromJson(str, new TypeToken<HashMap<String, T>>() { // from class: client.android.yixiaotong.util.JsonUtil.1
        }.getType());
    }
}
