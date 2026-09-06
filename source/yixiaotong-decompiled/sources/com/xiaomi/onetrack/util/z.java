package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class z {
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{81, 14, 91, Ascii.EM, 78, 95, 0, 11, 11, 11, Ascii.US, 10, 92, 4, 66, 69, 87, 85, 10, 74, 19, Ascii.SYN, 88, 9, Ascii.FS, Ascii.ESC}, "2a6766");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9560a = ijiami_1011.s.s.s.d(new byte[]{108, Ascii.ESC}, "05ba42");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{26}, "624670");

    public static List<String> a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(str2);
            if (strArrSplit == null || strArrSplit.length <= 0) {
                return null;
            }
            return Arrays.asList(strArrSplit);
        } catch (Exception e) {
            p.b(c, ijiami_1011.s.s.s.d(new byte[]{54, 69, 17, 90, 13, 6, 53, 11, 42, 11, 66, 17, 69, 84, 17, 65, 12, 19, 91, 68}, "e1c3ca") + e.getMessage());
            return null;
        }
    }

    public static Set<String> a(String str, String str2, String str3) {
        HashSet hashSet = new HashSet();
        try {
            String[] strArrSplit = null;
            String[] strArrSplit2 = TextUtils.isEmpty(str) ? null : str.split(str3);
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit2));
            }
            if (!TextUtils.isEmpty(str2)) {
                strArrSplit = str2.split(str3);
            }
            if (strArrSplit != null && strArrSplit.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit));
            }
        } catch (Exception e) {
            p.b(c, ijiami_1011.s.s.s.d(new byte[]{15, 80, Ascii.SYN, 87, 4, 53, 0, Ascii.SYN, 7, 15, 66, 69, 7, 71, Ascii.SYN, 95, 19, 95, 65}, "b5d0ae") + e.getMessage());
        }
        return hashSet;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        return (str == null || str.length() == 0 || str.equals("") || str.equals(ijiami_1011.s.s.s.d(new byte[]{94, 67, 15, 13}, "06ca2e"))) ? false : true;
    }
}
