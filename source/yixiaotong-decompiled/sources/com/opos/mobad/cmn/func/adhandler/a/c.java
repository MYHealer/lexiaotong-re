package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AppDownloadData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6769a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final com.opos.mobad.cmn.func.adhandler.b.a f;

    public c(AppDownloadData appDownloadData, String str, com.opos.mobad.cmn.func.adhandler.b.a aVar) {
        String strD;
        this.f = aVar;
        if (appDownloadData == null || TextUtils.isEmpty(appDownloadData.a()) || TextUtils.isEmpty(appDownloadData.c())) {
            strD = null;
            this.f6769a = null;
            this.b = null;
            this.c = null;
        } else {
            this.f6769a = appDownloadData.a();
            this.b = appDownloadData.c();
            this.c = appDownloadData.b();
            strD = appDownloadData.d();
        }
        this.d = strD;
        this.e = str;
    }

    public static c a(MaterialData materialData, com.opos.mobad.cmn.func.adhandler.b.a aVar) {
        return new c(materialData.K(), materialData.X(), aVar);
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f6769a) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 7;
    }
}
