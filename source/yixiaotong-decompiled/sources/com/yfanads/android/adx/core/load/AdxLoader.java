package com.yfanads.android.adx.core.load;

import android.content.Context;
import com.stub.StubApp;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.api.IAdxSDK;
import com.yfanads.android.adx.core.annotate.AdSdkDynamicApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean JR;
    private IAdxSDK alt;
    private Context mContext;

    /* JADX INFO: renamed from: com.yfanads.android.adx.core.load.AdxLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LoaderHold {
        private static final AdxLoader INSTANCE = new AdxLoader(null);

        private LoaderHold() {
        }
    }

    public /* synthetic */ AdxLoader(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void checkInitSDK(Context context) {
        AtomicBoolean atomicBoolean = AdxSDK.sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (AdxLoader.class) {
            if (!atomicBoolean.get()) {
                AdxSDK.init(context, AdxSdkConfig.create(SPManager.getString(context, "sdkconfig")));
            }
        }
    }

    public static AdxLoader get() {
        return LoaderHold.INSTANCE;
    }

    public static synchronized IAdxSDK load(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((AdSdkDynamicApi) IAdxSDK.class.getAnnotation(AdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (IAdxSDK) objInvoke;
    }

    public IAdxSDK init(Context context, ClassLoader classLoader) {
        if (!this.JR.get()) {
            this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.alt = load(classLoader);
            this.JR.set(true);
        }
        return this.alt;
    }

    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(this.mContext);
        return (T) this.alt.newInstance(cls);
    }

    private AdxLoader() {
        this.JR = new AtomicBoolean(false);
    }
}
