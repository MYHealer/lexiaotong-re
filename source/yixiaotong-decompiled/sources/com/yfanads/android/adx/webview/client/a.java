package com.yfanads.android.adx.webview.client;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* JADX INFO: compiled from: AdxDownloadListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9627a;

    public a(Context context) {
        this.f9627a = context;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        this.f9627a.startActivity(intent);
    }
}
