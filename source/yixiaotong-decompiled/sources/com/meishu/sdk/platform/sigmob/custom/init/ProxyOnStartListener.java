package com.meishu.sdk.platform.sigmob.custom.init;

import com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ProxyOnStartListener implements InvocationHandler {
    private final SigmobCustomInitManager.InitCallback callback;

    public ProxyOnStartListener(SigmobCustomInitManager.InitCallback initCallback) {
        this.callback = initCallback;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            String name = method.getName();
            if ("onStartSuccess".equals(name)) {
                SigmobCustomInitManager.InitCallback initCallback = this.callback;
                if (initCallback == null) {
                    return null;
                }
                initCallback.onSuccess();
                return null;
            }
            if (!"onStartFail".equals(name)) {
                return null;
            }
            String str = "";
            try {
                str = (String) objArr[0];
            } catch (Exception unused) {
            }
            SigmobCustomInitManager.InitCallback initCallback2 = this.callback;
            if (initCallback2 == null) {
                return null;
            }
            initCallback2.onError(-1, str);
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            SigmobCustomInitManager.InitCallback initCallback3 = this.callback;
            if (initCallback3 == null) {
                return null;
            }
            initCallback3.onError(-1, "error:" + th);
            return null;
        }
    }
}
