package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPlayablePBottomView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d3 extends j2 {
    public MimoAdInfo I;
    public AdMarkICP J;
    public RewardPlayablePBottomView K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public final Runnable P;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d3 d3Var;
            Runnable runnable;
            d3 d3Var2 = d3.this;
            long j = ((long) d3Var2.I.q1) * 1000;
            d3Var2.x = j;
            long j2 = d3Var2.j;
            try {
                if (j2 <= j) {
                    try {
                        d3.a(d3Var2, j2, j);
                        d3Var = d3.this;
                        long j3 = d3Var.j + 1000;
                        d3Var.j = j3;
                        if (j3 <= d3Var.x) {
                            runnable = d3Var.P;
                            d3Var.postDelayed(runnable, 1000L);
                        }
                    } catch (Exception e) {
                        m.b(ijiami_1011.s.s.s.d(new byte[]{101, 0, 66, 3, 67, 2, 49, 8, 7, Ascii.ESC, 80, 7, 91, 0, 101, 52, 88, 3, Ascii.SYN}, "7e5b1f"), ijiami_1011.s.s.s.d(new byte[]{97, 77, 6, 75, Ascii.CAN, Ascii.DC2, 17, 11, Ascii.NAK, 11, 69, 12, 95, 86, 67, 92, Ascii.EM, 81, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11}, "08c9a2"), e);
                        d3Var = d3.this;
                        if (d3Var.j <= d3Var.x) {
                            runnable = d3Var.P;
                        }
                    }
                }
            } catch (Throwable th) {
                d3 d3Var3 = d3.this;
                if (d3Var3.j <= d3Var3.x) {
                    d3Var3.postDelayed(d3Var3.P, 1000L);
                }
                throw th;
            }
        }
    }

    public d3(Context context) {
        super(context);
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = new a();
    }

    public static void a(d3 d3Var, long j, long j2) {
        d3Var.j = j;
        if (j2 > 0) {
            double d = j / j2;
            if (!d3Var.M && d >= 0.25d) {
                d3Var.M = true;
                MimoAdInfo mimoAdInfo = d3Var.I;
                String str = mimoAdInfo != null ? mimoAdInfo.u : null;
                String strValueOf = mimoAdInfo != null ? String.valueOf(mimoAdInfo.d) : null;
                MimoAdInfo mimoAdInfo2 = d3Var.I;
                b.a(str, strValueOf, mimoAdInfo2 != null ? mimoAdInfo2.e0 : null, ijiami_1011.s.s.s.d(new byte[]{72, 9, 7, 78, 112, 83, 50, 16, 7, 16, 69, 87, 13}, "8ef717"), ijiami_1011.s.s.s.d(new byte[]{3, 1, Ascii.DC4}, "14175b"), null, System.currentTimeMillis(), null, null);
            }
            if (!d3Var.N && d >= 0.5d) {
                d3Var.N = true;
                MimoAdInfo mimoAdInfo3 = d3Var.I;
                String str2 = mimoAdInfo3 != null ? mimoAdInfo3.u : null;
                String strValueOf2 = mimoAdInfo3 != null ? String.valueOf(mimoAdInfo3.d) : null;
                MimoAdInfo mimoAdInfo4 = d3Var.I;
                b.a(str2, strValueOf2, mimoAdInfo4 != null ? mimoAdInfo4.e0 : null, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 84, 83, Ascii.CAN, 39, 1, 50, 16, 7, 16, 69, 80, 82}, "b82afe"), ijiami_1011.s.s.s.d(new byte[]{13, 7, SignedBytes.MAX_POWER_OF_TWO}, "87e866"), null, System.currentTimeMillis(), null, null);
            }
            if (!d3Var.O && d >= 0.75d) {
                d3Var.O = true;
                MimoAdInfo mimoAdInfo5 = d3Var.I;
                String str3 = mimoAdInfo5 != null ? mimoAdInfo5.u : null;
                String strValueOf3 = mimoAdInfo5 != null ? String.valueOf(mimoAdInfo5.d) : null;
                MimoAdInfo mimoAdInfo6 = d3Var.I;
                b.a(str3, strValueOf3, mimoAdInfo6 != null ? mimoAdInfo6.e0 : null, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 85, 85, 65, 116, 81, 50, 16, 7, 16, 69, 82, 87}, "b94855"), ijiami_1011.s.s.s.d(new byte[]{5, 86, 16}, "2c5450"), null, System.currentTimeMillis(), null, null);
            }
        }
        String strValueOf4 = String.valueOf(Math.round(Math.round(Math.max(j2 - d3Var.j, 0L) / 1000.0d)));
        if (j >= j2) {
            d3Var.L = true;
            d3Var.c(1);
            d3Var.b();
            w3 w3Var = d3Var.g;
            if (w3Var != null) {
                w3Var.onVideoComplete();
            }
        }
        RewardPSkipCountDownView rewardPSkipCountDownView = d3Var.i;
        if (rewardPSkipCountDownView != null) {
            rewardPSkipCountDownView.d.setVisibility(0);
            rewardPSkipCountDownView.g.setVisibility(0);
            if (j <= j2) {
                d3Var.i.a(strValueOf4);
            } else if (d3Var.y) {
                d3Var.i.a();
                d3Var.i.h = true;
            } else {
                d3Var.i.a(String.valueOf(0));
            }
            d3Var.i.setVisibility(0);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(int i) {
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        this.J = (AdMarkICP) view.findViewById(a0.k2);
        this.K = (RewardPlayablePBottomView) view.findViewById(a0.O0);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public boolean a(int i, long j) {
        if (this.y || i == 4 || i == 3) {
            return true;
        }
        return i == 5 && !w6.a(getContext(), this.I);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public boolean c() {
        Class<?> cls;
        try {
            try {
                cls = Class.forName(ijiami_1011.s.s.s.d(new byte[]{84, 88, 94, 77, 91, 94, Ascii.DC4, 13, 72, 10, 72, 7, 69, 94, 87, 77, 81, 86, 12, 1, 72, 7, 73, 17, 82, 89, SignedBytes.MAX_POWER_OF_TWO, 10, 89, 89, 79, 48, Ascii.DC4, 11, 80, 9, 103, 91, 82, 26, 113, 86, 12, 1, 46, 7, 93, Ascii.NAK, 82, 69}, "773c67"));
            } catch (ClassNotFoundException unused) {
                cls = Class.forName(ijiami_1011.s.s.s.d(new byte[]{84, 14, 91, Ascii.FS, Ascii.GS, 8, 0, 11, 11, 11, Ascii.US, 8, 94, 15, 95, 85, 4, 12, 4, 74, Ascii.SYN, 14, 80, 17, 81, 14, 68, 95, 6, 14, 19, 1, 10, 11, 83, 75, 67, 19, 95, 83, 9, 17, 13, 5, Ascii.US, 76, 101, Ascii.ETB, 94, 0, 90, 98, 9, 0, Ascii.CAN, 35, 7, 15, 84, 45, 82, 13, 70, 87, Ascii.ETB}, "7a62ea"));
            }
            Object objInvoke = cls.getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{84, 85, 77, 113, 87, 67, Ascii.NAK, 5, 8, 1, 84}, "309890"), new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{89, 67, 46, 19, 70, 6, 5}, "00cf2c"), new Class[0]);
            declaredMethod.setAccessible(true);
            boolean zBooleanValue = ((Boolean) declaredMethod.invoke(objInvoke, new Object[0])).booleanValue();
            ImageView imageView = this.f5482a;
            if (imageView != null) {
                imageView.setSelected(zBooleanValue);
            }
            m.d(ijiami_1011.s.s.s.d(new byte[]{51, 82, 71, 88, Ascii.ETB, 7, 49, 8, 7, Ascii.ESC, 80, 7, 13, 82, 96, 111, 12, 6, Ascii.SYN}, "a709ec"), ijiami_1011.s.s.s.d(new byte[]{89, 67, 47, 67, Ascii.DC2, 80, 5, 94, 70}, "00b6f5") + zBooleanValue);
            return zBooleanValue;
        } catch (Exception e) {
            e.printStackTrace();
            m.b(ijiami_1011.s.s.s.d(new byte[]{49, 82, Ascii.DC2, 81, 70, 2, 49, 8, 7, Ascii.ESC, 80, 7, 15, 82, 53, 102, 93, 3, Ascii.SYN}, "c7e04f"), ijiami_1011.s.s.s.d(new byte[]{36, 66, 17, 88, 75, Ascii.ETB, 2, 12, 3, 1, 90, 12, 15, 87, 67, 90, 76, 67, 4, 68, Ascii.NAK, Ascii.SYN, 80, 17, Ascii.DC4, 67}, "a0c797"), e);
            return false;
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public boolean d() {
        return false;
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        DownloadButtonICP downloadButtonICP;
        super.destroy();
        RewardPlayablePBottomView rewardPlayablePBottomView = this.K;
        if (rewardPlayablePBottomView == null || (downloadButtonICP = rewardPlayablePBottomView.f) == null) {
            return;
        }
        downloadButtonICP.b();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        View[] viewArr = new View[1];
        RewardPlayablePBottomView rewardPlayablePBottomView = this.K;
        viewArr[0] = rewardPlayablePBottomView == null ? null : rewardPlayablePBottomView.getDownloadButton();
        return viewArr;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.K;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.j3;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void h() {
        e2 e2Var = this.e;
        if (e2Var != null) {
            e2Var.dismiss();
            this.e = null;
        }
        RewardPlayablePBottomView rewardPlayablePBottomView = this.K;
        if (rewardPlayablePBottomView != null) {
            rewardPlayablePBottomView.setDrawerViewExpanded(false);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void i() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.c();
        }
        m();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void j() {
        w3 w3Var;
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
        Runnable runnable = this.P;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.L || (w3Var = this.g) == null) {
            return;
        }
        w3Var.onVideoPause();
    }

    public final void m() {
        w3 w3Var;
        Runnable runnable = this.P;
        if (runnable != null) {
            removeCallbacks(runnable);
            post(this.P);
        }
        if (this.L || (w3Var = this.g) == null) {
            return;
        }
        w3Var.onVideoResume();
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        w3 w3Var;
        super.pause();
        Runnable runnable = this.P;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.L || (w3Var = this.g) == null) {
            return;
        }
        w3Var.onVideoPause();
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        super.resume();
        m();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00d2 A[PHI: r12 r13
  0x00d2: PHI (r12v12 com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView) = 
  (r12v11 com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView)
  (r12v15 com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView)
 binds: [B:24:0x00d0, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
  0x00d2: PHI (r13v12 java.lang.String) = (r13v11 java.lang.String), (r13v14 java.lang.String) binds: [B:24:0x00d0, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        RewardPSkipCountDownView rewardPSkipCountDownView;
        String strD;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        this.I = mimoAdInfo;
        this.i.setVisibility(0);
        AdMarkICP adMarkICP = this.J;
        MimoAdInfo mimoAdInfo2 = this.I;
        adMarkICP.f5687a.setText(mimoAdInfo2.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo2, this));
        this.K.a(this.I, w3Var, this);
        post(this.P);
        MimoAdInfo mimoAdInfo3 = this.I;
        String str = mimoAdInfo3 != null ? mimoAdInfo3.u : null;
        String strValueOf = mimoAdInfo3 != null ? String.valueOf(mimoAdInfo3.d) : null;
        MimoAdInfo mimoAdInfo4 = this.I;
        b.a(str, strValueOf, mimoAdInfo4 != null ? mimoAdInfo4.e0 : null, ijiami_1011.s.s.s.d(new byte[]{68, 8, 5, 74, 112, 85, 50, 16, 7, 16, 69}, "4dd311"), ijiami_1011.s.s.s.d(new byte[]{19, 8, 89, 78, 120, 82, 50, 16, 7, 16, 69}, "cd8796"), null, System.currentTimeMillis(), null, null);
        if (w6.a(getContext(), this.I)) {
            rewardPSkipCountDownView = this.i;
            String strD2 = ijiami_1011.s.s.s.d(new byte[]{-40, -103, -89, -124, -67, -53}, "062c3b");
            strD = ijiami_1011.s.s.s.d(new byte[]{-48, -106, -91, -126, -67, -94, -121, -19, -11, -121, -115, -27, -46, -120, -120, -127, -92, -66, -124, -38, -15}, "717d54");
            rewardPSkipCountDownView.getClass();
            if (b.h(strD2)) {
                rewardPSkipCountDownView.e.setText(strD2);
            }
            if (b.h(strD)) {
                rewardPSkipCountDownView.f.setText(strD);
            }
        } else {
            rewardPSkipCountDownView = this.i;
            String strD3 = ijiami_1011.s.s.s.d(new byte[]{-116, -54, -91, -125, -68, -56}, "de0d2a");
            strD = ijiami_1011.s.s.s.d(new byte[]{-127, -109, -13, -34, -65, -16, -124, -54, -17, -118, -110, -32, -125, -115, -34, -35, -90, -20, -124, -38, -15}, "f4a87f");
            rewardPSkipCountDownView.getClass();
            if (b.h(strD3)) {
                rewardPSkipCountDownView.e.setText(strD3);
            }
            if (b.h(strD)) {
                rewardPSkipCountDownView.f.setText(strD);
            }
        }
        setMute(w3Var.isMuted());
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void setMute(boolean z) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName(ijiami_1011.s.s.s.d(new byte[]{82, 90, 12, 75, 92, 81, Ascii.DC4, 13, 72, 10, 72, 7, 67, 92, 5, 75, 86, 89, 12, 1, 72, 7, 73, 17, 84, 91, Ascii.DC2, 12, 94, 86, 79, 48, Ascii.DC4, 11, 80, 9, 97, 89, 0, Ascii.FS, 118, 89, 12, 1, 46, 7, 93, Ascii.NAK, 84, 71}, "15ae18"));
            } catch (ClassNotFoundException unused) {
                cls = Class.forName(ijiami_1011.s.s.s.d(new byte[]{81, 11, 15, Ascii.SYN, 72, 12, 0, 11, 11, 11, Ascii.US, 8, 91, 10, 11, 95, 81, 8, 4, 74, Ascii.SYN, 14, 80, 17, 84, 11, 16, 85, 83, 10, 19, 1, 10, 11, 83, 75, 70, Ascii.SYN, 11, 89, 92, Ascii.NAK, 13, 5, Ascii.US, 76, 101, Ascii.ETB, 91, 5, 14, 104, 92, 4, Ascii.CAN, 35, 7, 15, 84, 45, 87, 8, Ascii.DC2, 93, 66}, "2db80e"));
            }
            Object objInvoke = cls.getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{87, 93, 67, 113, 86, Ascii.DC2, Ascii.NAK, 5, 8, 1, 84}, "08788a"), new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 84, 77, 121, Ascii.DC4, 76, 4}, "e194a8"), Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(objInvoke, Boolean.valueOf(z));
            ImageView imageView = this.f5482a;
            if (imageView != null) {
                imageView.setSelected(!z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
