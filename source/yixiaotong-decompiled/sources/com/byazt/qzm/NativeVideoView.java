package com.byazt.qzm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.pf;
import com.byazt.bzd.t;
import com.byazt.dh.ve;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.sa.uj;
import com.byazt.un.NativeVideoTsView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 694, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE})
public class NativeVideoView extends NativeVideoTsView implements ve.c {
    public int c;
    public boolean qy;
    public uj rl;
    public c tt;

    public void c(uj ujVar) {
        this.rl = ujVar;
    }

    public void setLp(boolean z) {
        this.qy = z;
    }

    public void setPlayerType(int i) {
        this.c = i;
    }

    public NativeVideoView(Context context) {
        super(context);
        if (this.n != null) {
            this.n.c(true);
        }
        this.gt.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void H_() {
        super.H_();
    }

    @Override // com.byazt.un.NativeVideoTsView
    public ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        c cVar = new c(context, viewGroup, icVar, str, z, z2, z3);
        this.tt = cVar;
        return cVar;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void uj() {
        if (this.n == null) {
            H_();
        } else if ((this.n instanceof com.byazt.un.uj) && !nu()) {
            ((com.byazt.un.uj) this.n).sv();
        }
        if (this.n == null || !this.gt.get()) {
            return;
        }
        this.gt.set(false);
        sp();
        if (z()) {
            pf.c((View) this.da, 0);
            if (this.t != null) {
                pf.c((View) this.t, 8);
            }
            if (xd.z(this.uj) != null) {
                a aVarC = xd.c(4, this.uj);
                aVarC.setCid(this.uj.uj());
                aVarC.setWidth(this.f2784a.getWidth());
                aVarC.setHeight(this.f2784a.getHeight());
                aVarC.setLogExtra(this.uj.w_());
                this.uj.q(this.c);
                aVarC.setPlayerType(this.c);
                aVarC.setAudio(t.c(this.uj));
                aVarC.setCurrent(this.n.sl());
                aVarC.setQuiet(this.n.my());
                ((com.byazt.un.uj) this.n).uj(this.c);
                ((com.byazt.un.uj) this.n).tt(this.uj);
                c(aVarC);
                this.n.ve(false);
                return;
            }
            m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.n.gt()) {
            pf.c((View) this.da, 0);
            return;
        }
        m.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
        t();
        pf.c((View) this.da, 0);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void n() {
        super.n();
        pf.c((View) this.da, 0);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        pf.c((View) this.da, 0);
    }

    public void c(boolean z, boolean z2) {
        t();
        pf.c((View) this.da, 0);
        pf.c((View) this.u, z ? 0 : 8);
        pf.c((View) this.sl, z2 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.rl;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public boolean c(long j, boolean z, boolean z2) {
        this.f2784a.setVisibility(0);
        if (this.n == null) {
            this.n = new com.byazt.un.uj(getContext(), this.sp, this.uj, this.z, false, false);
        }
        if (u() || this.i) {
            c(this.ve, 25, xd.tt(this.uj));
        }
        return false;
    }

    @Override // com.byazt.un.NativeVideoTsView, com.byazt.un.uj.c
    public void I_() {
        pf.c((View) this.da, 8);
        super.I_();
    }

    @Override // com.byazt.un.NativeVideoTsView, com.byazt.dh.ve.c
    public void tt(long j, int i) {
        super.tt(j, i);
        pf.c((View) this.da, 0);
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.qy && i == 8) {
            n();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        if (this.n != null) {
            this.n.tt(map);
        }
    }

    public void S_() {
        c cVar = this.tt;
        if (cVar != null) {
            cVar.x();
            pf.c((View) this.da, 8);
        }
    }

    public void x() {
        c cVar = this.tt;
        if (cVar != null) {
            cVar.a();
        }
    }
}
