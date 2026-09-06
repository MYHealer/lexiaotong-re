package com.unionpay;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.utils.UPUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unionpay.a.d f9318a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    d(com.unionpay.a.d dVar, Context context, String str, String str2) {
        this.f9318a = dVar;
        this.b = context;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        try {
            com.unionpay.a.c cVar = new com.unionpay.a.c(this.f9318a, com.unionpay.utils.b.a(UPPayAssistEx.q()));
            if (cVar.a() == 0) {
                String strB = cVar.b();
                if (this.b == null || TextUtils.isEmpty(strB)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strB);
                String strA = com.unionpay.utils.i.a(jSONObject, "sign");
                String strA2 = com.unionpay.utils.i.a(jSONObject, "configs");
                if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) {
                    return;
                }
                try {
                    i = Integer.parseInt(this.c);
                } catch (Exception unused) {
                    i = 0;
                }
                String strB2 = com.unionpay.utils.b.b(UPUtils.a(new String(Base64.decode(strA2, 2)) + this.d));
                String strForConfig = UPUtils.forConfig(i, strA);
                if (TextUtils.isEmpty(strForConfig) || !strForConfig.equals(strB2)) {
                    return;
                }
                UPUtils.a(this.b, strB, "scan_configs");
                UPUtils.a(this.b, this.c, "scan_mode");
                UPUtils.a(this.b, this.d, "scan_random");
            }
        } catch (Exception unused2) {
        }
    }
}
