package com.byazt.uq;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 15})
public class uj {
    public static <T> boolean c(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean c(T[] tArr, T t) {
        return tt(tArr, t) != -1;
    }

    public static <T> int tt(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean c(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!c(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
