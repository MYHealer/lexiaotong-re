package com.miui.zeus.mimo.sdk;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t6 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5615a;
    public int b;

    public t6(float f) {
        this.f5615a = f;
    }

    public t6(float f, int i) {
        this.f5615a = f;
        this.b = i;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int i = this.b;
        if (i == 1) {
            float width2 = view.getWidth();
            float height2 = view.getHeight();
            float fMin = Math.min(this.f5615a, Math.min(width2 / 2.0f, height2 / 2.0f));
            Path path = new Path();
            path.moveTo(0.0f, fMin);
            float f = 2.0f * fMin;
            path.arcTo(0.0f, 0.0f, f, f, 180.0f, 90.0f, false);
            path.lineTo(width2 - fMin, 0.0f);
            path.arcTo(width2 - f, 0.0f, width2, f, 270.0f, 90.0f, false);
            path.lineTo(width2, height2);
            path.lineTo(0.0f, height2);
            path.close();
            outline.setConvexPath(path);
            return;
        }
        if (i != 2) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), this.f5615a);
            return;
        }
        float width3 = view.getWidth();
        float height3 = view.getHeight();
        float fMin2 = Math.min(this.f5615a, Math.min(width3 / 2.0f, height3 / 2.0f));
        Path path2 = new Path();
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(width3, 0.0f);
        path2.lineTo(width3, height3 - fMin2);
        float f2 = fMin2 * 2.0f;
        float f3 = height3 - f2;
        path2.arcTo(width3 - f2, f3, width3, height3, 0.0f, 90.0f, false);
        path2.lineTo(fMin2, height3);
        path2.arcTo(0.0f, f3, f2, height3, 90.0f, 90.0f, false);
        path2.close();
        outline.setConvexPath(path2);
    }
}
