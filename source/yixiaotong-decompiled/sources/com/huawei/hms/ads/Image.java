package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class Image {
    public abstract Drawable getDrawable();

    public int getHeight() {
        return -1;
    }

    public abstract double getScale();

    public abstract Uri getUri();

    public int getWidth() {
        return -1;
    }
}
