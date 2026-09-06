package com.byazt.go;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.aas.cu;
import com.byazt.aas.rl;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.hkv.tt;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.byazt.rpt.PlayableEndcardFrameLayout;
import com.byazt.vfu.a;
import com.byazt.xzj.RewardLpBottomView;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 1225, 1631})
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RewardLpBottomView f2257a;
    public FrameLayout n;
    public PlayableEndcardFrameLayout sp;
    public SSWebView uj;
    public SSWebView ve;

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.n;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void setClickListener(tt ttVar) {
    }

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
    }

    private void ve() {
        SSWebView sSWebView = new SSWebView(this.c);
        sSWebView.setMaterialMeta(cu.c(this.tt));
        sSWebView.setId(2114387697);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.ve = sSWebView;
        addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    private void uj() {
        SSWebView sSWebView = new SSWebView(this.c);
        sSWebView.setMaterialMeta(cu.c(this.tt));
        sSWebView.setId(2114387859);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.uj = sSWebView;
        this.sp.addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
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
    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void c() {
        setId(2114387542);
        if (!TextUtils.isEmpty(xd.i(this.tt)) || !gt.tt().qi()) {
            ve();
        }
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setId(2114387541);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.c);
        this.sp = playableEndcardFrameLayout;
        playableEndcardFrameLayout.setId(2114387675);
        if (rl.tt(this.tt)) {
            uj();
        }
        FrameLayout frameLayout = new FrameLayout(this.c);
        frameLayout.setId(2114387919);
        frameLayout.setVisibility(8);
        this.sp.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutTt = a.tt(this.c);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        linearLayoutTt.setBackground(gradientDrawable);
        this.sp.addView(linearLayoutTt, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.c);
        rewardLpBottomView.setId(2114387824);
        rewardLpBottomView.setVisibility(8);
        this.f2257a = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.sp.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(this.sp, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.c);
        frameLayout2.setId(2114387798);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.n = frameLayout2;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        if (this.ve == null) {
            ve();
        }
        return this.ve;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        if (this.uj == null) {
            uj();
        }
        return this.uj;
    }

    @Override // com.byazt.go.AbstractEndCardFrameLayout
    public void tt() {
        super.tt();
        RewardLpBottomView rewardLpBottomView = this.f2257a;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.tt();
        }
    }
}
