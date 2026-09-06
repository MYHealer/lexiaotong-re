package com.ubixnow.core.bean;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdInfo {
    private HashMap<String, Object> extraInfo;
    public HashMap<String, String> extraMap;

    public UMNAdInfo(HashMap<String, String> map, HashMap<String, Object> map2) {
        this.extraInfo = new HashMap<>();
        this.extraMap = new HashMap<>();
        if (map != null) {
            this.extraMap = map;
        }
        if (this.extraInfo != null) {
            this.extraInfo = map2;
        }
    }

    public Object getValue(String str) {
        return this.extraInfo.get(str);
    }
}
