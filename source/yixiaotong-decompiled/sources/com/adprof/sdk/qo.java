package com.adprof.sdk;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedHashMap f693a = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f692a = new HashMap();

    public qo(String str, String str2) {
        this.f693a.put("URL_KEY_DEFAULT", str);
        this.f1391a = 0;
    }

    public Object a() {
        int i = this.f1391a;
        int i2 = 0;
        for (Object obj : this.f693a.keySet()) {
            if (i2 == i) {
                return this.f693a.get(obj);
            }
            i2++;
        }
        return null;
    }
}
