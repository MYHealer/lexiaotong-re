package client.android.yixiaotong.sdk.core;

import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CommandUtilsTwo {
    static String getOnlineConnectCommandTwo(long j, String str, boolean z, boolean z2) {
        String str2;
        StringBuilder sb = new StringBuilder("55 00 01 1A f0");
        String strBufferToHex = HexString.bufferToHex(LongUtils.long2Bytes(j));
        sb.append(strBufferToHex);
        sb.append(str);
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strReplace = (str.substring(4) + randomString).toUpperCase().replace(PPSLabelView.Code, "");
        if (z) {
            str2 = strBufferToHex + "01";
        } else {
            str2 = strBufferToHex + "00";
        }
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC(strReplace, str2 + "5477730000000A", 0);
        sb.append(strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8));
        if (z) {
            sb.append("BC");
        } else {
            sb.append("00");
        }
        if (z2) {
            CommandUtilsWrapper.Netflag = "0000";
            sb.append("00");
        } else {
            CommandUtilsWrapper.Netflag = "0004";
            sb.append("01");
        }
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOfflineConnectCommandTwo(long j, String str) {
        StringBuilder sb = new StringBuilder("55 AA AA 1A f0");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(str);
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES_MAC = new MacDesUtils().PBOC_3DES_MAC((str.substring(4) + randomString).toUpperCase().replace(PPSLabelView.Code, ""), "8554777385547773855477730000000A", 0);
        sb.append(strPBOC_3DES_MAC.substring(strPBOC_3DES_MAC.length() - 8));
        sb.append("BC00");
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOnlineConfirmCommandTwo(long j, short s, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 00");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((randomString + str).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOfflineConfirmCommandTwo(long j, short s, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 03");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((randomString + str).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String getOfflineDataCollectCommandTwo(long j, short s, String str) {
        StringBuilder sb = new StringBuilder("55 00 01 1A f1");
        sb.append(HexString.bufferToHex(LongUtils.long2Bytes(j)));
        sb.append(HexString.bufferToHex(ShortUtils.shortToBytes(s)));
        sb.append("00 04");
        String randomString = RandomUtils.getRandomString();
        sb.append(randomString);
        String strPBOC_3DES = new MacDesUtils().PBOC_3DES((randomString + str).toUpperCase().replace(PPSLabelView.Code, ""), "855477738554777385547773" + str, 0);
        sb.append(strPBOC_3DES.substring(strPBOC_3DES.length() - 16));
        sb.append(new XOrUtils().xOr(sb.toString().replace(PPSLabelView.Code, "").substring(2)));
        return sb.toString().replace(PPSLabelView.Code, "");
    }

    static String bindState(byte[] bArr) {
        String strBufferToHex = HexString.bufferToHex(bArr);
        return (strBufferToHex == null || strBufferToHex.length() <= 6) ? strBufferToHex : strBufferToHex.substring(strBufferToHex.length() - 6, strBufferToHex.length() - 4);
    }

    static int isoffineRecordState(byte[] bArr) {
        int iBytesToInt2;
        String strBufferToHex = HexString.bufferToHex(bArr);
        String strSubstring = strBufferToHex.substring(8, 12);
        if (strSubstring.toLowerCase().equals("02f0")) {
            byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(strBufferToHex.length() - 4, strBufferToHex.length() - 2));
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
            iBytesToInt2 = IntegerUtils.bytesToInt2(bArr2, 0);
        } else {
            if (!strSubstring.toLowerCase().equals("00f0")) {
                return -1;
            }
            byte[] bArrHexToBuffer2 = HexString.hexToBuffer(strBufferToHex.substring(strBufferToHex.length() - 4, strBufferToHex.length() - 2));
            byte[] bArr3 = new byte[4];
            System.arraycopy(bArrHexToBuffer2, 0, bArr3, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
            iBytesToInt2 = IntegerUtils.bytesToInt2(bArr3, 0);
        }
        return (short) iBytesToInt2;
    }

    static boolean isConfirmOfflineResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        return upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length())) && upperCase.substring(12, 14).equals("f1".toUpperCase()) && upperCase.substring(8, 12).equals("0001");
    }

    static boolean isBindDeviceResult(byte[] bArr) {
        String upperCase = HexString.bufferToHex(bArr).toUpperCase();
        return upperCase.length() >= 13 && new XOrUtils().xOr(upperCase.toString().replace(PPSLabelView.Code, "").substring(2, upperCase.length() - 2)).equals(upperCase.substring(upperCase.length() - 2, upperCase.length())) && upperCase.substring(12, 14).equals("f1".toUpperCase()) && upperCase.substring(8, 12).equals("0D01");
    }

    public static int getMachineDataLength(byte[] bArr) {
        try {
            String upperCase = HexString.bufferToHex(bArr).toUpperCase();
            if (upperCase.length() < 10) {
                return 0;
            }
            return IntegerUtils.byteToInt(HexString.hexToBuffer(upperCase.substring(6, 8))[0]);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getPosNumber(byte[] bArr) {
        try {
            String upperCase = HexString.bufferToHex(bArr).toUpperCase();
            if (upperCase.length() < 10) {
                return 0;
            }
            return IntegerUtils.byteToInt(HexString.hexToBuffer(upperCase.substring(62, 64))[0]);
        } catch (Exception unused) {
            return 0;
        }
    }
}
