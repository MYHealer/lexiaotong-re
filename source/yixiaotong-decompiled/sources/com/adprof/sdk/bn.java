package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qm f147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xl f148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f149a = false;

    public bn(Context context, wd wdVar, d dVar) {
        String str;
        this.f1095a = dVar;
        xl xlVar = (xl) dVar.m590a();
        this.f148a = xlVar;
        String strA = xlVar.a();
        if (TextUtils.isEmpty(strA)) {
            str = "nativeTemplateId is null";
        } else {
            strA.getClass();
            if (strA.equals("2002001")) {
                this.f147a = new an(context, wdVar, dVar, this.f148a);
                return;
            }
            str = "nativeTemplateId is not find";
        }
        a(str);
    }

    public final void a(String str) {
        if (this.f149a) {
            return;
        }
        this.f149a = true;
        HashMap map = new HashMap();
        map.put("error", str);
        s5.a(this.f1095a.k(), map, "action.splash.play.error", 0);
    }
}
