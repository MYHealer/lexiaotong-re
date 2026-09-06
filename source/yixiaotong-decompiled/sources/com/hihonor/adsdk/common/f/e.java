package com.hihonor.adsdk.common.f;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    private static final String hnadsa = "e";
    private static Method hnadsb;

    class a implements Runnable {
        final /* synthetic */ View hnadsd;
        final /* synthetic */ int hnadse;
        final /* synthetic */ int hnadsf;
        final /* synthetic */ int hnadsg;
        final /* synthetic */ int hnadsh;
        final /* synthetic */ View hnadsi;

        a(View view, int i, int i2, int i3, int i4, View view2) {
            this.hnadsd = view;
            this.hnadse = i;
            this.hnadsf = i2;
            this.hnadsg = i3;
            this.hnadsh = i4;
            this.hnadsi = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.hnadsd.getHitRect(rect);
            rect.left -= this.hnadse;
            rect.top -= this.hnadsf;
            rect.right += this.hnadsg;
            rect.bottom += this.hnadsh;
            this.hnadsi.setTouchDelegate(new TouchDelegate(rect, this.hnadsd));
        }
    }

    public static class b implements View.OnClickListener {
        private View.OnClickListener hnadsa;

        public View.OnClickListener hnadsa() {
            return this.hnadsa;
        }

        public void hnadsa(View.OnClickListener onClickListener) {
            this.hnadsa = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "ProxyClickListener#call proxy onClick method", new Object[0]);
            View.OnClickListener onClickListener = this.hnadsa;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public static boolean hnadsc(View view) {
        return hnadsa(view) instanceof b;
    }

    private static Object hnadsa(Object obj) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = obj.getClass().getDeclaredField("mOnClickListener");
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object hnadsb(View view) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method declaredMethod = hnadsb;
        if (declaredMethod == null) {
            declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            hnadsb = declaredMethod;
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(view, new Object[0]);
    }

    public static void hnadsa(View view, b bVar) {
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "setOnClickListener target is null", new Object[0]);
            return;
        }
        try {
            Object objHnadsb = hnadsb(view);
            if (objHnadsb == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "setOnClickListener Proxy click listener ex! listenerInfo get value is null", new Object[0]);
                return;
            }
            Object objHnadsa = hnadsa(objHnadsb);
            if (objHnadsa == null) {
                view.setOnClickListener(bVar);
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "Get target view click listener is null. Will set proxy click listener in target.", new Object[0]);
            } else {
                bVar.hnadsa((View.OnClickListener) objHnadsa);
                view.setOnClickListener(bVar);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "setOnClickListener, Proxy click listener ex!, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    public static View.OnClickListener hnadsa(View view) {
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "getClickListener target is null", new Object[0]);
            return null;
        }
        try {
            Object objHnadsb = hnadsb(view);
            if (objHnadsb == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "getClickListener Proxy click listener ex! listenerInfo get value is null", new Object[0]);
                return null;
            }
            Object objHnadsa = hnadsa(objHnadsb);
            if (objHnadsa instanceof View.OnClickListener) {
                return (View.OnClickListener) objHnadsa;
            }
            return null;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getClickListener, Proxy click listener ex!, Exception: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void hnadsa(View view, int i) {
        hnadsa(view, i, i, i, i);
    }

    public static void hnadsa(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            view2.post(new a(view, i, i2, i3, i4, view2));
        }
    }
}
