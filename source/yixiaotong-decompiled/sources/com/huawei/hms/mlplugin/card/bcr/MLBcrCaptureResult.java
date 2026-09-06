package com.huawei.hms.mlplugin.card.bcr;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class MLBcrCaptureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4162a = 0;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Bitmap g;
    private Bitmap h;

    public void a(String str) {
    }

    public int getErrorCode() {
        return this.f4162a;
    }

    public String getExpire() {
        return this.e;
    }

    public String getIssuer() {
        return this.c;
    }

    public String getNumber() {
        return this.b;
    }

    public Bitmap getNumberBitmap() {
        return this.h;
    }

    public String getOrganization() {
        return this.d;
    }

    public Bitmap getOriginalBitmap() {
        return this.g;
    }

    public String getType() {
        return this.f;
    }

    public void setErrorCode(int i) {
        this.f4162a = i;
    }

    public void setExpire(String str) {
        this.e = str;
    }

    public void setIssuer(String str) {
        this.c = str;
    }

    public void setNumber(String str) {
        this.b = str;
    }

    public void setNumberBitmap(Bitmap bitmap) {
        this.h = bitmap;
    }

    public void setOrganization(String str) {
        this.d = str;
    }

    public void setOriginalBitmap(Bitmap bitmap) {
        this.g = bitmap;
    }

    public void setType(String str) {
        this.f = str;
    }
}
