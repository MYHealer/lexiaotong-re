package com.byazt.uy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1180, 13})
public class tt {
    public Map<ve, List<c>> c = new HashMap();
    public Map<String, String> tt = new HashMap();
    public final List<Object> ve = new CopyOnWriteArrayList();
    public final List<Object> uj = new CopyOnWriteArrayList();
    public final List<Object> n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f2804a = new CopyOnWriteArrayList();
    public a sp = null;

    public Map<String, String> c() {
        return this.tt;
    }

    public void c(a aVar) {
        this.sp = aVar;
    }

    public List<Object> tt() {
        return this.uj;
    }

    public a uj() {
        return this.sp;
    }

    public List<Object> ve() {
        return this.f2804a;
    }

    public List<c> c(ve veVar) {
        return this.c.get(veVar);
    }

    public void c(Map<? extends String, ? extends String> map) {
        this.tt.putAll(map);
    }
}
