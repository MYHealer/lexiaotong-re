package client.android.yixiaotong.sdk.core;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CommandUtilsWrapper {
    public static final String DEVICEID_PREFIX = "0212";
    static String F5_Message = "";
    static String Netflag = "";
    static String SecretKey = "";
    public static String vers = "";
    public static XOrUtils xorUtils = new XOrUtils();

    public static String getDeviceVers() {
        return vers;
    }

    private CommandUtilsWrapper() {
    }

    public static void unRegisterApp() {
        CommandUtils.unRegisterApp();
    }

    public static void registerApp(Context context) {
        CommandUtils.registerApp(context);
    }

    public static String getOnlineConnectCommand(long j, String str) {
        return CommandUtils.getOnlineConnectCommand(j, str);
    }

    public static String getOfflineConnectCommand(long j, String str) {
        return CommandUtils.getOfflineConnectCommand(j, str);
    }

    public static String getOnlineConfirmCommand(long j, short s, String str) {
        return CommandUtils.getOnlineConfirmCommand(j, s, str);
    }

    public static String getOfflineConfirmCommand(long j, short s, String str) {
        return CommandUtils.getOfflineConfirmCommand(j, s, str);
    }

    public static String getAbortCommand() {
        return CommandUtils.getAbortCommand();
    }

    public static String getOpenSwitchCommand() {
        return CommandUtils.getOpenSwitchCommand();
    }

    public static String getCloseSwitchCommand() {
        return CommandUtils.getCloseSwitchCommand();
    }

    public static String getSettingCommand(String str, String str2) {
        return CommandUtils.getSettingCommand(str, str2);
    }

    public static String getReturnSettingCommand() {
        return CommandUtils.getReturnSettingCommand();
    }

    public static String[] getSettingQRcodeCommands(byte[] bArr) {
        return CommandUtils.getSettingQRcodeCommands(bArr);
    }

    public static boolean isConnectResult(byte[] bArr) {
        return CommandUtils.isConnectResult(bArr);
    }

    public static boolean isConfirmResult(byte[] bArr) {
        return CommandUtils.isConfirmResult(bArr);
    }

    public static boolean isAbortResult(byte[] bArr) {
        return CommandUtils.isAbortResult(bArr);
    }

    public static boolean isSwitchResult(byte[] bArr) {
        return CommandUtils.isSwitchResult(bArr);
    }

    public static boolean isSettingResult(byte[] bArr) {
        return CommandUtils.isSettingResult(bArr);
    }

    public static boolean isReturnSettingResult(byte[] bArr) {
        return CommandUtils.isReturnSettingResult(bArr);
    }

    public static boolean isSettingQRCodeResult(byte[] bArr) {
        return CommandUtils.isSettingQRCodeResult(bArr);
    }

    public static short getConnectResultStatus(byte[] bArr) {
        return CommandUtils.getConnectResultStatus(bArr);
    }

    public static String getConnectResultDeviceHexNo(byte[] bArr) {
        return CommandUtils.getConnectResultDeviceHexNo(bArr);
    }

    public static long getConnectResultUserId(byte[] bArr) {
        return CommandUtils.getConnectResultUserId(bArr);
    }

    public static short getConnectResultBalance(byte[] bArr) {
        return CommandUtils.getConnectResultBalance(bArr);
    }

    public static String getConnectResultTime(byte[] bArr) {
        return CommandUtils.getConnectResultTime(bArr);
    }

    public static short getConfirmResultStatus(byte[] bArr) {
        return CommandUtils.getConfirmResultStatus(bArr);
    }

    public static boolean getAbortResultStatus(byte[] bArr) {
        return CommandUtils.getAbortResultStatus(bArr);
    }

    public static boolean getSettingResultStatus(byte[] bArr) {
        return CommandUtils.getSettingResultStatus(bArr);
    }

    public static boolean getReturnSettingResultStatus(byte[] bArr) {
        return CommandUtils.getReturnSettingResultStatus(bArr);
    }

    public static String getReturnSettingResult(byte[] bArr) {
        return CommandUtils.getReturnSettingResult(bArr);
    }

    public static String getReturnSettingDeviceIdResult(byte[] bArr) {
        return CommandUtils.getReturnSettingDeviceIdResult(bArr);
    }

    public static short getReturnSettingDeviceTypeResult(byte[] bArr) {
        return CommandUtils.getReturnSettingDeviceTypeResult(bArr);
    }

    public static String getReturnSettingDeviceTypeStringResult(byte[] bArr) {
        return CommandUtils.getReturnSettingDeviceTypeStringResult(bArr);
    }

    public static boolean getSettingRQCodeResultStatus(byte[] bArr) {
        return CommandUtils.getSettingRQCodeResultStatus(bArr);
    }

    public static String setAddressCommand(String str) {
        return CommandUtils.setAddressCommand(str);
    }

    public static boolean isReturnSetDeviceName(byte[] bArr) {
        return CommandUtils.isReturnSetDeviceName(bArr);
    }

    public static boolean getSettingnameResultStatus(byte[] bArr) {
        return CommandUtils.getSettingnameResultStatus(bArr);
    }

    public static short getReturnSettingResulttemperature() {
        return CommandUtils.getReturnSettingResulttemperature();
    }

    public static int getDeviceVersion() {
        try {
            if (F5_Message.length() == 54) {
                return 0;
            }
            vers = F5_Message.substring(58, 62);
            return 1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
