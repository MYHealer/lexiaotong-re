package com.meishu.sdk.core.webview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.meishu.sdk.R;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.q0;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: WebViewClient.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m extends WebViewClient {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4987a;
    public HashMap<String, Integer> b = new HashMap<>();
    public volatile boolean c = false;

    public m(Context context) {
        this.f4987a = context;
    }

    public boolean a(Intent intent) {
        if (intent.resolveActivity(this.f4987a.getPackageManager()) != null) {
            intent.setFlags(268435456);
            ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(this.f4987a.getPackageManager(), 65536);
            if (activityInfoResolveActivityInfo != null && activityInfoResolveActivityInfo.exported) {
                intent.setFlags(intent.getFlags() & (-196));
                HashSet hashSet = new HashSet();
                hashSet.add("android.intent.action.CHOOSER");
                hashSet.add("android.intent.action.SEND");
                hashSet.add("android.intent.action.SEND_MULTIPLE");
                hashSet.add("android.media.action.IMAGE_CAPTURE");
                hashSet.add("android.media.action.IMAGE_CAPTURE_SECURE");
                hashSet.add("android.media.action.VIDEO_CAPTURE");
                if (hashSet.contains(intent.getAction())) {
                    return false;
                }
                this.f4987a.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        a(webView);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ComponentName callingActivity;
        if (str.startsWith("http")) {
            return false;
        }
        try {
            String scheme = Uri.parse(str).getScheme();
            HashMap<String, Integer> map = q0.h;
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (scheme != null && scheme.equals(str2)) {
                        if (this.b.containsKey(str2)) {
                            Integer num = this.b.get(str2);
                            if (num != null) {
                                this.b.put(str2, Integer.valueOf(num.intValue() + 1));
                            }
                        } else {
                            this.b.put(str2, 0);
                        }
                        Integer num2 = q0.h.get(str2);
                        Integer num3 = this.b.get(str2);
                        if (num2 != null && num3 != null && num3.intValue() < num2.intValue()) {
                        }
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            Context context = this.f4987a;
            if ((context instanceof Activity) && ((callingActivity = ((Activity) context).getCallingActivity()) == null || this.f4987a.getPackageName().equalsIgnoreCase(callingActivity.getPackageName()))) {
                a(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void a(WebView webView) {
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            Context context = webView.getContext();
            if (context instanceof Activity) {
                View viewFindViewById = ((Activity) context).findViewById(R.id.ms_webivew_loading);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
            } else {
                LogUtil.e("WebViewClient", "context is`not activity");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
