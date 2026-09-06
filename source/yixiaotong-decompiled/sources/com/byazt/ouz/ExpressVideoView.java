package com.byazt.ouz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.un.NativeVideoTsView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 1397})
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public int c;
    public boolean gu;
    public boolean qy;
    public boolean rl;
    public ImageView tt;

    public void setCanInterruptVideoPlay(boolean z) {
        this.rl = z;
    }

    public void setVideoPlayStatus(int i) {
        this.c = i;
    }

    public void tt(boolean z) {
        this.gu = z;
    }

    public ExpressVideoView(Context context, ic icVar, String str, boolean z) {
        super(context, icVar, false, false, str, false, false);
        this.rl = false;
        if ("draw_ad".equals(str)) {
            this.rl = true;
        }
        this.qy = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public com.byazt.dh.ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        if (this.qy) {
            return new com.byazt.un.ve(context, viewGroup, icVar, str, z, z2, z3);
        }
        return super.c(context, viewGroup, icVar, str, z, z2, z3);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void tt() {
        if (this.rl) {
            super.tt(this.c);
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.n != null) {
            this.n.n(z);
        }
    }

    public void ve() {
        if (this.u != null) {
            pf.c((View) this.u, 8);
        }
    }

    public void E_() {
        if (this.u != null) {
            pf.c((View) this.u, 0);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.t != null && this.t.getVisibility() == 0) {
            rl();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.t != null && this.t.getVisibility() == 0) {
            rl();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void x() {
        pf.c((View) this.da, 0);
        pf.c((View) this.sl, 0);
        pf.c((View) this.u, 8);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void c(boolean z) {
        if (this.gu) {
            super.c(z);
        }
    }

    private void rl() {
        t();
        if (this.da != null) {
            if (this.da.getVisibility() == 0) {
                return;
            }
            com.byazt.xky.tt.c(xd.tt(this.uj)).to(this.sl);
            c(this.sl, xd.tt(this.uj));
        }
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.t != null && this.t.getVisibility() == 0) {
            pf.n(this.da);
        }
        tt(this.c);
    }

    public void setShowAdInteractionView(boolean z) {
        com.byazt.dh.tt ttVarRh;
        if (this.n == null || (ttVarRh = this.n.rh()) == null) {
            return;
        }
        ttVarRh.c(z);
    }

    public void F_() {
        t();
        pf.c((View) this.da, 0);
    }

    public void a() {
        if (this.t != null) {
            pf.c((View) this.t, 8);
        }
    }

    public boolean G_() {
        return (this.n == null || this.n.nu() == null || !this.n.nu().isPlaying()) ? false : true;
    }

    public void setPauseIcon(boolean z) {
        if (this.tt == null) {
            this.tt = new ImageView(getContext());
            if (com.byazt.omf.x.m().sv() != null) {
                this.tt.setImageBitmap(com.byazt.omf.x.m().sv());
            } else {
                com.byazt.nr.z.c(com.byazt.omf.gt.getContext(), "tt_new_play_video", this.tt, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.tt.setScaleType(ImageView.ScaleType.FIT_XY);
            int iVe = pf.ve(getContext(), this.m);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iVe, iVe);
            layoutParams.gravity = 17;
            this.f2784a.addView(this.tt, layoutParams);
        }
        if (z) {
            this.tt.setVisibility(0);
        } else {
            this.tt.setVisibility(8);
        }
    }

    public com.byazt.dh.ve getVideoController() {
        return this.n;
    }
}
