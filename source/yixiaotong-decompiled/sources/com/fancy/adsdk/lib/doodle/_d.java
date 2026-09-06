package com.fancy.adsdk.lib.doodle;

import com.fancy._fq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _d {
    public static final _a _a = new _a(Math.min(Math.max(2, Runtime.getRuntime().availableProcessors()), 4));
    public static final _a _b = new _a(8);
    public static final _b _c = new _b();
    public static final _a _d = new _a(1);
    public static Executor _e = null;

    public static class _a implements Executor {
        public final int _c;
        public final LinkedList<Runnable> _a = new LinkedList<>();
        public final LinkedList<Runnable> _b = new LinkedList<>();
        public int _d = 0;
        public final Executor _e = _d._a();

        public _a(int i) {
            this._c = i <= 0 ? 1 : i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void _a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                try {
                    _fq._a("Doodle", th);
                } finally {
                    _a();
                }
            }
        }

        public final synchronized void _a() {
            int i = this._d - 1;
            this._d = i;
            if (i < this._c) {
                Runnable runnablePoll = this._a.poll();
                if (runnablePoll == null) {
                    runnablePoll = this._b.poll();
                }
                if (runnablePoll != null) {
                    _b(runnablePoll);
                }
            }
        }

        public final void _b(final Runnable runnable) {
            this._d++;
            this._e.execute(new Runnable() { // from class: com.fancy.adsdk.lib.doodle._d$_a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0._a(runnable);
                }
            });
        }

        @Override // java.util.concurrent.Executor
        public final synchronized void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (this._d < this._c) {
                _b(runnable);
            } else {
                this._a.offer(runnable);
            }
        }
    }

    public static class _b {
        public static final HashSet _a = new HashSet();
        public static final HashMap _b = new HashMap();
    }

    public static abstract class _c implements Runnable {
        public final Runnable _a;
        public final boolean _b;

        public _c(FutureTask futureTask, boolean z) {
            this._a = futureTask;
            this._b = z;
        }
    }

    public static Executor _a() {
        if (_e == null) {
            _e = Executors.newCachedThreadPool();
        }
        return _e;
    }
}
