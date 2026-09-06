package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
interface IFileDownloadServiceHandler {
    IBinder onBind(Intent intent);

    void onDestroy();

    void onStartCommand(Intent intent, int i, int i2);
}
