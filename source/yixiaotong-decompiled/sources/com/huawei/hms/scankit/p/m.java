package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BarcodeValue.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f4305a = new HashMap();

    m() {
    }

    void a(int i) {
        Integer num = this.f4305a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f4305a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f4305a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return t4.a(arrayList);
    }
}
