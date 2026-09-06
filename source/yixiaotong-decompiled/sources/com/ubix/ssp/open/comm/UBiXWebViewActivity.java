package com.ubix.ssp.open.comm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.c0.b;
import com.ubix.ssp.ad.e.c0.c;
import com.ubix.ssp.ad.e.c0.d;
import com.ubixnow.ooooo.o0OO000o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXWebViewActivity extends Activity implements b.a, d.b, View.OnClickListener, DownloadListener {
    private byte[] adBytes;
    private FrameLayout container;
    private boolean finishOnce;
    private ProgressBar progressBar;
    private String replacePgk;
    private String webUrl;
    private c webView;
    private boolean sendTracker = false;
    private boolean needRemovePackageName = false;
    private String reg = "\\b([a-z][a-z0-9_]*\\.)+[a-z][a-z0-9_]*\\b";
    private boolean hasError = false;
    private ArrayList<com.ubix.ssp.ad.d.d> bl = new ArrayList<>();
    private String adType = "0";
    private boolean userInnerFace = false;

    static {
        StubApp.interface11(52568);
    }

    private void finishCurrentActivity() {
        try {
            try {
                setResult(-1, new Intent("closeImmediately"));
                c cVar = this.webView;
                if (cVar != null) {
                    this.container.removeView(cVar);
                    this.webView.getSettings().setJavaScriptEnabled(false);
                    this.webView.stopLoading();
                    this.webView.removeAllViews();
                    this.webView.clearHistory();
                    this.webView.clearCache(true);
                    this.webView.freeMemory();
                    this.webView.destroy();
                    this.webView = null;
                }
            } catch (Throwable th) {
                u.d(th.toString());
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            Runtime.getRuntime().gc();
            finish();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private ArrayList<com.ubix.ssp.ad.d.d> generalBlockList() {
        com.ubix.ssp.ad.d.d dVarA;
        String[] strArr = com.ubix.ssp.ad.d.b.j;
        if (strArr != null && strArr.length > 0) {
            ArrayList<com.ubix.ssp.ad.d.d> arrayList = new ArrayList<>();
            for (String str : com.ubix.ssp.ad.d.b.j) {
                if (!TextUtils.isEmpty(str) && (dVarA = com.ubix.ssp.ad.d.d.a(str, com.ubix.ssp.ad.d.b.k)) != null) {
                    arrayList.add(dVarA);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return new ArrayList<>();
    }

    private void initBrowser(String str, String str2) {
        c cVar = new c((Activity) this);
        this.webView = cVar;
        cVar.setWebChromeClient(new b(this, this));
        this.webView.setWebViewClient(new d(this, this));
        this.webView.setDownloadListener(this);
        this.container.addView(this.webView, 0, new FrameLayout.LayoutParams(-1, -1));
        this.webView.setMaterial(this.adBytes);
        if (!TextUtils.isEmpty(this.webUrl) && this.needRemovePackageName) {
            updateCookies(this.webUrl);
        }
        this.webView.setTag(str + "_" + str2);
        this.webView.loadUrl(this.webUrl);
    }

    private void updateCookies(String str) {
        String[] strArrSplit;
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String cookie = cookieManager.getCookie(str);
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(cookie) || (strArrSplit = cookie.split(";")) == null) {
                return;
            }
            for (String str2 : strArrSplit) {
                arrayList.add(str2.replaceAll(getPackageName(), ""));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            cookieManager.removeAllCookie();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cookieManager.setCookie(str, (String) it.next());
            }
            cookieManager.flush();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void fullScreenOrShowStatusBar() {
    }

    @Override // com.ubix.ssp.ad.e.c0.d.b
    public boolean needReplace() {
        return this.replacePgk != null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.webView;
        if (cVar == null || !cVar.canGoBack()) {
            finishCurrentActivity();
        } else {
            this.webView.goBack();
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 10003) {
            onBackPressed();
            return;
        }
        try {
            if (!"0".equals(this.adType)) {
                setResult(-1, new Intent("closeImmediately"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        finish();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            Intent intent = new Intent("MainFrameDestroy");
            intent.putExtra("error", this.hasError);
            m.a(StubApp.getOrigApplicationContext(getApplicationContext())).a(intent);
            c cVar = this.webView;
            if (cVar != null) {
                cVar.stopLoading();
                ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.webView);
                }
                this.webView.removeAllViews();
                this.webView.destroy();
            }
            this.webView = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        u.b("webview download url: " + str);
        try {
            if (!this.finishOnce) {
                setWebViewProgress(100, false, true);
                this.finishOnce = true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            c cVar = this.webView;
            if (cVar != null && cVar.canGoBack()) {
                this.webView.goBack();
                return false;
            }
            finishCurrentActivity();
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            c cVar = this.webView;
            if (cVar != null) {
                cVar.onPause();
                this.webView.pauseTimers();
            }
        } catch (Exception unused) {
        }
        super.onPause();
    }

    @Override // com.ubix.ssp.ad.e.c0.d.b
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest) {
        this.hasError = true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            this.webView.onResume();
            this.webView.resumeTimers();
        } catch (Exception e) {
            u.d(e.toString());
        }
        super.onResume();
    }

    @Override // com.ubix.ssp.ad.e.c0.d.b
    public void onTwiceClicked(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("__MP_RESULT__", i + "");
        c cVar = this.webView;
        if (cVar != null) {
            cVar.a(202, map);
        }
    }

    @Override // com.ubix.ssp.ad.e.c0.d.b
    public String replacePackageName() {
        return this.replacePgk;
    }

    public void sendTracker() {
        if (this.sendTracker) {
            return;
        }
        try {
            this.sendTracker = true;
            HashMap map = new HashMap();
            u.b("--------webView page_url: " + this.webView.getTag());
            if (!TextUtils.isEmpty(this.webView.getTag().toString())) {
                String[] strArrSplit = this.webView.getTag().toString().split("_");
                if (strArrSplit.length > 1) {
                    map.put("ad_type", strArrSplit[0]);
                    map.put(o0OO000o.o000OooO, strArrSplit[1]);
                }
            }
            map.put("page_url", this.webUrl);
            map.put("ad_sizes", this.webView.getWidth() + "x" + this.webView.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.c0.b.a
    public void setTitle(String str) {
        ((TextView) findViewById(10005)).setText(str);
    }

    @Override // com.ubix.ssp.ad.e.c0.b.a, com.ubix.ssp.ad.e.c0.d.b
    public void setWebViewProgress(int i, boolean z, boolean z2) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            if (z) {
                progressBar.setVisibility(0);
            }
            if (z2) {
                this.progressBar.setVisibility(8);
            }
            this.progressBar.setProgress(i);
            if (i == 100) {
                this.progressBar.setVisibility(8);
                Intent intent = new Intent("MainFrameHasError");
                intent.putExtra("error", this.hasError);
                m.a(StubApp.getOrigApplicationContext(getApplicationContext())).a(intent);
            }
            if (!z2 || this.finishOnce) {
                return;
            }
            this.finishOnce = true;
            Intent intent2 = new Intent("WebViewLoadFinished");
            intent2.putExtra("error", this.hasError);
            m.a(StubApp.getOrigApplicationContext(getApplicationContext())).a(intent2);
        }
    }

    @Override // com.ubix.ssp.ad.e.c0.d.b
    public ArrayList<com.ubix.ssp.ad.d.d> shouldCheckRule() {
        try {
            if (this.webView == null) {
                return null;
            }
            return this.bl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
