package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class LoadControl extends NativeObject {
    protected abstract int onCodecStackSelected(int i);

    protected abstract int onFilterStackSelected(int i);

    protected abstract int onTrackSelected(int i);

    protected abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
