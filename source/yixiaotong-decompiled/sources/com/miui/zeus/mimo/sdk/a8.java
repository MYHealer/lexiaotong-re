package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.view.component.BubbleDownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BubbleDownloadButtonICP f5283a;

    public a8(BubbleDownloadButtonICP bubbleDownloadButtonICP) {
        this.f5283a = bubbleDownloadButtonICP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BubbleDownloadButtonICP bubbleDownloadButtonICP = this.f5283a;
        AutoDownloadController autoDownloadController = bubbleDownloadButtonICP.e;
        if (autoDownloadController != null) {
            autoDownloadController.a();
        }
        MimoAdInfo mimoAdInfo = bubbleDownloadButtonICP.f5761a;
        if (mimoAdInfo != null) {
            mimoAdInfo.S = false;
        }
    }
}
