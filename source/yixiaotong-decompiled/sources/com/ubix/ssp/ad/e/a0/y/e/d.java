package com.ubix.ssp.ad.e.a0.y.e;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8744a;
    private String b;
    private String c;
    private String d;
    private float e;
    private int f;
    private int g;
    private int h;
    private double i;
    private int j;
    private boolean k;
    private List<com.ubix.ssp.ad.e.a0.y.e.f.b> l;
    Set<String> m;

    public d(View view) {
        Rect rectA;
        this.k = false;
        this.l = null;
        this.m = null;
        try {
            this.f8744a = System.currentTimeMillis();
            this.l = new ArrayList();
            this.m = new HashSet();
            this.b = view.getWidth() + "x" + view.getHeight();
            Rect rectA2 = e.a(view);
            Point point = new Point();
            point.x = rectA2.left;
            point.y = rectA2.top;
            this.c = point.x + "x" + point.y;
            if (!a(view) && (rectA = a(view, rectA2)) != null) {
                rectA2 = rectA;
            }
            this.e = view.getAlpha();
            this.f = view.isShown() ? 1 : 0;
            Rect rectA3 = e.a(view.getContext());
            Rect rect = new Rect();
            rect.setIntersect(rectA2, rectA3);
            this.d = Math.abs(rect.right - rect.left) + "x" + Math.abs(rect.bottom - rect.top);
            boolean zC = c(view);
            this.k = zC;
            if (zC) {
                e(view);
                double dA = this.l.size() > 0 ? new com.ubix.ssp.ad.e.a0.y.e.f.a().a(this.l) : 0.0d;
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                double width = view.getWidth() * view.getHeight();
                this.i = Math.round(((dA + (width - ((double) ((rect2.right - rect2.left) * (rect2.bottom - rect2.top))))) / width) * 100.0d) / 100.0d;
            } else {
                this.i = 1.0d;
            }
            this.g = e.b(view) ? 1 : 0;
            this.h = view.hasWindowFocus() ? 1 : 0;
            view.getLocalVisibleRect(new Rect());
            this.l = null;
            this.m = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int a(View view, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.ViewGroup] */
    private Rect a(View view, Rect rect) {
        while (view.getParent() instanceof ViewGroup) {
            try {
                view = (ViewGroup) view.getParent();
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                ViewGroup viewGroup = view.getParent() instanceof ViewGroup ? (ViewGroup) view.getParent() : null;
                if (viewGroup != null && viewGroup.getClipChildren()) {
                    Rect rect3 = new Rect();
                    rect3.setIntersect(rect, rect2);
                    rect = rect3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rect;
    }

    private void a(Rect rect, Rect rect2) {
        int iMax = Math.max(rect.left, rect2.left);
        int iMax2 = Math.max(rect.top, rect2.top);
        int iMin = Math.min(rect.right, rect2.right);
        int iMin2 = Math.min(rect.bottom, rect2.bottom);
        this.m.add(iMax + "X" + iMax2 + "X" + Math.abs(iMin - iMax) + "X" + Math.abs(iMin2 - iMax2));
        Rect rect3 = new Rect();
        rect3.setIntersect(rect, rect2);
        com.ubix.ssp.ad.e.a0.y.e.f.b bVar = new com.ubix.ssp.ad.e.a0.y.e.f.b();
        bVar.f8751a = (double) rect3.left;
        bVar.b = (double) rect3.top;
        bVar.c = (double) rect3.right;
        bVar.d = (double) rect3.bottom;
        this.l.add(bVar);
    }

    private void a(View view, View view2) {
        int paddingLeft;
        int paddingTop;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        Point point = new Point();
        view2.getGlobalVisibleRect(rect2, point);
        if ((view2.getParent() instanceof ViewGroup) && (viewGroup = (ViewGroup) view2.getParent()) != null && (viewGroup.getParent() instanceof ViewGroup) && (viewGroup2 = (ViewGroup) viewGroup.getParent()) != null && !viewGroup2.getClipChildren()) {
            rect2.left = point.x;
            rect2.top = point.y;
        }
        if (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup3 = (ViewGroup) view2.getParent();
            paddingLeft = viewGroup3.getPaddingLeft();
            paddingTop = viewGroup3.getPaddingTop();
        } else {
            paddingLeft = 0;
            paddingTop = 0;
        }
        if (paddingLeft != 0 || paddingTop != 0) {
            Rect rect3 = new Rect();
            view2.getLocalVisibleRect(rect3);
            rect2.left += rect3.left + paddingLeft;
            rect2.top += rect3.top + paddingTop;
        }
        if (Rect.intersects(rect, rect2)) {
            a(rect, rect2);
        }
    }

    private boolean a(View view) {
        try {
            Rect rect = new Rect();
            return view.getGlobalVisibleRect(rect, new Point()) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(View view) {
        try {
            if (view.getVisibility() != 0) {
                return false;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getBackground() == null || viewGroup.getChildCount() < 1) {
                    return false;
                }
            }
            if (view.getAlpha() <= 0.1f) {
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    private boolean c(View view) {
        return view.getGlobalVisibleRect(new Rect(), new Point());
    }

    private boolean d(View view) {
        return view.getGlobalVisibleRect(new Rect()) && b(view);
    }

    private void e(View view) {
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iA = a(view2, viewGroup);
            int childCount = viewGroup.getChildCount();
            while (true) {
                iA++;
                if (iA < childCount) {
                    View childAt = viewGroup.getChildAt(iA);
                    boolean zD = d(childAt);
                    if (zD) {
                        a(view, childAt);
                        if (childAt instanceof ViewGroup) {
                            a(view, (ViewGroup) childAt, this.m);
                        }
                    } else {
                        this.k = zD;
                    }
                }
            }
            view2 = viewGroup;
        }
    }

    public void a(View view, ViewGroup viewGroup, Set<String> set) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (d(childAt)) {
                a(view, childAt);
                if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, set);
                }
            }
        }
    }

    public boolean a(float f) {
        if (this.i <= f && this.f == 1 && this.e > 0.001d && this.g == 1 && this.h == 1) {
            this.j = 1;
        } else {
            this.j = 0;
        }
        return this.j == 1;
    }

    public String toString() {
        return "[ 2t=" + this.f8744a + ",2k=" + this.b + ",2d=" + this.c + ",2o=" + this.d + ",2n=" + this.i + ",2l=" + this.e + ",2m=" + this.f + ",2r=" + this.g + ",2s=" + this.h + "]";
    }
}
