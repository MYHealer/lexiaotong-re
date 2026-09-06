package com.jd.ad.sdk.jad_iv;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ExposureChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public final ConcurrentHashMap<String, jad_dq> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, WeakReference<View>> jad_bo = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_iv.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExposureChecker.java */
    public static class C0556jad_an {
        public static final jad_an jad_an = new jad_an();
    }
}
