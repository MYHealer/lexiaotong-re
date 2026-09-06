package com.hihonor.adsdk.common.uikit.hwprogressbar.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.e.e.a.b;
import com.hihonor.adsdk.common.uikit.hwprogressbar.graphics.drawable.HwLoadingDrawableImpl;
import com.hihonor.adsdk.common.uikit.hwprogressbar.graphics.drawable.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@RemoteViews.RemoteView
public class HwProgressBar extends ProgressBar {
    private static final String hnadsj = "HwProgressBar";
    private static final int hnadsk = 15;
    private static final int hnadsl = -11711155;
    private static final float hnadsm = 0.38f;
    private static final float hnadsn = 0.1f;
    private static final float hnadso = 0.0f;
    private static final float hnadsp = 0.93f;
    private static final int hnadsq = 0;
    private int hnadsd;
    private int hnadse;
    private int hnadsf;
    private int hnadsg;
    private int hnadsh;
    private a hnadsi;

    public HwProgressBar(Context context) {
        this(context, null);
    }

    public static HwProgressBar hnadsa(Context context) {
        Object objHnadsa = b.hnadsa(context, b.hnadsa(context, (Class<?>) HwProgressBar.class, b.hnadsa(context, 15, 1)), (Class<?>) HwProgressBar.class);
        if (objHnadsa instanceof HwProgressBar) {
            return (HwProgressBar) objHnadsa;
        }
        return null;
    }

    private void hnadsb() {
        setIndeterminateDrawable(new HwLoadingDrawableImpl(getResources(), getMinimumWidth() > getMinimumHeight() ? getMinimumHeight() : getMinimumWidth(), this.hnadsg));
        setInterpolator(new com.hihonor.adsdk.common.e.d.a.a(0.38f, 0.1f, 0.0f, hnadsp));
    }

    protected boolean hnadsd() {
        return true;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        if (this.hnadsi != null) {
            hnadsa();
        }
    }

    public HwProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.honorAdsHwProgressBarStyle);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        if (this.hnadsi != null) {
            hnadsa();
        } else {
            super.onDraw(canvas);
        }
    }

    public void setIndeterminateColor(int i) {
        this.hnadsg = i;
        hnadsb();
    }

    public HwProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(hnadsa(context, i), attributeSet, i);
        hnadsa(super.getContext(), attributeSet, i);
    }

    public synchronized void setFillColor(int i) {
        this.hnadsg = i;
        a aVar = this.hnadsi;
        if (aVar != null) {
            aVar.hnadsa(i);
        }
    }

    public synchronized void setRingTrackColor(int i) {
        this.hnadsh = i;
        a aVar = this.hnadsi;
        if (aVar != null) {
            aVar.hnadsd(i);
        }
    }

    private void hnadsc() {
        int i = this.hnadsd;
        if (i == 1 || i == 2) {
            int max = getMax();
            if (max == 0) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsj, "The max is 0 in initRingDrawable.", new Object[0]);
                return;
            }
            a aVar = new a(getContext());
            this.hnadsi = aVar;
            aVar.hnadsa(getBackground());
            this.hnadsi.hnadse(this.hnadsd);
            this.hnadsi.hnadsa(this.hnadsg);
            this.hnadsi.hnadsd(this.hnadsh);
            this.hnadsi.hnadsb(this.hnadse);
            this.hnadsi.hnadsc(this.hnadsf);
            this.hnadsi.hnadsa(getProgress() / max);
            setBackground(this.hnadsi);
        }
    }

    private static Context hnadsa(Context context, int i) {
        return com.hihonor.adsdk.common.e.e.a.a.hnadsa(context, i, R.style.Honor_Ads_Theme_Magic_HwProgressBar);
    }

    private synchronized void hnadsa(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHwProgressBar, i, R.style.Honor_Ads_Widget_Magic_HwProgressBar);
        try {
            try {
                this.hnadsd = typedArrayObtainStyledAttributes.getInt(R.styleable.HonorAdsHwProgressBar_honorAdsHwProgressBarRingType, 0);
                this.hnadsg = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwProgressBar_honorAdsHwFillColor, hnadsl);
                this.hnadsh = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwProgressBar_honorAdsHwProgressBarRingTrackColor, getResources().getColor(R.color.honor_ads_magic_control_normal_dark));
                this.hnadse = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.HonorAdsHwProgressBar_honorAdsHwProgressBarRingWidth, 0);
                this.hnadsf = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.HonorAdsHwProgressBar_honorAdsHwProgressBarTickWidth, 0);
                hnadsb();
                hnadsc();
            } catch (Resources.NotFoundException unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsj, "Resource not found in initialize.", new Object[0]);
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void hnadsa() {
        int max = getMax();
        if (max == 0) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsj, "The max is 0 in setProgress.", new Object[0]);
        } else {
            this.hnadsi.hnadsa(getProgress() / max);
        }
    }
}
