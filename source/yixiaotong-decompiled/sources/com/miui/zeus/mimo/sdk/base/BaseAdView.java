package com.miui.zeus.mimo.sdk.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.ai;
import com.miui.zeus.mimo.msa.IBinderViewCallBack;
import com.miui.zeus.mimo.sdk.ad.binder.RemoteAdViewProxy;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.CommonEventImpl;
import com.miui.zeus.mimo.sdk.z;
import com.stub.StubApp;
import ijiami_1011.NCall;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BaseAdView extends CommonEventImpl {
    private static final String TAG = null;
    private static String methodName;
    private static String packageName;
    private static int rooId;
    private boolean isMuted;
    public Activity mActivity;
    private Runnable mBinderViewRunnable;
    public View mRootView;
    private RemoteAdViewProxy mService;

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.base.BaseAdView$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5379a;
        public final /* synthetic */ MimoAdInfo b;
        public final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.base.BaseAdView$1$1, reason: invalid class name and collision with other inner class name */
        public class BinderC08591 extends IBinderViewCallBack.Stub {
            public BinderC08591() {
            }

            @Override // com.miui.zeus.mimo.msa.IBinderViewCallBack
            public void attachView(z zVar) {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL), this, zVar});
            }
        }

        public AnonymousClass1(Activity activity, MimoAdInfo mimoAdInfo, int i) {
            this.f5379a = activity;
            this.b = mimoAdInfo;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(TypedValues.PositionType.TYPE_CURVE_FIT), this});
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<z> f5380a;
        public final WeakReference<Activity> b;
        public final WeakReference<BaseAdView> c;
        public final MimoAdInfo d;
        public final int e;

        public a(Activity activity, z zVar, BaseAdView baseAdView, MimoAdInfo mimoAdInfo, int i) {
            this.b = new WeakReference<>(activity);
            this.f5380a = new WeakReference<>(zVar);
            this.c = new WeakReference<>(baseAdView);
            this.d = mimoAdInfo;
            this.e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{509, this});
        }
    }

    static {
        NCall.IV(new Object[]{Integer.valueOf(ai.u)});
    }

    public BaseAdView(Context context) {
        super(context);
        this.isMuted = false;
        this.mService = new RemoteAdViewProxy(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()));
    }

    private void createBinderView(Activity activity, MimoAdInfo mimoAdInfo, int i) {
        NCall.IV(new Object[]{495, this, activity, mimoAdInfo, Integer.valueOf(i)});
    }

    private void createRemoteView(Activity activity, String str, int i, String str2, MimoAdInfo mimoAdInfo, int i2) {
        NCall.IV(new Object[]{Integer.valueOf(ai.v), this, activity, str, Integer.valueOf(i), str2, mimoAdInfo, Integer.valueOf(i2)});
    }

    public void createLocalView(Activity activity, MimoAdInfo mimoAdInfo, int i) {
        NCall.IV(new Object[]{Integer.valueOf(ai.w), this, activity, mimoAdInfo, Integer.valueOf(i)});
    }

    public void destroy() {
        NCall.IV(new Object[]{Integer.valueOf(ai.x), this});
    }

    public View getRootView() {
        return (View) NCall.IL(new Object[]{Integer.valueOf(ai.y), this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public boolean isMuted() {
        return NCall.IZ(new Object[]{500, this});
    }

    public boolean onBackPressed() {
        return NCall.IZ(new Object[]{501, this});
    }

    public void onBinderViewSuccess(View view) {
        NCall.IV(new Object[]{502, this, view});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{503, this, th});
    }

    public void pause() {
        NCall.IV(new Object[]{504, this});
    }

    public void resume() {
        NCall.IV(new Object[]{505, this});
    }

    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, int i) {
        NCall.IV(new Object[]{Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_X), this, activity, mimoAdInfo, Integer.valueOf(i)});
    }

    public void setMute(boolean z) {
        NCall.IV(new Object[]{507, this, Boolean.valueOf(z)});
    }
}
