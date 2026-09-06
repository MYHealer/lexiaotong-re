package com.huawei.hms.mlplugin.card.bcr.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: ViewBase.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4179a;
    private int b;

    public d(int i, int i2) {
        this.f4179a = i;
        this.b = i2;
    }

    protected int a() {
        return this.b;
    }

    protected int b() {
        return this.f4179a;
    }

    protected void a(Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        rect.left = i5;
        rect.top = i6;
        rect.right = i5 + i3;
        rect.bottom = i6 + i4;
        rect2.left = i;
        rect2.top = i2;
        rect2.right = i + i3;
        rect2.bottom = i2 + i4;
        canvas.drawBitmap(bitmap, (Rect) null, rect2, new Paint(1));
    }
}
