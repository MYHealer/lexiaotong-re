package com.yfanads.android.libs.thirdpart.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    @Override // com.yfanads.android.libs.thirdpart.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
