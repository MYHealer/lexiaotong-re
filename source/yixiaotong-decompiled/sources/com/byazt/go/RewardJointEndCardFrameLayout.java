package com.byazt.go;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.aas.rl;
import com.byazt.bzd.x;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.fq.a;
import com.byazt.hkv.tt;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.z;
import com.byazt.xzj.RewardJointBottomView;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 1225, 1962})
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f2258a;
    public RewardJointBottomView n;
    public View uj;
    public FrameLayout ve;

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.f2258a;
    }

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        c(linearLayout);
        tt(linearLayout);
        ve(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.n.getWebView();
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void setClickListener(tt ttVar) {
        pf.c(this.uj, (View.OnClickListener) ttVar, "bar_view");
        this.n.setClickListener(ttVar);
    }

    private void c(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.ve = frameLayout;
        if (uj()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, pf.ve(getContext(), 200.0f)));
        }
        ve();
        if (!ic.ve(this.tt)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            com.byazt.xky.tt.c(this.tt.pa().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.go.RewardJointEndCardFrameLayout.1
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    imageView.setImageBitmap(mVar.getResult());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.f2258a = frameLayout2;
        }
    }

    private void ve() {
        if (!ic.ve(this.tt)) {
            com.byazt.xky.tt.c(this.tt.pa().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.go.RewardJointEndCardFrameLayout.2
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    Bitmap bitmapC = com.byazt.or.tt.c(RewardJointEndCardFrameLayout.this.getContext(), mVar.getResult(), 25);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapC);
                    x.c(new Runnable() { // from class: com.byazt.go.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.ve != null) {
                                RewardJointEndCardFrameLayout.this.ve.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            com.byazt.xky.tt.c(xd.tt(this.tt)).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.go.RewardJointEndCardFrameLayout.3
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    Bitmap bitmapC = com.byazt.or.tt.c(RewardJointEndCardFrameLayout.this.getContext(), mVar.getResult(), 25);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapC);
                    x.c(new Runnable() { // from class: com.byazt.go.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.f2258a != null) {
                                RewardJointEndCardFrameLayout.this.f2258a.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void tt(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(pf.ve(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(pf.ve(getContext(), 40.0f), pf.ve(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(pf.ve(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, pf.ve(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(pf.ve(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pf.ve(getContext(), 70.0f), pf.ve(getContext(), 24.0f));
        layoutParams2.setMarginEnd(pf.ve(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, pf.ve(getContext(), 60.0f)));
        this.uj = linearLayout;
        zb zbVarTe = this.tt.te();
        if (zbVarTe != null && !TextUtils.isEmpty(zbVarTe.c())) {
            com.byazt.xky.tt.c(zbVarTe).to(tTRoundRectImageView);
        } else {
            z.c(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        if (this.tt.z() != null && !TextUtils.isEmpty(this.tt.z().ve())) {
            textView.setText(this.tt.z().ve());
        } else {
            textView.setText(this.tt.an());
        }
        textView2.setText(this.tt.v_());
        textView3.setText(this.tt.tj());
    }

    private void ve(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.tt);
        this.n = rewardJointBottomView;
        if (uj()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, pf.ve(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.c(rl.c(this.tt));
    }

    private boolean uj() {
        if (this.tt.id() == 15) {
            return true;
        }
        if (this.tt.id() == 5) {
            return false;
        }
        if (this.tt.pa() == null || this.tt.pa().isEmpty()) {
            return true;
        }
        zb zbVar = this.tt.pa().get(0);
        return zbVar.ve() > zbVar.tt();
    }

    @Override // com.byazt.fq.a
    public boolean c(View view, View view2, int i, int i2) {
        return uj();
    }

    @Override // com.byazt.fq.a
    public void c(View view, int i, int i2, int[] iArr, int i3) {
        int iC = c(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.height -= iC;
        this.n.setLayoutParams(layoutParams);
        if (iC != 0) {
            this.c.pu().bx();
        }
        iArr[1] = iArr[1] + iC;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.byazt.fq.n
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    private int c(int i) {
        if (i > 0) {
            int height = this.n.getHeight() - pf.ve(getContext(), 200.0f);
            if (height <= 0) {
                i = 0;
            } else if (height < Math.abs(i)) {
                i = height;
            }
        } else {
            int height2 = this.ve.getHeight() - pf.ve(getContext(), 160.0f);
            if (height2 <= 0) {
                i = 0;
            } else if (height2 < Math.abs(i)) {
                i = -height2;
            }
        }
        if (Math.abs(i) > 400) {
            return 0;
        }
        return i;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void tt() {
        super.tt();
        RewardJointBottomView rewardJointBottomView = this.n;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.tt();
        }
    }
}
