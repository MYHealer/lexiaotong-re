package com.ubixnow.ooooo;

import android.view.ViewGroup;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0000oo extends o0000O0 {
    public static final String OooO = "---o0000oo";
    public static final int OooOO0 = 5;
    public o00000OO OooOO0O;
    public o00000OO OooOO0o;
    public o000 OooOOO0;

    public class OooO00o extends o00000OO.OooO0O0 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            ooooO000.OooO0O0(o0000oo.OooO, "s_p=" + j);
            if (o0000oo.this.OooO00o(2)) {
                o0000oo.this.OooOO0O.OooO00o();
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            o0000oo.this.OooOO0O.OooO00o();
            o0000oo.this.OooOO0o();
        }
    }

    public class OooO0O0 extends o00000OO.OooO0O0 {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            ooooO000.OooO0O0(o0000oo.OooO, "d_p=" + j);
            if (o0000oo.this.OooO00o(2)) {
                o0000oo.this.OooOO0o.OooO00o();
                o0000oo.this.OooO();
            } else {
                o000 o000Var = o0000oo.this.OooOOO0;
                if (o000Var != null) {
                    o000Var.OooO00o(j + "秒后打开应用或详情页");
                }
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            o0000oo.this.OooOO0o.OooO00o();
            o0000oo.this.OooO();
            if (o0000oo.this.OooO00o(2)) {
                return;
            }
            o0000oo.this.OooOO0();
        }
    }

    public class OooO0OO implements o000.OooO0OO {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.o000.OooO0OO
        public void OooO00o() {
            o00000OO o00000oo = o0000oo.this.OooOO0o;
            if (o00000oo != null) {
                o00000oo.OooO00o();
            }
            o0000oo.this.OooO();
        }
    }

    public o0000oo(oo00o<UMNCustomRewardAdapter> oo00oVar) {
        super(oo00oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO() {
        try {
            o000 o000Var = this.OooOOO0;
            if (o000Var == null || !(o000Var.OooO0oo.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) this.OooOOO0.OooO0oo.getParent()).removeView(this.OooOOO0.OooO0oo);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOO0() {
        try {
            o0000.OooO00o oooO00o = this.OooO0o;
            if (oooO00o == null || oooO00o.getClickView() == null) {
                return;
            }
            this.OooO0o.getClickView().performClick();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    private void OooOO0O() {
        try {
            if (this.OooO0o != null) {
                o000 o000Var = new o000(BaseUtils.getContext(), this.OooO0o.getAppIconBitmap());
                this.OooOOO0 = o000Var;
                o000Var.OooO0oO = new OooO0OO();
                this.OooO0o.getPopWindowRoot().addView(this.OooOOO0.OooO0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOO0o() {
        if (this.OooOO0o != null || OooO00o(2)) {
            return;
        }
        OooOO0O();
        o00000OO o00000oo = new o00000OO(5L, new OooO0O0());
        this.OooOO0o = o00000oo;
        o00000oo.OooO0oO();
    }

    @Override // com.ubixnow.ooooo.o0000
    public synchronized void OooO0O0() {
        OooO0OO();
        super.OooO0O0();
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0OO() {
        OooO();
        o00000OO o00000oo = this.OooOO0O;
        if (o00000oo != null) {
            o00000oo.OooO00o();
        }
        o00000OO o00000oo2 = this.OooOO0o;
        if (o00000oo2 != null) {
            o00000oo2.OooO00o();
        }
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0o() {
        o0000.OooO00o oooO00o;
        super.OooO0o();
        if (this.OooOO0O == null && (oooO00o = this.OooO0o) != null) {
            o00000OO o00000oo = new o00000OO(oooO00o.getCountDownSeconds() - 5, new OooO00o());
            this.OooOO0O = o00000oo;
            o00000oo.OooO0oO();
        }
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0oO() {
        o00000OO o00000oo = this.OooOO0O;
        if (o00000oo != null) {
            o00000oo.OooO0Oo();
        }
        o00000OO o00000oo2 = this.OooOO0o;
        if (o00000oo2 != null) {
            o00000oo2.OooO0Oo();
        }
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0oo() {
        o00000OO o00000oo = this.OooOO0O;
        if (o00000oo != null) {
            o00000oo.OooO0o();
        }
        o00000OO o00000oo2 = this.OooOO0o;
        if (o00000oo2 != null) {
            o00000oo2.OooO0o();
        }
    }

    @Override // com.ubixnow.ooooo.o0000, com.ubixnow.adtype.nativead.api.UMNNativeEventListener
    public void onAdClicked() {
        super.onAdClicked();
        OooO0O0();
    }
}
