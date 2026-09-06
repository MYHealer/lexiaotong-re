package android.client.bluetoothsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class UUIDUtil {
    private static final String[] READUUID = {"0000ffe1", "6e400003", "00003af2"};
    private static final String[] WRITEUUID = {"0000ffe2", "6e400002", "00003af1"};

    public static boolean isReadUuid(String str) {
        int i = 0;
        while (true) {
            String[] strArr = READUUID;
            if (i >= strArr.length) {
                return false;
            }
            if (str.toLowerCase().indexOf(strArr[i]) == 0) {
                return true;
            }
            i++;
        }
    }

    public static boolean isWriteUuid(String str) {
        int i = 0;
        while (true) {
            String[] strArr = WRITEUUID;
            if (i >= strArr.length) {
                return false;
            }
            if (str.toLowerCase().indexOf(strArr[i]) == 0) {
                return true;
            }
            i++;
        }
    }
}
