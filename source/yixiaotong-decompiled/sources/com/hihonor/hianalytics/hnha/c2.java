package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class c2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3630a;
    private String b;

    public c2(Context context, String str) {
        this.f3630a = context;
        this.b = str;
    }

    private String a(Context context) {
        return v1.d(context, "cached");
    }

    private void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = com.hihonor.hianalytics.util.p.c(str).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private void a(b2 b2Var, String str, String str2) {
        b2Var.b(str, this.b);
        b2Var.a(str2, this.b);
        b2Var.a(this.b);
    }

    private void a(String str, String str2, String str3) {
        a(new d2(), str, str3);
        a(new e2(), str2, str3);
    }

    private void b(Context context) {
        v1.b(context, "cached");
    }

    private void c(Context context) {
        a(context, "state");
        a(context, "sessioncontext");
        a(context, "flag");
        b(context);
    }

    public void a() throws IllegalAccessException, InvocationTargetException {
        String strA = com.hihonor.hianalytics.util.p.a("state", "events", "");
        String strA2 = com.hihonor.hianalytics.util.p.a("state", "activities", "");
        String strA3 = a(this.f3630a);
        c(this.f3630a);
        if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2) && TextUtils.isEmpty(strA3)) {
            j2.c("V1CompatibleReportTask", "checkAndReportV1Data: No cached V1 data found.");
        } else {
            a(strA, strA2, strA3);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, InvocationTargetException {
        a();
    }
}
