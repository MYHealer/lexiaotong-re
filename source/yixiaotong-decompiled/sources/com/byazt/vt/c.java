package com.byazt.vt;

import java.util.HashMap;
import java.util.Map;
import org.videolan.libvlc.RendererDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, RendererDiscoverer.Event.ItemAdded, 20})
public class c {
    public volatile Map<String, ve> c = new HashMap();

    public ve c(String str) {
        if (this.c.containsKey(str) && this.c.get(str) != null) {
            return this.c.get(str);
        }
        tt ttVar = new tt();
        this.c.put(str, ttVar);
        return ttVar;
    }

    public void c(String str, ve veVar) {
        if (!this.c.containsKey(str) || this.c.get(str) == null) {
            this.c.put(str, veVar);
        }
    }
}
