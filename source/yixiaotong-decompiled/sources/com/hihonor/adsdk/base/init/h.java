package com.hihonor.adsdk.base.init;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.q0;
import com.hihonor.adsdk.base.mediation.adn.AdnAdapter;
import com.hihonor.adsdk.base.net.resp.InitResp;
import com.hihonor.adsdk.base.net.resp.ThirdPlatform;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.z;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsa = "SdkConfig";
    private static final int hnadsb = 0;
    private static final int hnadsc = 1;
    private static final int hnadsd = 2;
    private static final int hnadse = 3;
    private static InitResp.Media hnadsf = null;
    private static final AtomicInteger hnadsg = new AtomicInteger(0);
    private static int hnadsh = 0;
    private static final int hnadsi = 3;
    private static final int hnadsj = 3000;

    class a implements com.hihonor.adsdk.base.callback.e<InitResp> {
        a() {
        }

        @Override // com.hihonor.adsdk.base.callback.e
        public void hnadsa(InitResp initResp) {
            com.hihonor.adsdk.common.b.b.hnadsc(h.hnadsa, "init success", new Object[0]);
            if (initResp == null || initResp.media == null) {
                h.hnadsb(String.valueOf(30001), "init resp is null");
            } else {
                h.hnadsb(initResp);
                i.hnadsa(initResp);
            }
        }

        @Override // com.hihonor.adsdk.base.callback.e
        public void hnadsa(String str, Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsc(h.hnadsa, "init error:" + th.getMessage(), new Object[0]);
            h.hnadsb(String.valueOf(30001), z.hnadsa(str, th.getMessage()));
        }
    }

    public static InitResp.Media hnadsa() {
        return hnadsf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsb(InitResp initResp) {
        hnadsa(initResp.media);
        hnadsa(initResp.thirdPlatforms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsc() {
        AtomicInteger atomicInteger = hnadsg;
        if (2 == atomicInteger.get() || 1 == atomicInteger.get()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "init is pendding or sucess state: " + atomicInteger.get(), new Object[0]);
            return;
        }
        if (!com.hihonor.adsdk.base.net.i.hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "initAd#network disabled", new Object[0]);
            hnadsb(String.valueOf(30001), z.hnadsa(1012, new Throwable("init error,NOT_NETWORK").getMessage()));
            return;
        }
        if (HnAds.get().getCfg() == null || TextUtils.isEmpty(HnAds.get().getCfg().getAppId())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "cfg is null or appid is empty", new Object[0]);
            return;
        }
        hnadsa(1);
        InitResp initRespHnadsb = i.hnadsb();
        if (i.hnadsa(initRespHnadsb, HnAds.get().getCfg().getAppId())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startReq#No initial network requests are required", new Object[0]);
            hnadsb(initRespHnadsb);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startReq#Start initializing network requests, initNumber=%s", Integer.valueOf(hnadsh));
            com.hihonor.adsdk.base.h.f.hnadsa().hnadsa(HnAds.get().getContext(), new a());
        }
    }

    public static void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("reqConfig start :" + str));
        if (!b.hnadsc().hnadsg()) {
            b.hnadsc().hnadsa(new InitCallback() { // from class: com.hihonor.adsdk.base.init.h$$ExternalSyntheticLambda1
                @Override // com.hihonor.adsdk.base.init.InitCallback
                public final void onResult() {
                    h.hnadsc();
                }
            });
        } else {
            hnadsc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsb(String str, String str2) {
        hnadsa(3);
        new q0(0, str, str2).hnadse();
        if (!com.hihonor.adsdk.base.net.i.hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onFailed: no network", new Object[0]);
            return;
        }
        int i = hnadsh + 1;
        hnadsh = i;
        if (i <= 3) {
            a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.init.h$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    h.hnadsc();
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    private static void hnadsa(List<ThirdPlatform> list) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            return;
        }
        for (ThirdPlatform thirdPlatform : list) {
            if ("1".equals(thirdPlatform.thirdPlatformId) && !TextUtils.isEmpty(thirdPlatform.thirdMediaId)) {
                AdnAdapter.initCJS(HnAds.get().getContext(), thirdPlatform.thirdMediaId);
                return;
            }
        }
    }

    public static synchronized boolean hnadsb() {
        AtomicInteger atomicInteger;
        StringBuilder sb = new StringBuilder("isInitSuccess  state=");
        atomicInteger = hnadsg;
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) sb.append(atomicInteger.get()).toString());
        return 2 == atomicInteger.get();
    }

    private static void hnadsb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HnAds.get().updateConfig(new HnAdConfig.Builder(HnAds.get().getCfg()).setWxOpenAppId(str).build());
    }

    private static synchronized void hnadsa(InitResp.Media media) {
        hnadsf = media;
        if (media.enable == 1) {
            hnadsb(media.appIdWx);
            hnadsa(2);
        } else {
            hnadsb(String.valueOf(ErrorCode.AD_MEDIA_DISABLE), "media disable");
        }
    }

    private static synchronized void hnadsa(int i) {
        hnadsg.set(i);
    }
}
