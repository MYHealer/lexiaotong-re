package com.fancy;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dh implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ _di _a;

    public _dh(_di _diVar) {
        this._a = _diVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this._a._a.getContentHeight() > 0) {
            this._a._a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            _di _diVar = this._a;
            int screenRealWidth = ScreenUtils.getScreenRealWidth(_diVar.getContext());
            int screenRealHeight = ScreenUtils.getScreenRealHeight(_diVar.getContext());
            int contentHeight = _diVar._a.getContentHeight();
            int width = _diVar._a.getWidth();
            Logger.d("FeedBackWebView", "adjustWebViewSize contentWidth=" + width + ", contentHeight=" + contentHeight);
            double d = screenRealWidth;
            int i = (int) (d * 0.9d);
            double d2 = screenRealHeight;
            int i2 = (int) (0.9d * d2);
            if (width > 0) {
                screenRealWidth = width;
            }
            int iMin = Math.min(screenRealWidth, i);
            int iMin2 = Math.min(contentHeight, i2);
            int iMax = Math.max(iMin, (int) (d * 0.5d));
            int iMax2 = Math.max(iMin2, (int) (d2 * 0.5d));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) _diVar._a.getLayoutParams();
            layoutParams.width = iMax;
            layoutParams.height = iMax2;
            layoutParams.gravity = 17;
            _diVar._a.setLayoutParams(layoutParams);
            Logger.d("FeedBackWebView", "WebView size adjusted: " + iMax + "x" + iMax2);
        }
    }
}
