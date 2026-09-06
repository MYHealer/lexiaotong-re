package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private final Set<Integer> auZ = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> ava = new ConcurrentHashMap<>();

    static class a {
        private static final b avb = new b();
    }

    public static b zE() {
        return a.avb;
    }

    public final boolean cm(int i) {
        if (this.auZ.contains(Integer.valueOf(i))) {
            return false;
        }
        this.auZ.add(Integer.valueOf(i));
        return true;
    }

    public final void a(int i, f fVar) {
        Set<f> set = this.ava.get(Integer.valueOf(i));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.ava.put(Integer.valueOf(i), hashSet);
    }

    private void a(int i, String str, String str2) {
        Set<f> set;
        this.auZ.remove(Integer.valueOf(i));
        if (this.ava.isEmpty() || this.ava.get(Integer.valueOf(i)) == null || (set = this.ava.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        this.ava.remove(Integer.valueOf(i));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().zo();
        }
    }

    private void cn(int i) {
        Set<f> set;
        this.auZ.remove(Integer.valueOf(i));
        if (this.ava.isEmpty() || this.ava.get(Integer.valueOf(i)) == null || (set = this.ava.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().zp();
        }
        this.ava.remove(Integer.valueOf(i));
    }

    public final void b(int i, String str, String str2) {
        a(i, str, str2);
    }

    public final void co(int i) {
        cn(i);
    }
}
