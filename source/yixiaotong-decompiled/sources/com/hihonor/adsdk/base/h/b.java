package com.hihonor.adsdk.base.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.init.InitCallback;
import com.hihonor.adsdk.base.init.i;
import com.hihonor.adsdk.base.net.ApiResult;
import com.hihonor.adsdk.base.net.request.BaseRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b implements d {
    private static final String hnadsh = "AdRequest";
    protected final Handler hnadsa = new Handler(Looper.getMainLooper());
    protected final AtomicBoolean hnadsb = new AtomicBoolean(false);
    protected long hnadsc;
    protected int hnadsd;
    protected com.hihonor.adsdk.base.callback.f hnadse;
    private com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> hnadsf;
    protected String hnadsg;

    public b(int i) {
        this.hnadsd = i;
    }

    private void hnadsb(final long j) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "Send timeout msg, media set ad timeout millis is %s ms", Long.valueOf(j));
        if (j <= 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "timeout millis is 0 ms.", new Object[0]);
        } else {
            this.hnadsa.removeCallbacksAndMessages(null);
            this.hnadsa.postDelayed(new Runnable() { // from class: com.hihonor.adsdk.base.h.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(j);
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hnadsd, reason: merged with bridge method [inline-methods] */
    public void hnadsc(com.hihonor.adsdk.base.bean.a aVar) {
        Context context = HnAds.get().getContext();
        AdSlot adSlotHnadsa = aVar.hnadsa();
        BaseRequest baseRequestHnadsa = com.hihonor.adsdk.base.net.request.a.hnadsa(adSlotHnadsa, aVar.hnadsb());
        RequestBody requestBodyHnadsa = com.hihonor.adsdk.base.net.request.a.hnadsa(context, baseRequestHnadsa);
        this.hnadsg = aVar.hnadsd();
        com.hihonor.adsdk.base.net.e eVarHnadsa = hnadsa(context, baseRequestHnadsa);
        this.hnadsc = System.currentTimeMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "AdRepository#requestAdInfo#Start load ad", new Object[0]);
        com.hihonor.adsdk.base.bean.b bVarHnadsa = new com.hihonor.adsdk.base.bean.b.a().hnadsa(aVar.hnadsb()).hnadsd(adSlotHnadsa.getLoadType()).hnadsb(this.hnadsg).hnadsc(adSlotHnadsa.getSlotId()).hnadsc(com.hihonor.adsdk.base.b.hnadsa(adSlotHnadsa)).hnadsb(adSlotHnadsa.getTimeOutMillis()).hnadse(adSlotHnadsa.getRenderType()).hnadsa(this.hnadsc).hnadsb(adSlotHnadsa.getDataType()).hnadsa(com.hihonor.adsdk.base.g.c.hnadsa(adSlotHnadsa)).hnadsa(hnadsb()).hnadsa();
        if (i.hnadsa(adSlotHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "is polymerization ad load", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "is honor ad load", new Object[0]);
            hnadsb(adSlotHnadsa.getTimeOutMillis());
        }
        com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVarHnadsc = aVar.hnadsc();
        this.hnadsf = eVarHnadsc;
        this.hnadse = new com.hihonor.adsdk.base.callback.f(bVarHnadsa, eVarHnadsc);
        hnadsa(eVarHnadsa, requestBodyHnadsa);
    }

    protected abstract String hnadsa();

    @Override // com.hihonor.adsdk.base.h.d
    public void hnadsa(final com.hihonor.adsdk.base.bean.a aVar) {
        if (!hnadsb(aVar)) {
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(aVar.hnadsd());
        } else if (com.hihonor.adsdk.base.init.b.hnadsc().hnadsg()) {
            hnadsc(aVar);
        } else {
            com.hihonor.adsdk.base.init.b.hnadsc().hnadsa(new InitCallback() { // from class: com.hihonor.adsdk.base.h.b$$ExternalSyntheticLambda1
                @Override // com.hihonor.adsdk.base.init.InitCallback
                public final void onResult() {
                    this.f$0.hnadsc(aVar);
                }
            });
        }
    }

    protected abstract void hnadsa(com.hihonor.adsdk.base.net.e eVar, RequestBody requestBody, com.hihonor.adsdk.base.net.f<BaseAdInfoResp> fVar);

    protected abstract boolean hnadsb();

    class a implements com.hihonor.adsdk.base.net.f<BaseAdInfoResp> {
        a() {
        }

        @Override // com.hihonor.adsdk.base.net.f
        public void hnadsa(ApiResult<BaseAdInfoResp> apiResult) {
            b.this.hnadsa.removeCallbacksAndMessages(null);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsh, "Ads response success time consuming is %s. isTimeout= %s", Long.valueOf(System.currentTimeMillis() - b.this.hnadsc), Boolean.valueOf(b.this.hnadsb.get()));
            b bVar = b.this;
            bVar.hnadse.hnadsa(apiResult, bVar.hnadsb.get());
        }

        @Override // com.hihonor.adsdk.base.net.f
        public void hnadsa(String str, Throwable th) {
            b.this.hnadsa.removeCallbacksAndMessages(null);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsh, "Ads response fail time consuming is %s. isTimeout= %s", Long.valueOf(System.currentTimeMillis() - b.this.hnadsc), Boolean.valueOf(b.this.hnadsb.get()));
            b bVar = b.this;
            bVar.hnadse.hnadsa(str, th, bVar.hnadsb.get());
        }
    }

    protected com.hihonor.adsdk.base.net.e hnadsa(Context context, BaseRequest baseRequest) {
        return com.hihonor.adsdk.base.net.request.a.hnadsa(context, hnadsa(), baseRequest.getJsonCache(), this.hnadsg);
    }

    private boolean hnadsb(com.hihonor.adsdk.base.bean.a aVar) {
        if (com.hihonor.adsdk.base.net.i.hnadsc()) {
            return true;
        }
        com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVarHnadsc = aVar.hnadsc();
        if (eVarHnadsc != null) {
            eVarHnadsc.hnadsa(String.valueOf(1012), new Throwable(ErrorCode.NOT_NETWORK_MSG));
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsh, ErrorCode.NOT_NETWORK_MSG, new Object[0]);
        return false;
    }

    protected void hnadsa(com.hihonor.adsdk.base.net.e eVar, RequestBody requestBody) {
        com.hihonor.adsdk.common.b.b.hnadsc("ApiCall", "AdRequest开始请求", new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsg, 1);
        hnadsa(eVar, requestBody, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(long j) {
        this.hnadsb.set(true);
        String str = String.format("Ad response timed out, timeout: %s", Long.valueOf(j));
        com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar = this.hnadsf;
        if (eVar != null) {
            eVar.hnadsa(String.valueOf(ErrorCode.AD_LOADING_TIME_OUT), new Throwable(str));
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, str, new Object[0]);
    }
}
