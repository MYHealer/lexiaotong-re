package com.kwad.components.core.t;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class j {
    private static long alA;
    private boolean alB;
    private long alC;
    private long alz;

    public j() {
        this(false);
    }

    public j(boolean z) {
        this(z, 1000L);
    }

    private j(boolean z, long j) {
        this.alB = z;
        this.alC = 1000L;
    }

    public final void a(View view, View.OnClickListener onClickListener) {
        com.kwad.sdk.core.d.c.d("click", "cur:" + SystemClock.elapsedRealtime() + " pre:" + this.alz + " global:" + this.alB + " gt:" + alA);
        if (SystemClock.elapsedRealtime() - (this.alB ? alA : this.alz) > this.alC) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.alz = jElapsedRealtime;
            alA = jElapsedRealtime;
            onClickListener.onClick(view);
        }
    }
}
