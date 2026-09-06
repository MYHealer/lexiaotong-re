package com.byazt.utw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 46})
public class n {
    public final RandomAccessFile c;

    public n(File file, String str) throws c {
        try {
            this.c = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new c(e);
        }
    }

    public void c(long j) throws c {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public void c(byte[] bArr, int i, int i2) throws c {
        try {
            this.c.write(bArr, i, i2);
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public void c() {
        com.byazt.nxx.c.c(this.c);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 151})
    static class c extends Exception {
        public c(Throwable th) {
            super(th);
        }
    }
}
