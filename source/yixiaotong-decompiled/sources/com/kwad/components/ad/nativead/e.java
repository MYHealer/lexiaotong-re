package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.wrapper.m;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.j.c {
    private boolean cA;
    private OfflineOnAudioConflictListener cM;
    private List<Integer> cv;
    private final AdLivePlayStateListener ey;
    private IAdLiveOfflineView fH;
    private com.kwad.components.core.offline.a.c.a fI;
    private com.kwad.components.core.l.a.b fU;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private int fj;
    private as.b fo;
    private com.kwad.components.core.widget.a.c fx;
    private be iX;
    private az iY;
    private WebCardRegisterLiveMessageListener iZ;
    private KSRelativeLayout ij;
    public IAdLivePlayModule ir;
    private WebCardRegisterLiveShopListener ja;
    private ba.b je;
    private ba.a jf;
    private IAdLiveEndRequest js;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private d.a pD;
    private ImageView pP;
    private RelativeLayout pQ;
    private AdBasePvFrameLayout pR;
    private KSAdVideoPlayConfigImpl pS;
    private KsNativeAd.VideoPlayListener pv;
    private int px;
    private int py;

    private boolean cN() {
        return this.fj == 1;
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.pD = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.pv = videoPlayListener;
    }

    public e(Context context) {
        super(context);
        this.px = 0;
        this.py = 0;
        this.fo = new as.b() { // from class: com.kwad.components.ad.nativead.e.10
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar) {
                e.this.fj = aVar.status;
                if (e.this.fj != 1) {
                    e.this.mAdWebView.setVisibility(8);
                } else {
                    e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.nativead.e.12
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return w(str);
            }

            private static AdLiveEndCommonResultData w(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: cS, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.js);
            }
        };
        this.ey = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.nativead.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                e.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayComplete();
                }
                String strBn = com.kwad.sdk.core.response.helper.a.bn(e.this.mAdInfo);
                if (TextUtils.isEmpty(strBn)) {
                    return;
                }
                com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
                if (aVar != null) {
                    e.this.js = aVar.getAdLiveEndRequest(strBn);
                }
                e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.nativead.e.2.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onStartRequest(com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.kwad.components.core.liveEnd.a aVar2, AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ba.a aVar3 = new ba.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (e.this.je != null) {
                            e.this.je.a(aVar3);
                        } else {
                            e.this.jf = aVar3;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(com.kwad.components.core.liveEnd.a aVar2, int i, String str) {
                        super.onError(aVar2, i, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.l.a.tm().a(e.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = e.this.ir;
                e eVar = e.this;
                iAdLivePlayModule.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.l.a.tm().a(e.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = e.this.ir;
                e eVar = e.this;
                iAdLivePlayModule.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                try {
                    e.this.pv.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    e.this.pv.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.l.a.tm().a(e.this.getCurrentVoiceItem());
                try {
                    e.this.pv.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
                if (e.this.ir != null) {
                    e.this.ir.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayComplete();
                }
            }
        };
        this.cM = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.nativead.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                if (e.this.ir != null) {
                    e.this.ir.setAudioEnabled(false, false);
                }
            }
        };
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.pR = adBasePvFrameLayout;
        this.pP = (ImageView) adBasePvFrameLayout.findViewById(R.id.ksad_live_bg_img);
        this.ij = (KSRelativeLayout) this.pR.findViewById(R.id.ksad_live_container);
        this.pQ = (RelativeLayout) this.pR.findViewById(R.id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.pR.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.fI = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
    }

    public final void a(Context context, AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        this.mContext = context;
        this.pS = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = dVar;
        this.cv = com.kwad.sdk.core.response.helper.a.bv(adInfoEO);
        this.fx = new g(getParent() == null ? this : (View) getParent());
        if (this.pS.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.pS.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.helper.a.ch(this.mAdInfo);
        }
        fw();
        fA();
    }

    private void fw() {
        try {
            this.px = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.py = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void fA() {
        this.mAdWebView.setVisibility(8);
        bi();
        if (cN()) {
            this.mAdWebView.reload();
        } else {
            bj();
        }
    }

    private void bj() {
        if (com.kwad.sdk.core.response.helper.b.dH(this.mAdTemplate)) {
            fB();
        }
    }

    private void fB() {
        bl();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().fo(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.fh = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.fh, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.helper.b.dv(this.mAdTemplate));
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.fi.mScreenOrientation = 0;
        this.fi.bbV = null;
        this.fi.adW = this.pR;
        this.fi.ade = this.mAdWebView;
        this.fi.mReportExtData = null;
        this.fi.bbX = false;
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cA() {
        cB();
        IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.fI, this.mContext, 3);
        this.fH = iAdLiveOfflineViewA;
        if (iAdLiveOfflineViewA == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.fI.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), com.kwad.sdk.core.response.helper.a.cx(this.mAdInfo), com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo), com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.ey);
        final View view = this.fH.getView();
        this.pQ.removeAllViews();
        this.pQ.addView(view);
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.nativead.e.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                e.this.c(view);
            }
        });
        cO();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
        }
        return adLivePlayModule;
    }

    private void cB() {
        String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.pP.setImageDrawable(null);
            KSImageLoader.loadImage(this.pP, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.nativead.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.pP.setVisibility(0);
            return;
        }
        this.pP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.ij.getWidth();
        int height = this.ij.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    private void cO() {
        this.fH.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.nativead.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.iZ != null) {
                    e.this.iZ.u(list);
                }
            }
        });
        this.fH.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.nativead.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.ja != null) {
                    e.this.ja.a(adLiveShopInfo);
                }
            }
        });
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.iX = new be();
        az azVar = new az();
        this.iY = azVar;
        aVar.a(azVar);
        aVar.a(new ac(this.fi, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        aVar.a(new z(this.fi, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new ae(this.fi));
        aVar.a(new as(this.fo, com.kwad.sdk.core.response.helper.b.ds(this.mAdTemplate)));
        aVar.a(new bc(this.fi, this.mApkDownloadHelper));
        aVar.a(new am(this.fi));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.fi));
        aVar.b(new n(this.fi));
        aVar.a(this.iX);
        aVar.a(new aq(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.g(this.px, this.py));
        this.ja = new WebCardRegisterLiveShopListener();
        this.iZ = new WebCardRegisterLiveMessageListener();
        aVar.a(this.ja);
        aVar.a(this.iZ);
        aVar.a(new ba(getRegisterLiveListener()));
    }

    private ba.c getRegisterLiveListener() {
        return new ba.c() { // from class: com.kwad.components.ad.nativead.e.8
            @Override // com.kwad.components.core.webview.jshandler.ba.c
            public final void a(ba.b bVar) {
                e.this.je = bVar;
                if (e.this.jf != null) {
                    e.this.je.a(e.this.jf);
                    e.this.jf = null;
                }
            }
        };
    }

    private aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.ad.nativead.e.9
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0680a().aY(bVar.title).aZ(bVar.url).aY(e.this.mAdTemplate).ua());
            }
        };
    }

    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.nativead.e.11
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                int i = aVar.ara;
                if (aVar.QK) {
                    i = aVar.aqY ? 1 : 2;
                }
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(e.this.getContext()).aJ(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).as(false).aN(i).ay(aVar.QK).aw(com.kwad.sdk.core.response.helper.a.bi(e.this.mAdInfo)).D(e.this.ir == null ? 0L : e.this.ir.getPlayDuration()).aq((aVar.arb == null || TextUtils.isEmpty(aVar.arb.QY)) ? "" : aVar.arb.QY).au(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.e.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (e.this.pD != null) {
                            e.this.pD.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.fU != null) {
            com.kwad.components.core.l.a.tm();
            if (!com.kwad.components.core.l.a.b(this.fU)) {
                return false;
            }
        }
        if (com.kwad.sdk.core.config.e.hO()) {
            if (!this.cA) {
                this.cA = com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            }
            return this.cA;
        }
        if (com.kwad.components.core.t.a.aO(this.mContext).wE()) {
            return !com.kwad.components.core.t.a.aO(this.mContext).wD();
        }
        return com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cv.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ae() {
        super.ae();
        this.fx.Aa();
        this.fx.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void af() {
        super.af();
        this.fx.Aa();
        this.fx.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.ir;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.ir = null;
        }
        com.kwad.components.core.l.a.tm().c(this.fU);
        this.jf = null;
        this.je = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.fH;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.fH = null;
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.ir;
        if (iAdLivePlayModule == null) {
            this.ir = cA();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        IAdLivePlayModule iAdLivePlayModule = this.ir;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.l.a.tm().c(this.fU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.l.a.b getCurrentVoiceItem() {
        if (this.fU == null) {
            this.fU = new com.kwad.components.core.l.a.b(new com.kwad.components.core.l.a.c() { // from class: com.kwad.components.ad.nativead.e.4
                @Override // com.kwad.components.core.l.a.c
                public final void bL() {
                    if (e.this.ir == null) {
                        e eVar = e.this;
                        eVar.ir = eVar.cA();
                    }
                    if (e.this.ir != null) {
                        IAdLivePlayModule iAdLivePlayModule = e.this.ir;
                        e eVar2 = e.this;
                        iAdLivePlayModule.setAudioEnabled(eVar2.h(eVar2.mIsAudioEnable), false);
                    }
                }
            });
        }
        return this.fU;
    }
}
