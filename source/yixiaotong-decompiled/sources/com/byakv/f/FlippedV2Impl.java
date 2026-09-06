package com.byakv.f;

import android.util.Log;
import com.byazt.bog.a;
import com.byazt.bzd.sp;
import com.byazt.fus.ve;
import com.bytedance.pangle.GlobalParam;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class FlippedV2Impl implements ve {
    public static final String TAG = "FlippedV2Impl";

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        sp.c("pangleflipped");
    }

    @Override // com.byazt.fus.ve
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", "v2");
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            a.n(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
