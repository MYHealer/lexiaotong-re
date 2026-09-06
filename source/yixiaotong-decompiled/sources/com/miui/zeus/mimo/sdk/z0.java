package com.miui.zeus.mimo.sdk;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.MimoBookmarkView;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z0 extends b1 {
    public MimoBookmarkView A;
    public ImageICP B;

    public z0(Context context) {
        super(context);
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
    @Override // com.miui.zeus.mimo.sdk.b1, com.miui.zeus.mimo.sdk.j0
    public void a(View view) {
        View view2;
        super.a(view);
        this.A = (MimoBookmarkView) view.findViewById(a0.M);
        if (this.k.getResources().getConfiguration().orientation == 2) {
            MimoMediaView mimoMediaView = new MimoMediaView(getContext());
            this.b = mimoMediaView;
            view2 = mimoMediaView;
        } else {
            findViewById(a0.N3).setVisibility(8);
            View viewInflate = LayoutInflater.from(getContext()).inflate(a0.v1, (ViewGroup) this, false);
            this.b = (MimoMediaView) viewInflate.findViewById(a0.Q0);
            this.q = (i0) viewInflate.findViewById(a0.j1);
            view2 = viewInflate;
        }
        this.A.a(view2);
        this.B = (ImageICP) findViewById(a0.g0);
        this.A.setOutlineProvider(new t6(f9.a(getContext(), 14.5f)));
        this.A.setClipToOutline(true);
        this.b.setOutlineProvider(new t6(f9.a(getContext(), 14.5f)));
        this.b.setClipToOutline(true);
    }

    @Override // com.miui.zeus.mimo.sdk.b1, com.miui.zeus.mimo.sdk.j0
    public int getLayoutId() {
        return a0.w3;
    }

    @Override // com.miui.zeus.mimo.sdk.b1, com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        ObjectAnimator objectAnimatorOfFloat;
        float f;
        float f2;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        this.A.setRecommendText(ijiami_1011.s.s.s.d(new byte[]{-128, -40, -66, -126, -10, -109, -121, -22, -50, -118, -68, -11}, "dc4da6"));
        MimoBookmarkView mimoBookmarkView = this.A;
        mimoBookmarkView.f5664a.setPivotX(mimoBookmarkView.g);
        mimoBookmarkView.f5664a.setPivotY(mimoBookmarkView.h);
        mimoBookmarkView.b.setPivotX(mimoBookmarkView.g);
        mimoBookmarkView.b.setPivotY(mimoBookmarkView.h);
        if (mimoBookmarkView.getResources().getConfiguration().orientation == 2) {
            RelativeLayout relativeLayout = mimoBookmarkView.b;
            relativeLayout.setPivotX(relativeLayout.getLayoutParams().width - mimoBookmarkView.g);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(mimoBookmarkView.f5664a, ijiami_1011.s.s.s.d(new byte[]{66, 19, 3, 86, Ascii.DC2, 90, 0, 16, 15, 13, 95, Base64.padSymbol}, "6ab8a6"), 0.0f, -f9.a(mimoBookmarkView.getContext(), 14.5f));
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            f = 2.38f;
            f2 = -2.07f;
        } else {
            objectAnimatorOfFloat = null;
            f = 2.7f;
            f2 = -2.9f;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(mimoBookmarkView.f5664a, ijiami_1011.s.s.s.d(new byte[]{65, 92, 17, 3, Ascii.NAK, 90, 14, 10}, "33eba3"), 0.0f, f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(mimoBookmarkView.b, ijiami_1011.s.s.s.d(new byte[]{68, 92, 71, 87, 16, 92, 14, 10}, "6336d5"), 0.0f, f2);
        objectAnimatorOfFloat3.setDuration(1000L);
        objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        if (objectAnimatorOfFloat != null) {
            animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat);
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        }
        animatorSet.start();
        this.B.a(mimoAdInfo, w3Var, this);
        this.c.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 6, 83, 84, 1, 1, 81, 84, 86}, "80ed11")));
    }
}
