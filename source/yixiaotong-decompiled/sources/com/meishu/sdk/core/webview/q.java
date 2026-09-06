package com.meishu.sdk.core.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: WebViewUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q {
    public static Handler i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f4990a;
    public int c;
    public boolean d;
    public long e;
    public j g;
    public static final String h = com.meishu.sdk.activity.a.a("\n<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n    <title>500 - 服务器错误</title>\n    <style>\n        body {\n            margin: 0;\n            padding: 0;\n            background-color: white;\n            display: flex;\n            flex-direction: column;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            overflow: hidden;\n            touch-action: none;\n        }\n        .error-image {\n            width: 140px;\n            height: 119px;\n            margin-bottom: 16px;\n        }\n        .error-text {\n            font-weight: 400;\n            font-size: 14px;\n            color: #888888;\n            text-align: center;\n            line-height: 24px;\n            max-width: 80%;\n        }\n    </style>\n</head>\n<body>\n<img class=\"error-image\" src=\"data:image/png;base64,").append(a(AdSdk.getContext(), R.drawable.ad_mate_error)).append("\" alt=\"500错误提示图\">\n<p class=\"error-text\">页面加载失败<br>可尝试刷新或检查网络~</p>\n</body>\n</html>\n").toString();
    public static int j = 9000;
    public int b = 1;
    public Runnable f = new a();

    /* JADX INFO: compiled from: WebViewUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                if (!com.meishu.sdk.core.service.d.a()) {
                    q qVar = q.this;
                    if (qVar.e == 0) {
                        qVar.e = System.currentTimeMillis();
                    }
                    q qVar2 = q.this;
                    qVar2.c += 500;
                    qVar2.b = 2;
                    Handler handler = q.i;
                    if (handler != null) {
                        handler.postDelayed(qVar2.f, 500L);
                        return;
                    }
                    return;
                }
                q qVar3 = q.this;
                if (qVar3.b != 1 && qVar3.e > 0) {
                    if (System.currentTimeMillis() - q.this.e < q.j) {
                        LogUtil.e("WebViewUtil", "task_interrupted, mUpdateTime=" + q.this.c + ",rewardTmpTime=" + q.j);
                        q.a(q.this, "task_interrupted");
                    } else {
                        LogUtil.e("WebViewUtil", "达到目标时间，成功 ,task_completed");
                        q.this.d = true;
                        q.a(q.this, "task_completed");
                        q.this.c = 0;
                        q.i.removeCallbacksAndMessages(null);
                        j jVar = q.this.g;
                        if (jVar != null) {
                            jVar.onRewardSuccess();
                        }
                    }
                }
                q.i.postDelayed(q.this.f, 500L);
                q qVar4 = q.this;
                qVar4.getClass();
                qVar4.b = 1;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.clearCache(false);
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            Handler handler = i;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("about:") || str.startsWith("data:") || str.toLowerCase().contains("android_asset");
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(q qVar, String str) {
        if (qVar.f4990a == null || i == null) {
            return;
        }
        LogUtil.e("WebViewUtil", "notifyWebStatus----------------");
        qVar.f4990a.post(new r(qVar, str));
    }

    public static String a(Context context, int i2) {
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Throwable unused) {
            return "";
        }
    }
}
