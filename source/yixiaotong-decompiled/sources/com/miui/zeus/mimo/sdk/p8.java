package com.miui.zeus.mimo.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p8 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f5564a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ LinearLayout d;
    public final /* synthetic */ TextView e;
    public final /* synthetic */ SixElementsView f;

    public p8(SixElementsView sixElementsView, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3) {
        this.f = sixElementsView;
        this.f5564a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = linearLayout2;
        this.e = textView3;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f0  */
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
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        float f;
        int width;
        float width2;
        int width3;
        int width4 = this.f.getWidth();
        int height = this.f.getHeight();
        if (width4 <= 0 || height <= 0) {
            return;
        }
        int width5 = this.f5564a.getWidth();
        int height2 = this.f5564a.getHeight();
        float width6 = 0.0f;
        if (width5 <= 0 || height2 <= 0) {
            f = 0.0f;
        } else {
            SixElementsView sixElementsView = this.f;
            LinearLayout linearLayout = this.f5564a;
            TextView textView = this.b;
            TextView textView2 = this.c;
            int i = SixElementsView.m;
            sixElementsView.getClass();
            int childCount = linearLayout.getChildCount();
            if (childCount > 0 && !(textView == null && textView2 == null)) {
                if (textView == null) {
                    width3 = textView2.getWidth();
                } else if (textView2 == null) {
                    width3 = textView.getWidth();
                } else {
                    float fA = 0.0f;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = linearLayout.getChildAt(i2);
                        if (childAt != null) {
                            fA += childAt instanceof TextView ? sixElementsView.a((TextView) childAt) : childAt.getWidth();
                        }
                    }
                    if (fA <= sixElementsView.getWidth()) {
                        f = fA;
                    } else {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                        float fA2 = sixElementsView.a(textView2);
                        float fA3 = sixElementsView.a(textView);
                        if (fA2 >= sixElementsView.getWidth()) {
                            if (fA3 > sixElementsView.getWidth() / 5.0f) {
                                width = sixElementsView.getWidth() * 4;
                                width2 = width / 5.0f;
                            } else {
                                width2 = (sixElementsView.getWidth() - fA3) - f9.a(sixElementsView.getContext(), 8.01f);
                            }
                        } else if (fA3 > (sixElementsView.getWidth() * 4) / 5.0f) {
                            width = sixElementsView.getWidth();
                            width2 = width / 5.0f;
                        } else {
                            width2 = (sixElementsView.getWidth() - fA3) - f9.a(sixElementsView.getContext(), 8.01f);
                        }
                        int i3 = (int) width2;
                        layoutParams.width = i3;
                        textView2.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams2.width = (sixElementsView.getWidth() - i3) - f9.a(sixElementsView.getContext(), 8.01f);
                        layoutParams2.weight = 0.0f;
                        textView.setLayoutParams(layoutParams2);
                        width3 = sixElementsView.getWidth();
                    }
                }
                f = width3;
            } else {
                f = 0.0f;
            }
        }
        int width7 = this.d.getWidth();
        int height3 = this.d.getHeight();
        if (width7 > 0 && height3 > 0) {
            SixElementsView sixElementsView2 = this.f;
            LinearLayout linearLayout2 = this.d;
            TextView textView3 = this.e;
            int i4 = SixElementsView.m;
            sixElementsView2.getClass();
            int childCount2 = linearLayout2.getChildCount();
            if (childCount2 > 0) {
                for (int i5 = 0; i5 < childCount2; i5++) {
                    View childAt2 = linearLayout2.getChildAt(i5);
                    if (childAt2 != null) {
                        width6 += childAt2 instanceof TextView ? sixElementsView2.a((TextView) childAt2) : childAt2.getWidth();
                    }
                }
                if (width6 > sixElementsView2.getWidth()) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams3.width = 0;
                    layoutParams3.weight = 1.0f;
                    textView3.setLayoutParams(layoutParams3);
                    width6 = sixElementsView2.getWidth();
                }
            }
        }
        for (int i6 = 0; i6 < this.f5564a.getChildCount(); i6++) {
            View childAt3 = this.f5564a.getChildAt(i6);
            if (childAt3 != null) {
                childAt3.setVisibility(0);
            }
        }
        for (int i7 = 0; i7 < this.d.getChildCount(); i7++) {
            View childAt4 = this.d.getChildAt(i7);
            if (childAt4 != null) {
                childAt4.setVisibility(0);
            }
        }
        ViewGroup.LayoutParams layoutParams4 = this.f.getLayoutParams();
        layoutParams4.width = (int) Math.max(f, width6);
        this.f.setLayoutParams(layoutParams4);
        this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
