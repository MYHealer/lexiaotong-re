package client.android.yixiaotong.baseutil;

import android.util.Log;
import client.android.yixiaotong.sdk.utils.HexString;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RandomUtils {
    private RandomUtils() {
    }

    public static String getRandomString() {
        return HexString.bufferToHex(IntegerUtils.intToBytes(new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE)));
    }

    public static String getRandomString2() {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String str = new String();
        for (int i = 0; i < 8; i++) {
            str = str + cArr[(int) (Math.random() * ((double) 16))];
        }
        Log.i("随机数", str);
        return str;
    }
}
