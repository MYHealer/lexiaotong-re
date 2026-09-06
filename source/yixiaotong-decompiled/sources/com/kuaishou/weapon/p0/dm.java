package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class dm {
    public static synchronized void a(ClassLoader classLoader, File file) {
        if (file != null) {
            if (file.exists()) {
                try {
                    d.b(classLoader, file);
                } catch (Throwable unused) {
                    b.b(classLoader, file);
                }
            }
        }
    }

    static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            String path = file.getPath();
            Field fieldA = Cdo.a(classLoader, "libPath");
            String strValueOf = String.valueOf(fieldA.get(classLoader));
            fieldA.set(classLoader, !TextUtils.isEmpty(strValueOf) ? strValueOf + com.huawei.openalliance.ad.constant.x.bQ + path : path);
            Field fieldA2 = Cdo.a(classLoader, "libraryPathElements");
            List list = (List) fieldA2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            fieldA2.set(classLoader, list);
        }
    }

    static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = Cdo.a(classLoader, "pathList").get(classLoader);
            Field fieldA = Cdo.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) fieldA.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            fieldA.set(obj, arrayList.toArray(new File[0]));
        }
    }

    static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = Cdo.a(classLoader, "pathList").get(classLoader);
            Field fieldA = Cdo.a(obj, "nativeLibraryDirectories");
            Collection arrayList = (List) fieldA.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList2.add(file);
            fieldA.set(obj, arrayList2);
            if (fieldA.get(obj) != arrayList2) {
                Cdo.b(obj, "nativeLibraryDirectories").set(obj, arrayList2);
            }
            List arrayList3 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object obj2 = (Object[]) Cdo.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field fieldA2 = Cdo.a(obj, "nativeLibraryPathElements");
            fieldA2.set(obj, obj2);
            if (fieldA2.get(obj) != obj2) {
                Cdo.b(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = Cdo.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) Cdo.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            Cdo.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) Cdo.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = Cdo.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) Cdo.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            Cdo.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) Cdo.a(obj, "makePathElements", List.class).invoke(obj, arrayList3));
        }
    }
}
