package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.common.f.a0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class e extends com.hihonor.adsdk.base.api.b<PictureTextAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3544a = "PictureTextAdLoadImpl";

    e() {
    }

    private void a(final List<PictureTextExpressAd> list) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.picturetextad.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        if (this.hnadsb != 0) {
            ((PictureTextAdLoadListener) this.hnadsb).onAdLoaded(list);
            this.hnadsb = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp) {
        Video video;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BaseAdInfo baseAdInfo : baseAdInfoResp.getList()) {
            BaseAdImpl baseAdImpl = new BaseAdImpl(baseAdInfo);
            if ((baseAdImpl.getSubType() == 11 || baseAdImpl.getSubType() == 12) && (video = baseAdImpl.getVideo()) != null) {
                hnadsc(video.getVideoUrl());
            }
            PictureTextExpressAdImpl pictureTextExpressAdImpl = new PictureTextExpressAdImpl(baseAdInfo);
            pictureTextExpressAdImpl.setRenderType(this.hnadsa.getRenderType());
            arrayList.add(pictureTextExpressAdImpl);
            arrayList2.add(baseAdInfo.getAdId());
        }
        a(arrayList);
        a(baseAdInfoResp, arrayList2);
        hnadsn();
        AdSlot adSlot = this.hnadsa;
        hnadsa(baseAdInfoResp, adSlot != null ? adSlot.getDataType() : 0);
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected int hnadsb() {
        return 2;
    }

    @Override // com.hihonor.adsdk.base.api.b
    public boolean hnadsh() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected boolean hnadsk() {
        com.hihonor.adsdk.common.b.b.hnadsc(f3544a, "isSupportPreCache: false", new Object[0]);
        return false;
    }

    private void a(BaseAdInfoResp baseAdInfoResp, List<String> list) {
        String strHnadsa = com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp);
        String strHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.bean.b bVarHnadsb = hnadsb(strHnadsa);
        new com.hihonor.adsdk.base.g.j.d.j1.f(bVarHnadsb, list, strHnadsa, com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVarHnadsb, strHnadsb)).hnadse();
    }
}
