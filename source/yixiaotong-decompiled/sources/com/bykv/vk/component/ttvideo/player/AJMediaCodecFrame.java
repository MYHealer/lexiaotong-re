package com.bykv.vk.component.ttvideo.player;

import com.byazt.nr.m;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m776clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }
}
