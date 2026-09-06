package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class o1 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3665a = SystemUtils.getContext();

    private static void a(Context context) throws IllegalAccessException, InvocationTargetException {
        String strA = com.hihonor.hianalytics.util.p.a("global_v2", "upload_url", "");
        long jA = com.hihonor.hianalytics.util.p.a("global_v2", "upload_url_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(strA) && jCurrentTimeMillis - jA <= 86400000) {
            try {
                JSONArray jSONArray = new JSONArray(strA);
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = "{url}/common/hioperbatch".replace("{url}", jSONArray.getString(i));
                }
                o3.a().a("preload_url_tag", strArr);
                x0.c().b().a(strArr);
                x0.c().b().b(false);
                return;
            } catch (JSONException unused) {
                j2.g("InitInfoV2support", "cache pre url is error,need retrieve upload url ");
            }
        }
        x0.c().b().b(true);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("events");
            if (jSONArray != null && jSONArray.length() != 0) {
                a(jSONArray);
                return;
            }
            j2.c("InitInfoV2support", "No V2CacheFile Data!");
        } catch (JSONException unused) {
            j2.g("InitInfoV2support", "parseV2CacheData() eventJsonArray.cacheData No json !");
        }
    }

    private void a(String str, String str2) {
        b(str);
        a(str2);
    }

    private void a(Map<String, ?> map) throws IllegalAccessException, InvocationTargetException {
        String strA = com.hihonor.hianalytics.util.p.a("global_v2", "request_id", "");
        boolean zY = g.y();
        if (zY) {
            map.remove(strA);
        }
        j2.c("InitInfoV2support", "handlerErrorData size=" + map.size() + ",sign=" + zY + ",key=" + strA);
    }

    private void a(Map<String, JSONArray> map, Map<String, ?> map2) {
        JSONArray jSONArray;
        for (Map.Entry<String, ?> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = key.split("#")[0];
            if (map.containsKey(str)) {
                jSONArray = map.get(str);
            } else {
                JSONArray jSONArray2 = new JSONArray();
                map.put(str, jSONArray2);
                jSONArray = jSONArray2;
            }
            if (entry.getValue() instanceof String) {
                try {
                    JSONArray jSONArray3 = new JSONArray((String) entry.getValue());
                    for (int i = 0; i < jSONArray3.length(); i++) {
                        jSONArray.put(jSONArray3.getJSONObject(i));
                    }
                } catch (JSONException unused) {
                    j2.g("InitInfoV2support", "backup data is error! spKey: " + key);
                }
            }
        }
    }

    private void a(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                    String strOptString2 = jSONObject.optString("type");
                    int iC = c(strOptString2);
                    String str = (String) s1.a(jSONObject.getString("content"), r1.c().b()).second;
                    String strOptString3 = jSONObject.optString("eventtime");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString2)) {
                        linkedList.add(new n0("_default_config_tag", iC, strOptString, 51, Long.parseLong(strOptString3), com.hihonor.hianalytics.util.r.e(), str, null, 0, null, null));
                    }
                    j2.g("InitInfoV2support", "parseV2SPData() Data anomaly! Discarding data.");
                    return;
                }
                continue;
            } catch (JSONException unused) {
                j2.g("InitInfoV2support", "parseV2SPData() eventJsonArray.getJSONObject() error !");
            }
        }
        p2.c().b(linkedList);
    }

    private void a(boolean z) {
        String str;
        String strO = g.o();
        String strD = g.d();
        if (TextUtils.isEmpty(strO)) {
            str = "app ver is first save,mode=true";
        } else if (!strO.equals(strD)) {
            j2.c("InitInfoV2support", "the appVers are different,mode=true");
            p2.c().a("", 0, 8);
            return;
        } else if (!z) {
            return;
        } else {
            str = "report backup data,mode=true";
        }
        j2.c("InitInfoV2support", str);
    }

    private void b() throws IllegalAccessException, InvocationTargetException {
        com.hihonor.hianalytics.util.p.a("stat_v2");
        v1.b(this.f3665a, "cached_v2");
    }

    private void b(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = !TextUtils.isEmpty(str) ? new JSONArray(str) : null;
        } catch (JSONException unused) {
            j2.g("InitInfoV2support", "parseV2SPData:When events turn to JSONArray,json Exception");
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            j2.g("InitInfoV2support", "No V2State Data!");
        } else {
            a(jSONArray);
        }
    }

    public static int c(String str) {
        if ("preins".equals(str)) {
            return 2;
        }
        return "maint".equals(str) ? 1 : 0;
    }

    private boolean c() throws IllegalAccessException, InvocationTargetException {
        JSONArray jSONArray;
        j2.a("InitInfoV2support", "begin handler backup data...");
        long jE = t1.d().e();
        long jC = com.hihonor.hianalytics.util.p.c(this.f3665a, "stat_v2_1");
        if (jE + jC > CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            j2.g("InitInfoV2support", "initBackEvent haOverBackupSize=" + jE + ",statFileSize=" + jC);
            t1.d().b();
            return false;
        }
        Map<String, ?> mapC = t1.d().c();
        if (mapC.size() == 0) {
            j2.g("InitInfoV2support", "initBackEvent haNoBackupSize=" + jE + ",statFileSize=" + jC);
            return false;
        }
        if (mapC.size() > 1024) {
            j2.g("InitInfoV2support", "initBackEvent haBackupTooMuchSize=" + jE + ",statFileSize=" + jC);
            t1.d().b();
            return false;
        }
        t1.d().b();
        a(mapC);
        HashMap map = new HashMap();
        a(map, mapC);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Map.Entry<String, JSONArray> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                jSONArray = new JSONArray(com.hihonor.hianalytics.util.p.a("stat_v2_1", key, ""));
            } catch (JSONException unused) {
                j2.g("InitInfoV2support", "handler unusualData: stat sp data is error,spKey: " + key);
                jSONArray = new JSONArray();
                z2 = true;
            }
            for (int i = 0; i < entry.getValue().length(); i++) {
                try {
                    jSONArray.put(entry.getValue().getJSONObject(i));
                } catch (JSONException unused2) {
                    j2.c("InitInfoV2support", "handler backup data,json exception");
                    z2 = true;
                }
            }
            try {
                com.hihonor.hianalytics.util.p.b("stat_v2_1", key, jSONArray.toString());
                z = true;
            } catch (OutOfMemoryError unused3) {
                j2.g("InitInfoV2support", "handler backup data to stat sp error : OOM");
                z = false;
                z3 = true;
            }
        }
        j2.c("InitInfoV2support", "initBackEvent haNormalBackupSize=" + jE + ",statFileSize=" + jC + ",flag=" + z + ",hasJsonException=" + z2 + ",hasOomException=" + z3);
        return z;
    }

    private void d() throws IllegalAccessException, InvocationTargetException {
        if (!com.hihonor.hianalytics.util.p.b(this.f3665a, "stat_v2").exists()) {
            j2.c("InitInfoV2support", "No V2 data supporting!");
            return;
        }
        String strA = com.hihonor.hianalytics.util.p.a("stat_v2", "events", "");
        String str = (String) s1.a(v1.d(this.f3665a, "cached_v2"), r1.c().b()).second;
        b();
        if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(str)) {
            j2.g("InitInfoV2support", " No cached V2 data found.");
        } else {
            a(strA, str);
        }
    }

    private void e() throws IllegalAccessException, InvocationTargetException {
        a(this.f3665a);
    }

    protected boolean a() {
        boolean zX = g.x();
        EncryptUtil.setBouncycastleFlag(zX);
        String strD = g.d();
        if (!SystemUtils.a()) {
            j2.g("InitInfoV2support", "checkInitGlobalParam appVer=" + strD + ",isOpenAegisRandom=" + zX + ",mode=true");
            return false;
        }
        String strO = g.o();
        com.hihonor.hianalytics.util.p.b("global_v2", "app_ver", g.d());
        j2.c("InitInfoV2support", "checkInitGlobalParam appVer=" + strD + ",oldVer=" + strO + ",isOpenAegisRandom=" + zX + ",mode=true");
        return true;
    }

    protected void f() {
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, InvocationTargetException {
        f();
        if (a()) {
            e();
            a(c());
            if (com.hihonor.hianalytics.util.p.a("global_v2", "v2cacheHandlerFlag", false)) {
                j2.c("InitInfoV2support", "cached data by HASDKV2 has already handled.");
            } else {
                com.hihonor.hianalytics.util.p.b("global_v2", "v2cacheHandlerFlag", true);
                d();
            }
        }
    }
}
