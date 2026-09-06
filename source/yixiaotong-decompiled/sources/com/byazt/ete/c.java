package com.byazt.ete;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2167a;
    public String c;
    public JSONObject n;
    public int tt;
    public List<ic> uj = new ArrayList();
    public String ve;

    public int c() {
        return this.tt;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void c(long j) {
        this.f2167a = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(List<ic> list) {
        this.uj = list;
    }

    public void c(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public List<ic> tt() {
        return this.uj;
    }

    public void tt(String str) {
        this.ve = str;
    }

    public JSONObject ve() {
        return this.n;
    }

    public void c(ic icVar) {
        this.uj.add(icVar);
    }
}
