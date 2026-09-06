package com.byazt.lkb;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1657, 13})
public class tt {
    public static Map<String, Object> c(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null) {
            return map2;
        }
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}
