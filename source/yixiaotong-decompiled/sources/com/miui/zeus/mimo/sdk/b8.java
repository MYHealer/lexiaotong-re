package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadButtonICP f5376a;

    public b8(DownloadButtonICP downloadButtonICP) {
        this.f5376a = downloadButtonICP;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5376a.setEnabled(true);
        this.f5376a.k.setProgress(0);
        this.f5376a.k.setVisibility(0);
        this.f5376a.l.setText(ijiami_1011.s.s.s.d(new byte[]{9, Ascii.ETB}, "92129b"));
        DownloadButtonICP downloadButtonICP = this.f5376a;
        downloadButtonICP.l.setTextColor(downloadButtonICP.r);
        this.f5376a.m.setVisibility(8);
        this.f5376a.l();
    }
}
