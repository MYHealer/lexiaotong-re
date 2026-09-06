package com.ubix.ssp.ad.e.t.a;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8861a;
    LruCache<Integer, Bitmap> b;

    private a() {
        this.b = null;
        this.b = new LruCache<>((int) (Runtime.getRuntime().maxMemory() / 40));
    }

    public static a a() {
        a aVar = f8861a;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        f8861a = aVar2;
        return aVar2;
    }

    public Bitmap a(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public void a(int i, Bitmap bitmap) {
        this.b.put(Integer.valueOf(i), bitmap);
    }

    public void a(Bitmap bitmap) {
        this.b.put(Integer.valueOf(bitmap.hashCode()), bitmap);
    }
}
