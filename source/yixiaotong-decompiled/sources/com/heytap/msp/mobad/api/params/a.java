package com.heytap.msp.mobad.api.params;

import android.content.Context;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements INativeAdvanceData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f3452a = 0;
    protected int b = 0;

    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
    public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
        int i = this.f3452a;
        int i2 = this.b;
        if (i * i2 > 0) {
            mediaView.setWidthHeightRate(i, i2);
        }
    }
}
