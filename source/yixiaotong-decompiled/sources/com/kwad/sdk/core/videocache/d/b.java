package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements c {
    private HashMap<String, n> baI = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n fG(String str) {
        if (this.baI.containsKey(str)) {
            return this.baI.get(str);
        }
        return null;
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.baI.put(str, nVar);
    }
}
