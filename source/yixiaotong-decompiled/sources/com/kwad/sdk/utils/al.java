package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class al {
    public static String d(Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bv.C(context, z)));
    }

    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsb, fX(aVar.getWidth())).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsa, fX(aVar.getHeight())).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsc, fX(aVar.VE())).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsd, fX(aVar.VF())).replace(com.hihonor.adsdk.base.g.j.e.c.hnadse, fX(aVar.VG())).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsf, fX(aVar.VH()));
    }

    public static String av(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(n.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(n.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(n.dd(context))).replace("__DEVICE_HEIGHT__", String.valueOf(n.de(context)));
    }

    private static String fX(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }

    public static class a {
        private int bpw;
        private int bpx;
        private int bpy;
        private int bpz;
        private int mHeight;
        private int mWidth;

        public final void H(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final int VE() {
            return this.bpw;
        }

        public final int VF() {
            return this.bpx;
        }

        public final int VG() {
            return this.bpy;
        }

        public final int VH() {
            return this.bpz;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final void j(float f, float f2) {
            this.bpw = (int) f;
            this.bpx = (int) f2;
        }

        public final void k(float f, float f2) {
            this.bpy = (int) f;
            this.bpz = (int) f2;
        }

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.bpw = -1;
            this.bpx = -1;
            this.bpy = -1;
            this.bpz = -1;
        }

        public a(int i, int i2) {
            this.bpw = -1;
            this.bpx = -1;
            this.bpy = -1;
            this.bpz = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.bpw + ", mDownY=" + this.bpx + ", mUpX=" + this.bpy + ", mUpY=" + this.bpz + '}';
        }
    }
}
