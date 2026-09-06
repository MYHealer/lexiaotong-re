package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Context;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00000O extends o00O0O00 {
    private o000000O OooO0oO;
    private UMNCustomRewardAdapter OooO0oo;

    public o00000O(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
    }

    public o00O0 OooO00o(UMNEcpmInfo uMNEcpmInfo) {
        o00O0 o00o0OooO00o = OooO00o("03");
        o00o0OooO00o.OooOOo = uMNEcpmInfo;
        OooO0O0("3");
        return o00o0OooO00o;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public o0O00o0 OooO00o(Context context) {
        if (this.OooO0oO == null) {
            this.OooO0oO = new o000000O(context);
        }
        return this.OooO0oO;
    }

    public oo00o OooO00o(ErrorInfo errorInfo) {
        o000000O o000000o = this.OooO0oO;
        if (o000000o != null) {
            return o000000o.OooO00o(this.OooO0Oo, errorInfo, true);
        }
        return null;
    }

    public void OooO00o(Activity activity, o00000 o00000Var) {
        ooooO000.OooO0O0("showAd 激励视频");
        oo00o oo00oVar = this.OooO0Oo.OooOO0;
        if (oo00oVar == null) {
            if (o00000Var != null) {
                o00000Var.onShowError(new ErrorInfo(oOO00O0.ubix_cantShowSplash, oOO00O0.ubix_cantShowSplash_msg));
            }
            ooooO000.OooO0O0("激励视频广告未找到可以展示的广告");
        } else {
            UMNCustomRewardAdapter uMNCustomRewardAdapter = (UMNCustomRewardAdapter) oo00oVar.getAbsBaseAdapter();
            this.OooO0oo = uMNCustomRewardAdapter;
            uMNCustomRewardAdapter.setEventListener(o00000Var);
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
        UMNCustomRewardAdapter uMNCustomRewardAdapter = this.OooO0oo;
        if (uMNCustomRewardAdapter != null) {
            uMNCustomRewardAdapter.destory();
        }
    }

    public boolean OooO0oO() {
        oo00o oo00oVar;
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 == null || (oo00oVar = o00o0.OooOO0) == null) {
            return false;
        }
        return ((UMNCustomRewardAdapter) oo00oVar.getAbsBaseAdapter()).isValid();
    }
}
