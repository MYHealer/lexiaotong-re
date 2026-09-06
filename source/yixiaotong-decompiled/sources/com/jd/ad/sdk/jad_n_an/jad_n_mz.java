package com.jd.ad.sdk.jad_n_an;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: compiled from: JADShakeView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_mz extends View {
    public View jad_n_an;
    public ImageView jad_n_bo;
    public ObjectAnimator jad_n_cp;
    public TextView jad_n_dq;
    public TextView jad_n_er;
    public String jad_n_fs;

    /* JADX INFO: compiled from: JADShakeView.java */
    public class jad_n_an implements Runnable {
        public jad_n_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = jad_n_mz.this.jad_n_bo;
            imageView.setPivotX(imageView.getWidth());
            ImageView imageView2 = jad_n_mz.this.jad_n_bo;
            imageView2.setPivotY(imageView2.getHeight());
        }
    }

    /* JADX INFO: compiled from: JADShakeView.java */
    public class jad_n_bo implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Context jad_n_an;

        public jad_n_bo(Context context) {
            this.jad_n_an = context;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = jad_n_mz.this.jad_n_an.getLayoutParams();
            if (layoutParams != null) {
                int i = layoutParams.width;
                int i2 = layoutParams.height;
                if (i > 0 && i2 > 0) {
                    float fDip2px = ((int) ScreenUtils.dip2px(this.jad_n_an, 100.0f)) * 1.0f;
                    float fMax = Math.max(i2 / fDip2px, i / fDip2px);
                    float fMin = Math.min(i2, i) / 2;
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jad_n_mz.this.jad_n_bo.getLayoutParams();
                    if (layoutParams2 != null) {
                        int i3 = (int) fMin;
                        layoutParams2.width = i3;
                        layoutParams2.height = i3;
                        int iDip2px = (int) ScreenUtils.dip2px(this.jad_n_an, 15.0f * fMax);
                        layoutParams2.gravity = 17;
                        layoutParams2.setMargins(0, iDip2px, 0, 0);
                        jad_n_mz.this.jad_n_bo.setLayoutParams(layoutParams2);
                    }
                    jad_n_mz.this.jad_n_dq.setTextSize(12.0f * fMax);
                    jad_n_mz.this.jad_n_er.setTextSize(fMax * 9.0f);
                }
            }
            jad_n_mz.this.jad_n_an.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: compiled from: JADShakeView.java */
    public class jad_n_cp implements View.OnAttachStateChangeListener {
        public jad_n_cp() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_mz.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_mz.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
        }
    }

    public jad_n_mz(Context context) {
        super(context);
        jad_n_an(context);
        jad_n_an();
    }

    public View getView() {
        return this.jad_n_an;
    }

    public final void jad_n_an(Context context) {
        try {
            View viewInflate = View.inflate(context, ResourceUtils.getResourceId(context, "jad_shake_template", TtmlNode.TAG_LAYOUT), null);
            this.jad_n_an = viewInflate;
            this.jad_n_bo = (ImageView) viewInflate.findViewById(ResourceUtils.getResourceId(context, "iv_shake_template", "id"));
            this.jad_n_dq = (TextView) this.jad_n_an.findViewById(ResourceUtils.getResourceId(context, "tv_shake_first_content", "id"));
            this.jad_n_er = (TextView) this.jad_n_an.findViewById(ResourceUtils.getResourceId(context, "tv_shake_second_content", "id"));
            if (this.jad_n_dq != null && !TextUtils.isEmpty(this.jad_n_fs)) {
                this.jad_n_dq.setText(this.jad_n_fs);
            }
            this.jad_n_bo.post(new jad_n_an());
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.jad_n_bo, Key.ROTATION, 0.0f, 30.0f, 0.0f, 30.0f, 0.0f);
            this.jad_n_cp = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1000L);
            this.jad_n_cp.setRepeatCount(-1);
            ViewTreeObserver viewTreeObserver = this.jad_n_an.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new jad_n_bo(context));
            }
        } catch (Exception e) {
            Logger.w(a.a("JADShakeView initView error :").append(Log.getStackTraceString(e)).toString(), new Object[0]);
        }
    }

    public jad_n_mz(Context context, String str) {
        super(context);
        this.jad_n_fs = str;
        jad_n_an(context);
        jad_n_an();
    }

    public void jad_n_an() {
        ImageView imageView;
        if (this.jad_n_an == null || (imageView = this.jad_n_bo) == null || this.jad_n_cp == null) {
            return;
        }
        imageView.addOnAttachStateChangeListener(new jad_n_cp());
    }
}
