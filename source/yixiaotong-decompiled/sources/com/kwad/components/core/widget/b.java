package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.j.c {
    public a avs;
    private long avt;
    private com.kwad.sdk.core.j.b dH;
    private com.kwad.components.core.widget.a.c fx;
    public AdInfo mAdInfo;
    protected T mAdResultData;
    public R mAdTemplate;
    public Context mContext;
    private bx mTimerHelper;
    protected boolean pw;

    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public void bA() {
    }

    protected abstract void bC();

    public void bz() {
    }

    public void cw() {
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public void setInnerAdInteractionListener(a aVar) {
        this.avs = aVar;
    }

    public void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    static /* synthetic */ long a(b bVar, long j) {
        long j2 = bVar.avt + j;
        bVar.avt = j2;
        return j2;
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        if (com.kwad.sdk.core.config.e.KD()) {
            return;
        }
        setBackgroundColor(-1);
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bC();
        this.fx = new com.kwad.components.core.widget.a.c(this, 70);
    }

    public final boolean fx() {
        return (this.mAdInfo.status == 2 || this.mAdInfo.status == 3) ? false : true;
    }

    public void d(T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.helper.c.r(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(r);
        b(this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        this.fx.Ab();
        this.fx.b(this);
        cw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        this.fx.a(this);
        this.fx.a(this.dH);
        this.fx.Aa();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bx();
        }
        return this.mTimerHelper;
    }

    public long getStayTime() {
        return this.avt + getTimerHelper().getTime();
    }

    private void b(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.e.Kg() && com.kwad.sdk.core.config.e.Kf() >= 0.0f) {
            e(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new com.kwad.components.core.widget.a.InterfaceC0705a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0705a
                public final void ae() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0705a
                public final void onWindowFocusChanged(boolean z) {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0705a
                public final void af() {
                    if (b.this.mAdTemplate.mPvReported && b.this.pw) {
                        long jXg = b.this.getTimerHelper().Xg();
                        b.a(b.this, jXg);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jXg, (JSONObject) null);
                        b.this.pw = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0705a
                public final void b(View view) {
                    if (!b.this.mAdTemplate.mPvReported && b.this.avs != null) {
                        b.this.pw = true;
                        b.this.aa();
                        b.this.getTimerHelper().startTiming();
                    }
                    if (!b.this.pw) {
                        b.this.getTimerHelper().startTiming();
                    }
                    b.this.pw = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0705a
                public final void aD() {
                    if (b.this.mAdTemplate.mPvReported && b.this.pw) {
                        long jXg = b.this.getTimerHelper().Xg();
                        b.a(b.this, jXg);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jXg, (JSONObject) null);
                        b.this.pw = false;
                    }
                }
            });
            aVar.zM();
            return;
        }
        c cVarD = d(viewGroup);
        if (cVarD == null) {
            cVarD = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarD);
        }
        cVarD.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void fz() {
                b.this.aa();
            }
        });
        cVarD.setNeedCheckingShow(true);
    }

    private static c d(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void e(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    protected void aa() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.avs) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0733a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0733a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        bVar.b(c0733a);
        bVar.z(getHeight(), getWidth());
        com.kwad.components.core.t.b.wF().a(this.mAdTemplate, null, bVar);
    }

    public final void c(com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void zN() {
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void bY(int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.nm = i;
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        c0733a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0733a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        aVar.QZ = c0733a;
        if (this.mAdTemplate.swipeAngle != 0) {
            aVar.aMR = this.mAdTemplate.swipeAngle;
        }
        if (getTouchCoords() != null) {
            aVar.no = getTouchCoords();
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, aVar, (JSONObject) null);
        a aVar2 = this.avs;
        if (aVar2 != null) {
            aVar2.onAdClicked();
        }
    }

    public final void zO() {
        com.kwad.sdk.core.adlog.c.cn(this.mAdTemplate);
        a aVar = this.avs;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }
}
