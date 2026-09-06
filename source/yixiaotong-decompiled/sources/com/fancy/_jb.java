package com.fancy;

import android.content.Context;
import android.widget.FrameLayout;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _jb extends FrameLayout {
    public _jb(Context context) {
        super(context, null, 0);
    }

    public abstract void _a();

    public abstract void _a(int i);

    public abstract void _b();

    public abstract _j9 getInfo();

    public abstract PtgCoreVideo getVideoPlayer();

    public abstract void setInfo(_j9 _j9Var);

    public abstract void setVideoPlayer(PtgCoreVideo ptgCoreVideo);
}
