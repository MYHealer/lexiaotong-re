package com.heytap.msp.ipc.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.huawei.openalliance.ad.constant.ba;
import com.stub.StubApp;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends a {
    public e(Context context, com.heytap.msp.ipc.annotation.b bVar, Parcelable parcelable, Bundle bundle) {
        this(context, h.a(bVar), bVar.b(), bVar.c(), parcelable, bundle);
    }

    public e(Context context, List<l> list, String str, String str2, Parcelable parcelable, Bundle bundle) {
        super(list, str, str2, parcelable, bundle);
        this.h = StubApp.getOrigApplicationContext(context.getApplicationContext()) != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.heytap.msp.ipc.a.l] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    private Bundle a(com.heytap.msp.ipc.b.c cVar, l lVar, Object[] objArr) throws Throwable {
        ?? r7;
        j.b("BaseProviderClient", "multi process --- call remote");
        Bundle bundleA = c.a(cVar.b(), cVar.c(), cVar.d(), objArr);
        if (this.j != null) {
            bundleA.putBundle(ba.M, this.j);
        }
        Uri uri = Uri.parse("content://" + lVar.c);
        j.b("BaseProviderClient", "uri:" + uri.toString() + ",bundle:" + bundleA);
        ?? r2 = 0;
        bundleA = null;
        Bundle bundleA2 = null;
        try {
            try {
                lVar = cVar.a().getContentResolver().acquireUnstableContentProviderClient(lVar.c);
                try {
                    bundleA2 = lVar == 0 ? c.a(101010, "acquireUnstableContentProviderClient error") : cVar.a().getContentResolver().call(uri, "dispatch", "", bundleA);
                    r7 = lVar;
                    if (lVar != 0) {
                        r7.release();
                    }
                } catch (Exception e) {
                    e = e;
                    j.a("BaseProviderClient", "resolve error", e);
                    r7 = lVar;
                    if (lVar != 0) {
                    }
                    return bundleA2;
                }
            } catch (Throwable th) {
                th = th;
                r2 = lVar;
                if (r2 != 0) {
                    r2.release();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            lVar = 0;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
                r2.release();
            }
            throw th;
        }
        return bundleA2;
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ Object a(int i, Object[] objArr) throws IPCBridgeException {
        return super.a(i, objArr);
    }

    @Override // com.heytap.msp.ipc.a.a
    protected Object a(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseProviderClient", "callForResult method call");
        return super.a(context, str, parcelable, i, objArr);
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ void a(com.heytap.msp.ipc.c.a aVar) {
        super.a(aVar);
    }

    @Override // com.heytap.msp.ipc.a.a
    protected Bundle b(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseProviderClient", "callRemote");
        if (!c.a(objArr)) {
            return c.a(101006, "Invalid params");
        }
        com.heytap.msp.ipc.b.c cVarA = new com.heytap.msp.ipc.b.c.a().a(context).a(context.getPackageName()).a(this.j).b(str).a(parcelable).a(i).a();
        j.a("BaseProviderClient", "call clientMethodInterceptors");
        for (com.heytap.msp.ipc.b.a aVar : this.k) {
            com.heytap.msp.ipc.b.b bVarA = aVar.a(cVarA);
            j.a("BaseProviderClient", "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new IPCBridgeException(bVarA.b(), bVarA.a());
            }
        }
        l lVarA = null;
        try {
            if (this.d.tryLock() || this.d.tryLock(this.e, TimeUnit.MILLISECONDS)) {
                lVarA = a(context);
                this.d.unlock();
            } else {
                j.b("BaseProviderClient", "lock fail");
            }
        } catch (InterruptedException e) {
            j.a("BaseProviderClient", "lock", e);
            try {
                this.d.unlock();
            } catch (Exception e2) {
                j.a("BaseProviderClient", "unlock", e2);
            }
        }
        if (lVarA != null) {
            return a(cVarA, lVarA, objArr);
        }
        throw new IPCBridgeException("No target found for all authority", 101001);
    }

    @Override // com.heytap.msp.ipc.a.g
    IPCType c() {
        return IPCType.PROVIDER;
    }
}
