package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0712a> aAo = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.e
    public final void Bi() {
        w wVarBJ = r.BG().BJ();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aAo) {
            List<a.InterfaceC0712a> list = (List) this.aAo.clone();
            this.aAo.clear();
            ArrayList arrayList = new ArrayList(wVarBJ.BN());
            for (a.InterfaceC0712a interfaceC0712a : list) {
                int iAR = interfaceC0712a.AR();
                if (wVarBJ.cz(iAR)) {
                    interfaceC0712a.AP().Aw().AX();
                    if (!arrayList.contains(Integer.valueOf(iAR))) {
                        arrayList.add(Integer.valueOf(iAR));
                    }
                } else {
                    interfaceC0712a.AV();
                }
            }
            wVarBJ.w(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void Bj() {
        if (Bk() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w wVarBJ = r.BG().BJ();
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.Bn().size()));
            }
            if (h.Bn().size() > 0) {
                synchronized (this.aAo) {
                    h.Bn().v(this.aAo);
                    Iterator<a.InterfaceC0712a> it = this.aAo.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    wVarBJ.BM();
                }
                r.BG().BH();
                return;
            }
            return;
        }
        if (h.Bn().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.Bn().size()));
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0712a interfaceC0712a) {
        return !this.aAo.isEmpty() && this.aAo.contains(interfaceC0712a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0712a interfaceC0712a) {
        if (this.aAo.isEmpty()) {
            return;
        }
        synchronized (this.aAo) {
            this.aAo.remove(interfaceC0712a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0712a interfaceC0712a) {
        r.BG();
        if (!r.BI()) {
            synchronized (this.aAo) {
                r.BG();
                if (!r.BI()) {
                    if (com.kwad.framework.filedownloader.f.d.aDr) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0712a.AP().getId()));
                    }
                    n.By().aW(com.kwad.framework.filedownloader.f.c.Dx());
                    if (!this.aAo.contains(interfaceC0712a)) {
                        interfaceC0712a.free();
                        this.aAo.add(interfaceC0712a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0712a);
        return false;
    }
}
