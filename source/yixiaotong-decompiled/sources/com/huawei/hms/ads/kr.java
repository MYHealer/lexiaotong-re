package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class kr {
    private static final String Code = "clickActionType";
    private static final String V = "handleUrlResult";
    protected kh B;
    private kr F;
    protected Context I;
    protected AdContentData Z;
    private String S = null;
    protected int C = 0;

    kr() {
    }

    kr(Context context, AdContentData adContentData) {
        this.I = context;
        this.Z = adContentData;
    }

    public void Code(kh khVar) {
        this.B = khVar;
    }

    void Code(kr krVar) {
        this.F = krVar;
    }

    public void Code(String str) {
        this.S = str;
    }

    public abstract boolean Code();

    public void I(int i) {
        this.C = i;
    }

    boolean I() {
        kr krVar = this.F;
        if (krVar != null) {
            return krVar.Code();
        }
        return false;
    }

    public void V() {
    }

    public void V(boolean z) {
        if (this.B == null) {
            return;
        }
        el elVar = new el();
        elVar.V(Code, this.C);
        elVar.V(V, z);
        this.B.Code(elVar.Code());
    }

    public String Z() {
        kr krVar;
        String str = this.S;
        return (str != null || (krVar = this.F) == null) ? str : krVar.Z();
    }
}
