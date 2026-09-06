package com.meishu.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.meishu.sdk.core.AdSdk;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: DownloadListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4978a;
    public a b;

    /* JADX INFO: compiled from: DownloadListener.java */
    public interface a {
        void onDownloadStart();
    }

    public d(Context context) {
        this.f4978a = context;
    }

    public static d a(Context context) {
        try {
            if (AdSdk.adConfig() != null && AdSdk.adConfig().webViewDownloadListener() != null) {
                Constructor<? extends d> declaredConstructor = AdSdk.adConfig().webViewDownloadListener().getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new d(context);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f4978a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            a aVar = this.b;
            if (aVar != null) {
                aVar.onDownloadStart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
