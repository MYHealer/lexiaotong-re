package com.adprof.sdk;

import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t2 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        q0 q0Var = (q0) obj;
        q0 q0Var2 = (q0) obj2;
        if (q0Var != null || q0Var2 != null) {
            if (q0Var != null) {
                if (q0Var2 != null) {
                    int iCompare = Integer.compare(q0Var2.f1373a, q0Var.f1373a);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    String str = q0Var.f644a;
                    String str2 = q0Var2.f644a;
                    if (str != null || str2 != null) {
                        if (str != null) {
                            if (str2 != null) {
                                return str.compareTo(str2);
                            }
                        }
                    }
                }
                return -1;
            }
            return 1;
        }
        return 0;
    }
}
