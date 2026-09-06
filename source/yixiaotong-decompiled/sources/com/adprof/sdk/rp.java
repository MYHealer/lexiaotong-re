package com.adprof.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class rp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wp f710a;

    public rp(wp wpVar, Context context) {
        this.f710a = wpVar;
        this.f1408a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f710a.a()) {
            Log.d("InfoProviderUtil", "within key update interval.");
            return;
        }
        wp wpVar = this.f710a;
        synchronized (wpVar.f816c) {
            SharedPreferences sharedPreferences = wpVar.f813a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
            }
        }
        this.f710a.a(tp.m718a(this.f1408a));
    }
}
