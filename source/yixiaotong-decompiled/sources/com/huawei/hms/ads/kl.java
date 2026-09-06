package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kl extends kr {
    private static final String V = "InnerWebAction";
    protected ez Code;
    private boolean D;
    private boolean F;
    private final boolean S;

    public kl(Context context, AdContentData adContentData, boolean z) {
        super(context, adContentData);
        this.Code = new ez();
        this.F = false;
        this.D = false;
        this.S = z;
    }

    public kl(Context context, AdContentData adContentData, boolean z, Map<String, String> map) {
        super(context, adContentData);
        this.Code = new ez();
        this.F = false;
        this.D = false;
        this.S = z;
        Code(map);
    }

    private void B() {
        String str;
        String str2;
        if (this.Code == null || this.Z == null) {
            return;
        }
        Map<String, String> mapBh = this.Z.bh();
        if (mapBh != null) {
            str = mapBh.get("videoAutoPlay");
            str2 = mapBh.get("videoPlaySound");
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "y";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "n";
        }
        this.Code.S(str);
        this.Code.F(str2);
    }

    private boolean Code(AdContentData adContentData) {
        if (!jg.Code(this.Z.v()) && !com.huawei.openalliance.ad.utils.ap.Z(this.I)) {
            return I();
        }
        Code(com.huawei.openalliance.ad.constant.v.B);
        co.Code(this.I, adContentData, this.Code, this.F, this.D);
        return true;
    }

    protected void Code(Map<String, String> map) {
        fh.Code(V, "buildLinkedAdConfig");
        if (map == null || map.isEmpty()) {
            return;
        }
        this.D = com.huawei.openalliance.ad.constant.bf.ba.equals(map.get(com.huawei.openalliance.ad.constant.bf.ba));
        String orDefault = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.p, String.valueOf(0));
        String orDefault2 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.m, String.valueOf(0));
        String orDefault3 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.s, ez.V);
        String orDefault4 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.q, null);
        String orDefault5 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.r, "n");
        String orDefault6 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.aO, null);
        String orDefault7 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.aP, null);
        String orDefault8 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.aQ, null);
        String orDefault9 = map.getOrDefault(com.huawei.openalliance.ad.constant.bf.aV, ez.V);
        Integer numF = com.huawei.openalliance.ad.utils.bc.F(orDefault);
        if (numF != null) {
            this.Code.V(numF.intValue());
        } else {
            this.Code.V(0);
        }
        this.Code.I(orDefault2);
        Integer numF2 = com.huawei.openalliance.ad.utils.bc.F(orDefault4);
        if (numF2 != null) {
            this.Code.Code(numF2.intValue());
            fh.V(V, "set progress from native view " + numF2);
        } else {
            this.Code.Code(0);
        }
        if (!TextUtils.isEmpty(orDefault9)) {
            this.Code.Code(orDefault9);
        }
        this.Code.V(orDefault5);
        ez ezVar = this.Code;
        String str = ez.Code;
        ezVar.Code(ez.Code.equals(orDefault3));
        this.Code.B(orDefault6);
        this.Code.C(orDefault7);
        this.Code.Z(orDefault8);
        B();
        String strValueOf = map.containsKey(com.huawei.openalliance.ad.constant.bf.n) ? map.get(com.huawei.openalliance.ad.constant.bf.n) : null;
        String str2 = map.containsKey(com.huawei.openalliance.ad.constant.bf.o) ? map.get(com.huawei.openalliance.ad.constant.bf.o) : null;
        if (strValueOf == null && str2 == null) {
            return;
        }
        if (com.huawei.openalliance.ad.utils.bc.Code(strValueOf)) {
            strValueOf = String.valueOf(0);
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(str2)) {
            str = str2;
        }
        this.Code.Code(new VideoConfiguration.Builder().setAutoPlayNetwork(com.huawei.openalliance.ad.utils.bc.Code(strValueOf, 0)).setStartMuted(Boolean.parseBoolean(str)).build());
    }

    public void Code(boolean z) {
        this.F = z;
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        if (this.Z == null) {
            return I();
        }
        fh.V(V, "handle inner web action");
        this.Z.I(this.S);
        fh.V(V, "needAppDownload: %s", Boolean.valueOf(this.S));
        return TextUtils.isEmpty(this.Z.i()) ? I() : Code(this.Z);
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.B);
    }
}
