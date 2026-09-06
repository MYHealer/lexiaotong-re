package com.hihonor.adsdk.base.callback;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g implements View.OnClickListener {
    private static final String hnadsb = "ClickListener";
    private static final int hnadsc = 800;
    private static long hnadsd;
    private final View.OnClickListener hnadsa;

    public g(View.OnClickListener onClickListener) {
        this.hnadsa = onClickListener;
    }

    private boolean hnadsa() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = hnadsd;
        if (jCurrentTimeMillis <= j) {
            hnadsd = jCurrentTimeMillis;
            return false;
        }
        if (jCurrentTimeMillis - j <= 800) {
            return true;
        }
        hnadsd = jCurrentTimeMillis;
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (hnadsa()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onDownloadAndInstallClick: fast click", new Object[0]);
        } else {
            this.hnadsa.onClick(view);
        }
    }
}
