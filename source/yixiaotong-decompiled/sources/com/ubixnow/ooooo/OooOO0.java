package com.ubixnow.ooooo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OooOO0 extends o00O0O00 {
    private UMNCustomBannerAdapter OooO0oO;
    private OooO0OO OooO0oo;

    public OooOO0(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
    }

    public o00O0 OooO00o(UMNEcpmInfo uMNEcpmInfo) {
        o00O0 o00o0OooO00o = OooO00o("04");
        o00o0OooO00o.OooOOo = uMNEcpmInfo;
        OooO0O0("4");
        return o00o0OooO00o;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public o0O00o0 OooO00o(Context context) {
        if (this.OooO0oo == null) {
            this.OooO0oo = new OooO0OO(context);
        }
        return this.OooO0oo;
    }

    public oo00o OooO00o(ErrorInfo errorInfo) {
        OooO0OO oooO0OO = this.OooO0oo;
        if (oooO0OO != null) {
            return oooO0OO.OooO00o(this.OooO0Oo, errorInfo, true);
        }
        return null;
    }

    public void OooO00o(ViewGroup viewGroup, OooO0o oooO0o) {
        ooooO000.OooO0O0("Banner横幅展示广告");
        oo00o oo00oVar = this.OooO0Oo.OooOO0;
        if (oo00oVar != null) {
            this.OooO0oO = (UMNCustomBannerAdapter) oo00oVar.getAbsBaseAdapter();
            ((UMNCustomBannerAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter()).setEventListener(oooO0o);
            ((UMNCustomBannerAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter()).show(viewGroup);
        } else {
            if (oooO0o != null) {
                oooO0o.onShowError(new ErrorInfo(oOO00O0.ubix_cantShowSplash, oOO00O0.ubix_cantShowSplash_msg));
            }
            ooooO000.OooO0O0("Banner横幅未找到可以展示的广告");
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
        UMNCustomBannerAdapter uMNCustomBannerAdapter = this.OooO0oO;
        if (uMNCustomBannerAdapter != null) {
            uMNCustomBannerAdapter.destory();
        }
        super.OooO0OO();
    }

    public View OooO0oO() {
        try {
            if (this.OooO0oO == null) {
                this.OooO0oO = (UMNCustomBannerAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter();
            }
            ooooO000.OooO0O0("-----getBannerView", "manger: " + (this.OooO0oO != null));
            return this.OooO0oO.getView();
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean OooO0oo() {
        oo00o oo00oVar;
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 == null || (oo00oVar = o00o0.OooOO0) == null) {
            return false;
        }
        return ((UMNCustomBannerAdapter) oo00oVar.getAbsBaseAdapter()).isValid();
    }
}
