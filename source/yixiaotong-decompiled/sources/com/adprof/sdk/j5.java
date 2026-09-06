package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class j5 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f1243a = true;

    public static Intent a(Context context, Class cls, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra("ad_view_clz_name", str2);
        intent.putExtra("adUnit_requestId_key", str);
        int requestedOrientation = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : 3;
        if (requestedOrientation != 7 && requestedOrientation != 6) {
            requestedOrientation = h8.b() > h8.m641a() ? 6 : 7;
        }
        intent.putExtra("REQUESTED_ORIENTATION", requestedOrientation);
        intent.putExtra("broadcastIdentifier", str);
        return intent;
    }

    public static void a(Context context, Class cls, d dVar, String str) {
        Intent intentA = a(context, cls, dVar.k(), "LandingPage");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key_adunit_uuid", dVar.k());
            bundle.putString("key_detail_url", str);
            intentA.putExtras(bundle);
            h2.a(dVar);
            context.startActivity(intentA);
        } catch (Throwable th) {
            new HashMap().put("error", th.getMessage());
        }
    }
}
