package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class df extends bj {
    private ExpressInterstitialListener A;
    private ExpressInterstitialAd.InterAdDownloadWindowListener B;
    private ExpressInterstitialAd.InterstitialAdDislikeListener C;
    private a D;
    private boolean E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RelativeLayout f1805a;
    public boolean t;
    public boolean u;
    private int v;
    private String w;
    private String x;
    private int y;
    private int z;

    public void a(int i) {
        this.v = i;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.B = interAdDownloadWindowListener;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.C = interstitialAdDislikeListener;
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.A = expressInterstitialListener;
    }

    public void b(boolean z) {
        this.E = z;
    }

    public void c(boolean z) {
        this.F = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(String str) {
    }

    public String e() {
        return this.w;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(String str) {
    }

    public boolean f() {
        return this.u;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void v() {
    }

    public a x() {
        return this.D;
    }

    public df(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.v = 8000;
        this.w = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.y = 600;
        this.z = 500;
        this.E = false;
        this.f1805a = relativeLayout;
        this.x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.u = false;
        this.n = true;
        this.m.loadAd(j(), k());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.y = width;
            this.z = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.w);
            this.m.createProdHandler(jSONObject2);
            this.m.setAdContainer(this.f1805a);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.w);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.x);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            if (cs.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + bb.b(this.i));
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + bb.c(this.i));
            jSONObject.put("msa", 159);
            jSONObject.put("opt", 1);
            jSONObject = m.a(jSONObject, b(this.o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.t);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.E);
            jSONObject.put("use_dialog_container", this.F);
            jSONObject.put("timeout", this.v);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, int i, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i, str);
        }
        super.a(str, i, str2);
    }

    public void g() {
        if (this.m != null) {
            this.m.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i, String str, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i, str);
        }
        super.a(i, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        this.u = false;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.C;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        List<a> listA;
        if (iOAdEvent != null && (listA = b.a(iOAdEvent.getMessage()).a()) != null && listA.size() > 0) {
            this.D = listA.get(0);
        }
        this.u = true;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_d_t", motionEvent.getDownTime());
            jSONObject.put("e_e_t", motionEvent.getEventTime());
            jSONObject.put("e_a", motionEvent.getAction());
            jSONObject.put("e_x", motionEvent.getX());
            jSONObject.put("e_y", motionEvent.getY());
            jSONObject.put("e_m_s", motionEvent.getMetaState());
            jSONObject.put("event_type", "x_event");
            a(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.D;
        if (aVar != null) {
            a(aVar.M(), z, linkedHashMap, biddingListener);
        } else {
            a(this.j, z, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.o = m.a(map);
        } catch (Throwable unused) {
            this.o = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.D == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.D.Z();
        }
        return this.D.a(str);
    }
}
