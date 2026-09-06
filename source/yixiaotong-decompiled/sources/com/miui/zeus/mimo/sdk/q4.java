package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.api.AdRequest;
import com.miui.zeus.mimo.sdk.server.api.AdResponse;
import com.miui.zeus.mimo.sdk.server.http.Error;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRequest f5571a;
    public final /* synthetic */ r4 b;

    public q4(r4 r4Var, AdRequest adRequest) {
        this.b = r4Var;
        this.f5571a = adRequest;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0089 A[Catch: all -> 0x009d, Exception -> 0x009f, Merged into TryCatch #1 {all -> 0x009d, Exception -> 0x009f, blocks: (B:3:0x0002, B:5:0x0014, B:7:0x001e, B:9:0x0033, B:10:0x0038, B:11:0x0041, B:13:0x004a, B:15:0x0051, B:17:0x005f, B:20:0x0081, B:21:0x0083, B:23:0x0089, B:24:0x008e, B:18:0x0074, B:19:0x0079, B:29:0x00a0, B:31:0x00b8, B:32:0x00bd), top: B:38:0x0002 }] */
    @Override // java.lang.Runnable
    public void run() {
        String strA;
        p4 p4Var;
        try {
            l5<AdResponse> l5VarA = b.a().a(y8.f5752a, this.f5571a);
            if (l5VarA.b() && l5VarA.f5520a.a()) {
                r4 r4Var = this.b;
                this.f5571a.a();
                List<MimoAdInfo> listA = r4.a(r4Var, (s3) null, l5VarA.f5520a);
                p4 p4Var2 = this.f5571a.d;
                if (p4Var2 != null) {
                    ((BaseAdImpl.a) p4Var2).a(listA);
                }
                this.b.a(this.f5571a, l5VarA, true);
            } else {
                a7 a7Var = new a7();
                AdResponse adResponse = l5VarA.f5520a;
                if (adResponse == null || adResponse.b == 0) {
                    a7 a7Var2 = l5VarA.b;
                    a7Var.f5282a = a7Var2.f5282a;
                    strA = a7Var2.b;
                } else {
                    int i = adResponse.b;
                    String str = adResponse.c;
                    if (i == 300255) {
                        a7Var.f5282a = 2002;
                        strA = r4.a(this.b, this.f5571a.b(), this.f5571a.c);
                    } else {
                        a7Var.f5282a = i;
                        a7Var.b = str;
                    }
                    p4Var = this.f5571a.d;
                    if (p4Var != null) {
                        ((BaseAdImpl.a) p4Var).a(a7Var);
                    }
                    this.b.a(this.f5571a, l5VarA, false);
                }
                a7Var.b = strA;
                p4Var = this.f5571a.d;
                if (p4Var != null) {
                    ((BaseAdImpl.a) p4Var).a(a7Var);
                }
                this.b.a(this.f5571a, l5VarA, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            a7 a7Var3 = new a7(Error.CALLBACK.value(), e.getMessage());
            p4 p4Var3 = this.f5571a.d;
            if (p4Var3 != null) {
                ((BaseAdImpl.a) p4Var3).a(a7Var3);
            }
            this.b.a(this.f5571a, new l5<>(a7Var3, new i5(DiagnosisStep.KEY_EXCEPTION_WHEN_EXECUTE_AD_REQUEST, (String) null, e)), false);
        } finally {
            r4.a(this.b, this.f5571a);
        }
    }
}
