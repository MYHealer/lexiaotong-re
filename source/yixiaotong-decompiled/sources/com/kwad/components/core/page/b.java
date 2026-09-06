package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.wrapper.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    private WebView ade;
    private FeedVideoView adf;
    private LinearLayout adg;
    private TextView adh;
    private ImageView adi;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
    }

    public static b aX(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view) {
        this.adg = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.adh = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.adi = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.adg.setVisibility(8);
            }
        });
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        boolean zBF = com.kwad.sdk.core.response.helper.a.bF(adInfoEO);
        String strBB = com.kwad.sdk.core.response.helper.a.bB(adInfoEO);
        if (zBF) {
            this.adg.setVisibility(0);
            this.adh.setText(strBB);
            this.adh.setSelected(true);
            return;
        }
        this.adg.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        WebView webView = this.ade;
        if (webView != null && webView.canGoBack()) {
            this.ade.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.adf;
        if (feedVideoView != null) {
            return feedVideoView.zU();
        }
        return false;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) uE();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + viewHolderFindViewHolderForAdapterPosition.itemView.getHeight() + ")");
                    detailWebRecycleView.setTopViewHeight(viewHolderFindViewHolderForAdapterPosition.itemView.getHeight());
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    if (viewHolderFindViewHolderForAdapterPosition2.itemView instanceof FeedVideoView) {
                        b.this.adf = (FeedVideoView) viewHolderFindViewHolderForAdapterPosition2.itemView;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.ade = (WebView) view2.findViewById(R.id.ksad_video_webView);
                    b.this.A(view2);
                }
                com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rI() {
        return R.layout.ksad_detail_webview;
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }

    static class a extends com.kwad.components.core.page.recycle.d {
        com.kwad.components.core.page.recycle.e adl;
        AdTemplate mAdTemplate;
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return i;
        }

        a(AdTemplate adTemplate, Context context, com.kwad.components.core.page.recycle.e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.adl = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i) {
            super.onBindViewHolder(cVar, i);
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c c(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View viewA = m.a(this.mContext, R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.d.c());
                return new com.kwad.components.core.page.recycle.c(viewA, presenter, this.adl);
            }
            if (i == 0) {
                FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a(new com.kwad.components.core.page.d.b());
                return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.adl);
            }
            View view = new View(viewGroup.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 64.0f)));
            return new com.kwad.components.core.page.recycle.c(view, new Presenter(), this.adl);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)) ? 3 : 2;
        }
    }
}
