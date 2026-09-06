package com.byazt.kcl;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.byazt.dn.UgenBanner;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ff.TopProxyLayout;
import com.byazt.ge.RewardBrowserMixTopLayoutImpl;
import com.byazt.ge.TopLayoutImpl;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.hkv.tt f2404a;
    public final TTBaseVideoActivity c;
    public com.byazt.ge.n i;
    public UgenBanner n;
    public com.byazt.ge.a sp;
    public ic tt;
    public TextView uj;
    public com.byazt.ge.c ve;
    public com.byazt.ge.uj x;

    public n(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
    }

    public void c(ic icVar, tt ttVar, boolean z, com.byazt.hkv.tt ttVar2) {
        this.tt = icVar;
        this.f2404a = ttVar2;
        x();
        this.sp = new com.byazt.ge.a(this.c, this.tt, ttVar, this, z);
        this.i = new com.byazt.ge.n(this.c, this.tt, ttVar, this, z);
        this.x = new com.byazt.ge.uj(this.c, this.tt, ttVar, this, z);
        c(1);
    }

    private void x() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.c.findViewById(2114387721);
        if (topProxyLayout != null) {
            c(topProxyLayout);
        }
        this.uj = (TextView) this.c.findViewById(2114387801);
        this.n = (UgenBanner) this.c.findViewById(2114387901);
    }

    public void c(TopProxyLayout topProxyLayout) {
        View viewC;
        if (my.u(this.tt)) {
            viewC = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).c(this.tt);
        } else {
            viewC = new TopLayoutImpl(topProxyLayout.getContext()).c(this.tt);
        }
        if (viewC != null) {
            this.ve = (com.byazt.ge.c) viewC;
        } else {
            m.uj("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            c(topProxyLayout, viewC, (ViewGroup) parent);
        }
    }

    private void c(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void c(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setVisible(z);
        }
    }

    public void tt(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowDislike(z);
        }
    }

    public void ve(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setDislikeLeft(z);
        }
    }

    public void uj(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setSoundMute(z);
        }
    }

    public void n(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowSound(z);
        }
    }

    public void a(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowBack(z);
        }
    }

    public void c(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(z, str, str2, z2, z3);
        }
    }

    public void c(String str, String str2, boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(str, str2, z);
        }
    }

    public void c() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void tt() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.tt();
        }
    }

    public void ve() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.ve();
        }
    }

    public View uj() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            return cVar.getCloseButton();
        }
        return null;
    }

    public boolean n() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            return cVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void c(int i) {
        if (i == 2) {
            c(this.x);
        } else if (i == 4) {
            c(this.i);
        } else {
            c(this.sp);
        }
    }

    public void c(com.byazt.ge.tt ttVar) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setListener(ttVar);
        }
    }

    public void sp(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowAgain(z);
        }
    }

    public void c(String str) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setPlayAgainEntranceText(str);
        }
    }

    public void tt(String str) {
        TextView textView = this.uj;
        if (textView != null) {
            textView.setText(str);
            this.uj.setVisibility(0);
            this.uj.postDelayed(new Runnable() { // from class: com.byazt.kcl.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.uj.setVisibility(8);
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    public void a() {
        UgenBanner ugenBanner = this.n;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c(this.tt, this.f2404a);
    }

    public void sp() {
        UgenBanner ugenBanner = this.n;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c();
    }

    public void c(ic icVar) {
        com.byazt.ge.a aVar = this.sp;
        if (aVar != null) {
            aVar.c(icVar);
        }
        com.byazt.ge.uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.c(icVar);
        }
        com.byazt.ge.n nVar = this.i;
        if (nVar != null) {
            nVar.c(icVar);
        }
    }
}
