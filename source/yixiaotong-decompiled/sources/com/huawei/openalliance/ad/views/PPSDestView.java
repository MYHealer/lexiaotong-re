package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.ads.gl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSDestView extends FrameLayout implements gl {
    public PPSDestView(Context context) {
        super(context);
    }

    public PPSDestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSDestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }
}
