package client.android.yixiaotong.zksoundwave;

import android.content.Context;
import android.content.pm.PackageManager;
import client.android.yixiaotong.zksoundwave.b.d;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SWCommandUtil {
    public static String PACKAGENAME = "cn.anjjie.elec.zxxy";
    public static String PACKAGENAME1 = "com.warmcome.CSAJU";
    public static String PACKAGENAME2 = "com.ChaneyTechnology.XiaoXiao";
    public static String PACKAGENAME3 = "com.warmcome.huanong";
    public static final int PlayFreqIndexStart = 60;
    public static final int RecogFreqIndexStart = 60;
    public static final int RecogThreshold = 50;
    public static String SIGN = "ec03755c628220929c4d15f69257fb8c";
    public static String SIGN1 = "ca1338b444d3ff9650cdd4229ab97142";
    public static String SIGN2 = "638c7d6f4a2724f7fe58ec174967324f";
    public static String SIGN3 = "a501a13b84120c99de4bb0ad836dac5b";
    public static final int SampleRate = 44100;
    private static boolean isRegisterApp = true;
    private client.android.yixiaotong.zksoundwave.soundwavedatamanage.a jniSoundWaveDataManage;

    private SWCommandUtil() {
    }

    /* synthetic */ SWCommandUtil(a aVar) {
        this();
    }

    public static SWCommandUtil getInstance() {
        return b.f970a;
    }

    public boolean checkDataOne(String str, String str2) {
        if (isRegisterApp) {
            return client.android.yixiaotong.zksoundwave.b.b.a(str, str2);
        }
        return false;
    }

    public String encryptionMD5(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public String getSignMd5Str(Context context) {
        try {
            return encryptionMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void initDataManage() {
        if (isRegisterApp && this.jniSoundWaveDataManage == null) {
            this.jniSoundWaveDataManage = new client.android.yixiaotong.zksoundwave.soundwavedatamanage.a();
        }
    }

    public void openLog(boolean z) {
        d.a(z);
    }

    public void registerApp(Context context) {
        String signMd5Str = getSignMd5Str(context);
        String packageName = context.getPackageName();
        if ((PACKAGENAME.equals(packageName) || PACKAGENAME1.equals(packageName) || PACKAGENAME2.equals(packageName) || PACKAGENAME3.equals(packageName)) && signMd5Str != null && signMd5Str.length() > 0 && (SIGN.equals(signMd5Str) || SIGN1.equals(signMd5Str) || SIGN2.equals(signMd5Str) || SIGN3.equals(signMd5Str))) {
            isRegisterApp = true;
        } else {
            isRegisterApp = false;
        }
    }

    public void sendGetQrcodeData(String str, String str2) {
        if (!isRegisterApp || this.jniSoundWaveDataManage == null || str.isEmpty()) {
            return;
        }
        this.jniSoundWaveDataManage.a(str, str2);
    }

    public void sendQrcodeData(String str, int i) {
        if (!isRegisterApp || this.jniSoundWaveDataManage == null || str.isEmpty()) {
            return;
        }
        this.jniSoundWaveDataManage.a(str, i);
    }

    public void setDataListener(SoundWaveDataListener soundWaveDataListener) {
        client.android.yixiaotong.zksoundwave.soundwavedatamanage.a aVar;
        if (!isRegisterApp || (aVar = this.jniSoundWaveDataManage) == null) {
            return;
        }
        aVar.a(soundWaveDataListener);
    }

    public void unRegisterApp() {
        isRegisterApp = false;
    }
}
