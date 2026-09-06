package com.byazt.zg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum c implements n {
    TRUE,
    FALSE,
    NULL;

    public static final Map<String, c> uj = new HashMap(128);

    static {
        for (c cVar : values()) {
            uj.put(cVar.name().toLowerCase(), cVar);
        }
    }

    public static c c(String str) {
        return uj.get(str.toLowerCase());
    }
}
