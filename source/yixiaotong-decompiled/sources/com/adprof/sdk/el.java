package com.adprof.sdk;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static dl f262a;

    public static dl a() {
        synchronized (el.class) {
            dl dlVar = f262a;
            if (dlVar == null) {
                return new dl();
            }
            f262a = dlVar.f224a;
            dlVar.f224a = null;
            f1154a -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return dlVar;
        }
    }

    public static void a(dl dlVar) {
        if (dlVar.f224a != null || dlVar.f227b != null) {
            throw new IllegalArgumentException();
        }
        if (dlVar.f225a) {
            return;
        }
        synchronized (el.class) {
            long j = f1154a + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            f1154a = j;
            dlVar.f224a = f262a;
            dlVar.b = 0;
            dlVar.f1133a = 0;
            f262a = dlVar;
        }
    }
}
