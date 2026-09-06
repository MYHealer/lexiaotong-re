package com.ubixnow.ooooo;

import android.content.Context;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAdapter;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0ooOOo extends o00O0O00 {
    private o0Oo0oo OooO0oO;

    public o0ooOOo(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
    }

    public o00O0 OooO00o(UMNEcpmInfo uMNEcpmInfo) {
        o00O0 o00o0OooO00o = OooO00o("3");
        o00o0OooO00o.OooOOo = uMNEcpmInfo;
        OooO0O0("2");
        BaseDevConfig baseDevConfig = this.OooO00o;
        if (baseDevConfig instanceof UMNNativeParams) {
            this.OooO0Oo.OooO0Oo.OooO0OO = ((UMNNativeParams) baseDevConfig).adStyle;
        }
        return o00o0OooO00o;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public o0O00o0 OooO00o(Context context) {
        if (this.OooO0oO == null) {
            this.OooO0oO = new o0Oo0oo(context);
        }
        return this.OooO0oO;
    }

    public oo00o OooO00o(ErrorInfo errorInfo) {
        o0Oo0oo o0oo0oo = this.OooO0oO;
        if (o0oo0oo != null) {
            return o0oo0oo.OooO00o(this.OooO0Oo, errorInfo, true);
        }
        return null;
    }

    public void OooO00o(o00O00o0 o00o00o0, UMNNativeParams uMNNativeParams) {
        o00O0 o00o0 = this.OooO0Oo;
        o00o0.OooO0Oo.OooO0OO = uMNNativeParams.adStyle;
        o00o0.OooOOOo = o00o00o0;
        int iOooO00o = oOo00o00.OooO00o(this.OooO0Oo.OooO0Oo.OooO00o.slotId + oO00000o.o00000O0.OooO0oo, 0);
        BaseDevConfig baseDevConfig = this.OooO0Oo.OooO0Oo.OooO00o;
        o00o00o0.startCountDown(iOooO00o, baseDevConfig != null ? baseDevConfig.timeout : 0);
        OooO0o();
        super.OooO0O0();
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public void OooO0OO() {
        super.OooO0OO();
    }

    public void OooO0o() {
    }

    public boolean OooO0oO() {
        oo00o oo00oVar;
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 == null || (oo00oVar = o00o0.OooOO0) == null) {
            return false;
        }
        return ((UMNCustomNativeAdapter) oo00oVar.getAbsBaseAdapter()).isValid();
    }
}
