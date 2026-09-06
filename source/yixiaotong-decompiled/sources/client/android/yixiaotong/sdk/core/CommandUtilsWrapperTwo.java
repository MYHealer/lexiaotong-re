package client.android.yixiaotong.sdk.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CommandUtilsWrapperTwo {
    public static String getOnlineConnectCommandTwo(long j, String str, boolean z, boolean z2) {
        return CommandUtilsTwo.getOnlineConnectCommandTwo(j, str, z, z2);
    }

    public static String getOfflineConnectCommandTwo(long j, String str) {
        return CommandUtilsTwo.getOfflineConnectCommandTwo(j, str);
    }

    public static String getOnlineConfirmCommandTwo(long j, short s, String str) {
        return CommandUtilsTwo.getOnlineConfirmCommandTwo(j, s, str);
    }

    public static String getOfflineConfirmCommandTwo(long j, short s, String str) {
        return CommandUtilsTwo.getOfflineConfirmCommandTwo(j, s, str);
    }

    public static String getOfflineDataCollectCommandTwo(long j, short s, String str) {
        return CommandUtilsTwo.getOfflineDataCollectCommandTwo(j, s, str);
    }

    public static String bindState(byte[] bArr) {
        return CommandUtilsTwo.bindState(bArr);
    }

    public static int isoffineRecordState(byte[] bArr) {
        return CommandUtilsTwo.isoffineRecordState(bArr);
    }

    public static boolean isConfirmOfflineResult(byte[] bArr) {
        return CommandUtilsTwo.isConfirmOfflineResult(bArr);
    }

    public static boolean isBindDeviceResult(byte[] bArr) {
        return CommandUtilsTwo.isBindDeviceResult(bArr);
    }

    public static int getMachineDataLength(byte[] bArr) {
        return CommandUtilsTwo.getMachineDataLength(bArr);
    }

    public static int getPosNumber(byte[] bArr) {
        return CommandUtilsTwo.getPosNumber(bArr);
    }

    public static String getNetflag() {
        return CommandUtilsWrapper.Netflag;
    }

    public static String getSecretKey() {
        return CommandUtilsWrapper.SecretKey;
    }
}
