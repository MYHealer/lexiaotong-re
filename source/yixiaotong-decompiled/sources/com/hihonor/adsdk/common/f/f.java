package com.hihonor.adsdk.common.f;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    public static boolean hnadsa(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int hnadsb(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <T> T hnadsa(List<? extends T> list) {
        if (hnadsa((Collection<?>) list)) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T hnadsb(List<? extends T> list) {
        int iHnadsb = hnadsb((Collection<?>) list);
        if (iHnadsb == 0) {
            return null;
        }
        return list.get(iHnadsb - 1);
    }

    public static <T> T hnadsa(List<? extends T> list, int i) {
        if (i >= 0 && i < hnadsb((Collection<?>) list)) {
            return list.get(i);
        }
        return null;
    }

    public static <T> boolean hnadsa(List<T> list, T t) {
        if (Objects.isNull(list)) {
            return false;
        }
        return list.add(t);
    }
}
