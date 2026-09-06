package com.byazt.iyp;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 15})
public final class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<View> f2364a;
    public static Field x;
    public static final Map<View, n.C0189n> c = new WeakHashMap();
    public static final Map<View, Boolean> tt = new WeakHashMap();
    public static int ve = -1;
    public static long uj = 0;
    public static boolean n = false;
    public static final Rect sp = new Rect();
    public static boolean i = false;
    public static long da = 0;
    public static int sl = 0;
    public static volatile String t = null;
    public static final Handler u = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean yp = new AtomicBoolean(false);
    public static final AtomicBoolean z = new AtomicBoolean(false);
    public static final Runnable m = new Runnable() { // from class: com.byazt.iyp.uj.1
        @Override // java.lang.Runnable
        public void run() {
            uj.yp.set(false);
            try {
                uj.yp();
            } catch (Throwable unused) {
            }
        }
    };

    public static void n() {
        n = false;
    }

    public static void sp() {
        t = null;
        da = 0L;
        sl = 0;
    }

    public static int tt() {
        return ve;
    }

    public static void uj() {
        n = true;
    }

    public static void c() {
        ve = -1;
        n = false;
        sp();
        z.set(false);
        sl = 0;
        tt.clear();
    }

    public static void ve() {
        c.clear();
    }

    public static void c(int i2) {
        ve = i2;
        tt(ve(i2));
    }

    public static void c(View view) {
        f2364a = view != null ? new WeakReference<>(view) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = t;
        boolean z2 = str != null && str.startsWith("Tab_");
        boolean z3 = z2 && sl >= 3;
        if (str != null && ((!z2 || z3) && jCurrentTimeMillis - da < 60000)) {
            return str;
        }
        x();
        if (t == null && (n.ve() == null || n.ve().isEmpty())) {
            z();
        }
        String str2 = t;
        if (str2 == null) {
            str2 = "";
        }
        if (!str2.startsWith("Tab_")) {
            sl = 0;
        } else if (z2) {
            sl++;
        } else {
            sl = 1;
        }
        t = str2;
        da = jCurrentTimeMillis;
        return str2;
    }

    private static void z() {
        n.tt ttVarC;
        AtomicBoolean atomicBoolean = z;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        try {
            Activity activityC = sp.c();
            if (activityC == null || (ttVarC = n.c(activityC)) == null || ttVarC.uj == null || ttVarC.uj.isEmpty() || ttVarC.tt < 0 || ttVarC.tt >= ttVarC.uj.size()) {
                return;
            }
            n = true;
            c(ttVarC.tt);
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        if (m()) {
            return yp();
        }
        String str = t;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((str == null || jCurrentTimeMillis - da >= 60000) && yp.compareAndSet(false, true)) {
            u.post(m);
        }
        return str != null ? str : PPSLabelView.Code;
    }

    public static void x() {
        int iUj;
        if (n && nu() && (iUj = n.uj()) >= 0) {
            int i2 = ve;
            boolean z2 = iUj != i2;
            boolean z3 = i2 < 0;
            if (z2) {
                ve = iUj;
            } else if (!z3) {
                return;
            }
            tt(ve(iUj));
        }
    }

    public static void c(View view, n.C0189n c0189n) {
        if (view == null) {
            return;
        }
        c.put(view, c0189n);
        tt(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                c(viewGroup.getChildAt(i2), c0189n);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, AppTypeIdUtil.NewDevice4GBathOTA})
    private static final class c extends View.AccessibilityDelegate {
        public final View.AccessibilityDelegate c;
        public boolean tt;

        public c(View.AccessibilityDelegate accessibilityDelegate) {
            this.c = accessibilityDelegate;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            if (this.tt) {
                super.sendAccessibilityEvent(view, i);
                return;
            }
            this.tt = true;
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.c;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
                this.tt = false;
                if (i == 1 || i == 4) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - uj.uj < 300) {
                        return;
                    }
                    long unused = uj.uj = jCurrentTimeMillis;
                    n.C0189n c0189n = (n.C0189n) uj.c.get(view);
                    if (c0189n != null) {
                        int unused2 = uj.ve = c0189n.c;
                        uj.tt(c0189n.c());
                        int unused3 = uj.ve;
                    }
                }
            } catch (Throwable th) {
                this.tt = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(String str) {
        if (str == null) {
            str = "";
        }
        t = str;
        da = System.currentTimeMillis();
    }

    private static boolean m() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private static boolean nu() {
        View view;
        WeakReference<View> weakReference = f2364a;
        if (weakReference != null && (view = weakReference.get()) != null && view.isAttachedToWindow() && view.getVisibility() == 0 && view.getWidth() > 0 && view.getHeight() > 0) {
            return view.getGlobalVisibleRect(sp);
        }
        return false;
    }

    private static String ve(int i2) {
        String strConcat = "Tab_".concat(String.valueOf(i2));
        List<n.C0189n> listVe = n.ve();
        if (listVe == null || i2 < 0 || i2 >= listVe.size()) {
            return strConcat;
        }
        String strC = listVe.get(i2).c();
        return !TextUtils.isEmpty(strC) ? strC : strConcat;
    }

    private static void tt(View view) {
        Map<View, Boolean> map = tt;
        if (map.containsKey(view)) {
            return;
        }
        View.AccessibilityDelegate accessibilityDelegateVe = ve(view);
        if (accessibilityDelegateVe instanceof c) {
            return;
        }
        view.setAccessibilityDelegate(new c(accessibilityDelegateVe));
        map.put(view, Boolean.TRUE);
    }

    private static View.AccessibilityDelegate ve(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (i) {
            return null;
        }
        try {
            if (x == null) {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                x = declaredField;
                declaredField.setAccessible(true);
            }
            Object obj = x.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
        } catch (Throwable unused) {
            i = true;
        }
        return null;
    }
}
