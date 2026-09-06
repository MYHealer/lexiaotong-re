package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long alC;
    private float baM;
    private boolean baN;
    private boolean baO;
    private ViewTreeObserver.OnScrollChangedListener baP;
    private ca baQ;
    private l eW;
    private int ph;
    private ViewTreeObserver qD;

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.baM = f;
    }

    public void setVisibleListener(l lVar) {
        this.eW = lVar;
    }

    public AdBasePvFrameLayout(Context context) {
        super(context);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }

    private void init() {
        this.baQ = new ca(this);
        this.ph = n.getScreenHeight(getContext());
        this.baO = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.baN || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            z = true;
            this.baN = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            qZ();
        }
    }

    private void qZ() {
        if (this.baO) {
            Po();
        }
    }

    private void Po() {
        if (Pq()) {
            Pp();
        } else {
            Pr();
        }
    }

    protected final void Pp() {
        Ps();
        l lVar = this.eW;
        if (lVar != null) {
            lVar.aZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pq() {
        return this.baQ.Xh() && ((float) Math.abs(this.baQ.brw.height() - getHeight())) <= ((float) getHeight()) * (1.0f - this.baM) && getHeight() > 0 && getWidth() > 0 && this.baQ.brw.bottom > 0 && this.baQ.brw.top < this.ph;
    }

    private void Pr() {
        if (this.baP == null) {
            this.baP = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.Pq()) {
                        AdBasePvFrameLayout.this.Pp();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.qD = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.baP);
            }
        }
    }

    private void Ps() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.baP != null && (viewTreeObserver = this.qD) != null && viewTreeObserver.isAlive()) {
                this.qD.removeOnScrollChangedListener(this.baP);
            }
            this.baP = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ps();
        this.baN = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pr();
    }
}
