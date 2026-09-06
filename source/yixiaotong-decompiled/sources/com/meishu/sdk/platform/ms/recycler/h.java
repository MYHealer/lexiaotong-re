package com.meishu.sdk.platform.ms.recycler;

import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;

/* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h implements RecyclerAdMediaListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5191a;
    public final /* synthetic */ i b;

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            if (h.this.f5191a.getVisibility() != 0) {
                h.this.f5191a.setVisibility(0);
            }
        }
    }

    public h(i iVar, ViewGroup viewGroup) {
        this.b = iVar;
        this.f5191a = viewGroup;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoStart() {
        this.f5191a.postDelayed(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoStart();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoCompleted() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoCompleted();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoError() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoError(-1, "视频加载出错");
        }
        this.b.a(-1, "视频加载出错");
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoLoaded() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoLoaded();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoPause() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoPause();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoResume() {
        ExpressMediaListener expressMediaListener = this.b.h;
        if (expressMediaListener != null) {
            expressMediaListener.onVideoResume();
        }
    }
}
