package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.utils.ad;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends c implements e {
    private static final String B = "AwardAd";
    private static final long C = 30424300;
    protected boolean Code;
    private boolean D;
    private boolean F;
    private RewardItem L;
    private com.huawei.openalliance.ad.beans.metadata.VideoInfo S;
    protected boolean V;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.F = false;
        this.Code = true;
        this.V = true;
        if (adContentData.N() == null || adContentData.O() == 0) {
            return;
        }
        this.L = new RewardItem(adContentData.N(), adContentData.O());
    }

    private com.huawei.openalliance.ad.beans.metadata.VideoInfo Code() {
        MetaData metaDataJ_;
        if (this.S == null && (metaDataJ_ = j_()) != null) {
            this.S = metaDataJ_.V();
        }
        return this.S;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public boolean C() {
        return this.F;
    }

    public void Code(RewardItem rewardItem) {
        this.L = rewardItem;
    }

    protected void D() {
        if (this.I == null) {
            return;
        }
        fh.V(B, "reset video config server");
        Map map = (Map) ad.V(this.I.bg(), Map.class, new Class[0]);
        String str = map != null ? (String) map.get("videoPlaySound") : null;
        if (TextUtils.isEmpty(str)) {
            str = "n";
        }
        this.V = TextUtils.equals(str, "n");
    }

    public boolean F() {
        return this.D;
    }

    public void I(boolean z) {
        this.D = z;
    }

    protected void L() {
        if (this.I == null) {
            return;
        }
        fh.V(B, "reset video config server");
        Map map = (Map) ad.V(this.I.bg(), Map.class, new Class[0]);
        String str = map != null ? (String) map.get("videoAutoPlay") : null;
        if (TextUtils.isEmpty(str)) {
            str = "y";
        }
        this.Code = !TextUtils.equals(str, "a");
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public RewardItem S() {
        return this.L;
    }

    public boolean V() {
        if (this.I != null) {
            this.S = this.I.t();
        }
        return this.S != null || ae();
    }

    public void Z(boolean z) {
        this.F = z;
    }
}
