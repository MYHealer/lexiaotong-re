package com.meishu.sdk.core.cache.image;

import android.graphics.Bitmap;
import com.meishu.sdk.core.cache.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ImageDownloadTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements a {
    public final String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SoftReference<d>> f4780a = new ArrayList();
    public final Object c = new Object();

    public c(String str, d dVar) {
        this.b = str;
        a(dVar);
    }

    @Override // com.meishu.sdk.core.cache.image.a
    public c a(d dVar) {
        if (dVar == null) {
            return this;
        }
        try {
            synchronized (this.c) {
                Iterator<SoftReference<d>> it = this.f4780a.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == dVar) {
                    }
                }
                this.f4780a.add(new SoftReference<>(dVar));
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public static void a(c cVar, Bitmap bitmap, byte[] bArr) {
        synchronized (cVar.c) {
            Iterator<SoftReference<d>> it = cVar.f4780a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().a(bitmap, bArr, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            cVar.f4780a.clear();
        }
    }

    public static void a(c cVar, int i) {
        synchronized (cVar.c) {
            Iterator<SoftReference<d>> it = cVar.f4780a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().a(i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            cVar.f4780a.clear();
        }
    }
}
