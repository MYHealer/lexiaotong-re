package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f3755a;
    private final Class<?> b;
    private final Object c;
    private boolean d;
    private boolean e;
    private boolean f;

    /* JADX INFO: renamed from: com.huawei.agconnect.core.Service$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Class<?> f3756a;
        Class<?> b;
        Object c;
        private boolean d;
        private boolean e;
        private boolean f;

        public Service build() {
            if (this.f3756a == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls = this.b;
            AnonymousClass1 anonymousClass1 = null;
            if (cls == null) {
                if (this.c == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service = new Service(this.f3756a, this.c, anonymousClass1);
                service.d = this.d;
                return service;
            }
            if (cls.isInterface() || !Modifier.isPublic(this.b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service2 = new Service((Class) this.f3756a, (Class) this.b, anonymousClass1);
            service2.d = this.d;
            service2.e = this.e;
            service2.f = this.f;
            return service2;
        }

        public Builder isAutoCreated(boolean z) {
            this.f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f3756a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f3755a = cls;
        this.b = cls2;
        this.c = null;
    }

    /* synthetic */ Service(Class cls, Class cls2, AnonymousClass1 anonymousClass1) {
        this((Class<?>) cls, (Class<?>) cls2);
    }

    private Service(Class<?> cls, Object obj) {
        this.f3755a = cls;
        this.b = null;
        this.c = obj;
    }

    /* synthetic */ Service(Class cls, Object obj, AnonymousClass1 anonymousClass1) {
        this((Class<?>) cls, obj);
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.c;
    }

    public Class<?> getInterface() {
        return this.f3755a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f;
    }

    public boolean isSharedInstance() {
        return this.e;
    }

    public boolean isSingleton() {
        return this.d;
    }
}
