package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f8722a = null;
    private static String[] b = null;
    public static boolean c = false;
    public static int d = -1;
    public static long e = 600000;
    public static boolean f;
    public static List<com.ubix.ssp.ad.e.y.a.g.c> g = new ArrayList();
    public static List<com.ubix.ssp.ad.e.y.a.g.c> h = new ArrayList();
    public static long i = 600000;
    private static StringBuilder j = null;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.b();
        }
    }

    private static HashMap<String, ArrayList<String>> a(com.ubix.ssp.ad.e.y.a.g.c[] cVarArr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (cVarArr != null && cVarArr.length > 0) {
            for (com.ubix.ssp.ad.e.y.a.g.c cVar : cVarArr) {
                if (b(cVar.c)) {
                    arrayList.add(cVar.d + "");
                } else {
                    arrayList2.add(cVar.e + "");
                }
            }
        }
        map.put("positive", arrayList);
        map.put("negative", arrayList2);
        return map;
    }

    public static void a(String str) {
        try {
            if (d == 1 && com.ubix.ssp.ad.d.b.m) {
                if (!TextUtils.isEmpty(str)) {
                    j = new StringBuilder(str);
                }
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(File file, String str) {
        File parentFile;
        return file != null && (parentFile = file.getParentFile()) != null && parentFile.exists() && new File(new StringBuilder().append(parentFile.getAbsoluteFile()).append(File.separator).append(str).toString()).exists();
    }

    public static String[][] a(Context context) {
        Object objNewInstance;
        if (f) {
            long jC = v.c(context, "ubix_sp_castle", "analysis_detect_last_time");
            boolean zBooleanValue = v.a(context, "ubix_sp_castle", "analysis_detect_insert_list").booleanValue();
            if (System.currentTimeMillis() - jC >= i || !zBooleanValue) {
                v.a(context, "ubix_sp_castle", "analysis_detect_last_time", System.currentTimeMillis());
                try {
                    HashMap<String, ArrayList<String>> mapA = a((com.ubix.ssp.ad.e.y.a.g.c[]) h.toArray(new com.ubix.ssp.ad.e.y.a.g.c[0]));
                    if (mapA != null) {
                        String[] strArr = mapA.get("positive") != null ? (String[]) mapA.get("positive").toArray(new String[0]) : new String[0];
                        v.b(context, "ubix_sp_guarder", "analysis_install_tag_list", Arrays.toString(strArr));
                        return new String[][]{strArr, new String[0]};
                    }
                    objNewInstance = Array.newInstance((Class<?>) String.class, 2, 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    objNewInstance = Array.newInstance((Class<?>) String.class, 2, 0);
                }
            } else {
                try {
                    return new String[][]{c(v.d(context, "ubix_sp_guarder", "analysis_install_tag_list")), new String[0]};
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    objNewInstance = Array.newInstance((Class<?>) String.class, 2, 0);
                }
            }
        } else {
            objNewInstance = Array.newInstance((Class<?>) String.class, 2, 0);
        }
        return (String[][]) objNewInstance;
    }

    private static HashMap<String, ArrayList<String>> b(com.ubix.ssp.ad.e.y.a.g.c[] cVarArr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (cVarArr != null && cVarArr.length > 0) {
            String[] strArrC = c();
            if (strArrC == null || strArrC.length <= 0) {
                u.e("get detectList isEmpty");
            } else {
                List listAsList = Arrays.asList(strArrC);
                for (com.ubix.ssp.ad.e.y.a.g.c cVar : cVarArr) {
                    if (listAsList.contains(cVar.c)) {
                        arrayList.add(cVar.d);
                    } else if (!TextUtils.isEmpty(cVar.e)) {
                        arrayList2.add(cVar.e);
                    }
                }
            }
        }
        map.put("positive", arrayList);
        map.put("negative", arrayList2);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        try {
            HashMap<String, ArrayList<String>> mapB = com.ubix.ssp.ad.d.b.m ? b((com.ubix.ssp.ad.e.y.a.g.c[]) g.toArray(new com.ubix.ssp.ad.e.y.a.g.c[0])) : a((com.ubix.ssp.ad.e.y.a.g.c[]) g.toArray(new com.ubix.ssp.ad.e.y.a.g.c[0]));
            if (mapB != null) {
                ArrayList<String> arrayList = mapB.get("positive");
                ArrayList<String> arrayList2 = mapB.get("negative");
                if (arrayList != null) {
                    f8722a = (String[]) arrayList.toArray(new String[0]);
                    v.b(c.e(), "ubix_sp_villager", "install_result_array", Arrays.toString(f8722a));
                }
                if (arrayList2 != null) {
                    b = (String[]) arrayList2.toArray(new String[0]);
                    v.b(c.e(), "ubix_sp_villager", "not_install_result_array", Arrays.toString(b));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context) {
        if (c) {
            if (d == 1) {
                c(context);
            } else {
                d(context);
            }
        }
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && (a(k.b(c.e()).getParentFile(), str) || a(k.d(c.e()).getParentFile(), str));
    }

    private static void c(Context context) {
        String[] strArr;
        if (System.currentTimeMillis() - v.c(context, "ubix_sp_village", "install_chk_inr_last_time") < e) {
            u.b("packages checked interval less than " + e + ", skip ");
            if (f8722a == null || b == null) {
                f8722a = c(v.d(context, "ubix_sp_villager", "install_result_array"));
                b = c(v.d(context, "ubix_sp_villager", "not_install_result_array"));
                return;
            }
            return;
        }
        v.a(context, "ubix_sp_village", "install_chk_inr_last_time", System.currentTimeMillis());
        List<com.ubix.ssp.ad.e.y.a.g.c> list = g;
        if (list == null || list.isEmpty()) {
            u.e("packages list is empty");
            return;
        }
        String[] strArr2 = f8722a;
        if (strArr2 == null || (strArr = b) == null || (strArr2.length == 0 && strArr.length == 0)) {
            b();
        } else {
            c.y();
            c.d.execute(new a());
        }
    }

    private static String[] c() {
        String str;
        StringBuilder sb = j;
        if (sb == null) {
            long jC = v.c(c.f8631a, "ubix_sp_dungeon1", com.hihonor.adsdk.base.g.j.e.a.s);
            String strD = v.d(c.f8631a, "ubix_sp_mansion", "ubix_sp_vindicator");
            if (jC == 0 && TextUtils.isEmpty(strD)) {
                str = c.a(c.f8631a);
                j = new StringBuilder(str);
                v.a(c.f8631a, "ubix_sp_dungeon1", com.hihonor.adsdk.base.g.j.e.a.s, System.currentTimeMillis());
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                v.b(c.f8631a, "ubix_sp_mansion", "ubix_sp_vindicator", new String(Base64.encode(str.getBytes(StandardCharsets.UTF_8), 2)));
            } else {
                StringBuilder sb2 = new StringBuilder(strD);
                j = sb2;
                if (sb2.length() <= 0) {
                    return null;
                }
                str = new String(Base64.decode(j.toString(), 2));
            }
        } else {
            if (sb.length() <= 0) {
                return null;
            }
            str = new String(Base64.decode(j.toString(), 2));
        }
        return str.split(",");
    }

    private static String[] c(String str) {
        String[] strArr;
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        JSONArray jSONArray = new JSONArray(str);
        if (jSONArray.length() > 0) {
            strArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    strArr[i2] = jSONArray.get(i2) + "";
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } else {
            strArr = null;
        }
        return strArr == null ? new String[0] : strArr;
    }

    private static void d(Context context) {
        if (System.currentTimeMillis() - v.c(context, "ubix_sp_village", "install_chk_inr_last_time") < e) {
            u.b("scheme checked interval less than " + e + ", skip ");
            if (f8722a == null || b == null) {
                f8722a = c(v.d(context, "ubix_sp_villager", "install_result_array"));
                b = c(v.d(context, "ubix_sp_villager", "not_install_result_array"));
                return;
            }
            return;
        }
        v.a(context, "ubix_sp_village", "install_chk_inr_last_time", System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < g.size(); i2++) {
            String str = g.get(i2).c;
            if (!TextUtils.isEmpty(str.trim()) && str.trim().contains("://") && c.a(context, c.c(str))) {
                u.b("initConfig", "默认扫包已安装: " + str);
                if (!TextUtils.isEmpty(g.get(i2).d)) {
                    arrayList.add(g.get(i2).d);
                }
            } else {
                u.b("initConfig", "默认扫包未安装: " + str);
                if (!TextUtils.isEmpty(g.get(i2).e)) {
                    arrayList2.add(g.get(i2).e);
                }
            }
        }
        f8722a = (String[]) arrayList.toArray(new String[0]);
        b = (String[]) arrayList2.toArray(new String[0]);
        v.b(context, "ubix_sp_villager", "install_result_array", Arrays.toString(f8722a));
        v.b(context, "ubix_sp_villager", "not_install_result_array", Arrays.toString(b));
    }

    public static String[] d() {
        String[] strArr = f8722a;
        return strArr != null ? strArr : new String[0];
    }

    public static String[] e() {
        String[] strArr = b;
        return strArr != null ? strArr : new String[0];
    }
}
