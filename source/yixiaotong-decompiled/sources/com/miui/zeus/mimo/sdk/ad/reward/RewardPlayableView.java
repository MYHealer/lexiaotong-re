package com.miui.zeus.mimo.sdk.ad.reward;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.b2;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.s.s.s;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPlayableView extends RewardView {
    private static final String TAG = s.d(new byte[]{55, 82, 65, 2, 74, 86, 49, 8, 7, Ascii.ESC, 80, 7, 9, 82, 96, 10, 93, 69}, "e76c82");
    private boolean isRegisterReceiver;
    private boolean jumpOut;
    private BroadcastReceiver mPlayableBroadcastReceiver;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b2 b2Var;
            if (RewardPlayableView.this.mAdInfo == null) {
                return;
            }
            try {
                String stringExtra = intent.getStringExtra(s.d(new byte[]{12, 7}, "ec1a20"));
                if (b.a(stringExtra, RewardPlayableView.this.mAdInfo.u + s.d(new byte[]{Base64.padSymbol}, "bcfa82") + RewardPlayableView.this.mAdInfo.d)) {
                    int intExtra = intent.getIntExtra(s.d(new byte[]{66, 65, 80, 16, 86}, "151d3a"), -1);
                    String stringExtra2 = intent.getStringExtra(s.d(new byte[]{92, 67, 87}, "1004a3"));
                    m.a(s.d(new byte[]{48, 0, Ascii.SYN, 89, SignedBytes.MAX_POWER_OF_TWO, 85, 49, 8, 7, Ascii.ESC, 80, 7, 14, 0, 55, 81, 87, 70}, "bea821"), s.d(new byte[]{91, 10, 51, 3, 5, 7, 8, Ascii.DC2, 3, 66, 88, 1, 14}, "4daffb") + stringExtra + s.d(new byte[]{Ascii.SYN, 16, Ascii.ETB, 0, 65, 6, 91}, "6cca5c") + intExtra + s.d(new byte[]{Ascii.DC2, 84, SignedBytes.MAX_POWER_OF_TWO, 1, 92}, "293ff3") + stringExtra2);
                    if (intExtra == 0) {
                        b2 b2Var2 = RewardPlayableView.this.eventListener;
                        if (b2Var2 != null) {
                            b2Var2.onAdPresent();
                        }
                    } else if (intExtra == 1) {
                        b2 b2Var3 = RewardPlayableView.this.eventListener;
                        if (b2Var3 != null) {
                            b2Var3.c(MimoAdError.ERROR_3010, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, new Throwable(stringExtra2)));
                        }
                    } else if (intExtra == 3) {
                        b2 b2Var4 = RewardPlayableView.this.eventListener;
                        if (b2Var4 != null) {
                            b2Var4.onGetReward(b.a(stringExtra2, 1));
                        }
                    } else if (intExtra == 2) {
                        b2 b2Var5 = RewardPlayableView.this.eventListener;
                        if (b2Var5 != null) {
                            b2Var5.onAdClick();
                        }
                    } else if (intExtra == 4 && (b2Var = RewardPlayableView.this.eventListener) != null) {
                        b2Var.onAdDismissed();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RewardPlayableView(Context context) {
        super(context);
        this.jumpOut = false;
        this.isRegisterReceiver = false;
        this.mPlayableBroadcastReceiver = new a();
    }

    private void finishActivity() {
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).finish();
    }

    private void registerPlayableReceiver() {
        if (this.isRegisterReceiver) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(s.d(new byte[]{1, 92, 14, Ascii.EM, 76, 13, 0, 11, 11, 11, Ascii.US, 8, 11, 94, 12, Ascii.EM, 100, 40, 32, Base64.padSymbol, 39, 32, 125, 32, Base64.padSymbol, 96, 55, 118, 96, 33}, "b3c74d"));
            if (Build.VERSION.SDK_INT >= 33) {
                this.mContext.registerReceiver(this.mPlayableBroadcastReceiver, intentFilter, 2);
            } else {
                this.mContext.registerReceiver(this.mPlayableBroadcastReceiver, intentFilter);
            }
            this.isRegisterReceiver = true;
        } catch (Exception e) {
            m.b(TAG, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 87, 94, 90, 16, 66, 4, Ascii.SYN, 52, 7, 82, 0, 91, 68, 92, 65}, "2293c6"), e);
        }
    }

    private void unregisterPlayableReceiver() {
        if (this.isRegisterReceiver) {
            try {
                this.mContext.unregisterReceiver(this.mPlayableBroadcastReceiver);
                this.isRegisterReceiver = false;
            } catch (Exception e) {
                m.b(TAG, s.d(new byte[]{19, 90, 66, 0, 5, 90, Ascii.DC2, 16, 3, 16, 99, 0, 5, 81, 89, 19, 7, 65}, "f40eb3"), e);
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardView, com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.c0
    public void destroy() {
        super.destroy();
        unregisterPlayableReceiver();
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardView, com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.z1
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.z1
    public void pause() {
        super.pause();
        this.jumpOut = true;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.z1
    public void resume() {
        super.resume();
        if (this.jumpOut) {
            finishActivity();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardView, com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.z1
    public void setAdInfo(MimoAdInfo mimoAdInfo) {
        this.mAdInfo = mimoAdInfo;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(s.d(new byte[]{89, 7, 12, 92}, "0dc2b5"), mimoAdInfo.A);
            jSONObject.put(s.d(new byte[]{4, 66, Ascii.SYN, 43, 84, 89, 4}, "e2fe54"), mimoAdInfo.i);
            jSONObject.put(s.d(new byte[]{94, 67, 44, 65, Ascii.DC2, 6, 5}, "70a4fc"), isMuted());
            Intent intent = new Intent(s.d(new byte[]{82, 86, 92, Ascii.DC4, 90, 8, 5, 74, 15, 12, 69, 0, 93, 76, Ascii.SYN, 7, 86, Ascii.NAK, 8, 11, 8, 76, 103, 44, 118, 111}, "388f5a"));
            intent.setData(Uri.parse(mimoAdInfo.p1));
            intent.putExtra(s.d(new byte[]{86, 81, 112, 89, 94, 9}, "75978f"), mimoAdInfo.G());
            StringBuilder sbAppend = new StringBuilder().append(s.d(new byte[]{68, Ascii.NAK, 95, 2, 15}, "1e6f22")).append(mimoAdInfo.u).append(s.d(new byte[]{16, 72, 3, 86, 88, 80, 6, 1, 40, 3, 92, 0, 11}, "68b531")).append(this.mContext.getPackageName()).append(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 66, 0, 68, 16, 88, 14, 10, 40, 3, 92, 0, 91}, "f4e6c1"));
            Context context = this.mContext;
            int i = f9.f5428a;
            PackageInfo packageInfoA = f9.a(context, context.getPackageName(), 0);
            StringBuilder sbAppend2 = sbAppend.append(packageInfoA != null ? packageInfoA.versionName : null).append(s.d(new byte[]{68, 71, 3, 68, 70, 94, 14, 10, 37, 13, 85, 0, 95}, "b1f657"));
            Context context2 = this.mContext;
            intent.putExtra(s.d(new byte[]{67, Ascii.DC2, 95, 5}, "6b6a6d"), sbAppend2.append(f9.a(context2, context2.getPackageName())).toString());
            intent.putExtra(s.d(new byte[]{0, 79, 120, 86, 80, 10}, "e7186e"), jSONObject.toString());
            this.mContext.startActivity(intent);
            registerPlayableReceiver();
        } catch (Exception e) {
            try {
                Context context3 = this.mContext;
                if (context3 != null) {
                    Toast.makeText(context3, s.d(new byte[]{-42, -13, -50, -46, -21, -98, -119, -53, -13, -123, -65, -52, -38, -62, -44, -34, -4, -108, -124, -40, -28, -121, -119, -35, Ascii.US, -117, -50, -128, -120, -79, -20, -116, -55, -9, 16}, "3ca7a6"), 0).show();
                }
            } catch (Exception unused) {
            }
            finishActivity();
            b2 b2Var = this.eventListener;
            if (b2Var != null) {
                b2Var.c(MimoAdError.ERROR_3009, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, e));
            }
        }
    }
}
