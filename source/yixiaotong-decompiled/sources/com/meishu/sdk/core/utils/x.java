package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.domain.HttpResponse;
import java.io.IOException;

/* JADX INFO: compiled from: HttpGetBytesCallback.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface x {
    void onFailure(IOException iOException);

    void onResponse(HttpResponse<byte[]> httpResponse) throws IOException;
}
