package client.android.yixiaotong.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ListUtils {
    public static final String DEFAULT_JOIN_SEPARATOR = ",";

    private ListUtils() {
        throw new AssertionError();
    }

    public static <V> int getSize(List<V> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static <V> boolean isEmpty(List<V> list) {
        return list == null || list.size() == 0;
    }

    public static String join(List<String> list) {
        return join(list, ",");
    }

    public static String join(List<String> list, char c) {
        return join(list, new String(new char[]{c}));
    }

    public static String join(List<String> list, String str) {
        return list == null ? "" : TextUtils.join(str, list);
    }

    public static <V> boolean addDistinctEntry(List<V> list, V v) {
        if (list == null || list.contains(v)) {
            return false;
        }
        return list.add(v);
    }

    public static <V> int addDistinctList(List<V> list, List<V> list2) {
        if (list == null || isEmpty(list2)) {
            return 0;
        }
        int size = list.size();
        for (V v : list2) {
            if (!list.contains(v)) {
                list.add(v);
            }
        }
        return list.size() - size;
    }

    public static <V> int distinctList(List<V> list) {
        int i = 0;
        if (isEmpty(list)) {
            return 0;
        }
        int size = list.size();
        int size2 = list.size();
        while (i < size2) {
            int i2 = i + 1;
            int i3 = i2;
            while (i3 < size2) {
                if (list.get(i).equals(list.get(i3))) {
                    list.remove(i3);
                    size2 = list.size();
                    i3--;
                }
                i3++;
            }
            i = i2;
        }
        return size - list.size();
    }

    public static <V> boolean addListNotNullValue(List<V> list, V v) {
        if (list == null || v == null) {
            return false;
        }
        return list.add(v);
    }

    public static <V> void addList(List<V> list, List<V> list2) {
        if (list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public static <V> void addListAndClear(List<V> list, List<V> list2) {
        if (list == null || list2 == null) {
            return;
        }
        list.clear();
        list.addAll(list2);
    }

    public static <V> List<V> invertList(List<V> list) {
        if (isEmpty(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        return arrayList;
    }

    public static <K> List<K> getFields(List<?> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            try {
                arrayList.add(obj.getClass().getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }
}
