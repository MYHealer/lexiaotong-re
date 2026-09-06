package com.byazt.tp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ouz.NativeExpressVideoView;
import com.byazt.ouz.NativeExpressView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 1958})
public class BannerExpressVideoView extends c {
    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.byazt.ouz.c cVar) {
        super.setExpressInteractionListener(cVar);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.byazt.ft.ve veVar) {
        super.setVideoAdListener(veVar);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ boolean tt() {
        return super.tt();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void uj() {
        super.uj();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void ve() {
        super.ve();
    }

    public BannerExpressVideoView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        super(context, icVar, ttVar);
    }

    @Override // com.byazt.tp.c
    public void c() {
        this.tt = new NativeExpressVideoView(this.c, this.uj, this.n, this.da);
        addView(this.tt, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.tp.c
    public void c(ic icVar, com.byazt.dj.tt ttVar) {
        this.ve = new NativeExpressVideoView(this.c, icVar, ttVar, this.da);
        this.ve.setExpressInteractionListener(new com.byazt.ouz.c() { // from class: com.byazt.tp.BannerExpressVideoView.1
            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
                if (BannerExpressVideoView.this.f2750a != null) {
                    BannerExpressVideoView.this.f2750a.c(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, float f, float f2) {
                BannerExpressVideoView.this.c(f, f2);
                BannerExpressVideoView.this.a();
            }
        });
        pf.c((View) this.ve, 8);
        addView(this.ve, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.byazt.ua.c getVideoModel() {
        if (this.tt != null) {
            return ((NativeExpressVideoView) this.tt).getVideoModel();
        }
        return null;
    }
}
