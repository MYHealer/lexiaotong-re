package com.adprof.sdk;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class i9 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file != null || file2 != null) {
            if (file != null) {
                if (file2 != null) {
                    int iCompare = Long.compare(file.lastModified(), file2.lastModified());
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    String name = file.getName();
                    String name2 = file2.getName();
                    if (name != null || name2 != null) {
                        if (name != null) {
                            if (name2 != null) {
                                return name.compareTo(name2);
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
