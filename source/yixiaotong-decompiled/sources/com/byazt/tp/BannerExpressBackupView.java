package com.byazt.tp;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.ff.TTRatingBar;
import com.byazt.nr.z;
import com.byazt.omf.x;
import com.byazt.ouz.BackupView;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.rh;
import com.byazt.ui.UpieImageView;
import com.byazt.vfu.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 437})
public class BannerExpressBackupView extends BackupView {
    public static rh[] u = {new rh(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new rh(3, 1.2f, 600, 500)};
    public TextView gt;
    public com.byazt.pop.ve m;
    public TextView my;
    public int nu;
    public rh rh;
    public ImageView rl;
    public View yp;
    public NativeExpressView z;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.nu = 1;
        this.c = context;
    }

    @Override // com.byazt.ouz.BackupView
    public void c(View view, int i, gr grVar) {
        if (this.z != null) {
            if (i == 1 || i == 2) {
                View viewFindViewById = this.yp.findViewById(2114387854);
                if (i == 1) {
                    this.z.getClickListener().tt(viewFindViewById);
                } else {
                    this.z.getClickCreativeListener().tt(viewFindViewById);
                }
            }
            this.z.c(view, i, grVar, -1);
        }
    }

    public void c(ic icVar, NativeExpressView nativeExpressView, com.byazt.pop.ve veVar) {
        setBackgroundColor(-1);
        this.tt = icVar;
        this.z = nativeExpressView;
        this.m = veVar;
        this.n = com.byazt.dyf.tt.AD_TAG_BANNER;
        this.z.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.x = nb.t(this.tt);
        tt(this.x);
        tt();
        ve(x.m().pu());
    }

