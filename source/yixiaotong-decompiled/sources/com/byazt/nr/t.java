package com.byazt.nr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 66})
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f2532a;
    public static final byte[] c;
    public static final byte[] n;
    public static final int sp;
    public static final byte[] tt;
    public static final byte[] uj;
    public static final byte[] ve;

    public static int c() {
        return sp;
    }

    static {
        byte[] bArr = {-1, -40, -1};
        c = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        tt = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        ve = bArr3;
        byte[] bArrC = c("BM");
        uj = bArrC;
        n = c("GIF87a");
        f2532a = c("GIF89a");
        sp = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrC.length), 6))).intValue();
    }

    public static final String c(byte[] bArr) {
        if (tt(bArr)) {
            return "jpeg";
        }
        if (ve(bArr)) {
            return "png";
        }
        if (uj(bArr)) {
            return "gif";
        }
        if (n(bArr)) {
            return "bmp";
        }
        return a(bArr) ? "ico" : "other";
    }

    private static boolean tt(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = c;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean ve(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = tt;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean uj(byte[] bArr) {
        return (bArr.length >= 6 && c(bArr, n)) || c(bArr, f2532a);
    }

    private static boolean n(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = uj;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = ve;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        return c(bArr, bArr2, 0);
    }

    private static boolean c(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] c(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
