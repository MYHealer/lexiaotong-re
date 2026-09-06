package com.byazt.zlb;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.google.android.exoplayer2.ExoPlayer;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.ba;
import com.kuaishou.weapon.p0.bg;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 568, 54})
public class ve {
    public static String c = "SettingRitRepertoryImpl";
    public static boolean tt;
    public static long uj;
    public static Map<Integer, String> ve;

    public static boolean c() {
        return tt;
    }

    public static void tt() {
        tt = true;
    }

    public static String ve() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static String c(int i, String str) {
        if (ve == null || System.currentTimeMillis() - uj > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            uj = System.currentTimeMillis();
            ve = uj();
        }
        Map<Integer, String> map = ve;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strVe = com.byazt.nr.c.ve(map.get(Integer.valueOf(i)));
            return "null".equals(strVe) ? "" : strVe;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058 A[PHI: r3
  0x0058: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:21:0x0056, B:15:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    private static Map<Integer, String> uj() {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_global_info", new String[]{"_id", oOOOoo00.OooOo0o}, null, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                        Integer numValueOf = Integer.valueOf(i);
                        if (string == null) {
                            string = "";
                        }
                        map.put(numValueOf, string);
                    } catch (Exception unused) {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused2) {
                if (0 != 0) {
                    cursorQuery.close();
                }
            }
            return map;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static Map<String, String> c(String str) throws JSONException {
        JSONObject jSONObjectTt = tt(str);
        HashMap map = null;
        if (jSONObjectTt == null) {
            return null;
        }
        String strOptString = jSONObjectTt.optString(o0OO000o.o00O0O0O);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("headers");
                if (jSONObjectOptJSONObject == null) {
                    return null;
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObjectOptJSONObject.optString(next));
                }
                return map2;
            } catch (Exception unused) {
                map = map2;
                return map;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0051 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject tt(String str) throws JSONException {
        int columnIndex;
        if (!c()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("config")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            try {
                m.tt(c, th);
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return null;
    }

    public static void c(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectTt = tt(str);
        if (jSONObjectTt == null) {
            return;
        }
        String strOptString = jSONObjectTt.optString("aid");
        String strOptString2 = jSONObjectTt.optString(ba.D);
        String strOptString3 = jSONObjectTt.optString(o0OO000o.o00O0O0O);
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put("ad_id", strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (TextUtils.isEmpty(strOptString3)) {
            return;
        }
        jSONObject.put(o0OO000o.o00O0O0O, strOptString3);
    }

    public static void tt(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectVe;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (jSONObjectVe = ve(str)) == null) {
            return;
        }
        if (jSONObjectVe.has("preview_ads_save_time") && System.currentTimeMillis() - jSONObjectVe.optLong("preview_ads_save_time") > bg.s) {
            uj(str);
            return;
        }
        if (jSONObjectVe.has("image_mode")) {
            jSONObject.put("image_mode", jSONObjectVe.optString("image_mode"));
        }
        if (jSONObjectVe.has("preview_extra")) {
            jSONObject.put("preview_extra", jSONObjectVe.optString("preview_extra"));
        }
        if (jSONObjectVe.has("preview_ads")) {
            jSONObject.put("preview_ads", jSONObjectVe.optJSONObject("preview_ads"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0051 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject ve(String str) throws JSONException {
        int columnIndex;
        if (!c()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("preview_ads")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            try {
                m.tt(c, th);
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return null;
    }

    public static void uj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("preview_ads", "");
            com.byazt.pe.c.update(gt.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, JSONObject jSONObject) {
        if (!c() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectC = com.byazt.nr.c.c(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(oOOOoo00.OooOo0o, jSONObjectC.toString());
        if (z) {
            com.byazt.pe.c.update(gt.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.byazt.pe.c.insert(gt.getContext(), "setting_rit", contentValues);
        }
    }

    public static void c(com.byazt.dj.tt ttVar) {
        if (c()) {
            String strUj = ttVar.uj();
            if (n(strUj)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", ttVar.a());
                    jSONObject.put("img_height", ttVar.sp());
                    jSONObject.put("express_width", ttVar.x());
                    jSONObject.put("express_height", ttVar.i());
                    jSONObject.put(a.O, ttVar.t());
                } catch (JSONException e) {
                    m.c(e);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strUj);
                contentValues.put("slot", com.byazt.nr.c.tt(jSONObject.toString()));
                com.byazt.pe.c.update(gt.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strUj});
            }
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.pe.c.delete(gt.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    private static boolean n(String str) {
        boolean z;
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public static void tt(int i, String str) {
        if (c()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            try {
                com.byazt.pe.c.c(gt.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + com.byazt.nr.c.tt(str) + "')", "setting_base_info");
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public static void ve(int i, String str) {
        if (c()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            String strTt = com.byazt.nr.c.tt(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i));
            contentValues.put(oOOOoo00.OooOo0o, strTt);
            if (z) {
                com.byazt.pe.c.update(gt.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.byazt.pe.c.insert(gt.getContext(), "setting_global_info", contentValues);
            }
        }
    }
}
