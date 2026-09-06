package com.meishu.sdk.core.utils;

import android.graphics.Bitmap;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.IOException;

/* JADX INFO: compiled from: HttpGetBitmapCallback.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface w {
    void a(HttpResponse<byte[]> httpResponse, Bitmap bitmap, Bitmap bitmap2) throws IOException;

    void onFailure(IOException iOException);
}
