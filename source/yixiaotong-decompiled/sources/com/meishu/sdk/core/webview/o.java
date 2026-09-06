package com.meishu.sdk.core.webview;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.c1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.q0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: WebViewMaker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o {

    /* JADX INFO: compiled from: WebViewMaker.java */
    public class a implements com.meishu.sdk.core.webview.listener.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f4989a;

        public a(b bVar) {
            this.f4989a = bVar;
        }

        @Override // com.meishu.sdk.core.webview.listener.g
        public boolean onPageFinished(String str, boolean z, boolean z2, int i) {
            if (z && !z2) {
                b bVar = this.f4989a;
                bVar.getClass();
                SdkHandler.runOnMainThread(new c(bVar, false, 1));
            }
            return false;
        }

        @Override // com.meishu.sdk.core.webview.listener.g
        public void onPageStarted(String str) {
        }
    }

    public static s a(Context context, String str, final com.meishu.sdk.platform.ms.c cVar, n nVar, com.meishu.sdk.core.webview.listener.a aVar, com.meishu.sdk.core.webview.listener.d dVar) {
        Integer num;
        try {
            final boolean z = (cVar instanceof com.meishu.sdk.meishu_ad.nativ.d) && AdType.REWARD.value() == ((com.meishu.sdk.meishu_ad.nativ.d) cVar).f5045a;
            final b bVar = new b(new b.InterfaceC0822b() { // from class: com.meishu.sdk.core.webview.o$$ExternalSyntheticLambda0
                @Override // com.meishu.sdk.core.webview.b.InterfaceC0822b
                public final void a(boolean z2, int i) {
                    o.a(cVar, z, z2, i);
                }
            });
            WebView webView = new WebView(new ContextWrapper(context));
            webView.setScrollBarStyle(0);
            WebSettings settings = webView.getSettings();
            settings.setSavePassword(false);
            settings.setCacheMode(-1);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
            settings.setMixedContentMode(0);
            g gVar = new g(str);
            gVar.a(aVar);
            gVar.a(new a(bVar));
            webView.setDownloadListener(d.a(context));
            f fVar = new f(context, str, gVar);
            fVar.f = false;
            webView.setWebViewClient(fVar);
            webView.setWebChromeClient(new e(str, gVar));
            if (nVar != null && (num = nVar.f4988a) != null) {
                webView.setBackgroundColor(num.intValue());
            }
            com.meishu.sdk.core.webview.a aVar2 = new com.meishu.sdk.core.webview.a(cVar, webView, gVar, z);
            aVar2.g = dVar;
            aVar2.f = new com.meishu.sdk.core.webview.listener.c() { // from class: com.meishu.sdk.core.webview.o$$ExternalSyntheticLambda1
                @Override // com.meishu.sdk.core.webview.listener.c
                public final void a(boolean z2) {
                    o.a(bVar, z2);
                }
            };
            webView.addJavascriptInterface(aVar2, "ADMateJSBridge");
            a(cVar, z, 26, 0);
            a(webView, str);
            return new s(webView, fVar, gVar, bVar);
        } catch (Throwable th) {
            th.printStackTrace();
            if (!(aVar instanceof com.meishu.sdk.core.webview.listener.g)) {
                return null;
            }
            ((com.meishu.sdk.core.webview.listener.g) aVar).onPageFinished(str, true, false, -1);
            return null;
        }
    }

    public static /* synthetic */ void a(com.meishu.sdk.platform.ms.c cVar, boolean z, boolean z2, int i) {
        if (z2) {
            return;
        }
        a(cVar, z, 28, i);
    }

    public static void a(b bVar, boolean z) {
        int i = z ? 0 : 2;
        bVar.getClass();
        SdkHandler.runOnMainThread(new c(bVar, z, i));
    }

    public static void a(com.meishu.sdk.platform.ms.c cVar, boolean z, int i, int i2) {
        try {
            BaseAdSlot baseAdSlot = (BaseAdSlot) cVar.a();
            int webTempId = baseAdSlot.getWebTempId();
            if (z && webTempId <= 0) {
                webTempId = baseAdSlot.getRewardTmpId();
            }
            o1.a(baseAdSlot.getEventUrl(), i, i2, "{\"web_temp_id\":" + webTempId + com.alipay.sdk.util.i.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    public static void a(WebView webView, String str) throws Throwable {
        String string;
        String str2;
        String str3 = c1.f4891a;
        try {
            String strA = c1.a(str);
            if (!TextUtils.isEmpty(strA)) {
                File file = new File(c1.a(), strA);
                if (file.exists()) {
                    int i = com.meishu.sdk.core.utils.s.f4941a;
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    }
                    bufferedReader.close();
                    string = sb.toString();
                }
                str2 = string;
                if (!TextUtils.isEmpty(str2)) {
                    LogUtil.dev("o", "use local webView");
                    webView.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
                } else {
                    webView.loadUrl(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        string = null;
        str2 = string;
        if (!TextUtils.isEmpty(str2)) {
            LogUtil.dev("o", "use local webView");
            webView.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        } else {
            webView.loadUrl(str);
        }
    }

    public static boolean a(String str) {
        List<String> list;
        try {
            if (!TextUtils.isEmpty(str) && (list = q0.p) != null && !list.isEmpty()) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2) && str.toLowerCase().startsWith(str2.toLowerCase())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
