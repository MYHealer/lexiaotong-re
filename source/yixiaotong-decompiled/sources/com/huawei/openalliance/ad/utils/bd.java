package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class bd {
    private static final String Code = "SwUt";

    public static Integer Code(String str, int i) {
        return Code(str, i, 0);
    }

    public static Integer Code(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i2 < 0) {
            return null;
        }
        String[] strArrSplit = str.split(com.huawei.openalliance.ad.constant.x.A);
        if (strArrSplit.length < i2 + 1) {
            return null;
        }
        return V(strArrSplit[i2], i);
    }

    private static Integer V(String str, int i) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(i, i + 1)));
            } catch (RuntimeException e) {
                e = e;
                sb = new StringBuilder("getSwh ");
                fh.I(Code, sb.append(e.getClass().getSimpleName()).toString());
                return null;
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder("getSwh ");
                fh.I(Code, sb.append(e.getClass().getSimpleName()).toString());
                return null;
            }
        }
        return null;
    }
}
