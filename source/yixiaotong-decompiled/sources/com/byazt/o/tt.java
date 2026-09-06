package com.byazt.o;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 13})
public class tt {
    public static final void c(uj ujVar, int i) throws IOException {
        int iTt = ujVar.tt();
        if (iTt != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iTt) + ".");
        }
    }
}
