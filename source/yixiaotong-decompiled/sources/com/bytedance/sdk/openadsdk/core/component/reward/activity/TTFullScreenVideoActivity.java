package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.os.Bundle;
import com.byazt.cf.tt;
import com.byazt.ete.kp;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.byazt.yi.c;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean yv() {
        return false;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void bm() {
        super.bm();
        if (kp.nu(this.qp) || this.zb.d()) {
            return;
        }
        if (this.cu.eo()) {
            this.eo.c(false, null, null, true, true);
            return;
        }
        int iH = ((int) this.cu.h()) / 1000;
        String str = this.bx.a(false) + "s";
        boolean z = iH >= this.bx.lo();
        this.eo.c(false, str, (z || !gt.tt().n(String.valueOf(this.ic))) ? null : (this.bx.lo() - iH) + "s后可跳过", z, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void p() {
        if (this.ve.getAndSet(true)) {
            return;
        }
        if (this.to == null || !this.to.ve()) {
            c("onAdClose", (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void ve(boolean z) {
        byte b = -1;
        if (this.gu) {
            if (gt.tt().hz() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.gt.get()) {
            return;
        }
        if (b == 0) {
            if (this.gt.getAndSet(true)) {
                return;
            }
            tt.c().c(this.qp, String.valueOf(this.ic));
            return;
        }
        this.tt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTFullScreenVideoActivity.this.gt.getAndSet(true)) {
                    return;
                }
                tt.c().c(TTFullScreenVideoActivity.this.qp, String.valueOf(TTFullScreenVideoActivity.this.ic));
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void c(String str, Bundle bundle) {
        c.c(1, this.hd, str, bundle);
    }
}
