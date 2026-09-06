package com.hihonor.secure.android.common.enc2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.am;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ODS {
    public ODS() {
        System.loadLibrary("ods");
    }

    private native byte[] getwbwkc(byte[] bArr, byte[] bArr2);

    public String getAkInfo(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            Log.e("ODS", "error： 0x010201");
            return null;
        }
        if (str2 == null || str2.length() <= 56 || str2.length() % 2 != 0) {
            Log.e("ODS", "error： 0x010202");
            return null;
        }
        try {
            byte[] bArr = getwbwkc(null, Hex.decodeHex(str2.toCharArray()));
            if (TextUtils.isEmpty(str) || bArr == null) {
                str3 = "error： 0x010401";
            } else {
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
                    Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
                    mac.init(secretKeySpec);
                    return new String(Hex.encodeHex(mac.doFinal(str.getBytes(StandardCharsets.UTF_8))));
                } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
                    str3 = "error： 0x010402";
                }
            }
            Log.e("ODS", str3);
            return null;
        } catch (DecoderException unused2) {
            Log.e("ODS", "error： 0x010203");
            return null;
        }
    }

    public String getDeviceInfoHash(Context context) throws Exception {
        String string;
        if (context == null) {
            Log.e("ODS", "error： 0x010101");
            throw new Exception("context is null, not allowed！");
        }
        String str = Build.FINGERPRINT;
        String str2 = str != null ? new String(Base64.encodeBase64(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : "";
        List<Sensor> sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1);
        StringBuilder sb = new StringBuilder();
        Iterator<Sensor> it = sensorList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(System.lineSeparator());
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(sb.toString().getBytes(StandardCharsets.UTF_8));
            StringBuilder sb2 = new StringBuilder();
            for (byte b : bArrDigest) {
                sb2.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            string = sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            Log.e("ODS", "error： 0x020101");
            string = null;
        }
        String str3 = string != null ? new String(Base64.encodeBase64(string.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : "";
        String string2 = Settings.Global.getString(context.getContentResolver(), am.J);
        String str4 = string2 != null ? new String(Base64.encodeBase64(string2.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : "";
        String property = System.getProperty("os.version");
        String str5 = property != null ? new String(Base64.encodeBase64(property.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : "";
        String str6 = str2 + "|" + str3 + "|" + str4 + "|" + str5;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            try {
                return new String(Base64.encodeBase64(MessageDigest.getInstance("SHA-256").digest("['0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0']".getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
            } catch (NoSuchAlgorithmException unused2) {
                Log.e("ODS", "error： 0x010301");
                return null;
            }
        }
        try {
            return new String(Base64.encodeBase64(MessageDigest.getInstance("SHA-256").digest(str6.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException unused3) {
            Log.e("ODS", "error： 0x010301");
            return null;
        }
    }
}
