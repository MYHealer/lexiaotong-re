package com.ubix.ssp.ad.e.c0;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.net.HttpHeaders;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.p;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.ad.e.a0.x;
import com.ubix.ssp.ad.e.z.h;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8811a;
    private b b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebView f8812a;
        final /* synthetic */ Bundle b;
        final /* synthetic */ String c;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.c0.d$a$a, reason: collision with other inner class name */
        class C1093a implements h.c {
            C1093a() {
            }

            @Override // com.ubix.ssp.ad.e.z.h.c
            public void a(h hVar) {
                d.this.d = false;
            }

            @Override // com.ubix.ssp.ad.e.z.h.c
            public void a(h hVar, HashMap<String, String> map) {
                if (TextUtils.isEmpty(a.this.c)) {
                    return;
                }
                Uri uri = Uri.parse(a.this.c);
                String lowerCase = uri.getScheme().toLowerCase();
                if (lowerCase.equals("http") || lowerCase.equals("https")) {
                    a aVar = a.this;
                    aVar.f8812a.loadUrl(aVar.c);
                    d.this.e = true;
                    d.this.b(uri);
                    return;
                }
                String host = uri.getHost();
                if ("ubixad".equals(lowerCase) && "mini_program".equals(host)) {
                    a aVar2 = a.this;
                    int iA = d.this.a(aVar2.c);
                    if (d.this.b != null) {
                        d.this.b.onTwiceClicked(iA);
                    }
                }
                com.ubix.ssp.ad.e.a0.c.a(d.this.f8811a, a.this.c, d.this.b != null ? d.this.b.replacePackageName() : null);
            }

            @Override // com.ubix.ssp.ad.e.z.h.c
            public void b(h hVar) {
                d.this.d = false;
            }

            @Override // com.ubix.ssp.ad.e.z.h.c
            public void c(h hVar) {
            }
        }

        a(WebView webView, Bundle bundle, String str) {
            this.f8812a = webView;
            this.b = bundle;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ubix.ssp.ad.e.a0.c.a(this.f8812a.getContext(), this.b, new C1093a(), (h.b) null);
        }
    }

    public interface b {
        boolean needReplace();

        void onReceivedError(WebView webView, WebResourceRequest webResourceRequest);

        void onTwiceClicked(int i);

        String replacePackageName();

        void setWebViewProgress(int i, boolean z, boolean z2);

        ArrayList<com.ubix.ssp.ad.d.d> shouldCheckRule();
    }

    public d(Context context, b bVar) {
        this.f8811a = context;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return 0;
            }
            Context context = this.f8811a;
            String strD = context != null ? v.d(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ubix_sp_named_wx", "wxid") : null;
            String queryParameter = uri.getQueryParameter("userName");
            String queryParameter2 = uri.getQueryParameter("path");
            String queryParameter3 = uri.getQueryParameter("extData");
            if (TextUtils.isEmpty(strD) || TextUtils.isEmpty(queryParameter)) {
                return 1;
            }
            if (!p.b("com.tencent.mm")) {
                return 2;
            }
            if (!x.a()) {
                return 3;
            }
            x.a(this.f8811a, strD, queryParameter, queryParameter2, queryParameter3);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private ArrayList<com.ubix.ssp.ad.d.d> a(Uri uri) {
        b bVar;
        if (uri == null || (bVar = this.b) == null) {
            return null;
        }
        return bVar.shouldCheckRule();
    }

    private void a(WebView webView, String str) {
        if (this.d) {
            return;
        }
        this.d = true;
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "提示");
        bundle.putString("SUB_TITLE", "即将跳转至三方APP或其他网页，是否继续？");
        bundle.putString("BUTTON_TEXT", "继续前往");
        bundle.putInt("TYPE", 3);
        webView.post(new a(webView, bundle, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Uri uri) {
        ArrayList<com.ubix.ssp.ad.d.d> arrayListA = a(uri);
        if (arrayListA == null || arrayListA.isEmpty()) {
            return;
        }
        Iterator<com.ubix.ssp.ad.d.d> it = arrayListA.iterator();
        while (it.hasNext()) {
            it.next().c(uri.getScheme(), uri.getHost());
        }
    }

    private boolean c(Uri uri) {
        ArrayList<com.ubix.ssp.ad.d.d> arrayListA = a(uri);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            Iterator<com.ubix.ssp.ad.d.d> it = arrayListA.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!it.next().a(uri.getScheme(), uri.getHost())) {
                    z = true;
                }
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    private boolean d(Uri uri) {
        ArrayList<com.ubix.ssp.ad.d.d> arrayListA = a(uri);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            Iterator<com.ubix.ssp.ad.d.d> it = arrayListA.iterator();
            while (it.hasNext()) {
                if (it.next().b(uri.getScheme(), uri.getHost())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        u.b("onPageFinished:" + str);
        b bVar = this.b;
        if (bVar != null) {
            bVar.setWebViewProgress(webView.getProgress(), false, true);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        b bVar = this.b;
        if (bVar != null) {
            bVar.setWebViewProgress(webView.getProgress(), true, false);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        b bVar;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (!webResourceRequest.isForMainFrame() || (bVar = this.b) == null) {
            return;
        }
        bVar.onReceivedError(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        b bVar;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (!webResourceRequest.isForMainFrame() || (bVar = this.b) == null) {
            return;
        }
        bVar.onReceivedError(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            u.a("shouldInterceptRequest:" + webResourceRequest.getUrl().toString() + " is " + webResourceRequest.isForMainFrame());
            try {
                if (!webResourceRequest.isForMainFrame()) {
                    if (!c(webResourceRequest.getUrl())) {
                        return new WebResourceResponse("text/html", "utf-8", null);
                    }
                    if (com.ubix.ssp.ad.d.b.l && d(webResourceRequest.getUrl()) && !this.e) {
                        a(webView, webResourceRequest.getUrl().toString());
                        return new WebResourceResponse("text/html", "utf-8", null);
                    }
                }
                this.e = false;
                b bVar = this.b;
                if (bVar != null && bVar.needReplace()) {
                    Uri url = webResourceRequest.getUrl();
                    String lowerCase = url.getScheme().toLowerCase();
                    if (lowerCase.equals("http") || lowerCase.equals("https")) {
                        HashMap map = (HashMap) webResourceRequest.getRequestHeaders();
                        if (map != null) {
                            map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                            map.put(HttpHeaders.X_REQUESTED_WITH, this.b.replacePackageName());
                        }
                        HttpURLConnection httpURLConnectionA = com.ubix.ssp.ad.e.x.c.a(url.toString(), webResourceRequest.getMethod(), map);
                        if (httpURLConnectionA.getResponseCode() >= 400) {
                            try {
                                String contentType = httpURLConnectionA.getContentType();
                                if (TextUtils.isEmpty(contentType)) {
                                    return new WebResourceResponse("text/html", "utf-8", httpURLConnectionA.getInputStream());
                                }
                                String[] strArrSplit = contentType.split(";");
                                String str = strArrSplit[0];
                                String strReplace = strArrSplit.length == 2 ? strArrSplit[1].replace("charset=", "") : null;
                                if (TextUtils.isEmpty(str)) {
                                    str = "text/html";
                                }
                                if (TextUtils.isEmpty(strReplace)) {
                                    strReplace = "utf-8";
                                }
                                return new WebResourceResponse(str, strReplace, httpURLConnectionA.getInputStream());
                            } catch (Throwable unused) {
                                return new WebResourceResponse("text/html", "utf-8", httpURLConnectionA.getInputStream());
                            }
                        }
                        String contentType2 = httpURLConnectionA.getContentType();
                        if (TextUtils.isEmpty(contentType2)) {
                            u.b("Can Not invoke package replace");
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        String[] strArrSplit2 = contentType2.split(";");
                        String str2 = strArrSplit2[0];
                        String strReplace2 = strArrSplit2.length == 2 ? strArrSplit2[1].replace("charset=", "") : null;
                        Map<String, List<String>> headerFields = httpURLConnectionA.getHeaderFields();
                        HashMap map2 = new HashMap();
                        for (String str3 : headerFields.keySet()) {
                            List<String> list = headerFields.get(str3);
                            if (list != null && !list.isEmpty()) {
                                map2.put(str3, list.get(0));
                            }
                        }
                        return new WebResourceResponse(str2, strReplace2, httpURLConnectionA.getResponseCode(), "OK", map2, httpURLConnectionA.getInputStream());
                    }
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            u.a("shouldOverrideUrlLoading:" + webResourceRequest.getUrl().toString() + " is " + webResourceRequest.isForMainFrame());
            if (!c(webResourceRequest.getUrl())) {
                return true;
            }
            if (com.ubix.ssp.ad.d.b.l && d(webResourceRequest.getUrl()) && !this.e) {
                a(webView, webResourceRequest.getUrl().toString());
                return true;
            }
            this.e = false;
            Uri url = webResourceRequest.getUrl();
            String string = url.toString();
            String lowerCase = url.getScheme().toLowerCase();
            if (!lowerCase.equals("http") && !lowerCase.equals("https")) {
                String host = url.getHost();
                if (!"ubixad".equals(lowerCase) || !"mini_program".equals(host)) {
                    b bVar = this.b;
                    com.ubix.ssp.ad.e.a0.c.a(this.f8811a, string, bVar != null ? bVar.replacePackageName() : null);
                    return true;
                }
                int iA = a(string);
                b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.onTwiceClicked(iA);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
