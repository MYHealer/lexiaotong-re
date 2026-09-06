package com.opos.mobad.service.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, String> f7330a = new ConcurrentHashMap();
    private Map<Integer, String> b = new ConcurrentHashMap();
    private Map<Integer, String> c = new ConcurrentHashMap();

    a() {
    }

    private boolean a(Map<Integer, String> map) {
        return map != null && map.size() > 0;
    }

    public void a(int i, String str) {
        Map<Integer, String> map = this.b;
        if (map == null) {
            return;
        }
        map.put(Integer.valueOf(i), str);
    }

    public void a(Map<Integer, String> map, boolean z) {
        if (map == null || map.size() <= 0) {
            com.opos.cmn.an.f.a.a("Dynamic-Config", "refreshStrategy dynamic but null map");
            return;
        }
        this.f7330a = new ConcurrentHashMap(map);
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        if (z) {
            return;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Config", "refreshStrategy map = " + this.f7330a);
    }

    public boolean a() {
        Map<Integer, String> map = this.f7330a;
        com.opos.cmn.an.f.a.b("Dynamic-Config", "checkConfigEnable ", map);
        return a(map);
    }

    public boolean a(int i) {
        Map<Integer, String> map = this.f7330a;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public String b(int i) {
        Map<Integer, String> map = this.f7330a;
        return (!a(i) || map == null) ? "" : map.get(Integer.valueOf(i));
    }

    public Map<Integer, String> b() {
        return this.f7330a;
    }

    public void b(int i, String str) {
        Map<Integer, String> map = this.c;
        if (map == null) {
            return;
        }
        map.put(Integer.valueOf(i), str);
    }
}
