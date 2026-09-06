package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.log.MspLog;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Long, CountDownLatch> f3471a;
    private final Object b;

    /* JADX INFO: renamed from: com.heytap.mspsdk.proxy.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.heytap.mspsdk.proxy.a$a, reason: collision with other inner class name */
    private static class C0422a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3472a = new a(null);
    }

    private a() {
        this.f3471a = new ConcurrentHashMap<>();
        this.b = new Object();
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        return C0422a.f3472a;
    }

    public <T> T a(Object obj, com.heytap.mspsdk.event.b bVar) {
        return (T) a(obj, bVar, null, null);
    }

    public <T> T a(Object obj, com.heytap.mspsdk.event.b bVar, Parcelable parcelable, Bundle bundle) {
        Class<?> cls;
        Class<?> cls2;
        if (obj == null) {
            throw new RuntimeException("The instance of 'target' is null");
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
            cls2 = cls;
        } else {
            cls = obj.getClass();
            Class<?>[] interfaces = obj.getClass().getInterfaces();
            if (interfaces == null || interfaces.length <= 0) {
                throw new RuntimeException("The instance of 'target' doesn't implement an interface, please add 'makeInterface=true' at your moudle's BridgeTarget annotation");
            }
            MspLog.iIgnore("ApiProxy", "interfaces length " + interfaces.length);
            for (Class<?> cls3 : interfaces) {
                MspLog.iIgnore("ApiProxy", "interfaces clazz name is " + cls3.getSimpleName());
            }
            cls2 = interfaces[0];
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new c(this, obj, parcelable, bundle, bVar));
    }

    public Object b() {
        return this.b;
    }

    public ConcurrentHashMap<Long, CountDownLatch> c() {
        return this.f3471a;
    }
}
