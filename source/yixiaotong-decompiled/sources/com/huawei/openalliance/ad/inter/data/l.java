package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.co;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.w;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class l extends c implements g {
    private boolean B;
    private String C;
    private ImageInfo D;
    private List<ImageInfo> L;
    private String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoInfo f4461a;
    private List<String> b;
    private List<String> c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private String h;
    private NativeAdConfiguration i;

    @com.huawei.openalliance.ad.annotations.d
    private long j;
    private String k;
    private Integer l;
    private String m;
    private String n;
    private transient VideoConfiguration q;
    private MaterialClickInfo r;

    public l(AdContentData adContentData) {
        super(adContentData);
        this.B = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.l = Integer.valueOf(adContentData.aF());
        this.m = adContentData.aE();
    }

    private boolean C(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        return B(context, bundle);
    }

    private void Code(Context context, String str, Bundle bundle) {
        fh.V("INativeAd", "api report click event.");
        MaterialClickInfo materialClickInfoV = V(bundle);
        if (materialClickInfoV.L() == null && materialClickInfoV.D() == null) {
            materialClickInfoV.B((Integer) 1);
        }
        jk.Code(context, q(), bc.Code(bundle), 0, 0, str, 12, com.huawei.openalliance.ad.utils.b.Code(context), materialClickInfoV);
    }

    private void F(Context context, Bundle bundle) {
        fh.V("INativeAd", "api adShow called.");
        jk.V(context, q(), new ji.a().Z(bc.Code(bundle)).Code(Long.valueOf(Math.min(System.currentTimeMillis() - this.j, x()))).Code(Integer.valueOf(y())).V((Integer) 7).Code(ky.Code(bundle)).B(ky.V(bundle)).I(com.huawei.openalliance.ad.utils.b.Code(context)).Code());
    }

    private void S(Context context, Bundle bundle) {
        fh.V("INativeAd", "api report adShowStart event.");
        jk.Code(context, q(), bc.Code(bundle));
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<ImageInfo> B() {
        MetaData metaDataJ_;
        if (this.L == null && (metaDataJ_ = j_()) != null) {
            this.L = Code(metaDataJ_.d());
        }
        return this.L;
    }

    public void B(String str) {
        this.h = str;
        if (this.I != null) {
            this.I.I(str);
        }
    }

    public boolean B(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        Code(true);
        kr krVarCode = ks.Code(context, q(), au());
        boolean zCode = krVarCode.Code();
        if (zCode) {
            Code(context, krVarCode.Z(), bundle);
        }
        return zCode;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public VideoInfo C() {
        if (this.I == null || this.I.t() == null) {
            return null;
        }
        if (this.f4461a == null) {
            VideoInfo videoInfo = new VideoInfo(this.I.t());
            this.f4461a = videoInfo;
            videoInfo.Code(this.I.H());
        }
        return this.f4461a;
    }

    public void C(String str) {
        this.k = str;
    }

    public String Code() {
        MetaData metaDataJ_;
        if (this.C == null && (metaDataJ_ = j_()) != null) {
            this.C = bc.V(metaDataJ_.Z());
        }
        return this.C;
    }

    public void Code(Context context, MaterialClickInfo materialClickInfo) {
        co.Code(context, this.I, materialClickInfo);
    }

    public void Code(Context context, List<String> list) {
        if (context == null || !H()) {
            return;
        }
        new w(context, this).Code(list);
    }

    public void Code(Bundle bundle) {
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.q = videoConfiguration;
        if (this.I != null) {
            this.I.Code(videoConfiguration);
        }
        if (HiAd.Code() != null) {
            HiAd.Code().reportSetVideoConfigMedia(this.I, jg.c(K()), jg.d(K()), 3);
        }
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.i = nativeAdConfiguration;
    }

    public void Code(MaterialClickInfo materialClickInfo) {
        if (materialClickInfo != null) {
            this.r = materialClickInfo;
        }
    }

    public void Code(VideoInfo videoInfo) {
        this.f4461a = videoInfo;
    }

    public void Code(boolean z) {
        this.B = z;
    }

    public boolean Code(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        this.j = System.currentTimeMillis();
        B(String.valueOf(z.Code()));
        V(this.j);
        S(context, bundle);
        return true;
    }

    public void I(boolean z) {
        this.e = z;
    }

    public boolean I(Context context, Bundle bundle) {
        if (context == null || !H()) {
            fh.V("INativeAd", "record click event failed.");
            return false;
        }
        Code(context, v.D, bundle);
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> L() {
        List<String> listO;
        if (this.b == null && this.I != null && (listO = this.I.o()) != null && listO.size() > 0) {
            this.b = listO;
        }
        return this.b;
    }

    public void S(String str) {
        this.n = str;
    }

    public MaterialClickInfo V(Bundle bundle) {
        JSONObject jSONObjectV = bc.V(bundle);
        Integer numValueOf = Integer.valueOf(jSONObjectV.optInt(bf.al, -111111));
        Integer numValueOf2 = Integer.valueOf(jSONObjectV.optInt(bf.am, -111111));
        String strOptString = jSONObjectV.optString(bf.an, "");
        Float fCode = bc.Code(jSONObjectV.optString(bf.ar, "-111111"), Float.valueOf(-111111.0f));
        Integer numValueOf3 = Integer.valueOf(jSONObjectV.optInt("upX", -111111));
        Integer numValueOf4 = Integer.valueOf(jSONObjectV.optInt("upY", -111111));
        Integer numValueOf5 = Integer.valueOf(jSONObjectV.optInt(bf.ao, -111111));
        Long lValueOf = Long.valueOf(jSONObjectV.optLong(bf.aR));
        Long lValueOf2 = Long.valueOf(jSONObjectV.optLong(bf.aS));
        String strOptString2 = jSONObjectV.optString(bf.aT, "");
        if (numValueOf.intValue() == -111111) {
            numValueOf = null;
        }
        if (numValueOf2.intValue() == -111111) {
            numValueOf2 = null;
        }
        if (!bc.L(strOptString)) {
            strOptString = null;
        }
        if (fCode.floatValue() == -111111.0f) {
            fCode = null;
        }
        if (numValueOf3.intValue() == -111111) {
            numValueOf3 = null;
        }
        if (numValueOf4.intValue() == -111111) {
            numValueOf4 = null;
        }
        if (numValueOf5.intValue() == -111111) {
            numValueOf5 = null;
        }
        if (lValueOf.longValue() == 0) {
            lValueOf = null;
        }
        if (lValueOf2.longValue() == 0) {
            lValueOf2 = null;
        }
        if (bc.Code(strOptString2)) {
            strOptString2 = null;
        }
        return new MaterialClickInfo.a().Code(numValueOf).V(numValueOf2).V(strOptString).Code(fCode).I(numValueOf5).Z(numValueOf3).B(numValueOf4).V(lValueOf).Code(lValueOf2).Z(strOptString2).Code();
    }

    public String V() {
        MetaData metaDataS;
        if (this.S == null && (metaDataS = this.I.S()) != null) {
            this.S = bc.V(metaDataS.B());
        }
        return this.S;
    }

    public void V(long j) {
        if (this.I != null) {
            this.I.Z(j);
        }
    }

    public void V(Context context) {
        co.Code(context, this.I, (MaterialClickInfo) null);
    }

    public void V(List<ImageInfo> list) {
        this.L = list;
    }

    public void V(boolean z) {
        this.d = z;
    }

    public boolean V(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        F(context, bundle);
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public ImageInfo Z() {
        MetaData metaDataJ_;
        List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> listS;
        if (this.D == null && (metaDataJ_ = j_()) != null && (listS = metaDataJ_.S()) != null && !listS.isEmpty()) {
            this.D = new ImageInfo(listS.get(0));
        }
        return this.D;
    }

    public void Z(boolean z) {
        this.f = z;
    }

    public boolean Z(Context context, Bundle bundle) {
        return C(context, bundle);
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> a() {
        if (this.c == null && this.I != null) {
            List<String> listW = this.I.W();
            if (!ag.Code(listW) && listW.size() > 0) {
                this.c = listW;
            }
        }
        return this.c;
    }

    public String aA() {
        if (this.I != null) {
            return this.I.ao();
        }
        return null;
    }

    public String aB() {
        return this.k;
    }

    public String aC() {
        return this.n;
    }

    public DefaultTemplate aD() {
        if (this.I != null) {
            return this.I.aV();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ag() {
        if (this.I != null) {
            return this.I.z();
        }
        return null;
    }

    public VideoInfo ai() {
        return this.f4461a;
    }

    public boolean aj() {
        return this.d;
    }

    public boolean ak() {
        return this.e;
    }

    public boolean al() {
        return this.f;
    }

    public String am() {
        MetaData metaDataJ_ = j_();
        return metaDataJ_ != null ? metaDataJ_.a() : "";
    }

    public String an() {
        return h();
    }

    public Double ao() {
        return null;
    }

    public String ap() {
        return null;
    }

    public String aq() {
        return null;
    }

    public Bundle ar() {
        return new Bundle();
    }

    public void as() {
    }

    public NativeAdConfiguration at() {
        return this.i;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0113  */
    /* JADX WARN: Code duplicated, block: B:32:0x0139  */
    /* JADX WARN: Code duplicated, block: B:34:0x0145  */
    /* JADX WARN: Code duplicated, block: B:35:0x0152  */
    /* JADX WARN: Code duplicated, block: B:38:0x015a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0162  */
    public Map<String, String> au() {
        int iL;
        VideoInfo videoInfoC;
        String str;
        Map<String, String> mapBh;
        String str2;
        String str3;
        HashMap map = new HashMap();
        map.put("appId", z());
        map.put(kk.V, am());
        Integer numAy = ay();
        String str4 = ez.Code;
        if (numAy == null || ay().intValue() != 3) {
            if (C() == null) {
                str = "getVideoInfo is null";
            } else {
                iL = C().L();
                if (!C().h()) {
                    str4 = ez.V;
                }
                map.put(bf.s, str4);
                map.put(bf.r, C().a());
                map.put(bf.q, String.valueOf(iL));
                videoInfoC = C();
                map.put(bf.aV, videoInfoC.k());
                map.put(bf.m, u());
                map.put(bf.p, String.valueOf(az()));
                if (f_() != null) {
                    map.put(bf.n, String.valueOf(f_().getAutoPlayNetwork()));
                    map.put(bf.o, Boolean.toString(f_().isStartMuted()));
                }
                if (this.I != null) {
                    mapBh = this.I.bh();
                    if (mapBh != null) {
                        str2 = mapBh.get("videoAutoPlay");
                        str3 = mapBh.get("videoPlaySound");
                    } else {
                        str2 = null;
                        str3 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "y";
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "n";
                    }
                    map.put("videoAutoPlay", str2);
                    map.put("videoPlaySound", str3);
                }
                str = "buildLinkedAdConfig, set progress from native view " + iL;
            }
        } else if (ai() == null) {
            str = "getVideoInfoForV3 is null";
        } else {
            if (fh.Code()) {
                fh.Code("INativeAd", "video_info: %s", ad.V(ai()));
                fh.Code("INativeAd", "preview_image_info: %s", ad.V(B()));
            }
            iL = ai().L();
            if (!this.I.H()) {
                str4 = ez.V;
            }
            map.put(bf.s, str4);
            map.put(bf.aO, ad.V(ai()));
            map.put(bf.aP, ad.V(B()));
            map.put(bf.aQ, aB());
            map.put(bf.r, ai().a());
            map.put(bf.q, String.valueOf(iL));
            videoInfoC = ai();
            map.put(bf.aV, videoInfoC.k());
            map.put(bf.m, u());
            map.put(bf.p, String.valueOf(az()));
            if (f_() != null) {
                map.put(bf.n, String.valueOf(f_().getAutoPlayNetwork()));
                map.put(bf.o, Boolean.toString(f_().isStartMuted()));
            }
            if (this.I != null) {
                mapBh = this.I.bh();
                if (mapBh != null) {
                    str2 = mapBh.get("videoAutoPlay");
                    str3 = mapBh.get("videoPlaySound");
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "y";
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = "n";
                }
                map.put("videoAutoPlay", str2);
                map.put("videoPlaySound", str3);
            }
            str = "buildLinkedAdConfig, set progress from native view " + iL;
        }
        fh.V("INativeAd", str);
        return map;
    }

    public String av() {
        if (this.I != null) {
            return this.I.aE();
        }
        return null;
    }

    public Integer ay() {
        return this.l;
    }

    public int az() {
        if (this.I != null) {
            this.g = this.I.J();
        }
        return this.g;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public boolean b_() {
        return this.I != null && this.I.al() == 1;
    }

    public boolean d_() {
        if (this.I != null) {
            return !ag.Code(this.I.aL());
        }
        return false;
    }

    public VideoConfiguration f_() {
        return this.q;
    }

    public MaterialClickInfo g_() {
        return this.r;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public String h_() {
        MetaData metaDataJ_ = j_();
        return metaDataJ_ == null ? "" : metaDataJ_.q();
    }

    public Map<String, String> p() {
        if (this.I == null) {
            return null;
        }
        List<ImpEX> listAy = this.I.ay();
        List<ContentExt> listAz = this.I.az();
        HashMap map = new HashMap();
        if (!ag.Code(listAz)) {
            for (ContentExt contentExt : listAz) {
                map.put(contentExt.Code(), bc.V(contentExt.V()));
            }
        }
        if (!ag.Code(listAy)) {
            for (ImpEX impEX : listAy) {
                map.put(impEX.Code(), bc.V(impEX.V()));
            }
        }
        return map;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<FeedbackInfo> t() {
        if (this.I != null) {
            return this.I.aC();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String u() {
        return this.h;
    }

    public List<AdvertiserInfo> w() {
        if (this.I == null || !d_()) {
            return null;
        }
        return this.I.aL();
    }
}
