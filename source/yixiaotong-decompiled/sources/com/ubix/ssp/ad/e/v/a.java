package com.ubix.ssp.ad.e.v;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a {
    LruCache<String, Bitmap> a();

    void a(String str, int i, e.b bVar);

    void a(String str, ImageView imageView);

    void a(String str, ImageView imageView, int i, e.b bVar);

    void a(String str, e.b bVar);

    Bitmap b(String str);

    void b(String str, ImageView imageView);

    boolean c(String str);

    boolean d(String str);
}
