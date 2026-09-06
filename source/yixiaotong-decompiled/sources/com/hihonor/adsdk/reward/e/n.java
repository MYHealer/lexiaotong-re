package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.widget.RadiusLinearLayout;
import com.hihonor.adsdk.reward.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n extends b {
    private static final String W = "RewardColumnVideoViewHolder";

    public n(View view, Context context) {
        super(view, context);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Video video = this.K;
        if ((video != null && video.getOrientation() == 0) || com.hihonor.adsdk.reward.c.a()) {
            com.hihonor.adsdk.common.b.b.hnadsc(W, "setColumnSystemLayout,top to bottom layout", new Object[0]);
            com.hihonor.adsdk.reward.c.a(this.g, "c3m12g12t3-c5m32g12t5-c7m48g12t7", measuredWidth, measuredHeight, this.A);
            com.hihonor.adsdk.reward.c.a(this.g, "c3m12g12t3-c5m32g12t5-c7m48g12t7", measuredWidth, measuredHeight, this.h);
            return;
        }
        Video video2 = this.K;
        if (video2 == null || video2.getOrientation() != 1) {
            com.hihonor.adsdk.common.b.b.hnadse(W, "Orientation error", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(W, "setColumnSystemLayout,left to right layout", new Object[0]);
        com.hihonor.adsdk.reward.c.a(this.g, com.hihonor.adsdk.reward.c.a(this.K) ? "c3m12g12t3-c10m24g12t12-c7m48g12t7" : "c3m12g12t3-c8m24g12t12-c7m48g12t7", measuredWidth, measuredHeight, (RadiusLinearLayout) b(R.id.ad_reward_video_pt_container));
    }

    private void x() {
        final View viewA = a(android.R.id.content);
        if (viewA == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(W, "setColumnSystemLayout() decorView is null.", new Object[0]);
        } else {
            viewA.post(new Runnable() { // from class: com.hihonor.adsdk.reward.e.n$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(viewA);
                }
            });
        }
    }
}
