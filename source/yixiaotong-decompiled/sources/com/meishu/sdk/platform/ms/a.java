package com.meishu.sdk.platform.ms;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.meishu.sdk.activity.MeishuRewardH5Activity;
import com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoAd;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.safe.SafeBroadcastReceiver;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.d1;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.webview.o;
import com.meishu.sdk.meishu_ad.n0;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import java.util.Map;

/* JADX INFO: compiled from: BaseFullScreenVideoAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends com.meishu.sdk.core.ad.a implements RewardVideoAd, IFullScreenVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f5157a;
    public g b;
    public InteractionListener c;
    public RewardAdMediaListener d;
    public com.meishu.sdk.meishu_ad.nativ.f e;
    public com.meishu.sdk.platform.ms.reward.a f;
    public boolean g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public volatile boolean l;
    public BroadcastReceiver m;
    public volatile boolean n;
    public IFullScreenMediaListener o;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseFullScreenVideoAd.java */
    public class C0846a extends SafeBroadcastReceiver {
        public C0846a() {
        }

        /* JADX WARN: Code duplicated, block: B:107:0x021c A[Catch: all -> 0x0237, TryCatch #2 {all -> 0x0237, blocks: (B:101:0x0204, B:103:0x020a, B:105:0x0212, B:107:0x021c, B:109:0x022b), top: B:144:0x0204, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:109:0x022b A[Catch: all -> 0x0237, TRY_LEAVE, TryCatch #2 {all -> 0x0237, blocks: (B:101:0x0204, B:103:0x020a, B:105:0x0212, B:107:0x021c, B:109:0x022b), top: B:144:0x0204, outer: #1 }] */
        /* JADX WARN: Type inference failed for: r10v25, types: [com.meishu.sdk.core.loader.IAdLoadListener] */
        /* JADX WARN: Type inference failed for: r10v33, types: [com.meishu.sdk.core.loader.c] */
        @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            InteractionListener interactionListener;
            try {
                if ("broadcast_onclick".equalsIgnoreCase(intent.getAction())) {
                    com.meishu.sdk.meishu_ad.nativ.f fVar = a.this.e;
                    if (fVar != null && fVar.getCbc() == 0 && (interactionListener = a.this.c) != null) {
                        interactionListener.onAdClicked();
                    }
                    boolean booleanExtra = intent.getBooleanExtra("open_loading_page_browser", false);
                    if (a.this.f5157a.a() instanceof BaseAdSlot) {
                        ((BaseAdSlot) a.this.f5157a.a()).setRewardBrowserOpenLandingPage(booleanExtra);
                    }
                    int intExtra = intent.hasExtra("clk_power") ? intent.getIntExtra("clk_power", 0) : 0;
                    int intExtra2 = intent.hasExtra("clk_act_type") ? intent.getIntExtra("clk_act_type", 2) : 2;
                    if (a.this.f5157a.a() instanceof BaseAdSlot) {
                        ((BaseAdSlot) a.this.f5157a.a()).setClkActType(intExtra2);
                        if (intExtra >= 0) {
                            ((BaseAdSlot) a.this.f5157a.a()).setClkPower(intExtra);
                        }
                    }
                    if (intent.hasExtra("shake_result")) {
                        try {
                            ((BaseAdSlot) a.this.f5157a.a()).setShakeResult((ShakeResult) intent.getSerializableExtra("shake_result"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (intent.hasExtra("click_reward_tmp_id")) {
                        int intExtra3 = intent.getIntExtra("click_reward_tmp_id", 0);
                        c cVar = a.this.f5157a;
                        Map<Integer, Integer> map = h.f4907a;
                        if (cVar != null) {
                            try {
                                if (cVar.a() != null) {
                                    BaseAdSlot baseAdSlot = cVar.a() instanceof BaseAdSlot ? (BaseAdSlot) cVar.a() : null;
                                    if (baseAdSlot != null) {
                                        baseAdSlot.getAppendInfo().getClickExtInfo().setRewardTempId(intExtra3);
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        c cVar2 = a.this.f5157a;
                        if (cVar2 != null) {
                            try {
                                if (cVar2.a() != null) {
                                    BaseAdSlot baseAdSlot2 = cVar2.a() instanceof BaseAdSlot ? (BaseAdSlot) cVar2.a() : null;
                                    if (baseAdSlot2 != null) {
                                        baseAdSlot2.getAppendInfo().getClickExtInfo().setWebTempId(intExtra3, false);
                                    }
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    try {
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        String[] clickUrl = a.this.f5157a.a().getClickUrl();
                        for (int i = 0; i < clickUrl.length; i++) {
                            clickUrl[i] = h0.a(clickUrl[i], displayMetrics.widthPixels, displayMetrics.heightPixels);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    com.meishu.sdk.core.utils.f.a(a.this.f5157a, intExtra == 0 || intExtra >= 50);
                    return;
                }
                if ("broadcast_onreward".equalsIgnoreCase(intent.getAction())) {
                    IAdLoadListener loaderListener = a.this.b.getAdLoader().getLoaderListener();
                    if (loaderListener == null || !(loaderListener instanceof com.meishu.sdk.core.ad.reward.a)) {
                        return;
                    }
                    ((com.meishu.sdk.core.ad.reward.a) loaderListener).onReward(null);
                    return;
                }
                if ("broadcast_onclosed".equalsIgnoreCase(intent.getAction())) {
                    a.b(a.this);
                    return;
                }
                if ("broadcast_on_video_complete".equalsIgnoreCase(intent.getAction())) {
                    RewardAdMediaListener rewardAdMediaListener = a.this.d;
                    if (rewardAdMediaListener != null) {
                        rewardAdMediaListener.onVideoCompleted();
                    }
                    IFullScreenMediaListener iFullScreenMediaListener = a.this.o;
                    if (iFullScreenMediaListener != null) {
                        iFullScreenMediaListener.onVideoCompleted();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_start".equalsIgnoreCase(intent.getAction())) {
                    a.this.k = System.currentTimeMillis();
                    boolean zHasExtra = intent.hasExtra("report_exposure");
                    com.meishu.sdk.meishu_ad.nativ.f fVar2 = a.this.e;
                    fVar2.setMonitorUrl(h0.b(fVar2.getMonitorUrl(), a.this.i + "." + a.this.j + "." + a.this.k));
                    RewardAdMediaListener rewardAdMediaListener2 = a.this.d;
                    if (rewardAdMediaListener2 != null) {
                        rewardAdMediaListener2.onVideoStart();
                    }
                    if (zHasExtra) {
                        a.a(a.this);
                        if (a.this.b.getLoaderListener() != 0) {
                            a.this.b.getLoaderListener().onAdExposure();
                        }
                    } else {
                        try {
                            a aVar = a.this;
                            if (aVar.h || (aVar.e.getAdPatternType() != 2 && a.this.e.getImageUrls() != null)) {
                                a.a(a.this);
                                if (a.this.b.getLoaderListener() != 0) {
                                    a.this.b.getLoaderListener().onAdExposure();
                                }
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    InteractionListener interactionListener2 = a.this.c;
                    if (interactionListener2 != null) {
                        interactionListener2.onAdExposure();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_pause".equalsIgnoreCase(intent.getAction())) {
                    RewardAdMediaListener rewardAdMediaListener3 = a.this.d;
                    if (rewardAdMediaListener3 != null) {
                        rewardAdMediaListener3.onVideoPause();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_resume".equalsIgnoreCase(intent.getAction())) {
                    RewardAdMediaListener rewardAdMediaListener4 = a.this.d;
                    if (rewardAdMediaListener4 != null) {
                        rewardAdMediaListener4.onVideoResume();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_error".equalsIgnoreCase(intent.getAction())) {
                    a.this.j = System.currentTimeMillis();
                    RewardAdMediaListener rewardAdMediaListener5 = a.this.d;
                    if (rewardAdMediaListener5 != null) {
                        rewardAdMediaListener5.onVideoError();
                    }
                    com.meishu.sdk.platform.ms.reward.a aVar2 = a.this.f;
                    if (aVar2 != null) {
                        aVar2.onAdRenderFail("激励视频渲染失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                    }
                    if (a.this.l) {
                        com.meishu.sdk.core.event.b.a(context, a.this.m);
                        LogUtil.d("RewardVideoAdAdapter", "onVideoActivityClosed: 激励视频广告回收资源");
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            th3.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: BaseFullScreenVideoAd.java */
    public class b implements z.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5159a;
        public final /* synthetic */ n0 b;

        public b(Context context, n0 n0Var) {
            this.f5159a = context;
            this.b = n0Var;
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void a() {
            com.meishu.sdk.platform.ms.reward.a aVar = a.this.f;
            if (aVar != null) {
                aVar.onAdRenderFail("视频加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void success() {
            a.this.a(this.f5159a, this.b);
        }
    }

    public a(g gVar, c cVar, com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.platform.ms.reward.a aVar) {
        super(null, "MS");
        this.h = false;
        this.m = new C0846a();
        this.b = gVar;
        this.f5157a = cVar;
        this.e = fVar;
        this.f = aVar;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.meishu.sdk.core.loader.c] */
    public static void a(a aVar) {
        aVar.getClass();
        try {
            if (com.meishu.sdk.core.utils.a.a((AdSlot) aVar.e)) {
                LogUtil.dev("RewardVideoAdAdapter", "has exp. return");
                return;
            }
            if (aVar.n) {
                return;
            }
            aVar.n = true;
            com.meishu.sdk.meishu_ad.nativ.f fVar = aVar.e;
            if (fVar != null) {
                fVar.setHasExposed(true);
            }
            u0.a(aVar.b.getAdLoader().getPosId(), 3);
            String[] strArrB = h0.b(aVar.b.f5177a.getMonitorUrl(), aVar.i + "." + aVar.j + "." + aVar.k);
            h0.a(strArrB);
            if (strArrB != null) {
                LogUtil.d("RewardVideoAdAdapter", "send onAdExposure");
                for (String str : strArrB) {
                    if (!TextUtils.isEmpty(str)) {
                        g gVar = aVar.b;
                        z.a(aVar.b.getContext(), h0.a(h0.a(str, ((com.meishu.sdk.meishu_ad.nativ.f) gVar.f5177a).getAct_type(), gVar instanceof com.meishu.sdk.platform.ms.reward.b ? AdType.REWARD : AdType.FULL_SCREEN_VIDEO)), new i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
        MeishuRewardVideoPlayerActivity.clearRewardMediaView();
        this.f5157a = null;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.e.getCid());
        resultBean.setCat(this.e.getCat());
        resultBean.setAderId(this.e.getAder_id());
        resultBean.setFromId(this.e.getFromId());
        resultBean.setDrawing(this.e.getDrawing());
        resultBean.setPid(this.e.getPosId());
        resultBean.setReqId(this.e.getReq_id());
        resultBean.setPrice(this.e.getEcpm());
        resultBean.setEcpm(String.valueOf(this.e.getEcpm()));
        resultBean.setS_ext(this.e.getS_ext());
        resultBean.setS_code(this.e.getS_code());
        resultBean.setSdkName("MS");
        resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.e));
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        int expire_timestamp = this.e.getExpire_timestamp();
        return SystemClock.uptimeMillis() - this.e.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(this.b.getContext(), this.e.getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(this.b.getContext(), this.e.getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.o = iFullScreenMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.d = rewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        try {
            b(this.b.getContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009c A[Catch: all -> 0x00b4, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0012, B:10:0x001d, B:12:0x0029, B:15:0x0031, B:17:0x0039, B:19:0x004b, B:20:0x004f, B:22:0x005b, B:24:0x0073, B:25:0x0078, B:28:0x007d, B:30:0x0083, B:33:0x0088, B:34:0x009c, B:36:0x00a2, B:37:0x00ab), top: B:46:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a2 A[Catch: all -> 0x00b4, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0012, B:10:0x001d, B:12:0x0029, B:15:0x0031, B:17:0x0039, B:19:0x004b, B:20:0x004f, B:22:0x005b, B:24:0x0073, B:25:0x0078, B:28:0x007d, B:30:0x0083, B:33:0x0088, B:34:0x009c, B:36:0x00a2, B:37:0x00ab), top: B:46:0x0001 }] */
    public final synchronized void b(Context context) {
        com.meishu.sdk.platform.ms.reward.a aVar;
        if (this.g) {
            LogUtil.d("RewardVideoAdAdapter", "同一个激励视频只能展示一次");
            com.meishu.sdk.platform.ms.reward.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.onAdRenderFail("同一个激励视频只能展示一次", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
            return;
        }
        this.i = System.currentTimeMillis();
        c cVar = this.f5157a;
        n0 n0Var = cVar instanceof com.meishu.sdk.meishu_ad.nativ.d ? ((com.meishu.sdk.meishu_ad.nativ.d) cVar).h : null;
        if (n0Var != null) {
            T t = this.b.f5177a;
            if (t instanceof com.meishu.sdk.meishu_ad.nativ.f) {
                o1.b(((com.meishu.sdk.meishu_ad.nativ.f) t).getEventUrl());
                this.g = true;
                c cVar2 = this.f5157a;
                if (cVar2 instanceof com.meishu.sdk.meishu_ad.nativ.d) {
                    ((com.meishu.sdk.meishu_ad.nativ.d) cVar2).l = true;
                }
                try {
                    if (MeishuRewardH5Activity.isValid(this.e.getReq_id())) {
                        this.h = true;
                        a(context);
                        Intent intent = new Intent();
                        intent.setClass(context, MeishuRewardH5Activity.class);
                        intent.setFlags(67108864);
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        context.startActivity(intent);
                        return;
                    }
                } catch (Exception unused) {
                }
                g gVar = this.b;
                if (gVar instanceof com.meishu.sdk.platform.ms.reward.b) {
                    a(context, n0Var);
                    return;
                }
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) gVar.f5177a).getImageUrls()[0], new b(context, n0Var));
            } else {
                aVar = this.f;
                if (aVar != null) {
                    aVar.onAdRenderFail("视频加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                }
                LogUtil.e("RewardVideoAdAdapter", "showAd: 请先加载视频");
            }
        } else {
            aVar = this.f;
            if (aVar != null) {
                aVar.onAdRenderFail("视频加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
            LogUtil.e("RewardVideoAdAdapter", "showAd: 请先加载视频");
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        try {
            this.c = interactionListener;
            this.f5157a.setInteractionListener(interactionListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        try {
            c cVar = this.f5157a;
            if (cVar instanceof com.meishu.sdk.meishu_ad.nativ.d) {
                ((com.meishu.sdk.meishu_ad.nativ.d) cVar).j = activity;
            }
            b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(Context context, n0 n0Var) {
        try {
            com.meishu.sdk.meishu_ad.nativ.f fVar = (com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a;
            int i = context.getResources().getConfiguration().orientation;
            Intent intent = new Intent();
            intent.setClass(context, MeishuRewardVideoPlayerActivity.class);
            intent.setFlags(67108864);
            intent.putExtra(MeishuRewardVideoPlayerActivity.orientation_key, i);
            intent.putExtra(MeishuRewardVideoPlayerActivity.local_ad_id_key, this.b.f5177a.hashCode() + "");
            ShakeUtil.getInstance().a(fVar.getPosId(), fVar.getLoadedTime(), fVar.getDclk());
            if (fVar.getAdPatternType() != 2 && fVar.getImageUrls() != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Image_src, fVar.getImageUrls()[0]);
            }
            String[] strArr = fVar.j;
            if (strArr != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_start_key, strArr);
            }
            String[] strArr2 = fVar.k;
            if (strArr2 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_one_quarter_key, strArr2);
            }
            String[] strArr3 = fVar.l;
            if (strArr3 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_one_half_key, strArr3);
            }
            String[] strArr4 = fVar.m;
            if (strArr4 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_three_quarter_key, strArr4);
            }
            String[] strArr5 = fVar.n;
            if (strArr5 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_complete_key, strArr5);
            }
            String[] strArr6 = fVar.o;
            if (strArr6 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_pause_key, strArr6);
            }
            String[] strArr7 = fVar.p;
            if (strArr7 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_resume_key, strArr7);
            }
            String[] strArr8 = fVar.r;
            if (strArr8 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_mute_key, strArr8);
            }
            String[] strArr9 = fVar.s;
            if (strArr9 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_unmute_key, strArr9);
            }
            if (fVar.getVideo_cover() != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_cover, fVar.getVideo_cover());
            }
            String str = fVar.h;
            if (str != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_endcover, str);
            }
            long j = fVar.i;
            if (j != 0) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Video_keep_time, j);
            }
            if (!TextUtils.isEmpty(fVar.title)) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Ad_title, fVar.title);
            }
            if (!TextUtils.isEmpty(fVar.desc)) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Ad_content, fVar.desc);
            }
            if (!TextUtils.isEmpty(fVar.getFromLogo())) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.From_logo, fVar.getFromLogo());
            }
            String str2 = fVar.iconUrl;
            if (str2 != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Ad_icon_url, str2);
            }
            if (fVar.getEventUrl() != null) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Event_url, fVar.getEventUrl());
            }
            String str3 = fVar.d;
            if (TextUtils.isEmpty(str3)) {
                str3 = fVar.getInteractionType() == 0 ? "查看详情" : "点击下载";
            }
            intent.putExtra(MeishuRewardVideoPlayerActivity.Action_text, str3);
            intent.putExtra(MeishuRewardVideoPlayerActivity.Clickable_range, fVar.v);
            intent.putExtra(MeishuRewardVideoPlayerActivity.Close_btn, fVar.w);
            intent.putExtra(MeishuRewardVideoPlayerActivity.Clk_type, fVar.getAct_type());
            intent.putExtra(MeishuRewardVideoPlayerActivity.Power_index, fVar.getPower_index());
            intent.putExtra(MeishuRewardVideoPlayerActivity.Power_index2, fVar.getPower_index2());
            intent.putExtra(MeishuRewardVideoPlayerActivity.Power_count, fVar.getPower_count());
            intent.putExtra(MeishuRewardVideoPlayerActivity.Power_delay, fVar.getPower_delay());
            intent.putExtra(MeishuRewardVideoPlayerActivity.Interaction_type, fVar.getInteractionType());
            g gVar = this.b;
            if (gVar instanceof com.meishu.sdk.platform.ms.reward.b) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Ad_type, AdType.REWARD.value());
                if (d1.b(context) && o.a(fVar.getWebTempUrl()) && fVar.getWebTempId() > 0) {
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Web_temp_url, fVar.getWebTempUrl());
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Web_temp_id, fVar.getWebTempId());
                }
                if (d1.a(context, fVar)) {
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Reward_tmp_url, fVar.getReward_tmp_url());
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Reward_tmp_type, fVar.getReward_tmp_type());
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Reward_tmp_time, fVar.getReward_tmp_time());
                    intent.putExtra(MeishuRewardVideoPlayerActivity.Reward_tmp_id, fVar.getRewardTmpId());
                }
            } else if (gVar instanceof com.meishu.sdk.platform.ms.fullscreenvideo.a) {
                intent.putExtra(MeishuRewardVideoPlayerActivity.Ad_type, AdType.FULL_SCREEN_VIDEO.value());
            }
            c cVar = this.f5157a;
            if (cVar instanceof com.meishu.sdk.meishu_ad.nativ.d) {
                MeishuRewardVideoPlayerActivity.setVideoMute(((com.meishu.sdk.meishu_ad.nativ.d) cVar).k);
            }
            MeishuRewardVideoPlayerActivity.setFullScreenAd(this.f5157a);
            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
            downloadDialogBean.setApp_name(fVar.getAppName());
            downloadDialogBean.setApp_feature(fVar.getApp_feature());
            downloadDialogBean.setApp_intro(fVar.getApp_intro());
            downloadDialogBean.setApp_privacy(fVar.getApp_privacy());
            downloadDialogBean.setApp_size(fVar.getApp_size());
            downloadDialogBean.setDeveloper(fVar.getDeveloper());
            downloadDialogBean.setPayment_types(fVar.getPayment_types());
            downloadDialogBean.setApp_permission(fVar.getApp_permission());
            downloadDialogBean.setApp_permission_url(fVar.getApp_permission_url());
            downloadDialogBean.setApp_intor_url(fVar.getApp_intor_url());
            downloadDialogBean.setApp_private_agreement(fVar.getPrivacy_agreement());
            MeishuRewardVideoPlayerActivity.setDownloadDialogBean(downloadDialogBean);
            a(context);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            MeishuRewardVideoPlayerActivity.setMediaView(n0Var);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            com.meishu.sdk.platform.ms.reward.a aVar = this.f;
            if (aVar != null) {
                aVar.onAdRenderFail("视频加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.meishu.sdk.core.loader.c] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.meishu.sdk.core.loader.c] */
    public static void b(a aVar) {
        if (aVar.l) {
            com.meishu.sdk.core.event.b.a(aVar.b.getContext(), aVar.m);
            LogUtil.d("RewardVideoAdAdapter", "onVideoActivityClosed: 激励视频广告回收资源");
        }
        if (aVar.b.getAdLoader().getLoaderListener() != null) {
            aVar.b.getAdLoader().getLoaderListener().onAdClosed();
        }
        InteractionListener interactionListener = aVar.c;
        if (interactionListener != null) {
            interactionListener.onAdClosed();
        }
    }

    public final void a(Context context) {
        try {
            this.l = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("broadcast_onclick");
            intentFilter.addAction("broadcast_onreward");
            intentFilter.addAction("broadcast_onclosed");
            intentFilter.addAction("broadcast_on_video_complete");
            intentFilter.addAction("broadcast_on_video_start");
            intentFilter.addAction("broadcast_on_video_pause");
            intentFilter.addAction("broadcast_on_video_resume");
            intentFilter.addAction("broadcast_on_video_error");
            com.meishu.sdk.core.event.b.a(context, this.m, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
