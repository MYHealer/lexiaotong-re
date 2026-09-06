package com.meishu.sdk.platform.gdt.paster;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.hihonor.adsdk.base.c;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.paster.b;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTPasterAdWrapper extends BasePlatformLoader<PasterAdLoader, b> {
    private final String TAG;
    private i aQuery;
    private ImageButton closeButton;
    private Button downloadButton;
    private GDTPasterAd gdtPasterAd;
    private NativeADEventListener nativeADEventListener;
    private NativeADUnifiedListener nativeADUnifiedListener;
    private NativeUnifiedAD nativeUnifiedAD;
    private NativeUnifiedADData nativeUnifiedADData;

    public GDTPasterAdWrapper(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo) {
        super(pasterAdLoader, sdkAdInfo);
        this.TAG = getClass().getName();
        this.nativeADUnifiedListener = new NativeADUnifiedListener() { // from class: com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper.1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                GDTPasterAdWrapper.this.nativeUnifiedADData = list.get(0);
                GDTPasterAdWrapper.this.initAd();
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                try {
                    LogUtil.e(GDTPasterAdWrapper.this.TAG, "onNoAD, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
                    new GDTPlatformError(adError, GDTPasterAdWrapper.this.getSdkAdInfo()).post(GDTPasterAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.nativeADEventListener = new NativeADEventListener() { // from class: com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper.5
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                try {
                    if (GDTPasterAdWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(GDTPasterAdWrapper.this.getSdkAdInfo().getClk())) {
                        LogUtil.d(GDTPasterAdWrapper.this.TAG, "send onADClicked");
                        z.a(GDTPasterAdWrapper.this.getContext(), f.a(GDTPasterAdWrapper.this.getSdkAdInfo().getClk(), GDTPasterAdWrapper.this.gdtPasterAd), new com.meishu.sdk.core.utils.i());
                    }
                    if (GDTPasterAdWrapper.this.gdtPasterAd.getInteractionListener() != null) {
                        GDTPasterAdWrapper.this.gdtPasterAd.getInteractionListener().onAdClicked();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                try {
                    new GDTPlatformError(adError, GDTPasterAdWrapper.this.getSdkAdInfo()).post(GDTPasterAdWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                try {
                    if (GDTPasterAdWrapper.this.getLoaderListener() != null) {
                        GDTPasterAdWrapper.this.getLoaderListener().onAdExposure();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                try {
                    GDTPasterAdWrapper gDTPasterAdWrapper = GDTPasterAdWrapper.this;
                    gDTPasterAdWrapper.updateAdAction(gDTPasterAdWrapper.downloadButton, GDTPasterAdWrapper.this.nativeUnifiedADData);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        try {
            if (!TextUtils.isEmpty(sdkAdInfo.getS2sb())) {
                try {
                    this.nativeUnifiedAD = new NativeUnifiedAD(getContext(), sdkAdInfo.getPid(), this.nativeADUnifiedListener, ((S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.nativeUnifiedAD == null) {
                this.nativeUnifiedAD = new NativeUnifiedAD(getContext(), sdkAdInfo.getPid(), this.nativeADUnifiedListener);
            }
            this.nativeUnifiedAD.setMaxVideoDuration(0);
            this.nativeUnifiedAD.setMinVideoDuration(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAd() {
        try {
            if (getLoaderListener() != null) {
                ViewGroup containerView = getAdLoader().getContainerView();
                NativeAdContainer nativeAdContainer = (NativeAdContainer) View.inflate(getContext(), R.layout.ms_gdt_paster_layout, getAdLoader().getContainerView());
                containerView.addView(nativeAdContainer);
                this.downloadButton = (Button) nativeAdContainer.findViewById(R.id.ms_btn_download);
                this.closeButton = (ImageButton) nativeAdContainer.findViewById(R.id.ms_btn_close);
                final MediaView mediaView = (MediaView) nativeAdContainer.findViewById(R.id.ms_gdt_media_view);
                final ImageView imageView = (ImageView) nativeAdContainer.findViewById(R.id.ms_img_poster);
                this.closeButton.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper.2
                    @Override // com.meishu.sdk.core.safe.o
                    public void safeOnClick(View view) {
                        GDTPasterAdWrapper.this.destroy();
                    }
                });
                this.aQuery = new i(nativeAdContainer);
                renderAdUi(this.nativeUnifiedADData);
                updateAdAction(this.downloadButton, this.nativeUnifiedADData);
                containerView.post(new l() { // from class: com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper.3
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        try {
                            imageView.setVisibility(8);
                            mediaView.setVisibility(0);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.downloadButton);
                this.nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, null, arrayList);
                this.nativeUnifiedADData.setNativeAdEventListener(this.nativeADEventListener);
                if (this.nativeUnifiedADData.getAdPatternType() == 2) {
                    this.nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(1).setAutoPlayMuted(true).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(true).setEnableUserControl(false).build(), new NativeADMediaListener() { // from class: com.meishu.sdk.platform.gdt.paster.GDTPasterAdWrapper.4
                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoClicked() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoClicked");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoCompleted() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoCompleted: ");
                            if (GDTPasterAdWrapper.this.getLoaderListener() != null) {
                                GDTPasterAdWrapper.this.getLoaderListener().onVideoComplete();
                            }
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoError(AdError adError) {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoError: ");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoInit() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoInit: ");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoLoaded(int i) {
                            try {
                                LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoLoaded: ");
                                if (GDTPasterAdWrapper.this.getLoaderListener() != null) {
                                    GDTPasterAdWrapper.this.getLoaderListener().onVideoLoaded();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoLoading() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoLoading: ");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoPause() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoPause: ");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoReady() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoReady");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoResume() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoResume: ");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoStart() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoStart");
                        }

                        @Override // com.qq.e.ads.nativ.NativeADMediaListener
                        public void onVideoStop() {
                            LogUtil.d(GDTPasterAdWrapper.this.TAG, "onVideoStop");
                        }
                    });
                }
                this.gdtPasterAd = new GDTPasterAd(this.nativeUnifiedADData);
                getLoaderListener().onAdLoaded(this.gdtPasterAd);
                getLoaderListener().onAdReady(this.gdtPasterAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void renderAdUi(NativeUnifiedADData nativeUnifiedADData) {
        int adPatternType = nativeUnifiedADData.getAdPatternType();
        if (adPatternType == 1 || adPatternType == 2) {
            this.aQuery.b(R.id.ms_img_logo).a(nativeUnifiedADData.getIconUrl(), false);
            this.aQuery.b(R.id.ms_img_poster).a(nativeUnifiedADData.getImgUrl(), false);
            this.aQuery.b(R.id.ms_text_title).a(nativeUnifiedADData.getTitle());
            this.aQuery.b(R.id.ms_text_desc).a(nativeUnifiedADData.getDesc());
            return;
        }
        if (adPatternType == 3) {
            this.aQuery.b(R.id.ms_img_1).a(nativeUnifiedADData.getImgList().get(0), false);
            this.aQuery.b(R.id.ms_img_2).a(nativeUnifiedADData.getImgList().get(1), false);
            this.aQuery.b(R.id.ms_img_3).a(nativeUnifiedADData.getImgList().get(2), false);
            this.aQuery.b(R.id.ms_native_3img_title).a(nativeUnifiedADData.getTitle());
            this.aQuery.b(R.id.ms_native_3img_desc).a(nativeUnifiedADData.getDesc());
            return;
        }
        if (adPatternType == 4) {
            this.aQuery.b(R.id.ms_img_logo).a(nativeUnifiedADData.getImgUrl(), false);
            View view = this.aQuery.b(R.id.ms_img_poster).d;
            if (view != null) {
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(null);
                } else if (view instanceof WebView) {
                    WebView webView = (WebView) view;
                    webView.stopLoading();
                    webView.clearView();
                } else if (view instanceof TextView) {
                    ((TextView) view).setText("");
                }
            }
            this.aQuery.b(R.id.ms_text_title).a(nativeUnifiedADData.getTitle());
            this.aQuery.b(R.id.ms_text_desc).a(nativeUnifiedADData.getDesc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdAction(Button button, NativeUnifiedADData nativeUnifiedADData) {
        if (!nativeUnifiedADData.isAppAd()) {
            button.setText("浏览");
            return;
        }
        int appStatus = nativeUnifiedADData.getAppStatus();
        if (appStatus == 0) {
            button.setText(c.g1.hnadsa);
            return;
        }
        if (appStatus == 1) {
            button.setText("启动");
            return;
        }
        if (appStatus == 2) {
            button.setText("更新");
            return;
        }
        if (appStatus == 4) {
            button.setText(nativeUnifiedADData.getProgress() + "%");
            return;
        }
        if (appStatus == 8) {
            button.setText("安装");
        } else if (appStatus != 16) {
            button.setText("浏览");
        } else {
            button.setText("下载失败，重新下载");
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((PasterAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new com.meishu.sdk.core.utils.i());
            this.nativeUnifiedAD.loadData(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.nativeUnifiedADData != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.nativeUnifiedADData.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(i));
                    this.nativeUnifiedADData.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.nativeUnifiedADData.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
