package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSSplashSwipeClickView extends PPSBaseSwipeView {
    private LinearLayout L;

    public PPSSplashSwipeClickView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashSwipeClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        fh.V("PPSSplashSwipeClickView", "init");
        try {
            this.Code = inflate(context, R.layout.hiad_layout_splash_swipe_click, this);
            this.L = (LinearLayout) this.Code.findViewById(R.id.swipe_click_area);
            this.S = (ImageView) this.Code.findViewById(R.id.hiad_click_arrow);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_click_swipe_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_click_swipe_desc);
            this.F = (ScanningView) this.Code.findViewById(R.id.hiad_scanning_view);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            fh.I("PPSSplashSwipeClickView", str);
        } catch (Exception unused2) {
            str = "init error";
            fh.I("PPSSplashSwipeClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseSwipeView
    protected String getViewTag() {
        return "PPSSplashSwipeClickView";
    }
}
