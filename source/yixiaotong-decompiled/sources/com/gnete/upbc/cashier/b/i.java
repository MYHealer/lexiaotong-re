package com.gnete.upbc.cashier.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OrderInf.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3278a;
    private String b;
    private String c;
    private List<f> d = new ArrayList();

    public String a() {
        return this.f3278a;
    }

    public void a(String str) {
        this.f3278a = str;
    }

    public void a(List<f> list) {
        this.d = list;
    }

    public List<f> b() {
        return this.d;
    }

    public void b(String str) {
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
    }
}
