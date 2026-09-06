package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.base.e;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.base.widget.web.WebPermissionsActivity;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.AdVideoSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    private static final String hnadsa = "VideoAdPictureTextFactory";
    private static final String hnadsb = "v";
    private static final long hnadsc = 1000;
    private static final int hnadsd = 10;
    private static final int hnadse = 0;
    private static final String hnadsf = "00";
    private static final String hnadsg = ":";

    public static View hnadsa(final Context context, final BaseAd baseAd, boolean z, int i) {
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ad_image);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ad_brand);
        HnDownloadButton hnDownloadButton = (HnDownloadButton) viewInflate.findViewById(R.id.ad_download);
        if (TextUtils.isEmpty(baseAd.getBrand())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "createVideoAdFloatView,brand is empty", new Object[0]);
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(baseAd.getBrand());
        }
        hnadse(baseAd, viewInflate);
        hnadsf(baseAd, viewInflate);
        if (z) {
            hnDownloadButton.setBaseAd(baseAd, 0);
        } else {
            hnDownloadButton.setBaseAd(baseAd, 1);
        }
        viewInflate.post(new Runnable() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.hnadsa(context, baseAd, imageView);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsb(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsd(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_developer_not_provide_privacy));
    }

    public static void hnadse(BaseAd baseAd, View view) {
        TextView textView = (TextView) view.findViewById(R.id.ad_company_name);
        TextView textView2 = (TextView) view.findViewById(R.id.ad_version);
        TextView textView3 = (TextView) view.findViewById(R.id.ad_title);
        if (baseAd.getPromotionPurpose() != 0 && baseAd.getPromotionPurpose() != 4) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            if (TextUtils.isEmpty(baseAd.getTitle())) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setVideoAdFloatViewPartOne,title is empty", new Object[0]);
                textView3.setVisibility(8);
                return;
            } else {
                textView3.setVisibility(0);
                textView3.setText(baseAd.getTitle());
                return;
            }
        }
        textView3.setVisibility(8);
        if (TextUtils.isEmpty(baseAd.getDeveloperName())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setVideoAdFloatViewPartOne,developerName is empty", new Object[0]);
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(baseAd.getDeveloperName());
        }
        if (TextUtils.isEmpty(baseAd.getAppVersion())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setVideoAdFloatViewPartOne,appVersion is empty", new Object[0]);
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText("v" + baseAd.getAppVersion());
        }
    }

    public static void hnadsf(final BaseAd baseAd, View view) {
        final View viewFindViewById = view.findViewById(R.id.ad_permissions);
        final View viewFindViewById2 = view.findViewById(R.id.ad_privacy);
        TextView textView = (TextView) view.findViewById(R.id.ad_source);
        if (baseAd.getPromotionPurpose() != 0 && baseAd.getPromotionPurpose() != 4) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            textView.setVisibility(8);
            return;
        }
        viewFindViewById.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPermissionsUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setVideoAdFloatViewPartTwo,permissionsUrl is empty", new Object[0]);
            if (c.hnadsc(baseAd)) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.hnadsa(viewFindViewById, view2);
                    }
                });
            } else {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.hnadsb(viewFindViewById, view2);
                    }
                });
            }
        } else {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.hnadsa(2, baseAd);
                }
            });
        }
        viewFindViewById2.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPrivacyAgreementUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setVideoAdFloatViewPartTwo,privacyAgreementUrl is empty", new Object[0]);
            if (c.hnadsc(baseAd)) {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.hnadsc(viewFindViewById2, view2);
                    }
                });
            } else {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.hnadsd(viewFindViewById2, view2);
                    }
                });
            }
        } else {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.hnadsa(1, baseAd);
                }
            });
        }
        hnadsa(textView, baseAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsc(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsb(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_developer_not_provide_introduce));
    }

    public static String hnadsb(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 0) {
            long j4 = j3 / 1000;
            return j4 < 10 ? String.valueOf(0) + j4 : String.valueOf(j4);
        }
        return String.valueOf(0);
    }

    public static HnPurePlayerView hnadsb(Context context, BaseAd baseAd) {
        HnPurePlayerView hnPurePlayerView = new HnPurePlayerView(context);
        hnPurePlayerView.bindAd(baseAd);
        return hnPurePlayerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(Context context, BaseAd baseAd, ImageView imageView) {
        hnadsa(context, baseAd, imageView, baseAd.getTrackUrl(), j.hnadsa(context, 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_reserve_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsa(int i, BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("handleStartPage type = " + i));
        com.hihonor.adsdk.base.g.b.hnadsa(i, baseAd);
        WebPermissionsActivity.hnadsb(baseAd, i);
    }

    private static void hnadsa(final TextView textView, final BaseAd baseAd) {
        if (TextUtils.isEmpty(baseAd.getIntroUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setSourceView,introUrl is empty", new Object[0]);
            if (baseAd.getPkgType() == 0) {
                if (TextUtils.isEmpty(baseAd.getHomePage())) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setSourceView,homePage is empty", new Object[0]);
                    textView.setVisibility(8);
                    return;
                } else {
                    textView.setVisibility(0);
                    textView.setText(textView.getContext().getText(R.string.ads_source_cn));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            b.hnadsa(3, baseAd);
                        }
                    });
                    return;
                }
            }
            textView.setVisibility(0);
            textView.setText(textView.getContext().getText(R.string.ads_introduce_cn));
            if (c.hnadsc(baseAd)) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.hnadsa(textView, view);
                    }
                });
                return;
            } else {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.hnadsb(textView, view);
                    }
                });
                return;
            }
        }
        textView.setVisibility(0);
        textView.setText(textView.getContext().getText(R.string.ads_introduce_cn));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.player.b$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.hnadsa(4, baseAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_reserve_developer_not_provide_introduce));
    }

    public static void hnadsa(BaseAd baseAd, e eVar) {
        if (eVar != null) {
            eVar.hnadsa(baseAd);
            eVar.hnadsd();
        }
    }

    public static void hnadsa(Context context, BaseAd baseAd, ImageView imageView, TrackUrl trackUrl, int i) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "VideoAdViewFactory#loadImage, baseAd is null", new Object[0]);
            return;
        }
        String logo = baseAd.getLogo();
        if (TextUtils.isEmpty(logo) && baseAd.getImages() != null && baseAd.getImages().size() > 0) {
            logo = baseAd.getImages().get(0);
        }
        GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl(logo).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius(i).setImageView(imageView);
        imageView2.setCommonTrackUrls(trackUrl.getCommons());
        imageView2.build().loadImage();
    }

    public static String hnadsa(long j, long j2) {
        long j3 = j2 - j;
        if (j3 >= 60000) {
            long j4 = j3 / 60000;
            long j5 = (j3 - (60000 * j4)) / 1000;
            return (j4 < 10 ? "0" + j4 : Long.valueOf(j4)) + ":" + (j5 < 10 ? "0" + j5 : Long.valueOf(j5));
        }
        long j6 = j3 / 1000;
        return "00:" + (j6 < 10 ? "0" + j6 : Long.valueOf(j6));
    }

    public static HnPictureTextPlayerView hnadsa(Context context, BaseAd baseAd) {
        HnPictureTextPlayerView hnPictureTextPlayerView = new HnPictureTextPlayerView(context);
        hnPictureTextPlayerView.bindAd(baseAd);
        hnPictureTextPlayerView.setPlayerViewCorners();
        return hnPictureTextPlayerView;
    }

    private static HnBasePlayerView hnadsa(Context context, BaseAd baseAd, int i) {
        if (i != 1) {
            return hnadsa(context, baseAd);
        }
        return hnadsb(context, baseAd);
    }

    public static HnBasePlayerView hnadsa(Context context, BaseAd baseAd, AdVideoSize adVideoSize, int i) {
        int iHnadsa;
        int iHnadsg;
        HnBasePlayerView hnBasePlayerViewHnadsa = hnadsa(context, baseAd, i);
        Video video = baseAd.getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#createVidePlayer#video is null.", new Object[0]);
            return null;
        }
        hnBasePlayerViewHnadsa.setMuted(video.getMute() == 0);
        AdVideoSize adVideoSize2 = new AdVideoSize(video.getVideoWidth(), video.getVideoHeight());
        if (video.getVideoWidth() >= video.getVideoHeight()) {
            if (adVideoSize != null) {
                iHnadsg = adVideoSize.getWidth();
            } else {
                iHnadsg = u.hnadsg() - u.hnadsa(48.0f);
            }
            hnBasePlayerViewHnadsa.setVideoViewSize(adVideoSize2, 1, iHnadsg);
        } else {
            if (adVideoSize != null) {
                iHnadsa = adVideoSize.getHeight();
            } else {
                iHnadsa = u.hnadsa(192.0f);
            }
            hnBasePlayerViewHnadsa.setVideoViewSize(adVideoSize2, 2, iHnadsa);
        }
        VideoReportBean videoReportBean = new VideoReportBean();
        videoReportBean.setAuStart(String.valueOf(video.getAutoPlay()));
        videoReportBean.setHasVoice(String.valueOf(video.getMute()));
        videoReportBean.setScene(String.valueOf(1));
        videoReportBean.setVideoType(String.valueOf(0));
        hnBasePlayerViewHnadsa.setVideoReportBean(videoReportBean);
        return hnBasePlayerViewHnadsa;
    }
}
