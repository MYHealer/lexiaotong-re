package com.oplus.instant.router.callback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.g.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5771a;
    private String b;
    private Callback c;

    public c(Context context, String str, Callback callback) {
        this.f5771a = context;
        this.b = str;
        this.c = callback;
    }

    private String a(String str) {
        return str.replace("hap://app/", "hap://on_stack/");
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        String str;
        StringBuilder sb;
        if (this.c == null) {
            return;
        }
        if (this.f5771a instanceof Activity) {
            if (response.f5769a == 1) {
                Intent intent = new Intent("android.intent.action.instant.on_stack", Uri.parse(a(this.b)));
                intent.putExtra("in_one_task", "1");
                if (intent.resolveActivity(this.f5771a.getPackageManager()) != null) {
                    sb = new StringBuilder("req_uri: ");
                } else {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                    if (intent.resolveActivity(this.f5771a.getPackageManager()) != null) {
                        sb = new StringBuilder("req_uri: ");
                    } else {
                        response.f5769a = 200;
                        str = "QuickApp is not support";
                    }
                }
                d.a("OneTaskCallback", sb.append(intent.getDataString()).toString());
                this.f5771a.startActivity(intent);
            }
            this.c.onResponse(response);
        }
        response.f5769a = 200;
        str = "context is not activity";
        response.b = str;
        this.c.onResponse(response);
    }
}
