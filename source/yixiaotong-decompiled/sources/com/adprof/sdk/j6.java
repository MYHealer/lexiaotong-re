package com.adprof.sdk;

import android.view.View;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f391a;
    public float b;
    public float c;
    public float d;

    public j6(View view, float f, float f2, Random random) {
        this.f391a = view;
        this.f1244a = f;
        this.b = f2;
        this.c = (random.nextFloat() - 0.5f) * 2.4f;
        this.d = (random.nextFloat() - 0.5f) * 2.4f;
    }
}
