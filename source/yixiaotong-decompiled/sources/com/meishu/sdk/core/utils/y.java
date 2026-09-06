package com.meishu.sdk.core.utils;

import java.io.IOException;

/* JADX INFO: compiled from: HttpGetJsonCallback.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface y<response> {
    void a(response response) throws IOException;

    void onFailure(IOException iOException);
}
