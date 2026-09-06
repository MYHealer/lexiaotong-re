package com.baidu.mobads.sdk.internal;

import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bq extends DexClassLoader {
    public bq(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            Class<?> clsFindClass = findClass(str);
            if (clsFindClass != null) {
                return clsFindClass;
            }
        } catch (ClassNotFoundException e) {
            az.e("XAdDexClassLoader", "loadClass failed: " + e.getMessage());
        }
        return super.loadClass(str, z);
    }
}
