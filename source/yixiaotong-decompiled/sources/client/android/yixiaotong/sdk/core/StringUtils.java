package client.android.yixiaotong.sdk.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class StringUtils {
    public static String stringToAscii(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i != charArray.length - 1) {
                stringBuffer.append((int) charArray[i]).append(",");
            } else {
                stringBuffer.append((int) charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static String asciiToString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : str.split(",")) {
            stringBuffer.append((char) Integer.parseInt(str2));
        }
        return stringBuffer.toString();
    }
}
