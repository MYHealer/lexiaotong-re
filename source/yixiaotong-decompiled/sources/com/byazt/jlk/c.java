package com.byazt.jlk;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.or.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 20})
public final class c {

    /* JADX INFO: renamed from: com.byazt.jlk.c$c, reason: collision with other inner class name */
    public interface InterfaceC0190c {
        com.byazt.six.c c(String str, da.c cVar, String str2);

        boolean c();
    }

    public static com.byazt.six.c c(WebView webView, ic icVar, String str, InterfaceC0190c interfaceC0190c) {
        zb next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        da.c cVarC = da.c(str);
        boolean z = interfaceC0190c != null && interfaceC0190c.c();
        if (cVarC != da.c.IMAGE && z && icVar != null) {
            Iterator<zb> it = icVar.pa().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (!TextUtils.isEmpty(next.c()) && !TextUtils.isEmpty(str)) {
                    String strC = next.c();
                    if (strC.startsWith("https")) {
                        strC = strC.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strC)) {
                        break;
                    }
                }
            }
        } else {
            next = null;
            break;
        }
        if (cVarC == da.c.IMAGE) {
            com.byazt.six.c cVar = new com.byazt.six.c();
            cVar.c(5);
            cVar.c(c(str, tt.tt(icVar, str)));
            return cVar;
        }
        if (next == null) {
            if (interfaceC0190c == null) {
                return null;
            }
            return interfaceC0190c.c(str, cVarC, "");
        }
        com.byazt.six.c cVar2 = new com.byazt.six.c();
        cVar2.c(c(str, next.sp()));
        cVar2.c(5);
        return cVar2;
    }

    private static WebResourceResponse c(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamC = com.byazt.xky.tt.c(str, str2);
            if (inputStreamC == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(da.c.IMAGE.getType(), "utf-8", inputStreamC);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        m.ve("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
