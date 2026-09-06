package com.adprof.sdk;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b6 extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1066a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f84a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f85a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f86a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Set f87a;

    public b6(Context context) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f87a = new HashSet();
        this.f86a = new HashMap();
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        a(getSettings());
        if (!f84a) {
            a(getContext());
            f84a = true;
        }
        resumeTimers();
        b(context);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0128 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) {
        StringBuilder sbAppend;
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        String absolutePath = context.getDataDir().getAbsolutePath();
        HashSet hashSet = new HashSet();
        String processName = Application.getProcessName();
        if (TextUtils.equals(context.getPackageName(), processName)) {
            String str = "_" + processName;
            hashSet.add(absolutePath + "/app_webview/webview_data.lock");
            hashSet.add(absolutePath + "/app_webview" + str + "/webview_data.lock");
            if (nk.b()) {
                hashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
                sbAppend = new StringBuilder().append(absolutePath).append("/app_hws_webview").append(str);
                hashSet.add(sbAppend.append("/webview_data.lock").toString());
            }
            pk.b("handleWebViewDir error: ", th);
            return;
        }
        if (TextUtils.isEmpty(processName)) {
            processName = context.getPackageName();
        }
        WebView.setDataDirectorySuffix(processName);
        String str2 = "_" + processName;
        hashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
        if (nk.b()) {
            sbAppend = new StringBuilder().append(absolutePath).append("/app_hws_webview").append(str2);
            hashSet.add(sbAppend.append("/webview_data.lock").toString());
        }
        pk.b("handleWebViewDir error: ", th);
        return;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (file.exists()) {
                synchronized (f1066a) {
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                        } catch (Throwable th) {
                            pk.b("tryLockOrRecreateFile error: ", th);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            }
        }
    }

    private g7 getListener() {
        return null;
    }

    public void a() {
        hp.m656a((View) this);
        try {
            stopLoading();
        } catch (Throwable unused) {
        }
        setWebViewClient(null);
        removeAllViews();
        Iterator it = this.f87a.iterator();
        while (it.hasNext()) {
            removeJavascriptInterface((String) it.next());
        }
        this.f87a.clear();
        setWebChromeClient(null);
        loadUrl("about:blank");
        clearHistory();
        clearCache(true);
        this.f85a = null;
    }

    public final void a(Context context) {
    }

    public final void a(WebSettings webSettings) {
        try {
            String str = new String(Base64.decode("c2V0SmF2YVNjcmlwdEVuYWJsZWQ=", 2));
            qh.a(str);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Class<?> superclass = webSettings != null ? webSettings.getClass() : null;
            Class cls = Boolean.TYPE;
            Boolean bool = Boolean.TRUE;
            qh.a(cls);
            arrayList.add(cls);
            arrayList2.add(bool);
            Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
            qh.a(str);
            qh.a(clsArr);
            while (true) {
                if (superclass == null) {
                    throw new NoSuchMethodException();
                }
                try {
                    superclass.getDeclaredMethod(str, clsArr).invoke(webSettings, arrayList2.toArray());
                    break;
                } catch (Throwable unused) {
                    superclass = superclass.getSuperclass();
                }
            }
        } catch (Throwable th) {
            pk.b("webSetting error1: ", th);
        }
        try {
            String str2 = new String(Base64.decode("c2V0QWxsb3dGaWxlQWNjZXNz", 2));
            qh.a(str2);
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Class cls2 = Boolean.TYPE;
            Boolean bool2 = Boolean.TRUE;
            qh.a(cls2);
            arrayList3.add(cls2);
            arrayList4.add(bool2);
            Class<?>[] clsArr2 = (Class[]) arrayList3.toArray(new Class[arrayList3.size()]);
            qh.a(str2);
            qh.a(clsArr2);
            for (Class<?> superclass2 = webSettings != null ? webSettings.getClass() : null; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                try {
                    superclass2.getDeclaredMethod(str2, clsArr2).invoke(webSettings, arrayList4.toArray());
                    webSettings.setDomStorageEnabled(true);
                    webSettings.setUseWideViewPort(true);
                    webSettings.setBuiltInZoomControls(false);
                    webSettings.setLoadWithOverviewMode(true);
                    webSettings.setSupportZoom(true);
                    webSettings.setDefaultTextEncodingName("UTF-8");
                    webSettings.setBlockNetworkImage(false);
                    webSettings.setBlockNetworkLoads(false);
                    webSettings.setCacheMode(-1);
                    webSettings.setMediaPlaybackRequiresUserGesture(false);
                    webSettings.setLoadsImagesAutomatically(true);
                    webSettings.setAllowContentAccess(true);
                    webSettings.setSafeBrowsingEnabled(false);
                    webSettings.setMixedContentMode(0);
                    return;
                } catch (Throwable unused2) {
                }
            }
            throw new NoSuchMethodException();
        } catch (Throwable th2) {
            pk.b("webSetting error2: ", th2);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
        this.f87a.add(str);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            a();
            pk.a(" BaseWebView destroy called ");
            super.destroy();
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        this.f86a.put("Referer", "");
        d dVar = this.f85a;
        if (dVar != null) {
            dVar.getClass();
        }
        loadUrl(str, this.f86a);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAdUnit(d dVar) {
        this.f85a = dVar;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }
}
