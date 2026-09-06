package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService aUV;
    private static volatile Handler jk;
    private T aUY;
    private Context mContext;
    private volatile long als = 120000;
    protected l aUU = new m();
    private AtomicInteger aUW = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int aUX = 5;

    protected abstract R G(List<T> list);

    protected final void a(l lVar) {
        this.aUU = lVar;
    }

    protected final void aJ(long j) {
        if (j < 60) {
            this.als = 60000L;
        } else {
            this.als = j * 1000;
        }
    }

    protected b() {
        if (aUV == null) {
            aUV = GlobalThreadPools.Ob();
        }
    }

    public synchronized void j(Context context, int i) {
        this.mContext = context;
        if (jk == null) {
            jk = com.kwad.sdk.core.threads.a.NR();
        }
    }

    public final void a(final k<T> kVar) {
        aUV.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.jk != null && !b.jk.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.aK(bVar.als);
                }
                e eVarMV = kVar.MV();
                if (eVarMV != null) {
                    b.this.aUU.o(eVarMV);
                }
                if (b.this.MQ()) {
                    b.this.MR();
                }
            }
        });
    }

    protected final boolean MQ() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.aUU.size() >= (sVar != null ? (long) (sVar.Fr() << i) : 20L);
    }

    public final void MR() {
        aK(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aK(long j) {
        if (jk == null) {
            return;
        }
        jk.removeMessages(R.attr.childDivider);
        Message messageObtain = Message.obtain(jk, a(this.mContext, this.aUU, this.aUW));
        messageObtain.what = R.attr.childDivider;
        jk.sendMessageDelayed(messageObtain, j);
    }

    protected Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean, final u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.aUW.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return fh(str);
            }

            private static BatchReportResult fh(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aUV;
            }

            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                return (R) b.this.G(list);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                b.this.aUU.H(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.No();
                }
                if (b.this.aUW.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.MS();
                }
                b.this.aJ(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.aK(bVar.als);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.aUW.decrementAndGet() == 0) {
                    b.this.MS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.aUX) {
            if (andIncrement > 0) {
                this.als *= 2;
            }
            aK(this.als);
        }
    }

    public final void b(k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    private void c(final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return fh(str);
            }

            private static BatchReportResult fh(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                e eVarMV = kVar.MV();
                b.this.aUY = eVarMV;
                return (R) b.this.a(eVarMV);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aUV;
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aUY + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + b.this.aUY);
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    public final T MV() {
                        return (T) b.this.aUY;
                    }
                });
            }
        });
    }

    protected R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return (R) G(arrayList);
    }
}
