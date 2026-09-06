package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;
import com.kwad.components.core.proxy.k;
import com.kwad.components.core.proxy.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements k {
    private List<k> aiT = new CopyOnWriteArrayList();
    private Map<com.kwad.components.core.proxy.a, List<c>> aiU = new HashMap();
    private com.kwad.components.core.proxy.a aiV;

    public final com.kwad.components.core.proxy.a vD() {
        return this.aiV;
    }

    private void a(k kVar) {
        this.aiT.add(kVar);
    }

    private void b(k kVar) {
        if (kVar != null) {
            this.aiT.remove(kVar);
        }
    }

    public final c a(DetectEventType detectEventType) {
        List<c> list;
        com.kwad.components.core.proxy.a aVar = this.aiV;
        if (aVar == null || (list = this.aiU.get(aVar)) == null) {
            return null;
        }
        for (c cVar : list) {
            if (cVar.b(detectEventType)) {
                return cVar;
            }
        }
        return null;
    }

    public final void h(com.kwad.components.core.proxy.a aVar) {
        c cVar = new c(DetectEventType.USER_CANCEL, aVar, new g.b(Lifecycle.Event.ON_RESUME), new g.b(Lifecycle.Event.ON_PAUSE), new g.a(500L), new g.b(Lifecycle.Event.ON_RESUME));
        a(cVar);
        c cVar2 = new c(DetectEventType.USER_CONFIRM, aVar, new g.b(Lifecycle.Event.ON_RESUME), new g.b(Lifecycle.Event.ON_PAUSE), new g.a(1000L), new g.b(Lifecycle.Event.ON_STOP));
        a(cVar2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        arrayList.add(cVar2);
        this.aiU.put(aVar, arrayList);
    }

    public final void i(com.kwad.components.core.proxy.a aVar) {
        List<c> list;
        if (aVar != null && (list = this.aiU.get(aVar)) != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            list.clear();
        }
        this.aiU.remove(aVar);
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(final com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.a(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(final com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.b(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(final com.kwad.components.core.proxy.a aVar) {
        this.aiV = aVar;
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.c(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(final com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.d(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(final com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.e(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(final com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.f(aVar);
            }
        });
        i(aVar);
    }

    private void a(com.kwad.components.core.proxy.a aVar, com.kwad.sdk.g.a<k> aVar2) {
        for (k kVar : this.aiT) {
            if (kVar instanceof n) {
                n nVar = (n) kVar;
                if (nVar.g(aVar)) {
                    aVar2.accept(nVar);
                }
            } else {
                aVar2.accept(kVar);
            }
        }
    }
}
