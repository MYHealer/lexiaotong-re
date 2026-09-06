package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class y1 {
    public static long a(String str, long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            Date date = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j)));
            if (date == null) {
                return 0L;
            }
            return date.getTime();
        } catch (ParseException e) {
            j2.g("StringUtils", "getMillisOfDate failE=" + SystemUtils.getDesensitizedException(e));
            return 0L;
        }
    }

    public static String a() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039";
    }

    public static String a(String str, int i) {
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            int length = str.length();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = length - 1;
                str = str.substring(i3) + str.substring(0, i3);
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        byte[] bArrA = w1.a(str);
        byte[] bArrA2 = w1.a(str2);
        byte[] bArrA3 = w1.a(str3);
        byte[] bArrA4 = w1.a(str4);
        int length = bArrA.length;
        if (length > bArrA2.length) {
            length = bArrA2.length;
        }
        if (length > bArrA3.length) {
            length = bArrA3.length;
        }
        if (length > bArrA4.length) {
            length = bArrA4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((bArrA[i] ^ bArrA2[i]) ^ bArrA3[i]) ^ bArrA4[i]);
        }
        return a(cArr, w1.a(str5));
    }

    private static String a(char[] cArr, byte[] bArr) {
        String str;
        try {
            return w1.a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 128)).getEncoded());
        } catch (NoSuchAlgorithmException unused) {
            str = "getAuthToken() encryptPBKDF2 No such algorithm!";
            j2.b("StringUtils", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "getAuthToken() encryptPBKDF2 Invalid key specification !";
            j2.b("StringUtils", str);
            return null;
        }
    }

    public static void a(Map<String, Map<String, List<g1>>> map, Map<String, Map<String, List<g1>>> map2) {
        for (Map.Entry<String, Map<String, List<g1>>> entry : map.entrySet()) {
            String key = entry.getKey();
            Map<String, List<g1>> value = entry.getValue();
            Map<String, List<g1>> map3 = map2.get(key);
            if (map3 == null) {
                map2.put(key, value);
            } else {
                for (Map.Entry<String, List<g1>> entry2 : value.entrySet()) {
                    String key2 = entry2.getKey();
                    List<g1> value2 = entry2.getValue();
                    List<g1> list = map3.get(key2);
                    if (list != null) {
                        list.addAll(value2);
                    } else {
                        map3.put(key2, value2);
                    }
                }
            }
        }
    }

    public static String[] a(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(str.replace("{url}", it.next()));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
