package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.exception.MspBridgeWrapException;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.exception.MspUnHandledException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.provider.BridgeException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class c implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f3473a;
    private final Object b;
    private final com.heytap.mspsdk.event.b c;
    private final Bundle d;
    private final Parcelable e;

    public c(a aVar, Object obj, Parcelable parcelable, Bundle bundle, com.heytap.mspsdk.event.b bVar) {
        this.f3473a = aVar;
        this.b = obj;
        this.c = bVar;
        this.e = parcelable;
        this.d = bundle;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Throwable cause;
        try {
            com.heytap.mspsdk.event.b bVar = this.c;
            com.heytap.mspsdk.event.a aVarA = bVar != null ? bVar.a() : new com.heytap.mspsdk.event.b.a();
            aVarA.a();
            com.heytap.mspsdk.core.b bVarA = com.heytap.mspsdk.core.b.a(com.heytap.mspsdk.core.e.a().b());
            d dVar = new d(this.b, method, objArr, bVarA, this.d, aVarA);
            dVar.a("invokeStart");
            LinkedList linkedList = new LinkedList();
            linkedList.add(new b());
            if (bVarA.c() && com.heytap.mspsdk.core.b.g()) {
                linkedList.add(new h());
                linkedList.add(new f(this.f3473a));
            }
            linkedList.add((!bVarA.c() || (this.b instanceof Class)) ? new e(this.e) : new g());
            com.heytap.mspsdk.interceptor.c cVar = new com.heytap.mspsdk.interceptor.c(linkedList, 0, dVar);
            dVar.a("chainProceedStart");
            RESPONSE responseA = cVar.a(dVar);
            dVar.a("chainProceedEnd");
            return responseA;
        } catch (Throwable th) {
            MspLog.e(th);
            if (!(th instanceof MspProxyException) || (cause = th.getCause()) == null) {
                if (th instanceof MspSdkException) {
                    throw th;
                }
                throw new MspUnHandledException(th);
            }
            if (cause instanceof BridgeException) {
                throw new MspBridgeWrapException(cause.getMessage(), cause, ((BridgeException) cause).getCode());
            }
            if (cause instanceof MspSdkException) {
                throw cause;
            }
            throw new MspUnHandledException(cause);
        }
    }
}
