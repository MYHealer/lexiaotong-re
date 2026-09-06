package com.qq.e.ads.immersive;

import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface ImmersiveADFlowListener {
    void onADClick(String str);

    void onADExpose(String str);

    void onADLoaded();

    void onADPageDestroy();

    void onADPageShow();

    void onNoAD(AdError adError);
}
