package com.hihonor.adsdk.base.widget.download;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.f.i;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.common.f.b0;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnDownloadButton extends HnProgressButton {
    private static final String TAG_LOG = "HnDownloadButton";
    private final Point downTouchPoint;
    private a mAppearanceText;
    private BaseAd mBaseAd;
    private com.hihonor.adsdk.base.widget.download.d.a mDownloadButtonHandler;
    private View.OnClickListener onClickListener;
    private float pressure;
    private final Point upTouchPoint;

    public HnDownloadButton(Context context) {
        super(context);
        this.downTouchPoint = new Point();
        this.upTouchPoint = new Point();
    }

    private void reportAdClick() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "call reportAdClick.", new Object[0]);
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsa(this.downTouchPoint, this.upTouchPoint, this.pressure);
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

    @Override // com.hihonor.adsdk.base.widget.download.HnProgressButton
    protected void initData(Context context, AttributeSet attributeSet, int i) {
        setTag(R.id.ad_common_click_type_tag, 1);
        this.mAppearanceText = new a(this, context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadse();
        }
    }

    void onDownloadFail(g gVar) {
        boolean z = false;
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "onDownloadFail adDIInfo is null", new Object[0]);
            handleReset();
            return;
        }
        int iHnadsz = gVar.hnadsz();
        int iD = gVar.d();
        int iHnadsi = gVar.hnadsi();
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "onDownloadFail notifySource = %d, pkgType = %d, code = %d", Integer.valueOf(iHnadsz), Integer.valueOf(iD), Integer.valueOf(iHnadsi));
        if (gVar.d() != 2) {
            handleReset();
            return;
        }
        if (iHnadsz != 0) {
            handleReset();
            return;
        }
        if (iHnadsi == 10003) {
            b0.hnadsb(R.string.ads_download_no_network);
            return;
        }
        if (iHnadsi == -3) {
            b0.hnadsb(R.string.ads_download_app_removed_from_shelves);
            return;
        }
        if (iHnadsi != 10004 && iHnadsi != 10006) {
            handleReset();
            return;
        }
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        int iHnadsa = aVar != null ? aVar.hnadsa() : 0;
        if (getState() == 0 && iHnadsa == 1) {
            z = true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "onDownloadFail downloadType = %d, state = %d, isOpenLoadingPage = %s", Integer.valueOf(iHnadsa), Integer.valueOf(getState()), Boolean.valueOf(z));
        if (z) {
            return;
        }
        i.hnadsa(this.mBaseAd).hnadsb(2).hnadsa(10000).hnadsd();
    }

    void onDownloadPaused(int i) {
        pause(i);
    }

    void onDownloadSuccess() {
        installing();
    }

    void onDownloading(int i) {
        updateProgressBy(i);
    }

    void onInstallFail() {
        handleReset();
    }

    void onInstallSuccess() {
        complete();
    }

    void onInstalling() {
        installing();
    }

    public void onReserveFail() {
        handleReset();
    }

    public void onReserveSuccess() {
        onReserveComplete();
    }

    void onStartOrContinueDownLoad() {
        start();
    }

    public void setBaseAd(Object obj) {
        setBaseAd(obj, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void handleReset() {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(View view) {
        if (this.mBaseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "onDownloadAndInstallClick: baseAd is null", new Object[0]);
            return;
        }
        View.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        reportAdClick();
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsd();
        }
    }

    public String getAppPackageName() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd != null) {
            return baseAd.getAppPackage();
        }
        return null;
    }

    void onDownloadWait(int i) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsa(i);
        }
    }

    void onStatusNone() {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsb();
        }
    }

    public void setBaseAd(Object obj, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "call setBaseAd scene:%s", Integer.valueOf(i));
        if (obj instanceof BaseAd) {
            BaseAd baseAd = (BaseAd) obj;
            this.mBaseAd = baseAd;
            com.hihonor.adsdk.base.widget.download.d.a aVarHnadsa = com.hihonor.adsdk.base.widget.download.d.c.hnadsa(baseAd, this);
            this.mDownloadButtonHandler = aVarHnadsa;
            aVarHnadsa.hnadsa(this.mAppearanceText);
            this.mDownloadButtonHandler.hnadsa(this.mBaseAd, i);
            super.setOnClickListener(new com.hihonor.adsdk.base.callback.g(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.download.HnDownloadButton$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onClick(view);
                }
            }));
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[2];
        objArr[0] = ErrorCode.STR_AD_VIEW_SET_AD_FAIL;
        objArr[1] = obj == null ? "null" : com.hihonor.adsdk.base.j.g.hnadsa(obj);
        String str = String.format(locale, "method: DownloadButton setBaseAd,msg:%s, baseAd gson is:%s", objArr);
        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_VIEW_SET_AD_FAIL, str).hnadse();
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, str, new Object[0]);
    }

    public void setDownloadType(int i) {
        a aVar = this.mAppearanceText;
        if (aVar != null) {
            aVar.hnadsa(i);
        }
    }

    public void setRecoverText(CharSequence charSequence) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsa(charSequence);
        }
    }

    public void setReserveText(CharSequence charSequence) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsb(charSequence);
        }
    }

    public void setTryAgainText(CharSequence charSequence) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsc(charSequence);
        }
    }

    public void setViewText(CharSequence charSequence) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadsd(charSequence);
        }
    }

    public void setWaitText(CharSequence charSequence) {
        com.hihonor.adsdk.base.widget.download.d.a aVar = this.mDownloadButtonHandler;
        if (aVar != null) {
            aVar.hnadse(charSequence);
        }
    }

    public HnDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downTouchPoint = new Point();
        this.upTouchPoint = new Point();
    }

    public HnDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.downTouchPoint = new Point();
        this.upTouchPoint = new Point();
    }
}
