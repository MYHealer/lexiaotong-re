package com.byazt.su;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface DownloadEventConfig {
    String getClickButtonTag();

    String getClickContinueLabel();

    String getClickInstallLabel();

    String getClickItemTag();

    String getClickLabel();

    String getClickPauseLabel();

    String getClickStartLabel();

    int getDownloadScene();

    Object getExtraEventObject();

    JSONObject getExtraJson();

    JSONObject getParamsJson();

    String getRefer();

    String getStorageDenyLabel();

    boolean isEnableClickEvent();

    boolean isEnableV3Event();

    void setDownloadScene(int i);

    void setRefer(String str);
}
