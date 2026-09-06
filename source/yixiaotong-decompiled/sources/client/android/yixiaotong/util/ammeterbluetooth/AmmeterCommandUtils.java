package client.android.yixiaotong.util.ammeterbluetooth;

import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterDes;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.v3.comman.DeviceTypeVersionController;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterCommandUtils {
    public static int HexStringToInt(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return Integer.parseInt(str, 16);
        }
        return 0;
    }

    public static String sumCheckCode(String str) {
        if (str.length() % 2 != 0) {
            return "00";
        }
        int i = 0;
        int iHexStringToInt = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            iHexStringToInt += HexStringToInt(str.substring(i, i2));
            i = i2;
        }
        String upperCase = Integer.toHexString(iHexStringToInt % 256).toUpperCase();
        return upperCase.length() == 1 ? "0" + upperCase : upperCase;
    }

    public static String hexToAscii(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() % 2 != 0) {
            return "00";
        }
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            int iHexStringToInt = HexStringToInt(str.substring(i, i2));
            if (iHexStringToInt >= 0 && iHexStringToInt <= 127) {
                sb.append((char) iHexStringToInt);
            }
            i = i2;
        }
        return sb.toString();
    }

    public static boolean isConnectResult(String str) {
        if (str.length() < 7) {
            return false;
        }
        return "A5".equals(str.substring(0, 2).toUpperCase());
    }

    public static String getDeviceInfo(String str) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes("FF" + str + "01");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isReceiveDataFormat(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() >= 8 && strBufferToHex.substring(0, 2).toUpperCase().equals("A5") && (strBufferToHex.length() / 2) - 3 == Integer.parseInt(strBufferToHex.substring(2, 4), 16)) {
            return strBufferToHex.substring(strBufferToHex.length() - 2, strBufferToHex.length()).toUpperCase().equals(sumCheckCode(strBufferToHex.substring(0, strBufferToHex.length() - 2)));
        }
        return false;
    }

    public static String[] receiveDeviceInfo(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        String strHexToAscii = hexToAscii(strBufferToHex.substring(6, strBufferToHex.length() - 2));
        if (StringUtils.isNotEmpty(strHexToAscii)) {
            String[] strArrSplit = strHexToAscii.split(",");
            if (strArrSplit.length == 3) {
                return strArrSplit;
            }
        }
        return new String[]{"00"};
    }

    public static String getDeviceTypeAndState(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "02");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isReceiveDeviceTypeAndState(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("82");
    }

    public static String getDeviceNumber(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "03");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    public static boolean isReceiveDeviceNumber(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("83");
    }

    public static String getUserNumber(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "04");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isReceiveUserNumber(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("84");
    }

    public static String writeUserNumber(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str2 + str3 + "05" + str);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isWriteDeviceUserNumber(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("85");
    }

    public static String getDate(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "06");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isGetDate(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("86");
    }

    public static String writeDate(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str2 + str3 + "07" + str);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isWriteDate(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("87");
    }

    public static String getElectrovalence(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "08");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isGetElectrovalence(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("88");
    }

    public static String writeElectrovalence(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("A5");
        String strValueOf = String.valueOf((int) (Float.parseFloat(str) * 10000.0f));
        if (strValueOf.length() < 8) {
            if (strValueOf.length() == 1) {
                strValueOf = "0000000" + strValueOf;
            } else if (strValueOf.length() == 2) {
                strValueOf = "000000" + strValueOf;
            } else if (strValueOf.length() == 3) {
                strValueOf = "00000" + strValueOf;
            } else if (strValueOf.length() == 4) {
                strValueOf = "0000" + strValueOf;
            } else if (strValueOf.length() == 5) {
                strValueOf = Constant.DEFAULT_CVN2 + strValueOf;
            } else if (strValueOf.length() == 6) {
                strValueOf = "00" + strValueOf;
            } else if (strValueOf.length() == 7) {
                strValueOf = "0" + strValueOf;
            }
        }
        String strEnDes = AmmeterDes.enDes(str2 + str3 + DeviceTypeVersionController.Bluetooth_Device_Ver_DM1 + strValueOf);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isWriteElectrovalence(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("89");
    }

    public static String getBalance(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "0A");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isGetAmmeterBalance(byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        if (strBufferToHex.length() < 7) {
            return false;
        }
        return strBufferToHex.substring(4, 6).equals("8A");
    }

    public static String writeAccountRechargeDestroy(String str, short s, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder("A5");
        String string = Short.toString(s);
        if ("00".equals(str)) {
            int length = string.length();
            if (length == 1) {
                string = "00000" + string;
            } else if (length == 2) {
                string = "0000" + string;
            } else if (length == 3) {
                string = Constant.DEFAULT_CVN2 + string;
            } else if (length == 4) {
                string = "00" + string;
            }
        } else if ("01".equals(str)) {
            int length2 = string.length();
            if (length2 == 1) {
                str4 = "01000" + string;
            } else if (length2 == 2) {
                str4 = "0100" + string;
            } else if (length2 == 3) {
                str4 = "010" + string;
            } else if (length2 == 4) {
                str4 = "01" + string;
            }
            string = str4;
        } else if ("02".equals(str)) {
            string = "020000";
        }
        String strEnDes = AmmeterDes.enDes(str2 + str3 + "0B" + string);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isAmmeterrecharge(byte[] bArr) {
        String upperCase = AmmeterBluetoothDevice.HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() < 7) {
            return false;
        }
        return upperCase.substring(4, 6).equals("8B");
    }

    public static String getElectricityConsumption(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "0C");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getInit() {
        StringBuilder sb = new StringBuilder("A5E4");
        String strEnDes = AmmeterDes.enDes("FF" + AmmeterRandomUtils.getRandNumMaxString(2) + "3E");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getAllInfo(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + BaseWrapper.ENTER_ID_TOOLKIT);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String writeAllInfo(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder("A5");
        String strValueOf = String.valueOf((int) (Float.parseFloat(str3) * 10000.0f));
        if (strValueOf.length() < 8) {
            if (strValueOf.length() == 1) {
                strValueOf = "0000000" + strValueOf;
            } else if (strValueOf.length() == 2) {
                strValueOf = "000000" + strValueOf;
            } else if (strValueOf.length() == 3) {
                strValueOf = "00000" + strValueOf;
            } else if (strValueOf.length() == 4) {
                strValueOf = "0000" + strValueOf;
            } else if (strValueOf.length() == 5) {
                strValueOf = Constant.DEFAULT_CVN2 + strValueOf;
            } else if (strValueOf.length() == 6) {
                strValueOf = "00" + strValueOf;
            } else if (strValueOf.length() == 7) {
                strValueOf = "0" + strValueOf;
            }
        }
        String strEnDes = AmmeterDes.enDes(str4 + str5 + BaseWrapper.ENTER_ID_OAPS_DEMO + str + str2 + strValueOf);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String writeDateTimeAndEle(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("A5");
        String strValueOf = String.valueOf((int) (Float.parseFloat(str2) * 10000.0f));
        if (strValueOf.length() < 8) {
            if (strValueOf.length() == 1) {
                strValueOf = "0000000" + strValueOf;
            } else if (strValueOf.length() == 2) {
                strValueOf = "000000" + strValueOf;
            } else if (strValueOf.length() == 3) {
                strValueOf = "00000" + strValueOf;
            } else if (strValueOf.length() == 4) {
                strValueOf = "0000" + strValueOf;
            } else if (strValueOf.length() == 5) {
                strValueOf = Constant.DEFAULT_CVN2 + strValueOf;
            } else if (strValueOf.length() == 6) {
                strValueOf = "00" + strValueOf;
            } else if (strValueOf.length() == 7) {
                strValueOf = "0" + strValueOf;
            }
        }
        String strEnDes = AmmeterDes.enDes(str3 + str4 + "32" + str + strValueOf);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String writeDateAndRecharge(String str, short s, String str2, String str3) {
        StringBuilder sb = new StringBuilder("A5");
        String string = Short.toString(s);
        int length = string.length();
        if (length == 1) {
            string = Constant.DEFAULT_CVN2 + string;
        } else if (length == 2) {
            string = "00" + string;
        } else if (length == 3) {
            string = "0" + string;
        }
        String strEnDes = AmmeterDes.enDes(str2 + str3 + BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN + str + string);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getDeviceTypeStateDeviceNouserNo(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getDeviceNoUserNoDateBalabceEle(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + BaseWrapper.ENTER_ID_OAPS_FLOWMARKET);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getDeviceTypeStateUserNoBalanceEle(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + BaseWrapper.ENTER_ID_OAPS_GAMESPACE);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getDeviceTypeStateUserNoRecored(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "380" + i);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String getPurchaseRecord(int i, String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder("A5");
        if (i < 10) {
            str3 = "0" + i;
        } else {
            str3 = i == 10 ? i + "" : "";
        }
        String strEnDes = AmmeterDes.enDes(str + str2 + BaseWrapper.ENTER_ID_OAPS_ROAMING + str3);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static boolean isGetAmmeterElectricityConsumption(byte[] bArr) {
        String upperCase = AmmeterBluetoothDevice.HexString.bufferToHex(bArr).toUpperCase();
        if (upperCase.length() < 7) {
            return false;
        }
        return upperCase.substring(4, 6).equals("8C");
    }

    public static String getBalanceAndDeviceTypeAndState(String str, String str2) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str + str2 + "0D");
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }

    public static String setName(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("A5");
        String strEnDes = AmmeterDes.enDes(str2 + str3 + "0F" + str);
        String upperCase = Integer.toHexString(strEnDes.length() / 2).toUpperCase();
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        sb.append(strEnDes);
        sb.append(sumCheckCode("A5" + upperCase + strEnDes));
        return sb.toString().toUpperCase().replace(PPSLabelView.Code, "");
    }
}
