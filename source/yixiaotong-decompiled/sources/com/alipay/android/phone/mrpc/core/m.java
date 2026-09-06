package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class m extends FutureTask<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f1583a;
    final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.b = lVar;
        this.f1583a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        o oVarA = this.f1583a.a();
        if (oVarA.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || oVarA.h()) {
                oVarA.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (InterruptedException e) {
            new StringBuilder().append(e);
        } catch (CancellationException unused) {
            oVarA.g();
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                new StringBuilder().append(e2);
                return;
            }
            HttpException httpException = (HttpException) e2.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
