package com.miui.zeus.mimo.sdk.view.guide;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.q8;
import com.miui.zeus.mimo.sdk.r8;
import com.miui.zeus.mimo.sdk.s8;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GuideBuilder {
    public a c;
    public boolean d;
    public List<r8> b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s8 f5715a = new s8();

    public enum SlideState {
        UP,
        DOWN
    }

    public interface a {
        void a();

        void b();
    }

    public q8 a() {
        q8 q8Var = new q8();
        q8Var.c = (r8[]) this.b.toArray(new r8[this.b.size()]);
        q8Var.f5576a = this.f5715a;
        q8Var.d = this.c;
        this.b = null;
        this.f5715a = null;
        this.c = null;
        this.d = true;
        return q8Var;
    }

    public GuideBuilder a(int i) {
        if (this.d) {
            throw new GuideBuildException(s.d(new byte[]{112, 92, 17, 83, 7, 93, Ascii.CAN, 68, 5, 16, 84, 4, 69, 85, 7, Ascii.CAN, 70, 75, 4, 6, 19, 11, 93, 1, 17, 81, 67, 88, 3, 78, 65, 11, 8, 7, Ascii.US}, "10c6f9"));
        }
        if (i < 0 || i > 255) {
            i = 0;
        }
        this.f5715a.h = i;
        return this;
    }

    public GuideBuilder b(int i) {
        if (this.d) {
            throw new GuideBuildException(s.d(new byte[]{32, 94, 74, 6, 88, 93, Ascii.CAN, 68, 5, 16, 84, 4, Ascii.NAK, 87, 92, 77, Ascii.EM, 75, 4, 6, 19, 11, 93, 1, 65, 83, Ascii.CAN, 13, 92, 78, 65, 11, 8, 7, Ascii.US}, "a28c99"));
        }
        if (i < 0) {
            this.f5715a.b = 0;
        }
        this.f5715a.b = i;
        return this;
    }
}
