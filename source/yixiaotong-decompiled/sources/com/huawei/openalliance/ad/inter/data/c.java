package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class c implements d {
    private static final String Code = "BaseAd";
    private String B;
    private String C;
    private boolean D = false;
    private List<AdSource> F;
    protected AdContentData I;
    private AppInfo S;
    private String V;
    protected String Z;

    public c(AdContentData adContentData) {
        this.V = UUID.randomUUID().toString();
        this.I = adContentData;
        if (adContentData != null) {
            if (TextUtils.isEmpty(adContentData.aa())) {
                this.I.S(this.V);
            } else {
                this.V = this.I.aa();
            }
        }
    }

    public static List<ImageInfo> Code(List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<com.huawei.openalliance.ad.beans.metadata.ImageInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ImageInfo(it.next()));
            }
        }
        return arrayList;
    }

    private void V(Context context) {
        if (context == null) {
            fh.I(Code, "context is null not call gotoWhyThisAdPage method");
        } else {
            z.Code(context, this.I);
        }
    }

    public String A() {
        return this.V;
    }

    public void B(boolean z) {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.V(z);
        }
    }

    public void C(boolean z) {
        this.D = z;
    }

    public void Code(long j) {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        if (this.I == null || rewardVerifyConfig == null) {
            return;
        }
        Code(rewardVerifyConfig.getData());
        V(rewardVerifyConfig.getUserId());
    }

    public void Code(String str) {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.q(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (ah() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, this.I, ah().getNurl(), true);
        fh.Code(Code, "sendBiddingSuccess result");
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo E() {
        MetaData metaDataJ_;
        ApkInfo apkInfoE;
        if (this.S == null && (metaDataJ_ = j_()) != null && (apkInfoE = metaDataJ_.e()) != null) {
            AppInfo appInfo = new AppInfo(apkInfoE);
            appInfo.Code(o());
            appInfo.V(A());
            appInfo.a(metaDataJ_.I());
            this.S = appInfo;
        }
        return this.S;
    }

    public List<Integer> G() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.q();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean H() {
        boolean Z = jg.Z(K());
        if (!Z) {
            fh.V(Code, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    public void I(String str) {
        if (str != null) {
            this.I.i(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int J() {
        return jg.a(K());
    }

    public String K() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.v();
        }
        return null;
    }

    public DelayInfo M() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.an();
        }
        return null;
    }

    public String N() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.at();
        }
        return null;
    }

    public String O() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.au();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig P() {
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(N());
        builder.setUserId(O());
        return builder.build();
    }

    public List<AdSource> Q() {
        MetaData metaDataJ_;
        if (this.F == null && (metaDataJ_ = j_()) != null) {
            this.F = metaDataJ_.l();
        }
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String R() {
        AdSource adSourceCode = AdSource.Code(Q());
        if (adSourceCode != null) {
            return bc.V(adSourceCode.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String T() {
        AdSource adSourceCode = AdSource.Code(Q());
        if (adSourceCode != null) {
            return adSourceCode.V();
        }
        return null;
    }

    public String U() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.r();
        }
        return null;
    }

    public void V(String str) {
        if (str != null) {
            this.I.r(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void V(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (ah() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, this.I, ah().getLurl(), false);
        fh.Code(Code, "sendBiddingFailed result");
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String W() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aG();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String X() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aH();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int Y() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aN();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean aa() {
        MetaData metaDataJ_ = j_();
        if (metaDataJ_ != null) {
            return metaDataJ_.o();
        }
        return false;
    }

    public boolean ab() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String ac() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.aP() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean ad() {
        AdContentData adContentData = this.I;
        return (adContentData == null || !adContentData.aQ() || TextUtils.isEmpty(this.I.aP())) ? false : true;
    }

    protected boolean ae() {
        AdContentData adContentData = this.I;
        return adContentData != null && adContentData.aF() == 3;
    }

    public String af() {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aE();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ag() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public BiddingInfo ah() {
        if (this.I != null) {
            BiddingInfo.a aVarI = new BiddingInfo.a().Code(this.I.aW()).Code(this.I.aX()).V(this.I.aY()).I(this.I.aZ());
            if (!aVarI.Code().Code()) {
                return aVarI.Code();
            }
        }
        return new BiddingInfo();
    }

    public boolean b() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.x();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String c() {
        MetaData metaDataJ_;
        if (this.B == null && (metaDataJ_ = j_()) != null) {
            this.B = bc.V(metaDataJ_.Code());
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String d() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.a();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String e() {
        MetaData metaDataJ_ = j_();
        return metaDataJ_ != null ? metaDataJ_.g() : "2";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String strD = d();
        if (!(obj instanceof c) || strD == null) {
            return false;
        }
        return TextUtils.equals(strD, ((c) obj).d());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int f() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.l();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String g() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.b() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String h() {
        MetaData metaDataJ_;
        if (this.C == null && (metaDataJ_ = j_()) != null) {
            this.C = bc.V(metaDataJ_.L());
        }
        return this.C;
    }

    public int hashCode() {
        String strD = d();
        return (strD != null ? strD.hashCode() : -1) & super.hashCode();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long i() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.e();
        }
        return 0L;
    }

    public CtrlExt i_() {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return null;
        }
        return adContentData.V();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long j() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.d();
        }
        return 0L;
    }

    public MetaData j_() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.S();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean k() {
        return j() < System.currentTimeMillis();
    }

    public String k_() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.M();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String l() {
        AdContentData adContentData = this.I;
        String strAc = adContentData != null ? adContentData.ac() : null;
        return TextUtils.isEmpty(strAc) ? x.au : strAc;
    }

    public int l_() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.j();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String m() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.ad() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String n() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.ae() : "";
    }

    public String o() {
        MetaData metaDataJ_ = j_();
        return metaDataJ_ != null ? metaDataJ_.c() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AdContentData q() {
        return this.I;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String r() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.L();
        }
        return null;
    }

    public int s() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.Z();
        }
        return -1;
    }

    public String u() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.D();
        }
        return null;
    }

    public long v() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aB();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long x() {
        MetaData metaDataJ_ = j_();
        if (metaDataJ_ != null) {
            return metaDataJ_.F();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int y() {
        MetaData metaDataJ_ = j_();
        if (metaDataJ_ != null) {
            return metaDataJ_.D();
        }
        return 50;
    }

    public String z() {
        MetaData metaDataJ_ = j_();
        return metaDataJ_ != null ? metaDataJ_.b() : "";
    }
}
