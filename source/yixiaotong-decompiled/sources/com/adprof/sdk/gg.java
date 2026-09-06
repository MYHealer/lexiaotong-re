package com.adprof.sdk;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gg extends LruCache {
    public gg(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public int sizeOf(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        return bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : super.sizeOf((String) obj, null);
    }
}
