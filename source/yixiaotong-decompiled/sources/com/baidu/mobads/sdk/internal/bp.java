package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1752a = "ContainerFactoryBuilder";
    private static IXAdContainerFactory e;
    private Context c;
    private Class<?> d;
    public double b = 0.1d;
    private bv f = bv.a();

    public void b() {
        e = null;
    }

    public bp(Class<?> cls, Context context) {
        this.d = null;
        this.d = cls;
        this.c = context;
    }

    public IXAdContainerFactory a() throws cb.a {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.d.getDeclaredConstructor(Context.class).newInstance(this.c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.am.bc, "9.450");
                e.initConfig(jSONObject);
                this.b = e.getRemoteVersion();
                e.onTaskDistribute(bd.f1741a, MobadsPermissionSettings.getPermissionInfo());
                e.initCommonModuleObj(t.a());
            } catch (Throwable th) {
                this.f.b(f1752a, th.getMessage());
                throw new cb.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }
}
