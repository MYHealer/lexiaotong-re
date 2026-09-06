package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.yfanads.android.adx.thirdpart.filedownload.services.FileDownloadBroadcastHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.AH() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent(FileDownloadBroadcastHandler.ACTION_COMPLETED);
        intent.putExtra("model", cVar);
        com.kwad.framework.filedownloader.f.c.Dx().sendBroadcast(intent);
    }
}
