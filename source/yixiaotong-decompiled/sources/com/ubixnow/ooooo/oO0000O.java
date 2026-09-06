package com.ubixnow.ooooo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.utils.BaseUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0000O {
    private static String OooO00o = new String(oO0Oo0o0.OooO00o().OooO00o("SjdrUDNzUjlv".getBytes())).concat(new String(oO0Oo0o0.OooO00o().OooO00o("TDJxQTVtWA==".getBytes())));

    public static int OooO00o(float f) {
        float f2 = BaseUtils.getContext().getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static int OooO00o(int i) {
        return (int) ((i * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int OooO00o(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j > 0) {
            calendar.setTime(new Date(j));
        }
        Calendar calendar2 = Calendar.getInstance();
        int i = 0;
        while (calendar.before(calendar2) && calendar.get(5) != calendar2.get(5)) {
            calendar.add(5, 1);
            i++;
        }
        return i;
    }

    public static int OooO00o(String str, String str2) {
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit2[0])) {
                return 1;
            }
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i = 0;
            while (i < iMax) {
                int iCompareTo = (i < strArrSplit.length ? strArrSplit[i] : "0").compareTo(i < strArrSplit2.length ? strArrSplit2[i] : "0");
                if (iCompareTo > 0) {
                    return 1;
                }
                if (iCompareTo < 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return 1;
        }
    }

    public static oO000o00 OooO00o(String str) throws Exception {
        try {
            return oO000o00.OooO00o(OooO0O0(str));
        } catch (Exception e) {
            System.out.println("Error during decryption: " + e.getMessage());
            return null;
        }
    }

    public static oO0OOo0o OooO00o(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStreamOpen = BaseUtils.getContext().getAssets().open(str2 + "/" + str3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            inputStreamOpen.close();
            oO000o00 oo000o00OooO00o = OooO00o(sb.toString());
            if (oo000o00OooO00o == null) {
                return null;
            }
            for (oO0OOo0o oo0ooo0o : oo000o00OooO00o.OooO0OO) {
                if (oo0ooo0o.OooO0o0[0].OooO0OO.equals(str)) {
                    ooooO000.OooO0O0("---pre cache", "use asserts strategy!");
                    return oo0ooo0o;
                }
            }
            return null;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    public static String OooO00o() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + "/" + calendar.get(2) + "1/" + calendar.get(1);
    }

    public static String OooO00o(String str, String[] strArr) {
        try {
            int length = (str.split("%s").length - 1) - strArr.length;
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            for (int i = 0; i < length; i++) {
                arrayList.add(PPSLabelView.Code);
            }
            return String.format(str, arrayList.toArray());
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    public static String OooO00o(byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(OooO00o.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(OooO00o.getBytes()));
        return OooO0OO(cipher.doFinal(bArr));
    }

    public static boolean OooO00o(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] OooO00o(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                    e.printStackTrace();
                    return new byte[0];
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static int[] OooO00o(int i, int i2, int i3, int i4, boolean z) {
        double d;
        double d2;
        float f = i3 * 0.9f;
        if (i > f) {
            d = f;
            d2 = ((double) i2) * (d / ((double) i));
        } else {
            d = i;
            d2 = i2;
        }
        double d3 = i4 * 0.9f;
        if (d2 > d3) {
            d *= (((double) i4) * 0.9d) / d2;
            d2 = d3;
        }
        if (z) {
            try {
                if (d < OooO00o(80) || d2 < OooO00o(80)) {
                    ooooO000.OooO0O0("---UMNNativeAdView", "百度不能添加摇一摇控件");
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new int[]{(int) d2, (int) d};
    }

    public static int OooO0O0(String str, String str2) {
        try {
            if (str.equals(str2)) {
                return 0;
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
            int i = 0;
            int i2 = 0;
            while (i < iMin) {
                i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                if (i2 != 0) {
                    break;
                }
                i++;
            }
            if (i2 != 0) {
                return i2 > 0 ? 1 : -1;
            }
            for (int i3 = i; i3 < strArrSplit.length; i3++) {
                if (Integer.parseInt(strArrSplit[i3]) > 0) {
                    return 1;
                }
            }
            while (i < strArrSplit2.length) {
                if (Integer.parseInt(strArrSplit2[i]) > 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return 0;
        }
    }

    public static String OooO0O0(int i) {
        String version;
        o00O0O0O o00o0o0oOooO0O0;
        try {
            switch (i) {
                case 1:
                    String str = oO00000o.oo0o0Oo.OooO00o;
                    if (str != null) {
                        return str;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.oo0o0Oo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.oo0o0Oo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 2:
                    String str2 = oO00000o.Oooo000.OooO00o;
                    if (str2 != null) {
                        return str2;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.Oooo000.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.Oooo000.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 3:
                    String str3 = oO00000o.oo000o.OooO00o;
                    if (str3 != null) {
                        return str3;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.oo000o.OooO0OO);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.oo000o.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 4:
                    String str4 = oO00000o.o00Ooo.OooO00o;
                    if (str4 != null) {
                        return str4;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o00Ooo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o00Ooo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 5:
                    String str5 = oO00000o.o0000Ooo.OooO00o;
                    if (str5 != null) {
                        return str5;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000Ooo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000Ooo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 6:
                    String str6 = oO00000o.OooO.OooO00o;
                    if (str6 != null) {
                        return str6;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooO.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooO.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 7:
                    String str7 = oO00000o.o00Oo0.OooO00o;
                    if (str7 != null) {
                        return str7;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o00Oo0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o00Oo0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 8:
                    String str8 = oO00000o.o000000O.OooO00o;
                    if (str8 != null) {
                        return str8;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o000000O.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o000000O.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 9:
                    String str9 = oO00000o.o000oOoO.OooO00o;
                    if (str9 != null) {
                        return str9;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o000oOoO.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o000oOoO.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 10:
                    String str10 = oO00000o.OooOO0.OooO00o;
                    if (str10 != null) {
                        return str10;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooOO0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooOO0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 11:
                case 12:
                case 13:
                case 16:
                case 31:
                default:
                    o00o0o0oOooO0O0 = null;
                    break;
                case 14:
                    String str11 = oO00000o.o00oO0o.OooO00o;
                    if (str11 != null) {
                        return str11;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o00oO0o.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o00oO0o.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 15:
                    String str12 = oO00000o.o0Oo0oo.OooO00o;
                    if (str12 != null) {
                        return str12;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0Oo0oo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0Oo0oo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 17:
                    String str13 = oO00000o.Oooo0.OooO00o;
                    if (str13 != null) {
                        return str13;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.Oooo0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.Oooo0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 18:
                    String str14 = oO00000o.o0OOO0o.OooO00o;
                    if (str14 != null) {
                        return str14;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0OOO0o.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0OOO0o.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 19:
                    String str15 = oO00000o.o0000.OooO00o;
                    if (str15 != null) {
                        return str15;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 20:
                    String str16 = oO00000o.o0000O0.OooO00o;
                    if (str16 != null) {
                        return str16;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000O0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000O0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 21:
                    String str17 = oO00000o.o0000oo.OooO00o;
                    if (str17 != null) {
                        return str17;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000oo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000oo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 22:
                    String str18 = oO00000o.o000OO.OooO00o;
                    if (str18 != null) {
                        return str18;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o000OO.OooO0OO);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o000OO.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 23:
                    String str19 = oO00000o.o000OOo.OooO00o;
                    if (str19 != null) {
                        return str19;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o000OOo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o000OOo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 24:
                    String str20 = oO00000o.OooOo.OooO00o;
                    if (str20 != null) {
                        return str20;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooOo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooOo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 25:
                    String str21 = oO00000o.o0OO00O.OooO00o;
                    if (str21 != null) {
                        return str21;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0OO00O.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0OO00O.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 26:
                    String str22 = oO00000o.OooOO0O.OooO00o;
                    if (str22 != null) {
                        return str22;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooOO0O.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooOO0O.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 27:
                    String str23 = oO00000o.o00000.OooO00o;
                    if (str23 != null) {
                        return str23;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o00000.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o00000.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 28:
                    String str24 = oO00000o.o0ooOOo.OooO00o;
                    if (str24 != null) {
                        return str24;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0ooOOo.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0ooOOo.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 29:
                    String str25 = oO00000o.o00000O.OooO00o;
                    if (str25 != null) {
                        return str25;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o00000O.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o00000O.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 30:
                    String str26 = oO00000o.OooOOO0.OooO00o;
                    if (str26 != null) {
                        return str26;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooOOO0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooOOO0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 32:
                    String str27 = oO00000o.o0000O0O.OooO00o;
                    if (str27 != null) {
                        return str27;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000O0O.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000O0O.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 33:
                    String str28 = oO00000o.o0OoOo0.OooO00o;
                    if (str28 != null) {
                        return str28;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0OoOo0.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0OoOo0.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 34:
                    String str29 = oO00000o.o0000O00.OooO00o;
                    if (str29 != null) {
                        return str29;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.o0000O00.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.o0000O00.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
                case 35:
                    String str30 = oO00000o.OooOo00.OooO00o;
                    if (str30 != null) {
                        return str30;
                    }
                    o00o0o0oOooO0O0 = o00O0OOO.OooO0O0(oO00000o.OooOo00.OooO0O0);
                    if (o00o0o0oOooO0O0 != null) {
                        oO00000o.OooOo00.OooO00o = o00o0o0oOooO0O0.getVersion();
                    }
                    break;
                    break;
            }
            version = o00o0o0oOooO0O0 != null ? o00o0o0oOooO0O0.getVersion() : "";
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return version == null ? "" : version;
    }

    public static void OooO0O0() {
        try {
            ooooO000.OooO0O0(ooooO000.OooO0O0, "-----sApp-queryPkgD size: " + oO00000o.o00O0O.OooOO0O.size() + PPSLabelView.Code + oO00000o.o00O0O.OooOO0O);
            String path = BaseUtils.getCacheDir().getParentFile().getParentFile().getPath();
            String path2 = BaseUtils.getExternalDir().getParentFile().getParentFile().getPath();
            for (String str : oO00000o.o00O0O.OooOO0O.keySet()) {
                StringBuilder sbAppend = new StringBuilder().append(path2);
                String str2 = File.separator;
                String string = sbAppend.append(str2).append(str).toString();
                String str3 = path + str2 + str;
                File file = new File(string);
                if (new File(str3).exists() || (file.exists() && !TextUtils.isEmpty(oO00000o.o00O0O.OooOO0O.get(str)))) {
                    ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("k1") + str);
                    o0O0ooO.OooO0OO.add(oO00000o.o00O0O.OooOO0O.get(str));
                    o0O0ooO.OooO0Oo.add(str);
                }
            }
            oOo00o00.OooO00o(oO00000o.o00000O0.OooO, o0O0ooO.OooO0OO.toString());
            oOo00o00.OooO00o(oO00000o.o00000O0.OooOO0, o0O0ooO.OooO0Oo.toString());
            ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("k2") + o0O0ooO.OooO0OO);
        } catch (Exception e) {
            ooooO000.OooO0O0(ooooO000.OooO0O0, "-----sApp-pkg--Exception：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static byte[] OooO0O0(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(OooO00o.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(OooO00o.getBytes()));
            return cipher.doFinal(OooO0o(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] OooO0O0(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int OooO0OO(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "1":
                return 1;
            case "3":
                return 2;
            case "5":
                return 5;
            case "03":
                return 3;
            case "04":
                return 4;
            default:
                return 0;
        }
    }

    public static String OooO0OO(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void OooO0OO() {
        if (oO00000o.o00O0O.OooOO0o != null) {
            ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("k3") + " size: " + oO00000o.o00O0O.OooOO0o.size() + PPSLabelView.Code + oO00000o.o00O0O.OooOO0o);
            for (String str : oO00000o.o00O0O.OooOO0o.keySet()) {
                if (OooO00o(BaseUtils.getContext(), OooO0Oo(str)) && !TextUtils.isEmpty(oO00000o.o00O0O.OooOO0o.get(str))) {
                    ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("k3") + "安装 " + str);
                    o0O0ooO.OooO0OO.add(oO00000o.o00O0O.OooOO0o.get(str));
                    o0O0ooO.OooO0Oo.add(str);
                }
            }
            oOo00o00.OooO00o(oO00000o.o00000O0.OooO, o0O0ooO.OooO0OO.toString());
            oOo00o00.OooO00o(oO00000o.o00000O0.OooOO0, o0O0ooO.OooO0Oo.toString());
        }
        ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("k3") + " install_list: " + o0O0ooO.OooO0OO);
    }

    public static Intent OooO0Oo(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        return intent;
    }

    private static String OooO0Oo(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] OooO0o(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String OooO0o0(String str) {
        return OooO0Oo(str.getBytes());
    }

    public static byte[] OooO0o0(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static oO0Oo0oo OooO0oO(String str) {
        try {
            return oO0Oo0oo.OooO00o(OooO0o0(OooO0O0(str)));
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }
}
