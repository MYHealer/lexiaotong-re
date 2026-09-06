package com.meishu.sdk.core.download;

import com.meishu.sdk.core.safe.l;
import java.util.Iterator;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4784a;
    public final /* synthetic */ d b;

    public c(d dVar, b bVar) {
        this.b = dVar;
        this.f4784a = bVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        Iterator<h> it = this.b.e.values().iterator();
        while (it.hasNext()) {
            it.next().a(this.f4784a);
        }
    }
}
