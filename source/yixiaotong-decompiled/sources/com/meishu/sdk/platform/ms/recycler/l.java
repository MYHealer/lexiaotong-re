package com.meishu.sdk.platform.ms.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
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
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
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
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.DownloadUtils;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.f1;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.k0;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.s1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.FeedAdOverlayManager;
import com.meishu.sdk.core.view.PositionView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPoint;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l implements RecyclerAdData {
    public static int p = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MsCustomVideo f5213a;
    public com.meishu.sdk.meishu_ad.nativ.b b;
    public com.meishu.sdk.platform.ms.recycler.c c;
    public RecylcerAdInteractionListener d;
    public boolean e;
    public int f;
    public boolean g;
    public DownloadStatusListener h;
    public volatile boolean i;
    public int j;
    public FrameLayout k;
    public WeakReference<Activity> m;
    public int n;
    public boolean l = false;
    public ViewTreeObserver.OnScrollChangedListener o = new e();

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5214a;
        public final /* synthetic */ Rect b;
        public final /* synthetic */ RecylcerAdInteractionListener c;

        /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.recycler.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
        public class C0852a implements ShakeUtil.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f5215a;

            public C0852a(long j) {
                this.f5215a = j;
            }

            @Override // com.meishu.sdk.platform.ms.splash.ShakeUtil.c
            public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
                RecylcerAdInteractionListener recylcerAdInteractionListener;
                ShakeUtil.getInstance().a(l.this.f);
                if (l.this.b.a().getCbc() == 0 && (recylcerAdInteractionListener = a.this.c) != null) {
                    recylcerAdInteractionListener.onAdClicked();
                }
                if (shakeResult != null) {
                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f5215a);
                }
                l.this.b.a().setClkActType(i);
                l.this.b.a().setClkPower(i2);
                l.this.b.a().setShakeResult(shakeResult);
                com.meishu.sdk.core.utils.f.a(l.this.b, i2 >= 50);
            }
        }

        public a(ViewGroup viewGroup, Rect rect, RecylcerAdInteractionListener recylcerAdInteractionListener) {
            this.f5214a = viewGroup;
            this.b = rect;
            this.c = recylcerAdInteractionListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!this.f5214a.getGlobalVisibleRect(this.b)) {
                return true;
            }
            if (((long) this.b.height()) * ((long) this.b.width()) >= ((long) this.f5214a.getHeight()) * ((long) this.f5214a.getWidth()) * 0.3d) {
                l lVar = l.this;
                if (!lVar.e) {
                    lVar.e = true;
                    l.this.b.a().setMonitorUrl(h0.a(l.this.b.a().getMonitorUrl(), this.f5214a, (View) null));
                    com.meishu.sdk.platform.ms.recycler.a aVar = l.this.c.c;
                    if (aVar != null) {
                        aVar.onADExposure();
                        RecylcerAdInteractionListener recylcerAdInteractionListener = this.c;
                        if (recylcerAdInteractionListener != null) {
                            recylcerAdInteractionListener.onAdExposure();
                        }
                    }
                    l.this.b.a().B = true;
                    if (com.meishu.sdk.core.utils.h.c(l.this.b.a().getAct_type())) {
                        int iB = com.meishu.sdk.core.utils.h.b(l.this.b.a().getAct_type());
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ShakeUtil.getInstance().a(l.this.b.a().getPosId(), l.this.b.a().getLoadedTime(), l.this.b.a().getDclk());
                        ShakeUtil shakeUtil = ShakeUtil.getInstance();
                        int power_index = l.this.b.a().getPower_index();
                        int power_index2 = l.this.b.a().getPower_index();
                        long power_delay = l.this.b.a().getPower_delay();
                        int power_count = l.this.b.a().getPower_count();
                        l lVar2 = l.this;
                        shakeUtil.a(power_index, power_index2, iB, power_delay, power_count, lVar2.f, lVar2.b.a().getEcpm(), new C0852a(jCurrentTimeMillis));
                        ShakeUtil.getInstance().a(true);
                    }
                    this.f5214a.getViewTreeObserver().removeOnPreDrawListener(this);
                    l lVar3 = l.this;
                    ViewGroup viewGroup = this.f5214a;
                    lVar3.getClass();
                    try {
                        WeakReference<Activity> weakReference = lVar3.m;
                        Activity activity = weakReference != null ? weakReference.get() : null;
                        if (activity != null && viewGroup != null) {
                            FeedAdOverlayManager.getInstance().addOverlay(activity, viewGroup, ((RecyclerMixAdLoader) lVar3.c.getAdLoader()).getPosId(), l.p, lVar3.b.a(), lVar3.d(), new m(lVar3, viewGroup));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class b implements TouchAdContainer.OnWindownEventListener {
        public b() {
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onAttachedToWindow() {
            ShakeUtil.getInstance().a(l.this.f, true);
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onDetachedFromWindow() {
            ShakeUtil.getInstance().a(l.this.f, false);
        }

        @Override // com.meishu.sdk.core.view.TouchAdContainer.OnWindownEventListener
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                ShakeUtil.getInstance().a(l.this.f, true);
            } else {
                ShakeUtil.getInstance().a(l.this.f, false);
            }
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f5217a;
        public final /* synthetic */ t.a b;

        public c(List list, t.a aVar) {
            this.f5217a = list;
            this.b = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    for (int i = 0; i < this.f5217a.size(); i++) {
                        if (s1.a((View) this.f5217a.get(i), motionEvent.getRawX(), motionEvent.getRawY())) {
                            t.a(l.this.d(), motionEvent, this.b);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class d extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5218a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ List c;

        /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
        public class a implements q {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u f5219a;

            public a(u uVar) {
                this.f5219a = uVar;
            }

            @Override // com.meishu.sdk.platform.ms.recycler.q
            public void a(ViewGroup viewGroup, float f, float f2, long j, float f3, float f4, int i) {
                d dVar = d.this;
                l.this.a(dVar.f5218a, f, f2, j, f3, f4, i, !this.f5219a.a());
            }
        }

        /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
        public class b extends r {
            public b(View view, int i, List list) {
                super(view, i, list);
            }

            @Override // com.meishu.sdk.platform.ms.recycler.r
            public void a(float f, float f2, long j, float f3, float f4, int i) {
                d dVar = d.this;
                l.this.a(dVar.f5218a, f, f2, j, f3, f4, i, true);
            }
        }

        /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
        public class c implements View.OnTouchListener {
            public c() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == 0) {
                        l.this.b();
                    } else if (motionEvent.getAction() == 1) {
                        l.this.getClass();
                        float f = l.this.k.getContext().getResources().getDisplayMetrics().density;
                        float f2 = t.d;
                        float fMax = (f2 <= 0.0f || t.e <= 0.0f) ? 0.0f : Math.max(Math.abs(f2 - motionEvent.getRawX()), Math.abs(t.e - motionEvent.getRawY()));
                        if (fMax > l.this.j) {
                            LogUtil.dev("MeishuRecyclerAdDataAda", "use rawXY");
                        }
                        l lVar = l.this;
                        lVar.j = (int) Math.max(lVar.j, fMax);
                        TouchPoint touchPointA = t.a(l.this.d(), motionEvent, f, l.this.j);
                        if (touchPointA == null) {
                            return false;
                        }
                        d dVar = d.this;
                        l lVar2 = l.this;
                        int i = lVar2.j;
                        if (i / f > l.p) {
                            float f3 = touchPointA.downX;
                            if (f3 > 0.0f) {
                                float f4 = touchPointA.downY;
                                if (f4 > 0.0f) {
                                    lVar2.a(dVar.f5218a, f3, f4, touchPointA.downTime, touchPointA.upX, touchPointA.upY, i, true);
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

        public d(ViewGroup viewGroup, boolean z, List list) {
            this.f5218a = viewGroup;
            this.b = z;
            this.c = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            View view;
            try {
                ViewGroup viewGroup = this.f5218a;
                List list = null;
                list = null;
                if (viewGroup == null) {
                    view = null;
                    break;
                }
                try {
                    view = (View) viewGroup.getParent();
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
                    new p(l.this.k, uVar.a() ? view : null).a(this.f5218a, l.p, new a(uVar));
                    return;
                }
                if (view != null) {
                    view.setOnTouchListener(new c());
                    return;
                }
                try {
                    FrameLayout frameLayout = l.this.k;
                    View childAt = this.f5218a.getChildAt(0);
                    int i2 = l.p;
                    if (this.b && l.this.l) {
                        list = this.c;
                    }
                    frameLayout.setOnTouchListener(new b(childAt, i2, list));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class e implements ViewTreeObserver.OnScrollChangedListener {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (t.b <= 0.0f || t.c <= 0.0f || !o1.a(((RecyclerMixAdLoader) l.this.c.getAdLoader()).getPosId(), l.this.b.a().getAdp(), l.this.b.a().getAdg())) {
                    return;
                }
                int[] iArr = new int[2];
                l.this.k.getLocationOnScreen(iArr);
                if (iArr[1] > 0 && t.f == 0) {
                    try {
                        t.a(l.this.d(), iArr[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                l.this.j = Math.abs(t.f - iArr[1]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class f extends com.meishu.sdk.core.safe.l {
        public f() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            com.meishu.sdk.meishu_ad.nativ.b bVar = l.this.b;
            if (bVar == null || bVar.getMediaView() == null) {
                return;
            }
            l.this.b.getMediaView().start();
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class g extends com.meishu.sdk.core.safe.l {
        public g() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            com.meishu.sdk.meishu_ad.nativ.b bVar = l.this.b;
            if (bVar == null || bVar.getMediaView() == null) {
                return;
            }
            l.this.b.getMediaView().replay();
        }
    }

    public l(com.meishu.sdk.platform.ms.recycler.c cVar, com.meishu.sdk.meishu_ad.nativ.b bVar, int i) {
        this.c = cVar;
        this.b = bVar;
        this.n = i;
        this.f5213a = new MsCustomVideo(bVar.a());
        if (this.f == 0) {
            this.f = ShakeUtil.getInstance().b();
        }
        try {
            AdType adType = AdType.FEED_MIX;
            adType.value();
            com.meishu.sdk.core.utils.h.a();
            bVar.a().setAct_type(com.meishu.sdk.core.utils.h.a(bVar.a().getAct_type(), adType.value()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bVar.a().getPower_index() > 0) {
            p = bVar.a().getPower_index() * 5;
        }
    }

    public final void b() {
        t.a();
        this.j = 0;
    }

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
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        try {
            if (viewGroup == null) {
                LogUtil.e("MeishuRecyclerAdDataAda", "adContainer is null");
                return;
            }
            o1.b(this.b.a().getEventUrl());
            this.d = recylcerAdInteractionListener;
            Rect rect = new Rect();
            Activity activity = context instanceof Activity ? (Activity) context : viewGroup.getContext() instanceof Activity ? (Activity) viewGroup.getContext() : null;
            if (activity != null) {
                try {
                    if (!this.g && Build.VERSION.SDK_INT >= 29) {
                        this.g = true;
                        activity.registerActivityLifecycleCallbacks(new n(this));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.m = new WeakReference<>(activity);
            FeedAdOverlayManager.getInstance().updateAdContainer(d(), viewGroup);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new a(viewGroup, rect, recylcerAdInteractionListener));
            ViewGroup[] viewGroupArrA = com.meishu.sdk.core.ad.recycler.d.a(viewGroup, l.class, TouchAdContainer.class);
            ViewGroup viewGroup2 = viewGroupArrA[1];
            if (viewGroup2 == null) {
                viewGroup2 = viewGroupArrA[0];
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 == null) {
                    try {
                        LogUtil.d("", new String(f1.a("c2VsZiByZW5kZXIgYmluZEFkVG9WaWV3LCBUaGUgYWRDb250YWluZXIgbXVzdCBiZSBpbnNlcnRlZCBpbnRvIHRoZSBwYWdlIGxheW91dC4=")));
                    } catch (Throwable unused) {
                    }
                } else {
                    int iIndexOfChild = viewGroup3.indexOfChild(viewGroup2);
                    ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup3.removeView(viewGroup2);
                    TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.b));
                    touchAdContainer.addView(viewGroup2, layoutParams2);
                    touchAdContainer.setId(viewGroup2.getId());
                    if (AdSdk.adConfig().showFeedAdLogo()) {
                        try {
                            ImageView imageView = new ImageView(viewGroup2.getContext());
                            imageView.setAdjustViewBounds(true);
                            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup2.getContext().getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                            layoutParams3.gravity = 85;
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ms_ad));
                            touchAdContainer.addView(imageView, layoutParams3);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    o1.a(viewGroup2, this.b.a().getPosId(), this.b.a().getLoadedTime());
                    viewGroup3.addView(touchAdContainer, iIndexOfChild, layoutParams);
                    viewGroup2 = touchAdContainer;
                }
            } else if (viewGroup2 instanceof TouchAdContainer) {
                ((TouchAdContainer) viewGroup2).setTouchPositionListener(new TouchPositionListener(this.b));
            }
            PositionView positionView = new PositionView(viewGroup.getContext());
            positionView.setTag(Integer.valueOf(this.f));
            positionView.setOnWindownEventListener(new b());
            for (int i = 0; i < viewGroup2.getChildCount(); i++) {
                try {
                    View childAt = viewGroup2.getChildAt(i);
                    if (childAt instanceof PositionView) {
                        viewGroup2.removeView(childAt);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            viewGroup2.addView(positionView, 1, 1);
            a(activity, viewGroup2, list);
            try {
                this.b.a().getAppendInfo().getHasClicked().a(new com.meishu.sdk.core.utils.b.a() { // from class: com.meishu.sdk.platform.ms.recycler.l$$ExternalSyntheticLambda1
                    @Override // com.meishu.sdk.core.utils.b.a
                    public final void a(Object obj, Object obj2) {
                        this.f$0.a((Boolean) obj, (Boolean) obj2);
                    }
                });
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
            bVar.a(context, viewGroup2, list, new com.meishu.sdk.platform.ms.recycler.d(bVar, recylcerAdInteractionListener));
            this.b.setInteractionListener(recylcerAdInteractionListener);
            View viewFindViewWithTag = viewGroup2.findViewWithTag("meishu_media_view");
            if (viewFindViewWithTag == null || viewFindViewWithTag.getParent() == null || !(viewFindViewWithTag.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
        } catch (Throwable unused2) {
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdRenderFailed();
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        try {
            viewGroup.removeAllViews();
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
            this.c.getContext();
            bVar.a(viewGroup, null, new com.meishu.sdk.platform.ms.recycler.b((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a, recyclerAdMediaListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final List<View> c() {
        Method declaredMethod;
        try {
            String str = new String(f1.a("Z3N3"));
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                declaredMethod = this.d.getClass().getDeclaredMethod(str, new Class[0]);
            } catch (Throwable unused) {
                declaredMethod = null;
            }
            if (declaredMethod == null) {
                return null;
            }
            this.l = true;
            declaredMethod.setAccessible(true);
            return (List) declaredMethod.invoke(this.d, new Object[0]);
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final String d() {
        try {
            return this.b.a().getReq_id() + "_" + this.n;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().d;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getApp_intro();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getApp_intor_url();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getAppName();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar == null || bVar.a() == null) {
            return null;
        }
        return this.b.a().getApp_permission();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getApp_permission_url();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getApp_size();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getApp_ver();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().c;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return this.f5213a;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getCid());
            resultBean.setCat(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getCat());
            resultBean.setAderId(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getAder_id());
            resultBean.setFromId(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getFromId());
            resultBean.setDrawing(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getDrawing());
            resultBean.setPid(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getPosId());
            resultBean.setReqId(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getReq_id());
            resultBean.setPrice(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getEcpm());
            resultBean.setEcpm(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getEcpm() + "");
            resultBean.setS_ext(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getS_ext());
            resultBean.setS_code(((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getS_code());
            resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.c.f5177a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("MS");
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getDeveloper();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar != null && bVar.getMediaView() != null && (this.b.getMediaView() instanceof NormalMediaView)) {
            return ((NormalMediaView) this.b.getMediaView()).getDuration();
        }
        com.meishu.sdk.meishu_ad.nativ.b bVar2 = this.b;
        if (bVar2 == null || bVar2.a() == null) {
            return 0L;
        }
        return this.b.a().y * 1000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().f;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getFromId();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getFromLogo();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar == null || bVar.a() == null) {
            return 0;
        }
        return this.b.a().b;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().e;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getPackageName();
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
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return (bVar == null || bVar.a() == null) ? "" : this.b.a().getPrivacy_agreement();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        try {
            return this.b.a().getVideo_cover();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        try {
            if (getAdPatternType() == 2) {
                return getImgUrls()[0];
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar == null || bVar.a() == null) {
            return 0;
        }
        return this.b.a().f5047a;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
        com.meishu.sdk.meishu_ad.nativ.b bVar;
        if (getAdPatternType() != 2 || (bVar = this.b) == null || bVar.getMediaView() == null) {
            return;
        }
        this.b.getMediaView().mute();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
        com.meishu.sdk.meishu_ad.nativ.b bVar;
        if (getAdPatternType() != 2 || (bVar = this.b) == null || bVar.getMediaView() == null) {
            return;
        }
        this.b.getMediaView().pause();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
        if (getAdPatternType() == 2) {
            new Handler().postDelayed(new g(), 300L);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
        com.meishu.sdk.meishu_ad.nativ.b bVar;
        if (getAdPatternType() != 2 || (bVar = this.b) == null || bVar.getMediaView() == null) {
            return;
        }
        this.b.getMediaView().resume();
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(this.c.getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(this.c.getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
        if (getAdPatternType() == 2) {
            new Handler().postDelayed(new f(), 300L);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar == null || bVar.getMediaView() == null || !(this.b.getMediaView() instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) this.b.getMediaView()).l();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
        com.meishu.sdk.meishu_ad.nativ.b bVar;
        if (getAdPatternType() != 2 || (bVar = this.b) == null || bVar.getMediaView() == null) {
            return;
        }
        this.b.getMediaView().unmute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(Boolean bool, Boolean bool2) {
        b();
        WeakReference<Activity> weakReference = this.m;
        FeedAdOverlayManager.getInstance().onAdClickedIfOverlayExists(d(), ((RecyclerMixAdLoader) this.c.getAdLoader()).getPosId(), weakReference != null ? weakReference.get() : null);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        if (bVar.getMediaView() != null && (this.b.getMediaView() instanceof NormalMediaView)) {
            ((NormalMediaView) this.b.getMediaView()).d();
        }
        ShakeUtil.getInstance().a(this.f);
        try {
            FeedAdOverlayManager.getInstance().removeOverlay(d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            String[] strArr = this.b.a().getdUrl();
            String str = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            com.meishu.sdk.meishu_ad.nativ.b bVar2 = this.b;
            String packageName = (bVar2 == null || bVar2.a() == null) ? "" : this.b.a().getPackageName();
            Map<Integer, k0> map = DownloadUtils.h;
            if (!TextUtils.isEmpty(str)) {
                DownloadUtils.j.remove(str);
            }
            if (TextUtils.isEmpty(packageName)) {
                return;
            }
            DownloadUtils.k.remove(packageName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar != null) {
            if (bVar.a().getAdPatternType() == 2) {
                return 2;
            }
            switch (this.b.a().x) {
                case 1:
                case 2:
                case 6:
                    break;
                case 3:
                case 4:
                    return 11;
                case 5:
                    return 13;
                default:
                    return this.b.getAdPatternType();
            }
        }
        return 12;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getAdView() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar != null) {
            return bVar.getAdView();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return bVar != null ? bVar.getDesc() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return bVar != null ? bVar.getIconUrl() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar != null) {
            return bVar.getInteractionType();
        }
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        return bVar != null ? bVar.getTitle() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
        this.h = downloadStatusListener;
        if (getInteractionType() != 1) {
            return;
        }
        try {
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
            String str = null;
            String[] strArr = bVar != null ? bVar.a().getdUrl() : null;
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
            }
            com.meishu.sdk.meishu_ad.nativ.b bVar2 = this.b;
            String packageName = (bVar2 == null || bVar2.a() == null) ? "" : this.b.a().getPackageName();
            Map<Integer, k0> map = DownloadUtils.h;
            if (!TextUtils.isEmpty(str) && downloadStatusListener != null) {
                DownloadUtils.j.put(str, downloadStatusListener);
            }
            if (TextUtils.isEmpty(packageName) || downloadStatusListener == null) {
                return;
            }
            DownloadUtils.k.put(packageName, downloadStatusListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
        if (bVar != null) {
            return bVar.getImgUrls();
        }
        return null;
    }

    public final void a(Activity activity, final ViewGroup viewGroup, List<View> list) {
        try {
            if (activity != null) {
                try {
                    if ((this.b.a().getAct_type() & 512) != 512) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                boolean z = true;
                if (this.b.a().getNativeSE() == 1) {
                    z = false;
                }
                List<View> listC = z ? c() : null;
                if (z && this.l) {
                    list = listC;
                }
                if (list != null && !list.isEmpty()) {
                    if (this.k == null) {
                        FrameLayout frameLayout = new FrameLayout(activity);
                        int height = -1;
                        int width = viewGroup.getWidth() <= 0 ? -1 : viewGroup.getWidth();
                        if (viewGroup.getHeight() > 0) {
                            height = viewGroup.getHeight();
                        }
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                        viewGroup.addView(frameLayout);
                        this.k = frameLayout;
                    }
                    this.k.setOnTouchListener(new c(list, new t.a() { // from class: com.meishu.sdk.platform.ms.recycler.l$$ExternalSyntheticLambda0
                        @Override // com.meishu.sdk.platform.ms.recycler.t.a
                        public final void a(float f2, float f3, long j, float f4, float f5, float f6, int i) {
                            this.f$0.a(viewGroup, f2, f3, j, f4, f5, f6, i);
                        }
                    }));
                    viewGroup.post(new d(viewGroup, z, listC));
                    this.k.getViewTreeObserver().addOnScrollChangedListener(this.o);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
        ImageView imageView;
        try {
            NormalMediaView normalMediaView = (NormalMediaView) this.b.getMediaView();
            if (normalMediaView != null) {
                normalMediaView.setDisplayMode(1);
                if (i > 0) {
                    normalMediaView.setContainerWidth(i);
                }
                if (i2 > 0) {
                    normalMediaView.setContainerHeight(i2);
                }
                normalMediaView.S = true;
                imageView = new ImageView(normalMediaView.getContext());
                ExecutorService executorService = g0.f4905a;
                g0.b.f4906a.a(new o(this, imageView));
            } else {
                imageView = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        if (i > 0 && i2 > 0) {
            layoutParams2.width = i;
            layoutParams2.height = i2;
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        viewGroup.removeAllViews();
        if (imageView != null && !(viewGroup instanceof LinearLayout)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewGroup.addView(imageView, layoutParams2);
        }
        viewGroup.addView(relativeLayout, layoutParams2);
        try {
            com.meishu.sdk.meishu_ad.nativ.b bVar = this.b;
            this.c.getContext();
            bVar.a(relativeLayout, layoutParams, new com.meishu.sdk.platform.ms.recycler.b((com.meishu.sdk.meishu_ad.nativ.f) this.c.f5177a, recyclerAdMediaListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, float f2, float f3, long j, float f4, float f5, float f6, int i) {
        if (i / f6 > p) {
            a(viewGroup, f2, f3, j, f4, f5, i, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ViewGroup viewGroup, float f2, float f3, long j, float f4, float f5, int i, boolean z) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        try {
            if (this.i) {
                return;
            }
            if (z) {
                FrameLayout frameLayout = this.k;
                if (frameLayout != null && frameLayout.getVisibility() == 0 && frameLayout.getParent() != null && frameLayout.hasWindowFocus()) {
                    Rect rect = new Rect();
                    if (!frameLayout.getGlobalVisibleRect(rect)) {
                        return;
                    }
                    int iHeight = rect.height() * rect.width();
                    int width = (int) (((double) (frameLayout.getWidth() * frameLayout.getHeight())) * 0.8d);
                    if (width <= 0) {
                        return;
                    }
                    if (iHeight < width) {
                        return;
                    }
                }
                return;
            }
            if (this.e) {
                this.i = true;
                try {
                    if (this.b.a().getCbc() == 0 && (recylcerAdInteractionListener = this.d) != null) {
                        recylcerAdInteractionListener.onAdClicked();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.meishu.sdk.core.utils.q.a().b(((RecyclerMixAdLoader) this.c.getAdLoader()).getPosId() + "_adp", jCurrentTimeMillis);
                com.meishu.sdk.core.utils.q.a().b("adg_time", jCurrentTimeMillis);
                this.b.a().setClkActType(512);
                this.b.a().setClkPower(i);
                s.a(this.b, f2, f3, j, f4, f5);
                b();
                h0.a(this.b, viewGroup);
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.b, false);
                try {
                    this.k.getViewTreeObserver().removeOnScrollChangedListener(this.o);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
