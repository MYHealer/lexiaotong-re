package com.jd.ad.sdk.jad_ly;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.lottie.LottieAnimationView;

/* JADX INFO: compiled from: VideoRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt implements View.OnTouchListener {
    public int jad_an;
    public int jad_bo;
    public final /* synthetic */ Context jad_cp;
    public final /* synthetic */ VideoRenderView jad_dq;

    public jad_jt(VideoRenderView videoRenderView, Context context) {
        this.jad_dq = videoRenderView;
        this.jad_cp = context;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0078  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_an = x;
            this.jad_bo = y;
        } else {
            if (action != 1) {
                return true;
            }
            VideoRenderView videoRenderView = this.jad_dq;
            Context context = this.jad_cp;
            float f = this.jad_an;
            float f2 = this.jad_bo;
            float f3 = x;
            float f4 = y;
            float f5 = videoRenderView.jad_kx;
            float f6 = videoRenderView.jad_na;
            if (context == null) {
                z = false;
            } else {
                float f7 = f3 - f;
                float f8 = f4 - f2;
                if (f5 <= 0.0f) {
                    f5 = 1.0f;
                }
                if (f6 <= 0.0f) {
                    f6 = 45.0f;
                }
                float fSqrt = (float) Math.sqrt(Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d));
                float degrees = (float) Math.toDegrees(Math.atan2(Math.abs(f8), Math.abs(f7)));
                float f9 = 180.0f - f6;
                if (f8 >= 0.0f || fSqrt <= ScreenUtils.dip2px(context, f5) || degrees < f6 || degrees > f9) {
                    z = false;
                } else {
                    z = true;
                }
            }
            int iOrdinal = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
            LottieAnimationView lottieAnimationView = this.jad_dq.jad_tg;
            if (lottieAnimationView != null && x >= lottieAnimationView.getLeft() && x <= this.jad_dq.jad_tg.getRight() && y >= this.jad_dq.jad_tg.getTop() && y <= this.jad_dq.jad_tg.getBottom()) {
                VideoRenderView videoRenderView2 = this.jad_dq;
                VideoInteractionListener videoInteractionListener = videoRenderView2.jad_qd;
                if (videoInteractionListener != null) {
                    videoInteractionListener.onAdClicked(videoRenderView2.jad_pc, iOrdinal);
                    VideoRenderView videoRenderView3 = this.jad_dq;
                    videoRenderView3.jad_an(videoRenderView3.jad_kv.getWidth(), this.jad_dq.jad_kv.getHeight());
                }
            } else if (z) {
                int iOrdinal2 = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                VideoRenderView videoRenderView4 = this.jad_dq;
                VideoInteractionListener videoInteractionListener2 = videoRenderView4.jad_qd;
                if (videoInteractionListener2 != null) {
                    videoInteractionListener2.onAdClicked(videoRenderView4.jad_pc, iOrdinal2);
                    VideoRenderView videoRenderView5 = this.jad_dq;
                    videoRenderView5.jad_an(videoRenderView5.jad_kv.getWidth(), this.jad_dq.jad_kv.getHeight());
                }
            }
        }
        return true;
    }
}
