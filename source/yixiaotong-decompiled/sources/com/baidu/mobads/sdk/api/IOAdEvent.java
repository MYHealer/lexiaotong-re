package com.baidu.mobads.sdk.api;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
