package com.huawei.hms.mlplugin.card.bcr;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class MLSnCaptureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4163a = 0;
    private String b;
    private Bitmap c;

    public int getErrorCode() {
        return this.f4163a;
    }

    public String getNumber() {
        return this.b;
    }

    public Bitmap getNumberBitmap() {
        return this.c;
    }

    public void setErrorCode(int i) {
        this.f4163a = i;
    }

    public void setNumber(String str) {
        this.b = str;
    }

    public void setNumberBitmap(Bitmap bitmap) {
        this.c = bitmap;
    }
}
