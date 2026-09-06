package com.huawei.hms.scankit.p;

import android.graphics.Point;

/* JADX INFO: compiled from: CameraConfig.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4221a;
    private int b;
    private String c;
    private Point d;
    private int e;
    private boolean f;
    private boolean g;

    /* JADX INFO: compiled from: CameraConfig.java */
    static /* synthetic */ class a {
    }

    /* synthetic */ c0(int i, int i2, int i3, String str, Point point, boolean z, a aVar) {
        this(i, i2, i3, str, point, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c0 a(boolean z) {
        this.g = z;
        return this;
    }

    public Point a() {
        return this.d;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(Point point) {
        this.d = point;
    }

    public int b() {
        return this.f4221a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    private c0(int i, int i2, int i3, String str, Point point, boolean z) {
        this.f4221a = i;
        this.b = i2;
        this.e = i3;
        this.c = str;
        this.d = point;
        this.f = z;
    }

    /* JADX INFO: compiled from: CameraConfig.java */
    public static class b {
        private Point e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4222a = 0;
        private int b = 1;
        private int c = 0;
        private String d = "off";
        private boolean f = true;
        private boolean g = false;

        public b a(int i) {
            this.b = i;
            return this;
        }

        public b a(Point point) {
            this.e = point;
            return this;
        }

        public b a(boolean z) {
            this.g = z;
            return this;
        }

        public b b(int i) {
            this.c = i;
            return this;
        }

        public b b(boolean z) {
            this.f = z;
            return this;
        }

        public c0 a() {
            return new c0(this.f4222a, this.b, this.c, this.d, this.e, this.f, null).a(this.g);
        }
    }
}
