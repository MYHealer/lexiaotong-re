package com.byazt.im;

import com.byazt.ete.ic;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 71})
public class x extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.hm.tt f2344a;
    public long da;
    public long i;
    public com.byazt.nc.tt m;
    public String nu;
    public long rh;
    public long sl;
    public Map<String, String> t;
    public String u;
    public com.byazt.uph.tt uj;
    public boolean yp;
    public boolean z;
    public boolean n = false;
    public boolean sp = false;
    public boolean x = false;
    public AtomicBoolean my = new AtomicBoolean(false);

    public boolean a() {
        return this.sp;
    }

    public void c(com.byazt.hm.tt ttVar) {
        this.f2344a = ttVar;
    }

    public void c(com.byazt.nc.tt ttVar) {
        this.m = ttVar;
    }

    public void c(String str) {
        this.u = str;
    }

    public void c(Map<String, String> map) {
        this.t = map;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public boolean da() {
        return this.x;
    }

    public Map<String, String> i() {
        return this.t;
    }

    public void n(long j) {
        this.rh = j;
    }

    public boolean n() {
        return this.n;
    }

    public boolean sl() {
        return this.yp;
    }

    public long sp() {
        return this.i;
    }

    public com.byazt.nc.tt t() {
        return this.m;
    }

    public void tt(long j) {
        this.i = j;
    }

    public void tt(String str) {
        this.nu = str;
    }

    public void tt(boolean z) {
        this.sp = z;
    }

    public String u() {
        return this.nu;
    }

    public com.byazt.uph.tt uj() {
        return this.uj;
    }

    public void uj(long j) {
        this.sl = j;
    }

    public void uj(boolean z) {
        this.z = z;
    }

    public void ve(long j) {
        this.da = j;
    }

    public void ve(boolean z) {
        this.x = z;
    }

    public long x() {
        return this.sl;
    }

    public long yp() {
        return this.rh;
    }

    @Override // com.byazt.im.c
    public int c() {
        return this.c;
    }

    @Override // com.byazt.im.c
    public void c(int i) {
        this.c = i;
    }

    @Override // com.byazt.im.c
    public ic tt() {
        return this.tt;
    }

    @Override // com.byazt.im.c
    public void c(ic icVar) {
        this.tt = icVar;
    }

    public x(ic icVar, boolean z) {
        this.tt = icVar;
        this.yp = z;
    }

    public x(com.byazt.uph.tt ttVar, ic icVar, boolean z) {
        this.uj = ttVar;
        this.tt = icVar;
        this.yp = z;
    }

    public boolean z() {
        return this.my.get();
    }

    public void n(boolean z) {
        this.my.set(z);
    }
}
