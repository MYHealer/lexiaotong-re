package client.android.yixiaotong.sdk.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BathUtil {
    public static String getStudentId(String str) {
        byte[] bArrNegation = negation(HexString.hexToBuffer(str));
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrNegation) {
            sb.append(new XOrUtils().xOr(HexString.appendHexPair(b), "AA"));
        }
        return sb.toString();
    }

    public static byte[] negation(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 += (1 << i3) * (((bArr[i] >> i3) & 1) == 0 ? 1 : 0);
            }
            bArr[i] = (byte) i2;
        }
        return bArr;
    }
}
