package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NativeMediaTransport extends MediaTransport {
    @Override // com.bykv.vk.component.ttvideo.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }
}
