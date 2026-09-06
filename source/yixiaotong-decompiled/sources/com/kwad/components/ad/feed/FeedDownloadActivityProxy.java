package com.kwad.components.ad.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
public class FeedDownloadActivityProxy extends com.kwad.components.core.proxy.f implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    private static final String TAG = "FeedDownloadActivity";
    private static com.kwad.components.core.widget.b.a sInnerAdInteractionListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private TextProgressBar mProgressBarTv;

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    public static void launch(Context context, AdTemplate adTemplate, com.kwad.components.core.widget.b.a aVar) {
        com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = aVar;
        context.startActivity(intent);
    }

    public static void register() {
        com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_activity_feed_download;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        KsAdContainer ksAdContainer = (KsAdContainer) findViewById(R.id.ksad_container);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.n(this.mAdTemplate);
        this.mAppTailFrameView.E(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate, null, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.aK(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.eF(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.cK(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.aK(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.af(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.E(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.helper.a.eG(i), i);
            }
        });
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.lR();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(view == this.mProgressBarTv ? 1 : 2).as(view == this.mProgressBarTv).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    FeedDownloadActivityProxy.this.notifyAdClick();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        com.kwad.components.core.widget.b.a aVar = sInnerAdInteractionListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }
}
