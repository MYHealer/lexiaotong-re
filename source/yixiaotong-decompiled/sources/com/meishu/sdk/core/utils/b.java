package com.meishu.sdk.core.utils;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: BooleanWatcher.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SoftReference<a<Boolean>> f4882a;
    public volatile boolean b;

    /* JADX INFO: compiled from: BooleanWatcher.java */
    public interface a<T> {
        void a(T t, T t2);
    }

    public void a(boolean z) {
        boolean z2 = this.b;
        this.b = z;
        try {
            SoftReference<a<Boolean>> softReference = this.f4882a;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            this.f4882a.get().a(Boolean.valueOf(z2), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(a<Boolean> aVar) {
        if (aVar == null) {
            this.f4882a = null;
        } else {
            this.f4882a = new SoftReference<>(aVar);
        }
        return this.b;
    }
}
