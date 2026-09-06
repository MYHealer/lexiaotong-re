package com.byazt.ouz;

import android.content.Context;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 482})
public class zm extends gu {
    public zm(Context context, ic icVar, com.byazt.dj.tt ttVar, int i) {
        super(context, icVar, ttVar, i);
    }

    @Override // com.byazt.ouz.gu
    public void initExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        this.c = new NativeExpressVideoView(context, icVar, ttVar, com.byazt.dyf.tt.AD_TAG_FEED);
        c(this.c, this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setVideoAdListener(final com.byazt.ft.ve veVar) {
        if (this.c != null) {
            this.c.setVideoAdListener(new com.byazt.dh.ve.uj() { // from class: com.byazt.ouz.zm.1
                @Override // com.byazt.dh.ve.uj
                public void onVideoLoad() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c();
                    }
                }

                @Override // com.byazt.dh.ve.uj
                public void onVideoError(int i, int i2) {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(i, i2);
                    }
                }
            });
            this.c.setVideoAdInteractionListener(new com.byazt.dh.ve.InterfaceC0133ve() { // from class: com.byazt.ouz.zm.2
                @Override // com.byazt.dh.ve.InterfaceC0133ve
                public void onVideoAdStartPlay() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.tt();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0133ve
                public void onVideoAdPaused() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.ve();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0133ve
                public void onVideoAdContinuePlay() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.uj();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0133ve
                public void onProgressUpdate(long j, long j2) {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, j2);
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0133ve
                public void onVideoComplete() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.n();
                    }
                }
            });
        }
    }

    @Override // com.byazt.ouz.tt
    public com.byazt.ua.c getVideoModel() {
        if (this.n != null && this.n.get() != null) {
            return this.n.get().getVideoModel();
        }
        if (!(this.c instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) this.c).yp();
        return ((NativeExpressVideoView) this.c).getVideoModel();
    }
}
