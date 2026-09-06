package com.miui.zeus.mimo.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l8 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SixElementsView f5523a;

    public l8(SixElementsView sixElementsView) {
        this.f5523a = sixElementsView;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
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
        int iA;
        float fA;
        int width = this.f5523a.getWidth();
        int height = this.f5523a.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        SixElementsView sixElementsView = this.f5523a;
        int i = SixElementsView.m;
        int childCount = sixElementsView.getChildCount();
        if (childCount <= 0) {
            ViewGroup.LayoutParams layoutParams = sixElementsView.getLayoutParams();
            layoutParams.width = 0;
            sixElementsView.setLayoutParams(layoutParams);
        } else {
            ArrayList arrayList = new ArrayList();
            float f = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = sixElementsView.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        Object tag = textView.getTag(a0.s);
                        int iIntValue = !(tag instanceof Integer) ? -1 : ((Integer) tag).intValue();
                        if (iIntValue >= 3) {
                            fA = sixElementsView.a(textView);
                            f += fA;
                        } else if (iIntValue >= 0) {
                            arrayList.add(textView);
                        }
                    } else if (childAt instanceof LinearLayout) {
                        fA = f9.a(sixElementsView.getContext(), 8.01f);
                        f += fA;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                float width2 = sixElementsView.getWidth() - f;
                if (width2 > 0.0f) {
                    while (true) {
                        int iA2 = sixElementsView.a(arrayList);
                        if (iA2 < 0) {
                            break;
                        }
                        float fA2 = (!arrayList.isEmpty() && (iA = sixElementsView.a(arrayList)) >= 0) ? sixElementsView.a((TextView) arrayList.get(iA)) : 0.0f;
                        if (fA2 <= 0.0f) {
                            break;
                        }
                        if (fA2 >= width2 / arrayList.size()) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                TextView textView2 = (TextView) arrayList.get(i3);
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                                layoutParams2.weight = 1.0f;
                                layoutParams2.width = 0;
                                textView2.setLayoutParams(layoutParams2);
                            }
                            arrayList.clear();
                        } else {
                            width2 -= fA2;
                            arrayList.remove(iA2);
                        }
                    }
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt2 = sixElementsView.getChildAt(i4);
                        if (childAt2 != null) {
                            childAt2.setVisibility(0);
                        }
                    }
                }
            }
        }
        this.f5523a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
