package com.huawei.openalliance.ad.beans.metadata.v3;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MotionData implements Serializable {
    private static final long serialVersionUID = -4033124660273385722L;
    private long dataId;
    private int duration;
    private String filePath;
    private String format;
    private int height;
    private String sha256;
    private int size;
    private String url;
    private int width;

    public int B() {
        return this.size;
    }

    public int C() {
        return this.duration;
    }

    public long Code() {
        return this.dataId;
    }

    public void Code(int i) {
        this.width = i;
    }

    public void Code(long j) {
        this.dataId = j;
    }

    public void Code(String str) {
        this.format = str;
    }

    public String D() {
        return this.filePath;
    }

    public String F() {
        return this.sha256;
    }

    public int I() {
        return this.height;
    }

    public void I(int i) {
        this.size = i;
    }

    public void I(String str) {
        this.sha256 = str;
    }

    public String S() {
        return this.url;
    }

    public int V() {
        return this.width;
    }

    public void V(int i) {
        this.height = i;
    }

    public void V(String str) {
        this.url = str;
    }

    public String Z() {
        return this.format;
    }

    public void Z(int i) {
        this.duration = i;
    }

    public void Z(String str) {
        this.filePath = str;
    }
}
