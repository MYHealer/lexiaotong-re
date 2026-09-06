package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f1178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ra f297a = new nn();

    public static abstract class a {
        public boolean mCancelled;
        public Exception mError;
        public Future<?> mFuture;

        public abstract void callback(Exception exc);

        public void cancel() {
            this.mCancelled = true;
            try {
                Future<?> future = this.mFuture;
                if (future != null) {
                    future.cancel(true);
                }
            } catch (Exception e) {
                Log.w("TaskHelper", e.toString());
            }
            ((nn) fn.f297a).getClass();
            nn.f1329a.removeMessages(1, this);
        }

        public abstract void execute() throws Exception;

        public final boolean isCancelled() {
            return this.mCancelled;
        }

        public boolean needDoneAtOnce() {
            return false;
        }
    }

    public static abstract class b extends a {
        @Override // com.adprof.sdk.fn.a
        public void execute() {
        }
    }

    public static a a(a aVar, long j) {
        if (j > 0) {
            new Handler(hn.f1216a).postDelayed(new cn(aVar), j);
        } else {
            ((nn) f297a).a(aVar);
        }
        return aVar;
    }

    public static void a(b bVar) {
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            if (f1178a == null) {
                f1178a = new Handler(Looper.getMainLooper());
            }
            f1178a.post(new dn(bVar));
        } else {
            try {
                bVar.callback(null);
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
            }
        }
    }
}
