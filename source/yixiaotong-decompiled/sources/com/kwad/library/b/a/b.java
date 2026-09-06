package com.kwad.library.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.pangle.PluginClassLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> aDK;
    private final List<String> aDL;
    private final ClassLoader aDM;

    public b(ClassLoader classLoader, String str, File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aDM = classLoader;
        this.aDK = list;
        this.aDL = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i(PluginClassLoader.TAG, "mParent is " + classLoader.getClass().getName());
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        List<String> list = this.aDK;
        if (list != null && list.contains(str)) {
            Log.i(PluginClassLoader.TAG, "loadClass " + str + " from host by interface");
            return super.loadClass(str, z);
        }
        List<String> list2 = this.aDL;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e2) {
                e2.addSuppressed(e);
                throw e2;
            }
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String strFindLibrary = super.findLibrary(str);
        return (TextUtils.isEmpty(strFindLibrary) && (this.aDM instanceof BaseDexClassLoader)) ? ((BaseDexClassLoader) this.aDM).findLibrary(str) : strFindLibrary;
    }
}
