package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.y8;
import com.miui.zeus.mimo.sdk.z8;
import ijiami_1011.s.s.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5276a;
    public static String b;

    public class a implements LPWebView.OnWebPageFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LPWebView f5277a;

        public a(LPWebView lPWebView) {
            this.f5277a = lPWebView;
        }

        @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
        public void onReceivedTitle(WebView webView, String str) {
        }

        @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
        public void onWebPageError(WebView webView, String str) {
        }

        @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
        public void onWebPageFinished(WebView webView, String str) {
            this.f5277a.destroy();
        }

        @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }
    }

    public static WebResourceResponse a(Context context, Uri uri) {
        String strA;
        try {
            String string = uri.toString();
            String path = uri.getPath();
            String strA2 = a(path);
            if (com.miui.zeus.mimo.sdk.b.g(strA2)) {
                return null;
            }
            if (strA2.equals(s.d(new byte[]{67, 1, 65, 65, Ascii.EM, 9, Ascii.NAK, 9, 10}, "7d956a"))) {
                string = uri.getScheme() + s.d(new byte[]{13, Ascii.US, 76}, "70ca4d") + uri.getAuthority() + uri.getPath();
            }
            if (com.miui.zeus.mimo.sdk.b.a(b, s.d(new byte[]{117, 118, 81}, "82dd65"))) {
                strA = z8.a(string);
            } else {
                strA = com.miui.zeus.mimo.sdk.b.a(b, s.d(new byte[]{44, 112, 123, 121}, "a96668")) ? z8.a(string) + s.d(new byte[]{77, 9}, "c9992c") : path;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(strA2, s.d(new byte[]{99, 55, 126, Ascii.CAN, 15}, "6c857d"), context.getAssets().open(strA));
            HashMap map = new HashMap();
            map.put(s.d(new byte[]{115, 87, 81, 6, 71, 69, 76, 39, 9, 12, 69, Ascii.ETB, 93, 88, Ascii.US, 34, 88, 90, 14, 19, 75, 45, 67, 12, 85, 93, 92}, "242c46"), s.d(new byte[]{26}, "0db8c8"));
            webResourceResponse.setResponseHeaders(map);
            m.d(s.d(new byte[]{122, 95, 84, 7, 13, 51, 4, 6, 48, 11, 84, Ascii.DC2, 117, 92, 94, 3, 15, 16}, "607fad"), s.d(new byte[]{9, 13, 82, 85, 35, 67, 14, 9, 39, 17, 66, 0, 17, 17, 9, 17}, "eb31e1") + path);
            return webResourceResponse;
        } catch (IOException e) {
            m.b(s.d(new byte[]{122, 10, 80, 89, 93, 51, 4, 6, 48, 11, 84, Ascii.DC2, 117, 9, 90, 93, 95, 16}, "6e381d"), s.d(new byte[]{119, 75, 69, 87, 67, 67, 13, 11, 7, 6, 88, 11, 85, Ascii.EM, 81, 74, 94, 14, 65, 5, Ascii.NAK, 17, 84, 17, 65, 3, Ascii.ETB}, "29781c") + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00cd A[Catch: IOException -> 0x013a, TRY_LEAVE, TryCatch #0 {IOException -> 0x013a, blocks: (B:3:0x0003, B:6:0x0016, B:8:0x002a, B:9:0x005a, B:11:0x006d, B:16:0x00a9, B:18:0x00cd, B:20:0x0114, B:13:0x0073, B:15:0x0087), top: B:25:0x0003 }] */
    public static WebResourceResponse a(Uri uri) {
        String strA;
        String str;
        File file;
        try {
            String string = uri.toString();
            String path = uri.getPath();
            String strA2 = a(path);
            if (com.miui.zeus.mimo.sdk.b.g(strA2)) {
                return null;
            }
            if (strA2.equals(s.d(new byte[]{67, 80, 79, Ascii.DC2, 73, 92, Ascii.NAK, 9, 10}, "757ff4"))) {
                string = uri.getScheme() + s.d(new byte[]{89, 77, Ascii.CAN}, "cb7ec9") + uri.getAuthority() + uri.getPath();
            }
            if (com.miui.zeus.mimo.sdk.b.a(b, s.d(new byte[]{125, 38, 1}, "0b4859"))) {
                strA = z8.a(string);
            } else {
                if (com.miui.zeus.mimo.sdk.b.a(b, s.d(new byte[]{126, 120, 122, 119}, "31782c"))) {
                    strA = z8.a(string) + s.d(new byte[]{Ascii.SYN, 1}, "813bf6");
                }
                str = f5276a + File.separator + path;
                file = new File(str);
                if (file.exists()) {
                    WebResourceResponse webResourceResponse = new WebResourceResponse(strA2, s.d(new byte[]{55, 101, 39, Ascii.CAN, 91}, "b1a5c7"), new FileInputStream(file));
                    HashMap map = new HashMap();
                    map.put(s.d(new byte[]{117, 84, 83, 6, Ascii.NAK, Ascii.SYN, 76, 39, 9, 12, 69, Ascii.ETB, 91, 91, Ascii.GS, 34, 10, 9, 14, 19, 75, 45, 67, 12, 83, 94, 94}, "470cfe"), s.d(new byte[]{Ascii.FS}, "63b808"));
                    webResourceResponse.setResponseHeaders(map);
                    m.d(s.d(new byte[]{125, 9, 0, 7, 93, 103, 4, 6, 48, 11, 84, Ascii.DC2, 114, 10, 10, 3, 95, 68}, "1fcf10"), string + s.d(new byte[]{95, 4, 15, 8, 10, 95, 92, 1, Ascii.RS, 11, 66, 17, 17, Ascii.EM, 8, Ascii.NAK}, "b9257b") + str);
                    return webResourceResponse;
                }
            }
            path = strA;
            str = f5276a + File.separator + path;
            file = new File(str);
            if (file.exists()) {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(strA2, s.d(new byte[]{55, 101, 39, Ascii.CAN, 91}, "b1a5c7"), new FileInputStream(file));
                HashMap map2 = new HashMap();
                map2.put(s.d(new byte[]{117, 84, 83, 6, Ascii.NAK, Ascii.SYN, 76, 39, 9, 12, 69, Ascii.ETB, 91, 91, Ascii.GS, 34, 10, 9, 14, 19, 75, 45, 67, 12, 83, 94, 94}, "470cfe"), s.d(new byte[]{Ascii.FS}, "63b808"));
                webResourceResponse2.setResponseHeaders(map2);
                m.d(s.d(new byte[]{125, 9, 0, 7, 93, 103, 4, 6, 48, 11, 84, Ascii.DC2, 114, 10, 10, 3, 95, 68}, "1fcf10"), string + s.d(new byte[]{95, 4, 15, 8, 10, 95, 92, 1, Ascii.RS, 11, 66, 17, 17, Ascii.EM, 8, Ascii.NAK}, "b9257b") + str);
                return webResourceResponse2;
            }
        } catch (IOException e) {
            m.b(s.d(new byte[]{121, 91, 86, 2, 90, 99, 4, 6, 48, 11, 84, Ascii.DC2, 118, 88, 92, 6, 88, SignedBytes.MAX_POWER_OF_TWO}, "545c64"), s.d(new byte[]{125, Ascii.ETB, 19, 90, Ascii.DC4, 68, 13, 11, 7, 6, 88, 11, 95, 69, 7, 71, 9, 9, 65, 2, 15, 14, 84, 95, Ascii.CAN}, "8ea5fd") + e.getMessage());
        }
        return null;
    }

    public static String a(String str) {
        String strSubstring = str.substring(str.lastIndexOf(s.d(new byte[]{Ascii.SYN}, "88e97e")) + 1);
        if (strSubstring.equalsIgnoreCase(s.d(new byte[]{10, 77, 92, 14}, "b91b9f")) || strSubstring.equalsIgnoreCase(s.d(new byte[]{92, 69, 12}, "41aa8a"))) {
            return s.d(new byte[]{66, 87, 79, SignedBytes.MAX_POWER_OF_TWO, Ascii.US, 93, Ascii.NAK, 9, 10}, "627405");
        }
        if (strSubstring.equalsIgnoreCase(s.d(new byte[]{80, 75, 74}, "389a5c"))) {
            return s.d(new byte[]{77, 87, 75, SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, 82, Ascii.DC2, Ascii.ETB}, "923431");
        }
        if (strSubstring.equalsIgnoreCase(s.d(new byte[]{90, Ascii.ETB}, "0d3930"))) {
            return s.d(new byte[]{89, Ascii.DC2, 67, 13, 10, 6, 0, 16, 15, 13, 95, 74, 82, 3, 69, 0, 16, 6, 19, 13, Ascii.SYN, Ascii.SYN}, "8b3ace");
        }
        if (strSubstring.equalsIgnoreCase(s.d(new byte[]{Ascii.NAK, 10, 86}, "ed15df"))) {
            return s.d(new byte[]{93, 94, 4, 84, 81, 74, 17, 10, 1}, "43e34e");
        }
        if (strSubstring.equalsIgnoreCase(s.d(new byte[]{8, 65, 84}, "b13564")) || strSubstring.equalsIgnoreCase(s.d(new byte[]{11, 71, 3, 5}, "a7fbb4"))) {
            return s.d(new byte[]{90, 11, 81, 86, 92, 75, 11, Ascii.DC4, 3, 5}, "3f019d");
        }
        return strSubstring.equalsIgnoreCase(s.d(new byte[]{86, 11, 83}, "1b5fc7")) ? s.d(new byte[]{90, 89, 86, 80, 1, Ascii.SYN, 6, 13, 0}, "3477d9") : s.d(new byte[]{88, 69, 67, 85, 91, 1, 0, 16, 15, 13, 95, 74, 86, 86, 71, 92, 70, 79, Ascii.DC2, 16, Ascii.DC4, 7, 80, 8}, "95392b");
    }

    public static void a(String str, String str2) {
        f5276a = str;
        b = str2;
    }

    public static WebResourceResponse b(Context context, Uri uri) {
        if (!TextUtils.isEmpty(f5276a) && com.miui.zeus.mimo.sdk.b.h(uri.getPath())) {
            return f5276a.startsWith(s.d(new byte[]{87, 8, 92, 1, 88, 26, 78, 75, 7, 12, 85, Ascii.ETB, 94, 8, 84, 59, 3, 70, Ascii.DC2, 1, Ascii.DC2, 77}, "1a0db5")) ? a(context, uri) : a(uri);
        }
        return null;
    }

    public static void b(String str) {
        if (com.miui.zeus.mimo.sdk.b.b(str)) {
            String strD = s.d(new byte[]{73, 70, 93, 89, 90, 81, 5}, "948550");
            String strD2 = s.d(new byte[]{68, 16, 69, 81}, "0b04c8");
            try {
                Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
                builderBuildUpon.appendQueryParameter(strD, strD2);
                builderBuildUpon.build().toString();
            } catch (Exception unused) {
            }
            LPWebView lPWebView = new LPWebView(y8.f5752a);
            lPWebView.setPreloadWithWebView(true);
            lPWebView.loadUrl(str);
            lPWebView.setOnWebPageFinishedListener(new a(lPWebView));
        }
    }
}
