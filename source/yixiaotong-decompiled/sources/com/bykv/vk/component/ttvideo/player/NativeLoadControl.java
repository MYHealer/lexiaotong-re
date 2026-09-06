package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NativeLoadControl extends LoadControl {
    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onTrackSelected(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onCodecStackSelected(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onFilterStackSelected(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected boolean shouldStartPlayback(long j, float f, boolean z) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeLoadControl(LoadControl loadControl) {
        return loadControl instanceof NativeLoadControl;
    }
}
