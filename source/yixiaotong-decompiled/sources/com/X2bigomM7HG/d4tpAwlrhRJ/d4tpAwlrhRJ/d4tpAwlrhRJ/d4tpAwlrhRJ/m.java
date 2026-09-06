package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f1003a;
    private Function<SparseArray<Object>, Object> b;
    private volatile boolean c = false;
    private NativeADMediaListener d = new NativeADMediaListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.1
        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            t.a("onVideoCompleted");
            m.this.b();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            t.a("onVideoCompleted");
            m.this.c();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            t.a("onVideoError adError = " + adError);
            m.this.a(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            t.a("onVideoPause");
            m.this.g();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            t.a("onVideoResume");
            m.this.f();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            t.a("onVideoStart");
            m.this.h();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    };

    public m(NativeUnifiedADData nativeUnifiedADData) {
        this.f1003a = nativeUnifiedADData;
    }

    private void a(int i) {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(i);
        }
    }

    private void a(Map<String, Object> map) {
        int iA;
        if (map == null || this.f1003a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f1003a.sendLossNotification(0, iA, null);
    }

    private void d() {
        this.c = true;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.f1003a = null;
        }
    }

    private Map<String, Object> e() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getExtraInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60020);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60019);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60018);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    private void i() {
        this.f1003a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.2
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                t.a("onADClicked");
                m.this.b();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                t.a("onADExposed");
                m.this.a();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }
        });
    }

    private String j() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getImgUrl() : "";
    }

    private String k() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getIconUrl() : "";
    }

    private String l() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getCTAText() : "";
    }

    private String m() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getDescriptionUrl();
    }

    private String n() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getVersionName();
    }

    private String o() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getPrivacyAgreement();
    }

    private String p() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getPermissionsUrl();
    }

    private long q() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
            return 0L;
        }
        return appMiitInfo.getPackageSizeBytes();
    }

    private String r() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getAuthorName();
    }

    private String s() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) ? "" : appMiitInfo.getAppName();
    }

    private String t() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getTitle() : "";
    }

    private String u() {
        NativeUnifiedADData nativeUnifiedADData = this.f1003a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getDesc() : "";
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void a(AdError adError) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60010);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50006, new h(adError));
            this.b.apply(sparseArray);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v102, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v103, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v104, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v105, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v106, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v107, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v108, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v109, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v110, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v113, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v114, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v147 */
    /* JADX WARN: Type inference failed for: r10v148 */
    /* JADX WARN: Type inference failed for: r10v71, types: [T, java.lang.String] */
    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        NativeUnifiedADData nativeUnifiedADData;
        if (i == 40038) {
            ?? r10 = (T) s();
            t.a("getAppName appName = " + ((String) r10));
            return r10;
        }
        if (i == 40039) {
            ?? r11 = (T) r();
            t.a("getAuthorName authorName = " + ((String) r11));
            return r11;
        }
        if (i == 40040) {
            long jQ = q();
            t.a("getPackageSizeBytes packageSize = " + jQ);
            return (T) Long.valueOf(jQ);
        }
        if (i == 40041) {
            ?? r12 = (T) p();
            t.a("getPermissionsUrl permissionsUrl = " + ((String) r12));
            return r12;
        }
        if (i == 40042) {
            ?? r13 = (T) o();
            t.a("getPrivacyAgreement privacyAgreement = " + ((String) r13));
            return r13;
        }
        if (i == 40044) {
            ?? r14 = (T) m();
            t.a("getDescriptionUrl descriptionUrl = " + ((String) r14));
            return r14;
        }
        if (i == 40043) {
            ?? r15 = (T) n();
            t.a("getVersionName versionName = " + ((String) r15));
            return r15;
        }
        if (i == 40032) {
            ?? r16 = (T) t();
            t.a("getTitle title = " + ((String) r16));
            return r16;
        }
        if (i == 40033) {
            ?? r17 = (T) u();
            t.a("desc title = " + ((String) r17));
            return r17;
        }
        if (i == 40045) {
            ?? r18 = (T) l();
            t.a("getCTAText ctaTest = " + ((String) r18));
            return r18;
        }
        if (i == 40046) {
            ?? r19 = (T) k();
            t.a("getIconUrl iconUrl = " + ((String) r19));
            return r19;
        }
        if (i == 40047) {
            ?? r110 = (T) j();
            t.a("getImgUrl imgUrl = " + ((String) r110));
            return r110;
        }
        if (i == 40048) {
            NativeUnifiedADData nativeUnifiedADData2 = this.f1003a;
            int pictureWidth = nativeUnifiedADData2 != null ? nativeUnifiedADData2.getPictureWidth() : 0;
            t.a("getPictureWidth width = " + pictureWidth);
            return (T) Integer.valueOf(pictureWidth);
        }
        if (i == 40049) {
            NativeUnifiedADData nativeUnifiedADData3 = this.f1003a;
            int pictureHeight = nativeUnifiedADData3 != null ? nativeUnifiedADData3.getPictureHeight() : 0;
            t.a("getPictureHeight height = " + pictureHeight);
            return (T) Integer.valueOf(pictureHeight);
        }
        if (i == 40050) {
            NativeUnifiedADData nativeUnifiedADData4 = this.f1003a;
            T t = nativeUnifiedADData4 != null ? (T) nativeUnifiedADData4.getImgList() : (T) new ArrayList(0);
            t.a("getImgList list = " + t + " list.size = " + (t != null ? ((List) t).size() : 0));
            return t;
        }
        if (i == 40051) {
            NativeUnifiedADData nativeUnifiedADData5 = this.f1003a;
            int appScore = nativeUnifiedADData5 != null ? nativeUnifiedADData5.getAppScore() : 0;
            t.a("getAppScore appScore = " + appScore);
            return (T) Integer.valueOf(appScore);
        }
        if (i == 40052) {
            NativeUnifiedADData nativeUnifiedADData6 = this.f1003a;
            boolean zIsAppAd = nativeUnifiedADData6 != null ? nativeUnifiedADData6.isAppAd() : false;
            t.a("isAppAd isAppAd = " + zIsAppAd);
            return (T) Boolean.valueOf(zIsAppAd);
        }
        if (i == 40003) {
            NativeUnifiedADData nativeUnifiedADData7 = this.f1003a;
            int ecpm = nativeUnifiedADData7 != null ? nativeUnifiedADData7.getECPM() : -1;
            t.a("getECPM ecpm = " + ecpm);
            return (T) Integer.valueOf(ecpm);
        }
        if (i == 40004) {
            NativeUnifiedADData nativeUnifiedADData8 = this.f1003a;
            ?? r111 = nativeUnifiedADData8 != null ? (T) nativeUnifiedADData8.getECPMLevel() : (T) "";
            t.a("getECPMLevel level = " + ((String) r111));
            return (T) r111;
        }
        if (i == 40053) {
            NativeUnifiedADData nativeUnifiedADData9 = this.f1003a;
            int appStatus = nativeUnifiedADData9 != null ? nativeUnifiedADData9.getAppStatus() : 1;
            t.a("getAppStatus status = " + appStatus);
            return (T) Integer.valueOf(appStatus);
        }
        if (i == 40010) {
            NativeUnifiedADData nativeUnifiedADData10 = this.f1003a;
            T t2 = (T) Boolean.valueOf(nativeUnifiedADData10 != null ? nativeUnifiedADData10.isValid() : false);
            t.a("isValid  flag  = " + t2);
            return t2;
        }
        if (i == 40054) {
            T t3 = (T) Boolean.valueOf(((View) MediationValueUtil.objectValue(sparseArray.get(PtgErrorCode.SDK_DP_PERMISSION_PROHIBIT), View.class, null)) instanceof NativeAdContainer);
            t.a("isNativeAdContainer  flag  = " + t3);
            return t3;
        }
        if (i == 40055) {
            Context context = (Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null);
            t.a("createNativeContainer  context  = " + context);
            if (context != null) {
                return (T) new NativeAdContainer(context);
            }
        } else if (i == 40056) {
            Context context2 = (Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null);
            ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(PtgErrorCode.SDK_DP_PERMISSION_PROHIBIT), ViewGroup.class, null);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) MediationValueUtil.objectValue(sparseArray.get(50017), FrameLayout.LayoutParams.class, null);
            List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(50018), List.class, null);
            List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(50019), List.class, null);
            t.a("bindToView context = " + context2 + " container = " + viewGroup + " logoParams = " + layoutParams + " clickViews = " + list + " createViews = " + list2);
            NativeUnifiedADData nativeUnifiedADData11 = this.f1003a;
            if (nativeUnifiedADData11 != null && (viewGroup instanceof NativeAdContainer)) {
                nativeUnifiedADData11.bindAdToView(context2, (NativeAdContainer) viewGroup, layoutParams, list, list2);
            }
        } else if (i == 40057) {
            Context context3 = (Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null);
            t.a("getMediaView  context  = " + context3);
            if (context3 != null) {
                return (T) new MediaView(context3);
            }
        } else if (i == 40058) {
            ViewGroup viewGroup2 = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(PtgErrorCode.SDK_DP_PERMISSION_PROHIBIT), ViewGroup.class, null);
            Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(50020), Object.class, null);
            t.a("bindMediaView  mediaView  = " + viewGroup2 + " VideoOption = " + objObjectValue);
            VideoOption videoOptionBuild = new VideoOption.Builder().build();
            if (objObjectValue instanceof VideoOption) {
                videoOptionBuild = (VideoOption) objObjectValue;
            }
            if ((viewGroup2 instanceof MediaView) && (nativeUnifiedADData = this.f1003a) != null) {
                nativeUnifiedADData.bindMediaView((MediaView) viewGroup2, videoOptionBuild, this.d);
            }
        } else if (i == 40059) {
            List<View> list3 = (List) MediationValueUtil.objectValue(sparseArray.get(50021), List.class, null);
            t.a("bindCtaViews  ctaViews  = " + list3);
            NativeUnifiedADData nativeUnifiedADData12 = this.f1003a;
            if (nativeUnifiedADData12 != null) {
                nativeUnifiedADData12.bindCTAViews(list3);
            }
        } else if (i == 40060) {
            t.a("setNativeAdEventListener");
            i();
        } else if (i == 40009) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
        } else {
            if (i == 40021) {
                NativeUnifiedADData nativeUnifiedADData13 = this.f1003a;
                int adPatternType = nativeUnifiedADData13 != null ? nativeUnifiedADData13.getAdPatternType() : 0;
                t.a("getAdPatternType adPatternType = " + adPatternType);
                return (T) Integer.valueOf(adPatternType);
            }
            if (i == 40015) {
                T t4 = (T) e();
                t.a("getExtraInfo  map  = " + t4);
                return t4;
            }
            if (i == 40061) {
                t.a("onResume");
                NativeUnifiedADData nativeUnifiedADData14 = this.f1003a;
                if (nativeUnifiedADData14 != null) {
                    nativeUnifiedADData14.resume();
                }
            } else if (i == 40062) {
                t.a("onPause");
                NativeUnifiedADData nativeUnifiedADData15 = this.f1003a;
                if (nativeUnifiedADData15 != null) {
                    nativeUnifiedADData15.pauseVideo();
                }
            } else if (i == 40011) {
                t.a("onDestroy");
                d();
            } else {
                if (i == 40012) {
                    T t5 = (T) Boolean.valueOf(this.c);
                    t.a("hasDestroy  flag  = " + t5);
                    return t5;
                }
                if (i == 40063) {
                    t.a("pauseAppDownload");
                    NativeUnifiedADData nativeUnifiedADData16 = this.f1003a;
                    if (nativeUnifiedADData16 != null) {
                        nativeUnifiedADData16.pauseAppDownload();
                    }
                } else if (i == 40064) {
                    t.a("resumeAppDownload");
                    NativeUnifiedADData nativeUnifiedADData17 = this.f1003a;
                    if (nativeUnifiedADData17 != null) {
                        nativeUnifiedADData17.resumeAppDownload();
                    }
                } else if (i == 40013) {
                    int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("sendWinNotification  ecpm  = " + iIntValue);
                    a(iIntValue);
                } else if (i == 40014) {
                    Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null);
                    t.a("sendLossNotification  map  = " + map);
                    a(map);
                } else if (i == 40065) {
                    t.a("negativeFeedback");
                    NativeUnifiedADData nativeUnifiedADData18 = this.f1003a;
                    if (nativeUnifiedADData18 != null) {
                        nativeUnifiedADData18.negativeFeedback();
                    }
                } else if (i == 40007 && this.f1003a != null) {
                    int iIntValue2 = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("setBidECPM ecpm = " + iIntValue2);
                    this.f1003a.setBidECPM(iIntValue2);
                }
            }
        }
        return null;
    }

    public void b() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60004);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void c() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60005);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
