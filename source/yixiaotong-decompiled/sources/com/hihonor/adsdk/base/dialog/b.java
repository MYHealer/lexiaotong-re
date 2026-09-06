package com.hihonor.adsdk.base.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "InstallNotifyViewFactory";

    public static View hnadsa(Context context, InstallNotifyBean installNotifyBean, int i) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "createView context is null", new Object[0]);
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(i, new RelativeLayout(context));
        if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "createView installNotifyBean is null", new Object[0]);
            return viewInflate;
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ad_install_notify_image);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ad_install_notify_brand_tv);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ad_install_notify_title_tv);
        hnadsa(HnAds.get().getContext(), installNotifyBean, imageView, j.hnadsa(HnAds.get().getContext(), 12.0f));
        textView.setText(installNotifyBean.getBrand());
        String title = installNotifyBean.getTitle();
        if (TextUtils.isEmpty(title) || installNotifyBean.getPkgType() == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "createView hide adTitleTv", new Object[0]);
            textView2.setVisibility(8);
        } else {
            textView2.setText(title);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "createView hide adTitleTv=" + u.hnadsc(context), new Object[0]);
        if (!u.hnadsc(context)) {
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ad_down_root);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.width = (u.hnadsf() / 2) + (j.hnadsa(context, 12.0f) * 2);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "initView current width is " + layoutParams.width, new Object[0]);
            relativeLayout.setLayoutParams(layoutParams);
        }
        return viewInflate;
    }

    private static void hnadsa(Context context, InstallNotifyBean installNotifyBean, ImageView imageView, int i) {
        if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "guideDialogBean is null", new Object[0]);
            return;
        }
        String logo = installNotifyBean.getLogo();
        if (TextUtils.isEmpty(logo) && installNotifyBean.getImgUrls() != null && installNotifyBean.getImgUrls().size() > 0) {
            logo = installNotifyBean.getImgUrls().get(0);
        }
        GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl(logo).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(installNotifyBean)).setAdUnitId(installNotifyBean.getAdUnitId()).setCornerRadius(i).setImageView(imageView);
        imageView2.setCommonTrackUrls(installNotifyBean.getCommonUrls());
        imageView2.build().loadImage();
    }
}
