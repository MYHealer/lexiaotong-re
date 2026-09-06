package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c<T extends d> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final List<T> f7460a;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<T> f7461a = new ArrayList();

        public a a(T t) throws NullPointerException {
            if (t == null) {
                throw new NullPointerException("iCreator is null");
            }
            this.f7461a.add(t);
            return this;
        }
    }

    public c(a<T> aVar) {
        this.f7460a = ((a) aVar).f7461a;
    }

    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar2) {
        List<T> list = this.f7460a;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            com.opos.mobad.template.a aVarA = it.next().a(context, i, aVar, interfaceC1003a, aVar2);
            if (aVarA != null) {
                return aVarA;
            }
        }
        return null;
    }
}
