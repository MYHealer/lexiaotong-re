package com.meishu.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.l0;
import com.meishu.sdk.core.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: FreedomWebViewClient.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends m {
    public final g e;
    public volatile boolean f;
    public com.meishu.sdk.core.webview.listener.f g;

    public f(Context context, String str, g gVar) {
        super(context);
        this.f = true;
        this.e = gVar;
    }

    @Override // com.meishu.sdk.core.webview.m, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        LogUtil.dev("FreedomWebViewClient", "onPageFinished:" + str);
        super.onPageFinished(webView, str);
        g gVar = this.e;
        gVar.getClass();
        try {
            LogUtil.dev("H5LoadSate", "notifyOnPageFinished:" + str);
            if (TextUtils.isEmpty(str)) {
                LogUtil.dev("H5LoadSate", "notifyOnPageFinished url null");
                return;
            }
            if (!gVar.c.contains(str)) {
                gVar.c.add(str);
            }
            if (gVar.f4980a.isEmpty()) {
                LogUtil.dev("H5LoadSate", "notifyOnPageFinished listener null");
                return;
            }
            try {
                ArrayList arrayList = null;
                for (com.meishu.sdk.core.webview.listener.g gVar2 : new ArrayList(gVar.f4980a)) {
                    try {
                        boolean z = false;
                        boolean z2 = gVar.c.size() == 1 && str.equals(gVar.e);
                        try {
                            if (!TextUtils.isEmpty(str) && gVar.c.contains(str) && !gVar.b.containsKey(str) && !q.a(str)) {
                                z = true;
                            }
                        } catch (Exception unused) {
                        }
                        if (!gVar2.onPageFinished(str, z2, z, gVar.a(str))) {
                            LogUtil.dev("H5LoadSate", "notifyOnPageFinished nokeep");
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(gVar2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (arrayList != null) {
                    gVar.f4980a.removeAll(arrayList);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtil.dev("FreedomWebViewClient", "onPageStarted:" + str);
        g gVar = this.e;
        gVar.getClass();
        try {
            gVar.d = str;
            LogUtil.dev("H5LoadSate", "notifyOnPageStarted:" + str);
            if (!TextUtils.isEmpty(str) && !gVar.f4980a.isEmpty()) {
                try {
                    Iterator it = new ArrayList(gVar.f4980a).iterator();
                    while (it.hasNext()) {
                        try {
                            ((com.meishu.sdk.core.webview.listener.g) it.next()).onPageStarted(str);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    super.onPageStarted(webView, str, bitmap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        try {
            LogUtil.dev("FreedomWebViewClient", "onReceivedError1:" + webView.getUrl() + PPSLabelView.Code + webResourceRequest.getUrl());
            this.e.a(webResourceRequest.getUrl().toString(), -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        try {
            int statusCode = webResourceResponse.getStatusCode();
            LogUtil.dev("FreedomWebViewClient", "onReceivedHttpError " + webResourceRequest.isForMainFrame() + " statusCode:" + statusCode + x.bQ + webView.getUrl() + PPSLabelView.Code + webResourceRequest.getUrl());
            if (statusCode == 404 || statusCode >= 500) {
                this.e.a(webResourceRequest.getUrl().toString(), statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        LogUtil.dev("FreedomWebViewClient", com.meishu.sdk.activity.a.a("onReceivedSslError:").append(webView.getUrl()).append(PPSLabelView.Code).append(sslError.toString()).toString());
    }

    @Override // com.meishu.sdk.core.webview.m
    public boolean a(Intent intent) {
        if (!this.f) {
            return false;
        }
        try {
            com.meishu.sdk.core.webview.listener.f fVar = this.g;
            if (fVar != null) {
                fVar.onDPStart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final boolean[] zArr = {false};
        final l0 l0Var = new l0(1500L, true);
        o0.b.f4927a.f4926a = new o0.a() { // from class: com.meishu.sdk.core.webview.f$$ExternalSyntheticLambda0
            @Override // com.meishu.sdk.core.utils.o0.a
            public final void a(boolean z) {
                this.f$0.a(zArr, l0Var, z);
            }
        };
        com.meishu.sdk.core.service.d.a(l0Var);
        zArr[0] = super.a(intent);
        LogUtil.dev("FreedomWebViewClient", com.meishu.sdk.activity.a.a("super.jump res:").append(zArr[0]).toString());
        if (!zArr[0]) {
            boolean z = l0Var.e;
            try {
                com.meishu.sdk.core.webview.listener.f fVar2 = this.g;
                if (fVar2 != null) {
                    fVar2.onJumpDPRes(false, z);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            o0.b.f4927a.f4926a = null;
            com.meishu.sdk.core.service.d.b(l0Var);
        }
        return zArr[0];
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        LogUtil.dev("FreedomWebViewClient", com.meishu.sdk.activity.a.a("onReceivedError2:").append(webView.getUrl()).append("  ").append(i).append("  ").append(str).append(PPSLabelView.Code).append(str2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean[] zArr, l0 l0Var, boolean z) {
        LogUtil.dev("FreedomWebViewClient", "h5 openDeepLink res :" + z);
        if (zArr[0]) {
            boolean z2 = l0Var.e;
            try {
                com.meishu.sdk.core.webview.listener.f fVar = this.g;
                if (fVar != null) {
                    fVar.onJumpDPRes(z, z2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
