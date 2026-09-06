package com.kwad.components.core.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e extends a implements cc.a {
    private View bZ;
    private final cc ca;
    private final AtomicBoolean cb;
    private boolean cc;
    private boolean cd;
    private final KsAdVideoPlayConfig ce;

    public final void setAutoRelease(boolean z) {
        this.cd = z;
    }

    public final void xH() {
        this.cc = false;
    }

    public e(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.ca = new cc(this);
        this.cb = new AtomicBoolean(true);
        this.cd = true;
        this.bZ = this;
        this.ce = ksAdVideoPlayConfig;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ae();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    private void ae() {
        if (this.cb.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewAttached");
            this.ca.sendEmptyMessage(1);
        }
    }

    public final void af() {
        if (this.cb.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewDetached");
        this.ca.removeCallbacksAndMessages(null);
        if (this.cd) {
            release();
        } else {
            this.aZI.pause();
        }
    }

    public final void xD() {
        this.ca.removeCallbacksAndMessages(null);
        if (this.cd) {
            release();
        } else {
            this.aZI.pause();
        }
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (!this.amd && message.what == 1) {
            if (!cb.r(this.bZ, 30)) {
                xj();
            } else if (!this.cc) {
                startPlay();
            }
            this.ca.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    protected final void startPlay() {
        if (this.aZI.isIdle()) {
            if (this.ams != null) {
                this.ams.onStart();
            }
            if (!aq.isNetworkConnected(this.mContext)) {
                xe();
                return;
            }
            xf();
            if (this.amd) {
                xi();
                this.aZI.start();
                return;
            } else if (ag()) {
                xi();
                this.aZI.start();
                return;
            } else if (this.amb) {
                xi();
                this.aZI.start();
                return;
            } else {
                xg();
                return;
            }
        }
        if (this.aZI.isPaused() || this.aZI.OO()) {
            xi();
            this.aZI.restart();
        }
    }

    private boolean ag() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return aq.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return aq.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return aq.isNetworkConnected(this.mContext);
                }
                return aq.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.helper.a.cj(this.mAdInfo)) {
            return aq.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.helper.a.ck(this.mAdInfo)) {
            return aq.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.components.core.video.a
    protected final void fI() {
        try {
            this.amt = com.kwad.sdk.wrapper.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, null);
            LinearLayout linearLayout = (LinearLayout) this.amt.findViewById(R.id.ksad_video_complete_app_container);
            this.ED = (ImageView) this.amt.findViewById(R.id.ksad_video_complete_app_icon);
            this.EE = (TextView) this.amt.findViewById(R.id.ksad_app_name);
            this.amp = (TextView) this.amt.findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.ED, com.kwad.sdk.core.response.helper.e.eT(this.mAdTemplate), this.mAdTemplate, 12);
            this.EE.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
            this.amp.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
            this.amo = linearLayout;
            this.ED.setOnClickListener(this);
            this.EE.setOnClickListener(this);
            this.amp.setOnClickListener(this);
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            this.mApkDownloadHelper.b(this.amu);
            if (xE()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ED.getLayoutParams();
                layoutParams.width = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                this.ED.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.EE.getLayoutParams();
                layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
                this.EE.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.amp.getLayoutParams();
                layoutParams3.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 26.0f);
                layoutParams3.height = com.kwad.sdk.c.a.a.a(this.mContext, 32.0f);
                layoutParams3.width = com.kwad.sdk.c.a.a.a(this.mContext, 72.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#FE3666"));
                gradientDrawable.setCornerRadius(com.kwad.sdk.c.a.a.a(this.mContext, 8.0f));
                gradientDrawable.setShape(0);
                this.amp.setTextSize(2, 12.0f);
                this.amp.setLayoutParams(layoutParams3);
                this.amp.setBackground(gradientDrawable);
            }
            this.amo.setOnClickListener(this);
            this.amo.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private boolean xE() {
        if (this.mAdTemplate.type == 21) {
            return this.mAdTemplate.defaultType == 1 || this.mAdTemplate.defaultType == 2;
        }
        return false;
    }

    public final void xF() {
        this.aZI.pause();
        this.cc = true;
    }

    public final void xG() {
        startPlay();
        this.cc = false;
    }
}
