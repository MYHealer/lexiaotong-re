package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NativeMaskInfo extends MaskInfo {
    @Override // com.bykv.vk.component.ttvideo.player.MaskInfo
    protected void onMaskInfoCallback(int i, int i2, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMaskInfo(MaskInfo maskInfo) {
        return maskInfo instanceof NativeMaskInfo;
    }
}
