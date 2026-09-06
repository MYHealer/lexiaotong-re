package com.bykv.vk.component.ttvideo.player;

import com.byazt.nr.m;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AJCodecBuffer implements Cloneable {
    public ByteBuffer data;
    public int index;
    public long pts;
    public int size;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJCodecBuffer m775clone() {
        AJCodecBuffer aJCodecBuffer;
        try {
            aJCodecBuffer = (AJCodecBuffer) super.clone();
        } catch (Throwable th) {
            m.c(th);
            aJCodecBuffer = null;
        }
        aJCodecBuffer.size = this.size;
        aJCodecBuffer.pts = this.pts;
        aJCodecBuffer.index = this.index;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.size);
        byteBufferAllocateDirect.put(this.data);
        aJCodecBuffer.data = byteBufferAllocateDirect;
        return aJCodecBuffer;
    }
}
