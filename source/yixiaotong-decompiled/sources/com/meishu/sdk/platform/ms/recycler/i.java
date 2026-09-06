package com.meishu.sdk.platform.ms.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.domain.LayoutBean;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.FeedAdOverlayManager;
import com.meishu.sdk.core.view.PositionView;
import com.meishu.sdk.core.view.RoundImageView;
import com.meishu.sdk.core.view.ShakeImageView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPoint;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.platform.gdt.util.PxUtils;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i implements RecyclerAdData {
    public static int C = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.meishu_ad.nativ.b f5193a;
    public com.meishu.sdk.platform.ms.recycler.c b;
    public RelativeLayout c;
    public RecylcerAdInteractionListener d;
    public int e;
    public ExpressMediaListener h;
    public int i;
    public boolean j;
    public boolean k;
    public volatile boolean l;
    public int m;
    public FrameLayout n;
    public TouchAdContainer o;
    public boolean p;
    public FrameLayout q;
    public int r;
    public int s;
    public boolean t;
    public WeakReference<Activity> v;
    public WeakReference<ViewGroup> w;
    public int x;
    public int f = 0;
    public boolean g = false;
    public boolean u = false;
    public ViewTreeObserver.OnScrollChangedListener y = new j();
    public int z = 0;
    public boolean A = true;
    public ViewTreeObserver.OnScrollChangedListener B = new m();

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class a implements RecyclerAdMediaListener {
        public a() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoCompleted() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoCompleted();
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoError() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoError(-1, "视频加载出错");
            }
            i.this.a(-1, "视频加载出错");
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoLoaded() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoLoaded();
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoPause() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoPause();
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoResume() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoResume();
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoStart() {
            ExpressMediaListener expressMediaListener = i.this.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoStart();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundImageView f5195a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ float c;
        public final /* synthetic */ ImageView d;

        public b(RoundImageView roundImageView, Context context, float f, ImageView imageView) {
            this.f5195a = roundImageView;
            this.b = context;
            this.c = f;
            this.d = imageView;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            int iDpToPx;
            int i;
            try {
                if (!httpResponse.isSuccessful()) {
                    i.this.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
                    return;
                }
                if (responseBody.length >= i0.a()) {
                    i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
                    return;
                }
                if (i.a(i.this, responseBody)) {
                    RoundImageView roundImageView = this.f5195a;
                    if (roundImageView != null) {
                        roundImageView.setBytes(responseBody);
                        int gifWidth = this.f5195a.getGifWidth();
                        int gifHeight = this.f5195a.getGifHeight();
                        iDpToPx = i.this.b.getAdLoader() instanceof RecyclerMixAdLoader ? PxUtils.dpToPx(this.b, ((RecyclerMixAdLoader) i.this.b.getAdLoader()).getFixedHeight()) : 0;
                        int i2 = i.C;
                        LogUtil.i("i", "fixedHeight=" + iDpToPx);
                        int i3 = (int) (this.c * 75.0f);
                        if (iDpToPx > 0) {
                            i = (gifWidth * iDpToPx) / gifHeight;
                        } else {
                            i = (gifWidth * i3) / gifHeight;
                            iDpToPx = i3;
                        }
                        ViewGroup.LayoutParams layoutParams = this.f5195a.getLayoutParams();
                        layoutParams.width = i;
                        layoutParams.height = iDpToPx;
                        this.f5195a.setLayoutParams(layoutParams);
                        this.f5195a.startAnimation();
                        i.this.f5193a.a().D = System.currentTimeMillis();
                    }
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray == null) {
                        i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
                        return;
                    }
                    i.this.f5193a.a().D = System.currentTimeMillis();
                    iDpToPx = i.this.b.getAdLoader() instanceof RecyclerMixAdLoader ? PxUtils.dpToPx(this.b, ((RecyclerMixAdLoader) i.this.b.getAdLoader()).getFixedHeight()) : 0;
                    int i4 = i.C;
                    LogUtil.i("i", "fixedHeight=" + iDpToPx);
                    int i5 = (int) (this.c * 75.0f);
                    if (iDpToPx <= 0) {
                        int width = (bitmapDecodeByteArray.getWidth() * i5) / bitmapDecodeByteArray.getHeight();
                        iDpToPx = i5;
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.f5195a.getLayoutParams();
                    layoutParams2.height = iDpToPx;
                    this.f5195a.setLayoutParams(layoutParams2);
                    this.f5195a.setImageBitmap(bitmapDecodeByteArray);
                    Bitmap bitmapA = e0.a(bitmapDecodeByteArray, 25);
                    if (bitmapA != null) {
                        this.d.setLayoutParams(layoutParams2);
                        this.d.setImageBitmap(bitmapA);
                    }
                }
                i iVar = i.this;
                if (iVar.g) {
                    return;
                }
                iVar.g = true;
                i.c(i.this);
            } catch (Throwable th) {
                th.printStackTrace();
                i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundImageView f5196a;

        public c(RoundImageView roundImageView) {
            this.f5196a = roundImageView;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            try {
                if (!httpResponse.isSuccessful()) {
                    i.this.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                try {
                    byte[] responseBody = httpResponse.getResponseBody();
                    if (responseBody == null || responseBody.length <= 0) {
                        i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
                        return;
                    }
                    if (responseBody.length >= i0.a()) {
                        i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
                        return;
                    }
                    if (i.a(i.this, responseBody)) {
                        RoundImageView roundImageView = this.f5196a;
                        if (roundImageView != null) {
                            roundImageView.setBytes(responseBody);
                            this.f5196a.startAnimation();
                            this.f5196a.getGifHeight();
                        }
                    } else {
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray == null) {
                            i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
                            return;
                        } else {
                            bitmapDecodeByteArray.getHeight();
                            this.f5196a.setImageBitmap(bitmapDecodeByteArray);
                        }
                    }
                    i iVar = i.this;
                    if (iVar.g) {
                        return;
                    }
                    iVar.g = true;
                    i.c(i.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundImageView f5197a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ ImageView d;
        public final /* synthetic */ RelativeLayout e;
        public final /* synthetic */ ShakeImageView f;
        public final /* synthetic */ ImageView g;
        public final /* synthetic */ TextView h;
        public final /* synthetic */ TextView i;
        public final /* synthetic */ ViewGroup j;
        public final /* synthetic */ boolean k;

        public d(RoundImageView roundImageView, int i, Context context, ImageView imageView, RelativeLayout relativeLayout, ShakeImageView shakeImageView, ImageView imageView2, TextView textView, TextView textView2, ViewGroup viewGroup, boolean z) {
            this.f5197a = roundImageView;
            this.b = i;
            this.c = context;
            this.d = imageView;
            this.e = relativeLayout;
            this.f = shakeImageView;
            this.g = imageView2;
            this.h = textView;
            this.i = textView2;
            this.j = viewGroup;
            this.k = z;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String str;
            try {
                if (!httpResponse.isSuccessful()) {
                    i.this.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
                    return;
                }
                if (responseBody.length >= i0.a()) {
                    i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
                    return;
                }
                int i = i.C;
                LogUtil.d("i", "showUpDownStyle");
                if (i.a(i.this, responseBody)) {
                    RoundImageView roundImageView = this.f5197a;
                    if (roundImageView != null) {
                        roundImageView.setBytes(responseBody);
                        int gifHeight = (this.b * this.f5197a.getGifHeight()) / this.f5197a.getGifWidth();
                        Integer accept_ad_height = ((RecyclerMixAdLoader) i.this.b.getAdLoader()).getAccept_ad_height();
                        if (accept_ad_height != null && accept_ad_height.intValue() > 0) {
                            gifHeight = accept_ad_height.intValue();
                        }
                        try {
                            if ((this.b * 1.0f) / gifHeight < 1.77d && accept_ad_height != null && accept_ad_height.intValue() == -1) {
                                gifHeight = (int) Math.round(((double) this.b) / 1.77d);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ViewGroup.LayoutParams layoutParams = this.f5197a.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = gifHeight;
                        this.f5197a.setLayoutParams(layoutParams);
                        this.f5197a.startAnimation();
                    }
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray == null) {
                        i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载失败");
                        return;
                    }
                    int height = (this.b * bitmapDecodeByteArray.getHeight()) / bitmapDecodeByteArray.getWidth();
                    Integer accept_ad_height2 = ((RecyclerMixAdLoader) i.this.b.getAdLoader()).getAccept_ad_height();
                    if (accept_ad_height2 != null && accept_ad_height2.intValue() > 0) {
                        height = accept_ad_height2.intValue();
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f5197a.getLayoutParams();
                    try {
                        if ((this.b * 1.0f) / height < 1.77d && accept_ad_height2 != null && accept_ad_height2.intValue() == -1) {
                            height = (int) Math.round(((double) this.b) / 1.77d);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    layoutParams2.width = -1;
                    layoutParams2.height = height;
                    layoutParams2.addRule(14);
                    this.f5197a.setLayoutParams(layoutParams2);
                    this.f5197a.setImageBitmap(bitmapDecodeByteArray);
                    Bitmap bitmapA = e0.a(bitmapDecodeByteArray, 25);
                    if (bitmapA != null) {
                        this.d.setLayoutParams(layoutParams2);
                        this.d.setImageBitmap(bitmapA);
                    }
                }
                i.this.f5193a.a().D = System.currentTimeMillis();
                if ((i.this.f5193a.a().getAct_type() & 4) == 4 || (i.this.f5193a.a().getAct_type() & 64) == 64) {
                    i.this.a(this.c, this.e, this.f);
                    this.g.setVisibility(0);
                    this.h.setVisibility(0);
                    str = "摇动或点击";
                    TextView textView = this.i;
                    if (textView != null) {
                        textView.setText("摇一摇");
                    }
                } else if (com.meishu.sdk.core.utils.h.e(i.this.f5193a.a().getAct_type())) {
                    i.this.a(this.c, this.e, this.f);
                    this.g.setVisibility(0);
                    this.h.setVisibility(0);
                    str = "扭动或点击";
                    TextView textView2 = this.i;
                    if (textView2 != null) {
                        textView2.setText("扭一扭");
                    }
                } else {
                    str = "点击";
                    ViewGroup viewGroup = this.j;
                    if (viewGroup != null && !this.k) {
                        viewGroup.setVisibility(0);
                        this.g.setImageResource(R.drawable.ms_ic_right);
                        this.g.setVisibility(0);
                        this.h.setVisibility(0);
                    }
                }
                this.h.setText(str.concat(i.this.f5193a.a().getInteractionType() == 1 ? "立即下载" : "查看详情"));
                i iVar = i.this;
                if (iVar.g) {
                    return;
                }
                iVar.g = true;
                i.c(i.this);
            } catch (Throwable th) {
                th.printStackTrace();
                i.this.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class e extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5198a;
        public final /* synthetic */ RelativeLayout b;
        public final /* synthetic */ ShakeImageView c;

        /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
        public class a extends com.meishu.sdk.core.safe.l {
            public a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                e.this.c.stopAnimation();
                e.this.b.setVisibility(8);
            }
        }

        public e(Context context, RelativeLayout relativeLayout, ShakeImageView shakeImageView) {
            this.f5198a = context;
            this.b = relativeLayout;
            this.c = shakeImageView;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                DisplayMetrics displayMetrics = this.f5198a.getResources().getDisplayMetrics();
                int measuredHeight = i.this.c.getMeasuredHeight();
                if (measuredHeight < displayMetrics.density * 120.0f) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                    layoutParams.height = Math.max(measuredHeight - 70, (int) (displayMetrics.density * 70.0f));
                    layoutParams.width = -2;
                    layoutParams.addRule(13);
                    this.b.setLayoutParams(layoutParams);
                }
                this.b.setVisibility(0);
                this.c.startAnimation();
                this.b.postDelayed(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class f extends com.meishu.sdk.core.safe.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5200a;

        public f(View view) {
            this.f5200a = view;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            if (i.this.b.getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.recycler.a) i.this.b.getLoaderListener()).onAdClosed();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = i.this.d;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdClosed();
            }
            View view2 = this.f5200a;
            if (view2 != null && view2.getParent() != null && (this.f5200a.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f5200a.getParent()).removeView(this.f5200a);
            }
            ShakeUtil.getInstance().a(i.this.i);
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class g implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5201a;
        public final /* synthetic */ Rect b;

        public g(ViewGroup viewGroup, Rect rect) {
            this.f5201a = viewGroup;
            this.b = rect;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!this.f5201a.getGlobalVisibleRect(this.b)) {
                return true;
            }
            if (((long) this.b.height()) * ((long) this.b.width()) >= ((long) this.f5201a.getHeight()) * ((long) this.f5201a.getWidth()) * 0.3d) {
                i.this.p = true;
                i.this.f5193a.a().setMonitorUrl(h0.a(i.this.f5193a.a().getMonitorUrl(), this.f5201a, (View) null));
                i iVar = i.this;
                if (iVar.j && iVar.f5193a.getAdPatternType() == 2) {
                    i.a(i.this);
                    i.b(i.this);
                } else {
                    i.c(i.this);
                }
                this.f5201a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class h implements FeedAdOverlayManager.OnOverlayTriggerAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5202a;

        public h(ViewGroup viewGroup) {
            this.f5202a = viewGroup;
        }

        @Override // com.meishu.sdk.core.view.FeedAdOverlayManager.OnOverlayTriggerAction
        public void onOverlayAttached() {
            try {
                o1.a(i.this.f5193a.a().getEventUrl(), 29, 0, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.view.FeedAdOverlayManager.OnOverlayTriggerAction
        public void onTrigger(boolean z, boolean z2, float f, float f2, long j, float f3, float f4, int i) {
            RecylcerAdInteractionListener recylcerAdInteractionListener;
            if (i.this.f5193a.a().B) {
                if (!z2) {
                    try {
                        o1.a(i.this.f5193a.a().getEventUrl(), 30, 0, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                h0.a(i.this.f5193a, this.f5202a);
                if (z) {
                    i iVar = i.this;
                    iVar.a(iVar.o, f, f2, j, f3, f4, i);
                    return;
                }
                try {
                    if (i.this.f5193a.a().getCbc() == 0 && (recylcerAdInteractionListener = i.this.d) != null) {
                        recylcerAdInteractionListener.onAdClicked();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                s.a(i.this.f5193a, f, f2, j, f3, f4);
                i.this.f5193a.a().setClkActType(1);
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) i.this.f5193a, true);
            }
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.recycler.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class C0851i implements TouchAdContainer.OnWindownEventListener {
        public C0851i() {
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onAttachedToWindow() {
            ShakeUtil.getInstance().a(i.this.i, true);
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onDetachedFromWindow() {
            ShakeUtil.getInstance().a(i.this.i, false);
            try {
                i.this.q.getViewTreeObserver().removeOnScrollChangedListener(i.this.y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                ShakeUtil.getInstance().a(i.this.i, true);
            } else {
                ShakeUtil.getInstance().a(i.this.i, false);
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class j implements ViewTreeObserver.OnScrollChangedListener {
        public j() {
        }

        /* JADX WARN: Code duplicated, block: B:13:0x003e A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0025, B:8:0x002b, B:10:0x002e, B:12:0x0032, B:13:0x003e), top: B:19:0x0000 }] */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                FrameLayout frameLayout = i.this.q;
                if (frameLayout != null) {
                    int[] iArr = new int[2];
                    frameLayout.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = i.this.q.getWidth();
                    int height = i.this.q.getHeight();
                    if (width + i > 0) {
                        i iVar = i.this;
                        if (i >= iVar.r || height + i2 <= 0 || i2 >= iVar.s) {
                            ShakeUtil.getInstance().a(i.this.i, false);
                        } else {
                            ShakeUtil.getInstance().a(i.this.i, true);
                        }
                    } else {
                        ShakeUtil.getInstance().a(i.this.i, false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class k implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f5205a;

        public k(t.a aVar) {
            this.f5205a = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                t.a(i.this.d(), motionEvent, this.f5205a);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class l extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchAdContainer f5206a;

        /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
        public class a implements q {
            public a() {
            }

            @Override // com.meishu.sdk.platform.ms.recycler.q
            public void a(ViewGroup viewGroup, float f, float f2, long j, float f3, float f4, int i) {
                l lVar = l.this;
                i iVar = i.this;
                TouchAdContainer touchAdContainer = lVar.f5206a;
                int i2 = i.C;
                iVar.a(touchAdContainer, f, f2, j, f3, f4, i);
            }
        }

        /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
        public class b extends r {
            public b(View view, int i) {
                super(view, i);
            }

            @Override // com.meishu.sdk.platform.ms.recycler.r
            public void a(float f, float f2, long j, float f3, float f4, int i) {
                l lVar = l.this;
                i iVar = i.this;
                TouchAdContainer touchAdContainer = lVar.f5206a;
                int i2 = i.C;
                iVar.a(touchAdContainer, f, f2, j, f3, f4, i);
            }
        }

        /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
        public class c implements View.OnTouchListener {
            public c() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == 0) {
                        i iVar = i.this;
                        int i = i.C;
                        iVar.c();
                    } else if (motionEvent.getAction() == 1) {
                        i iVar2 = i.this;
                        int i2 = i.C;
                        iVar2.getClass();
                        float f = i.this.n.getContext().getResources().getDisplayMetrics().density;
                        float f2 = t.d;
                        float fMax = (f2 <= 0.0f || t.e <= 0.0f) ? 0.0f : Math.max(Math.abs(f2 - motionEvent.getRawX()), Math.abs(t.e - motionEvent.getRawY()));
                        if (fMax > i.this.m) {
                            LogUtil.dev("i", "use rawXY");
                        }
                        i iVar3 = i.this;
                        iVar3.m = (int) Math.max(iVar3.m, fMax);
                        TouchPoint touchPointA = t.a(i.this.d(), motionEvent, f, i.this.m);
                        if (touchPointA == null) {
                            return false;
                        }
                        l lVar = l.this;
                        i iVar4 = i.this;
                        int i3 = iVar4.m;
                        if (i3 / f > i.C) {
                            float f3 = touchPointA.downX;
                            if (f3 > 0.0f) {
                                float f4 = touchPointA.downY;
                                if (f4 > 0.0f) {
                                    iVar4.a(lVar.f5206a, f3, f4, touchPointA.downTime, touchPointA.upX, touchPointA.upY, i3);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        }

        public l(TouchAdContainer touchAdContainer) {
            this.f5206a = touchAdContainer;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            View view;
            try {
                TouchAdContainer touchAdContainer = this.f5206a;
                if (touchAdContainer == null) {
                    view = null;
                    break;
                }
                try {
                    view = (View) touchAdContainer.getParent();
                    int i = 0;
                    while (true) {
                        if (view != null && i < 10) {
                            if ((view instanceof RecyclerView) || (view instanceof ListView) || (view instanceof ScrollView) || (view instanceof NestedScrollView)) {
                                break;
                            } else if (view.getParent() instanceof View) {
                                view = (View) view.getParent();
                                i++;
                            }
                            e.printStackTrace();
                        }
                        view = null;
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                u uVar = new u(view);
                if (uVar.f5231a && !q0.c()) {
                    new p(i.this.n, uVar.a() ? view : null).a(this.f5206a, i.C, new a());
                    return;
                }
                if (view != null) {
                    view.setOnTouchListener(new c());
                    return;
                }
                try {
                    i.this.n.setOnTouchListener(new b(this.f5206a.getChildAt(0), i.C));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class m implements ViewTreeObserver.OnScrollChangedListener {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (o1.a(((RecyclerMixAdLoader) i.this.b.getAdLoader()).getPosId(), i.this.f5193a.a().getAdp(), i.this.f5193a.a().getAdg())) {
                    int[] iArr = new int[2];
                    i.this.n.getLocationOnScreen(iArr);
                    if (iArr[1] > 0 && t.f == 0 && t.b > 0.0f && t.c > 0.0f) {
                        try {
                            t.a(i.this.d(), iArr[1]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        i.this.z = iArr[1];
                    }
                    i iVar = i.this;
                    if (iVar.A) {
                        iVar.z = iArr[1];
                        iVar.A = false;
                        return;
                    }
                    int i = iArr[1];
                    int iAbs = Math.abs(i - iVar.z);
                    if (iAbs > 5) {
                        i iVar2 = i.this;
                        iVar2.m += iAbs;
                        iVar2.z = i;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class n implements RecylcerAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5210a;
        public final /* synthetic */ List b;

        public n(Context context, List list) {
            this.f5210a = context;
            this.b = list;
        }

        @Override // com.meishu.sdk.core.loader.InteractionListener
        public void onAdClicked() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
        public void onAdClosed() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
        public void onAdExposure() {
            i.this.j = true;
            i iVar = i.this;
            if (iVar.p) {
                i.a(iVar);
                i.b(i.this);
            }
            i iVar2 = i.this;
            Context context = this.f5210a;
            List<View> list = this.b;
            iVar2.getClass();
            try {
                com.meishu.sdk.meishu_ad.nativ.b bVar = iVar2.f5193a;
                bVar.a(context, iVar2.c, list, new com.meishu.sdk.platform.ms.recycler.d(bVar, new com.meishu.sdk.platform.ms.recycler.e(iVar2)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
        public void onAdRenderFailed() {
        }
    }

    public i(com.meishu.sdk.platform.ms.recycler.c cVar, com.meishu.sdk.meishu_ad.nativ.b bVar, int i) {
        this.b = cVar;
        this.f5193a = bVar;
        this.x = i;
        if (this.i == 0) {
            this.i = ShakeUtil.getInstance().b();
        }
        try {
            AdType adType = AdType.FEED_MIX;
            adType.value();
            com.meishu.sdk.core.utils.h.a();
            this.f5193a.a().setAct_type(com.meishu.sdk.core.utils.h.a(this.f5193a.a().getAct_type(), adType.value()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bVar.a().getPower_index() > 0) {
            C = bVar.a().getPower_index() * 5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        int i;
        try {
            o1.b(this.f5193a.a().getEventUrl());
            this.d = recylcerAdInteractionListener;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_width() != null && ((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_width().intValue() > 0) {
                this.e = (int) (((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_width().intValue() / displayMetrics.density);
            }
            if (((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_height() != null && ((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_height().intValue() > 0) {
                this.f = (int) (((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_height().intValue() / displayMetrics.density);
            }
            int i2 = this.e;
            if ((i2 > 0 && i2 * displayMetrics.density < ((double) displayMetrics.widthPixels) * 0.3d) || ((i = this.f) > 0 && i * displayMetrics.density < ((double) displayMetrics.widthPixels) * 0.3d)) {
                LogUtil.e("i", "container size is too small");
                a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "container size is too small");
                return;
            }
            Rect rect = new Rect();
            Activity activity = context instanceof Activity ? (Activity) context : viewGroup.getContext() instanceof Activity ? (Activity) viewGroup.getContext() : null;
            if (activity != null && !this.k && Build.VERSION.SDK_INT >= 29) {
                this.k = true;
                activity.registerActivityLifecycleCallbacks(new com.meishu.sdk.platform.ms.recycler.k(this));
            }
            this.v = new WeakReference<>(activity);
            this.w = new WeakReference<>(viewGroup);
            FeedAdOverlayManager.getInstance().updateAdContainer(d(), viewGroup);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new g(viewGroup, rect));
            viewGroup.removeAllViews();
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup.getContext());
            touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f5193a));
            touchAdContainer.addView(adView, layoutParams);
            PositionView positionView = new PositionView(viewGroup.getContext());
            positionView.setTag(Integer.valueOf(this.i));
            positionView.setOnWindownEventListener(new C0851i());
            for (int i3 = 0; i3 < touchAdContainer.getChildCount(); i3++) {
                try {
                    View childAt = touchAdContainer.getChildAt(i3);
                    if (childAt instanceof PositionView) {
                        touchAdContainer.removeView(childAt);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            touchAdContainer.addView(positionView, 1, 1);
            viewGroup.addView(touchAdContainer);
            a(activity, touchAdContainer);
            try {
                this.f5193a.a().getAppendInfo().getHasClicked().a(new com.meishu.sdk.core.utils.b.a() { // from class: com.meishu.sdk.platform.ms.recycler.i$$ExternalSyntheticLambda0
                    @Override // com.meishu.sdk.core.utils.b.a
                    public final void a(Object obj, Object obj2) {
                        this.f$0.a((Boolean) obj, (Boolean) obj2);
                    }
                });
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            b(activity, touchAdContainer);
            o1.a(viewGroup, this.f5193a.a().getPosId(), this.f5193a.a().getLoadedTime());
            this.f5193a.setInteractionListener(this.d);
        } catch (Throwable th) {
            RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.d;
            if (recylcerAdInteractionListener2 != null) {
                recylcerAdInteractionListener2.onAdRenderFailed();
            }
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        ShakeUtil.getInstance().a(this.i);
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.f5193a;
        if (bVar != null && bVar.getMediaView() != null) {
            ((NormalMediaView) this.f5193a.getMediaView()).d();
        }
        try {
            FrameLayout frameLayout = this.q;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().removeOnScrollChangedListener(this.y);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            FeedAdOverlayManager.getInstance().removeOverlay(d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        return this.f5193a.getAdPatternType();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getCid());
            resultBean.setCat(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getCat());
            resultBean.setAderId(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getAder_id());
            resultBean.setFromId(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getFromId());
            resultBean.setDrawing(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getDrawing());
            resultBean.setPid(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getPosId());
            resultBean.setReqId(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getReq_id());
            resultBean.setPrice(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getEcpm());
            resultBean.setEcpm(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getEcpm() + "");
            resultBean.setS_ext(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getS_ext());
            resultBean.setS_code(((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getS_code());
            resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.b.f5177a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("MS");
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return this.f5193a.a().y * 1000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return this.f5193a.a().b;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        return com.meishu.sdk.core.utils.a.a(this.f5193a.a().getAder_id()) ? this.f5193a.a().getImageUrls() : new String[0];
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return this.f5193a.getInteractionType();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "MS";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return this.f5193a.a().f5047a;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(this.b.getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(this.b.getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
        this.h = expressMediaListener;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    public static boolean a(i iVar, byte[] bArr) {
        iVar.getClass();
        try {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            return new BigInteger(1, bArr2).toString(16).startsWith(com.huawei.openalliance.ad.constant.x.aw);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void b(Activity activity, TouchAdContainer touchAdContainer) {
        if (activity != null) {
            try {
                DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                this.r = displayMetrics.widthPixels;
                this.s = displayMetrics.heightPixels;
                try {
                    if (!com.meishu.sdk.core.utils.h.c(this.f5193a.a().getAct_type())) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.q == null) {
                    this.q = new FrameLayout(activity);
                    int height = -1;
                    int width = touchAdContainer.getWidth() <= 0 ? -1 : touchAdContainer.getWidth();
                    if (touchAdContainer.getHeight() > 0) {
                        height = touchAdContainer.getHeight();
                    }
                    this.q.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                    touchAdContainer.addView(this.q);
                }
                this.q.getViewTreeObserver().addOnScrollChangedListener(this.y);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void c() {
        t.a();
        this.m = 0;
        this.A = true;
        this.z = 0;
    }

    public final void d(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        String str;
        boolean zD = q0.d();
        int i5 = zD ? R.layout.ms_item_pre_render_large_image : R.layout.ms_item_pre_render_large_image_v2;
        if (styleBean != null) {
            int type = styleBean.getType();
            if (type == 201) {
                i5 = zD ? R.layout.ms_item_pre_render_large_image_top : R.layout.ms_item_pre_render_large_image_top_v2;
            } else if (type == 601 && !zD) {
                i5 = R.layout.ms_item_pre_render_large_image_top_v2_601;
            }
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_rootview);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_videocontainer);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imagebg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_content);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imageview);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_close);
        if (TextUtils.isEmpty(this.f5193a.a().title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f5193a.a().title);
        }
        if (TextUtils.isEmpty(this.f5193a.a().c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f5193a.a().c);
        }
        if (TextUtils.isEmpty(this.f5193a.a().e)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f5193a.a().e);
        }
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_layout);
        ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_image);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_shake_text);
        RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate.findViewById(R.id.ms_shakeRoot);
        ShakeImageView shakeImageView = (ShakeImageView) viewInflate.findViewById(R.id.ms_shake_img);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        LogUtil.d("i", com.meishu.sdk.activity.a.a("clkType=").append(this.f5193a.a().getAct_type()).toString());
        if (com.meishu.sdk.core.utils.h.d(this.f5193a.a().getAct_type())) {
            a(context, relativeLayout3, shakeImageView);
            imageView4.setVisibility(0);
            textView5.setVisibility(0);
            if (textView6 != null) {
                textView6.setText("摇一摇");
            }
            str = "摇动或点击";
        } else if (com.meishu.sdk.core.utils.h.e(this.f5193a.a().getAct_type())) {
            a(context, relativeLayout3, shakeImageView);
            imageView4.setVisibility(0);
            textView5.setVisibility(0);
            if (textView6 != null) {
                textView6.setText("扭一扭");
            }
            str = "扭动或点击";
        } else {
            if (viewGroup != null && !zD) {
                viewGroup.setVisibility(0);
                imageView4.setImageResource(R.drawable.ms_ic_right);
                imageView4.setVisibility(0);
                textView5.setVisibility(0);
            }
            str = "点击";
        }
        textView5.setText(str.concat(this.f5193a.a().getInteractionType() == 1 ? "立即下载" : "查看详情"));
        imageView2.setVisibility(8);
        a(imageView3);
        a(textView4, viewInflate);
        try {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i6 = this.e;
            if (i6 > 0) {
                layoutParams.width = (int) (i6 * displayMetrics.density);
            }
            int i7 = this.f;
            if (i7 > 0) {
                layoutParams.height = (int) (i7 * displayMetrics.density);
            }
            imageView.setLayoutParams(layoutParams);
            relativeLayout2.setVisibility(8);
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.f5193a;
            this.b.getContext();
            bVar.a(relativeLayout2, null, new com.meishu.sdk.platform.ms.recycler.b((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a, new com.meishu.sdk.platform.ms.recycler.h(this, relativeLayout2)));
            String str2 = this.f5193a.a().g;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    ExecutorService executorService = g0.f4905a;
                    g0.b.f4906a.a(new com.meishu.sdk.platform.ms.recycler.g(this, str2, context, imageView, styleBean, relativeLayout2));
                    if (!zD && (this.f5193a.getMediaView() instanceof NormalMediaView)) {
                        ((NormalMediaView) this.f5193a.getMediaView()).setRadius(6);
                    }
                } else if (!zD) {
                    ((NormalMediaView) this.f5193a.getMediaView()).setRadius(6);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (!zD || styleBean == null) {
            return;
        }
        if ((styleBean.getType() == 101 || styleBean.getType() == 201) && styleBean.getCreative() != null) {
            a(styleBean, this.c, textView, textView2, null, textView4, imageView3, textView3, null);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0063 A[PHI: r7
  0x0063: PHI (r7v5 com.meishu.sdk.core.domain.LayoutBean$StyleBean) = 
  (r7v0 com.meishu.sdk.core.domain.LayoutBean$StyleBean)
  (r7v1 com.meishu.sdk.core.domain.LayoutBean$StyleBean)
  (r7v0 com.meishu.sdk.core.domain.LayoutBean$StyleBean)
  (r7v2 com.meishu.sdk.core.domain.LayoutBean$StyleBean)
 binds: [B:12:0x003a, B:24:0x0060, B:14:0x0040, B:77:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x0067 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0087 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d5 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x0109 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0111 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x011d A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0128 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0132 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0135 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:61:0x0136 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0141 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x014c A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0157 A[Catch: all -> 0x0183, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0165 A[Catch: all -> 0x0183, TRY_LEAVE, TryCatch #1 {all -> 0x0183, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0021, B:10:0x0029, B:13:0x003c, B:16:0x0043, B:18:0x0049, B:20:0x0055, B:27:0x0067, B:29:0x006d, B:30:0x0075, B:32:0x0087, B:34:0x008b, B:36:0x00a9, B:38:0x00d5, B:65:0x0161, B:67:0x0165, B:50:0x00f1, B:51:0x00fd, B:52:0x0109, B:54:0x0111, B:55:0x011d, B:56:0x0128, B:59:0x0132, B:61:0x0136, B:62:0x0141, B:63:0x014c, B:64:0x0157, B:24:0x0060), top: B:75:0x0000, inners: #0 }] */
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getAdView() {
        LayoutBean.StyleBean styleBean;
        int[] iArrUserPreRenderPaddings;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int adPatternType;
        int type;
        try {
            if (this.c == null) {
                Context context = this.b.getContext();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i6 = this.f5193a.a().x;
                if (i6 < 1 || i6 > 6) {
                    i6 = 1;
                }
                LayoutBean layoutBeanA = com.meishu.sdk.core.utils.c.a.f4888a.a(context);
                if (layoutBeanA == null) {
                    layoutBeanA = (LayoutBean) new Gson().fromJson("{\n    \"dpi\": 160,\n    \"style\": [\n        {\n            \"id\": 1,\n            \"type\": 101,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    10,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    2\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    1,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    4,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    13,\n                    13,\n                    13,\n                    13\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 2,\n            \"type\": 201,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    5,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    3,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    10,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    8,\n                    8,\n                    8,\n                    8\n                ]}\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    10,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    1,\n                    3,\n                    1,\n                    3\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 11}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 3,\n            \"type\": 301,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            }\n            ,\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 4,\n            \"type\": 401,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            }, \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    20,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"000000\"\n                }\n            }\n        },\n        {\n            \"id\": 5,\n            \"type\": 501,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    16,\n                    0,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    9,\n                    0,\n                    12,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    15,\n                    0,\n                    0,\n                    6\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    14,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    4,\n                    2,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"creatives\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"childs\": {\n                    \"left\": {\n                        \"margin\": [\n                            0,\n                            2,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"center\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"right\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            2\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    }\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    10\n                ]\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    15,\n                    15,\n                    15,\n                    15\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    8,\n                    0,\n                    8,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    9,\n                    4,\n                    9\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 13,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        }\n    ]\n}", LayoutBean.class);
                }
                LayoutBean.StyleBean styleBean2 = null;
                if (layoutBeanA != null) {
                    try {
                        List<LayoutBean.StyleBean> style = layoutBeanA.getStyle();
                        if (style != null) {
                            for (int i7 = 0; i7 < style.size(); i7++) {
                                if (i6 == style.get(i7).getId()) {
                                    styleBean2 = style.get(i7);
                                }
                            }
                            if (i6 == 6 && !q0.d()) {
                                styleBean2 = new LayoutBean.StyleBean();
                                styleBean2.setType(601);
                            }
                            styleBean = styleBean2;
                            float f2 = displayMetrics.density;
                            iArrUserPreRenderPaddings = AdSdk.adConfig().userPreRenderPaddings();
                            i = (int) (16.0f * f2);
                            if (iArrUserPreRenderPaddings == null && iArrUserPreRenderPaddings.length == 4) {
                                int i8 = (int) (iArrUserPreRenderPaddings[0] * f2);
                                int i9 = (int) (iArrUserPreRenderPaddings[1] * f2);
                                int i10 = (int) (iArrUserPreRenderPaddings[2] * f2);
                                i5 = (int) (iArrUserPreRenderPaddings[3] * f2);
                                i4 = i10;
                                i3 = i9;
                                i2 = i8;
                            } else {
                                i2 = i;
                                i3 = i2;
                                i4 = i3;
                                i5 = i4;
                            }
                            LogUtil.d("i", "AdPatternType = " + this.f5193a.getAdPatternType());
                            this.f5193a.a().C = System.currentTimeMillis();
                            if (styleBean != null) {
                                type = styleBean.getType();
                                if (type != 101 || type == 201) {
                                    if (this.f5193a.getAdPatternType() == 2) {
                                        d(context, styleBean, i2, i3, i4, i5);
                                    } else {
                                        c(context, styleBean, i2, i3, i4, i5);
                                    }
                                } else if (type == 301 || type == 401) {
                                    a(context, styleBean, i2, i3, i4, i5);
                                } else if (type == 501) {
                                    b(context, styleBean, i2, i3, i4, i5);
                                } else if (type == 601) {
                                    if (this.f5193a.getAdPatternType() == 2) {
                                        d(context, styleBean, i2, i3, i4, i5);
                                    } else {
                                        c(context, styleBean, i2, i3, i4, i5);
                                    }
                                }
                            } else {
                                adPatternType = this.f5193a.getAdPatternType();
                                if (adPatternType == 1) {
                                    c(context, styleBean, i2, i3, i4, i5);
                                } else if (adPatternType != 2) {
                                    switch (adPatternType) {
                                        case 11:
                                            a(context, styleBean, i2, i3, i4, i5);
                                            break;
                                        case 12:
                                            c(context, styleBean, i2, i3, i4, i5);
                                            break;
                                        case 13:
                                            b(context, styleBean, i2, i3, i4, i5);
                                            break;
                                    }
                                } else {
                                    d(context, styleBean, i2, i3, i4, i5);
                                }
                            }
                            if (this.c != null) {
                                new DownloadView().handleFeedDownloadView(this.c, this.f5193a.a(), styleBean);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(this.c);
                                a(context, arrayList);
                            }
                        } else {
                            if (i6 == 6) {
                                styleBean2 = new LayoutBean.StyleBean();
                                styleBean2.setType(601);
                            }
                            styleBean = styleBean2;
                            float f3 = displayMetrics.density;
                            iArrUserPreRenderPaddings = AdSdk.adConfig().userPreRenderPaddings();
                            i = (int) (16.0f * f3);
                            if (iArrUserPreRenderPaddings == null) {
                                i2 = i;
                                i3 = i2;
                                i4 = i3;
                                i5 = i4;
                            } else {
                                i2 = i;
                                i3 = i2;
                                i4 = i3;
                                i5 = i4;
                            }
                            LogUtil.d("i", "AdPatternType = " + this.f5193a.getAdPatternType());
                            this.f5193a.a().C = System.currentTimeMillis();
                            if (styleBean != null) {
                                type = styleBean.getType();
                                if (type != 101) {
                                    if (this.f5193a.getAdPatternType() == 2) {
                                        d(context, styleBean, i2, i3, i4, i5);
                                    } else {
                                        c(context, styleBean, i2, i3, i4, i5);
                                    }
                                } else if (this.f5193a.getAdPatternType() == 2) {
                                    d(context, styleBean, i2, i3, i4, i5);
                                } else {
                                    c(context, styleBean, i2, i3, i4, i5);
                                }
                            } else {
                                adPatternType = this.f5193a.getAdPatternType();
                                if (adPatternType == 1) {
                                    c(context, styleBean, i2, i3, i4, i5);
                                } else if (adPatternType != 2) {
                                    switch (adPatternType) {
                                        case 11:
                                            a(context, styleBean, i2, i3, i4, i5);
                                            break;
                                        case 12:
                                            c(context, styleBean, i2, i3, i4, i5);
                                            break;
                                        case 13:
                                            b(context, styleBean, i2, i3, i4, i5);
                                            break;
                                    }
                                } else {
                                    d(context, styleBean, i2, i3, i4, i5);
                                }
                            }
                            if (this.c != null) {
                                new DownloadView().handleFeedDownloadView(this.c, this.f5193a.a(), styleBean);
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(this.c);
                                a(context, arrayList2);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    if (i6 == 6) {
                        styleBean2 = new LayoutBean.StyleBean();
                        styleBean2.setType(601);
                    }
                    styleBean = styleBean2;
                    float f4 = displayMetrics.density;
                    iArrUserPreRenderPaddings = AdSdk.adConfig().userPreRenderPaddings();
                    i = (int) (16.0f * f4);
                    if (iArrUserPreRenderPaddings == null) {
                        i2 = i;
                        i3 = i2;
                        i4 = i3;
                        i5 = i4;
                    } else {
                        i2 = i;
                        i3 = i2;
                        i4 = i3;
                        i5 = i4;
                    }
                    LogUtil.d("i", "AdPatternType = " + this.f5193a.getAdPatternType());
                    this.f5193a.a().C = System.currentTimeMillis();
                    if (styleBean != null) {
                        type = styleBean.getType();
                        if (type != 101) {
                            if (this.f5193a.getAdPatternType() == 2) {
                                d(context, styleBean, i2, i3, i4, i5);
                            } else {
                                c(context, styleBean, i2, i3, i4, i5);
                            }
                        } else if (this.f5193a.getAdPatternType() == 2) {
                            d(context, styleBean, i2, i3, i4, i5);
                        } else {
                            c(context, styleBean, i2, i3, i4, i5);
                        }
                    } else {
                        adPatternType = this.f5193a.getAdPatternType();
                        if (adPatternType == 1) {
                            c(context, styleBean, i2, i3, i4, i5);
                        } else if (adPatternType != 2) {
                            switch (adPatternType) {
                                case 11:
                                    a(context, styleBean, i2, i3, i4, i5);
                                    break;
                                case 12:
                                    c(context, styleBean, i2, i3, i4, i5);
                                    break;
                                case 13:
                                    b(context, styleBean, i2, i3, i4, i5);
                                    break;
                            }
                        } else {
                            d(context, styleBean, i2, i3, i4, i5);
                        }
                    }
                    if (this.c != null) {
                        new DownloadView().handleFeedDownloadView(this.c, this.f5193a.a(), styleBean);
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(this.c);
                        a(context, arrayList3);
                    }
                }
            }
        } catch (Throwable th) {
            a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "渲染失败");
            th.printStackTrace();
        }
        return this.c;
    }

    public static void c(i iVar) {
        if (!iVar.j && iVar.g && iVar.p) {
            iVar.j = true;
            if (iVar.b.c != null && iVar.f5193a.getAdPatternType() != 2) {
                com.meishu.sdk.meishu_ad.nativ.f fVarA = iVar.f5193a.a();
                String[] monitorUrl = iVar.f5193a.a().getMonitorUrl();
                StringBuilder sbAppend = new StringBuilder().append(iVar.f5193a.a().C).append(".0.");
                iVar.f5193a.a().getClass();
                fVarA.setMonitorUrl(h0.b(monitorUrl, sbAppend.append(iVar.f5193a.a().D).toString()));
                iVar.b.c.onADExposure();
                RecylcerAdInteractionListener recylcerAdInteractionListener = iVar.d;
                if (recylcerAdInteractionListener != null) {
                    recylcerAdInteractionListener.onAdExposure();
                }
                iVar.f5193a.a().B = true;
                iVar.b();
            }
            if (!com.meishu.sdk.core.utils.h.c(iVar.f5193a.a().getAct_type()) || iVar.f5193a.getAdPatternType() == 2) {
                return;
            }
            int iB = com.meishu.sdk.core.utils.h.b(iVar.f5193a.a().getAct_type());
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(iVar.f5193a.a().getPosId(), iVar.f5193a.a().getLoadedTime(), iVar.f5193a.a().getDclk());
            ShakeUtil.getInstance().a(iVar.f5193a.a().getPower_index2(), iVar.f5193a.a().getPower_index(), iB, iVar.f5193a.a().getPower_delay(), iVar.f5193a.a().getPower_count(), iVar.i, iVar.f5193a.a().getEcpm(), new com.meishu.sdk.platform.ms.recycler.j(iVar, jCurrentTimeMillis));
            ShakeUtil.getInstance().a(true);
        }
    }

    public static void a(i iVar) {
        iVar.getClass();
        try {
            if (iVar.t) {
                return;
            }
            iVar.t = true;
            try {
                iVar.b.c.onADExposure();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = iVar.d;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
            iVar.f5193a.a().B = true;
            iVar.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(i iVar) {
        if (com.meishu.sdk.core.utils.h.c(iVar.f5193a.a().getAct_type()) && iVar.f5193a.getAdPatternType() == 2) {
            int iB = com.meishu.sdk.core.utils.h.b(iVar.f5193a.a().getAct_type());
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(iVar.f5193a.a().getPosId(), iVar.f5193a.a().getLoadedTime(), iVar.f5193a.a().getDclk());
            ShakeUtil.getInstance().a(iVar.f5193a.a().getPower_index2(), iVar.f5193a.a().getPower_index(), iB, iVar.f5193a.a().getPower_delay(), iVar.f5193a.a().getPower_count(), iVar.i, iVar.f5193a.a().getEcpm(), new com.meishu.sdk.platform.ms.recycler.f(iVar, jCurrentTimeMillis));
            ShakeUtil.getInstance().a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(Boolean bool, Boolean bool2) {
        c();
        WeakReference<Activity> weakReference = this.v;
        FeedAdOverlayManager.getInstance().onAdClickedIfOverlayExists(d(), ((RecyclerMixAdLoader) this.b.getAdLoader()).getPosId(), weakReference != null ? weakReference.get() : null);
    }

    public final void b(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int iIntValue;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Context context2 = context;
        this.u = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        if (this.f5193a.getImgUrls() == null || this.f5193a.getImgUrls().length <= 0) {
            return;
        }
        boolean zD = q0.d();
        if (zD) {
            i5 = R.layout.ms_item_pre_render_three_img;
        } else {
            i5 = R.layout.ms_item_pre_render_three_img_v2;
        }
        View viewInflate = View.inflate(context2, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_container);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_close);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_type);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_three_shake_image);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_shakeRoot);
        ShakeImageView shakeImageView = (ShakeImageView) viewInflate.findViewById(R.id.ms_shake_img);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        boolean z2 = false;
        if ((this.f5193a.a().getAct_type() & 4) != 4 && (this.f5193a.a().getAct_type() & 64) != 64) {
            if (com.meishu.sdk.core.utils.h.e(this.f5193a.a().getAct_type())) {
                a(context2, relativeLayout2, shakeImageView);
                imageView2.setVisibility(0);
                if (textView5 != null) {
                    textView5.setText("扭一扭");
                }
                str = "扭动或点击";
            } else {
                if (!zD) {
                    imageView2.setImageResource(R.drawable.ms_ic_right);
                    imageView2.setVisibility(0);
                }
                str = "点击";
            }
        } else {
            a(context2, relativeLayout2, shakeImageView);
            imageView2.setVisibility(0);
            if (textView5 != null) {
                textView5.setText("摇一摇");
            }
            str = "摇动或点击";
        }
        textView4.setText(str.concat(this.f5193a.getInteractionType() == 1 ? "立即下载" : "查看详情"));
        textView.setText(this.f5193a.getTitle());
        textView3.setText(this.f5193a.a().e);
        a(imageView);
        a(textView2, viewInflate);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_containerll);
        int i16 = 0;
        int i17 = 0;
        while (i16 < this.f5193a.getImgUrls().length) {
            String str2 = this.f5193a.getImgUrls()[i16];
            if (TextUtils.isEmpty(str2)) {
                textView4 = textView4;
                z = z2;
            } else {
                RoundImageView roundImageView = new RoundImageView(context2);
                roundImageView.setAdjustViewBounds(true);
                roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                roundImageView.setCornerRadius(2);
                if (!zD || styleBean == null || styleBean.getCreatives() == null) {
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    iIntValue = 6;
                } else {
                    if (i16 != 0 || styleBean.getCreatives().getChilds().getLeft().getMargin().size() < 4) {
                        i9 = 0;
                        i10 = 1;
                        iIntValue = 6;
                        i11 = 0;
                        i12 = 0;
                    } else {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean left = styleBean.getCreatives().getChilds().getLeft();
                        int iIntValue2 = left.getMargin().get(3).intValue();
                        int iIntValue3 = left.getMargin().get(0).intValue();
                        int iIntValue4 = left.getMargin().get(1).intValue();
                        int iIntValue5 = left.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border = styleBean.getCreatives().getChilds().getLeft().getBorder();
                        if (border == null || !border.getClip() || border.getRadius() == null) {
                            i12 = iIntValue4;
                            i11 = iIntValue5;
                        } else {
                            i12 = iIntValue4;
                            i11 = iIntValue5;
                            if (border.getRadius().size() >= 4) {
                                roundImageView.setCornerTopLeftRadius((int) (border.getRadius().get(0).intValue() * f2));
                                roundImageView.setCornerTopRightRadius((int) (border.getRadius().get(1).intValue() * f2));
                                roundImageView.setCornerBottomRightRadius((int) (border.getRadius().get(2).intValue() * f2));
                                roundImageView.setCornerBottomLeftRadius((int) (border.getRadius().get(3).intValue() * f2));
                            }
                        }
                        i9 = iIntValue3;
                        iIntValue = iIntValue2;
                        i10 = 1;
                    }
                    if (i16 != i10 || styleBean.getCreatives().getChilds().getCenter().getMargin().size() < 4) {
                        i13 = 2;
                        int i18 = i12;
                        i14 = i11;
                        i15 = i18;
                    } else {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean center = styleBean.getCreatives().getChilds().getCenter();
                        int iIntValue6 = center.getMargin().get(3).intValue();
                        int iIntValue7 = center.getMargin().get(0).intValue();
                        int iIntValue8 = center.getMargin().get(1).intValue();
                        int iIntValue9 = center.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border2 = styleBean.getCreatives().getChilds().getCenter().getBorder();
                        if (border2 == null || !border2.getClip() || border2.getRadius() == null) {
                            i14 = iIntValue9;
                            i15 = iIntValue8;
                        } else {
                            i14 = iIntValue9;
                            i15 = iIntValue8;
                            if (border2.getRadius().size() >= 4) {
                                roundImageView.setCornerTopLeftRadius((int) (border2.getRadius().get(0).intValue() * f2));
                                roundImageView.setCornerTopRightRadius((int) (border2.getRadius().get(1).intValue() * f2));
                                roundImageView.setCornerBottomRightRadius((int) (border2.getRadius().get(2).intValue() * f2));
                                roundImageView.setCornerBottomLeftRadius((int) (border2.getRadius().get(3).intValue() * f2));
                            }
                        }
                        iIntValue = iIntValue6;
                        i9 = iIntValue7;
                        i13 = 2;
                    }
                    if (i16 != i13 || styleBean.getCreatives().getChilds().getRight().getMargin().size() < 4) {
                        i8 = i9;
                    } else {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean right = styleBean.getCreatives().getChilds().getRight();
                        iIntValue = right.getMargin().get(3).intValue();
                        int iIntValue10 = right.getMargin().get(0).intValue();
                        int iIntValue11 = right.getMargin().get(1).intValue();
                        int iIntValue12 = right.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border3 = styleBean.getCreatives().getChilds().getRight().getBorder();
                        if (border3 == null || !border3.getClip() || border3.getRadius() == null) {
                            i14 = iIntValue12;
                            i15 = iIntValue11;
                        } else {
                            i14 = iIntValue12;
                            i15 = iIntValue11;
                            if (border3.getRadius().size() >= 4) {
                                roundImageView.setCornerTopLeftRadius((int) (border3.getRadius().get(0).intValue() * f2));
                                roundImageView.setCornerTopRightRadius((int) (border3.getRadius().get(1).intValue() * f2));
                                roundImageView.setCornerBottomRightRadius((int) (border3.getRadius().get(2).intValue() * f2));
                                roundImageView.setCornerBottomLeftRadius((int) (border3.getRadius().get(3).intValue() * f2));
                            }
                        }
                        i8 = iIntValue10;
                    }
                    i7 = i15;
                    i6 = i14;
                }
                z = false;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                int i19 = i17 + 1;
                if (i17 > 0) {
                    layoutParams.setMargins((int) (iIntValue * f2), (int) (i8 * f2), (int) (i7 * f2), (int) (i6 * f2));
                }
                linearLayout.addView(roundImageView, layoutParams);
                com.meishu.sdk.core.cache.a.a(str2, new c(roundImageView), true);
                i17 = i19;
            }
            i16++;
            context2 = context;
            textView4 = textView4;
            textView3 = textView3;
            z2 = z;
            imageView = imageView;
            textView2 = textView2;
        }
        TextView textView6 = textView2;
        ImageView imageView3 = imageView;
        TextView textView7 = textView3;
        TextView textView8 = textView4;
        if (zD && styleBean != null && styleBean.getType() == 501) {
            a(styleBean, this.c, textView, null, null, textView6, imageView3, textView7, textView8);
        }
    }

    public final void a(Activity activity, final TouchAdContainer touchAdContainer) {
        if (activity != null) {
            try {
                try {
                    if ((this.f5193a.a().getAct_type() & 512) != 512) {
                        touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f5193a));
                        return;
                    }
                    this.o = touchAdContainer;
                    int childCount = touchAdContainer.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        if (touchAdContainer.getChildAt(i) == this.n) {
                            this.n.setOnTouchListener(new k(new t.a() { // from class: com.meishu.sdk.platform.ms.recycler.i$$ExternalSyntheticLambda1
                                @Override // com.meishu.sdk.platform.ms.recycler.t.a
                                public final void a(float f2, float f3, long j2, float f4, float f5, float f6, int i2) {
                                    this.f$0.a(touchAdContainer, f2, f3, j2, f4, f5, f6, i2);
                                }
                            }));
                            touchAdContainer.post(new l(touchAdContainer));
                            touchAdContainer.getViewTreeObserver().addOnScrollChangedListener(this.B);
                            return;
                        }
                    }
                    this.n = new FrameLayout(activity);
                    int height = -1;
                    int width = touchAdContainer.getWidth() <= 0 ? -1 : touchAdContainer.getWidth();
                    if (touchAdContainer.getHeight() > 0) {
                        height = touchAdContainer.getHeight();
                    }
                    this.n.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                    touchAdContainer.addView(this.n);
                    this.n.setOnTouchListener(new k(new t.a() { // from class: com.meishu.sdk.platform.ms.recycler.i$$ExternalSyntheticLambda1
                        @Override // com.meishu.sdk.platform.ms.recycler.t.a
                        public final void a(float f2, float f3, long j2, float f4, float f5, float f6, int i2) {
                            this.f$0.a(touchAdContainer, f2, f3, j2, f4, f5, f6, i2);
                        }
                    }));
                    touchAdContainer.post(new l(touchAdContainer));
                    touchAdContainer.getViewTreeObserver().addOnScrollChangedListener(this.B);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        int i5;
        i iVar;
        boolean zD = q0.d();
        if (zD) {
            i5 = R.layout.ms_item_pre_render_large_image;
        } else {
            i5 = R.layout.ms_item_pre_render_large_image_v2;
        }
        if (styleBean != null) {
            int type = styleBean.getType();
            if (type != 201) {
                if (type == 601 && !zD) {
                    i5 = R.layout.ms_item_pre_render_large_image_top_v2_601;
                }
            } else if (zD) {
                i5 = R.layout.ms_item_pre_render_large_image_top;
            } else {
                i5 = R.layout.ms_item_pre_render_large_image_top_v2;
            }
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_rootview);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_content);
        RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imageview);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imagebg);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_close);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_layout);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_image);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_shake_text);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_shakeRoot);
        ShakeImageView shakeImageView = (ShakeImageView) viewInflate.findViewById(R.id.ms_shake_img);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        LogUtil.d("i", com.meishu.sdk.activity.a.a("clkType=").append(this.f5193a.a().getAct_type()).toString());
        if (TextUtils.isEmpty(this.f5193a.a().title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f5193a.a().title);
        }
        if (TextUtils.isEmpty(this.f5193a.a().c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f5193a.a().c);
        }
        if (this.f5193a.a().e == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f5193a.a().e);
        }
        if (this.f5193a.getImgUrls() != null && this.f5193a.getImgUrls().length > 0 && !TextUtils.isEmpty(this.f5193a.getImgUrls()[0])) {
            LogUtil.i("i", com.meishu.sdk.activity.a.a(" 容器宽度：").append(((RecyclerMixAdLoader) this.b.getAdLoader()).getAccept_ad_width()).toString());
            com.meishu.sdk.core.cache.a.a(this.f5193a.getImgUrls()[0], new d(roundImageView, (context.getResources().getDisplayMetrics().widthPixels - i) - i3, context, imageView, relativeLayout2, shakeImageView, imageView3, textView5, textView6, viewGroup, zD), true);
            iVar = this;
        } else {
            iVar = this;
            iVar.a(ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片加载错误");
        }
        iVar.a(imageView2);
        iVar.a(textView4, viewInflate);
        if (!zD || styleBean == null) {
            return;
        }
        if (styleBean.getType() == 101 || styleBean.getType() == 201) {
            a(styleBean, iVar.c, textView, textView2, roundImageView, textView4, imageView2, textView3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TouchAdContainer touchAdContainer, float f2, float f3, long j2, float f4, float f5, float f6, int i) {
        if (i / f6 > C) {
            a(touchAdContainer, f2, f3, j2, f4, f5, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(TouchAdContainer touchAdContainer, float f2, float f3, long j2, float f4, float f5, int i) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        try {
            if (this.l || !this.f5193a.a().B) {
                return;
            }
            this.l = true;
            try {
                if (this.f5193a.a().getCbc() == 0 && (recylcerAdInteractionListener = this.d) != null) {
                    recylcerAdInteractionListener.onAdClicked();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.meishu.sdk.core.utils.q.a().b(((RecyclerMixAdLoader) this.b.getAdLoader()).getPosId() + "_adp", jCurrentTimeMillis);
            com.meishu.sdk.core.utils.q.a().b("adg_time", jCurrentTimeMillis);
            this.f5193a.a().setClkActType(512);
            this.f5193a.a().setClkPower(i);
            s.a(this.f5193a, f2, f3, j2, f4, f5);
            c();
            h0.a(this.f5193a, touchAdContainer);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5193a, false);
            try {
                this.n.getViewTreeObserver().removeOnScrollChangedListener(this.B);
            } catch (Exception unused) {
            }
            try {
                touchAdContainer.removeView(this.n);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        try {
            WeakReference<Activity> weakReference = this.v;
            Activity activity = weakReference != null ? weakReference.get() : null;
            WeakReference<ViewGroup> weakReference2 = this.w;
            ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
            if (activity != null && viewGroup != null) {
                FeedAdOverlayManager.getInstance().addOverlay(activity, viewGroup, ((RecyclerMixAdLoader) this.b.getAdLoader()).getPosId(), C, this.f5193a.a(), d(), new h(viewGroup));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(Context context, List<View> list) {
        if (this.f5193a.getAdPatternType() == 2) {
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.f5193a;
            if (bVar instanceof com.meishu.sdk.meishu_ad.nativ.d) {
                com.meishu.sdk.meishu_ad.nativ.d dVar = (com.meishu.sdk.meishu_ad.nativ.d) bVar;
                n nVar = new n(context, list);
                if (dVar.h.getVideoView() instanceof NormalMediaView) {
                    ((NormalMediaView) dVar.h.getVideoView()).setOnExposureListener(nVar);
                    return;
                }
                return;
            }
            return;
        }
        try {
            com.meishu.sdk.meishu_ad.nativ.b bVar2 = this.f5193a;
            bVar2.a(context, this.c, list, new com.meishu.sdk.platform.ms.recycler.d(bVar2, new com.meishu.sdk.platform.ms.recycler.e(this)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        int i5;
        TextView textView;
        TextView textView2;
        boolean zD = q0.d();
        this.u = true;
        if (zD) {
            i5 = R.layout.ms_item_pre_render_smallimage;
        } else {
            i5 = R.layout.ms_item_pre_render_smallimage_v2;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        if (styleBean != null && styleBean.getType() == 401) {
            if (zD) {
                i5 = R.layout.ms_item_pre_render_smallimage_left;
            } else {
                i5 = R.layout.ms_item_pre_render_smallimage_left_v2;
            }
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_rootView);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_imageview);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_videoContainer);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_small_iamge_imagebg);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_title);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_content);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_fromtext);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_shake_text);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_close);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_shake_image);
        RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate.findViewById(R.id.ms_shakeRoot);
        ShakeImageView shakeImageView = (ShakeImageView) viewInflate.findViewById(R.id.ms_shake_img);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        textView3.setText(this.f5193a.a().title);
        textView4.setText(this.f5193a.a().c);
        textView5.setText(this.f5193a.a().e);
        if (com.meishu.sdk.core.utils.h.d(this.f5193a.a().getAct_type())) {
            a(context, relativeLayout3, shakeImageView);
            imageView3.setVisibility(0);
            if (textView8 != null) {
                textView8.setText("摇一摇");
            }
        } else if (com.meishu.sdk.core.utils.h.e(this.f5193a.a().getAct_type())) {
            a(context, relativeLayout3, shakeImageView);
            imageView3.setVisibility(0);
            if (textView8 != null) {
                textView8.setText("扭一扭");
            }
        } else if (!zD) {
            imageView3.setImageResource(R.drawable.ms_ic_right);
            imageView3.setVisibility(0);
        }
        String str = this.f5193a.a().getInteractionType() == 1 ? "立即下载" : "查看详情";
        if (textView6 != null) {
            textView6.setText(str);
        }
        if (this.f5193a.getAdPatternType() == 2) {
            roundImageView.setVisibility(4);
            relativeLayout2.setVisibility(0);
            try {
                NormalMediaView normalMediaView = (NormalMediaView) this.f5193a.getMediaView();
                if (normalMediaView != null) {
                    normalMediaView.setDisplayMode(1);
                    normalMediaView.setContainerWidth(displayMetrics.density * 100.0f);
                    normalMediaView.setContainerHeight(displayMetrics.density * 75.0f);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.f5193a;
            this.b.getContext();
            bVar.a(relativeLayout2, null, new com.meishu.sdk.platform.ms.recycler.b((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a, new a()));
            String str2 = this.f5193a.getImgUrls()[0];
            try {
                if (TextUtils.isEmpty(str2)) {
                    textView = textView7;
                    textView2 = textView4;
                } else {
                    ExecutorService executorService = g0.f4905a;
                    textView = textView7;
                    textView2 = textView4;
                    try {
                        g0.b.f4906a.a(new com.meishu.sdk.platform.ms.recycler.g(this, str2, context, imageView, styleBean, relativeLayout2));
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                textView = textView7;
                textView2 = textView4;
            }
        } else {
            textView = textView7;
            textView2 = textView4;
            relativeLayout2.setVisibility(8);
            roundImageView.setVisibility(0);
            com.meishu.sdk.core.cache.a.a(this.f5193a.getImgUrls()[0], new b(roundImageView, context, f2, imageView), true);
        }
        a(imageView2);
        a(textView, viewInflate);
        if (zD && styleBean != null && (styleBean.getType() == 301 || styleBean.getType() == 401)) {
            a(styleBean, this.c, textView3, textView2, roundImageView, textView, imageView2, textView5, null);
        }
        if (zD) {
            return;
        }
        try {
            if (((com.meishu.sdk.meishu_ad.nativ.f) this.b.f5177a).getInteractionType() == 1) {
                return;
            }
            RelativeLayout relativeLayout4 = (RelativeLayout) this.c.findViewById(R.id.ms_item_pre_render_smallimage_app_logo_name);
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.ms_item_pre_render_smallimage_logo_layout);
            if (relativeLayout4 != null && viewGroup != null) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(15);
                relativeLayout4.addView(viewGroup, layoutParams);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String d() {
        try {
            return this.f5193a.a().getReq_id() + "_" + this.x;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void a(Context context, RelativeLayout relativeLayout, ShakeImageView shakeImageView) {
        if (this.u && !q0.d()) {
            LogUtil.dev("i", "no show shake float view");
        } else {
            this.c.post(new e(context, relativeLayout, shakeImageView));
        }
    }

    public final void a(int i, String str) {
        try {
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.d;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdRenderFailed();
            }
            SdkHandler.getInstance().runOnUiThread(new com.meishu.sdk.core.utils.p(this.f5193a.a().getErrorUrl(), i, str));
            o1.b(this.f5193a.a().getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), str);
            h0.b(this.f5193a.a().getMonitorUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(TextView textView, View view) {
        textView.setOnClickListener(new f(view));
    }

    public final void a(ImageView imageView) {
        if (!TextUtils.isEmpty(this.f5193a.a().getFromLogo())) {
            new com.meishu.sdk.core.bquery.i(imageView).a(this.f5193a.a().getFromLogo(), false);
        }
        if (AdSdk.adConfig().showLogo()) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public GradientDrawable a(List<Integer> list, int i, String str) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            if (i > 0) {
                gradientDrawable.setStroke(i, Color.parseColor(str));
            }
            if (list != null && list.size() == 4) {
                gradientDrawable.setCornerRadii(new float[]{list.get(0).intValue(), list.get(0).intValue(), list.get(1).intValue(), list.get(1).intValue(), list.get(2).intValue(), list.get(2).intValue(), list.get(3).intValue(), list.get(3).intValue()});
            }
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }

    public final void a(LayoutBean.StyleBean styleBean, RelativeLayout relativeLayout, TextView textView, TextView textView2, RoundImageView roundImageView, TextView textView3, ImageView imageView, TextView textView4, TextView textView5) {
        LayoutBean.StyleBean.BorderBean border;
        try {
            float f2 = this.b.getContext().getResources().getDisplayMetrics().density;
            if (styleBean.getContainer() != null && relativeLayout != null) {
                List<Integer> padding = styleBean.getContainer().getPadding();
                if (padding != null && padding.size() >= 4) {
                    relativeLayout.setPadding((int) (padding.get(3).intValue() * f2), (int) (padding.get(0).intValue() * f2), (int) (padding.get(1).intValue() * f2), (int) (padding.get(2).intValue() * f2));
                }
                LayoutBean.StyleBean.BorderBean border2 = styleBean.getContainer().getBorder();
                if (border2 != null && border2.getClip() && border2.getRadius() != null && border2.getRadius().size() >= 4) {
                    relativeLayout.setBackground(a(border2.getRadius(), 0, ""));
                }
            }
            if (styleBean.getTitle() != null && textView != null) {
                if (styleBean.getTitle().getMargin() != null && styleBean.getTitle().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    marginLayoutParams.topMargin = (int) (styleBean.getTitle().getMargin().get(0).intValue() * f2);
                    marginLayoutParams.rightMargin = (int) (styleBean.getTitle().getMargin().get(1).intValue() * f2);
                    marginLayoutParams.bottomMargin = (int) (styleBean.getTitle().getMargin().get(2).intValue() * f2);
                    marginLayoutParams.leftMargin = (int) (styleBean.getTitle().getMargin().get(3).intValue() * f2);
                    textView.setLayoutParams(marginLayoutParams);
                }
                if (styleBean.getTitle().getPadding() != null && styleBean.getTitle().getPadding().size() >= 4) {
                    textView.setPadding((int) (styleBean.getTitle().getPadding().get(3).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(0).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(1).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(2).intValue() * f2));
                }
                if (styleBean.getTitle().getText() != null) {
                    if (!TextUtils.isEmpty(styleBean.getTitle().getText().getColor())) {
                        textView.setTextColor(Color.parseColor("#" + styleBean.getTitle().getText().getColor()));
                    }
                    if (styleBean.getTitle().getText().getSize() > 0) {
                        textView.setTextSize(styleBean.getTitle().getText().getSize());
                    }
                    if (styleBean.getTitle().getText().getLines() == 0) {
                        textView.setMaxLines(20);
                    } else {
                        textView.setMaxLines(styleBean.getTitle().getText().getLines());
                    }
                }
            }
            if (styleBean.getContent() != null && textView2 != null) {
                if (styleBean.getContent().getMargin() != null && styleBean.getContent().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) (styleBean.getContent().getMargin().get(0).intValue() * f2);
                    marginLayoutParams2.rightMargin = (int) (styleBean.getContent().getMargin().get(1).intValue() * f2);
                    marginLayoutParams2.bottomMargin = (int) (styleBean.getContent().getMargin().get(2).intValue() * f2);
                    marginLayoutParams2.leftMargin = (int) (styleBean.getContent().getMargin().get(3).intValue() * f2);
                    textView2.setLayoutParams(marginLayoutParams2);
                }
                if (styleBean.getContent().getPadding() != null && styleBean.getContent().getPadding().size() >= 4) {
                    textView2.setPadding((int) (styleBean.getContent().getPadding().get(3).intValue() * f2), (int) (styleBean.getContent().getPadding().get(0).intValue() * f2), (int) (styleBean.getContent().getPadding().get(1).intValue() * f2), (int) (styleBean.getContent().getPadding().get(2).intValue() * f2));
                }
                if (styleBean.getContent().getText() != null) {
                    if (!TextUtils.isEmpty(styleBean.getContent().getText().getColor())) {
                        textView2.setTextColor(Color.parseColor("#" + styleBean.getContent().getText().getColor()));
                    }
                    if (styleBean.getContent().getText().getSize() > 0) {
                        textView2.setTextSize(styleBean.getContent().getText().getSize());
                    }
                    if (styleBean.getContent().getText().getLines() == 0) {
                        textView.setMaxLines(20);
                    } else {
                        textView.setMaxLines(styleBean.getContent().getText().getLines());
                    }
                }
            }
            if (styleBean.getCreative() != null && roundImageView != null) {
                LayoutBean.StyleBean.BorderBean border3 = styleBean.getCreative().getBorder();
                if (border3 != null && border3.getClip() && border3.getRadius() != null && border3.getRadius().size() >= 4) {
                    roundImageView.setCornerTopLeftRadius((int) (border3.getRadius().get(0).intValue() * f2));
                    roundImageView.setCornerTopRightRadius((int) (border3.getRadius().get(1).intValue() * f2));
                    roundImageView.setCornerBottomRightRadius((int) (border3.getRadius().get(2).intValue() * f2));
                    roundImageView.setCornerBottomLeftRadius((int) (border3.getRadius().get(3).intValue() * f2));
                }
                if (styleBean.getCreative().getMargin() != null && styleBean.getCreative().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) roundImageView.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) (styleBean.getCreative().getMargin().get(0).intValue() * f2);
                    marginLayoutParams3.rightMargin = (int) (styleBean.getCreative().getMargin().get(1).intValue() * f2);
                    marginLayoutParams3.bottomMargin = (int) (styleBean.getCreative().getMargin().get(2).intValue() * f2);
                    marginLayoutParams3.leftMargin = (int) (styleBean.getCreative().getMargin().get(3).intValue() * f2);
                    roundImageView.setLayoutParams(marginLayoutParams3);
                }
            }
            if (styleBean.getDislike() != null) {
                if (styleBean.getDislike().isHide()) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                }
                if (styleBean.getDislike().getText() != null) {
                    LayoutBean.StyleBean.TextBean text = styleBean.getDislike().getText();
                    if (text.getSize() > 0) {
                        textView3.setTextSize(text.getSize());
                    }
                    if (!TextUtils.isEmpty(text.getColor())) {
                        textView3.setTextColor(Color.parseColor("#" + text.getColor()));
                    }
                    if (text.getLines() > 0) {
                        textView3.setMaxLines(text.getLines());
                    }
                }
                if (styleBean.getDislike().getMargin() != null && styleBean.getDislike().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) (styleBean.getDislike().getMargin().get(0).intValue() * f2);
                    marginLayoutParams4.rightMargin = (int) (styleBean.getDislike().getMargin().get(1).intValue() * f2);
                    marginLayoutParams4.bottomMargin = (int) (styleBean.getDislike().getMargin().get(2).intValue() * f2);
                    marginLayoutParams4.leftMargin = (int) (styleBean.getDislike().getMargin().get(3).intValue() * f2);
                    textView3.setLayoutParams(marginLayoutParams4);
                }
                List<Integer> padding2 = styleBean.getDislike().getPadding();
                if (padding2 != null && padding2.size() >= 4) {
                    textView3.setPadding((int) (padding2.get(3).intValue() * f2), (int) (padding2.get(0).intValue() * f2), (int) (padding2.get(1).intValue() * f2), (int) (padding2.get(2).intValue() * f2));
                }
                LayoutBean.StyleBean.BorderBean border4 = styleBean.getDislike().getBorder();
                if (border4 != null) {
                    textView3.setBackground(a(border4.getRadius(), styleBean.getDislike().getBorder().getSize(), "#" + styleBean.getDislike().getBorder().getColor()));
                }
            }
            if (styleBean.getLogo() != null) {
                if (styleBean.getLogo().isHide()) {
                    imageView.setVisibility(8);
                } else if (AdSdk.adConfig().showLogo()) {
                    imageView.setVisibility(0);
                }
                if (styleBean.getLogo().getMargin() != null && styleBean.getLogo().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams5.topMargin = (int) (styleBean.getLogo().getMargin().get(0).intValue() * f2);
                    marginLayoutParams5.rightMargin = (int) (styleBean.getLogo().getMargin().get(1).intValue() * f2);
                    marginLayoutParams5.bottomMargin = (int) (styleBean.getLogo().getMargin().get(2).intValue() * f2);
                    marginLayoutParams5.leftMargin = (int) (styleBean.getLogo().getMargin().get(3).intValue() * f2);
                    imageView.setLayoutParams(marginLayoutParams5);
                }
            }
            if (styleBean.getSource() != null && textView4 != null) {
                if (styleBean.getSource().isHide()) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setVisibility(0);
                }
                if (styleBean.getSource().getMargin() != null && styleBean.getSource().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
                    marginLayoutParams6.topMargin = (int) (styleBean.getSource().getMargin().get(0).intValue() * f2);
                    marginLayoutParams6.rightMargin = (int) (styleBean.getSource().getMargin().get(1).intValue() * f2);
                    marginLayoutParams6.bottomMargin = (int) (styleBean.getSource().getMargin().get(2).intValue() * f2);
                    marginLayoutParams6.leftMargin = (int) (styleBean.getSource().getMargin().get(3).intValue() * f2);
                    textView4.setLayoutParams(marginLayoutParams6);
                }
                List<Integer> padding3 = styleBean.getSource().getPadding();
                if (padding3 != null && padding3.size() >= 4) {
                    textView4.setPadding((int) (padding3.get(3).intValue() * f2), (int) (padding3.get(0).intValue() * f2), (int) (padding3.get(1).intValue() * f2), (int) (padding3.get(2).intValue() * f2));
                }
                if (styleBean.getSource().getText() != null) {
                    LayoutBean.StyleBean.TextBean text2 = styleBean.getSource().getText();
                    if (text2.getSize() > 0) {
                        textView4.setTextSize(text2.getSize());
                    }
                    if (!TextUtils.isEmpty(text2.getColor())) {
                        textView4.setTextColor(Color.parseColor("#" + text2.getColor()));
                    }
                }
            }
            if (styleBean.getButton() == null || textView5 == null) {
                return;
            }
            if (styleBean.getButton().getMargin() != null && styleBean.getButton().getMargin().size() >= 4) {
                ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) textView5.getLayoutParams();
                marginLayoutParams7.topMargin = (int) (styleBean.getButton().getMargin().get(0).intValue() * f2);
                marginLayoutParams7.rightMargin = (int) (styleBean.getButton().getMargin().get(1).intValue() * f2);
                marginLayoutParams7.bottomMargin = (int) (styleBean.getButton().getMargin().get(2).intValue() * f2);
                marginLayoutParams7.leftMargin = (int) (styleBean.getButton().getMargin().get(3).intValue() * f2);
                textView5.setLayoutParams(marginLayoutParams7);
            }
            List<Integer> padding4 = styleBean.getButton().getPadding();
            if (padding4 != null && padding4.size() >= 4) {
                textView5.setPadding((int) (padding4.get(3).intValue() * f2), (int) (padding4.get(0).intValue() * f2), (int) (padding4.get(1).intValue() * f2), (int) (padding4.get(2).intValue() * f2));
            }
            if (styleBean.getButton().getText() != null) {
                LayoutBean.StyleBean.TextBean text3 = styleBean.getButton().getText();
                if (text3.getSize() > 0) {
                    textView5.setTextSize(text3.getSize());
                }
                if (!TextUtils.isEmpty(text3.getColor())) {
                    textView5.setTextColor(Color.parseColor("#" + text3.getColor()));
                }
            }
            if (styleBean.getButton().getBorder() == null || (border = styleBean.getButton().getBorder()) == null || border.getRadius() == null || border.getRadius().size() < 4) {
                return;
            }
            textView5.setBackground(a(border.getRadius(), styleBean.getButton().getBorder().getSize(), "#" + styleBean.getButton().getBorder().getColor()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
