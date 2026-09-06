package com.kwad.sdk.utils;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ar {
    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }

    public static boolean Z(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean R(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj != null && obj.equals(obj2);
    }
}
