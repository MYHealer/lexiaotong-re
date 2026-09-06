package com.adprof.sdk;

import android.content.Context;
import android.renderscript.RenderScript;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RenderScript f1143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static e6 f233a;

    public static void a(Context context) {
        if (f233a != null) {
            return;
        }
        f233a = new e6();
        f1143a = RenderScript.create(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }
}
