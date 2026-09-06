package com.kwad.components.core.t;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l {
    private static final WeakHashMap<a, ViewTreeObserver.OnGlobalLayoutListener> alN = new WeakHashMap<>();

    public interface a {
        void bz(int i);

        void vc();
    }

    public static void a(Window window, final a aVar) {
        WeakHashMap<a, ViewTreeObserver.OnGlobalLayoutListener> weakHashMap = alN;
        if (weakHashMap.get(aVar) != null) {
            return;
        }
        final View decorView = window.getDecorView();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.t.l.1
            private int Wz;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int iHeight = rect.height();
                int i = this.Wz;
                if (i == 0) {
                    this.Wz = iHeight;
                    return;
                }
                if (i == iHeight) {
                    return;
                }
                int height = decorView.getHeight() / 4;
                int i2 = this.Wz;
                if (i2 - iHeight > height) {
                    aVar.bz(i2 - iHeight);
                    this.Wz = iHeight;
                } else if (iHeight - i2 > height) {
                    aVar.vc();
                    this.Wz = iHeight;
                }
            }
        };
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        weakHashMap.put(aVar, onGlobalLayoutListener);
    }

    public static void b(Window window, a aVar) {
        window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(alN.remove(aVar));
    }
}
