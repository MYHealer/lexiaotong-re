package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class le {
    private String B;
    private String C;
    private String Code;
    private ImageInfo D;
    private String F;
    private String I;
    private AdContentData L;
    private String S;
    private String V;
    private Integer Z;

    public le() {
    }

    public le(String str, String str2, String str3, String str4) {
        this.Code = str == null ? "" : str;
        this.V = str2 == null ? "" : str2;
        this.I = str3 == null ? "" : str3;
        this.B = str4 == null ? "" : str4;
    }

    public int B() {
        return this.Z.intValue();
    }

    public void B(String str) {
        this.C = str;
    }

    public String C() {
        return this.C;
    }

    public void C(String str) {
        this.S = str;
    }

    public String Code() {
        return this.I;
    }

    public void Code(int i) {
        this.Z = Integer.valueOf(i);
    }

    public void Code(AdContentData adContentData) {
        this.L = adContentData;
    }

    public void Code(ImageInfo imageInfo) {
        this.D = imageInfo;
    }

    public void Code(String str) {
        if (str == null) {
            str = "";
        }
        this.I = str;
    }

    public ImageInfo D() {
        return this.D;
    }

    public String F() {
        return this.F;
    }

    public String I() {
        return this.V;
    }

    public void I(String str) {
        if (str == null) {
            str = "";
        }
        this.V = str;
    }

    public AdContentData L() {
        return this.L;
    }

    public String S() {
        return this.S;
    }

    public void S(String str) {
        this.F = str;
    }

    public String V() {
        return this.Code;
    }

    public void V(String str) {
        if (str == null) {
            str = "";
        }
        this.Code = str;
    }

    public String Z() {
        return this.B;
    }

    public void Z(String str) {
        if (str == null) {
            str = "";
        }
        this.B = str;
    }
}
