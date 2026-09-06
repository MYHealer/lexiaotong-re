package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RewardVideoADListener f1012a = new RewardVideoADListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.q.1
        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            t.a("adn onADClick");
            if (q.this.d != null) {
                q.this.d.b();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            t.a("adn onADClose");
            if (q.this.d != null) {
                q.this.d.d();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            t.a("adn onADLoad");
            q.this.b();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            t.a("adn onADShow");
            if (q.this.d != null) {
                q.this.d.a();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            t.a("adnOnError adError = " + adError);
            q.this.a(adError);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            t.a("adn onReward map = " + map);
            if (q.this.d != null) {
                q.this.d.a(map);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            t.a("adn onVideoCached");
            q.this.c();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            t.a("adn onVideoComplete");
            if (q.this.d != null) {
                q.this.d.c();
            }
        }
    };
    private RewardVideoAD b;
    private Function<SparseArray<Object>, Object> c;
    private p d;

    private void a() {
        if (this.d == null) {
            this.d = new p(this.b);
        }
    }

    private void a(Context context, String str, boolean z, String str2) {
        t.a("createRewardVideoAd context = " + context + " adnId = " + str + " volumeOn = " + z + " adm = " + str2);
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                this.b = new RewardVideoAD(context, str, this.f1012a, z);
            } else {
                this.b = new RewardVideoAD(context, str, this.f1012a, z, str2);
            }
            if (Thread.currentThread().getName().equals("gm_t_main")) {
                return;
            }
            com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PtgErrorCode.SDK_CLICK_ERR));
            sparseArray.put(-99999985, null);
            sparseArray.put(50006, new h(adError));
            this.c.apply(sparseArray);
        }
    }

    private void a(Object obj) {
        t.a("load ad bridge = " + obj);
        if (this.b != null) {
            this.c = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.b.loadAD();
        }
    }

    private void a(String str, String str2) {
        RewardVideoAD rewardVideoAD;
        t.a("setServerSideVerificationOptions userId = " + str + " customStr = " + str2);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (str != null) {
            builder.setUserId(str);
        }
        if (str2 != null) {
            builder.setCustomData(str2);
        }
        if ((str == null && TextUtils.isEmpty(str2)) || (rewardVideoAD = this.b) == null) {
            return;
        }
        rewardVideoAD.setServerSideVerificationOptions(builder.build());
    }

    private void a(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            a();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60000);
            sparseArray.put(-99999985, null);
            sparseArray.put(50005, this.d);
            this.c.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            a();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60003);
            sparseArray.put(-99999985, null);
            sparseArray.put(50005, this.d);
            this.c.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40000) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null), !((Boolean) MediationValueUtil.objectValue(sparseArray.get(50001), Boolean.class, false)).booleanValue(), (String) MediationValueUtil.objectValue(sparseArray.get(50002), String.class, null));
        } else if (i == 40001) {
            a((String) MediationValueUtil.objectValue(sparseArray.get(50003), String.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50004), String.class, null));
        } else if (i == 40002) {
            a(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null));
        } else if (i == 40025) {
            a((Map<String, String>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
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
