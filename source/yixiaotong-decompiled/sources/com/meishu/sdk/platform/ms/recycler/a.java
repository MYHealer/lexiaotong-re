package com.meishu.sdk.platform.ms.recycler;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MeishuAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.meishu.sdk.meishu_ad.nativ.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.ad.recycler.a f5184a;
    public c b;
    public volatile boolean c;

    public a(c cVar, com.meishu.sdk.core.ad.recycler.a aVar) {
        this.b = cVar;
        this.f5184a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
        boolean z;
        List<com.meishu.sdk.meishu_ad.nativ.b> list2 = list;
        try {
            if (this.f5184a == null || list2 == null) {
                return;
            }
            int drawing = ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getDrawing();
            int i = 0;
            if (this.b.getAdLoader() instanceof RecyclerMixAdLoader) {
                z = true;
                if (drawing == 1) {
                    z = false;
                }
            } else {
                z = false;
            }
            ArrayList arrayList = new ArrayList();
            for (com.meishu.sdk.meishu_ad.nativ.b bVar : list2) {
                if (z) {
                    arrayList.add(new i(this.b, bVar, i));
                } else {
                    arrayList.add(new l(this.b, bVar, i));
                }
                i++;
            }
            this.f5184a.onAdReady(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        try {
            if (((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getErrorUrl() != null) {
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            com.meishu.sdk.core.ad.recycler.a aVar = this.f5184a;
            if (aVar != null) {
                aVar.onAdPlatformError(new com.meishu.sdk.platform.ms.d(str, Integer.valueOf(i)));
                this.f5184a.onAdRenderFail(str, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADExposure() {
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            u0.a(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getPosId(), 3);
            String[] monitorUrl = ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getMonitorUrl();
            if (monitorUrl != null) {
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        int act_type = ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getAct_type();
                        if ((act_type & 2) == 2) {
                            act_type = (act_type - 2) | 1;
                        }
                        z.a(this.b.getContext(), h0.a(h0.a(str, act_type, AdType.FEED_MIX)), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            com.meishu.sdk.core.ad.recycler.a aVar = this.f5184a;
            if (aVar != null) {
                aVar.onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
