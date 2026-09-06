package com.adprof.sdk;

import android.content.SharedPreferences;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f1426a;

    public static SharedPreferences a() {
        SharedPreferences sharedPreferences = f1426a;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = StubApp.getOrigApplicationContext(AdprofSdk.getInstance().getContext().getApplicationContext()).getSharedPreferences("adprof_data", 0);
        f1426a = sharedPreferences2;
        return sharedPreferences2;
    }

    public static Boolean a(String str, String str2) {
        SharedPreferences.Editor editorEdit = a().edit();
        editorEdit.putString(str, str2);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static String a(String str) {
        return a().getString(str, "");
    }
}
