package com.opos.mobad.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.c.f;
import com.opos.mobad.model.data.AdItemData;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdActivity extends AdBaseActivity {
    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, com.opos.mobad.t.a aVar) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, "", 1));
            Bundle bundle = new Bundle();
            if (aVar != null) {
                bundle.putBinder("webCallback", aVar.asBinder());
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, String str4, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, str4, 2));
            Bundle bundle = new Bundle();
            if (aVar != null) {
                bundle.putBinder("webCallback", aVar.asBinder());
            }
            if (cVar != null) {
                bundle.putBinder("videoCallback", cVar.asBinder());
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static boolean a(Context context, ComplianceInfo complianceInfo, int i, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        if (context == null) {
            return false;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(complianceInfo, i));
            Bundle bundle = new Bundle();
            if (abstractBinderC0999a != null) {
                bundle.putBinder("webCallback", abstractBinderC0999a);
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return false;
        }
    }

    public static boolean a(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return a(context, complianceInfo, 4, abstractBinderC0999a);
    }

    public static boolean b(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return a(context, complianceInfo, 3, abstractBinderC0999a);
    }

    public static boolean c(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return a(context, complianceInfo, 5, abstractBinderC0999a);
    }

    protected com.opos.mobad.b a() {
        f fVarK = com.opos.mobad.c.b.k();
        if (fVarK == null || !fVarK.a()) {
            return null;
        }
        return new com.opos.mobad.c(this, fVarK.b(), fVarK.c(), fVarK.d(), fVarK.e(), fVarK.g(), new com.opos.mobad.e.b(StubApp.getOrigApplicationContext(getApplicationContext())));
    }

    @Override // com.opos.mobad.activity.AdBaseActivity
    protected void a(Intent intent) {
        a(a(), intent);
    }
}
