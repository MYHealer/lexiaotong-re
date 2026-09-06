package com.opos.process.bridge.server;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.openalliance.ad.constant.ba;
import com.opos.process.bridge.a.f;
import com.opos.process.bridge.a.g;
import com.opos.process.bridge.a.h;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.process.bridge.a.AbstractBinderC1042a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8423a;
    private Map<String, Object> b;

    public b(Context context, Map<String, Object> map) {
        this.f8423a = context;
        this.b = map;
    }

    @Override // com.opos.process.bridge.a
    public Bundle a(Bundle bundle) throws RemoteException {
        String str;
        String[] packagesForUid = this.f8423a.getPackageManager().getPackagesForUid(getCallingUid());
        if (packagesForUid == null || packagesForUid.length != 1) {
            ProcessBridgeLog.e("ProcessBridgeBinder", "could not find correct package name");
            str = "";
        } else {
            str = packagesForUid[0];
            ProcessBridgeLog.d("ProcessBridgeBinder", "callingPackage:" + str);
        }
        bundle.setClassLoader(ProcessBridgeProvider.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(ba.M);
        String strDecodeParamsGetTargetClass = BundleUtil.decodeParamsGetTargetClass(bundle);
        g gVarA = new g.a().a(this.f8423a).a(str).b(strDecodeParamsGetTargetClass).a(bundle2).a(this.b).a();
        for (f fVar : c.a().c()) {
            com.opos.process.bridge.a.b bVarA = fVar.a(gVarA);
            ProcessBridgeLog.d("ProcessBridgeBinder", "ServerInterceptor: " + fVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(str, bVarA);
                return BundleUtil.makeInterceptorResultBundle(bVarA.a(), bVarA.b());
            }
        }
        IBridgeTargetIdentify iBridgeTargetIdentifyDecodeParamsGetIdentify = BundleUtil.decodeParamsGetIdentify(bundle);
        int iDecodeParamsGetMethodId = BundleUtil.decodeParamsGetMethodId(bundle);
        com.opos.process.bridge.a.d dVarA = new com.opos.process.bridge.a.d.a().a(this.f8423a).a(str).a(bundle2).b(strDecodeParamsGetTargetClass).a(iBridgeTargetIdentifyDecodeParamsGetIdentify).a(iDecodeParamsGetMethodId).a();
        for (h hVar : c.a().d()) {
            com.opos.process.bridge.a.b bVarA2 = hVar.a(dVarA);
            ProcessBridgeLog.d("ProcessBridgeBinder", "ServerMethodInterceptor: " + hVar.getClass().getName() + ", result:" + bVarA2);
            if (bVarA2.c()) {
                c.a().a(str, bVarA2);
                return BundleUtil.makeInterceptorResultBundle(bVarA2.a(), bVarA2.b());
            }
        }
        try {
            Object[] objArrDecodeParamsGetArgs = BundleUtil.decodeParamsGetArgs(bundle);
            ThreadLocalUtil.put(this.b);
            Bundle bundleA = com.opos.process.bridge.dispatch.a.a().a(this.f8423a, str, strDecodeParamsGetTargetClass, iBridgeTargetIdentifyDecodeParamsGetIdentify, iDecodeParamsGetMethodId, objArrDecodeParamsGetArgs);
            ThreadLocalUtil.remove(this.b.keySet());
            return bundleA;
        } catch (Exception e) {
            c.a().a(strDecodeParamsGetTargetClass, str, 101008, e.getMessage());
            return BundleUtil.makeExceptionBundle(e);
        }
    }
}
