package client.android.yixiaotong.v3.comman;

import android.util.Log;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.util.bluetooth.BathUtil;
import com.lxt.bluetoothsdk.utils.HexString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothDeviceCommand {
    private static int leftCount;
    private static StringBuilder stringBuilder;

    public static String getAA() {
        return "AA";
    }

    public static String getf2() {
        return "55000105F2000000F6";
    }

    public static String getf5() {
        return "55000103F500F7";
    }

    public static String getSmallClose(String str) {
        return "AC" + BathUtil.getStudentId(str);
    }

    public static String receivedData(String str) {
        StringBuilder sb;
        if (str.startsWith("550001") && str.length() >= 8) {
            StringBuilder sb2 = new StringBuilder();
            stringBuilder = sb2;
            sb2.append(str);
            byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(6, 8));
            byte[] bArr = new byte[4];
            System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
            leftCount = ((IntegerUtils.bytesToInt2(bArr, 0) + 1) * 2) - (str.length() - 6);
            Log.e("test", "1:" + leftCount);
        } else {
            StringBuilder sb3 = stringBuilder;
            if (sb3 != null && sb3.toString().length() >= 8) {
                stringBuilder.append(str);
                leftCount -= str.length();
                Log.e("test", "2:" + leftCount);
            } else {
                StringBuilder sb4 = stringBuilder;
                if (sb4 != null && sb4.toString().length() < 8) {
                    stringBuilder.append(str);
                    if (stringBuilder.toString().length() >= 8) {
                        byte[] bArrHexToBuffer2 = HexString.hexToBuffer(stringBuilder.toString().substring(6, 8));
                        byte[] bArr2 = new byte[4];
                        System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                        leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (stringBuilder.toString().length() - 6);
                        Log.e("test", "3:" + leftCount);
                    }
                } else {
                    if (str.startsWith("55") && str.length() < 8) {
                        StringBuilder sb5 = new StringBuilder();
                        stringBuilder = sb5;
                        sb5.append(str);
                        leftCount = 1;
                    }
                    return "";
                }
            }
        }
        if (leftCount <= 0 && (sb = stringBuilder) != null) {
            String string = sb.toString();
            stringBuilder = null;
            return string;
        }
        return "";
    }
}
