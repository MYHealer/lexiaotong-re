package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiagnosisStep f5528a;
    public String b;
    public int c;
    public String d;

    public static m4 a(DiagnosisStep diagnosisStep, MimoAdError mimoAdError) {
        m4 m4Var = new m4();
        m4Var.f5528a = diagnosisStep;
        m4Var.c = mimoAdError.ERROR_CODE;
        m4Var.d = mimoAdError.ERROR_MSG;
        return m4Var;
    }

    public static m4 a(DiagnosisStep diagnosisStep, String str) {
        m4 m4Var = new m4();
        m4Var.f5528a = diagnosisStep;
        m4Var.b = str;
        return m4Var;
    }

    public static m4 a(DiagnosisStep diagnosisStep, Throwable th) {
        m4 m4Var = new m4();
        m4Var.f5528a = diagnosisStep;
        String stackTraceString = Log.getStackTraceString(th);
        if (TextUtils.isEmpty(stackTraceString)) {
            stackTraceString = th.getMessage();
        }
        if (!TextUtils.isEmpty(stackTraceString)) {
            stackTraceString = "    " + stackTraceString;
        }
        m4Var.b = stackTraceString;
        return m4Var;
    }
}
