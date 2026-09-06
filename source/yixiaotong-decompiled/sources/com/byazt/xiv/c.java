package com.byazt.xiv;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface c {
    Set<String> getAdnKeySet();

    Map<String, Map<String, Object>> getAdnStatusMap();

    boolean getAndUpdateInitStatus(String str);

    ve getDexPluginStrategy(String str);
}
