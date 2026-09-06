package com.heytap.msp.ipc.a;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k {
    public static <E> String a(List<E> list) {
        return a(list, ",");
    }

    public static <E> String a(List<E> list, String str) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) != null ? list.get(i).toString() : "");
            if (i < list.size() - 1) {
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
