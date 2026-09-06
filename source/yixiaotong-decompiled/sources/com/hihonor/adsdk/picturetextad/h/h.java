package com.hihonor.adsdk.picturetextad.h;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.player.HnPictureTextPlayerView;
import com.hihonor.adsdk.base.widget.RadiusFrameLayout;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.picturetextad.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h extends d {
    private static final String D = "VideoViewHolder";
    protected int A;
    private final View.OnAttachStateChangeListener B;
    private final OnVideoPlayListener C;
    protected final HnPictureTextPlayerView r;
    protected final ImageView s;
    protected final View t;
    protected final View u;
    protected final ImageView v;
    protected final TextView w;
    protected View x;
    protected Video y;
    protected RadiusFrameLayout z;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ImageView imageView;
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "onViewAttachedToWindow", new Object[0]);
            if (Objects.isNull(h.this.r)) {
                com.hihonor.adsdk.common.b.b.hnadse(h.D, "onViewAttachedToWindow adPlayerView is null", new Object[0]);
                return;
            }
            View view2 = h.this.x;
            if (view2 != null && view2.getVisibility() == 0) {
                com.hihonor.adsdk.common.b.b.hnadse(h.D, "onViewAttachedToWindow adPlayerView mEndStubView is visible", new Object[0]);
            } else {
                if (h.this.r.canAutoPlay() || (imageView = h.this.s) == null) {
                    return;
                }
                imageView.setVisibility(0);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class b extends OnVideoPlayListener {
        b() {
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onProgressUpdate(long j, long j2, long j3) {
            h.this.s.setVisibility(8);
            h.this.w.setText(com.hihonor.adsdk.base.player.b.hnadsa(j, j3));
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoBuffering(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoEnd() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoEnd", new Object[0]);
            h.this.a(true);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoError(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPause() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoPause", new Object[0]);
            h.this.s.setVisibility(0);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPrepare() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoPrepare", new Object[0]);
            h.this.s.setVisibility(8);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPrepared() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoPrepared", new Object[0]);
            h.this.s.setVisibility(0);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoResume() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoResume", new Object[0]);
            h.this.s.setVisibility(8);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoStart() {
            com.hihonor.adsdk.common.b.b.hnadsc(h.D, "pictureText--->onVideoStart", new Object[0]);
            h.this.s.setVisibility(8);
            h.this.a(false);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VideoReportBean f3550a;

        public c(VideoReportBean videoReportBean) {
            this.f3550a = videoReportBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.h()) {
                h.this.r.setPlayerViewCorners();
            }
            h.this.a(new AdVideoSize(h.this.y.getVideoWidth(), h.this.y.getVideoHeight()));
            h.this.r.setVideoReportBean(this.f3550a);
            View viewHnadsa = h.this.hnadsa(R.id.ad_video_container);
            ViewGroup.LayoutParams layoutParams = viewHnadsa.getLayoutParams();
            AdVideoSize finalPlayerSize = h.this.r.getFinalPlayerSize();
            if (finalPlayerSize != null) {
                layoutParams.width = finalPlayerSize.getWidth();
                layoutParams.height = finalPlayerSize.getHeight();
            }
            viewHnadsa.setLayoutParams(layoutParams);
            h.this.a(h.this.r.getPlayState() == 8);
        }
    }

    public h(View view) {
        super(view);
        this.A = -1;
        a aVar = new a();
        this.B = aVar;
        this.C = new b();
        HnPictureTextPlayerView hnPictureTextPlayerView = (HnPictureTextPlayerView) hnadsa(R.id.ad_player_view);
        this.r = hnPictureTextPlayerView;
        this.s = (ImageView) hnadsa(R.id.ad_video_start);
        this.t = hnadsa(com.hihonor.adsdk.base.R.id.ad_video_volume_time_layout);
        View viewHnadsa = hnadsa(com.hihonor.adsdk.base.R.id.ad_video_volume);
        this.u = viewHnadsa;
        viewHnadsa.setBackground(new ColorDrawable(0));
        this.v = (ImageView) hnadsa(com.hihonor.adsdk.base.R.id.ad_video_volume_view);
        TextView textView = (TextView) hnadsa(com.hihonor.adsdk.base.R.id.ad_video_time);
        this.w = textView;
        textView.setBackground(new ColorDrawable(0));
        hnPictureTextPlayerView.addOnAttachStateChangeListener(aVar);
    }

    private void e() {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.h$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.g(view);
            }
        });
    }

    private void f() {
        this.r.bindAd(this.f3547a);
        VideoReportBean videoReportBean = new VideoReportBean();
        videoReportBean.setAuStart(String.valueOf(this.y.getAutoPlay()));
        videoReportBean.setHasVoice(String.valueOf(this.y.getMute()));
        videoReportBean.setScene(String.valueOf(1));
        videoReportBean.setVideoType(String.valueOf(0));
        this.r.setVideoReportBean(videoReportBean);
        this.r.setVideoListener(this.C);
        int coverWidth = this.y.getCoverWidth();
        int coverHeight = this.y.getCoverHeight();
        if (coverWidth != 0 && coverHeight != 0) {
            int iHnadse = (int) (j.hnadse(this.hnadsa.getContext()) / ((coverWidth * 1.0f) / coverHeight));
            com.hihonor.adsdk.common.b.b.hnadsc(D, "imgHeight: " + iHnadse, new Object[0]);
            this.r.setVideoImageCoverHeight(iHnadse);
        }
        this.hnadsa.post(new c(videoReportBean));
        e();
        g();
        this.w.setText(com.hihonor.adsdk.base.player.b.hnadsa(0L, ((long) this.y.getVideoDuration()) * 1000));
        this.r.setTag(R.id.ad_common_click_type_tag, 5);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.h$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(view);
            }
        });
        int playState = this.r.getPlayState();
        com.hihonor.adsdk.common.b.b.hnadsc(D, "initVideoPlayerView,current state:" + playState, new Object[0]);
        if (playState == 0) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void h(View view) {
        boolean zIsMuted = this.r.isMuted();
        com.hihonor.adsdk.common.b.b.hnadsc(D, "onClick,muted: " + zIsMuted, new Object[0]);
        HnPictureTextPlayerView hnPictureTextPlayerView = this.r;
        boolean z = !zIsMuted;
        hnPictureTextPlayerView.setMuted(z);
        a(zIsMuted ? 1 : 0);
        b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(D, "pictureText replay--->start", new Object[0]);
        this.r.replay();
    }

    public void a(int i) {
        this.A = i;
    }

    protected void a(AdVideoSize adVideoSize) {
    }

    public int d() {
        return this.A;
    }

    protected boolean h() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.widget.a.c.a
    public void hnadsc() {
        super.hnadsc();
        HnPictureTextPlayerView hnPictureTextPlayerView = this.r;
        if (hnPictureTextPlayerView != null) {
            hnPictureTextPlayerView.removeOnAttachStateChangeListener(this.B);
            this.r.release();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.a.c.a
    public void hnadsd() {
        super.hnadsd();
        HnPictureTextPlayerView hnPictureTextPlayerView = this.r;
        if (hnPictureTextPlayerView != null) {
            hnPictureTextPlayerView.removeProxyVideoListener();
            this.r.removeScrollChangeListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        HnPictureTextPlayerView hnPictureTextPlayerView = this.r;
        if (hnPictureTextPlayerView == null) {
            com.hihonor.adsdk.common.b.b.hnadse(D, "pictureText--->start no adPlayerView", new Object[0]);
            return;
        }
        int playState = hnPictureTextPlayerView.getPlayState();
        com.hihonor.adsdk.common.b.b.hnadsc(D, "pictureText--->start playStage:" + playState, new Object[0]);
        if (5 == playState || 7 == playState || 2 == playState) {
            this.r.resume();
        } else {
            Video video = this.y;
            this.r.start(video != null ? video.getVideoUrl() : "", true, 1);
        }
    }

    private void b(boolean z) {
        if (z) {
            this.v.setImageDrawable(k.hnadsa(hnadsb().getContext(), R.drawable.ic_honor_ads_volume_off));
        } else {
            this.v.setImageDrawable(k.hnadsa(hnadsb().getContext(), R.drawable.ic_honor_ads_volume_on));
        }
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    public void a(BaseAd baseAd) {
        super.a(baseAd);
        com.hihonor.adsdk.common.b.b.hnadsc(D, "bindData", new Object[0]);
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(D, "baseAd is null.", new Object[0]);
            return;
        }
        this.f3547a = baseAd;
        if (baseAd.getVideo() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(D, "baseAd is null or getVideo is null.", new Object[0]);
        } else {
            this.y = this.f3547a.getVideo();
            f();
        }
    }

    private void g() {
        com.hihonor.adsdk.common.b.b.hnadsc(D, "initVolume,mute: " + this.A, new Object[0]);
        if (this.A == -1) {
            this.A = this.y.getMute();
        }
        this.r.setMuted(this.A == 0);
        b(this.A == 0);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.h$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.h(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(D, "setPlayFinishLayout,visible:" + z, new Object[0]);
        this.t.setVisibility(z ? 8 : 0);
        if (z && this.x == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(D, "setPlayFinishLayout,inflate", new Object[0]);
            ViewStub viewStub = (ViewStub) hnadsa(com.hihonor.adsdk.base.R.id.ad_end_stub);
            if (this.y.getVideoWidth() < this.y.getVideoHeight()) {
                viewStub.setLayoutResource(R.layout.honor_ads_video_finish_layout_vertical);
            } else {
                viewStub.setLayoutResource(R.layout.honor_ads_video_finish_layout_land);
            }
            try {
                View viewInflate = viewStub.inflate();
                this.x = viewInflate;
                if (viewInflate == null) {
                    com.hihonor.adsdk.common.b.b.hnadse(D, "mEndStubView is null,return", new Object[0]);
                    return;
                }
                RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) viewInflate.findViewById(com.hihonor.adsdk.base.R.id.ad_video_end_root);
                this.z = radiusFrameLayout;
                if (radiusFrameLayout != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(this.hnadsa.getContext().getResources().getColor(R.color.honor_ads_magic_mask_regular_dark));
                    if (h()) {
                        this.z.setRadius(this.c);
                        gradientDrawable.setCornerRadius(this.c);
                    }
                    this.z.setBackground(gradientDrawable);
                }
                View viewFindViewById = this.x.findViewById(com.hihonor.adsdk.base.R.id.ad_video_replay);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.h$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.i(view);
                        }
                    });
                }
                HnDownloadButton hnDownloadButton = (HnDownloadButton) this.x.findViewById(com.hihonor.adsdk.base.R.id.ad_download);
                if (hnDownloadButton != null) {
                    hnDownloadButton.setBaseAd(this.f3547a, 1);
                }
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsc(D, "setPlayFinishLayout,exception: " + e.getMessage(), new Object[0]);
            }
        }
        View view = this.x;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
