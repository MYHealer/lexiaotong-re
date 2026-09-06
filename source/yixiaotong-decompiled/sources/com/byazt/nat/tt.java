package com.byazt.nat;

import android.content.Context;
import com.byazt.ete.ic;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1196, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f2491a;
    public boolean c;
    public Object i;
    public com.byazt.uz.c m;
    public int n;
    public com.byazt.pop.ve nu;
    public long rh;
    public c.InterfaceC0217c sl;
    public String sp;
    public ic t;
    public Context u;
    public com.byazt.zd.tt uj;
    public boolean ve;
    public boolean x = false;
    public int da = Integer.MIN_VALUE;
    public boolean yp = false;
    public int z = -1;
    public boolean tt = true;

    public com.byazt.pop.ve a() {
        return this.nu;
    }

    public c.InterfaceC0217c c() {
        return this.sl;
    }

    public void c(int i) {
        this.z = i;
    }

    public void c(long j) {
        this.rh = j;
    }

    public void c(Context context) {
        this.u = context;
    }

    public void c(ic icVar) {
        this.t = icVar;
    }

    public void c(c.InterfaceC0217c interfaceC0217c) {
        this.sl = interfaceC0217c;
    }

    public void c(com.byazt.pop.ve veVar) {
        this.nu = veVar;
    }

    public void c(com.byazt.uz.c cVar) {
        this.m = cVar;
    }

    public void c(com.byazt.zd.tt ttVar) {
        this.uj = ttVar;
    }

    public void c(Object obj) {
        this.i = obj;
    }

    public void c(String str) {
        this.sp = str;
    }

    public void c(Map<String, Object> map) {
        this.f2491a = map;
    }

    public void c(boolean z) {
        this.yp = z;
    }

    public boolean da() {
        return this.x;
    }

    public Context getContext() {
        return this.u;
    }

    public String i() {
        return this.sp;
    }

    public com.byazt.uz.c n() {
        return this.m;
    }

    public boolean sl() {
        return this.ve;
    }

    public int sp() {
        return this.n;
    }

    public com.byazt.zd.tt t() {
        return this.uj;
    }

    public void tt(int i) {
        this.n = i;
    }

    public void tt(boolean z) {
        this.c = z;
    }

    public boolean tt() {
        return this.yp;
    }

    public void uj(boolean z) {
        this.x = z;
    }

    public boolean uj() {
        return this.c;
    }

    public int ve() {
        return this.z;
    }

    public void ve(boolean z) {
        this.tt = z;
    }

    public Map<String, Object> x() {
        return this.f2491a;
    }
}
