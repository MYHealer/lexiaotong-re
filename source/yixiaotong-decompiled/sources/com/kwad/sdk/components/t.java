package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface t {
    o a(String str, Object... objArr);

    void a(k kVar);

    void a(r rVar);

    void a(String str, String str2, s sVar);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
