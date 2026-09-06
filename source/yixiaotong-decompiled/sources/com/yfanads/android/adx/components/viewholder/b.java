package com.yfanads.android.adx.components.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.components.base.i;
import com.yfanads.android.adx.components.template.AdxRewardVideoTemplateData;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: AdxRewardVideoViewHolder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b extends i {
    public final LinearLayout s;
    public final TextView t;
    public final ImageView u;
    public final RelativeLayout v;
    public final FrameLayout w;
    public final ImageView x;
    public final ImageView y;

    public b(View view) {
        super(view);
        this.x = (ImageView) view.findViewById(R.id.iv_reward_dialog_cancel);
        this.y = (ImageView) view.findViewById(R.id.iv_reward_dialog_button);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_reward_dialog_root);
        this.w = frameLayout;
        frameLayout.setVisibility(8);
        this.s = (LinearLayout) view.findViewById(R.id.layout_receive_reward);
        this.t = (TextView) view.findViewById(R.id.tev_receive_reward);
        this.u = (ImageView) view.findViewById(R.id.ad_image);
        this.v = (RelativeLayout) view.findViewById(R.id.ad_image_area);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        YFLog.debug("AdxRewardVideoViewHolder hideRewardDialogView");
        FrameLayout frameLayout = this.w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void b() {
        YFLog.debug("AdxRewardVideoViewHolder showRewardDialogView");
        FrameLayout frameLayout = this.w;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.viewholder.b$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    public static boolean a(AbstractNativeAd abstractNativeAd, AdxRewardVideoTemplateData adxRewardVideoTemplateData) {
        boolean z;
        TemplateConf templateConf;
        if (!TextUtils.isEmpty(abstractNativeAd.getDeepLink()) && (templateConf = adxRewardVideoTemplateData.conf) != null) {
            z = templateConf.cte == 1;
        }
        YFLog.debug("AdxRewardVideoViewHolder needShowRewardDialogView: " + z);
        return z;
    }
}
