package com.opos.mobad.template.j;

import android.view.View;
import com.opos.mobad.template.cmn.baseview.e;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8229a;
    protected com.opos.mobad.template.a.InterfaceC1003a d;
    private long i;
    private p b = new p() { // from class: com.opos.mobad.template.j.a.2
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.h(view, iArr);
            } else {
                com.opos.cmn.an.f.a.b("TemplateState", "mOnExtClickListener = isShowing " + a.this.i() + "," + a.this.c.a());
            }
        }
    };
    private f f = new f() { // from class: com.opos.mobad.template.j.a.3
        @Override // com.opos.mobad.template.cmn.baseview.f
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("TemplateState", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            a(view, i, z);
        }
    };
    private p g = new p() { // from class: com.opos.mobad.template.j.a.4
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.a(view, iArr);
            } else {
                com.opos.cmn.an.f.a.b("TemplateState", "mOnCloseClickListener = isShowing " + a.this.i() + "," + a.this.c.a());
            }
        }
    };
    private p h = new p() { // from class: com.opos.mobad.template.j.a.5
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.g(view, iArr);
            } else {
                com.opos.cmn.an.f.a.b("TemplateState", "mOnBtnClickListener = isShowing " + a.this.i() + "," + a.this.c.a());
            }
        }
    };
    protected boolean e = false;
    protected C1026a c = j();

    /* JADX INFO: renamed from: com.opos.mobad.template.j.a$16, reason: invalid class name */
    class AnonymousClass16 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f8239a;

        AnonymousClass16(Map map) {
            this.f8239a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.c.a() >= 3) {
                com.opos.cmn.an.f.a.b("TemplateState", "current state has showing ,no need to onShow = " + a.this.c.a());
            } else {
                a.this.c.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.16.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.j.a.16.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.d != null) {
                                    a.this.d.a(AnonymousClass16.this.f8239a);
                                }
                            }
                        });
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.template.j.a$a, reason: collision with other inner class name */
    static class C1026a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<Integer, Set<Integer>> f8253a;
        private AtomicInteger b;

        /* JADX INFO: renamed from: com.opos.mobad.template.j.a$a$a, reason: collision with other inner class name */
        public static class C1027a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f8254a;
            private Map<Integer, Set<Integer>> b = new HashMap();

            public C1027a(int i) {
                this.f8254a = i;
            }

            public C1027a a(int i, int i2) {
                Set<Integer> hashSet = this.b.get(Integer.valueOf(i));
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.b.put(Integer.valueOf(i), hashSet);
                }
                hashSet.add(Integer.valueOf(i2));
                return this;
            }

            public C1027a a(int i, int... iArr) {
                if (iArr == null) {
                    return this;
                }
                Set<Integer> hashSet = this.b.get(Integer.valueOf(i));
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.b.put(Integer.valueOf(i), hashSet);
                }
                for (int i2 : iArr) {
                    hashSet.add(Integer.valueOf(i2));
                }
                return this;
            }

            public C1026a a() {
                return new C1026a(this.f8254a, this.b);
            }
        }

        protected C1026a(int i, Map<Integer, Set<Integer>> map) {
            this.b = new AtomicInteger(i);
            a(map);
        }

        private int a(int i, int i2, Callable<Boolean> callable) {
            try {
                if (!callable.call().booleanValue()) {
                    a("execute fail");
                    return i;
                }
                if (!this.b.compareAndSet(i, i2)) {
                    a("unexpected fail");
                    b();
                }
                return i2;
            } catch (Exception e) {
                a("call exception :" + e);
                return i;
            }
        }

        private static final void a(String str) {
            com.opos.cmn.an.f.a.b("TemplateStateController", str);
        }

        private void a(Map<Integer, Set<Integer>> map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            this.f8253a = new HashMap();
            for (Integer num : map.keySet()) {
                Set<Integer> set = map.get(num);
                if (set != null && !set.isEmpty()) {
                    this.f8253a.put(num, new HashSet(map.get(num)));
                }
            }
        }

        private boolean a(int i, int i2) {
            StringBuilder sbAppend;
            String string;
            Map<Integer, Set<Integer>> map = this.f8253a;
            if (map == null) {
                string = "checkEnable but mController = null";
            } else {
                if (!map.containsKey(Integer.valueOf(i))) {
                    sbAppend = new StringBuilder("checkEnable but error current state:").append(i);
                } else {
                    if (this.f8253a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                        return true;
                    }
                    sbAppend = new StringBuilder("checkEnable but error next state:").append(i).append(",to:").append(i2);
                }
                string = sbAppend.toString();
            }
            a(string);
            return false;
        }

        private void b() {
        }

        public int a() {
            return this.b.get();
        }

        public int a(int i, Callable<Boolean> callable) {
            StringBuilder sb;
            a("changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
            int i2 = this.b.get();
            if (i2 == i) {
                sb = new StringBuilder("changeToStateBy but now target:");
            } else {
                if (a(i2, i)) {
                    if (callable != null) {
                        return a(i2, i, callable);
                    }
                    if (!this.b.compareAndSet(i2, i)) {
                        b();
                    }
                    return i;
                }
                sb = new StringBuilder("changeToStateBy but target is not enable:");
            }
            a(sb.append(i).toString());
            return i2;
        }
    }

    public a(int i) {
        this.f8229a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final long j, final long j2) {
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.j.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.n() == 8 || a.this.d == null) {
                    return;
                }
                a.this.d.d(j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return n() >= 3 && n() < 8;
    }

    protected static final C1026a j() {
        return new C1026a.C1027a(0).a(0, 2, 1, 8).a(1, 8).a(2, 3, 8).a(3, 4, 5, 8).a(4, 7, 6, 1, 8).a(5, 7, 6, 1, 8).a(7, 4, 5, 8).a(6, 5, 8).a();
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        this.c.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.11
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void a(final int i) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.14
            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.14.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        if (a.this.d != null) {
                            a.this.d.a(i);
                        }
                        return true;
                    }
                });
            }
        });
    }

    protected void a(int i, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.a(i, iArr);
    }

    public void a(long j, long j2) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.c(j, j2);
    }

    public void a(View view) {
        if (this.c.a() == 8) {
            return;
        }
        p.a(view, this.b);
    }

    public void a(View view, int i, boolean z) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        com.opos.cmn.an.f.a.a("TemplateState", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.a(view, i, z);
    }

    public void a(final View view, final int[] iArr) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.18
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d != null) {
                    a.this.d.e(view, iArr);
                }
            }
        });
    }

    public void a(View view, int[] iArr, boolean z) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.a(view, iArr, z);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.d = interfaceC1003a;
    }

    public void a(e eVar) {
        if (this.c.a() != 8 && eVar == null) {
            eVar.a(this.f);
        }
    }

    public void a(Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new AnonymousClass16(map));
    }

    public void a(final Callable callable) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.15
            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.15.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        if (a.this.d != null) {
                            a.this.d.e();
                        }
                        if (callable != null) {
                            callable.call();
                        }
                        return true;
                    }
                });
            }
        });
    }

    protected void a(int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.b(iArr);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        this.c.a(5, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void b(int i) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.c(i);
    }

    public void b(long j, long j2) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.b(j, j2);
    }

    public void b(View view) {
        if (this.c.a() == 8) {
            return;
        }
        p.a(view, this.h);
    }

    protected void b(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.i(view, iArr);
    }

    public void b(final Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.17
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("TemplateState", "onShowFocus = " + map);
                if (a.this.d != null) {
                    a.this.d.a(map);
                }
            }
        });
    }

    protected void b(int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.a(iArr);
    }

    public void c(final long j, final long j2) {
        com.opos.cmn.an.f.a.b("TemplateState", "onProgress = " + j + "," + j2 + "," + this.c.a());
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                int iA = a.this.c.a();
                if (iA == 4 || iA == 5) {
                    if (a.this.e) {
                        a aVar = a.this;
                        aVar.d(j, aVar.i);
                        return;
                    }
                    a.this.i = j2;
                    a.this.e = true;
                    a aVar2 = a.this;
                    aVar2.d(0L, aVar2.i);
                }
            }
        });
    }

    protected void c(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.j(view, iArr);
    }

    public void c(final Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.7.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        if (a.this.d != null) {
                            a.this.d.b(map);
                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.c.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                a.this.h();
                a.this.d = null;
                return true;
            }
        });
    }

    public void d(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.c(view, iArr);
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.f8229a;
    }

    public void e(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.b(view, iArr);
    }

    public void f(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.d(view, iArr);
    }

    protected abstract boolean f();

    public void g(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.g(view, iArr);
    }

    protected abstract boolean g();

    protected abstract void h();

    public void h(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.h(view, iArr);
    }

    public void i(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.f(view, iArr);
    }

    public void j(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.a(view, iArr);
    }

    protected void k() {
        this.c.a(4, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.12
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void k(View view, int[] iArr) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a;
        if (this.c.a() == 8 || (interfaceC1003a = this.d) == null) {
            return;
        }
        interfaceC1003a.l(view, iArr);
    }

    protected void l() {
        this.c.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.13
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void l(View view, int[] iArr) {
        if (i()) {
            d(view, iArr);
        } else {
            com.opos.cmn.an.f.a.b("TemplateState", "onPermissionClickWithState = isShowing " + i() + "," + this.c.a());
        }
    }

    public void m() {
        a((Callable) null);
    }

    public void m(View view, int[] iArr) {
        if (i()) {
            e(view, iArr);
        } else {
            com.opos.cmn.an.f.a.b("TemplateState", "onPrivacyClickWithState = isShowing " + i() + "," + this.c.a());
        }
    }

    public int n() {
        return this.c.a();
    }

    public void n(View view, int[] iArr) {
        if (i()) {
            f(view, iArr);
        } else {
            com.opos.cmn.an.f.a.b("TemplateState", "onIntroduceClickWithState = isShowing " + i() + "," + this.c.a());
        }
    }

    public void o() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d != null) {
                    a.this.d.a(a.this.i, a.this.i);
                }
            }
        });
    }
}
