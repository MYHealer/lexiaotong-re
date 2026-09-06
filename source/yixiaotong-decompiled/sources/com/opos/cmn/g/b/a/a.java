package com.opos.cmn.g.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.an.transactivity.api.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6163a;

    public a(String str) {
        this.f6163a = str;
    }

    @Override // com.opos.cmn.an.transactivity.api.b, com.opos.cmn.an.transactivity.a.a
    public void a(Activity activity, Bundle bundle) {
        if (activity != null) {
            try {
                try {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "marketUrl:" + this.f6163a);
                    com.opos.cmn.g.b.b.a.a((Context) activity, this.f6163a);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "onCreate", e);
                }
            } finally {
                activity.finish();
            }
        }
    }
}
