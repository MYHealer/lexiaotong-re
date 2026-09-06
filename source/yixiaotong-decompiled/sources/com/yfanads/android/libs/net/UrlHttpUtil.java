package com.yfanads.android.libs.net;

import com.yfanads.android.libs.utils.Util;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class UrlHttpUtil {
    public static final String FILE_TYPE_AUDIO = "audio/*";
    public static final String FILE_TYPE_FILE = "file/*";
    public static final String FILE_TYPE_IMAGE = "image/*";
    public static final String FILE_TYPE_VIDEO = "video/*";
    public static boolean IS_AES = true;
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    private UrlHttpUtil() {
    }

    public static void get(String str, NetCallBack<?> netCallBack) {
        get(str, null, null, netCallBack);
    }

    public static void get(String str, Map<String, String> map, NetCallBack<?> netCallBack) {
        get(str, map, null, netCallBack);
    }

    public static void get(String str, Map<String, String> map, Map<String, String> map2, NetCallBack<?> netCallBack) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Map<String, String> map3 = map2;
        map3.put("Connection", "close");
        new RequestTask("GET", str, map, map3, netCallBack);
    }

    public static void isNetAvailability(String str, NetCallBack<?> netCallBack) {
        HashMap map = new HashMap();
        map.put("Connection", "close");
        new RequestTask().isNetAvailability(str, map, netCallBack);
    }

    public static void postJson(String str, String str2, Map<String, String> map, NetCallBack<?> netCallBack) {
        new RequestTask(str, str2, map, false, netCallBack);
    }

    public static void postJsonByTry(String str, String str2, Map<String, String> map, NetCallBack<?> netCallBack) {
        new RequestTask(str, str2, map, true, netCallBack);
    }

    public static void uploadFile(String str, File file, String str2, String str3, String str4, NetCallBack<?> netCallBack) {
        uploadFile(str, file, str3, str2, str4, null, null, netCallBack);
    }

    public static void uploadFile(String str, File file, String str2, String str3, String str4, Map<String, String> map, Map<String, String> map2, NetCallBack<?> netCallBack) {
        new RequestTask(str, file, null, null, str2, str3, str4, map, map2, netCallBack);
    }

    public static void uploadFile(String str, File file, String str2, String str3, Map<String, String> map, NetCallBack<?> netCallBack) {
        uploadFile(str, file, str2, null, str3, map, null, netCallBack);
    }

    public static void uploadJson(String str, boolean z, NetCallBack<?> netCallBack) {
        HashMap map = new HashMap();
        map.put("Connection", "close");
        if (z) {
            str = Util.encryptAES7(str, UrlConst.getKey());
        }
        postJson(UrlConst.getUpload(z), str, map, netCallBack);
    }

    public static void uploadJsonByTry(String str, boolean z, NetCallBack<?> netCallBack) {
        HashMap map = new HashMap();
        map.put("Connection", "close");
        if (z) {
            str = Util.encryptAES7(str, UrlConst.getKey());
        }
        postJsonByTry(UrlConst.getUpload(z), str, map, netCallBack);
    }

    public static void uploadListFile(String str, List<File> list, String str2, String str3, NetCallBack<?> netCallBack) {
        uploadListFile(str, list, str2, str3, null, netCallBack);
    }

    public static void uploadListFile(String str, List<File> list, String str2, String str3, Map<String, String> map, NetCallBack<?> netCallBack) {
        uploadListFile(str, list, str2, str3, map, null, netCallBack);
    }

    public static void uploadListFile(String str, List<File> list, String str2, String str3, Map<String, String> map, Map<String, String> map2, NetCallBack<?> netCallBack) {
        new RequestTask(str, null, list, null, str2, null, str3, map, map2, netCallBack);
    }

    public static void uploadMapFile(String str, Map<String, File> map, String str2, NetCallBack<?> netCallBack) {
        uploadMapFile(str, map, str2, null, netCallBack);
    }

    public static void uploadMapFile(String str, Map<String, File> map, String str2, Map<String, String> map2, NetCallBack<?> netCallBack) {
        uploadMapFile(str, map, str2, map2, null, netCallBack);
    }

    public static void uploadMapFile(String str, Map<String, File> map, String str2, Map<String, String> map2, Map<String, String> map3, NetCallBack<?> netCallBack) {
        new RequestTask(str, null, null, map, null, str2, null, map2, map3, netCallBack);
    }
}
