package com.opos.mobad.c.e;

import com.opos.mobad.c.e.c;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f<T extends c> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<d<T>> f6718a;

    public f(List<d<T>> list) {
        this.f6718a = list;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(T t) {
        List<d<T>> list = this.f6718a;
        if (list == null || list.size() <= 0) {
            return true;
        }
        Iterator<d<T>> it = this.f6718a.iterator();
        while (it.hasNext()) {
            if (it.next().a(t)) {
                return true;
            }
        }
        return false;
    }
}
