package com.byazt.fus;

import android.util.Log;
import com.byazt.bog.a;
import com.bytedance.pangle.GlobalParam;
import com.huawei.hms.ads.dynamicloader.b;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1805, 13})
public class tt implements ve {
    @Override // com.byazt.fus.ve
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", b.f);
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            a.n("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
