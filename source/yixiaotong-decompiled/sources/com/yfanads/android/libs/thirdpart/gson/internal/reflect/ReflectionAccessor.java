package com.yfanads.android.libs.thirdpart.gson.internal.reflect;

import com.yfanads.android.libs.thirdpart.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        instance = JavaVersion.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
