package com.opos.mobad.f.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6887a;
    public final String b;
    public final int c;
    public int d = 0;
    public int e;
    public d f;

    public b(String str, String str2, int i, d dVar) {
        this.f6887a = str;
        this.b = str2;
        this.c = i;
        this.f = dVar;
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b) || !str.equals(this.b)) ? false : true;
    }
}
