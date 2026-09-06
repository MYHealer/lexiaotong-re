package com.jd.ad.sdk.jad_n_an;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: compiled from: JADSwipeView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_na extends View {
    public View jad_n_an;
    public LinearLayout jad_n_bo;
    public ObjectAnimator jad_n_cp;
    public ObjectAnimator jad_n_dq;

    /* JADX INFO: compiled from: JADSwipeView.java */
    public class jad_n_an implements View.OnAttachStateChangeListener {
        public jad_n_an() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            ObjectAnimator objectAnimator2 = jad_n_na.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            ObjectAnimator objectAnimator2 = jad_n_na.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.end();
            }
        }
    }

    public jad_n_na(Context context) {
        super(context);
        jad_n_an(context);
        jad_n_an();
    }

    public View getView() {
        return this.jad_n_an;
    }

    public final void jad_n_an(Context context) {
        try {
            View viewInflate = View.inflate(context, ResourceUtils.getResourceId(context, "jad_swipe_template", TtmlNode.TAG_LAYOUT), null);
            this.jad_n_an = viewInflate;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(ResourceUtils.getResourceId(context, "liner_swipe_template", "id"));
            this.jad_n_bo = linearLayout;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, -30.0f, 0.0f);
            this.jad_n_cp = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setRepeatCount(4);
            this.jad_n_cp.setDuration(1500L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.jad_n_bo, "alpha", 1.0f, 0.7f, 1.0f);
            this.jad_n_dq = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1500L);
            this.jad_n_dq.setRepeatCount(4);
        } catch (Exception e) {
            Logger.w(a.a("JADSwipeView initView error :").append(Log.getStackTraceString(e)).toString(), new Object[0]);
        }
    }

    public final void jad_n_an() {
        LinearLayout linearLayout;
        if (this.jad_n_an == null || (linearLayout = this.jad_n_bo) == null || this.jad_n_cp == null || this.jad_n_dq == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new jad_n_an());
    }
}
