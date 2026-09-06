package com.byazt.ac;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.aas.nb;
import com.byazt.aas.qp;
import com.byazt.ddx.a;
import com.byazt.ddx.da;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.xd;
import com.byazt.fcd.n;
import com.byazt.go.AbstractEndCardFrameLayout;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.d;
import com.byazt.wz.x;
import com.byazt.xl.yp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 89, 13})
public class tt extends c {
    public double d;
    public double eo;
    public double h;
    public double md;
    public boolean or;
    public final com.byazt.at.tt p;
    public final com.byazt.bd.c yv;
    public String zb;
    public final Map<String, Bitmap> zm;

    @Override // com.byazt.ac.c
    public String gr() {
        return "endcard";
    }

    public tt(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, icVar, str, i, i2, z);
        this.zm = new HashMap();
        this.yv = new com.byazt.bd.c() { // from class: com.byazt.ac.tt.1
            @Override // com.byazt.bd.c
            public void c() {
                tt.this.c.x(1);
            }
        };
        this.p = new com.byazt.at.tt() { // from class: com.byazt.ac.tt.2
            @Override // com.byazt.at.tt
            public void c(boolean z2, int i3, String str2) {
                if (z2) {
                    tt.this.m = true;
                    if (tt.this.or) {
                        tt ttVar = tt.this;
                        ttVar.c(ttVar.md, tt.this.h, tt.this.d, tt.this.eo, tt.this.zb);
                        tt.this.or = false;
                    }
                }
                if (xd.sl(tt.this.tt)) {
                    tt.this.c(z2, i3, str2);
                }
                if (tt.this.sp != null) {
                    if (tt.this.sp.getVisibility() == 0) {
                        tt.this.x.a(true);
                        tt.this.c(true);
                        tt.this.c(false, true);
                    } else {
                        tt.this.x.a(false);
                        tt.this.c(false);
                        tt.this.c(true, false);
                    }
                }
            }
        };
        this.sp = abstractEndCardFrameLayout.getEndCardWebView();
        c();
    }

    @Override // com.byazt.ac.c
    public void c(boolean z, Map<String, Object> map, View view) {
        String str;
        if (this.sp == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.i = new da(this.ve, this.tt, jSONObject, null);
        this.i.c(jSONObject, "webview_source", (Object) 2);
        this.t = new a(this.tt, this.sp).tt(true);
        this.t.c(true);
        h();
        a aVar = this.t;
        if (p()) {
            str = "landingpage_endcard";
        } else {
            str = z ? "reward_endcard" : "fullscreen_endcard";
        }
        aVar.c(str);
        this.x = new d(this.c);
        this.x.tt(this.sp).c(this.tt).tt(this.tt.uj()).uj(this.tt.w_()).ve(z ? 7 : 5).c(this.gu).n(nb.my(this.tt)).c(this.sp).tt(x.c(this.tt)).c(this.i).c(this.ve).c(map).c(this.gr).c(view).ve(this.c.c()).c(this.yv);
        this.x.c(this.p);
    }

    private void h() {
        float fFr = this.tt.fr();
        this.da = xd.i(this.tt);
        if (TextUtils.isEmpty(this.da)) {
            return;
        }
        this.da = this.da.trim();
        Uri.Builder builderBuildUpon = Uri.parse(this.da).buildUpon();
        if (this.my == 1) {
            builderBuildUpon.appendQueryParameter("orientation", "portrait");
        }
        this.da = builderBuildUpon.appendQueryParameter("height", String.valueOf(this.rl)).appendQueryParameter("width", String.valueOf(this.gt)).appendQueryParameter("aspect_ratio", String.valueOf(fFr)).toString();
        this.da = com.byazt.biq.c.c(this.da);
        this.da = qp.ve(this.da);
    }

    @Override // com.byazt.ac.c
    public void c(DownloadListener downloadListener, com.byazt.hkv.tt ttVar) {
        if (this.sp == null) {
            return;
        }
        this.sl = new com.byazt.jwd.uj(this.c, this.x, this.tt.uj(), this.t) { // from class: com.byazt.ac.tt.3
            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseC = tt.this.c(str);
                return webResourceResponseC != null ? webResourceResponseC : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (tt.this.tt != null) {
                        WebResourceResponse webResourceResponseC = tt.this.c(string);
                        if (webResourceResponseC != null) {
                            return webResourceResponseC;
                        }
                        if (TextUtils.isEmpty(tt.this.tt.ve())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        tt.this.n++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    m.ve("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                tt.this.nu.set(false);
                tt.this.rh = this.x;
                tt.this.u = i;
                tt.this.yp = str;
                if (tt.this.i != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put("msg", str);
                        tt.this.i.tt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    tt.this.nu.set(false);
                    tt.this.rh = this.x;
                }
                if (tt.this.i != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put("msg", webResourceError.getDescription());
                        tt.this.i.tt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                tt.this.u = webResourceError.getErrorCode();
                tt.this.yp = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (tt.this.i != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        tt.this.i.tt(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (tt.this.da.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        tt.this.nu.set(false);
                        tt.this.rh = this.x;
                    }
                    if (webResourceResponse != null) {
                        tt.this.u = webResourceResponse.getStatusCode();
                        tt.this.yp = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (tt.this.i != null) {
                    tt.this.i.sp();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (tt.this.i != null) {
                    tt.this.i.a();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.sp.setWebViewClient(this.sl);
        c(this.sp);
        this.sp.setBackgroundColor(-1);
        this.sp.setDisplayZoomControls(false);
        this.sp.setWebChromeClient(new com.byazt.jwd.ve(this.x, this.t) { // from class: com.byazt.ac.tt.4
            @Override // com.byazt.jwd.ve, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.sp.setDownloadListener(downloadListener);
    }

    public boolean p() {
        if (this.da == null) {
            return false;
        }
        try {
            return Uri.parse(this.da).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void md() {
        if (this.z || this.sp == null || this.sp.getWebView() == null) {
            return;
        }
        this.sp.loadUrl(this.da);
        this.z = true;
    }

    @Override // com.byazt.ac.c
    public void c(int i) {
        super.c(i);
        c(true);
        ve(true);
        c(false, true);
    }

    public void c(double d, double d2, double d3, double d4, String str) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        if (!this.m) {
            this.md = d;
            this.h = d2;
            this.eo = d4;
            this.d = d3;
            this.zb = str;
            this.or = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.x.tt("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void c(yp ypVar) {
        double dX;
        double dI;
        double d;
        double dSp;
        if (kp.gr(this.tt)) {
            double d2 = this.gt;
            double d3 = this.rl;
            if (ypVar == null || !this.c.to().sp() || (ypVar.x() == 0.0d && ypVar.i() == 0.0d)) {
                dX = d2;
                dI = d3;
                d = 0.0d;
                dSp = 0.0d;
            } else {
                double dA = ypVar.a();
                d = dA;
                dSp = ypVar.sp();
                dX = ypVar.x();
                dI = ypVar.i();
            }
            c(d, dSp, dX, dI, null);
            if (this.c.to() instanceof n) {
                return;
            }
            final double d4 = d;
            final double d5 = dSp;
            final double d6 = dX;
            final double d7 = dI;
            com.byazt.vv.tt.c(2147483647L, xd.c(this.tt), new com.byazt.vv.tt.InterfaceC0307tt() { // from class: com.byazt.ac.tt.5
                @Override // com.byazt.vv.tt.InterfaceC0307tt
                public void c(Bitmap bitmap) {
                    if (bitmap != null) {
                        String strValueOf = String.valueOf(bitmap.hashCode());
                        tt.this.zm.put(strValueOf, bitmap);
                        tt.this.c(d4, d5, d6, d7, strValueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse c(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.zm.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    @Override // com.byazt.ac.c
    public void z() {
        super.z();
        this.zm.clear();
    }
}
