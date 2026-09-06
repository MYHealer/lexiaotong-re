package com.yfanads.android.utils;

import android.text.TextUtils;
import com.kuaishou.weapon.p0.bg;
import com.yfanads.android.core.f;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFTimeUtils {
    private static final String TAG = "YFTimeUtils";

    private YFTimeUtils() {
    }

    public static boolean isEquals(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            long j = Long.parseLong(str);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(j);
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.setTimeInMillis(System.currentTimeMillis());
            return gregorianCalendar.get(i) == gregorianCalendar2.get(i);
        } catch (Exception e) {
            f.a(e, new StringBuilder("YFTimeUtils isEqualsDay = "));
            return false;
        }
    }

    public static boolean isEqualsHour(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(str) <= bg.s;
        } catch (Exception e) {
            f.a(e, new StringBuilder("YFTimeUtils isEqualsDay = "));
            return false;
        }
    }
}
