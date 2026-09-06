package client.android.yixiaotong.v3.comman;

import android.util.Log;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppTypeIdUtil {
    public static final int Bath4G = 109;
    public static final int Bath4GCostControl = 116;
    public static final String Bluetooth_Device_Type = "00";
    public static final String Bluetooth_Device_Ver_Bath1 = "00";
    public static final String Bluetooth_Device_Ver_Bath2 = "01";
    public static final String Bluetooth_Device_Ver_Bath3 = "02";
    public static final String Bluetooth_Device_Ver_Bath4 = "06";
    public static final String Bluetooth_Device_Ver_Bath5 = "03";
    public static final String Bluetooth_Device_Ver_DrinkWater = "03";
    public static final String Bluetooth_Device_Ver_Dry = "07";
    public static final String Bluetooth_Device_Ver_Hair = "05";
    public static final String Bluetooth_Device_Ver_SellCard = "08";
    public static final String Bluetooth_Device_Ver_Washer = "04";
    public static final int DOORLOCK = 10;
    public static final int DSKBLEDrink = 7;
    public static final int DSKBath = 1;
    public static final int DSKDrink = 2;
    public static final int DSKHair = 5;
    public static final int DSKPrepayment = 3;
    public static final int DSKWasher = 4;
    public static final int DSK_BLEBath = 6;
    public static final int Drink4GCostControl_1 = 117;
    public static final int Drink4GCostControl_2 = 118;
    public static final int Drink4G_1 = 111;
    public static final int Drink4G_2 = 112;
    public static final int Dry4G = 114;
    public static final int Dry4GCostControl = 121;
    public static final int Hair4G = 113;
    public static final int Hair4GCostControl = 119;
    public static final int NBAIR = 107;
    public static final int NBBath = 101;
    public static final int NBDrink = 102;
    public static final int NBDry = 105;
    public static final int NBHair = 103;
    public static final int NBQrcodeBath = 106;
    public static final int NBWash = 104;
    public static final int NewDevice4GBATHWIFI = 129;
    public static final int NewDevice4GBath = 122;
    public static final int NewDevice4GBathOTA = 123;
    public static final int NewDevice4GBathY = 130;
    public static final int NewDevice4GDrinkOTA_1 = 124;
    public static final int NewDevice4GDrinkOTA_2 = 125;
    public static final int NewDevice4GDryOTA = 128;
    public static final int NewDevice4GHairOTA = 126;
    public static final int NewDevice4GWashOTA = 127;
    public static final int QrcodeBath4G = 108;
    public static final int QrcodeBath4GCostControl = 115;
    public static final int Wash4G = 110;
    public static final int Wash4GCostControl = 120;

    public static int isNBOr4GDevice(String str, String str2) {
        if (str.equalsIgnoreCase("01") && (str2.equalsIgnoreCase("02") || str2.equalsIgnoreCase("03"))) {
            return 101;
        }
        if (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase("08")) {
            return 109;
        }
        if (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase(DeviceTypeVersionController.Bluetooth_Device_Ver_DM1)) {
            return 116;
        }
        if (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
            return 122;
        }
        if (str.equalsIgnoreCase("01") && (str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_DEMO) || str2.equalsIgnoreCase("32") || str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_ROAMING))) {
            return NewDevice4GBathOTA;
        }
        if (str.equalsIgnoreCase("01") && (str2.equalsIgnoreCase("61") || str2.equalsIgnoreCase("62") || str2.equalsIgnoreCase(Constant.TRANS_TYPE_CASH_LOAD) || str2.equalsIgnoreCase("71") || str2.equalsIgnoreCase("72") || str2.equalsIgnoreCase("73"))) {
            return 130;
        }
        if (str.equalsIgnoreCase("01") && (str2.equalsIgnoreCase("51") || str2.equalsIgnoreCase("52") || str2.equalsIgnoreCase("53"))) {
            return 129;
        }
        if (str.equalsIgnoreCase("02") && str2.equalsIgnoreCase("02")) {
            return 102;
        }
        if (str.equalsIgnoreCase("02") && str2.equalsIgnoreCase("08")) {
            return 111;
        }
        if (str.equalsIgnoreCase("02") && str2.equalsIgnoreCase(DeviceTypeVersionController.Bluetooth_Device_Ver_DM1)) {
            return 112;
        }
        if (str.equalsIgnoreCase("02") && str2.equalsIgnoreCase("0A")) {
            return Drink4GCostControl_1;
        }
        if (str.equalsIgnoreCase("02") && str2.equalsIgnoreCase("0B")) {
            return 118;
        }
        if (str.equalsIgnoreCase("02") && (str2.equalsIgnoreCase("32") || str2.equalsIgnoreCase("62"))) {
            return NewDevice4GDrinkOTA_1;
        }
        if (str.equalsIgnoreCase("02") && (str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_ROAMING) || str2.equalsIgnoreCase(Constant.TRANS_TYPE_CASH_LOAD))) {
            return NewDevice4GDrinkOTA_2;
        }
        if (str.equalsIgnoreCase("03") && str2.equalsIgnoreCase("02")) {
            return 103;
        }
        if (str.equalsIgnoreCase("03") && str2.equalsIgnoreCase("03")) {
            return 113;
        }
        if (str.equalsIgnoreCase("03") && str2.equalsIgnoreCase("04")) {
            return 119;
        }
        if (str.equalsIgnoreCase("03") && str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_DEMO)) {
            return 126;
        }
        if (str.equalsIgnoreCase("04") && str2.equalsIgnoreCase("02")) {
            return 104;
        }
        if (str.equalsIgnoreCase("04") && str2.equalsIgnoreCase("03")) {
            return 110;
        }
        if (str.equalsIgnoreCase("04") && str2.equalsIgnoreCase("04")) {
            return 120;
        }
        if (str.equalsIgnoreCase("04") && str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_DEMO)) {
            return 127;
        }
        if (str.equalsIgnoreCase("05") && str2.equalsIgnoreCase("02")) {
            return 105;
        }
        if (str.equalsIgnoreCase("05") && str2.equalsIgnoreCase("03")) {
            return 114;
        }
        if (str.equalsIgnoreCase("05") && str2.equalsIgnoreCase("04")) {
            return 121;
        }
        if (str.equalsIgnoreCase("05") && str2.equalsIgnoreCase(BaseWrapper.ENTER_ID_OAPS_DEMO)) {
            return 128;
        }
        if (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase("04")) {
            return 106;
        }
        if (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase("06")) {
            return 108;
        }
        return (str.equalsIgnoreCase("01") && str2.equalsIgnoreCase("07")) ? 115 : 0;
    }

    public static int isDSKDevice(String str, String str2) {
        if (str2.equals(BaseWrapper.ENTER_ID_AD_SDK) && str.equals("01")) {
            return 1;
        }
        if (str2.equals("16") && str.equals("01")) {
            return 1;
        }
        if (str2.equals("15") && str.equals("01")) {
            return 6;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_17) && str.equals("01")) {
            return 6;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_AD_SDK) && str.equals("02")) {
            return 2;
        }
        if (str2.equals("16") && str.equals("02")) {
            return 2;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_18) && str.equals("02")) {
            return 2;
        }
        if (str2.equals("1A") && str.equals("02")) {
            return 2;
        }
        if (str2.equals("1C") && str.equals("02")) {
            return 2;
        }
        if (str2.equals("15") && str.equals("02")) {
            return 7;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_17) && str.equals("02")) {
            return 7;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_19) && str.equals("02")) {
            return 7;
        }
        if (str2.equals("1B") && str.equals("02")) {
            return 7;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_17) && str.equals("04")) {
            return 4;
        }
        return (str2.equals(BaseWrapper.ENTER_ID_18) && str.equals("03")) ? 5 : 0;
    }

    public static int isBluetoothDevice(String str, String str2) {
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("00")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("01")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("02")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("03")) {
            return 6;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("04")) {
            return 3;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("07")) {
            return 16;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("05")) {
            return 8;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("08")) {
            return 9;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("06")) {
            return 1;
        }
        return (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("03")) ? 1 : 0;
    }

    public static int getTypeId(String str, String str2) {
        Log.e("test", "type:" + str + "  version:" + str2);
        if (isNBOr4GDevice(str, str2) == 101 || isNBOr4GDevice(str, str2) == 109 || isNBOr4GDevice(str, str2) == 116 || isNBOr4GDevice(str, str2) == 122 || isNBOr4GDevice(str, str2) == 123 || isNBOr4GDevice(str, str2) == 129 || isNBOr4GDevice(str, str2) == 130) {
            return 1;
        }
        if (isNBOr4GDevice(str, str2) == 102 || isNBOr4GDevice(str, str2) == 111 || isNBOr4GDevice(str, str2) == 112 || isNBOr4GDevice(str, str2) == 117 || isNBOr4GDevice(str, str2) == 118 || isNBOr4GDevice(str, str2) == 124 || isNBOr4GDevice(str, str2) == 125) {
            return 6;
        }
        if (isNBOr4GDevice(str, str2) == 103 || isNBOr4GDevice(str, str2) == 113 || isNBOr4GDevice(str, str2) == 119 || isNBOr4GDevice(str, str2) == 126) {
            return 8;
        }
        if (isNBOr4GDevice(str, str2) == 104 || isNBOr4GDevice(str, str2) == 110 || isNBOr4GDevice(str, str2) == 120 || isNBOr4GDevice(str, str2) == 127) {
            return 3;
        }
        if (isNBOr4GDevice(str, str2) == 105 || isNBOr4GDevice(str, str2) == 114 || isNBOr4GDevice(str, str2) == 121 || isNBOr4GDevice(str, str2) == 128) {
            return 16;
        }
        if (isNBOr4GDevice(str, str2) == 106 || isNBOr4GDevice(str, str2) == 108 || isNBOr4GDevice(str, str2) == 115) {
            return 17;
        }
        if (isDSKDevice(str, str2) == 1 || isDSKDevice(str, str2) == 6) {
            return 1;
        }
        if (isDSKDevice(str, str2) == 4) {
            return 3;
        }
        if (isDSKDevice(str, str2) == 2 || isDSKDevice(str, str2) == 7) {
            return 6;
        }
        return isDSKDevice(str, str2) == 5 ? 8 : 0;
    }

    public static boolean isBLEDevice(String str, String str2) {
        return isDSKDevice(str, str2) == 6 || isDSKDevice(str, str2) == 7;
    }

    public static boolean isTwoSetDevice(String str, String str2) {
        if (str2.equals("16") && str.equals("02")) {
            return true;
        }
        if (str2.equals(BaseWrapper.ENTER_ID_17) && str.equals("02")) {
            return true;
        }
        if (str2.equals("1A") && str.equals("02")) {
            return true;
        }
        return str2.equals("1B") && str.equals("02");
    }

    public static boolean is4GDevice(String str, String str2) {
        return isNBOr4GDevice(str, str2) == 109 || isNBOr4GDevice(str, str2) == 116 || isNBOr4GDevice(str, str2) == 122 || isNBOr4GDevice(str, str2) == 123 || isNBOr4GDevice(str, str2) == 111 || isNBOr4GDevice(str, str2) == 112 || isNBOr4GDevice(str, str2) == 117 || isNBOr4GDevice(str, str2) == 118 || isNBOr4GDevice(str, str2) == 124 || isNBOr4GDevice(str, str2) == 125 || isNBOr4GDevice(str, str2) == 113 || isNBOr4GDevice(str, str2) == 119 || isNBOr4GDevice(str, str2) == 126 || isNBOr4GDevice(str, str2) == 110 || isNBOr4GDevice(str, str2) == 120 || isNBOr4GDevice(str, str2) == 127 || isNBOr4GDevice(str, str2) == 114 || isNBOr4GDevice(str, str2) == 121 || isNBOr4GDevice(str, str2) == 128 || isNBOr4GDevice(str, str2) == 108 || isNBOr4GDevice(str, str2) == 115;
    }

    public static boolean isSingleWayDevice(String str, String str2) {
        return isNBOr4GDevice(str, str2) == 111 || isNBOr4GDevice(str, str2) == 117 || isNBOr4GDevice(str, str2) == 124 || isNBOr4GDevice(str, str2) == 125;
    }

    public static boolean isNew4GDevice(String str, String str2) {
        return isNBOr4GDevice(str, str2) == 123 || isNBOr4GDevice(str, str2) == 129 || isNBOr4GDevice(str, str2) == 130 || isNBOr4GDevice(str, str2) == 124 || isNBOr4GDevice(str, str2) == 125 || isNBOr4GDevice(str, str2) == 126 || isNBOr4GDevice(str, str2) == 127 || isNBOr4GDevice(str, str2) == 128;
    }
}
