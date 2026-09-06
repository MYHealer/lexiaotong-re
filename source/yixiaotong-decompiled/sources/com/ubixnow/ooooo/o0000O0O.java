package com.ubixnow.ooooo;

import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0000O0O extends o0000O0 {
    public static final String OooO = "---o0000O0O";
    public o00000OO OooOO0;
    public o00000OO OooOO0O;
    public o00000OO OooOO0o;
    public final o000O000 OooOOO;
    public long OooOOO0;

    public class OooO00o extends o00000OO.OooO0O0 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            ooooO000.OooO0O0(o0000O0O.OooO, "s_p=" + j);
            if (o0000O0O.this.OooO00o(2)) {
                o0000O0O.this.OooOO0.OooO00o();
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            o0000O0O.this.OooOO0.OooO00o();
            o0000O0O.this.OooOO0o();
        }
    }

    public class OooO0O0 extends o00000OO.OooO0O0 {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            ooooO000.OooO0O0(o0000O0O.OooO, "d_p=" + j);
            if (o0000O0O.this.OooO00o(2)) {
                OooO0O0();
            } else {
                o0000O0O.this.OooOOO.OooO00o("00:0" + j + "秒自动放弃，继续看视频");
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            o0000O0O.this.OooOO0O.OooO00o();
            o0000O0O.this.OooOO0();
        }
    }

    public class OooO0OO extends o00000OO.OooO0O0 {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            ooooO000.OooO0O0(o0000O0O.OooO, "r=" + j);
            if (o0000O0O.this.OooO()) {
                OooO0O0();
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            o0000O0O.this.OooO0O0();
        }
    }

    public o0000O0O(oo00o<UMNCustomRewardAdapter> oo00oVar) {
        super(oo00oVar);
        this.OooOOO = new o000O000();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OooO() {
        return this.OooOOO0 > 0 && SystemClock.elapsedRealtime() - this.OooOOO0 >= 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOO0() {
        try {
            FrameLayout frameLayout = this.OooOOO.OooO0oo;
            if (frameLayout == null || !(frameLayout.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    private void OooOO0O() {
        try {
            if (this.OooO0o != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(-1087953113);
                this.OooOOO.OooO0oo.setBackgroundDrawable(gradientDrawable);
                this.OooO0o.getPopWindowRoot().addView(this.OooOOO.OooO0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOO0o() {
        if (this.OooOO0O != null || OooO00o(2)) {
            return;
        }
        OooOO0O();
        o00000OO o00000oo = new o00000OO(5L, new OooO0O0());
        this.OooOO0O = o00000oo;
        o00000oo.OooO0oO();
    }

    @Override // com.ubixnow.ooooo.o0000
    public synchronized void OooO0O0() {
        OooO0OO();
        super.OooO0O0();
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0OO() {
        OooOO0();
        o00000OO o00000oo = this.OooOO0;
        if (o00000oo != null) {
            o00000oo.OooO00o();
        }
        o00000OO o00000oo2 = this.OooOO0O;
        if (o00000oo2 != null) {
            o00000oo2.OooO00o();
        }
        o00000OO o00000oo3 = this.OooOO0o;
        if (o00000oo3 != null) {
            o00000oo3.OooO00o();
        }
    }

    @Override // com.ubixnow.ooooo.o0000
    public View OooO0Oo() {
        return this.OooOOO.OooO00o();
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0o() {
        super.OooO0o();
        if (this.OooOO0 != null) {
            return;
        }
        o00000OO o00000oo = new o00000OO(2L, new OooO00o());
        this.OooOO0 = o00000oo;
        o00000oo.OooO0oO();
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0oO() {
        o00000OO o00000oo = this.OooOO0;
        if (o00000oo != null) {
            o00000oo.OooO0Oo();
        }
        o00000OO o00000oo2 = this.OooOO0O;
        if (o00000oo2 != null) {
            o00000oo2.OooO0Oo();
        }
    }

    @Override // com.ubixnow.ooooo.o0000
    public void OooO0oo() {
        o00000OO o00000oo = this.OooOO0;
        if (o00000oo != null) {
            o00000oo.OooO0o();
        }
        o00000OO o00000oo2 = this.OooOO0O;
        if (o00000oo2 != null) {
            o00000oo2.OooO0o();
        }
        if (OooO()) {
            OooO0O0();
        }
    }

    @Override // com.ubixnow.ooooo.o0000, com.ubixnow.adtype.nativead.api.UMNNativeEventListener
    public void onAdClicked() {
        super.onAdClicked();
        o00000OO o00000oo = this.OooOO0O;
        if (o00000oo != null) {
            o00000oo.OooO00o();
        }
        OooOO0();
        if (this.OooOO0o != null || this.OooOOO0 > 0) {
            return;
        }
        this.OooOOO0 = SystemClock.elapsedRealtime();
        o00000OO o00000oo2 = new o00000OO(5L, new OooO0OO());
        this.OooOO0o = o00000oo2;
        o00000oo2.OooO0oO();
    }
}
