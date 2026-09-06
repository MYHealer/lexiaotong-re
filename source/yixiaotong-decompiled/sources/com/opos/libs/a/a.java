package com.opos.libs.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, Set<Integer>> f6572a;
    private AtomicInteger b;
    private ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: com.opos.libs.a.a$a, reason: collision with other inner class name */
    public static class C0933a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6573a;
        private Map<Integer, Set<Integer>> b = new HashMap();

        public C0933a(int i) {
            this.f6573a = i;
        }

        public C0933a a(int i, int i2) {
            Set<Integer> hashSet = this.b.get(Integer.valueOf(i));
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.b.put(Integer.valueOf(i), hashSet);
            }
            hashSet.add(Integer.valueOf(i2));
            return this;
        }

        public C0933a a(int i, int... iArr) {
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

        public a a() {
            return new a(this.f6573a, this.b);
        }
    }

    protected a(int i, Map<Integer, Set<Integer>> map) {
        this.b = new AtomicInteger(i);
        a(map);
    }

    private int a(int i, int i2, Callable<Boolean> callable) {
        try {
            if (!callable.call().booleanValue()) {
                com.opos.cmn.an.f.a.a("SyncStateController", "execute fail");
                return i;
            }
            if (!this.b.compareAndSet(i, i2)) {
                com.opos.cmn.an.f.a.a("SyncStateController", "unexpected fail");
                b();
            }
            return i2;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SyncStateController", "call exception :" + e);
            return i;
        }
    }

    private void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f6572a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f6572a.put(num, new HashSet(map.get(num)));
            }
        }
    }

    private boolean a(int i, int i2) {
        StringBuilder sbAppend;
        String string;
        Map<Integer, Set<Integer>> map = this.f6572a;
        if (map == null) {
            string = "checkEnable but mController = null";
        } else {
            if (!map.containsKey(Integer.valueOf(i))) {
                sbAppend = new StringBuilder("checkEnable but error current state:").append(i);
            } else {
                if (this.f6572a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                    return true;
                }
                sbAppend = new StringBuilder("checkEnable but error next state:").append(i).append(",to:").append(i2);
            }
            string = sbAppend.toString();
        }
        com.opos.cmn.an.f.a.a("SyncStateController", string);
        return false;
    }

    private void b() {
    }

    public int a() {
        return this.b.get();
    }

    public int a(int i) {
        com.opos.cmn.an.f.a.a("SyncStateController", "changeToState:" + i);
        try {
            this.c.readLock().lock();
            int i2 = this.b.get();
            if (i2 == i) {
                this.c.readLock().unlock();
                return i;
            }
            int i3 = 3;
            while (i3 > 0) {
                if (!a(i2, i)) {
                    this.c.readLock().unlock();
                    return i2;
                }
                if (this.b.compareAndSet(i2, i)) {
                    this.c.readLock().unlock();
                    return i;
                }
                i3--;
                i2 = this.b.get();
            }
            this.c.readLock().unlock();
            return a(i, (Callable<Boolean>) null);
        } catch (Throwable th) {
            this.c.readLock().unlock();
            throw th;
        }
    }

    public int a(int i, Callable<Boolean> callable) {
        String str;
        com.opos.cmn.an.f.a.a("SyncStateController", "changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
        try {
            this.c.writeLock().lock();
            int i2 = this.b.get();
            if (i2 == i) {
                str = "changeToStateBy but now target:" + i;
            } else {
                if (a(i2, i)) {
                    if (callable != null) {
                        i = a(i2, i, callable);
                    } else if (!this.b.compareAndSet(i2, i)) {
                        b();
                    }
                    return i;
                }
                str = "changeToStateBy but target is not enable:" + i;
            }
            com.opos.cmn.an.f.a.a("SyncStateController", str);
            return i2;
        } finally {
            this.c.writeLock().unlock();
        }
    }
}
