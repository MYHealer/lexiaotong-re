package com.heytap.mspsdk.proxy;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.msp.ipc.a.l;
import com.heytap.msp.ipc.a.m;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e implements m, com.heytap.msp.ipc.c.a, com.heytap.mspsdk.interceptor.b<d, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f3475a;
    private com.heytap.mspsdk.core.b b;

    public e(Parcelable parcelable) {
        this.f3475a = parcelable;
    }

    @Override // com.heytap.msp.ipc.a.m
    public l a(Context context, l lVar) {
        String strA = lVar.a();
        com.heytap.mspsdk.core.b bVar = this.b;
        if (bVar != null) {
            strA = bVar.f();
        }
        String strB = lVar.b();
        String strC = lVar.c();
        if (!TextUtils.isEmpty(strB) && strB.contains("${applicationId}")) {
            String strReplace = strB.replace("${applicationId}", strA);
            MspLog.v("PackageReplace", "replace package = " + strReplace);
            return l.a(strA, strReplace);
        }
        if (TextUtils.isEmpty(strC)) {
            return lVar;
        }
        if (strC.contains("${applicationId}")) {
            strC = strC.replace("${applicationId}", strA);
            MspLog.v("PackageReplace", "replace package = " + strC);
        }
        return l.b(strA, strC);
    }

    @Override // com.heytap.msp.ipc.c.a
    public l a(Context context, List<l> list) {
        if (list != null && !list.isEmpty()) {
            for (l lVar : list) {
                if (TextUtils.equals(lVar.a(), this.b.f())) {
                    MspLog.iIgnore("PackageReplace", "filter target = " + lVar);
                    return lVar;
                }
            }
        }
        return null;
    }

    @Override // com.heytap.mspsdk.interceptor.b
    public Object a(com.heytap.mspsdk.interceptor.a<d, Object> aVar) {
        Object objA;
        Object objA2;
        d dVarA = aVar.a();
        this.b = dVarA.d;
        Bundle bundle = dVarA.f;
        Class cls = dVarA.f3474a instanceof Class ? (Class) dVarA.f3474a : null;
        if (cls == null || !cls.isInterface()) {
            throw new MspSdkException(2007, MspSdkCode.EXCEPTION_MSG_2007_INTERFACE_ERROR);
        }
        com.heytap.msp.ipc.annotation.a aVar2 = (com.heytap.msp.ipc.annotation.a) dVarA.b.getAnnotation(com.heytap.msp.ipc.annotation.a.class);
        if (aVar2 == null) {
            throw new MspSdkException(2008, MspSdkCode.EXCEPTION_MSG_2008_METHOD_NO_ANNOTATION);
        }
        com.heytap.msp.ipc.a.g gVarA = com.heytap.mspsdk.core.c.a(com.heytap.mspsdk.core.e.a().b(), cls, this.f3475a, bundle);
        gVarA.a(this);
        try {
            if (gVarA instanceof com.heytap.msp.ipc.a.d) {
                ((com.heytap.msp.ipc.a.d) gVarA).a(aVar2.a(), dVarA.c);
                return null;
            }
            Class<?> returnType = dVarA.b.getReturnType();
            if (gVarA instanceof com.heytap.msp.ipc.a.e) {
                com.heytap.msp.ipc.a.e eVar = (com.heytap.msp.ipc.a.e) gVarA;
                eVar.a((com.heytap.msp.ipc.c.a) this);
                objA = eVar.a(aVar2.a(), dVarA.c);
            } else if (gVarA instanceof com.heytap.msp.ipc.a.f) {
                com.heytap.msp.ipc.a.f fVar = (com.heytap.msp.ipc.a.f) gVarA;
                fVar.a((com.heytap.msp.ipc.c.a) this);
                objA = fVar.a(aVar2.a(), dVarA.c);
            } else {
                objA = null;
            }
            if (returnType == Void.TYPE) {
                return null;
            }
            return (returnType.isPrimitive() && objA == null && (objA2 = com.heytap.mspsdk.util.d.a(returnType)) != null) ? objA2 : objA;
        } catch (IPCBridgeException e) {
            throw new MspProxyException(e);
        }
    }
}
