package com.miui.zeus.mimo.sdk;

import android.widget.TextView;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5389a;
    public final /* synthetic */ DownloadButtonICP b;

    public c8(DownloadButtonICP downloadButtonICP, int i) {
        this.b = downloadButtonICP;
        this.f5389a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        int i;
        this.b.setEnabled(true);
        this.b.l.setText(this.f5389a + ijiami_1011.s.s.s.d(new byte[]{17}, "4cc204"));
        DownloadButtonICP downloadButtonICP = this.b;
        downloadButtonICP.l.setTextColor(downloadButtonICP.r);
        DownloadButtonICP downloadButtonICP2 = this.b;
        if (downloadButtonICP2.t) {
            if (this.f5389a >= downloadButtonICP2.u) {
                textView = downloadButtonICP2.l;
                i = downloadButtonICP2.q;
            } else {
                textView = downloadButtonICP2.l;
                i = downloadButtonICP2.r;
            }
            textView.setTextColor(i);
        }
        this.b.k.setProgress(this.f5389a);
        this.b.k.setVisibility(0);
        this.b.m.setVisibility(8);
    }
}
