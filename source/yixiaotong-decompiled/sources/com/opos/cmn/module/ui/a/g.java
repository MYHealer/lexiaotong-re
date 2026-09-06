package com.opos.cmn.module.ui.a;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {
    public static Path a(Path path, RectF rectF, float f) {
        return a(path, rectF, f, true, true, true, true);
    }

    public static Path a(Path path, RectF rectF, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        float f2;
        float f3 = f < 0.0f ? 0.0f : f;
        path.reset();
        float f4 = rectF.left;
        float f5 = rectF.right;
        float f6 = rectF.bottom;
        float f7 = rectF.top;
        float f8 = f5 - f4;
        float f9 = f6 - f7;
        float f10 = f8 / 2.0f;
        float f11 = f9 / 2.0f;
        float fMin = ((double) (f3 / Math.min(f10, f11))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f3 / Math.min(f10, f11)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = f3 / Math.min(f10, f11) > 0.6f ? 1.0f + (Math.min(1.0f, ((f3 / Math.min(f10, f11)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f4 + f10, f7);
        if (z2) {
            float f12 = f3 / 100.0f;
            float f13 = f12 * 128.19f * fMin;
            path.lineTo(Math.max(f10, f8 - f13) + f4, f7);
            float f14 = f4 + f8;
            float f15 = f12 * 83.62f * fMin2;
            float f16 = f12 * 67.45f;
            float f17 = f12 * 4.64f;
            float f18 = f12 * 51.16f;
            float f19 = f12 * 13.36f;
            path.cubicTo(f14 - f15, f7, f14 - f16, f7 + f17, f14 - f18, f7 + f19);
            float f20 = f12 * 34.86f;
            float f21 = f12 * 22.07f;
            path.cubicTo(f14 - f20, f7 + f21, f14 - f21, f7 + f20, f14 - f19, f7 + f18);
            path.cubicTo(f14 - f17, f7 + f16, f14, f7 + f15, f14, f7 + Math.min(f11, f13));
        } else {
            path.lineTo(f4 + f8, f7);
        }
        if (z4) {
            float f22 = f4 + f8;
            float f23 = f3 / 100.0f;
            float f24 = f23 * 128.19f * fMin;
            path.lineTo(f22, Math.max(f11, f9 - f24) + f7);
            float f25 = f7 + f9;
            float f26 = f23 * 83.62f * fMin2;
            float f27 = f23 * 4.64f;
            float f28 = f23 * 67.45f;
            float f29 = f23 * 13.36f;
            float f30 = f23 * 51.16f;
            path.cubicTo(f22, f25 - f26, f22 - f27, f25 - f28, f22 - f29, f25 - f30);
            float f31 = f23 * 22.07f;
            float f32 = f23 * 34.86f;
            path.cubicTo(f22 - f31, f25 - f32, f22 - f32, f25 - f31, f22 - f30, f25 - f29);
            path.cubicTo(f22 - f28, f25 - f27, f22 - f26, f25, f4 + Math.max(f2, f8 - f24), f25);
        } else {
            path.lineTo(f8 + f4, f7 + f9);
        }
        if (z3) {
            f2 = f10;
            float f33 = f3 / 100.0f;
            float f34 = f33 * 128.19f * fMin;
            float f35 = f7 + f9;
            path.lineTo(Math.min(f2, f34) + f4, f35);
            float f36 = f33 * 83.62f * fMin2;
            float f37 = f33 * 67.45f;
            float f38 = f33 * 4.64f;
            float f39 = f33 * 51.16f;
            float f40 = f33 * 13.36f;
            path.cubicTo(f4 + f36, f35, f4 + f37, f35 - f38, f4 + f39, f35 - f40);
            float f41 = f33 * 34.86f;
            float f42 = f33 * 22.07f;
            path.cubicTo(f4 + f41, f35 - f42, f4 + f42, f35 - f41, f4 + f40, f35 - f39);
            path.cubicTo(f4 + f38, f35 - f37, f4, f35 - f36, f4, f7 + Math.max(f11, f9 - f34));
        } else {
            f2 = f10;
            path.lineTo(f4, f9 + f7);
        }
        if (z) {
            f2 = f10;
            f2 = f10;
            float f43 = f3 / 100.0f;
            float f44 = 128.19f * f43 * fMin;
            path.lineTo(f4, Math.min(f11, f44) + f7);
            float f45 = 83.62f * f43 * fMin2;
            float f46 = 4.64f * f43;
            float f47 = 67.45f * f43;
            float f48 = 13.36f * f43;
            float f49 = 51.16f * f43;
            path.cubicTo(f4, f7 + f45, f4 + f46, f7 + f47, f4 + f48, f7 + f49);
            float f50 = 22.07f * f43;
            float f51 = f43 * 34.86f;
            path.cubicTo(f4 + f50, f7 + f51, f4 + f51, f7 + f50, f4 + f49, f7 + f48);
            path.cubicTo(f4 + f47, f7 + f46, f4 + f45, f7, f4 + Math.min(f2, f44), f7);
        } else {
            f2 = f10;
            f2 = f10;
            path.lineTo(f4, f7);
        }
        path.close();
        return path;
    }
}
