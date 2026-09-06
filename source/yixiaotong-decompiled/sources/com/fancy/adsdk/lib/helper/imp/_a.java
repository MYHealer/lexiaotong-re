package com.fancy.adsdk.lib.helper.imp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.fancy._fj;
import com.fancy._pb;
import com.fancy._s;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils._d;
import com.fancy.mpsdk.widget.titlebar.PtgTitleBarWeb;
import com.fancy.mpsdk.widget.web.AdvancedWebView;
import java.net.URLDecoder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a {
    public AdvancedWebView _a;
    public ProgressBar _b;
    public PtgTitleBarWeb _c;
    public List<String> _d;
    public int _e;
    public _s _f;
    public final RunnableC0373_a _g = new RunnableC0373_a();

    /* JADX INFO: renamed from: com.fancy.adsdk.lib.helper.imp._a$_a, reason: collision with other inner class name */
    public class RunnableC0373_a implements Runnable {
        public RunnableC0373_a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdvancedWebView advancedWebView = _a.this._a;
            if (advancedWebView == null || advancedWebView.getSettings() == null) {
                return;
            }
            _a.this._a.getSettings().setJavaScriptEnabled(true);
        }
    }

    public static String _a(_a _aVar, String str) {
        String strDecode;
        List<String> list = _aVar._d;
        if (list == null || list.isEmpty()) {
            return "";
        }
        try {
            strDecode = URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            strDecode = "";
        }
        for (String str2 : _aVar._d) {
            if (!str.startsWith(str2)) {
                try {
                    if (TextUtils.isEmpty(strDecode) || !strDecode.contains(str2)) {
                    }
                } catch (Exception unused2) {
                }
            }
            return str2;
        }
        return "";
    }

    public static boolean _a(_a _aVar) {
        int i = _aVar._e;
        if (i <= 0) {
            return false;
        }
        _aVar._e = Math.max(500, Math.min(i, 5000));
        return true;
    }

    public final void _a(final Activity activity, PtgTitleBarWeb ptgTitleBarWeb, AdvancedWebView advancedWebView, ProgressBar progressBar, String str) {
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null) {
            this._f = (_s) intent.getSerializableExtra("playerInfo");
        }
        this._d = PtgAdSdk.getConfig().getQaList();
        this._e = PtgAdSdk.getConfig().getQaNRTime();
        this._a = advancedWebView;
        this._b = progressBar;
        this._c = ptgTitleBarWeb;
        advancedWebView.loadUrl(str);
        AdvancedWebView advancedWebView2 = this._a;
        if (advancedWebView2 != null) {
            advancedWebView2.setWebViewClient(new WebViewClient() { // from class: com.fancy.adsdk.lib.helper.imp.WebManager$1

                public class _a implements Runnable {
                    public _a() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AdvancedWebView advancedWebView = WebManager$1.this._b._a;
                        if (advancedWebView != null && advancedWebView.getSettings() != null) {
                            WebManager$1.this._b._a.getSettings().setJavaScriptEnabled(false);
                        }
                        com.fancy.adsdk.lib.helper.imp._a _aVar = WebManager$1.this._b;
                        com.fancy.adsdk.lib.helper.imp._a.RunnableC0373_a runnableC0373_a = _aVar._g;
                        long j = _aVar._e;
                        if (runnableC0373_a != null) {
                            _d._b.postDelayed(new _d._c(runnableC0373_a), j);
                        } else {
                            _d._b _bVar = _d._a;
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    ProgressBar progressBar2;
                    super.onPageFinished(webView, str2);
                    if (activity.isFinishing() || (progressBar2 = this._b._b) == null || progressBar2 == null) {
                        return;
                    }
                    progressBar2.setVisibility(8);
                }

                @Override // android.webkit.WebViewClient
                public final void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    ProgressBar progressBar2;
                    super.onPageStarted(webView, str2, bitmap);
                    if (activity.isFinishing() || (progressBar2 = this._b._b) == null || progressBar2 == null) {
                        return;
                    }
                    progressBar2.setVisibility(0);
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    if (str2.startsWith("https") || str2.startsWith("http")) {
                        webView.loadUrl(str2);
                        return false;
                    }
                    try {
                        if (webView.getContext() != null) {
                            String str_a = com.fancy.adsdk.lib.helper.imp._a._a(this._b, str2);
                            Logger.d("iqa qa: " + str_a);
                            if (TextUtils.isEmpty(str_a)) {
                                _s _sVar = this._b._f;
                                if (_sVar != null) {
                                    _sVar._c = str2;
                                    new _fj()._a(activity, new Intent("android.intent.action.VIEW", Uri.parse(str2)), _sVar);
                                }
                            } else {
                                boolean z_a = com.fancy.adsdk.lib.helper.imp._a._a(this._b);
                                Logger.d("iqa ejs: " + z_a + " dy:" + this._b._e);
                                if (z_a) {
                                    _d._c(new _a());
                                }
                            }
                        }
                        return true;
                    } catch (ActivityNotFoundException | Exception unused) {
                        return true;
                    }
                }
            });
        }
        AdvancedWebView advancedWebView3 = this._a;
        if (advancedWebView3 == null) {
            return;
        }
        advancedWebView3.setWebChromeClient(new _pb(this, activity));
    }
}
