package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class j extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnifiedInterstitialAD f998a;
    private Function<SparseArray<Object>, Object> b;
    private i c;
    private UnifiedInterstitialADListener d = new UnifiedInterstitialADListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.j.1
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            t.a("onADClicked");
            if (j.this.c != null) {
                j.this.c.b();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            t.a("onADClose");
            if (j.this.c != null) {
                j.this.c.d();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            t.a("onADExposure");
            if (j.this.c != null) {
                j.this.c.a();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            t.a("adn onADReceive");
            j.this.b();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            t.a("adnOnError adError = " + adError);
            j.this.a(adError);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            t.a("adn onVideoCached");
            j.this.c();
        }
    };

    private void a() {
        if (this.c == null) {
            this.c = new i(this.f998a);
        }
    }

    private void a(Context context, String str) {
        t.a("createUnifiedInterstitialAD context = " + context + " adnId = " + str);
        if (context instanceof Activity) {
            this.f998a = new UnifiedInterstitialAD((Activity) context, str, this.d);
            if (Thread.currentThread().getName().equals("gm_t_main")) {
                return;
            }
            com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PtgErrorCode.SDK_CLICK_ERR));
            sparseArray.put(-99999985, null);
            sparseArray.put(50006, new h(adError));
            this.b.apply(sparseArray);
        }
    }

    private void a(Object obj) {
        t.a("loadFullScreenAD ad bridge = " + obj);
        if (this.f998a != null) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.f998a.loadFullScreenAD();
        }
    }

    private void a(String str, String str2) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        t.a("setServerSideVerificationOptions userId = " + str + " customStr = " + str2);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (str != null) {
            builder.setUserId(str);
        }
        if (str2 != null) {
            builder.setCustomData(str2);
        }
        if ((str == null && TextUtils.isEmpty(str2)) || (unifiedInterstitialAD = this.f998a) == null) {
            return;
        }
        unifiedInterstitialAD.setServerSideVerificationOptions(builder.build());
    }

    private void a(Map<String, Object> map) {
        t.a("setVideoOption map = " + map);
        VideoOption videoOptionBuild = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                videoOptionBuild = (VideoOption) obj;
            }
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.f998a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(videoOptionBuild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            a();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60008);
            sparseArray.put(-99999985, null);
            sparseArray.put(50005, this.c);
            this.b.apply(sparseArray);
        }
    }

    private void b(Map<String, Object> map) {
        int iIntValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        t.a("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0 || (unifiedInterstitialAD = this.f998a) == null) {
                return;
            }
            unifiedInterstitialAD.setMaxVideoDuration(iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b != null) {
            a();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60003);
            sparseArray.put(-99999985, null);
            sparseArray.put(50005, this.c);
            this.b.apply(sparseArray);
        }
    }

    private void c(Map<String, Object> map) {
        int iIntValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        t.a("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0 || (unifiedInterstitialAD = this.f998a) == null) {
                return;
            }
            unifiedInterstitialAD.setMinVideoDuration(iIntValue);
        }
    }

    private void d(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40017) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null));
        } else if (i == 40018) {
            a((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40019) {
            b((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40020) {
            c((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40001) {
            a((String) MediationValueUtil.objectValue(sparseArray.get(50003), String.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50004), String.class, null));
        } else if (i == 40002) {
            a(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null));
        } else if (i == 40025) {
            d((Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        }
        return null;
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
