package com.miui.zeus.landingpage.sdk.js;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.landingpage.sdk.OnAppLaunchListener;
import com.miui.zeus.landingpage.sdk.a;
import com.miui.zeus.mimo.sdk.C1210r;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n;
import com.miui.zeus.mimo.sdk.o;
import com.miui.zeus.mimo.sdk.u;
import com.miui.zeus.mimo.sdk.w;
import com.miui.zeus.mimo.sdk.x8;
import com.miui.zeus.mimo.sdk.y;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LPJsCallee {
    private static final int DEEPLINK_EXIST_DEEPLINK_DONE = 3;
    private static final int DEEPLINK_EXIST_PACKAGE_DONE = 4;
    private static final int DEEPLINK_EXIST_PACKAGE_FAIL = 5;
    private static final int DEEPLINK_NOT_EXIST_PACKAGE_DONE = 1;
    private static final int DEEPLINK_NOT_EXIST_PACKAGE_FAIL = 2;
    private static final String TAG = s.d(new byte[]{122, 101, 44, 68, 32, 5, 13, 8, 3, 7}, "65f7cd");
    private static final int TYPE_DEEPLINK = 1;
    private static final int TYPE_DOWNLOAD = 0;
    private AppLaunchProxy mAppLaunchProxy;
    private Context mContext;
    private n mDownloadListener;
    private C1210r mMiMarketHelper;
    private int mProgress;
    private final WebView mWebView;
    private boolean mRegister = false;
    private String mMethodName = "";
    private String mPackageName = "";
    private String mDowndloadUrl = "";

    public interface AppLaunchProxy {
        void appLaunchCallBack(OnAppLaunchProxyCallBack onAppLaunchProxyCallBack);
    }

    public interface OnAppLaunchProxyCallBack {
        void appLaunchCallBack(boolean z);
    }

    public LPJsCallee(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
        this.mMiMarketHelper = new C1210r(context);
        initDownloadListener();
    }

    private void addExtraData(Uri.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            m.a(TAG, s.d(new byte[]{81, 80, 80, 124, 65, Ascii.SYN, 19, 5, 34, 3, 69, 4, 16, 81, 76, 77, 75, 3, 48, 17, 3, 16, 72, 53, 81, 70, 85, 84, 74, 66, 8, Ascii.ETB, 70, 7, 92, Ascii.NAK, 68, 77}, "04499b"));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean(s.d(new byte[]{3, Ascii.ESC, 68, 103, 94, 83, Ascii.DC4, 10, 5, 10, 102, 13, 3, 13, 121, 86, 65, 70, 0, 8, 10, 7, 85}, "fc0822"), false)) {
                builder.appendQueryParameter(s.d(new byte[]{85, 82, 17, 8, 82, 94, 54, 12, 3, 12, 120, 11, 74, 71, 5, 10, 93, 83, 5}, "93df16"), String.valueOf(true));
                jSONObject.remove(s.d(new byte[]{81, 26, 68, 107, 88, 3, Ascii.DC4, 10, 5, 10, 102, 13, 81, 12, 121, 90, 71, Ascii.SYN, 0, 8, 10, 7, 85}, "4b044b"));
            }
            builder.appendQueryParameter(s.d(new byte[]{84, Ascii.FS, 16, Ascii.DC4, 89, 105, 16, 17, 3, 16, 72, 58, 65, 5, Ascii.SYN, 7, 85, 69}, "1ddf86"), jSONObject.toString());
        } catch (JSONException e) {
            builder.appendQueryParameter(s.d(new byte[]{6, Ascii.FS, Ascii.ETB, 16, 86, 110, 16, 17, 3, 16, 72, 58, 19, 5, 17, 3, 90, 66}, "cdcb71"), str);
            m.b(TAG, s.d(new byte[]{0, 2, 85, 119, Ascii.RS, 16, 19, 5, 34, 3, 69, 4, 65, 44, 98, 125, 40, 33, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 14, 8, 11}, "af12fd"), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAppLaunchResult(String str, String str2) {
        Set<OnAppLaunchListener> setB = a.a().b();
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            String str3 = s.d(new byte[]{74, 7, 76, 123, 4, 15, 13, 6, 7, 1, 90, 35, 86, 16, 118, 87, 17, 10, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 88, Ascii.ETB, 86, 91, 13, 67, 5, 1, 3, Ascii.DC2, 125, 12, 87, 9, 5}, "9b88ec") + str;
            String str4 = TAG;
            m.a(str4, str3);
            Context context = this.mContext;
            int i = f9.f5428a;
            try {
                m.a(s.d(new byte[]{121, 91, 82, 69, 93, 12, 5, 49, Ascii.DC2, 11, 93, Ascii.SYN}, "85672e"), s.d(new byte[]{95, 71, 81, 87, 67, 48, 19, 8, 70}, "0749ce") + str);
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(s.d(new byte[]{84, 86, 80, 65, 91, 11, 5, 74, 15, 12, 69, 0, 91, 76, 26, 82, 87, Ascii.SYN, 8, 11, 8, 76, 103, 44, 112, 111}, "58434b"));
                    intent.setData(Uri.parse(str));
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    m.a(str4, s.d(new byte[]{Ascii.SYN, 92, 16, 39, 0, 92, 13, 6, 7, 1, 90, 35, 10, 75, 42, 11, Ascii.NAK, 89, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 4, 76, 10, 7, 9, 16, Ascii.ETB, 13, 7, 66, 85, 0, 0, 73, 8, 13, 15, 91, 65, Ascii.ETB, 19, 1, 82, 0, Ascii.SYN, 74}, "e9dda0"));
                    postMessageToJs(1, this.mMethodName, String.valueOf(3));
                } else if (f9.c(this.mContext, str2)) {
                    m.a(TAG, s.d(new byte[]{69, 6, 71, 119, 3, 85, 13, 6, 7, 1, 90, 35, 89, 17, 125, 91, Ascii.SYN, 80, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 87, Ascii.SYN, 93, 87, 10, Ascii.EM, 5, 1, 3, Ascii.DC2, 93, 12, 88, 8, 19, 82, 3, 80, 13, 1, 2, 66, 71, 12, 87, 67, 67, 85, 1, 82, 0, 3, 3, 44, 80, 8, 83, 67, SignedBytes.MAX_POWER_OF_TWO, 65, 1, 90, 4, Ascii.ETB, Ascii.NAK}, "6c34b9"));
                    postMessageToJs(1, this.mMethodName, String.valueOf(4));
                } else {
                    m.a(TAG, s.d(new byte[]{70, 7, Ascii.NAK, 112, 85, 13, 13, 6, 7, 1, 90, 35, 90, 16, 47, 92, SignedBytes.MAX_POWER_OF_TWO, 8, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 84, Ascii.ETB, 15, 80, 92, 65, 5, 1, 3, Ascii.DC2, 93, 12, 91, 9, 65, 85, 85, 8, 13, 1, 2, 66, 71, 12, 84, 66, 17, 82, 87, 10, 0, 3, 3, 44, 80, 8, 80, 66, 7, 82, 93, 13, 4, 0}, "5ba34a"));
                    postMessageToJs(1, this.mMethodName, String.valueOf(5));
                }
            } catch (Exception unused) {
            }
            z = true;
        } else if (f9.c(this.mContext, str2)) {
            m.a(TAG, s.d(new byte[]{67, 7, 68, 112, 87, 95, 13, 6, 7, 1, 90, 35, 95, 16, 126, 92, 66, 90, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 81, Ascii.ETB, 94, 80, 94, 19, Ascii.ETB, 13, 7, 66, 65, 4, 83, 9, 81, 84, 83, 125, 0, 9, 3, 66, 66, 16, 83, 1, 85, SignedBytes.MAX_POWER_OF_TWO, 69}, "0b0363"));
            postMessageToJs(1, this.mMethodName, String.valueOf(1));
            z = true;
        } else {
            m.a(TAG, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 87, SignedBytes.MAX_POWER_OF_TWO, 38, 85, 94, 13, 6, 7, 1, 90, 35, 92, SignedBytes.MAX_POWER_OF_TWO, 122, 10, SignedBytes.MAX_POWER_OF_TWO, 91, 7, Ascii.GS, 39, Ascii.DC2, 65, 41, 82, 71, 90, 6, 92, Ascii.DC2, Ascii.ETB, 13, 7, 66, 65, 4, 80, 89, 85, 2, 81, 124, 0, 9, 3, 66, 87, 4, 90, 94, 81, 1}, "324e42"));
            postMessageToJs(1, this.mMethodName, String.valueOf(2));
        }
        for (OnAppLaunchListener onAppLaunchListener : setB) {
            if (z) {
                onAppLaunchListener.onSuccess(str2);
            } else {
                onAppLaunchListener.onFailed(str2);
            }
        }
    }

    private void initDownloadListener() {
        this.mDownloadListener = new n() { // from class: com.miui.zeus.landingpage.sdk.js.LPJsCallee.1
            @Override // com.miui.zeus.mimo.sdk.n
            public void onCancelDownload(String str) {
                m.a(s.d(new byte[]{117, 51, 120, 70, 37, 4, 13, 8, 3, 7}, "9c25fe"), s.d(new byte[]{93, 10, 113, 81, 93, 7, 4, 8, 34, 13, 70, 11, 94, 11, 83, 84, 19, Ascii.DC4, 0, 7, 13, 3, 86, 0, 124, 5, 95, 85, 14}, "2d203d") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(-8), s.d(new byte[]{4}, "46fc34"), s.d(new byte[]{6}, "605715"));
                    LPJsCallee.this.downloadCancel(str);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onDownloadFailed(String str, int i) {
                m.a(s.d(new byte[]{123, 51, 122, 67, 119, 4, 13, 8, 3, 7}, "7c004e"), s.d(new byte[]{88, 88, 112, 12, 70, 95, 13, 11, 7, 6, 119, 4, 94, 90, 81, 7, 17, 65, 0, 7, 13, 3, 86, 0, 121, 87, 89, 6, 12}, "764c11") + str + s.d(new byte[]{Ascii.DC4, 67, 70, 81, Ascii.ETB, 76, Ascii.DC2, 39, 9, 6, 84, 88}, "8020c9") + i);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(-2), Integer.toString(LPJsCallee.this.mProgress), Integer.toString(i));
                    LPJsCallee.this.downloadFailed(str, i);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onDownloadFinished(String str) {
                m.a(s.d(new byte[]{127, 49, 47, 68, 117, 4, 13, 8, 3, 7}, "3ae76e"), s.d(new byte[]{89, 94, 119, 89, Ascii.SYN, 87, 13, 11, 7, 6, 119, 12, 88, 89, SignedBytes.MAX_POWER_OF_TWO, 94, 4, 93, 65, Ascii.DC4, 7, 1, 90, 4, 81, 85, 125, 87, 12, 92, 92}, "6036a9") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(2), s.d(new byte[]{87, 85, 1}, "fe1570"), s.d(new byte[]{7}, "7b5985"));
                    LPJsCallee.this.downloadFinished(str);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onDownloadPaused(String str) {
                m.a(s.d(new byte[]{117, 51, 40, SignedBytes.MAX_POWER_OF_TWO, 116, 82, 13, 8, 3, 7}, "9cb373"), s.d(new byte[]{91, 12, 125, 91, 70, 91, 13, 11, 7, 6, 97, 4, 65, 17, 92, 80, 17, 69, 0, 7, 13, 3, 86, 0, 122, 3, 84, 81, 12}, "4b9415") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(5), s.d(new byte[]{83}, "c5af76"), Integer.toString(-3));
                    LPJsCallee.this.downloadPaused(str);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onDownloadProgressUpdated(String str, int i) {
                m.a(s.d(new byte[]{41, 53, 125, 66, 33, 0, 13, 8, 3, 7}, "ee71ba"), s.d(new byte[]{86, 93, 114, 95, Ascii.SYN, 93, 13, 11, 7, 6, 97, Ascii.ETB, 86, 84, 68, 85, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 52, Ascii.DC4, 2, 3, 69, 0, 93, 19, 70, 81, 2, 88, 0, 3, 3, 44, 80, 8, 92, 14}, "9360a3") + str + s.d(new byte[]{74, 67, 68, 9, 81, 66, 4, Ascii.ETB, Ascii.NAK, 95}, "f36f60") + i);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee.this.mProgress = i;
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(5), Integer.toString(i), Integer.toString(-2));
                    LPJsCallee.this.downloadProgressUpdated(str, i);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onDownloadStarted(String str) {
                m.a(s.d(new byte[]{121, 105, 123, 68, 39, 85, 13, 8, 3, 7}, "5917d4"), s.d(new byte[]{12, 90, 125, 94, 17, 87, 13, 11, 7, 6, 98, 17, 2, 70, 77, 84, 2, Ascii.EM, 17, 5, 5, 9, 80, 2, 6, 122, 88, 92, 3, 4}, "c491f9") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(1), s.d(new byte[]{84}, "de0d82"), s.d(new byte[]{81}, "a9e9d5"));
                    LPJsCallee.this.downloadStart(str);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onExistDownload(String str) {
                LPJsCallee lPJsCallee = LPJsCallee.this;
                lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, s.d(new byte[]{79, 5}, "b789ca"), String.valueOf(0), s.d(new byte[]{81}, "a61474"));
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onInstallFailed(String str, int i) {
                m.a(s.d(new byte[]{125, 52, 115, 70, 116, 82, 13, 8, 3, 7}, "1d9573"), s.d(new byte[]{13, 89, 121, 15, 17, 65, 0, 8, 10, 36, 80, 12, 14, 82, 84, 65, Ascii.DC2, 84, 2, 15, 7, 5, 84, 43, 3, 90, 85, 92}, "b70ab5") + str + s.d(new byte[]{Ascii.FS, 66, 77, 80, 68, Ascii.DC4, Ascii.DC2, 39, 9, 6, 84, 88}, "01910a") + i);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(-3), s.d(new byte[]{1, 6, 7}, "067c87"), Integer.toString(i));
                    LPJsCallee.this.installFailed(str, i);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onInstallStart(String str) {
                m.a(s.d(new byte[]{126, 99, 41, 67, 33, 0, 13, 8, 3, 7}, "23c0ba"), s.d(new byte[]{10, 12, 45, 88, Ascii.DC2, 65, 0, 8, 10, 49, 69, 4, Ascii.ETB, Ascii.SYN, 68, 70, 0, 86, 10, 5, 1, 7, 127, 4, 8, 7, 89}, "ebd6a5") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(3), s.d(new byte[]{8, 83, 81}, "9cab56"), s.d(new byte[]{4}, "476fa0"));
                    LPJsCallee.this.installStart(str);
                }
            }

            @Override // com.miui.zeus.mimo.sdk.n
            public void onInstallSuccess(String str) {
                m.a(s.d(new byte[]{123, 53, 41, 69, 123, 0, 13, 8, 3, 7}, "7ec68a"), s.d(new byte[]{9, 88, 40, 87, 16, 77, 0, 8, 10, 49, 68, 6, 5, 83, Ascii.DC2, 74, 67, 73, 0, 7, 13, 3, 86, 0, 40, 87, 12, 92, 94}, "f6a9c9") + str);
                if (TextUtils.equals(LPJsCallee.this.mPackageName, str)) {
                    LPJsCallee lPJsCallee = LPJsCallee.this;
                    lPJsCallee.postMessageToJs(0, lPJsCallee.mMethodName, Integer.toString(4), s.d(new byte[]{4, 3, 84}, "53d263"), s.d(new byte[]{82}, "b3b70f"));
                    LPJsCallee.this.installSuccess(str);
                }
            }
        };
    }

    private void registerDownloadListener() {
        if (this.mRegister) {
            return;
        }
        m.a(TAG, s.d(new byte[]{65, 0, 2, 13, 71, 68, 4, Ascii.SYN, 34, 13, 70, 11, 95, 10, 4, 0, 120, 89, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "3eed40"));
        this.mMiMarketHelper.a(this.mPackageName, this.mDownloadListener);
        this.mRegister = true;
    }

    @JavascriptInterface
    public void cancelDownloadAppDirectly(String str, String str2, String str3) {
        String str4 = s.d(new byte[]{90, 89, 10, 6, 84, 91, 37, 11, 17, 12, 93, 10, 88, 92, 37, Ascii.NAK, 65, 115, 8, Ascii.SYN, 3, 1, 69, 9, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, Ascii.DC4, 4, 82, 92, 0, 3, 3, 44, 80, 8, 92, 5}, "98de17") + str;
        String str5 = TAG;
        m.a(str5, str4);
        this.mPackageName = str;
        this.mMethodName = str3;
        m.a(str5, s.d(new byte[]{83, 87, 13, 86, 7, 90, 37, 11, 17, 12, 93, 10, 81, 82, 34, 69, Ascii.DC2, 114, 8, Ascii.SYN, 3, 1, 69, 9, 73, Ascii.SYN, Ascii.SYN, 71, 14, 11}, "06c5b6") + str2);
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        sVarA.getClass();
        com.miui.zeus.mimo.sdk.s.d = true;
        x8.j.execute(new y(sVarA, str2));
        m.a(str5, s.d(new byte[]{5, 82, 12, 83, 7, 15, 37, 11, 17, 12, 93, 10, 7, 87, 35, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 39, 8, Ascii.SYN, 3, 1, 69, 9, Ascii.US, 19, 17, 69, 1, 0, 4, Ascii.ETB, Ascii.NAK, 95}, "f3b0bc") + true);
    }

    public void downloadCancel(String str) {
        com.miui.zeus.mimo.sdk.s.a().b.remove(str);
    }

    public void downloadFailed(String str, int i) {
        com.miui.zeus.mimo.sdk.s.a().b.remove(str);
    }

    public void downloadFinished(String str) {
        com.miui.zeus.mimo.sdk.s.a().b.remove(str);
    }

    public void downloadPaused(String str) {
        com.miui.zeus.mimo.sdk.s.a().a(str, 2);
    }

    public void downloadProgressUpdated(String str, int i) {
        com.miui.zeus.mimo.sdk.s.a().a(str, 3);
    }

    public void downloadStart(String str) {
        com.miui.zeus.mimo.sdk.s.a().a(str, 1);
    }

    @JavascriptInterface
    public int getApkVersion(String str) {
        return f9.a(this.mContext, str);
    }

    @JavascriptInterface
    public String getAppDownloadState(String str) {
        String str2 = s.d(new byte[]{87, 93, 66, 112, 17, 70, 37, 11, 17, 12, 93, 10, 81, 92, 101, 69, 0, 66, 4, 68, Ascii.SYN, 3, 82, 14, 81, 95, 83, 127, 0, 91, 4, 89}, "0861a6") + str;
        String str3 = TAG;
        m.a(str3, str2);
        if (f9.b(this.mContext, str)) {
            o oVar = new o(4, 100);
            m.a(str3, oVar.toString());
            return oVar.toString();
        }
        o oVar2 = com.miui.zeus.mimo.sdk.s.a().b.get(str);
        if (oVar2 != null) {
            m.a(str3, oVar2.toString());
            return oVar2.toString();
        }
        m.a(str3, new o(-1, 0).toString());
        return new o(-1, 0).toString();
    }

    public void installFailed(String str, int i) {
        com.miui.zeus.mimo.sdk.s.a().b.remove(str);
    }

    public void installStart(String str) {
    }

    public void installSuccess(String str) {
        com.miui.zeus.mimo.sdk.s.a().b.remove(str);
    }

    @JavascriptInterface
    public boolean isFeatureSupport(int i) {
        return i >= 0 && i <= 4;
    }

    public void onDestroy() {
        m.a(TAG, s.d(new byte[]{93, 86, 119, 6, 67, 67, 19, 11, Ascii.US}, "283c07"));
        C1210r c1210r = this.mMiMarketHelper;
        if (c1210r != null) {
            c1210r.a();
            this.mMiMarketHelper = null;
        }
        AppLaunchProxy appLaunchProxy = this.mAppLaunchProxy;
        if (appLaunchProxy != null) {
            appLaunchProxy.appLaunchCallBack(null);
        }
    }

    @JavascriptInterface
    public void pauseDownloadAppDirectly(String str, String str2, String str3) {
        String str4 = s.d(new byte[]{68, 87, 76, 68, 80, 32, 14, 19, 8, 14, 94, 4, 80, 119, 73, 71, 113, 13, 19, 1, 5, Ascii.SYN, 93, Ascii.FS, Ascii.DC4, 82, 88, 67, 84, 89}, "46975d") + this.mDowndloadUrl;
        String str5 = TAG;
        m.a(str5, str4);
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        String str6 = this.mDowndloadUrl;
        sVarA.getClass();
        x8.j.execute(new u(sVarA, str6));
        m.a(str5, s.d(new byte[]{67, 87, 66, Ascii.NAK, 4, 112, 14, 19, 8, 14, 94, 4, 87, 119, 71, Ascii.SYN, 37, 93, 19, 1, 5, Ascii.SYN, 93, Ascii.FS, 19, 69, 66, 5, 2, 81, Ascii.DC2, Ascii.ETB, 91}, "367fa4") + true);
    }

    public void postMessageToJs(final int i, final String str, final String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y8.b.post(new Runnable() { // from class: com.miui.zeus.landingpage.sdk.js.LPJsCallee.3
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                WebView webView;
                ValueCallback<String> valueCallback;
                int i2 = i;
                if (i2 == 0) {
                    str2 = s.d(new byte[]{93, 83, 69, 5, 65, 1, 19, 13, Ascii.SYN, Ascii.SYN, 11}, "723d2b") + str + s.d(new byte[]{76}, "d3eedd") + strArr[0] + s.d(new byte[]{Ascii.GS}, "1c0d7e") + strArr[1] + s.d(new byte[]{Ascii.RS, Ascii.DC4}, "261277") + LPJsCallee.this.mPackageName + s.d(new byte[]{65, 74}, "cf94bc") + strArr[2] + s.d(new byte[]{79}, "f3fafa");
                    m.a(s.d(new byte[]{125, 100, 125, 74, 117, 86, 13, 8, 3, 7}, "147967"), s.d(new byte[]{96, 58, 103, 112, 103, 39, 46, 51, 40, 46, 126, 36, 112, 67, 83, 90, 79, 13, 45, 11, 7, 6, 124, 0, SignedBytes.MAX_POWER_OF_TWO, 11, 88, 81, 107, Ascii.ETB, 19, 89}, "4c758c") + str2);
                    webView = LPJsCallee.this.mWebView;
                    valueCallback = new ValueCallback<String>() { // from class: com.miui.zeus.landingpage.sdk.js.LPJsCallee.3.2
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str3) {
                        }
                    };
                } else {
                    if (i2 != 1) {
                        return;
                    }
                    str2 = s.d(new byte[]{90, 5, 67, 3, 75, 7, 19, 13, Ascii.SYN, Ascii.SYN, 11}, "0d5b8d") + str + s.d(new byte[]{Ascii.US, SignedBytes.MAX_POWER_OF_TWO}, "7b31d7") + LPJsCallee.this.mPackageName + s.d(new byte[]{26, 74}, "8f40a1") + strArr[0] + s.d(new byte[]{Ascii.RS}, "7a5c22");
                    m.a(s.d(new byte[]{121, 103, 41, SignedBytes.MAX_POWER_OF_TWO, 33, 7, 13, 8, 3, 7}, "57c3bf"), s.d(new byte[]{103, 106, 53, 114, 62, 116, 36, 33, 54, 46, 120, 43, 120, 19, 1, 82, 4, SignedBytes.MAX_POWER_OF_TWO, 45, 13, 8, 9, 124, 0, 71, 91, 10, 83, 50, 68, 19, 89}, "33e7a0") + str2);
                    webView = LPJsCallee.this.mWebView;
                    valueCallback = new ValueCallback<String>() { // from class: com.miui.zeus.landingpage.sdk.js.LPJsCallee.3.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str3) {
                        }
                    };
                }
                webView.evaluateJavascript(str2, valueCallback);
            }
        });
    }

    @JavascriptInterface
    public void quitCurrentWebview() {
        m.a(TAG, s.d(new byte[]{Ascii.NAK, 19, 94, 77, 38, 65, 19, Ascii.SYN, 3, 12, 69, 50, 1, 4, 65, 80, 0, 67}, "df79e4"));
        try {
            Context context = this.mContext;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            ((Activity) context).finish();
        } catch (Exception e) {
            m.b(TAG, s.d(new byte[]{68, Ascii.DC4, 81, 76, 39, 65, 19, Ascii.SYN, 3, 12, 69, 50, 80, 3, 78, 81, 1, 67, 65, 1, 92}, "5a88d4"), e);
        }
    }

    @JavascriptInterface
    public void resumeDownloadAppDirectly(String str, String str2) {
        String str3 = s.d(new byte[]{Ascii.SYN, 81, 67, 17, 95, 1, 37, 11, 17, 12, 93, 10, 5, 80, 113, Ascii.DC4, 66, 32, 8, Ascii.SYN, 3, 1, 69, 9, Ascii.GS, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 5, 81, 15, 0, 3, 3, 44, 80, 8, 1, 9}, "d40d2d") + str;
        String str4 = TAG;
        m.a(str4, str3);
        this.mPackageName = str;
        registerDownloadListener();
        m.a(str4, s.d(new byte[]{75, 0, 17, 66, 84, 93, 37, 11, 17, 12, 93, 10, 88, 1, 35, 71, 73, 124, 8, Ascii.SYN, 3, 1, 69, 9, SignedBytes.MAX_POWER_OF_TWO, 69, 6, 86, 77, 89, 92}, "9eb798") + this.mDowndloadUrl);
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        String str5 = this.mDowndloadUrl;
        sVarA.getClass();
        com.miui.zeus.mimo.sdk.s.d = false;
        x8.j.execute(new w(sVarA, str5));
        m.a(str4, s.d(new byte[]{68, 1, 74, Ascii.ETB, 88, 93, 37, 11, 17, 12, 93, 10, 87, 0, 120, Ascii.DC2, 69, 124, 8, Ascii.SYN, 3, 1, 69, 9, 79, 68, 74, Ascii.ETB, 86, 91, 4, Ascii.ETB, Ascii.NAK, 95}, "6d9b58") + true);
    }

    public void setAppLaunchProxy(AppLaunchProxy appLaunchProxy) {
        this.mAppLaunchProxy = appLaunchProxy;
    }

    @JavascriptInterface
    public void setCallbackForNotifyAppLaunch(final String str, final String str2, String str3) {
        this.mPackageName = str2;
        this.mMethodName = str3;
        AppLaunchProxy appLaunchProxy = this.mAppLaunchProxy;
        if (appLaunchProxy != null) {
            appLaunchProxy.appLaunchCallBack(new OnAppLaunchProxyCallBack() { // from class: com.miui.zeus.landingpage.sdk.js.LPJsCallee.2
                @Override // com.miui.zeus.landingpage.sdk.js.LPJsCallee.OnAppLaunchProxyCallBack
                public void appLaunchCallBack(boolean z) {
                    if (!z) {
                        LPJsCallee.this.callbackAppLaunchResult(str, str2);
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        LPJsCallee lPJsCallee = LPJsCallee.this;
                        lPJsCallee.postMessageToJs(1, lPJsCallee.mMethodName, String.valueOf(1));
                    } else {
                        LPJsCallee lPJsCallee2 = LPJsCallee.this;
                        lPJsCallee2.postMessageToJs(1, lPJsCallee2.mMethodName, String.valueOf(3));
                    }
                    Iterator<OnAppLaunchListener> it = a.a().b().iterator();
                    while (it.hasNext()) {
                        it.next().onSuccess(str2);
                    }
                }
            });
        } else {
            callbackAppLaunchResult(str, str2);
        }
    }

    @JavascriptInterface
    public void startInstallAppDirectly(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = TAG;
        m.a(str9, s.d(new byte[]{69, Ascii.ETB, 88, 71, Ascii.ETB, 124, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 119, 19, 73, 113, 10, 71, 4, 7, Ascii.DC2, 14, 72, 69, 95, 13}, "6c95c5"));
        this.mMethodName = str8;
        this.mPackageName = str;
        Uri.Builder builderBuildUpon = Uri.parse(s.d(new byte[]{91, 2, 67, 83, 85, 67, 91, 75, 73, 6, 84, 17, 87, 10, 93, 75, Ascii.US, 83, 4, 16, 7, 11, 93, 3, 90, 12, 80, 76}, "6c1807")).buildUpon();
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{81, 85}, "8127ef"), str);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{19, 85, 87, 91, 81, 95, 4, 42, 7, 15, 84}, "c44008"), str);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{70, 86, 86}, "4302ee"), str2);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{4, 68, 69, 32, 88, 13, 4, 10, Ascii.DC2, 43, 85}, "e45c4d"), str3);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{66, 92, 86, 93, 6, Ascii.DC4, 49, 5, 5, 9, 80, 2, 84, 119, 89, 84, 6}, "1989cf"), this.mContext.getPackageName());
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{88, 71, Ascii.DC4, 50, 80, 82, 15, 5, Ascii.DC2, Ascii.ETB, 67, 0}, "97da95"), str4);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{92, 86, 11, 90, 85}, "29e904"), str5);
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{71, 11, 10, 70, 60, 82, Ascii.NAK, 5}, "4ce1c1"), Boolean.toString(true));
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{91, 19, 6, 17, 84, 5, Ascii.CAN, 52, 9, 17, 88, 17, 93, 10, 13}, "4ecc8d"), Integer.toString(1));
        builderBuildUpon.appendQueryParameter(s.d(new byte[]{Ascii.ETB, 70, 85, SignedBytes.MAX_POWER_OF_TWO, 69, 116, 14, 19, 8, 14, 94, 4, 0}, "d24210"), Boolean.toString(true));
        addExtraData(builderBuildUpon, str7);
        String strDecode = Uri.decode(builderBuildUpon.toString());
        m.a(str9, s.d(new byte[]{68, 66, 4, 69, 71, 42, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 118, 70, Ascii.NAK, 115, 90, 17, 4, 7, Ascii.DC2, 14, 72, 69, 83, 87, 17, 86, 14}, "76e73c") + strDecode);
        this.mDowndloadUrl = strDecode;
        registerDownloadListener();
        com.miui.zeus.mimo.sdk.s.a().a(strDecode);
        m.a(str9, s.d(new byte[]{69, Ascii.NAK, 85, 71, 77, 127, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 119, 17, 68, 113, 80, 68, 4, 7, Ascii.DC2, 14, 72, 69, 69, Ascii.DC4, 87, 86, 92, 69, Ascii.DC2, 89}, "6a4596") + true);
    }

    @JavascriptInterface
    public void startInstallAppDirectly1(String str, String str2, String str3) {
        String str4 = s.d(new byte[]{74, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.SYN, 71, 121, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 120, 68, Ascii.NAK, 32, 90, 66, 4, 7, Ascii.DC2, 14, 72, 84, Ascii.EM, 65, Ascii.ETB, 8, 14}, "94ed30") + str2;
        String str5 = TAG;
        m.a(str5, str4);
        this.mMethodName = str3;
        this.mPackageName = str;
        this.mDowndloadUrl = str2;
        registerDownloadListener();
        com.miui.zeus.mimo.sdk.s.a().a(str2);
        m.a(str5, s.d(new byte[]{Ascii.ETB, Ascii.NAK, 85, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 123, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 37, 17, 68, 33, 93, SignedBytes.MAX_POWER_OF_TWO, 4, 7, Ascii.DC2, 14, 72, 84, 68, Ascii.DC2, 65, 6, 87, 87, Ascii.DC2, Ascii.ETB, 91}, "da4e42") + true);
    }
}
