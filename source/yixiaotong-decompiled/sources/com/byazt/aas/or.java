package com.byazt.aas;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 579})
public final class or {
    public static final ConcurrentHashMap<ViewGroup, Object> c = new ConcurrentHashMap<>();
    public static final Object tt = new Object();
    public static volatile boolean ve = false;

    private or() {
    }

    public static void c(WeakReference<ViewGroup> weakReference, com.byazt.hkv.ve veVar) {
        if (weakReference == null || veVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.byazt.omf.zb.c(viewGroup)) {
            c(viewGroup, false);
            return;
        }
        c.put(viewGroup, veVar);
        if (ve) {
            c(viewGroup, false);
            return;
        }
        synchronized (or.class) {
            if (ve) {
                c(viewGroup, false);
            } else {
                ve = true;
                com.byazt.omf.rh.a().postDelayed(new Runnable() { // from class: com.byazt.aas.or.1
                    @Override // java.lang.Runnable
                    public void run() {
                        or.ve();
                    }
                }, 50L);
            }
        }
    }

    public static boolean c(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(2114387349);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z));
        Object tag = viewGroup.getTag(2114387349);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.byazt.nr.m.uj("TTShakeChecker", th.getMessage());
                c(2114387349, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(2114387349, map);
    }

    public static void c(final int i, final String str) {
        com.byazt.ukr.tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.aas.or.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i);
                    jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, str);
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("stats_shake_tag_key").tt(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void c(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.byazt.omf.zb.c(viewGroup) && c(f, f2, j)) {
            c.put(viewGroup, tt);
            if (ve) {
                return;
            }
            synchronized (or.class) {
                if (ve) {
                    return;
                }
                ve = true;
                com.byazt.omf.rh.a().postDelayed(new Runnable() { // from class: com.byazt.aas.or.3
                    @Override // java.lang.Runnable
                    public void run() {
                        or.uj();
                    }
                }, 50L);
            }
        }
    }

    private static boolean c(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.14748365E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return fCurrentTimeMillis >= f && fCurrentTimeMillis <= f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    public static void ve() {
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = c;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iN = pf.n(com.byazt.omf.gt.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    c.remove(viewGroup3);
                } else if (!com.byazt.omf.zb.c(viewGroup3)) {
                    c.remove(viewGroup3);
                } else {
                    int i2 = iN / 2;
                    int i3 = rect.bottom <= i2 ? i2 - rect.bottom : Integer.MAX_VALUE;
                    int i4 = rect.top >= i2 ? rect.top - i2 : Integer.MAX_VALUE;
                    if (rect.bottom > i2 && rect.top < i2) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i4, i3);
                    if (iMin < i) {
                        viewGroup = viewGroup3;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap2 = c;
        com.byazt.hkv.ve veVar = concurrentHashMap2.get(viewGroup2) instanceof com.byazt.hkv.ve ? (com.byazt.hkv.ve) concurrentHashMap2.get(viewGroup2) : null;
        c(viewGroup2, true);
        concurrentHashMap2.clear();
        ve = false;
        if (veVar != null) {
            veVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb  */
    public static void uj() {
        com.byazt.hkv.c cVar;
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = c;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iN = pf.n(com.byazt.omf.gt.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    c.remove(viewGroup3);
                } else if (!com.byazt.omf.zb.c(viewGroup3)) {
                    c.remove(viewGroup3);
                } else {
                    int i2 = iN / 2;
                    int i3 = rect.bottom <= i2 ? i2 - rect.bottom : Integer.MAX_VALUE;
                    int i4 = rect.top >= i2 ? rect.top - i2 : Integer.MAX_VALUE;
                    if (rect.bottom > i2 && rect.top < i2) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i4, i3);
                    if (iMin < i) {
                        viewGroup = viewGroup3;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        for (int i5 = 0; i5 < viewGroup2.getChildCount(); i5++) {
            Object tag = viewGroup2.getChildAt(i5).getTag(2114387349);
            if (tag instanceof Map) {
                Object obj = ((Map) tag).get("click_listener");
                if (obj instanceof com.byazt.hkv.c) {
                    cVar = (com.byazt.hkv.c) obj;
                } else {
                    cVar = null;
                }
            } else {
                cVar = null;
            }
            if (cVar != null) {
                HashMap map = new HashMap();
                map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsh, 2);
                com.byazt.vis.c cVar2 = (com.byazt.vis.c) cVar.c(com.byazt.vis.c.class);
                cVar2.c(map);
                cVar2.c();
                cVar.onClick(viewGroup2);
                break;
            }
        }
        c.clear();
        ve = false;
    }
}
