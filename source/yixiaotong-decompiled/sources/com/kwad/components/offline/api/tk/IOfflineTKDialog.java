package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    boolean isHideNavigationBar();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
