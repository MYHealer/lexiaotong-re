package com.byazt.on;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 15})
public class uj implements sp {
    public ByteBuffer c;

    public uj() {
        ve(10240);
    }

    public void c(byte b) {
        this.c.put(b);
    }

    public void c(byte[] bArr) {
        this.c.put(bArr);
    }

    public int c() {
        return this.c.position();
    }

    public void uj(int i) {
        this.c.position(i + c());
    }

    public byte[] tt() {
        return this.c.array();
    }

    public void ve(int i) {
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.c = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.c.clear();
    }
}
