package com.xiaomi.onetrack.util;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9509a = ijiami_1011.s.s.s.d(new byte[]{10, Ascii.EM, 0, Ascii.SYN, 86}, "8718d8");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{41, 11, 0, 100, 71, 89, 2, 15, 70, 80, Ascii.US, 84, 72, 87}, "fee058");
    private static final String k = ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 1, 0, 67, 65, 65, 89, Ascii.ETB, 108}, "e310ad");
    private static final String l = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 83, 8, 17, 66, 70, 89, Ascii.ETB, 70, 71, 3, 84, 65, 65, Ascii.FS, 90, 17, 105}, "2a9bbc");
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{118, Ascii.ETB, 3, 70, 13, 97, Ascii.NAK, 13, 10}, "5eb5e4");
    public static final String d = ijiami_1011.s.s.s.d(new byte[]{79, Ascii.FS, 79, Ascii.DC4, Ascii.GS, 76, 75, 68, 76, 72, Ascii.ESC, 69, 79, Ascii.FS, 79, Ascii.DC4, Ascii.GS, 76, 75, 68, 76, 72, Ascii.ESC, 69, 79, Ascii.FS, 79, Ascii.DC4, Ascii.GS, 76, 75, 68, 76, 72, Ascii.ESC, 69, 79, Ascii.FS, 79, Ascii.DC4, Ascii.GS, 76, 75, 68, 76, 72, Ascii.ESC, 69, 79, Ascii.FS, 79, Ascii.DC4, Ascii.GS, 76, 75, 68, 76, 72, Ascii.ESC, 69, 79, Ascii.FS, 79}, "e6e47f");
    public static final String e = ijiami_1011.s.s.s.d(new byte[]{75, 76, Ascii.EM, Ascii.EM, Ascii.FS, Ascii.DC4, 76, 68, 75, 79, Ascii.FS, 69, 75, 76, Ascii.EM, Ascii.EM, Ascii.FS, Ascii.DC4, 76, 68, 75, 79, Ascii.FS, 69, 75, 76, Ascii.EM, Ascii.EM, Ascii.FS, Ascii.DC4, 76, 68, 75, 79, Ascii.FS, 69, 75, 76, Ascii.EM, Ascii.EM, Ascii.FS, Ascii.DC4, 76, 68, 75, 79, Ascii.FS, 69, 75, 76, Ascii.EM, Ascii.EM, Ascii.FS, Ascii.DC4, 76, 68, 75, 79, Ascii.FS, 69, 75, 76, Ascii.EM}, "fa4919");
    public static final String f = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.RS, Ascii.CAN, Ascii.DC4, 73, 79, 74, 68, 77, 73, 26, 69, Ascii.RS, Ascii.RS, Ascii.CAN, Ascii.DC4, 73, 79, 74, 68, 77, 73, 26, 69, Ascii.RS, Ascii.RS, Ascii.CAN, Ascii.DC4, 73, 79, 74, 68, 77, 73, 26, 69, Ascii.RS, Ascii.RS, Ascii.CAN, Ascii.DC4, 73, 79, 74, 68, 77, 73, 26, 69, Ascii.RS, Ascii.RS, Ascii.CAN, Ascii.DC4, 73, 79, 74, 68, 77, 73, 26, 69, Ascii.RS, Ascii.RS, Ascii.CAN}, "5534bd");
    public static final String g = ijiami_1011.s.s.s.d(new byte[]{74, 26, Ascii.CAN, 74, 75, 126, 44, 73, 2, 6, Ascii.SYN, 49, Ascii.DC4, 43, 41, 9, 11, 94, 91, Ascii.ETB, Ascii.NAK, 76, 98, 54, 96, 57}, "3ca3f3");
    public static final String h = ijiami_1011.s.s.s.d(new byte[]{88, 0, 65, 3}, "2a7b34");
    public static final String i = ijiami_1011.s.s.s.d(new byte[]{67, 12, 90, 91, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, 14, 10, 3}, "7c79f4");
    public static final String j = ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 83, 4, 68, 84, Ascii.ETB, Ascii.EM, 7, Ascii.DC4, 3, 66, 13}, "29e259");
    private static final String[] m = {ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 80, 3, Ascii.ETB, 2, Ascii.FS, 13, 11, 5, 3, 93, 74, 74, 65}, "94bcc3"), ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 84, 4, 71, 80, 76, 13, 11, 5, 3, 93, 74, 86, 89, 11, Ascii.FS, 66, Ascii.SYN}, "40e31c"), ijiami_1011.s.s.s.d(new byte[]{78, 83, 0, SignedBytes.MAX_POWER_OF_TWO, 0, Ascii.US, 13, 11, 5, 3, 93, 74, Ascii.EM, 85, 8, 90, 78, 67, Ascii.DC4}, "a7a4a0"), ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 16, 72, 16, 71, 4, 12, 75, Ascii.RS, 0, 88, 11, Ascii.US, 16, 68}, "0c1c3a"), ijiami_1011.s.s.s.d(new byte[]{26, 16, 76, 16, 77, 86, 12, 75, 4, 11, 95, 74, 70, Ascii.SYN}, "5c5c93"), ijiami_1011.s.s.s.d(new byte[]{26, Ascii.ETB, 74, 70, Ascii.SYN, 86, 12, 75, 4, 11, 95, 74, Ascii.ESC, 1, 75, 65, 77, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4}, "5d35b3"), ijiami_1011.s.s.s.d(new byte[]{76, Ascii.NAK, Ascii.CAN, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, 87, 12, 75, 4, 11, 95, 74, 5, 7, 8, 10, 71, 83, 7, 1, 73, 17, 68}, "cfaf42"), ijiami_1011.s.s.s.d(new byte[]{76, 17, 73, 71, 70, 0, 12, 75, Ascii.NAK, 6, Ascii.RS, Ascii.GS, 1, 11, 94, Ascii.ESC, 65, 16}, "cb042e"), ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 66, 79, 65, 71, 86, 12, 75, 19, 17, 67, 74, 69, 84, Ascii.ESC, 92, 86, 86, 5, 73, Ascii.DC4, 13, 94, 17, Ascii.GS, 66, 67}, "216233"), ijiami_1011.s.s.s.d(new byte[]{26, 16, 3, 93, 11, Ascii.ETB, Ascii.DC2, 17}, "5ca4e8"), ijiami_1011.s.s.s.d(new byte[]{77, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 77, 83, 95, 15, 75, Ascii.NAK, Ascii.ETB}, "bd5b16")};

    private b() {
    }

    public static long a(String str) {
        try {
            return new SimpleDateFormat(g, Locale.US).parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String a(int i2, int i3, int i4) throws Throwable {
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append(ijiami_1011.s.s.s.d(new byte[]{88, 88, 5, 82, 82, 67, 91, 110}, "47b137"));
        if (i2 > 0) {
            a(iMyPid, sb, ijiami_1011.s.s.s.d(new byte[]{8, 89, 94, 95}, "e871d7"), i2, 'D');
        }
        if (i3 > 0) {
            a(iMyPid, sb, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, Ascii.CAN, 70, Ascii.SYN, 81, 85}, "ea5b48"), i3, 'W');
        }
        if (i4 > 0) {
            a(iMyPid, sb, ijiami_1011.s.s.s.d(new byte[]{4, 66, 92, 95, 70, Ascii.SYN}, "a4912e"), i3, 'I');
        }
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        return sb.toString();
    }

    public static String a(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? ijiami_1011.s.s.s.d(new byte[]{70, 92, 14, 94, 14, 78, 15}, "32e0a9") : str;
    }

    public static String a(Context context, int i2) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 72, 74, 91, 84, 26}, "488475") + i2 + ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 5, 14, 93, 14, 94, 15, 1}, "3fc9b7")));
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    String strTrim = line.trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                        return strTrim;
                    }
                }
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused5) {
        }
        return null;
    }

    private static String a(String str, int i2) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                int i3 = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String strTrim = line.trim();
                        if (strTrim.length() > 0) {
                            i3++;
                            if (i2 == 0 || i3 <= i2) {
                                sb.append("  ").append(strTrim).append(IOUtils.LINE_SEPARATOR_UNIX);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        p.c(c, ijiami_1011.s.s.s.d(new byte[]{118, Ascii.DC4, 83, Ascii.SYN, 88, 99, Ascii.NAK, 13, 10, 66, 86, 0, 65, 47, 92, 3, 95, Ascii.RS}, "5f2e06") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.DC4, 94, 84, 88, 15, 4, 0}, "74851c"), e);
                        if (bufferedReader2 != null) {
                            bufferedReader = bufferedReader2;
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
                if (i2 > 0 && i3 > i2) {
                    sb.append(ijiami_1011.s.s.s.d(new byte[]{17, Ascii.DC4, Ascii.ETB, Ascii.GS, Ascii.CAN, 76, 79, 74, 108}, "14936b")).append(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 69, 76, 88, 66, 89, 3, 1, Ascii.DC4, 66, 94, 3, Ascii.DC4, Ascii.ETB, 1, 85, 88, 70, 5, Ascii.ETB, 92, 66}, "4ed674")).append(i3).append(ijiami_1011.s.s.s.d(new byte[]{74, 59}, "c1dbf6"));
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(Date date, Date date2, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(g, Locale.US);
        return ijiami_1011.s.s.s.d(new byte[]{19, Ascii.GS, 26, 69, Ascii.RS, 75, 75, 68, 76, 72, Ascii.ESC, 69, 19, Ascii.GS, 26, 69, Ascii.RS, 75, 75, 68, 76, 72, Ascii.ESC, 69, 19, Ascii.GS, 26, 69, Ascii.RS, 75, 75, 68, 76, 72, Ascii.ESC, 69, 19, Ascii.GS, 26, 69, Ascii.RS, 75, 75, 68, 76, 72, Ascii.ESC, 69, 19, Ascii.GS, 26, 69, Ascii.RS, 75, 75, 68, 76, 72, Ascii.ESC, 69, 19, Ascii.GS, 26, 111, 96, 14, 12, 6, Ascii.NAK, Ascii.SYN, 94, 11, 92, Ascii.ETB, 93, 4, 95, 4, 19, 94, 70, 69, 126, 11, 92, 99, 66, 4, 87, 10, 65, 86, 72, 83, Ascii.US, 87, Ascii.RS, Base64.padSymbol, 115, Ascii.ETB, 85, Ascii.DC2, 9, 68, Ascii.DC2, Ascii.ESC, 65, 0, 3, Ascii.ETB, Ascii.ETB}, "970e4a") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 104, 49, Ascii.ETB, 3, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 68, Ascii.DC2, 11, 92, 0, 2, 66, 69}, "8bbcb2") + simpleDateFormat.format(date) + ijiami_1011.s.s.s.d(new byte[]{67, 57, 119, 71, 81, 16, 9, 68, Ascii.DC2, 11, 92, 0, 94, 19, 19}, "d3450c") + simpleDateFormat.format(date2) + ijiami_1011.s.s.s.d(new byte[]{19, 110, 35, 72, Ascii.NAK, Ascii.SYN, 40, 32, 92, 66, Ascii.SYN}, "4db8e6") + str2 + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 60, 112, 65, 71, 68, Ascii.ETB, 1, Ascii.DC4, 17, 88, 10, 87, 12, 17, Ascii.SYN}, "96117d") + str3 + ijiami_1011.s.s.s.d(new byte[]{65, Base64.padSymbol, 98, 86, 10, Ascii.ETB, 4, 0, 92, 66, Ascii.SYN}, "f709ec") + (a() ? ijiami_1011.s.s.s.d(new byte[]{110, 85, 17}, "70b0b8") : ijiami_1011.s.s.s.d(new byte[]{118, 87}, "88c4d0")) + ijiami_1011.s.s.s.d(new byte[]{70, Base64.padSymbol, 34, 49, 123, Ascii.ETB, 13, 1, 16, 7, 93, 95, 65, 16}, "a7ca27") + Build.VERSION.SDK_INT + ijiami_1011.s.s.s.d(new byte[]{67, 108, 127, 54, Ascii.ETB, 79, 4, Ascii.SYN, Ascii.NAK, 11, 94, 11, 94, 70, Ascii.ETB}, "df0e79") + Build.VERSION.RELEASE + ijiami_1011.s.s.s.d(new byte[]{70, Utf8.REPLACEMENT_BYTE, 117, 113, 123, 68, 13, 13, Ascii.NAK, Ascii.SYN, 11, 69, 70}, "a5432d") + b() + ijiami_1011.s.s.s.d(new byte[]{16, 107, 46, 86, 86, 19, 7, 5, 5, Ascii.SYN, 68, Ascii.ETB, 82, 19, 89, Ascii.ETB, Ascii.US}, "7ac78f") + Build.MANUFACTURER + ijiami_1011.s.s.s.d(new byte[]{17, 50, 38, 74, 81, 87, 5, 94, 70, 69}, "68d809") + Build.BRAND + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 111, 117, 91, 80, 82, 13, 94, 70, 69}, "9e8447") + Build.MODEL + ijiami_1011.s.s.s.d(new byte[]{70, 59, 122, 66, 15, 10, 5, 68, 0, 11, 95, 2, 4, 67, 72, 69, 15, 8, Ascii.NAK, 94, 70, 69}, "a187ff") + Build.FINGERPRINT + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 108}, "3ffa29");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static void a(int i2, StringBuilder sb, String str, int i3, char c2) throws Throwable {
        BufferedReader bufferedReader;
        Object obj;
        String string = Integer.toString(i2);
        String str2 = PPSLabelView.Code + string + PPSLabelView.Code;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{78, Ascii.ETB, Ascii.ESC, 66, 77, 87, 12, 75, 4, 11, 95, 74, 13, 11, 5, 82, 88, 70}, "adb192"));
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 3}, "2a0aee"));
        arrayList.add(str);
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{73, 81}, "d54317"));
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 16}, "2f5ba5"));
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{65, 92, Ascii.SYN, 82, 81, 0, Ascii.NAK, 13, 11, 7}, "54d70d"));
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{78, 17}, "ce4374"));
        arrayList.add(Integer.toString(i3));
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 78, Ascii.NAK, 94, 87}, "1ce73c"));
        arrayList.add(string);
        arrayList.add(ijiami_1011.s.s.s.d(new byte[]{79, 92}, "efb727") + c2);
        Object[] array = arrayList.toArray();
        sb.append(ijiami_1011.s.s.s.d(new byte[]{78, Ascii.US, Ascii.NAK, 79, 26, Ascii.ESC, 76, 73, 75, 66, 69, 4, 10, 94, Ascii.CAN, 7, 89, 82, 65, 11, 0, 66, 93, 10, 4, Ascii.DC2}, "c28b76")).append(str);
        sb.append(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 75}, "2c7770")).append(TextUtils.join(PPSLabelView.Code, array)).append(ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 111}, "4e3bfe"));
        ?? r5 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader3.readLine();
                        obj = line;
                        bufferedReader = bufferedReader3;
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        p.b(c, ijiami_1011.s.s.s.d(new byte[]{118, 17, 80, 17, 14, 99, Ascii.NAK, 13, 10, 66, 67, 16, 91, 67, 93, 13, 1, 85, 0, 16, 70, 1, 94, 8, 88, 2, 95, 6, 70, 80, 0, 13, 10, 7, 85}, "5c1bf6"), e);
                        r5 = bufferedReader2;
                        if (bufferedReader2 != null) {
                            bufferedReader = bufferedReader2;
                            obj = bufferedReader2;
                            try {
                                bufferedReader.close();
                                r5 = obj;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        r5 = bufferedReader3;
                        if (r5 != 0) {
                            try {
                                r5.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        bufferedReader.close();
        r5 = obj;
    }

    public static boolean a() {
        try {
            for (String str : m) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String b() {
        return TextUtils.join(ijiami_1011.s.s.s.d(new byte[]{78}, "b156b4"), Build.SUPPORTED_ABIS);
    }

    private static String b(String str) {
        return a(str, 0);
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 102, 66, 92, 0, 81, Ascii.DC2, Ascii.ETB, 70, 49, 68, 8, 90, 87, 66, 74, 67, Ascii.FS, 39, Ascii.SYN, 9, 15, 11, 69, 86, 88, 84, 65, 12, 93, 5, 74, 9, 17, Ascii.US, 33, 82, 84, 69, 84, 77, 121, 4, 9, 9, 16, 72, 44, 89, 80, 95, 26, 105}, "7603c4"));
        Locale locale = Locale.US;
        Object[] objArr = {"", ijiami_1011.s.s.s.d(new byte[]{99, 75, SignedBytes.MAX_POWER_OF_TWO, 77, 125, 33, 72}, "383e6c")};
        String str = k;
        sb.append(String.format(locale, str, objArr));
        sb.append(String.format(locale, str, "", ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, Ascii.DC4, 26, 76, 73, Ascii.EM}, "897ad4")));
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{127, 4, Ascii.ETB, 3, Ascii.CAN, 121, 4, 5, Ascii.SYN, 88}, "5eab81"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, Ascii.ETB, 14, 90, 5, 70, Ascii.CAN, 74, 12, 3, 71, 4, 75, 10, 6, 86, Ascii.DC4}, "fbc7d4"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{120, 83, 77, 88, 67, 1, 65, 44, 3, 3, 65, 95}, "62915d"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 14, 94, 89, 67, Ascii.CAN, 74, 8, 3, 69, 12, Ascii.ETB, 80, 78, 91, 93, 80, 17}, "a5c381"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{118, 11, 83, 81, 3}, "5d7493"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{67, Ascii.SYN, 90, 84, 83, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 74, 5, 13, 85, 0}, "0c7922"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{96, 66, 86, 86, 8, 9}, "3675c3"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{71, 65, 14, 15, 86, 65, Ascii.CAN, 74, Ascii.NAK, Ascii.SYN, 80, 6, 95}, "44cb73"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{35, Ascii.ETB, 7, 69, 88, 90, 2, Ascii.ETB, 92}, "def503"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{71, 19, 84, 95, 85, 69, Ascii.CAN, 74, 1, 16, 80, Ascii.NAK, 92, 15, 90, 65}, "4f9247"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{98, 68, 10, 78, 88, 68, 4, 68, 41, Ascii.SYN, 89, 0, SignedBytes.MAX_POWER_OF_TWO, 12}, "26c890"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{75, 70, 8, 90, 81, 71, Ascii.CAN, 74, Ascii.SYN, 16, 88, 19, 89, 71, 0, 26, 95, 65, 9, 1, Ascii.DC4}, "83e705"))));
            sb.append(String.format(locale, str, ijiami_1011.s.s.s.d(new byte[]{106, Ascii.FS, 67, 71, 93, 89, 91}, "9e0384"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 94, 85, 7, 70, Ascii.CAN, 74, Ascii.NAK, Ascii.ESC, 66, 17, 86, 15}, "3b38f4"))));
            sb.append(String.format(locale, l, ijiami_1011.s.s.s.d(new byte[]{100, 44, 97, 35, 45, 92}, "0c5baf"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{71, 17, 14, 9, 86, 69, Ascii.CAN, 74, Ascii.DC2, 13, 69, 4, 88, 73, 19, Ascii.ETB, 68}, "4dcd77")), ijiami_1011.s.s.s.d(new byte[]{99, 125, 48, 116, 42, 67, 50, 51, 39, 50, 11}, "72d5fc"), memoryInfo.getMemoryStat(ijiami_1011.s.s.s.d(new byte[]{74, 68, 94, 90, 89, Ascii.SYN, Ascii.CAN, 74, Ascii.DC2, 13, 69, 4, 85, Ascii.FS, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 89, Ascii.DC4}, "91378d"))));
        } catch (Exception e2) {
            p.b(c, ijiami_1011.s.s.s.d(new byte[]{38, 65, 2, 69, 10, 96, Ascii.NAK, 13, 10, 66, 86, 0, 17, 99, 17, 89, 1, 80, Ascii.DC2, Ascii.ETB, 43, 7, 92, 10, Ascii.ETB, 74, 42, 88, 4, 90, 65, 2, 7, 11, 93, 0, 1}, "e3c6b5"), e2);
        }
        return sb.toString();
    }

    public static String d() {
        return ijiami_1011.s.s.s.d(new byte[]{84, 87, 84, 12, 17, 78, 65, 13, 8, 4, 94, 95, 51, Ascii.DC2, 106, 26, 16, 67, 4, 9, 70, 49, 68, 8, 84, 83, 75, 26, 67, Ascii.US, 39, Ascii.SYN, 9, 15, 11, 69, Ascii.SYN, 66, 75, 12, 0, Ascii.CAN, 12, 1, 11, 11, 95, 3, 86, Ascii.ESC, 51}, "929cc7") + b(ijiami_1011.s.s.s.d(new byte[]{78, 67, 67, 14, 5, 73, 12, 1, 11, 11, 95, 3, 14}, "a31aff")) + ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 56, 69, 99, 70, 91, 2, 1, Ascii.NAK, 17, 17, 54, 76, 83, 17, 70, 71, Ascii.DC4, 73, 34, Ascii.DC4, 13, 92, 95, Ascii.CAN, Ascii.GS, Ascii.NAK, 65, 91, 87, 78, 52, 47, 38, Ascii.RS, Ascii.SYN, 76, 83, 17, 70, 71, Ascii.GS, 107}, "82e344") + b(ijiami_1011.s.s.s.d(new byte[]{74, 17, 74, 92, 80, Ascii.EM, Ascii.DC2, 1, 10, 4, Ascii.RS, Ascii.SYN, 17, 0, 76, 70, SignedBytes.MAX_POWER_OF_TWO}, "ea8336")) + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 57, 70, 50, 67, 89, 2, 1, Ascii.NAK, 17, 17, 41, 89, 94, 15, Ascii.SYN, 66, Ascii.SYN, 73, 34, Ascii.DC4, 13, 92, 95, 16, Ascii.FS, Ascii.SYN, 16, 94, 85, 78, 52, 47, 38, Ascii.RS, 9, 89, 94, 15, Ascii.SYN, 66, Ascii.US, 107}, "03fb16") + b(ijiami_1011.s.s.s.d(new byte[]{26, 17, 67, 89, 2, Ascii.EM, Ascii.DC2, 1, 10, 4, Ascii.RS, 9, 92, 12, 88, 66, Ascii.DC2}, "5a16a6")) + ijiami_1011.s.s.s.d(new byte[]{79, 56}, "b20b80") + c() + IOUtils.LINE_SEPARATOR_UNIX;
    }

    public static String e() {
        return Build.VERSION.SDK_INT >= 29 ? ijiami_1011.s.s.s.d(new byte[]{91, 82, 67, 70, 13, Ascii.DC4, 10, 68, 15, 12, 87, 10, 15, Base64.padSymbol, 121, 94, Ascii.SYN, 70, Ascii.DC2, 17, Ascii.SYN, Ascii.DC2, 94, Ascii.ETB, 65, 82, 83, 17, 13, 8, 65, 37, 8, 6, 67, 10, 92, 83, Ascii.ETB, 96, 66, 78, 32, 52, 47, 66, 93, 0, 67, 82, 91, 17, 80, 95, 72, 68, 7, 12, 85, 69, 89, 86, 67, 84, 16, 72, 107, 110}, "5771bf") : ijiami_1011.s.s.s.d(new byte[]{13, 93, 65, Ascii.NAK, 94, Ascii.ETB, 10, 68, 15, 12, 87, 10, 89, 50, Ascii.NAK, 54, 114, 53, 65, 11, 16, 7, 67, 69, 42, 104, 67, 86, 17, 77, 39, Ascii.SYN, 9, 15, 11, 69, 76, 72, 71, 13, 82, 74, 49, 45, 34, 77, 95, 0, Ascii.ETB, Ascii.ETB, 65, 1, 65, 76, 107}, "c85b1e") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 72, SignedBytes.MAX_POWER_OF_TWO, 92, 91, Ascii.GS, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 82, 76, Ascii.GS, 71, 91, 66}, "782382"), 1024) + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 51, 16, 53, 119, 99, 65, 11, 16, 7, 67, 69, 125, 105, 70, 87, Ascii.DC4, Ascii.ESC, 39, Ascii.SYN, 9, 15, 11, 69, Ascii.ESC, 73, 66, 14, 87, Ascii.FS, 49, 45, 34, 77, 95, 0, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 68, 2, 68, 5, 72, 110}, "490a43") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 68, 68, 13, 2, 26, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 93, SignedBytes.MAX_POWER_OF_TWO, Ascii.EM, Ascii.SYN, 2, 69, 87}, "846ba5"), 1024) + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 107, 17, 49, 118, 99, 65, 11, 16, 7, 67, 69, 124, 49, 71, 80, Ascii.DC2, Ascii.ESC, 39, Ascii.SYN, 9, 15, 11, 69, 26, 17, 67, 11, 81, Ascii.FS, 49, 45, 34, 77, 95, 0, 65, 78, 68, 0, 66, 26, 107}, "5a1d23") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 70, 16, 91, 1, Ascii.CAN, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 86, 66, 77, 65, 6, 71}, "36b4b7"), 1024) + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 62, Ascii.DC4, 55, 34, 101, 65, 11, 16, 7, 67, 69, 123, 100, 66, 84, 70, Ascii.GS, 39, Ascii.SYN, 9, 15, 11, 69, Ascii.GS, 68, 70, 13, 5, 26, 49, 45, 34, 77, 95, 0, 70, Ascii.ESC, 65, 6, Ascii.SYN, 3, 72, 110}, "244bf5") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 19, Ascii.SYN, 88, 7, 75, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 85, Ascii.ETB, 75, 66, 0, Ascii.DC4, 87}, "0cd7dd"), 1024) + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 51, Ascii.DC2, 120, 32, 117, 49, 68, 15, 12, 17, 44, 98, 79, 6, 17, 75, 126, 19, 11, 11, 88, 17, 74, 66, 75, 93, 82, 76, 104, 40, 32, 73, 12, 84, 17, Ascii.GS, 80, 81, 92, 19, 17, 107}, "2921c8") + a(ijiami_1011.s.s.s.d(new byte[]{76, Ascii.DC2, 71, 9, 85, Ascii.US, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 6, Ascii.SYN, 26, 15, 85, 93, 17}, "cb5f60"), 256) + ijiami_1011.s.s.s.d(new byte[]{79, 105, 67, 44, 113, 47, 49, 68, 15, 12, 17, 44, 50, Ascii.NAK, 85, 69, 26, 36, 19, 11, 11, 88, 17, 74, Ascii.DC2, 17, 12, 6, Ascii.GS, 50, 40, 32, 73, 12, 84, 17, 77, 10, 0, 8, 66, 84, 72, 110}, "bcce2b") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 19, 71, 92, 0, Ascii.US, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 82, Ascii.ETB, 26, 90, 0, 93, 17, 82}, "7c53c0"), 256) + ijiami_1011.s.s.s.d(new byte[]{76, 111, 67, 98, 124, 44, 57, 68, 2, 13, 92, 4, 8, 11, 67, Ascii.US, 116, Ascii.ETB, 14, 9, 92, 66, Ascii.RS, Ascii.NAK, 19, 10, 0, Ascii.CAN, 98, 44, 37, 75, 8, 7, 69, 74, Ascii.DC4, 11, 10, 79, Ascii.ESC, 111}, "aec72e") + a(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 17, Ascii.SYN, 91, 82, Ascii.ETB, Ascii.DC2, 1, 10, 4, Ascii.RS, 11, 86, Ascii.NAK, 75, 65, 95, 81, Ascii.EM}, "3ad418"), 256) + IOUtils.LINE_SEPARATOR_UNIX;
    }

    public static String f() {
        String str;
        StringBuilder sb = new StringBuilder(ijiami_1011.s.s.s.d(new byte[]{9, 66, 0, 8, Ascii.SYN, 80, 8, 8, 3, 17, 11, 111}, "f2ef66"));
        try {
            File[] fileArrListFiles = new File(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.DC2, Ascii.ETB, 94, 85, Ascii.RS, Ascii.DC2, 1, 10, 4, Ascii.RS, 3, 82}, "6be161")).listFiles(new c());
            if (fileArrListFiles != null) {
                int i2 = 0;
                for (File file : fileArrListFiles) {
                    try {
                        str = Os.readlink(file.getAbsolutePath());
                    } catch (Exception unused) {
                        str = null;
                    }
                    sb.append(ijiami_1011.s.s.s.d(new byte[]{19, Ascii.ETB, Ascii.NAK, Ascii.SYN, 80, 80, 65}, "375664")).append(file.getName()).append(ijiami_1011.s.s.s.d(new byte[]{91, 69}, "aef312")).append(TextUtils.isEmpty(str) ? ijiami_1011.s.s.s.d(new byte[]{14, 7, 6}, "18948e") : str.trim()).append('\n');
                    i2++;
                    if (i2 > 1024) {
                        break;
                    }
                }
                if (fileArrListFiles.length > 1024) {
                    sb.append(ijiami_1011.s.s.s.d(new byte[]{19, Ascii.DC4, 67, Ascii.SYN, 72, Ascii.EM, 79, 74, 72, 76, 59}, "34c6f7"));
                }
                sb.append(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, Ascii.ETB, Ascii.SYN, Ascii.CAN, 16, 89, Ascii.DC4, 9, 4, 7, 67, 69, 88, 81, Ascii.SYN, 126, 124, 68, 91, 68}, "776887")).append(fileArrListFiles.length).append(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 51}, "1954b1"));
            }
        } catch (Exception unused2) {
        }
        sb.append('\n');
        return sb.toString();
    }
}
