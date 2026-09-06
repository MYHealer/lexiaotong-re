package com.jd.ad.sdk.jad_ly;

import android.animation.Animator;
import android.content.Context;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: compiled from: VideoRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu implements Animator.AnimatorListener {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ VideoRenderView jad_bo;

    public jad_hu(VideoRenderView videoRenderView, Context context) {
        this.jad_bo = videoRenderView;
        this.jad_an = context;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Logger.d("onAnimationCancel动画取消");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Logger.d("onAnimationRepeat动画重复");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        VideoRenderView videoRenderView = this.jad_bo;
        VideoInteractionListener videoInteractionListener = videoRenderView.jad_qd;
        if (videoInteractionListener == null || videoRenderView.jad_yl < 0) {
            return;
        }
        videoRenderView.jad_yl = -1;
        videoInteractionListener.onAdCountdown(0);
        this.jad_bo.jad_qd.onVideoAnimationEnd();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Context context = this.jad_an;
        if (context == null) {
            return;
        }
        VideoRenderView videoRenderView = this.jad_bo;
        if (videoRenderView.jad_pc == 2) {
            if (videoRenderView.jad_jw == 0.0f && videoRenderView.jad_ly == 0.0f) {
                videoRenderView.jad_jw = 15.0f;
            }
            jad_iv jad_ivVar = new jad_iv(videoRenderView, context, videoRenderView.jad_jw, videoRenderView.jad_ly, videoRenderView.jad_mz);
            videoRenderView.jad_hu = jad_ivVar;
            jad_ivVar.register();
        }
    }
}
