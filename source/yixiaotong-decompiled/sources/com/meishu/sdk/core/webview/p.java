package com.meishu.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.webview.jsbridge.bean.ClickTempParam;

/* JADX INFO: compiled from: WebViewUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p extends com.meishu.sdk.core.webview.listener.e {
    public final /* synthetic */ com.meishu.sdk.platform.ms.c b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, com.meishu.sdk.core.webview.listener.d dVar, com.meishu.sdk.platform.ms.c cVar, Context context) {
        super(dVar);
        this.d = qVar;
        this.b = cVar;
        this.c = context;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void onClosePage() {
        Handler handler = q.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        j jVar = this.d.g;
        if (jVar != null) {
            jVar.onCloseWebView();
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void onWebClicked(ClickTempParam clickTempParam) {
        int webTempId;
        AdSlot adSlotA;
        boolean open_browser = clickTempParam.getOpen_browser();
        com.meishu.sdk.platform.ms.c cVar = this.b;
        if ((cVar instanceof com.meishu.sdk.meishu_ad.nativ.d) && ((com.meishu.sdk.meishu_ad.nativ.d) cVar).f5045a == AdType.REWARD.value() && (adSlotA = this.b.a()) != null) {
            com.meishu.sdk.meishu_ad.nativ.f fVar = (com.meishu.sdk.meishu_ad.nativ.f) adSlotA;
            if (!o.a(fVar.getWebTempUrl()) || fVar.getWebTempId() <= 0) {
                open_browser = true;
            }
        }
        q qVar = this.d;
        Context context = this.c;
        com.meishu.sdk.platform.ms.c cVar2 = this.b;
        qVar.getClass();
        if (cVar2.a() instanceof BaseAdSlot) {
            webTempId = ((BaseAdSlot) cVar2.a()).getWebTempId();
            if (webTempId <= 0) {
                webTempId = ((BaseAdSlot) cVar2.a()).getRewardTmpId();
            }
            int reward_tmp_time = ((BaseAdSlot) cVar2.a()).getReward_tmp_time();
            if (reward_tmp_time > 0) {
                q.j = reward_tmp_time * 1000;
            }
        } else {
            webTempId = 0;
        }
        if (!qVar.d) {
            if (q.i == null) {
                q.i = new Handler();
            }
            q.i.post(qVar.f);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intent intent = new Intent();
        intent.setAction("broadcast_onclick");
        intent.putExtra("clk_act_type", 2);
        intent.putExtra("image_width", displayMetrics.widthPixels);
        intent.putExtra("image_height", displayMetrics.heightPixels);
        intent.putExtra("click_reward_tmp_id", webTempId);
        intent.putExtra("open_loading_page_browser", open_browser);
        com.meishu.sdk.core.event.b.a(context, intent);
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void onWebReady(boolean z) {
        j jVar = this.d.g;
        if (jVar != null) {
            jVar.onWebReady(z);
        }
    }
}
