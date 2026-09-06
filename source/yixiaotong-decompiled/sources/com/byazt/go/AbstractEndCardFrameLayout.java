package com.byazt.go;

import android.widget.FrameLayout;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.hkv.tt;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 1225, 2170})
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    public final TTBaseVideoActivity c;
    public final ic tt;

    public abstract void c();

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void setClickListener(tt ttVar);

    public void tt() {
    }

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity);
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        c();
    }
}
