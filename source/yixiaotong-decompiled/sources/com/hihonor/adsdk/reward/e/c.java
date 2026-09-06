package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.widget.RadiusConstrainLayout;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.reward.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c extends a.b {
    private static final String z = "BaseRewardViewHolder";
    protected BaseAd c;
    protected AdListener d;
    protected x e;
    protected com.hihonor.adsdk.base.widget.base.e f;
    protected final Context g;
    protected final View h;
    protected final ImageView i;
    protected final HnDownloadButton j;
    protected final TextView k;
    protected final TextView l;
    protected final TextView m;
    protected final TextView n;
    protected final TextView o;
    protected final TextView p;
    protected final TextView q;
    protected final w r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected boolean v;
    protected boolean w;
    protected boolean x;
    protected boolean y;

    public c(View view, Context context) {
        super(view, context);
        this.f = new com.hihonor.adsdk.base.widget.base.e();
        this.r = new w();
        this.g = this.f3564a.getContext();
        this.h = b(R.id.ad_reward_picture_text_view);
        this.j = (HnDownloadButton) b(R.id.ad_reward_download);
        this.i = (ImageView) b(R.id.ad_reward_image);
        this.k = (TextView) b(R.id.ad_reward_title);
        this.l = (TextView) b(R.id.ad_reward_brand);
        this.m = (TextView) b(R.id.ad_reward_company_name);
        this.n = (TextView) b(R.id.ad_reward_version);
        this.o = (TextView) b(R.id.ad_reward_privacy);
        this.p = (TextView) b(R.id.ad_reward_permissions);
        this.q = (TextView) b(R.id.ad_reward_source);
    }

    public void a(BaseAd baseAd, AdListener adListener, o oVar, x xVar) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "bindData baseAd is null", new Object[0]);
            return;
        }
        this.c = baseAd;
        this.d = adListener;
        this.e = xVar;
        this.f.hnadsa(baseAd);
        if (Objects.isNull(this.f3564a)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "bindData,rootView is null", new Object[0]);
            return;
        }
        h();
        o();
        f();
        i();
        m();
        d();
        e();
        n();
        k();
        j();
        g();
        l();
    }

    protected void d() {
        View view = this.f3564a;
        BaseAd baseAd = this.c;
        com.hihonor.adsdk.base.widget.base.e eVar = this.f;
        w wVar = this.r;
        com.hihonor.adsdk.reward.c.a(view, baseAd, eVar, wVar.f3578a, wVar.b, this.d, this.t, wVar.c);
    }

    protected void e() {
        com.hihonor.adsdk.reward.c.a(this.f3564a, this.c, this.u);
    }

    protected void f() {
        com.hihonor.adsdk.reward.c.a(this.f3564a, this.c);
    }

    protected void g() {
        com.hihonor.adsdk.reward.c.b(this.f3564a, this.c, this.y);
    }

    protected void h() {
        if (Objects.nonNull(this.f3564a)) {
            this.f3564a.setOnTouchListener(this.r);
            View view = this.f3564a;
            BaseAd baseAd = this.c;
            com.hihonor.adsdk.base.widget.base.e eVar = this.f;
            w wVar = this.r;
            com.hihonor.adsdk.reward.c.a(view, baseAd, eVar, 9, wVar.f3578a, wVar.b, this.d, wVar.c);
        }
        if (Objects.nonNull(this.h)) {
            this.h.setOnTouchListener(this.r);
            View view2 = this.h;
            BaseAd baseAd2 = this.c;
            com.hihonor.adsdk.base.widget.base.e eVar2 = this.f;
            w wVar2 = this.r;
            com.hihonor.adsdk.reward.c.a(view2, baseAd2, eVar2, 9, wVar2.f3578a, wVar2.b, this.d, wVar2.c);
        }
    }

    protected void i() {
        Context context = this.g;
        View view = this.f3564a;
        BaseAd baseAd = this.c;
        com.hihonor.adsdk.base.widget.base.e eVar = this.f;
        w wVar = this.r;
        com.hihonor.adsdk.reward.c.a(context, view, baseAd, eVar, wVar.f3578a, wVar.b, this.d, wVar.c);
    }

    protected void j() {
        com.hihonor.adsdk.reward.c.c(this.f3564a, this.c, this.x);
    }

    protected void k() {
        com.hihonor.adsdk.reward.c.d(this.f3564a, this.c, this.w);
    }

    protected void l() {
        if (Objects.isNull(this.f3564a)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "initSeparatorView,rootView is null", new Object[0]);
            return;
        }
        View viewFindViewById = this.f3564a.findViewById(R.id.ad_reward_factor_dividing_0);
        View viewFindViewById2 = this.f3564a.findViewById(R.id.ad_reward_factor_dividing_1);
        View viewFindViewById3 = this.f3564a.findViewById(R.id.ad_reward_factor_dividing_2);
        View viewFindViewById4 = this.f3564a.findViewById(R.id.ad_reward_factor_dividing_3);
        if (Objects.isNull(viewFindViewById) || Objects.isNull(viewFindViewById2) || Objects.isNull(viewFindViewById3) || Objects.isNull(viewFindViewById4)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "No dividing line", new Object[0]);
        } else {
            com.hihonor.adsdk.common.f.w.hnadsa(this.m, viewFindViewById, this.o, viewFindViewById2, this.p, viewFindViewById3, this.q, viewFindViewById4, this.n);
        }
    }

    protected void m() {
        com.hihonor.adsdk.reward.c.e(this.f3564a, this.c, this.s);
    }

    protected void n() {
        com.hihonor.adsdk.reward.c.f(this.f3564a, this.c, this.v);
    }

    protected void o() {
        if (Objects.isNull(this.f3564a)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "initViewGroupRadius,rootView is null", new Object[0]);
            return;
        }
        RadiusConstrainLayout radiusConstrainLayout = (RadiusConstrainLayout) this.f3564a.findViewById(R.id.ad_reward_layout_radius);
        if (radiusConstrainLayout != null) {
            radiusConstrainLayout.setRadius(this.g.getResources().getDimension(R.dimen.dimens_12));
        }
    }
}
