package com.hihonor.hianalytics.hnha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f3639a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;

    public static void a(Map<String, List<g1>> map, g1 g1Var, String str) {
        List<g1> arrayList = map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(g1Var);
        map.put(str, arrayList);
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f3639a;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }
}
