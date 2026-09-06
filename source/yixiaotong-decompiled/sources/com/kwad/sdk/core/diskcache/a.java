package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.c;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static void bP(final Context context) {
        i.schedule(new bi() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                d dVarEA;
                synchronized (a.class) {
                    try {
                        File fileEf = bg.ef(context);
                        if (!fileEf.exists()) {
                            return;
                        }
                        for (File file : a.n(fileEf)) {
                            if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.IH().dS(file.getAbsolutePath()) != null && a.a(context, file) != null && (dVarEA = c.Ey().EA()) != null) {
                                dVarEA.g(file);
                            }
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PackageInfo a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getPath(), 65);
                    try {
                        if (aa.getPackageInfo(context, packageArchiveInfo.packageName, 1) != null) {
                            return null;
                        }
                        return packageArchiveInfo;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<File> n(File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(fileArrListFiles));
        F(arrayList);
        return arrayList;
    }

    private static void F(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }

            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }
        });
    }
}
