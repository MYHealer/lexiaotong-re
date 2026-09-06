package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h {
    private final ArrayList<com.kwad.framework.filedownloader.a.InterfaceC0712a> azI;

    static final class a {
        private static final h azJ = new h(0);
    }

    /* synthetic */ h(byte b) {
        this();
    }

    public static h Bn() {
        return a.azJ;
    }

    private h() {
        this.azI = new ArrayList<>();
    }

    final int size() {
        return this.azI.size();
    }

    final int cr(int i) {
        int i2;
        synchronized (this.azI) {
            Iterator<com.kwad.framework.filedownloader.a.InterfaceC0712a> it = this.azI.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().cq(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    final List<com.kwad.framework.filedownloader.a.InterfaceC0712a> cs(int i) {
        byte bAH;
        ArrayList arrayList = new ArrayList();
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a : this.azI) {
                if (interfaceC0712a.cq(i) && !interfaceC0712a.isOver() && (bAH = interfaceC0712a.AP().AH()) != 0 && bAH != 10) {
                    arrayList.add(interfaceC0712a);
                }
            }
        }
        return arrayList;
    }

    final List<com.kwad.framework.filedownloader.a.InterfaceC0712a> ct(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a : this.azI) {
                if (interfaceC0712a.cq(i) && !interfaceC0712a.isOver()) {
                    arrayList.add(interfaceC0712a);
                }
            }
        }
        return arrayList;
    }

    final boolean a(com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a) {
        return this.azI.isEmpty() || !this.azI.contains(interfaceC0712a);
    }

    final void v(List<com.kwad.framework.filedownloader.a.InterfaceC0712a> list) {
        synchronized (this.azI) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a : this.azI) {
                if (!list.contains(interfaceC0712a)) {
                    list.add(interfaceC0712a);
                }
            }
            this.azI.clear();
        }
    }

    public final boolean a(com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bAH = messageSnapshot.AH();
        synchronized (this.azI) {
            zRemove = this.azI.remove(interfaceC0712a);
        }
        if (com.kwad.framework.filedownloader.f.d.aDr && this.azI.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0712a, Byte.valueOf(bAH), Integer.valueOf(this.azI.size()));
        }
        if (zRemove) {
            t tVarBf = interfaceC0712a.AQ().Bf();
            if (bAH == -4) {
                tVarBf.l(messageSnapshot);
            } else if (bAH == -3) {
                tVarBf.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bAH == -2) {
                tVarBf.n(messageSnapshot);
            } else if (bAH == -1) {
                tVarBf.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0712a, Byte.valueOf(bAH));
        }
        return zRemove;
    }

    final void b(com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a) {
        if (!interfaceC0712a.AP().Ay()) {
            interfaceC0712a.AS();
        }
        if (interfaceC0712a.AQ().Bf().Bs()) {
            c(interfaceC0712a);
        }
    }

    final void c(com.kwad.framework.filedownloader.a.InterfaceC0712a interfaceC0712a) {
        if (interfaceC0712a.AT()) {
            return;
        }
        synchronized (this.azI) {
            if (this.azI.contains(interfaceC0712a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0712a);
            } else {
                interfaceC0712a.AU();
                this.azI.add(interfaceC0712a);
                if (com.kwad.framework.filedownloader.f.d.aDr) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0712a, Byte.valueOf(interfaceC0712a.AP().AH()), Integer.valueOf(this.azI.size()));
                }
            }
        }
    }
}
