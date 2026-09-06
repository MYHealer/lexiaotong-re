package com.byazt.tp;

import android.content.Context;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 54})
public class ve extends tt {
    public ve(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        super(context, icVar, ttVar);
    }

    @Override // com.byazt.tp.tt
    public void c(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        if (context == null) {
            return;
        }
        this.c = new BannerExpressVideoView(context, icVar, ttVar);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setVideoAdListener(com.byazt.ft.ve veVar) {
        if (this.c != null) {
            this.c.setVideoAdListener(veVar);
        }
    }

    @Override // com.byazt.ouz.tt
    public com.byazt.ua.c getVideoModel() {
        if (this.sp != null && this.sp.get() != null) {
            return this.sp.get().getVideoModel();
        }
        if (this.c != null) {
            return ((BannerExpressVideoView) this.c).getVideoModel();
        }
        return null;
    }
}
