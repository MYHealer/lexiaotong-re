package com.ubix.ssp.ad.e.b0;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8754a;
    public LinkedHashMap b;
    public String c;
    public HashMap<String, String> d;
    public boolean e;

    public a(Object obj) {
        this.b = new LinkedHashMap();
        this.c = "";
        this.d = new HashMap<>();
        this.e = false;
        this.b.put("URL_KEY_DEFAULT", obj);
        this.f8754a = 0;
    }

    public a(String str) {
        this.b = new LinkedHashMap();
        this.c = "";
        this.d = new HashMap<>();
        this.e = false;
        this.b.put("URL_KEY_DEFAULT", str);
        this.f8754a = 0;
    }

    public a(String str, String str2) {
        this.b = new LinkedHashMap();
        this.c = "";
        this.d = new HashMap<>();
        this.e = false;
        this.b.put("URL_KEY_DEFAULT", str);
        this.c = str2;
        this.f8754a = 0;
    }

    public a(LinkedHashMap linkedHashMap) {
        this.b = new LinkedHashMap();
        this.c = "";
        this.d = new HashMap<>();
        this.e = false;
        this.b.clear();
        this.b.putAll(linkedHashMap);
        this.f8754a = 0;
    }

    public a(LinkedHashMap linkedHashMap, String str) {
        this.b = new LinkedHashMap();
        this.c = "";
        this.d = new HashMap<>();
        this.e = false;
        this.b.clear();
        this.b.putAll(linkedHashMap);
        this.c = str;
        this.f8754a = 0;
    }

    public Object a() {
        return a(this.f8754a);
    }

    public Object a(int i) {
        int i2 = 0;
        for (Object obj : this.b.keySet()) {
            if (i2 == i) {
                return this.b.get(obj);
            }
            i2++;
        }
        return null;
    }
}
