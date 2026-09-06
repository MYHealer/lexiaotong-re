package com.huawei.hms.mlkit.bcr.impl;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BcrDetectResult.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f4146a;
    private Bitmap b;
    private Bitmap c;

    public Bitmap a() {
        return this.c;
    }

    public void a(Bitmap bitmap) {
        this.c = bitmap;
    }

    public void a(String[] strArr) {
        this.f4146a = strArr == null ? null : (String[]) strArr.clone();
    }

    public Bitmap b() {
        return this.b;
    }

    public void b(Bitmap bitmap) {
        this.b = bitmap;
    }

    public String[] c() {
        String[] strArr = this.f4146a;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }
}
