package com.yfanads.android.utils.log;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface LogUploadResultListener {
    void onUploadFailure(File file);

    void onUploadSuccess(File file);
}
