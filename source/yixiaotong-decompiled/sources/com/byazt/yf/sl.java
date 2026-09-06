package com.byazt.yf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 158})
public abstract class sl {
    public int c;
    public String tt;
    public String uj;
    public String ve;

    public int c() {
        return this.c;
    }

    public String n() {
        switch (this.c) {
            case 1:
                return MediationConstant.ADN_PANGLE;
            case 2:
            default:
                return "";
            case 3:
                return MediationConstant.ADN_GDT;
            case 4:
                return MediationConstant.ADN_MINTEGRAL;
            case 5:
                return MediationConstant.ADN_UNITY;
            case 6:
                return "baidu";
            case 7:
                return MediationConstant.ADN_KS;
            case 8:
                return MediationConstant.ADN_SIGMOB;
            case 9:
                return MediationConstant.ADN_KLEVIN;
            case 10:
                return MediationConstant.ADN_XIAOMI;
        }
    }

    public String tt() {
        return this.tt;
    }

    public String uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }
}
