package com.ubixnow.ooooo;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oo0OOoo {
    public int OooO00o;
    private String OooO0O0;
    public int OooO0Oo;
    public int OooO0o0;
    public int OooO0oO;
    public String OooO0OO = "";
    private String OooO0o = "";

    public oo0OOoo(int i, String str) {
        this.OooO0O0 = "";
        this.OooO00o = i;
        this.OooO0O0 = str == null ? "" : str;
        OooO00o();
    }

    public oo0OOoo(int i, String str, int i2, int i3) {
        this.OooO0O0 = "";
        this.OooO00o = i;
        this.OooO0O0 = str == null ? "" : str;
        this.OooO0o0 = i2;
        this.OooO0Oo = i3;
        OooO00o();
    }

    public void OooO00o() {
        try {
            if (TextUtils.isEmpty(this.OooO0O0)) {
                return;
            }
            this.OooO0OO = ooo0o.OooO00o(this.OooO0O0);
        } catch (Exception unused) {
        }
    }

    public void OooO00o(int i) {
        this.OooO0Oo = i;
    }

    public void OooO00o(String str) {
        if (str == null) {
            str = "";
        }
        this.OooO0O0 = str;
        OooO00o();
    }

    public int OooO0O0() {
        return this.OooO0Oo;
    }

    public void OooO0O0(int i) {
        this.OooO00o = i;
    }

    public void OooO0O0(String str) {
        if (str == null) {
            str = "";
        }
        this.OooO0o = str;
    }

    public String OooO0OO() {
        return this.OooO0OO;
    }

    public void OooO0OO(int i) {
        this.OooO0o0 = i;
    }

    public int OooO0Oo() {
        return this.OooO00o;
    }

    public void OooO0Oo(int i) {
        this.OooO0oO = i;
    }

    public int OooO0o() {
        return this.OooO0o0;
    }

    public String OooO0o0() {
        return this.OooO0O0;
    }

    public String OooO0oO() {
        return this.OooO0o;
    }

    public int OooO0oo() {
        return this.OooO0oO;
    }

    public String toString() {
        return "com.ubixnow.core.common.material.BaseMaterialDetailInfo{materialType=" + this.OooO00o + ", materialUrl='" + this.OooO0O0 + "', materialId='" + this.OooO0OO + "', materialHeight=" + this.OooO0Oo + ", materialWidth=" + this.OooO0o0 + ", videoCoverUrl='" + this.OooO0o + "', videoDuration=" + this.OooO0oO + '}';
    }
}
