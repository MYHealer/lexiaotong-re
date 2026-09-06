package com.kwad.sdk.components;

import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface n {
    void a(q qVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}
