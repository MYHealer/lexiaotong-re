package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper = 0;

    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }

    public void setNativeWrapper(long j) {
        this.mNativeWrapper = j;
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioOpen(int i, int i2, int i3, int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioProcess(ByteBuffer[] byteBufferArr, int i, long j) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioRelease(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    public static boolean isNativeAudioProcessor(AudioProcessor audioProcessor) {
        return audioProcessor instanceof NativeAudioProcessor;
    }
}
