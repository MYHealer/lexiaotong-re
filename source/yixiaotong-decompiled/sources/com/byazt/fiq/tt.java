package com.byazt.fiq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, 13})
public class tt {
    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return x.c(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
