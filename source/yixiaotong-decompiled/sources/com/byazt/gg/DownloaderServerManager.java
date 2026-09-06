package com.byazt.gg;

import com.byazt.bog.a;
import com.byazt.nys.i;
import com.byazt.quv.AbsServerManager;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 2027, 2522})
public class DownloaderServerManager extends AbsServerManager {
    @Override // com.byazt.quv.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        try {
            i.c(getContext());
        } catch (Throwable th) {
            a.c(th);
        }
        return super.onCreate();
    }
}
