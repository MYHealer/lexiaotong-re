package com.miui.zeus.mimo.sdk.ad.banner;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.BannerAd;
import com.miui.zeus.mimo.sdk.b0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c0;
import com.miui.zeus.mimo.sdk.f7;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;
import com.stub.StubApp;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BannerUIController implements b0, f7.a, BannerAd.BannerDownloadListener {
    private static final String TAG = null;
    private Activity mActivity;
    private MimoAdInfo mAdInfo;
    private r3 mBannerDownloadListener;
    private float mBannerViewScale;
    private ViewGroup mContainer;
    private final Context mContext;
    private c0 mCurrentAdView;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private AdImpressMonitor mImpressMonitor;
    private e mInteractionEventListener;
    private boolean mIsUpdateView;
    private String mPrice;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5287a;
        public final /* synthetic */ MimoAdInfo b;

        public a(Activity activity, MimoAdInfo mimoAdInfo) {
            this.f5287a = activity;
            this.b = mimoAdInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME), this});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MimoAdInfo f5288a;

        public b(MimoAdInfo mimoAdInfo) {
            this.f5288a = mimoAdInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS), this});
        }
    }

    public class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f5289a;

        public c(c0 c0Var) {
            this.f5289a = c0Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            NCall.IV(new Object[]{276, this, animator});
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NCall.IV(new Object[]{277, this, animator});
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            NCall.IV(new Object[]{278, this, animator});
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS), this, animator});
        }
    }

    public class d implements AdImpressMonitor.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f5290a;

        public d(c0 c0Var) {
            this.f5290a = c0Var;
        }

        @Override // com.miui.zeus.mimo.sdk.view.AdImpressMonitor.a
        public void onAdShow() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS), this});
        }
    }

    public interface e extends BannerAd.BannerInteractionListener {
    }

    static {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN)});
    }

    public BannerUIController(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void addView(c0 c0Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL), this, c0Var});
    }

    private f7 getEmptyView(ViewGroup viewGroup) {
        return (f7) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS), this, viewGroup});
    }

    private void notifyViewClicked() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS), this});
    }

    private void notifyViewDismissed() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER), this});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewShown(View view) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL), this, view});
    }

    private void performSwitchAnimation(c0 c0Var) {
        NCall.IV(new Object[]{286, this, c0Var});
    }

    public void destroy() {
        NCall.IV(new Object[]{287, this});
    }

    public ViewGroup getContainer() {
        return (ViewGroup) NCall.IL(new Object[]{288, this});
    }

    public boolean isStartBtnDownLoad() {
        return NCall.IZ(new Object[]{289, this});
    }

    @Override // com.miui.zeus.mimo.sdk.b0
    public void onClickCloseView() {
        NCall.IV(new Object[]{290, this});
    }

    @Override // com.miui.zeus.mimo.sdk.b0
    public void onClicked() {
        NCall.IV(new Object[]{291, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadCancel() {
        NCall.IV(new Object[]{292, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadFailed(int i) {
        NCall.IV(new Object[]{293, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadFinished() {
        NCall.IV(new Object[]{294, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadPaused() {
        NCall.IV(new Object[]{295, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadProgressUpdated(int i) {
        NCall.IV(new Object[]{296, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onDownloadStarted() {
        NCall.IV(new Object[]{297, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onInstallFailed(int i) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX), this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onInstallStart() {
        NCall.IV(new Object[]{299, this});
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerDownloadListener, com.miui.zeus.mimo.sdk.r3
    public void onInstallSuccess() {
        NCall.IV(new Object[]{300, this});
    }

    public void onPause() {
        NCall.IV(new Object[]{301, this});
    }

    public void onResume() {
        NCall.IV(new Object[]{302, this});
    }

    @Override // com.miui.zeus.mimo.sdk.f7.a
    public void onViewAttached() {
        NCall.IV(new Object[]{303, this});
    }

    @Override // com.miui.zeus.mimo.sdk.b0
    public void onViewCreateFailed(boolean z, Throwable th) {
        NCall.IV(new Object[]{304, this, Boolean.valueOf(z), th});
    }

    @Override // com.miui.zeus.mimo.sdk.b0
    public void onViewCreateSuccess(boolean z, c0 c0Var) {
        NCall.IV(new Object[]{305, this, Boolean.valueOf(z), c0Var});
    }

    @Override // com.miui.zeus.mimo.sdk.f7.a
    public void onViewDetached() {
        NCall.IV(new Object[]{306, this});
    }

    public void setDownLoadListener(r3 r3Var) {
        NCall.IV(new Object[]{307, this, r3Var});
    }

    public void setPrice(String str) {
        NCall.IV(new Object[]{308, this, str});
    }

    public void showBanner(Activity activity, MimoAdInfo mimoAdInfo, ViewGroup viewGroup, float f, e eVar) {
        NCall.IV(new Object[]{309, this, activity, mimoAdInfo, viewGroup, Float.valueOf(f), eVar});
    }

    public void updateBannerView(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{310, this, mimoAdInfo});
    }
}
