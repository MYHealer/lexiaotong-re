package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, String> f1594a;
    private static final String[] b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    private static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            String str2 = map.get(str);
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            if (i != 0) {
                str3 = "&";
            }
            stringBuffer.append(sb.append(str3).append(str).append("=").append(str2).toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        if (f1594a == null) {
            c(context, map);
        }
        f1594a.putAll(d.a());
        return f1594a;
    }

    public static synchronized void a() {
        f1594a = null;
    }

    public static synchronized String b(Context context, Map<String, String> map) {
        TreeMap treeMap;
        a(context, map);
        treeMap = new TreeMap();
        for (String str : b) {
            if (f1594a.containsKey(str)) {
                treeMap.put(str, f1594a.get(str));
            }
        }
        return com.alipay.security.mobile.module.a.a.b.a(a(treeMap));
    }

    private static synchronized void c(Context context, Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        f1594a = treeMap;
        treeMap.putAll(b.a(context, map));
        f1594a.putAll(d.a(context));
        f1594a.putAll(c.a(context));
        f1594a.putAll(a.a(context, map));
    }
}
