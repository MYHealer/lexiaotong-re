package com.byazt.dc;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2063, 13})
public class tt {
    public static String c = "AdapterPl";
    public static final Set<String> tt = new CopyOnWriteArraySet();
    public static volatile Map<String, Map<String, Object>> ve = new ConcurrentHashMap(1);

    public static Map<String, Map<String, Object>> c() {
        return ve;
    }

    public static boolean c(String str) {
        Set<String> set = tt;
        if (set.contains(str)) {
            return true;
        }
        set.add(str);
        return false;
    }
}
