package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.DislikeInfo;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.base.g.j.d.d1;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.common.f.c0;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseAdView<Ad extends BaseAd> extends RelativeLayout implements IAdView {
    private static final String LOG_TAG = "BaseAdView";
    private static final int VIEW_ATTACHED_TIMEOUT = 500;
    private static final int WAIT_TIMEOUT = 10000;
    protected Context context;
    private DislikeItemClickListener dislikeItemClickListener;
    private Point downTouchPoint;
    private String exposureId;
    private com.hihonor.adsdk.base.widget.a.c.a holder;
    protected boolean isClickable;
    protected Ad mAd;
    protected AdFlagCloseView mAdCloseView;
    protected com.hihonor.adsdk.base.widget.a.c mAdapter;
    protected e mController;
    protected com.hihonor.adsdk.base.widget.a.b mDataSetObserver;
    private final Handler mHandler;
    private int mOrientation;
    private int mScreenLayout;
    protected final c0 mViewMonitor;
    private float pressure;
    private Point upTouchPoint;
    private long viewAttachedWinSta;

    class a extends c0 {
        a(View view) {
            super(view);
        }

        @Override // com.hihonor.adsdk.common.f.c0
        protected void hnadsa(long j, int i) {
            super.hnadsa(j, i);
            com.hihonor.adsdk.common.b.b.hnadsa(BaseAdView.LOG_TAG, "onViewHide#showDuration %s, showPercent %s", Long.valueOf(j), Integer.valueOf(i));
        }

        @Override // com.hihonor.adsdk.common.f.c0
        protected void hnadsj() {
            super.hnadsj();
            BaseAdView.this.onImpression();
        }
    }

    class b implements DislikeItemClickListener {
        b() {
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onCancel() {
            com.hihonor.adsdk.common.b.b.hnadsc(BaseAdView.LOG_TAG, "onItemCancel.", new Object[0]);
            DislikeItemClickListener dislikeItemClickListener = BaseAdView.this.dislikeItemClickListener;
            if (dislikeItemClickListener != null) {
                dislikeItemClickListener.onCancel();
            }
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onFeedItemClick(int i, DislikeInfo dislikeInfo, View view) {
            BaseAdView.this.onItemClick(i, dislikeInfo, view);
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onShow() {
            com.hihonor.adsdk.common.b.b.hnadsc(BaseAdView.LOG_TAG, "onItemShow.", new Object[0]);
            DislikeItemClickListener dislikeItemClickListener = BaseAdView.this.dislikeItemClickListener;
            if (dislikeItemClickListener != null) {
                dislikeItemClickListener.onShow();
            }
        }
    }

    private static class c implements Runnable {
        private final String hnadsd;
        private final com.hihonor.adsdk.base.g.j.d.h1.a hnadse;

        public c(BaseAd baseAd) {
            this.hnadsd = baseAd.getAdUnitId();
            this.hnadse = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.hihonor.adsdk.common.b.b.hnadsc(BaseAdView.LOG_TAG, "view add to page timeout, millis is %s", 10000);
            new d1(ErrorCode.HI_AD_VIEW_ADD_TIME_OUT, this.hnadsd, this.hnadse).hnadse();
        }
    }

    public class d implements com.hihonor.adsdk.base.widget.a.b {
        public d() {
        }

        @Override // com.hihonor.adsdk.base.widget.a.b
        public void hnadsa() {
            BaseAdView.this.notifyAllChildView();
        }
    }

    public BaseAdView(Context context) {
        this(context, null);
    }

    private void attachedToWindow() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "BaseAdView#attachedToWindow", new Object[0]);
        this.viewAttachedWinSta = System.currentTimeMillis();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mViewMonitor.hnadsg();
    }

    private void compareConfig(final Configuration configuration) {
        if ((this.mOrientation == configuration.orientation && this.mScreenLayout == configuration.screenLayout) || this.mAdapter == null || this.holder == null) {
            return;
        }
        post(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.BaseAdView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m903xbe061215(configuration);
            }
        });
    }

    private void detachedFromWindow() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "BaseAdView#detachedFromWindow", new Object[0]);
        this.mViewMonitor.hnadsf();
        this.viewAttachedWinSta = 0L;
    }

    private void initExposureId() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "call init exposure id", new Object[0]);
        if (hasAd()) {
            this.exposureId = this.mAd.getRequestId() + this.mAd.getAdId();
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "init exposure id： " + this.exposureId, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllChildView() {
        View viewHnadsb;
        Configuration configuration = getResources().getConfiguration();
        this.mOrientation = configuration.orientation;
        this.mScreenLayout = configuration.screenLayout;
        if (this.mAdapter == null) {
            return;
        }
        if (!hasAd()) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "notifyAllChildView : ad is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.widget.a.c.a aVar = this.holder;
        if (aVar != null) {
            aVar.hnadsd();
            removeAllViews();
        }
        com.hihonor.adsdk.base.widget.a.c.a aVarHnadsa = this.mAdapter.hnadsa(this.context);
        this.holder = aVarHnadsa;
        if (aVarHnadsa != null && (viewHnadsb = aVarHnadsa.hnadsb()) != null) {
            addView(viewHnadsb, new RelativeLayout.LayoutParams(-1, -2));
            this.mAdapter.hnadsa(this.holder);
            this.mAdCloseView = this.holder.hnadsa();
            this.holder.hnadsa(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.BaseAdView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.triggerClick(view);
                }
            });
            AdFlagCloseView adFlagCloseView = this.mAdCloseView;
            if (adFlagCloseView != null) {
                adFlagCloseView.setBaseAd(this.mAd);
            }
        }
        DislikeItemClickListener dislikeItemClickListener = this.dislikeItemClickListener;
        if (dislikeItemClickListener != null) {
            setDislikeItemClickListener(dislikeItemClickListener);
        }
    }

    private void onAdClicked() {
        Ad ad = this.mAd;
        AdListener adListener = ad != null ? ad.getAdListener() : null;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    private void onAdClosed() {
        Ad ad = this.mAd;
        AdListener adListener = ad != null ? ad.getAdListener() : null;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    private void onAdImpression() {
        Ad ad = this.mAd;
        AdListener adListener = ad != null ? ad.getAdListener() : null;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    protected void bindAd(Ad ad) throws IllegalArgumentException {
        boolean zIsAttachedToWindow = isAttachedToWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "child bind base ad data. ad:" + (ad == null) + ";isAttachedToWindow:" + zIsAttachedToWindow, new Object[0]);
        if (ad == null) {
            new com.hihonor.adsdk.base.g.j.d.j1.b(ErrorCode.AD_BIND_VIEW_ERR, "ad is null.AD bind to view，but has err.", "", com.hihonor.adsdk.base.g.j.g.b.hnadsb()).hnadse();
            throw new IllegalArgumentException("Expect ad data to be not empty, actual ad data is empty.");
        }
        new com.hihonor.adsdk.base.g.j.d.j1.b(0, ErrorCode.STR_AD_BIND_VIEW, ad.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(ad)).hnadse();
        String str = ad.getRequestId() + ad.getAdId();
        if (this.mAd != null && !TextUtils.equals(str, this.exposureId)) {
            onDestroy();
        }
        if (zIsAttachedToWindow) {
            detachedFromWindow();
        }
        setData(ad);
        if (zIsAttachedToWindow) {
            attachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downTouchPoint.set((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 1) {
            this.upTouchPoint.set((int) motionEvent.getX(), (int) motionEvent.getY());
            this.pressure = motionEvent.getPressure();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected Ad getAd() {
        return this.mAd;
    }

    protected int getBorderRadius(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "get border radius", new Object[0]);
        Ad ad = this.mAd;
        if (ad != null && ad.getStyle() != null) {
            return this.mAd.getStyle().getBorderRadius();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "get border radius,but mAd || style is null.", new Object[0]);
        return i;
    }

    protected boolean hasAd() {
        return this.mAd != null;
    }

    protected abstract void initView();

    protected boolean isExposure() {
        boolean zHnadsb = com.hihonor.adsdk.base.g.e.hnadsb(this.exposureId);
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "Call isExposure. result: " + zHnadsb, new Object[0]);
        return zHnadsb;
    }

    /* JADX INFO: renamed from: lambda$compareConfig$1$com-hihonor-adsdk-base-widget-base-BaseAdView, reason: not valid java name */
    /* synthetic */ void m903xbe061215(Configuration configuration) {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "compareConfig onBindDataToHolder", new Object[0]);
        this.mAdapter.hnadsa(this.holder);
        this.mOrientation = configuration.orientation;
        this.mScreenLayout = configuration.screenLayout;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "onAttachedToWindow hashCode:" + hashCode(), new Object[0]);
        attachedToWindow();
        compareConfig(getResources().getConfiguration());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "onConfigurationChanged ", new Object[0]);
        compareConfig(configuration);
    }

    protected void onDestroy() {
        if (isExposure()) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "detachedFromWindow now to onDestroy", new Object[0]);
            return;
        }
        if (this.mAd == null) {
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_NULL_AD, ErrorCode.REPORT_AD_NULL_AD).hnadse();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.mAd);
        if (jCurrentTimeMillis - this.viewAttachedWinSta < 500) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "detachedFromWindow difference < VIEW_Attached_TIMEOUT", new Object[0]);
            new s0(ErrorCode.c.hnadsh, "", this.mAd.getAdUnitId(), aVarHnadsa).hnadse();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "detachedFromWindow difference > VIEW_Attached_TIMEOUT", new Object[0]);
        t tVar = new t(ErrorCode.c.hnadse, ErrorCode.c.hnadsf);
        Ad ad = this.mAd;
        tVar.hnadsa(ad, ad.getTrackUrl().getCommons());
        new s0(ErrorCode.c.hnadse, "", this.mAd.getAdUnitId(), aVarHnadsa).hnadse();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "onDetachedFromWindow hashCode:" + hashCode(), new Object[0]);
        onDestroy();
        detachedFromWindow();
    }

    protected void onImpression() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "Call onImpression.", new Object[0]);
        if (isExposure()) {
            return;
        }
        com.hihonor.adsdk.base.g.e.hnadsa(this.exposureId);
        this.mController.hnadsa(this);
        onAdImpression();
        this.mViewMonitor.hnadsl();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.mController.hnadsb();
        } else {
            this.mController.hnadsa();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "onWindowVisibilityChanged  visibility == VISIBLE ：" + (i == 0), new Object[0]);
        if (i == 0 && this.mViewMonitor.hnadsd()) {
            onImpression();
        }
    }

    public void release() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "BaseAdView#release ", new Object[0]);
        this.mHandler.removeCallbacksAndMessages(null);
        com.hihonor.adsdk.base.widget.a.c.a aVar = this.holder;
        if (aVar != null) {
            aVar.hnadsc();
        }
        e eVar = this.mController;
        if (eVar != null) {
            eVar.hnadsc();
        }
        if (this.dislikeItemClickListener != null) {
            this.dislikeItemClickListener = null;
        }
        if (isExposure() || !hasAd()) {
            return;
        }
        new d1(ErrorCode.AD_VIEW_RELEASE_BUT_WITHOUT_EXPOSURE, this.mAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.mAd)).hnadse();
    }

    protected void setAdapter(com.hihonor.adsdk.base.widget.a.c<? extends com.hihonor.adsdk.base.widget.a.c.a> cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "setAdapter", new Object[0]);
        com.hihonor.adsdk.base.widget.a.c cVar2 = this.mAdapter;
        if (cVar2 != null) {
            cVar2.hnadsb(this.mDataSetObserver);
        }
        this.mAdapter = cVar;
        if (cVar != null) {
            cVar.hnadsa(this.mDataSetObserver);
        }
        notifyAllChildView();
    }

    protected <Controller extends e> void setController(Controller controller) {
        if (Objects.isNull(controller)) {
            return;
        }
        this.mController = controller;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener onClickListener) {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.BaseAdView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m904xd27d0b62(onClickListener, view);
            }
        });
    }

    protected void triggerClick(View view) {
        triggerClick(view, 3);
    }

    protected void updateCloseView() {
        Ad ad;
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "update close view", new Object[0]);
        if (this.mAdCloseView == null || (ad = this.mAd) == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, (this.mAdCloseView == null ? "close view" : "baseAd").concat(" is null"), new Object[0]);
            return;
        }
        int adFlag = ad.getAdFlag();
        int closeFlag = this.mAd.getCloseFlag();
        if (adFlag == 0 && closeFlag == 0) {
            this.mAdCloseView.setVisibility(8);
        } else {
            this.mAdCloseView.setAdFlagShow(this.mAd.getAdFlag() == 1);
            this.mAdCloseView.setCloseIconShow(this.mAd.getCloseFlag() == 1);
        }
        this.mAdCloseView.setBaseAd(this.mAd);
    }

    public BaseAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void init(Context context) {
        this.context = context;
        this.mController = new e();
        this.downTouchPoint = new Point();
        this.upTouchPoint = new Point();
        this.mDataSetObserver = new d();
        setOnClickListener(null);
        initView();
    }

    private void setData(Ad ad) {
        this.mAd = ad;
        this.mController.hnadsa(ad);
        initExposureId();
        updateCloseView();
        this.mHandler.postDelayed(new c(ad), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: renamed from: lambda$setOnClickListener$0$com-hihonor-adsdk-base-widget-base-BaseAdView, reason: not valid java name */
    /* synthetic */ void m904xd27d0b62(View.OnClickListener onClickListener, View view) {
        if (!this.isClickable) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "isClickable is false", new Object[0]);
            return;
        }
        triggerClick(view);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.IAdView
    public void setAdCloseView(AdFlagCloseView adFlagCloseView) {
        this.mAdCloseView = adFlagCloseView;
        if (adFlagCloseView == null || !hasAd()) {
            return;
        }
        this.mAdCloseView.setBaseAd(this.mAd);
    }

    @Override // com.hihonor.adsdk.base.widget.base.IAdView
    public void setDislikeItemClickListener(DislikeItemClickListener dislikeItemClickListener) {
        AdFlagCloseView adFlagCloseView = this.mAdCloseView;
        if (adFlagCloseView != null) {
            adFlagCloseView.setDislikeItemClickListener(new b());
        }
        this.dislikeItemClickListener = dislikeItemClickListener;
    }

    protected void triggerClick(View view, int i) {
        int iIntValue;
        Object tag = view.getTag(R.id.ad_common_click_type_tag);
        if (tag instanceof Integer) {
            iIntValue = ((Integer) tag).intValue();
        } else {
            iIntValue = 1;
            if (i != 0) {
                if (i != 1) {
                    iIntValue = i != 2 ? 0 : 3;
                } else {
                    iIntValue = 4;
                }
            }
        }
        this.mController.hnadsa(this.downTouchPoint, this.upTouchPoint, iIntValue, this.pressure, 0);
        this.mController.hnadsd();
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "triggerClick#click type is %s, ad is" + this.mAd, Integer.valueOf(iIntValue));
        onAdClicked();
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isClickable = true;
        this.mViewMonitor = new a(this);
        this.mHandler = new Handler(Looper.getMainLooper());
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int i, DislikeInfo dislikeInfo, View view) {
        DislikeItemClickListener dislikeItemClickListener = this.dislikeItemClickListener;
        if (dislikeItemClickListener != null) {
            dislikeItemClickListener.onFeedItemClick(i, dislikeInfo, view);
        }
        onAdClosed();
        Object[] objArr = new Object[1];
        objArr[0] = dislikeInfo != null ? dislikeInfo.getText() : "";
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "Call dislike item call back method. Click text:%s", objArr);
    }
}
