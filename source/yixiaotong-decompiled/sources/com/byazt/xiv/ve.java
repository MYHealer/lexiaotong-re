package com.byazt.xiv;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ve {
    String getAdnName();

    String getAdnVersion();

    String getAdnVersionListKey();

    String getClassName();

    Function<SparseArray<Object>, Object> getInitBridge();

    Function<SparseArray<Object>, Object> getManager();

    String getUnSupportVersion();

    void saveManager(Function<SparseArray<Object>, Object> function);

    void saveUnSupportVersion(String str);
}
