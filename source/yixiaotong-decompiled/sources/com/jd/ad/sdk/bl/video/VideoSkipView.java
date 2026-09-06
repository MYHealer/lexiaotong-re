package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.R;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class VideoSkipView extends FrameLayout {
    public int jad_an;
    public jad_bo jad_bo;
    public TextView jad_cp;
    public boolean jad_dq;
    public final Runnable jad_er;

    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoSkipView videoSkipView = VideoSkipView.this;
            TextView textView = videoSkipView.jad_cp;
            if (textView == null) {
                return;
            }
            if (videoSkipView.jad_an > 5) {
                textView.setText("跳过");
            } else {
                textView.setText(String.format(Locale.getDefault(), "跳过 %d", Integer.valueOf(VideoSkipView.this.jad_an)));
            }
            VideoSkipView videoSkipView2 = VideoSkipView.this;
            if (videoSkipView2.jad_dq) {
                jad_bo jad_boVar = videoSkipView2.jad_bo;
                if (jad_boVar != null) {
                    int i = videoSkipView2.jad_an;
                    VideoInteractionListener videoInteractionListener = ((jad_cp) jad_boVar).jad_an.jad_qd;
                    if (videoInteractionListener != null) {
                        videoInteractionListener.onAdCountdown(i);
                    }
                }
                VideoSkipView.this.jad_an--;
            }
            VideoSkipView videoSkipView3 = VideoSkipView.this;
            if (videoSkipView3.jad_an >= 0) {
                videoSkipView3.postDelayed(videoSkipView3.jad_er, 1000L);
                return;
            }
            jad_bo jad_boVar2 = videoSkipView3.jad_bo;
            if (jad_boVar2 != null) {
                jad_cp jad_cpVar = (jad_cp) jad_boVar2;
                VideoRenderView videoRenderView = jad_cpVar.jad_an;
                VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_an);
                VideoInteractionListener videoInteractionListener2 = jad_cpVar.jad_an.jad_qd;
                if (videoInteractionListener2 != null) {
                    videoInteractionListener2.onAdTimeOver();
                }
                VideoSkipView videoSkipView4 = jad_cpVar.jad_an.jad_ju;
                if (videoSkipView4 != null) {
                    videoSkipView4.removeCallbacks(null);
                }
            }
        }
    }

    public interface jad_bo {
    }

    public VideoSkipView(Context context) {
        super(context);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    public final void jad_an(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.jad_video_skip_btn_layout, (ViewGroup) null);
            this.jad_cp = (TextView) viewInflate.findViewById(R.id.jad_tv_video_count);
            addView(viewInflate);
        } catch (Exception e) {
            Logger.w("Exception while splash video skip init: " + e, new Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_dq = z;
    }

    public void setTotalCount(int i) {
        this.jad_an = i;
        TextView textView = this.jad_cp;
        if (textView == null) {
            return;
        }
        if (i > 5) {
            textView.setText("跳过");
        } else {
            textView.setText(String.format(Locale.getDefault(), "跳过 %d", Integer.valueOf(this.jad_an)));
        }
    }

    public VideoSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    public VideoSkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }

    public VideoSkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jad_dq = true;
        this.jad_er = new jad_an();
        jad_an(context);
    }
}
