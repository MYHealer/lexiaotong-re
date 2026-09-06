package com.adprof.sdk;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h2 f1202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map f330a = new HashMap();

    public static d a(String str) {
        return (d) ((HashMap) f330a).get(str);
    }

    public static void a(d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.k())) {
            return;
        }
        ((HashMap) f330a).put(dVar.k(), dVar);
    }

    public static File[] a(File[] fileArr, long j, long j2) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        pk.a(String.format("clearCacheFileByDate files: %d t: %d", Integer.valueOf(fileArr.length), Long.valueOf(j2)));
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (File file : fileArr) {
            long j3 = j - j2;
            if (file.exists() && j3 > file.lastModified()) {
                file.delete();
                arrayList.remove(file);
                pk.a(String.format("file delete %s", file.getName()));
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public void a(d dVar, p5 p5Var) {
        if (p5Var != null) {
            pk.c("---------------cacheStart---------");
        }
        if (dVar == null) {
            pk.b("adUnit is null");
            if (p5Var != null) {
                p5Var.a((d) null, "adUnit is null");
                return;
            }
            return;
        }
        if (dVar.f190a.f1499a != 1) {
            File file = new File(dVar.m594a());
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
                if (p5Var != null) {
                    p5Var.a(dVar, (String) null);
                    return;
                }
                return;
            }
            h9 h9VarA = s8.a();
            q8 q8Var = new q8();
            q8Var.f674b = dVar.m594a();
            go goVar = dVar.f183a;
            q8Var.f672a = (goVar == null || TextUtils.isEmpty(goVar.f321a)) ? dVar.f204f : dVar.f183a.f321a;
            q8Var.f671a = p8.OTHER;
            q8Var.f673a = false;
            pk.c(String.format("not_exist downloadItem: %s", q8Var.toString()));
            h9VarA.a(q8Var, new g2(this, p5Var, dVar));
            return;
        }
        if (dVar.m605f() || dVar.f180a > 0) {
            File file2 = new File(dVar.m594a());
            pk.c(String.format("checking adFile: %s exists: %b", file2.getAbsolutePath(), Boolean.valueOf(file2.exists())));
            if (!file2.exists()) {
                h9 h9VarA2 = s8.a();
                q8 q8Var2 = new q8();
                q8Var2.f674b = dVar.m594a();
                go goVar2 = dVar.f183a;
                q8Var2.f672a = (goVar2 == null || TextUtils.isEmpty(goVar2.f321a)) ? dVar.f204f : dVar.f183a.f321a;
                q8Var2.f671a = p8.OTHER;
                q8Var2.f673a = false;
                pk.c(String.format("adfile not exists downloadItem: %s", q8Var2.toString()));
                h9VarA2.a(q8Var2, new f2(this, p5Var, dVar));
                return;
            }
            file2.setLastModified(System.currentTimeMillis());
            if (p5Var == null) {
                return;
            }
        } else if (p5Var == null) {
            return;
        }
        p5Var.a(dVar, (String) null);
    }
}
