package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Video implements Serializable {
    private static final long serialVersionUID = -9078513959338975690L;
    private int checkSHA256Flag;
    private long duration;
    private String format;

    @c(Code = "H")
    private int height;
    private String localPath;
    private String sha256;
    private long size;
    private int type;
    private String url;

    @c(Code = "W")
    private int width;

    public long B() {
        return this.size;
    }

    public String C() {
        return this.sha256;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i) {
        this.width = i;
    }

    public void Code(long j) {
        this.duration = j;
    }

    public void Code(String str) {
        this.url = str;
    }

    public String D() {
        return this.localPath;
    }

    public int F() {
        return this.checkSHA256Flag;
    }

    public int I() {
        return this.height;
    }

    public void I(int i) {
        this.checkSHA256Flag = i;
    }

    public void I(String str) {
        this.format = str;
    }

    public int L() {
        return this.type;
    }

    public String S() {
        return this.format;
    }

    public int V() {
        return this.width;
    }

    public void V(int i) {
        this.height = i;
    }

    public void V(long j) {
        this.size = j;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public long Z() {
        return this.duration;
    }

    public void Z(int i) {
        this.type = i;
    }

    public void Z(String str) {
        this.localPath = str;
    }
}
