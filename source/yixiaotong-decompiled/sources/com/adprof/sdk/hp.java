package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class hp {
    public static Activity a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            rootView = null;
        } else {
            View viewFindViewById = rootView.findViewById(android.R.id.content);
            if (viewFindViewById != null) {
                rootView = viewFindViewById;
            }
        }
        if (rootView == null) {
            return null;
        }
        for (Context context = rootView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static View m656a(View view) {
        if (view == null) {
            return null;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        return view;
    }

    public static View a(ViewGroup viewGroup, Class cls) {
        View viewA;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                return (View) cls.cast(childAt);
            }
            if ((childAt instanceof ViewGroup) && (viewA = a((ViewGroup) childAt, cls)) != null) {
                return viewA;
            }
        }
        return null;
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return rawY >= i2 && rawY <= view.getMeasuredHeight() + i2 && rawX >= i && rawX <= view.getMeasuredWidth() + i;
    }
}
