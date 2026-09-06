package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineHostActionHandler {
    void dismissDialog(IOfflineTKDialog iOfflineTKDialog);

    void showDialog(IOfflineTKDialog iOfflineTKDialog);

    void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent);
}
