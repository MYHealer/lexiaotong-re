package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.ActivatingData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.ApkSignerData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6767a;
    public final String b;
    public final List<ApkSignerData> c;
    public final int d;

    private a(ActivatingData activatingData) {
        int i;
        if (activatingData == null) {
            this.f6767a = null;
            this.b = null;
            this.c = null;
            i = -1;
        } else {
            this.f6767a = activatingData.f7182a;
            this.b = activatingData.b;
            this.c = activatingData.c;
            i = activatingData.d;
        }
        this.d = i;
    }

    public static a a(AdItemData adItemData) {
        return new a(adItemData.L());
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f6767a)) ? false : true;
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 16;
    }
}
