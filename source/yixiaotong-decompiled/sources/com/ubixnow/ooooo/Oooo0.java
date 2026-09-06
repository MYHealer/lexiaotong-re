package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Context;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Oooo0 extends o00O0O00 {
    private OooOo00 OooO0oO;
    private UMNCustomInterstitalAdapter OooO0oo;

    public Oooo0(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
    }

    public o00O0 OooO00o(UMNEcpmInfo uMNEcpmInfo) {
        o00O0 o00o0OooO00o = OooO00o("5");
        o00o0OooO00o.OooOOo = uMNEcpmInfo;
        OooO0O0("5");
        return o00o0OooO00o;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public o0O00o0 OooO00o(Context context) {
        if (this.OooO0oO == null) {
            this.OooO0oO = new OooOo00(context);
        }
        return this.OooO0oO;
    }

    public oo00o OooO00o(ErrorInfo errorInfo) {
        OooOo00 oooOo00 = this.OooO0oO;
        if (oooOo00 != null) {
            return oooOo00.OooO00o(this.OooO0Oo, errorInfo, true);
        }
        return null;
    }

    public void OooO00o(Activity activity, OooOo oooOo) {
        ooooO000.OooO0O0("插屏展示广告");
        oo00o oo00oVar = this.OooO0Oo.OooOO0;
        if (oo00oVar == null) {
            if (oooOo != null) {
                oooOo.onShowError(new ErrorInfo(oOO00O0.ubix_cantShowIntertital, oOO00O0.ubix_cantShowIntertital_msg).setInfo((Object) this.OooO0Oo.OooOO0));
            }
            ooooO000.OooO0O0("插屏广告未找到可以展示的广告");
        } else {
            UMNCustomInterstitalAdapter uMNCustomInterstitalAdapter = (UMNCustomInterstitalAdapter) oo00oVar.getAbsBaseAdapter();
            this.OooO0oo = uMNCustomInterstitalAdapter;
            uMNCustomInterstitalAdapter.setEventListener(oooOo);
            this.OooO0oo.show(activity);
        }
    }

    public void OooO00o(o00O00o0 o00o00o0) {
        o00O0 o00o0 = this.OooO0Oo;
        o00o0.OooO0Oo.OooO0OO = 2;
        o00o0.OooOOOo = o00o00o0;
        int iOooO00o = oOo00o00.OooO00o(this.OooO0Oo.OooO0Oo.OooO00o.slotId + oO00000o.o00000O0.OooO0oo, 0);
        BaseDevConfig baseDevConfig = this.OooO0Oo.OooO0Oo.OooO00o;
        o00o00o0.startCountDown(iOooO00o, baseDevConfig != null ? baseDevConfig.timeout : 0);
        super.OooO0O0();
    }

    public void OooO0o() {
        this.OooO0O0 = null;
        UMNCustomInterstitalAdapter uMNCustomInterstitalAdapter = this.OooO0oo;
        if (uMNCustomInterstitalAdapter != null) {
            uMNCustomInterstitalAdapter.destory();
        }
    }

    public boolean OooO0oO() {
        oo00o oo00oVar;
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 == null || (oo00oVar = o00o0.OooOO0) == null) {
            return false;
        }
        return ((UMNCustomInterstitalAdapter) oo00oVar.getAbsBaseAdapter()).isValid();
    }
}