    private void tt() {
        this.rh = c(this.z.getExpectExpressWidth(), this.z.getExpectExpressHeight());
        if (this.z.getExpectExpressWidth() > 0 && this.z.getExpectExpressHeight() > 0) {
            this.f2598a = pf.ve(this.c, this.z.getExpectExpressWidth());
            this.sp = pf.ve(this.c, this.z.getExpectExpressHeight());
        } else {
            this.f2598a = pf.uj(this.c);
            this.sp = Float.valueOf(this.f2598a / this.rh.ve).intValue();
        }
        if (this.f2598a > 0 && this.f2598a > pf.uj(this.c)) {
            float fUj = pf.uj(this.c) / this.f2598a;
            this.f2598a = pf.uj(this.c);
            this.sp = Float.valueOf(this.sp * fUj).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f2598a, this.sp);
        }
        layoutParams.width = this.f2598a;
        layoutParams.height = this.sp;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.rh.c != 1 && this.rh.c == 3) {
            c(this.rh);
        } else {
            ve();
        }
    }

    private void c(ImageView imageView) {
        com.byazt.xky.tt.c(this.tt.pa().get(0)).to(imageView);
        if (com.byazt.ic.c.uj(this.tt)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.byazt.ic.c.i(this.tt), com.byazt.nj.c.c(this.tt), com.byazt.ic.c.da(this.tt));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.byazt.ic.c.c(imageView, upieImageView);
        }
    }

    private void c(rh rhVar) {
        View viewC;
        float fVe = (this.sp * 1.0f) / pf.ve(this.c, 250.0f);
        View viewHd = a.hd(this.c);
        this.yp = viewHd;
        addView(viewHd);
        FrameLayout frameLayout = (FrameLayout) this.yp.findViewById(2114387772);
        this.rl = (ImageView) this.yp.findViewById(2114387854);
        ImageView imageView = (ImageView) this.yp.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.yp.findViewById(2114387931);
        this.my = (TextView) this.yp.findViewById(2114387940);
        this.gt = (TextView) this.yp.findViewById(2114387920);
        TextView textView = (TextView) this.yp.findViewById(2114387927);
        TextView textView2 = (TextView) this.yp.findViewById(2114387633);
        pf.c((TextView) this.yp.findViewById(2114387658), this.tt);
        LinearLayout linearLayout = (LinearLayout) this.yp.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (pf.ve(this.c, 45.0f) * fVe);
            layoutParams.height = (int) (pf.ve(this.c, 45.0f) * fVe);
        }
        this.my.setTextSize(2, pf.tt(this.c, this.my.getTextSize()) * fVe);
        this.gt.setTextSize(2, pf.tt(this.c, this.gt.getTextSize()) * fVe);
        textView.setTextSize(2, pf.tt(this.c, textView.getTextSize()) * fVe);
        textView2.setTextSize(2, pf.tt(this.c, textView2.getTextSize()) * fVe);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fVe - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = pf.ve(this.c, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (pf.ve(this.c, 16.0f) * fVe), 0, 0);
        } catch (Throwable unused) {
        }
        this.rl.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.tp.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.c();
            }
        });
        int iVe = pf.ve(this.c, 15.0f);
        pf.c(this.rl, iVe, iVe, iVe, iVe);
        if (xd.z(this.tt) != null && (viewC = c(this.z)) != null) {
            int i = (this.f2598a * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
            if (rhVar.tt == 1) {
                int i2 = (this.f2598a * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
            } else if (rhVar.tt == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (rhVar.tt == 3) {
                int i3 = (this.sp * 188) / 260;
                layoutParams3 = new FrameLayout.LayoutParams((i3 * 16) / 9, i3);
            } else if (rhVar.tt == 4) {
                int i4 = (this.f2598a * 480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i4, (i4 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewC, 0, layoutParams3);
            pf.c((View) imageView, 8);
        } else {
            c(imageView);
            pf.c((View) imageView, 0);
        }
        com.byazt.xky.tt.c(this.tt.te()).to(imageView2);
        textView.setText(getNameOrSource());
        this.my.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.gt.setText(getDescription());
        if (!TextUtils.isEmpty(this.tt.tj())) {
            textView2.setText(this.tt.tj());
        }
        c((View) this, true);
        c((View) textView2, true);
        c(frameLayout);
    }

    private void ve() {
        float fVe = (this.sp * 1.0f) / pf.ve(this.c, 50.0f);
        if ((this.sp * 1.0f) / this.f2598a > 0.21875f) {
            fVe = (this.f2598a * 1.0f) / pf.ve(this.c, 320.0f);
        }
        View viewIc = a.ic(this.c);
        this.yp = viewIc;
        addView(viewIc);
        this.rl = (ImageView) this.yp.findViewById(2114387854);
        ImageView imageView = (ImageView) this.yp.findViewById(2114387931);
        this.my = (TextView) this.yp.findViewById(2114387940);
        TextView textView = (TextView) this.yp.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.yp.findViewById(2114387891);
        TextView textView2 = (TextView) this.yp.findViewById(2114387633);
        this.my.setTextSize(2, pf.tt(this.c, this.my.getTextSize()) * fVe);
        textView.setTextSize(2, pf.tt(this.c, textView.getTextSize()) * fVe);
        textView2.setTextSize(2, pf.tt(this.c, textView2.getTextSize()) * fVe);
        TextView textView3 = (TextView) this.yp.findViewById(2114387658);
        this.rl.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.tp.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.c();
            }
        });
        pf.c(textView3, this.tt, 27, 11);
        com.byazt.xky.tt.c(this.tt.te()).to(imageView);
        this.my.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (pf.ve(this.c, 45.0f) * fVe);
            layoutParams.height = (int) (pf.ve(this.c, 45.0f) * fVe);
        }
        if (!TextUtils.isEmpty(this.tt.tj())) {
            textView2.setText(this.tt.tj());
        }
        int iN = this.tt.z() != null ? this.tt.z().n() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iN)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iN);
        tTRatingBar.setStarImageWidth(pf.ve(this.c, 15.0f) * fVe);
        tTRatingBar.setStarImageHeight(pf.ve(this.c, 14.0f) * fVe);
        tTRatingBar.setStarImagePadding(pf.ve(this.c, 4.0f));
        tTRatingBar.c();
        c((View) this, true);
        c((View) textView2, true);
    }

    private rh c(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 300.0d) / 600.0d) ? u[1] : u[0];
        } catch (Throwable unused) {
            return u[0];
        }
    }

    private void ve(int i) {
        if (i == 1) {
            n();
            this.yp.setBackgroundColor(0);
        } else {
            uj();
            this.yp.setBackgroundColor(-1);
        }
    }

    private void uj() {
        if (this.rh.c != 2 && this.rh.c != 3) {
            TextView textView = this.my;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FF333333"));
            }
            if (this.rl != null) {
                z.c(getContext(), "tt_dislike_icon", this.rl, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            }
            return;
        }
        TextView textView2 = this.my;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        }
        TextView textView3 = this.gt;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#3E3E3E"));
        }
        if (this.rl != null) {
            this.rl.setImageDrawable(a.bm(this.c));
        }
    }

    private void n() {
        if (this.rh.c == 2 || this.rh.c == 3) {
            TextView textView = this.my;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.gt;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.my;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.rl != null) {
            z.c(getContext(), "tt_dislike_icon_night", this.rl, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    @Override // com.byazt.ouz.BackupView, com.byazt.xv.c
    public void b_(int i) {
        super.b_(i);
        ve(i);
    }
}
