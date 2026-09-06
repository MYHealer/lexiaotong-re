package com.miui.zeus.mimo.sdk.ad.nativead.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.imageutils.JfifUtil;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class DirectDownloadView extends FrameLayout {
    private DownloadButtonICP btnView;

    public DirectDownloadView(Context context) {
        super(context, null);
        addView(context, (AttributeSet) null);
    }

    public DirectDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(context, attributeSet);
    }

    public DirectDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        addView(context, attributeSet);
    }

    public DirectDownloadView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        addView(context, attributeSet);
    }

    private void addView(Context context, AttributeSet attributeSet) {
        NCall.IV(new Object[]{214, this, context, attributeSet});
    }

    public void destroy() {
        NCall.IV(new Object[]{215, this});
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        NCall.IV(new Object[]{216, this, drawable});
    }

    public void setBackgroundRes(int i) {
        NCall.IV(new Object[]{Integer.valueOf(JfifUtil.MARKER_EOI), this, Integer.valueOf(i)});
    }

    public void setDownloadTextColor(int i) {
        NCall.IV(new Object[]{Integer.valueOf(JfifUtil.MARKER_SOS), this, Integer.valueOf(i)});
    }

    public void setProgressRes(int i) {
        NCall.IV(new Object[]{219, this, Integer.valueOf(i)});
    }

    public void setTextColor(int i) {
        NCall.IV(new Object[]{220, this, Integer.valueOf(i)});
    }
}
