package com.huawei.hms.ads.templatead;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface TemplateAdListener {
    void onAdLoaded(Map<String, List<TemplateAd>> map);

    void onError(int i);
}
