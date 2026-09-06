package com.byazt.ete;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 72})
public class da {
    public String gr;
    public String my;
    public String rl;
    public View u;
    public View yp;
    public boolean z;
    public int zm;
    public float c = -1.0f;
    public float tt = -1.0f;
    public float ve = -1.0f;
    public float uj = -1.0f;
    public long n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2171a = -1;
    public int sp = -1;
    public int x = -1;
    public int i = -1024;
    public boolean da = true;
    public int sl = 0;
    public int t = 0;
    public byte m = 0;
    public byte nu = -1;
    public boolean rh = false;
    public int gt = -1;
    public SparseArray<com.byazt.hkv.uj.c> qy = new SparseArray<>();
    public List<Integer> gu = new ArrayList();
    public boolean yv = false;

    public int a() {
        return this.x;
    }

    public void a(int i) {
        this.t = i;
    }

    public void c(byte b) {
        this.m = b;
    }

    public void c(float f) {
        this.c = f;
    }

    public void c(int i) {
        this.zm = i;
    }

    public void c(long j) {
        this.n = j;
    }

    public void c(SparseArray<com.byazt.hkv.uj.c> sparseArray) {
        this.qy = sparseArray;
    }

    public void c(String str) {
        this.my = str;
    }

    public void c(boolean z) {
        this.yv = z;
    }

    public boolean c() {
        return this.yv;
    }

    public View da() {
        return this.yp;
    }

    public String gr() {
        return this.gr;
    }

    public float gt() {
        return this.uj;
    }

    public String gu() {
        return this.rl;
    }

    public View i() {
        return this.u;
    }

    public long m() {
        return this.f2171a;
    }

    public float my() {
        return this.ve;
    }

    public int n() {
        return this.sp;
    }

    public void n(int i) {
        this.sl = i;
    }

    public float nu() {
        return this.c;
    }

    public int qy() {
        return this.gt;
    }

    public float rh() {
        return this.tt;
    }

    public String rl() {
        return this.my;
    }

    public int sl() {
        return this.sl;
    }

    public int sp() {
        return this.i;
    }

    public void sp(int i) {
        this.gt = i;
    }

    public int t() {
        return this.t;
    }

    public byte tt() {
        return this.m;
    }

    public void tt(byte b) {
        this.nu = b;
    }

    public void tt(float f) {
        this.tt = f;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public void tt(long j) {
        this.f2171a = j;
    }

    public void tt(String str) {
        this.rl = str;
    }

    public void tt(boolean z) {
        this.da = z;
    }

    public SparseArray<com.byazt.hkv.uj.c> u() {
        return this.qy;
    }

    public void uj(float f) {
        this.uj = f;
    }

    public void uj(int i) {
        this.i = i;
    }

    public void uj(boolean z) {
        this.rh = z;
    }

    public boolean uj() {
        return this.zm == 2;
    }

    public byte ve() {
        return this.nu;
    }

    public void ve(float f) {
        this.ve = f;
    }

    public void ve(int i) {
        this.x = i;
    }

    public void ve(String str) {
        this.gr = str;
    }

    public void ve(boolean z) {
        this.z = z;
    }

    public boolean x() {
        return this.da;
    }

    public List<Integer> yp() {
        return this.gu;
    }

    public long z() {
        return this.n;
    }

    public void c(View view) {
        this.u = (View) new WeakReference(view).get();
    }

    public void tt(View view) {
        this.yp = (View) new WeakReference(view).get();
    }
}
