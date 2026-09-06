package com.baidu.mobads.sdk.api;

import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface ShakeViewContainer {
    void destroy();

    RelativeLayout getContainer();

    void pause();

    void resume();
}
