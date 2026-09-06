package com.opos.process.bridge.provider;

import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class StringUtil {
    public static <E> String arrayToString(E[] eArr) {
        return arrayToString(eArr, ",");
    }

    public static <E> String arrayToString(E[] eArr, String str) {
        if (eArr == null || eArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < eArr.length; i++) {
            sb.append(eArr[i].toString());
            if (i < eArr.length - 1) {
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static <E> String listToString(List<E> list) {
        return listToString(list, ",");
    }

    public static <E> String listToString(List<E> list, String str) {
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

    public static <K, V> String mapToString(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (K k : map.keySet()) {
            sb.append(k).append(x.bQ).append(map.get(k)).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(i.d);
        return sb.toString();
    }
}
