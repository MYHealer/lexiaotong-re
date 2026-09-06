package com.lxt.bluetoothsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class UUIDUtil {
    private static final String[] READUUID = {"0000ffe1", "6e400003", "6c290d2e", "00003af2", "0000fe62", "00008910", "0000c305"};
    private static final String[] WRITEUUID = {"0000ffe2", "6e400002", "772ae377", "00003af1", "0000fe61", "0000fffe", "0000c304"};

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
