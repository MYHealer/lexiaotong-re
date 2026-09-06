package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class ab implements w {
    private final SparseArray<Handler> aAp = new SparseArray<>();

    ab() {
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void BM() {
        for (int i = 0; i < this.aAp.size(); i++) {
            b(this.aAp.get(this.aAp.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void w(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            c(this.aAp.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int BN() {
        return this.aAp.size();
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean cz(int i) {
        return this.aAp.get(i) != null;
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void c(Handler handler) {
        handler.sendEmptyMessage(3);
    }
}
