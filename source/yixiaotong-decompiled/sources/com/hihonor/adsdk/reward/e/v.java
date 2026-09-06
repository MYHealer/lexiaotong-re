package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.widget.RadiusLinearLayout;
import com.hihonor.adsdk.reward.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class v extends n {
    private static final String X = "RewardSmallHolder010001";

    public v(View view, Context context) {
        super(view, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RadiusLinearLayout radiusLinearLayout) {
        int measuredWidth = radiusLinearLayout.getMeasuredWidth();
        radiusLinearLayout.setRadius(this.g.getResources().getDimension(R.dimen.dimens_16));
        int dimension = (int) this.g.getResources().getDimension(R.dimen.dimens_200);
        int i = measuredWidth - dimension;
        com.hihonor.adsdk.common.b.b.hnadsc(X, "setVideoViewSize() containerWidth: " + measuredWidth + ", videoBaseSize: " + i, new Object[0]);
        this.I.setVideoViewSize(this.P, 1, i);
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        layoutParams.width = dimension;
        this.h.setBackgroundColor(this.g.getResources().getColor(R.color.color_191919));
        int dimension2 = (int) this.g.getResources().getDimension(R.dimen.dimens_16);
        this.h.setPadding(dimension2, dimension2, dimension2, dimension2);
        this.h.setLayoutParams(layoutParams);
    }

    @Override // com.hihonor.adsdk.reward.e.b
    protected void v() {
        final RadiusLinearLayout radiusLinearLayout = (RadiusLinearLayout) b(R.id.ad_reward_video_pt_container);
        if (radiusLinearLayout == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(X, "setVideoViewSize() radiusLinearLayout is null.", new Object[0]);
        } else {
            radiusLinearLayout.post(new Runnable() { // from class: com.hihonor.adsdk.reward.e.v$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(radiusLinearLayout);
                }
            });
        }
    }
}
