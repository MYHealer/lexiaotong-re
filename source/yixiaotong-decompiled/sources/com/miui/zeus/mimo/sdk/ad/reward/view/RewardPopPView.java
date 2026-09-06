package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.click.MarketDownloadHandler;
import com.miui.zeus.mimo.sdk.e2;
import com.miui.zeus.mimo.sdk.e3;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.j2;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.u3;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPopPView extends j2 {
    public static final String U = "RewardPopPView";
    public CloseICP I;
    public DownloadButtonICP J;
    public RewardMiniGamePBottomView K;
    public TextView L;
    public TextView M;
    public ImageView N;
    public LinearLayout O;
    public c P;
    public ImageICP Q;
    public ImageICP R;
    public boolean S;
    public boolean T;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = RewardPopPView.this.P;
            if (cVar != null) {
                e3.this.dismiss();
            }
            com.miui.zeus.mimo.sdk.b.a(RewardPopPView.this.f, s.d(new byte[]{101, 124, 98, 118, 54, 33, 62, 52, 41, 50, 110, 38, 123, 118, 102, 114}, "7957de"), s.d(new byte[]{Ascii.DC2, 0, 78, 76}, "fe68f7"), System.currentTimeMillis());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardPopPView rewardPopPView = RewardPopPView.this;
            rewardPopPView.onClick(view, rewardPopPView.K.getClickAreaType());
        }
    }

    public interface c {
    }

    public RewardPopPView(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public RewardPopPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.S = false;
        this.T = false;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(int i) {
        this.N.setImageResource(a0.H3);
        this.J.setGetReward(true);
        this.J.setText(this.f.i());
        this.L.setText("");
        this.M.setVisibility(8);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        this.Q = (ImageICP) view.findViewById(a0.l3);
        this.R = (ImageICP) view.findViewById(a0.G2);
        this.I = (CloseICP) view.findViewById(a0.i2);
        this.N = (ImageView) view.findViewById(a0.O3);
        this.L = (TextView) view.findViewById(a0.s0);
        this.M = (TextView) view.findViewById(a0.A5);
        this.J = (DownloadButtonICP) view.findViewById(a0.T0);
        this.c = (SixElementsView) view.findViewById(a0.j);
        this.K = (RewardMiniGamePBottomView) view.findViewById(a0.o2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a0.U3);
        this.O = linearLayout;
        linearLayout.setOnClickListener(new a());
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public boolean a(int i, long j) {
        return this.y || i != 5;
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        DownloadButtonICP downloadButtonICP = this.J;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        return new View[]{this.J};
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.y;
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        e2.a aVar;
        if (clickAreaType == ClickAreaType.TYPE_CLOSE) {
            c cVar = this.P;
            if (cVar != null) {
                e3.this.dismiss();
            }
            com.miui.zeus.mimo.sdk.b.a(this.f, s.d(new byte[]{96, 125, 103, 36, 55, 124, 62, 52, 41, 50, 110, 38, 126, 119, 99, 32}, "280ee8"), s.d(new byte[]{15, 0, 89, 94}, "fc6051"), System.currentTimeMillis());
            return;
        }
        if (this.f.a(clickAreaType) != ClickEventType.CLICK_DISABLE && !this.y) {
            c(5);
            com.miui.zeus.mimo.sdk.b.a(this.f, s.d(new byte[]{119, 116, 108, 111, 100, 36, 54, 37, 35, 38, 110, 35, 98, 126, 117, 111, 102, 46, 49}, "01806a"), "", System.currentTimeMillis());
            this.y = true;
            c cVar2 = this.P;
            if (cVar2 != null && (aVar = e3.this.f) != null) {
                j2.l.a aVar2 = (j2.l.a) aVar;
                j2 j2Var = j2.this;
                j2Var.y = true;
                RewardPSkipCountDownView rewardPSkipCountDownView = j2Var.i;
                if (rewardPSkipCountDownView != null) {
                    rewardPSkipCountDownView.a();
                    j2.this.i.h = true;
                }
            }
        }
        super.onClick(view, clickAreaType);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, final MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.f = mimoAdInfo;
        a(LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true));
        this.h = activity;
        this.g = w3Var;
        this.I.setClickAreaListener(this);
        CommonActionHandler commonActionHandler = new CommonActionHandler(getContext(), activity, w3Var);
        this.z = commonActionHandler;
        u3 u3Var = commonActionHandler.d;
        if (u3Var instanceof MarketDownloadHandler) {
            ((MarketDownloadHandler) u3Var).e = this;
        }
        this.J.a(mimoAdInfo, false, true, this, true);
        this.J.setClickAreaType(ClickAreaType.TYPE_WIN_BUTTON);
        this.K.a(mimoAdInfo, w3Var, null);
        this.K.setClickAreaType(ClickAreaType.TYPE_REWARD_WINDOW);
        this.K.setOnClickListener(new b());
        this.K.d.setMaxLines(2);
        AdMarkICP adMarkICP = this.K.e;
        MimoAdInfo mimoAdInfo2 = this.f;
        adMarkICP.f5687a.setText(mimoAdInfo2.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo2, this));
        if (!this.f.t()) {
            this.K.b.setVisibility(8);
        }
        this.L.setText(this.f.k());
        this.c.setTextColor(Color.parseColor(s.d(new byte[]{26, 92, 95, 32, 114, 34, 39, 34, 32}, "9eff4d")));
        SixElementsView sixElementsView = this.c;
        MimoAdInfo mimoAdInfo3 = this.f;
        String str = mimoAdInfo3.i;
        String str2 = mimoAdInfo3.k;
        String strE = mimoAdInfo3.e();
        MimoAdInfo mimoAdInfo4 = this.f;
        sixElementsView.a(str, str2, strE, mimoAdInfo4.m, mimoAdInfo4.l, mimoAdInfo4.n, true);
        this.c.setVisibility(this.f.D() ? 0 : 4);
        this.c.setGravity(17);
        this.c.setOnItemClickListener(this);
        this.R.a(mimoAdInfo.C1, (i8) null, new RequestListener<Drawable>() { // from class: com.miui.zeus.mimo.sdk.ad.reward.view.RewardPopPView.3
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                String str3 = RewardPopPView.U;
                m.b(RewardPopPView.U, mimoAdInfo.C1 + s.d(new byte[]{Ascii.DC2, 11, 10, 123, 11, 80, 5, 34, 7, 11, 93, 0, 86, 94, 68}, "2dd7d1"), glideException);
                RewardPopPView.this.T = false;
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                String str3 = RewardPopPView.U;
                m.a(RewardPopPView.U, mimoAdInfo.C1 + s.d(new byte[]{Ascii.NAK, 11, 15, 51, 6, 71, 14, 17, Ascii.DC4, 1, 84, 55, 80, 5, 5, Ascii.CAN}, "5daac4"));
                RewardPopPView.this.T = true;
                return false;
            }
        });
        this.Q.a(mimoAdInfo.D1, (i8) null, new RequestListener<Drawable>() { // from class: com.miui.zeus.mimo.sdk.ad.reward.view.RewardPopPView.4
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                String str3 = RewardPopPView.U;
                m.b(RewardPopPView.U, mimoAdInfo.D1 + s.d(new byte[]{Ascii.ETB, 10, 89, 122, 95, 83, 5, 34, 7, 11, 93, 0, 83, 95, Ascii.ETB}, "7e7602"), glideException);
                RewardPopPView.this.S = false;
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                String str3 = RewardPopPView.U;
                m.a(RewardPopPView.U, mimoAdInfo.D1 + s.d(new byte[]{Ascii.NAK, 87, 88, 100, 1, Ascii.NAK, 14, 17, Ascii.DC4, 1, 84, 55, 80, 89, 82, 79}, "5866df"));
                RewardPopPView.this.S = true;
                return false;
            }
        });
    }

    public void setOnStatusListener(c cVar) {
        this.P = cVar;
    }
}
