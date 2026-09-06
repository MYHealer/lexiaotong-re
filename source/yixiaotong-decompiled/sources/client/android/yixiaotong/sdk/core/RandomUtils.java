package client.android.yixiaotong.sdk.core;

import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
class RandomUtils {
    private RandomUtils() {
    }

    static String getRandomString() {
        return HexString.bufferToHex(IntegerUtils.intToBytes(new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE)));
    }
}
