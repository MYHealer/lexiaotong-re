package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bs implements ExpressResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1754a;
    private int b = 1;
    private ExpressResponse.ExpressInteractionListener c;
    private ExpressResponse.ExpressAdDownloadWindowListener d;
    private ExpressResponse.ExpressDislikeListener e;
    private ExpressResponse.ExpressCloseListener f;
    private final dg g;
    private final a h;
    private ViewGroup i;
    private ExpressAdData j;
    private String k;

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.k = str;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.c = expressInteractionListener;
    }

    public bs(Context context, dg dgVar, a aVar) {
        this.f1754a = context;
        this.g = dgVar;
        this.h = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.i == null && (aVar = this.h) != null) {
            this.i = this.g.a(aVar);
        }
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setExpectedSizePixel(int i, int i2) {
        dg dgVar = this.g;
        if (dgVar != null) {
            dgVar.a(i, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i) {
        dg dgVar = this.g;
        if (dgVar != null) {
            return dgVar.a(this.i, this.h, i);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dg dgVar = this.g;
        if (dgVar != null) {
            dgVar.b(activity);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dg dgVar = this.g;
        if (dgVar == null || (aVar = this.h) == null) {
            return;
        }
        if (this.i == null) {
            this.i = dgVar.a(aVar);
        }
        this.g.a(this.i, this.h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void destroy() {
        a aVar;
        ViewGroup viewGroup;
        dg dgVar = this.g;
        if (dgVar == null || (aVar = this.h) == null || (viewGroup = this.i) == null) {
            return;
        }
        dgVar.b(viewGroup, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isReady(Context context) {
        return this.h != null && System.currentTimeMillis() - this.h.z() <= this.h.K();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.h != null && System.currentTimeMillis() - this.h.z() <= this.h.K();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.h;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getPECPM() {
        a aVar = this.h;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dg dgVar;
        a aVar = this.h;
        if (aVar == null || (dgVar = this.g) == null) {
            return;
        }
        dgVar.a(aVar.M(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (this.g != null) {
            String strM = this.k;
            a aVar = this.h;
            if (aVar != null) {
                strM = aVar.M();
            }
            this.g.a(strM, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.h == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.h.Z();
        }
        return this.h.a(str);
    }

    public String a() {
        a aVar = this.h;
        return aVar != null ? aVar.M() : "";
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void a(View view, int i, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i, i2);
        }
    }

    public void a(View view, String str, int i) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i);
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void b(String str) {
        if (this.h != null && this.g != null) {
            this.j = new ExpressAdData(this.h, this.g.g());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    public void b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }
}
