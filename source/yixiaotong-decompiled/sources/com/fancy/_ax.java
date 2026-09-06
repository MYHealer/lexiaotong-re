package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ax {
    public static void _a(Context context, Bitmap bitmap, FrameLayout frameLayout) {
        Bitmap bitmap_a;
        if (context == null || bitmap == null || frameLayout == null) {
            return;
        }
        try {
            bitmap_a = _ac._a(bitmap);
        } catch (Exception unused) {
            bitmap_a = null;
        }
        if (bitmap_a != null) {
            frameLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap_a));
        } else {
            frameLayout.setBackgroundColor(-16777216);
        }
    }
}
