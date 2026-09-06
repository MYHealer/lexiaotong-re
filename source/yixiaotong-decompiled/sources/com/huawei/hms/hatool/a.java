package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z0 f4069a;

    private static synchronized z0 a() {
        if (f4069a == null) {
            f4069a = q.c().b();
        }
        return f4069a;
    }

    public static void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f4069a.a(i, str, linkedHashMap);
        } else {
            v.d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f4069a.a(context, str, str2);
        }
    }

    public static void b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f4069a.b(i, str, linkedHashMap);
        } else {
            v.d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    public static boolean b() {
        return q.c().a();
    }

    public static void c() {
        if (a() == null || !q1.b().a()) {
            return;
        }
        f4069a.a(-1);
    }
}
