package com.opos.process.bridge.dispatch;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.ba;
import com.opos.process.bridge.a.b;
import com.opos.process.bridge.a.d;
import com.opos.process.bridge.a.f;
import com.opos.process.bridge.a.g;
import com.opos.process.bridge.a.h;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import com.opos.process.bridge.server.c;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class BaseActivityDispatcher implements IActivityDispatcher {
    private static final String TAG = "BaseActivityDispatcher";

    @Override // com.opos.process.bridge.dispatch.IActivityDispatcher
    public void dispatch(Activity activity) {
        b bVarA;
        ProcessBridgeLog.d(TAG, "dispatch this");
        if (activity.getIntent() == null || activity.getIntent().getExtras() == null) {
            activity.finish();
            return;
        }
        Bundle bundle = activity.getIntent().getExtras().getBundle(ba.M);
        HashMap map = new HashMap();
        String strDecodeParamsGetTargetClass = BundleUtil.decodeParamsGetTargetClass(activity.getIntent().getExtras());
        g gVarA = new g.a().a(activity).a(activity.getCallingPackage()).b(strDecodeParamsGetTargetClass).a(bundle).a(map).a();
        for (f fVar : c.a().c()) {
            bVarA = fVar.a(gVarA);
            ProcessBridgeLog.d(TAG, "ServerInterceptor: " + fVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(activity.getCallingPackage(), bVarA);
                activity.finish();
                return;
            }
        }
        int iDecodeParamsGetMethodId = BundleUtil.decodeParamsGetMethodId(activity.getIntent().getExtras());
        ProcessBridgeLog.d(TAG, "targetClass:" + strDecodeParamsGetTargetClass + ", methodId:" + iDecodeParamsGetMethodId);
        d dVarA = new d.a().a(activity).a(activity.getCallingPackage()).a(bundle).b(strDecodeParamsGetTargetClass).a(iDecodeParamsGetMethodId).a();
        for (h hVar : c.a().d()) {
            bVarA = hVar.a(dVarA);
            ProcessBridgeLog.d(TAG, "ServerMethodInterceptor: " + hVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(activity.getCallingPackage(), bVarA);
                activity.finish();
                return;
            }
        }
        try {
            Object[] objArrDecodeParamsGetArgs = BundleUtil.decodeParamsGetArgs(activity.getIntent().getExtras());
            ThreadLocalUtil.put(map);
            ProcessBridgeLog.d(TAG, "dispatch ");
            dispatch(activity, strDecodeParamsGetTargetClass, iDecodeParamsGetMethodId, objArrDecodeParamsGetArgs);
            ThreadLocalUtil.remove((Set<String>) map.keySet());
        } catch (Exception e) {
            c.a().a(activity.getClass().getName(), activity.getCallingPackage(), 101008, e.getMessage());
        }
    }

    protected abstract void dispatch(Activity activity, String str, int i, Object[] objArr);
}
