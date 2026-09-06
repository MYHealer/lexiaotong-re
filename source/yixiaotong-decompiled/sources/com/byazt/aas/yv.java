package com.byazt.aas;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.ai;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, ai.y})
public final class yv {
    public static AtomicBoolean tt = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> c = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, 131, 2028})
    private static final class c {
        public static final com.byazt.iy.n c = com.byazt.ut.a.getKVStore("tt_scheme_check_list_cache");
    }

    private yv() {
    }

    public static void c(String str, Boolean bool) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            string = "";
        } else {
            try {
                string = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(oOOOoo00.OooOo0o, string);
        jSONObject.put(CrashHianalyticsData.TIME, System.currentTimeMillis());
        c.c.put(str, jSONObject.toString());
        tt.set(true);
    }

    public static Map<String, Boolean> c(long j) {
        try {
            if (tt.get()) {
                synchronized (yv.class) {
                    if (tt.get()) {
                        Map<String, Boolean> mapTt = tt(j);
                        tt.set(false);
                        return mapTt;
                    }
                }
            }
            return new HashMap(c);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public static Map<String, Boolean> tt(long j) {
        HashMap map = new HashMap();
        try {
            Map all = c.c.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong(CrashHianalyticsData.TIME);
                    String str = (String) entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        c(str);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get(oOOOoo00.OooOo0o).toString())));
                    }
                }
                if (c == null) {
                    c = new ConcurrentHashMap();
                } else {
                    c.clear();
                }
                c.putAll(map);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static Boolean c(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectTt = tt(str);
            if (jSONObjectTt == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectTt.getLong(CrashHianalyticsData.TIME) <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectTt.getString(oOOOoo00.OooOo0o)));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void c(String str) {
        c.c.remove(str);
    }

    private static JSONObject tt(String str) {
        String str2 = c.c.get(str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme()).append("://").append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(com.huawei.openalliance.ad.constant.x.bQ).append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
