package com.byazt.vm;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 54})
public abstract class ve<SERVICE> implements nu {
    public final String c;
    public tt<Boolean> tt = new tt<Boolean>() { // from class: com.byazt.vm.ve.1
        @Override // com.byazt.vm.tt
        /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
        public Boolean c(Object... objArr) {
            return Boolean.valueOf(x.c((Context) objArr[0], ve.this.c));
        }
    };

    public abstract Intent c(Context context);

    public abstract zm.tt<SERVICE, String> c();

    public ve(String str) {
        this.c = str;
    }

    @Override // com.byazt.vm.nu
    public boolean tt(Context context) {
        if (context == null) {
            return false;
        }
        return this.tt.tt(context).booleanValue();
    }

    @Override // com.byazt.vm.nu
    public nu.c ve(Context context) {
        return c((String) new zm(context, c(context), c()).c());
    }

    private nu.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        nu.c cVar = new nu.c();
        cVar.tt = str;
        return cVar;
    }
}
