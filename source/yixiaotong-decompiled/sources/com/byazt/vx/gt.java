package com.byazt.vx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static final MessageDigest tt = c();
    public static final Charset c = Charset.forName("UTF-8");
    public static final char[] ve = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private gt() {
    }

    private static MessageDigest c() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String c(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = tt;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(c);
        synchronized (gt.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return c(bArrDigest);
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ve;
            cArr[i] = cArr2[(b & 240) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
