package client.android.yixiaotong.v3.comman;

import androidx.exifinterface.media.ExifInterface;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInfoUtil {
    private static final String TAG = "DeviceInfoUtil";

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.comman.DeviceInfoUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public String getAppName(int i) {
        if (i == 1 || i == 17) {
            return "洗澡/扫码淋浴";
        }
        if (i == 3) {
            return "洗衣";
        }
        if (i == 6) {
            return "饮水";
        }
        if (i == 8) {
            return "吹风";
        }
        if (i == 11) {
            return "公共澡堂";
        }
        if (i == 16) {
            return "干衣";
        }
        if (i == 18) {
            return "预付费水表";
        }
        if (i == 20) {
            return "领款机";
        }
        return i == 9 ? "售卡" : "";
    }

    /* synthetic */ DeviceInfoUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private DeviceInfoUtil() {
    }

    private static final class SINGLEHOLDER {
        private static final DeviceInfoUtil INSTANCE = new DeviceInfoUtil(null);

        private SINGLEHOLDER() {
        }
    }

    public static DeviceInfoUtil getInstance() {
        return SINGLEHOLDER.INSTANCE;
    }

    public String getType(String str) {
        return BathUtil.receivedResult(str.substring(14, 16), str.substring(4, 6), str.substring(6, 8));
    }

    public String getVersion(String str) {
        return BathUtil.receivedResult(str.substring(16, 18), str.substring(4, 6), str.substring(6, 8));
    }

    public String getCmd(String str) {
        return BathUtil.receivedResult(str.substring(12, 14), str.substring(4, 6), str.substring(6, 8));
    }

    public String getTypeAndVersion(String str) {
        return BathUtil.receivedResult(str.substring(14, 16), str.substring(4, 6), str.substring(6, 8)) + "," + BathUtil.receivedResult(str.substring(16, 18), str.substring(4, 6), str.substring(6, 8));
    }

    public String getHexState(String str) {
        return BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8));
    }

    public String getByteState(String str) {
        return StringUtils.getByteString(Integer.toBinaryString(Integer.parseInt(getHexState(str), 16)));
    }

    public boolean isHasOrder(String str) {
        String byteState = getByteState(str);
        return StringUtils.isNotEmpty(byteState) && byteState.length() >= 8 && byteState.substring(6, 7).equals("1");
    }

    public String getSN(String str) {
        return str.substring(22, 38);
    }

    public String getIMEI(String str) {
        return str.substring(50, 65);
    }

    public int getFeilvFen(String str) {
        return Integer.parseInt(str.substring(74, 76), 16);
    }

    public int getMaiChong(String str) {
        return Integer.parseInt(str.substring(76, 78), 16);
    }

    public int getFeilvLi(String str) {
        return Integer.parseInt(str.substring(78, 80), 16);
    }

    public int getFeilvMaxMoney(String str) {
        return Integer.parseInt(str.substring(82, 84) + str.substring(80, 82), 16);
    }

    public int getLimitQuantitySheng(String str) {
        if (str.substring(76, 78).equals("00") || str.substring(84, 86).equals("00")) {
            return -1;
        }
        return (Integer.parseInt(str.substring(82, 84) + str.substring(80, 82), 16) / Integer.parseInt(str.substring(76, 78), 16)) / Integer.parseInt(str.substring(84, 86), 16);
    }

    public int getMaxTimeMiao(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() <= 84) {
            return -1;
        }
        return Integer.parseInt(str.substring(82, 84) + str.substring(80, 82), 16);
    }

    public int getQValue(String str) {
        return Integer.parseInt(str.substring(84, 86), 16);
    }

    public int getAlarmTime(String str) {
        return Integer.parseInt(str.substring(86, 88), 16);
    }

    public int getAlarmCount(String str) {
        return Integer.parseInt(str.substring(88, 90), 16);
    }

    public int getAntimagneticCount(String str) {
        return Integer.parseInt(str.substring(90, 92), 16);
    }

    public boolean isChaiKe(String str) {
        return str.substring(92, 94).equalsIgnoreCase("BC");
    }

    public int get4gSingle(String str) {
        if (str.length() > 88) {
            return Integer.parseInt(str.substring(88, 90), 16);
        }
        return -1;
    }

    public String getICCID(String str) {
        return (!StringUtils.isNotEmpty(str) || str.length() <= 114) ? "" : str.substring(94, 114);
    }

    public String getDeviceVer(String str) {
        return (!StringUtils.isNotEmpty(str) || str.length() <= 142) ? "" : StringUtils.asciiToString2(str.substring(114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO));
    }

    public boolean isNeedWrite67(String str) {
        String deviceVer = getDeviceVer(str);
        if (!StringUtils.isNotEmpty(deviceVer) || deviceVer.length() != 14) {
            return false;
        }
        String strSubstring = deviceVer.substring(6, 8);
        if (deviceVer.substring(6, 7).equalsIgnoreCase(ExifInterface.GPS_DIRECTION_TRUE)) {
            return true;
        }
        int i = Integer.parseInt(strSubstring, 16);
        LogUtil.e(TAG, "isNeedWrite67:" + deviceVer + "  " + strSubstring + "  " + i);
        return i >= 36 && !deviceVer.substring(6, 7).equalsIgnoreCase("B");
    }

    public boolean isEnableOffline(String str) {
        String deviceVer = getDeviceVer(str);
        return StringUtils.isNotEmpty(deviceVer) && deviceVer.length() == 14 && deviceVer.substring(6, 7).equalsIgnoreCase(ExifInterface.GPS_DIRECTION_TRUE);
    }

    public String getMoZuSN(String str) {
        return (!StringUtils.isNotEmpty(str) || str.length() <= 162) ? "" : str.substring(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 162);
    }

    public int getFeilvFenCold(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() <= 164) {
            return -1;
        }
        return Integer.parseInt(str.substring(162, 164), 16);
    }

    public int getMaiChongCold(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() <= 168) {
            return -1;
        }
        return Integer.parseInt(str.substring(166, Opcodes.JSR), 16);
    }

    public int getFeilvLiCold(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() <= 166) {
            return -1;
        }
        return Integer.parseInt(str.substring(164, 166), 16);
    }

    public long getPrepaymentUseMaiChong(String str) {
        return Long.parseLong(str.substring(72, 74) + str.substring(70, 72) + str.substring(68, 70) + str.substring(66, 68), 16);
    }

    public long getPrepaymentResidueMaiChong(String str) {
        return Long.parseLong(str.substring(80, 82) + str.substring(78, 80) + str.substring(76, 78) + str.substring(74, 76), 16);
    }

    public float getPrepaymentBatteryMV(String str) {
        return Integer.parseInt(str.substring(84, 86) + str.substring(82, 84), 16) / 1000.0f;
    }

    public String getAlarmState(String str) {
        String strConcat;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String byteString = StringUtils.getByteString(Integer.toBinaryString(Integer.parseInt(str.substring(86, 88), 16)));
        String str7 = byteString.substring(7, 8).equals("1") ? "开阀状态：未开到位" : "开阀状态：正常";
        if (byteString.substring(6, 7).equals("1")) {
            strConcat = str7.concat("\n关阀状态：未关到位");
        } else {
            strConcat = str7.concat("\n关阀状态：正常");
        }
        if (byteString.substring(5, 6).equals("1")) {
            str2 = strConcat + "\n流量计霍尔1：损坏";
        } else {
            str2 = strConcat + "\n流量计霍尔1：正常";
        }
        if (byteString.substring(4, 5).equals("1")) {
            str3 = str2 + "\n流量计霍尔2：损坏";
        } else {
            str3 = str2 + "\n流量计霍尔2：正常";
        }
        if (byteString.substring(3, 4).equals("1")) {
            str4 = str3 + "\n剩余水量：不足";
        } else {
            str4 = str3 + "\n剩余水量：充足";
        }
        if (byteString.substring(2, 3).equals("1")) {
            str5 = str4 + "\n电池电压：过低";
        } else {
            str5 = str4 + "\n电池电压：正常";
        }
        if (byteString.substring(1, 2).equals("1")) {
            str6 = str5 + "\n存储状态：存储出错";
        } else {
            str6 = str5 + "\n存储状态：正常";
        }
        if (byteString.substring(0, 1).equals("1")) {
            return str6 + "\nSIM卡通讯连接状态：连接异常";
        }
        return str6 + "\nSIM卡通讯连接状态：正常";
    }

    public int getPrepaymentSignalValue(String str) {
        return Integer.parseInt(str.substring(88, 90), 16);
    }

    public String getPremaymentValveState(String str) {
        if (str.substring(90, 92).equals("00")) {
            return "开";
        }
        return str.substring(90, 92).equals("01") ? "关" : "未知";
    }

    public String getPrepaymentCPUVersion(String str) {
        return str.substring(92, 94);
    }

    public String getShiImei(String str) {
        return str.substring(51, 66);
    }

    public boolean isCheckMAC(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > ':') && (str.charAt(i) < 'A' || str.charAt(i) > 'F')) {
                return false;
            }
        }
        return true;
    }
}
