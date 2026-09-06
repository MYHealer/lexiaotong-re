package com.byazt.fk;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface da {

    public interface c {
        void cancel(u uVar, int i);

        void onVideoPreloadFail(u uVar, int i, String str);

        void onVideoPreloadSuccess(u uVar, int i);
    }

    void execVideoPreload(Context context, u uVar, c cVar);
}
