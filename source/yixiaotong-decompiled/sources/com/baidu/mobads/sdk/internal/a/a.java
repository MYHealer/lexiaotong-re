package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface a extends IOAdEvent {
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
