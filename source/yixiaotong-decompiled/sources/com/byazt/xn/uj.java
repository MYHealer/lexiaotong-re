package com.byazt.xn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 15})
public class uj extends com.byazt.gqp.uj {
    public ExecutorService c;
    public final Deque<c.C0327c> tt = new ArrayDeque();
    public final Deque<c.C0327c> ve = new ArrayDeque();
    public final Deque<c> uj = new ArrayDeque();
    public AtomicInteger n = new AtomicInteger(64);

    @Override // com.byazt.gqp.uj
    public ExecutorService tt() {
        return this.c;
    }

    @Override // com.byazt.gqp.uj
    public void tt(int i) {
    }

    public uj() {
        if (this.c == null) {
            this.c = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.byazt.xn.uj.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(runnable, "systemHttp Dispatcher");
                    veVar.setDaemon(false);
                    veVar.setPriority(10);
                    return veVar;
                }
            });
        }
    }

    @Override // com.byazt.gqp.uj
    public void c(int i) {
        this.n.set(i);
    }

    @Override // com.byazt.gqp.uj
    public int c() {
        return this.n.get();
    }

    public synchronized void c(c.C0327c c0327c) {
        try {
            if (this.ve.size() < c()) {
                this.ve.add(c0327c);
                if (c0327c != null) {
                    c0327c.c();
                }
                tt().submit(c0327c);
                return;
            }
            this.tt.add(c0327c);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c(c cVar) {
        this.uj.add(cVar);
    }

    public void tt(c.C0327c c0327c) {
        c(this.ve, c0327c, true);
    }

    public void tt(c cVar) {
        c(this.uj, cVar, false);
    }

    private <T> void c(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                ve();
            }
        }
    }

    private void ve() {
        if (this.ve.size() < c() && !this.tt.isEmpty()) {
            Iterator<c.C0327c> it = this.tt.iterator();
            while (it.hasNext()) {
                c.C0327c next = it.next();
                it.remove();
                this.ve.add(next);
                if (next != null) {
                    next.c();
                }
                tt().submit(next);
                if (this.ve.size() >= c()) {
                    return;
                }
            }
        }
    }
}
