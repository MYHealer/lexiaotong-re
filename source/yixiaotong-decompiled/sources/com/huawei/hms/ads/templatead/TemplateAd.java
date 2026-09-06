package com.huawei.hms.ads.templatead;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface TemplateAd {
    void destroy();

    String getContentId();

    Map<String, String> getExt();

    View getTemplateAdView();

    String getUniqueId();

    boolean isExpire();

    void render();
}
