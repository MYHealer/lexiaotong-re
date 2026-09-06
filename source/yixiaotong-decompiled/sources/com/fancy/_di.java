package com.fancy;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import com.huawei.openalliance.ad.constant.br;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _di extends FrameLayout {
    public AdTemplateWebView _a;
    public View _b;
    public FrameLayout _c;
    public boolean _d;

    public _di(PtgBaseVideoActivity ptgBaseVideoActivity) {
        super(ptgBaseVideoActivity);
        this._d = false;
        _a(ptgBaseVideoActivity);
    }

    public final void _a() {
        if (this._d) {
            Logger.d("FeedBackWebView", br.b.C);
            AdTemplateWebView adTemplateWebView = this._a;
            if (adTemplateWebView != null) {
                adTemplateWebView.stopLoading();
                this._a.destroy();
            }
            setVisibility(8);
            this._d = false;
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        }
    }

    public final void _a(PtgBaseVideoActivity ptgBaseVideoActivity) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setVisibility(8);
        this._b = new View(getContext());
        this._b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this._b.setBackgroundColor(Color.parseColor("#80000000"));
        this._b.setOnClickListener(new _dg(this));
        this._c = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this._c.setLayoutParams(layoutParams);
        this._a = new AdTemplateWebView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this._a.setLayoutParams(layoutParams2);
        this._a.setBackgroundColor(-1);
        this._a.getViewTreeObserver().addOnGlobalLayoutListener(new _dh(this));
        this._c.addView(this._a);
        addView(this._b);
        addView(this._c);
    }

    public final void _a(String str, FrameLayout frameLayout) {
        Logger.d("FeedBackWebView", "show: " + str);
        frameLayout.addView(this);
        setVisibility(0);
        this._d = true;
        if (str == null || str.isEmpty()) {
            Logger.e("FeedBackWebView", "feedbackUrl is empty");
        } else {
            this._a.loadUrl(str);
        }
    }

    public AdTemplateWebView getWebView() {
        return this._a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        _a();
        this._c = null;
        this._b = null;
    }

    public void setWebViewBridgeListener(_pc _pcVar) {
        AdTemplateWebView adTemplateWebView = this._a;
        if (adTemplateWebView != null) {
            adTemplateWebView.setWebViewBridgeListener(_pcVar);
        }
    }
}
