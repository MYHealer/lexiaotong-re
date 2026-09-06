package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class fs extends fp {
    boolean h;
    private final int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;

    public fs(lt ltVar) {
        super(ltVar);
        this.j = hashCode();
        this.k = false;
        this.l = false;
        this.h = false;
        this.m = false;
        this.n = false;
        this.o = String.valueOf(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        fh.V("RealtimeAdMediator", "doOnShowSloganEnd");
        this.l = true;
        if (this.m) {
            fh.V("RealtimeAdMediator", "Ad fails to display or loading timeout, ad dismiss");
            I(com.huawei.openalliance.ad.constant.ai.y);
            a();
        } else {
            if (this.h) {
                return;
            }
            fh.V(u(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
            if (this.n && this.e != null) {
                com.huawei.openalliance.ad.ipc.g.V(this.e).Code("getNormalSplashAd", String.valueOf(this.C.Z()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.fs.5
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fs.this.B = (AdContentData) callResult.getData();
                                if (fs.this.B != null) {
                                    fh.V(fs.this.u(), "linked loaded, display normal when slogan ends");
                                    fs.this.Code(fs.this.B, true);
                                    fs.this.Z(com.huawei.openalliance.ad.constant.ai.ah);
                                } else {
                                    fh.V(fs.this.u(), "linked loaded, do not call play");
                                    fs.this.I(-6);
                                    fs.this.a();
                                }
                            }
                        });
                    }
                }, AdContentData.class);
            } else if (this.B != null) {
                fh.V(u(), "show splash");
                Code(this.B, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        fh.V("RealtimeAdMediator", "doOnReachMinSloganShowTime");
        this.k = true;
        if (!this.h && this.B != null) {
            Code(this.B, true);
            return;
        }
        fh.V("RealtimeAdMediator", "doOnReachMinSloganShowTime adFailToDisplay: %s", Boolean.valueOf(this.m));
        if (this.m) {
            fh.V("RealtimeAdMediator", "ad fail to load when reach min slogan show time");
            I(com.huawei.openalliance.ad.constant.ai.y);
            a();
        }
    }

    @Override // com.huawei.hms.ads.fp
    protected void Code(AdContentData adContentData, boolean z) {
        fh.V("RealtimeAdMediator", "on content loaded");
        this.B = adContentData;
        if (adContentData == null) {
            I(com.huawei.openalliance.ad.constant.ai.u);
            r();
            if (z || this.f == null) {
                return;
            }
            this.f.onAdFailed(com.huawei.openalliance.ad.constant.ai.u);
            return;
        }
        lt ltVarH = h();
        if (ltVarH == null) {
            I(com.huawei.openalliance.ad.constant.ai.w);
            r();
            if (z || this.f == null) {
                return;
            }
            this.f.onAdFailed(com.huawei.openalliance.ad.constant.ai.w);
            return;
        }
        if (!z) {
            fh.V("RealtimeAdMediator", "displayAfterLoaded false");
            if (this.f != null) {
                this.f.onAdLoaded();
                return;
            }
            return;
        }
        di diVar = new di(ltVarH.getContext());
        if (diVar.Code()) {
            I(com.huawei.openalliance.ad.constant.ai.v);
            r();
            return;
        }
        if (this.B.l() != 12) {
            if (!this.k && !this.l) {
                fh.V("RealtimeAdMediator", "slogan hasn't reach min show time or end, show ad later");
                return;
            }
            if (diVar.Code()) {
                I(com.huawei.openalliance.ad.constant.ai.v);
                r();
                return;
            }
            boolean zV = V(this.B);
            this.h = true;
            if (zV) {
                return;
            }
            V(com.huawei.openalliance.ad.constant.ai.w);
            return;
        }
        if (Z() == 1 && (I() instanceof com.huawei.openalliance.ad.inter.listeners.m)) {
            fh.V("RealtimeAdMediator", "on linked loaded, sloganShowEnd:" + this.l);
            if (!this.l) {
                com.huawei.openalliance.ad.inter.listeners.m mVar = (com.huawei.openalliance.ad.inter.listeners.m) I();
                com.huawei.openalliance.ad.inter.data.k kVarCode = jl.Code(this.B);
                fh.V(u(), "on content loaded, linkedAd loaded. ");
                this.F = System.currentTimeMillis();
                mVar.Code(kVarCode);
                this.L = this.B;
                this.n = true;
                B(200);
                return;
            }
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.6
            @Override // java.lang.Runnable
            public void run() {
                fs.this.I(com.huawei.openalliance.ad.constant.ai.af);
                fs.this.r();
            }
        });
    }

    @Override // com.huawei.hms.ads.ft
    public void I(boolean z) {
        lt ltVarH = h();
        if (ltVarH == null) {
            fh.I("RealtimeAdMediator", "splash view is null");
            if (this.g != null) {
                this.g.onAdDismissed();
            }
        }
        if (this.B == null) {
            if (this.g != null) {
                this.g.onAdError(com.huawei.openalliance.ad.constant.ai.u);
            }
            a();
            fh.I("RealtimeAdMediator", "ad is null");
            return;
        }
        if (this.B.d() < com.huawei.openalliance.ad.utils.z.Code()) {
            fh.I("RealtimeAdMediator", "show ad, ad expire");
            if (this.g != null) {
                this.g.onAdError(com.huawei.openalliance.ad.constant.ai.aj);
                return;
            }
            return;
        }
        fh.V("RealtimeAdMediator", "showAd, showSlogan: %s", Boolean.valueOf(z));
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.3
            @Override // java.lang.Runnable
            public void run() {
                fs.this.D();
            }
        });
        if (z) {
            ltVarH.Code(new mg() { // from class: com.huawei.hms.ads.fs.4
                @Override // com.huawei.hms.ads.mg
                public void Code() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.w();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.mg
                public void V() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.v();
                        }
                    });
                }
            });
        } else {
            w();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void V(boolean z) {
        if (z) {
            q();
            return;
        }
        fh.V("RealtimeAdMediator", "start load ad.");
        lt ltVarH = h();
        AdSlotParam adSlotParamB = b();
        if (ltVarH == null || adSlotParamB == null) {
            if (this.f != null) {
                this.f.onAdFailed(-4);
            }
        } else {
            this.o = String.valueOf(102);
            Code(adSlotParamB);
            Code(adSlotParamB, d(), false);
        }
    }

    @Override // com.huawei.hms.ads.fp
    protected String f() {
        return this.o;
    }

    @Override // com.huawei.hms.ads.ft
    public void q() {
        fh.V("RealtimeAdMediator", "start");
        lt ltVarH = h();
        if (ltVarH == null) {
            I(-4);
            a();
        } else {
            c();
            com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.1
                @Override // java.lang.Runnable
                public void run() {
                    fs.this.D();
                }
            });
            ltVarH.Code(new mg() { // from class: com.huawei.hms.ads.fs.2
                @Override // com.huawei.hms.ads.mg
                public void Code() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.w();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.mg
                public void V() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.v();
                        }
                    });
                }
            });
            e();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void r() {
        fh.V("RealtimeAdMediator", "onAdFailToDisplay - reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(this.k), Boolean.valueOf(this.l));
        this.m = true;
        if (this.k || this.l) {
            a();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public AdContentData s() {
        return this.B;
    }

    protected String u() {
        return "RealtimeAdMediator" + this.j;
    }
}
