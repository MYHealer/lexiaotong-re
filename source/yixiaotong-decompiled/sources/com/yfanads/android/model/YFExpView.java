package com.yfanads.android.model;

import android.view.View;
import com.yfanads.android.core.render.api.YFNativeAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFExpView implements ExpView {
    private int index;
    private YFNativeAd nativeAd;
    int type;
    private View view;

    public YFExpView(View view, int i) {
        this.type = i;
        this.view = view;
    }

    @Override // com.yfanads.android.model.ExpView
    public int getAdSourceType() {
        return this.type;
    }

    @Override // com.yfanads.android.model.ExpView
    public View getView() {
        return this.view;
    }

    @Override // com.yfanads.android.model.ExpView
    public int getViewIndex() {
        return this.index;
    }

    @Override // com.yfanads.android.model.ExpView
    public YFNativeAd getYFNativeAd() {
        return this.nativeAd;
    }

    public YFExpView(View view, int i, int i2) {
        this.type = i;
        this.view = view;
        this.index = i2;
    }

    public YFExpView(YFNativeAd yFNativeAd, int i) {
        this.nativeAd = yFNativeAd;
        this.type = i;
    }

    public YFExpView(YFNativeAd yFNativeAd, int i, int i2) {
        this.nativeAd = yFNativeAd;
        this.type = i;
        this.index = i2;
    }
}
