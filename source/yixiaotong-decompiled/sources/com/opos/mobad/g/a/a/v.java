package com.opos.mobad.g.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6945a;
    private int b;
    private final List<b<T>> c;
    private Set<Integer> d;

    /* JADX INFO: renamed from: com.opos.mobad.g.a.a.v$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<b<T>> f6946a = new ArrayList();
        private int b = 0;

        public v<T> a() {
            return new v<>(this.f6946a, this.b, null);
        }

        public void a(T t, int i) {
            if (i <= 0) {
                return;
            }
            this.f6946a.add(new b<>(t, i));
            this.b += i;
        }
    }

    private static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6947a;
        private final T b;

        public b(T t, int i) {
            this.b = t;
            this.f6947a = i;
        }
    }

    private v(List<b<T>> list, int i) {
        this.c = list;
        this.f6945a = i;
        this.b = i;
        this.d = new HashSet(list.size());
    }

    /* synthetic */ v(List list, int i, AnonymousClass1 anonymousClass1) {
        this(list, i);
    }

    public T a() {
        if (this.b <= 0 || this.c.size() <= 0 || this.d.size() >= this.c.size()) {
            return null;
        }
        int iRandom = (int) (Math.random() * ((double) this.b));
        int iMax = 0;
        for (int i = 0; i < this.c.size(); i++) {
            if (!this.d.contains(Integer.valueOf(i))) {
                b<T> bVar = this.c.get(i);
                iMax += Math.max(0, ((b) bVar).f6947a);
                if (iRandom <= iMax) {
                    T t = (T) ((b) bVar).b;
                    this.d.add(Integer.valueOf(i));
                    this.b -= ((b) bVar).f6947a;
                    return t;
                }
            }
        }
        return null;
    }

    public void b() {
        this.b = this.f6945a;
        this.d.clear();
    }
}
