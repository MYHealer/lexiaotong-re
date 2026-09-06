package com.yfanads.android.core.render.api;

import android.app.FragmentManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFNativeCall {
    void handleClickByIndex(boolean z, int i);

    void handleClose();

    void handleExposureByIndex(int i);

    void handleFailed(String str, String str2);

    void showFeedBackDialog(FragmentManager fragmentManager, String str);
}
