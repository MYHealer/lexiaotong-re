package com.yfanads.android.core.splash;

import android.view.View;
import com.yfanads.android.callback.BaseAdapterEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFSplashSetting extends BaseAdapterEvent {
    View getBottomView();

    int[] getSize();

    boolean isCustom();
}
