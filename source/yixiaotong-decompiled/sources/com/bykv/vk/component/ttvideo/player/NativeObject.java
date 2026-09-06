package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    private long getNativeObj() {
        return this.mNativeObj;
    }

    private native void nativeRelease(long j);

    protected void finalize() throws Throwable {
    }

    protected void setNativeObj(long j) {
        this.mNativeObj = j;
    }

    public synchronized void release() {
        long j = this.mNativeObj;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeObj = 0L;
        }
    }
}
