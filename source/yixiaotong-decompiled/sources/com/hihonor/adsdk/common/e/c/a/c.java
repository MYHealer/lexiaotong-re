package com.hihonor.adsdk.common.e.c.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.f.q;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final float A = 0.5f;
    private static final float B = 1.0E-6f;
    private static final int C = 1;
    private static final int D = 2;
    private static final int E = 3;
    private static final int F = 3;
    private static final int G = 4;
    private static final int H = 13;
    private static final int I = 14;
    private static final double J = 12.0d;
    private static final int[][] K = {new int[]{4, 6, 8}, new int[]{2, 3, 4}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{2, 2, 2}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{2, 2, 2}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{3, 4, 4}, new int[]{4, 5, 5}, new int[]{4, 8, 8}, new int[]{4, 4, 4}};
    private static final int[][] L = {new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{3, 4, 4}, new int[]{4, 5, 5}, new int[]{4, 8, 8}, new int[]{4, 4, 4}};
    private static final int[][] M = {new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{12, 12, 12}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{12, 12, 12}, new int[]{12, 12, 12}, new int[]{12, 12, 12}, new int[]{24, 24, 24}, new int[]{24, 24, 24}};
    private static final int[][] N = {new int[]{24, 24, 24}, new int[]{12, 12, 12}, new int[]{12, 12, 12}, new int[]{8, 8, 8}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{24, 24, 24}, new int[]{12, 12, 12}, new int[]{12, 12, 12}, new int[]{12, 12, 12}, new int[]{24, 24, 24}, new int[]{24, 24, 24}};
    private static final String O = "^c(\\d+)m(\\d+)g(\\d+)t(\\d+)";
    private static final String P = "^c(\\d+)m(\\d+)g(\\d+)";
    private static final int Q = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3515a = 7;
    public static final int b = 8;
    public static final int c = 9;
    public static final int d = 10;
    public static final int e = 11;
    public static final int f = 12;
    public static final int g = 15;
    public static final int h = 16;
    public static final int hnadss = -1;
    public static final int hnadst = 0;
    public static final int hnadsu = 1;
    public static final int hnadsv = 2;
    public static final int hnadsw = 3;
    public static final int hnadsx = 4;
    public static final int hnadsy = 5;
    public static final int hnadsz = 6;
    public static final int i = 560;
    public static final int j = 900;
    protected static final int k = -2;
    private static final String l = "com.hihonor.android.view.WindowManagerEx$LayoutParamsEx";
    private static final String m = "getDisplayDecoRegion";
    private static final String n = "getDecoSafeInset";
    private static final String o = "com.hihonor.android.view.DisplayDecoRegionEx";
    private static final String p = "c";
    private static final int q = 2;
    private static final int r = 3;
    private static final int s = 4;
    private static final int t = -1;
    private static final int u = 8;
    private static final int v = 12;
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 4;
    private static final int z = 3;
    private List<Integer[]> hnadsa;
    private int hnadsb;
    private int hnadsc;
    private int hnadsd;
    private float hnadse;
    private float hnadsf;
    private float hnadsg;
    private int hnadsh;
    private int hnadsi;
    private int hnadsj;
    private int hnadsk;
    private int hnadsl;
    private int hnadsm;
    private int hnadsn;
    private com.hihonor.adsdk.common.e.c.a.a hnadso;
    private Context hnadsp;
    private Object hnadsq;
    private Object hnadsr;

    class a implements Comparator<Integer[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public int compare(Integer[] numArr, Integer[] numArr2) {
            return Integer.compare(numArr[0].intValue(), numArr2[0].intValue());
        }
    }

    class b implements Comparator<Integer[]> {
        b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public int compare(Integer[] numArr, Integer[] numArr2) {
            return Integer.compare(numArr[0].intValue(), numArr2[0].intValue());
        }
    }

    public c(Context context) {
        this(context, -1);
    }

    private void a() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_dialog_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_dialog_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_dialog_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_dialog_max_count);
    }

    private void b() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_toolbar_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_toolbar_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_toolbar_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_toolbar_max_count);
    }

    private void c() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_toast_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_toast_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_toast_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_toast_max_count);
    }

    private void d() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_tooltips_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_tooltips_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_tooltips_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_tooltips_max_count);
    }

    private void g() {
        if (this.hnadsn == 12 && Double.compare(hnadsj(), J) >= 0) {
            if (this.hnadsn == 4) {
                this.hnadsb = 14;
                return;
            } else {
                this.hnadsb = 13;
                return;
            }
        }
        int i2 = this.hnadsn;
        if (i2 == 4) {
            if (this.hnadsc * 4 > this.hnadsd * 3) {
                this.hnadsb = 13;
                return;
            } else {
                this.hnadsb = 14;
                return;
            }
        }
        if (i2 != 8) {
            if (i2 != 12) {
                return;
            }
            this.hnadsb = 14;
        } else if (this.hnadsc * 3 > this.hnadsd * 4) {
            this.hnadsb = 13;
        } else {
            this.hnadsb = 14;
        }
    }

    private int hnadsa(int i2, float f2) {
        return (int) ((i2 * f2) + 0.5f);
    }

    public static int hnadsa(Context context, int i2) {
        return new c(context, i2).hnadsh();
    }

    private void hnadsb(int i2, int i3, int i4) {
        com.hihonor.adsdk.common.e.c.a.b bVar = new com.hihonor.adsdk.common.e.c.a.b();
        this.hnadso = bVar;
        bVar.hnadsa(this.hnadsc, this.hnadsd, this.hnadse);
        this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private double hnadsj() {
        float f2;
        DisplayMetrics displayMetrics = this.hnadsp.getResources().getDisplayMetrics();
        float f3 = displayMetrics.xdpi;
        float f4 = 0.0f;
        if (f3 != 0.0f) {
            float f5 = displayMetrics.ydpi;
            if (f5 != 0.0f) {
                f4 = this.hnadsc / f3;
                f2 = this.hnadsd / f5;
            } else {
                com.hihonor.adsdk.common.b.b.hnadse(p, "displayMetrics.xdpi or displayMetrics.ydpi get failed.", new Object[0]);
                f2 = 0.0f;
            }
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(p, "displayMetrics.xdpi or displayMetrics.ydpi get failed.", new Object[0]);
            f2 = 0.0f;
        }
        return Math.sqrt((f4 * f4) + (f2 * f2));
    }

    private void hnadsk() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_bubble_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_bubble_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_bubble_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_bubble_max_count);
    }

    private void hnadsl() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_card_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_card_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_card_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_card_max_count);
    }

    private void hnadsm() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_content_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_content_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_content_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_content_max_count);
    }

    private void hnadsn() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_content_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_content_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_content_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_content_max_count);
    }

    private void hnadso() {
        try {
            this.hnadsl = this.hnadsp.getResources().getDimensionPixelOffset(34472574);
            this.hnadsm = this.hnadsp.getResources().getDimensionPixelOffset(34472575);
        } catch (Exception unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "magic_dimens_max_start or magic_dimens_max_end is exception", new Object[0]);
            this.hnadsl = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_magic_dimens_max_start);
            this.hnadsm = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_magic_dimens_max_end);
        }
    }

    private void hnadsp() {
        DisplayMetrics displayMetrics = this.hnadsp.getResources().getDisplayMetrics();
        this.hnadsc = displayMetrics.widthPixels;
        this.hnadsd = displayMetrics.heightPixels;
        this.hnadse = displayMetrics.density;
        this.hnadsf = displayMetrics.xdpi;
        this.hnadsg = displayMetrics.ydpi;
        f();
        float f2 = this.hnadse;
        if (f2 != 0.0f) {
            hnadsa(this.hnadsc / f2, f2);
        }
        com.hihonor.adsdk.common.e.c.a.b bVar = new com.hihonor.adsdk.common.e.c.a.b();
        this.hnadso = bVar;
        bVar.hnadsa(this.hnadsc, this.hnadsd, this.hnadse);
        this.hnadso.hnadsa(this.hnadsb, this.hnadsl, this.hnadsm);
        this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
    }

    private void hnadsq() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_double_button_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_double_button_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_double_button_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_double_button_max_count);
    }

    private void hnadsr() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_bottomtab_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_bottomtab_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_bottomtab_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_bottomtab_max_count);
    }

    private void hnadss() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_dialog_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_dialog_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_dialog_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_dialog_max_count);
    }

    private void hnadst() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_toolbar_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_large_toolbar_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_toolbar_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_large_toolbar_max_count);
    }

    private void hnadsu() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_list_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_list_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_list_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_list_max_count);
        hnadso();
    }

    private void hnadsv() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_menu_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_menu_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_menu_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_menu_max_count);
    }

    private void hnadsy() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_button_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_button_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_button_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_button_max_count);
    }

    private void hnadsz() {
        this.hnadsh = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_bottomtab_margin);
        this.hnadsi = this.hnadsp.getResources().getDimensionPixelOffset(R.dimen.honor_ads_hwcolumnsystem_cs_small_bottomtab_gutter);
        this.hnadsj = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_bottomtab_count);
        this.hnadsk = this.hnadsp.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_small_bottomtab_max_count);
    }

    public int hnadsa() {
        return this.hnadsb;
    }

    public int hnadsc() {
        return this.hnadsi;
    }

    public int hnadsd() {
        return this.hnadsh;
    }

    public int hnadse() {
        return this.hnadso.hnadsb();
    }

    public int hnadsf() {
        return this.hnadso.hnadsc();
    }

    public float hnadsg() {
        return hnadsa(1);
    }

    public int hnadsh() {
        return this.hnadso.hnadsa();
    }

    public int hnadsi() {
        return this.hnadsn;
    }

    public c(Context context, int i2) {
        this.hnadsa = new ArrayList();
        this.hnadsn = 4;
        this.hnadsb = i2;
        this.hnadsp = context;
        hnadsp();
    }

    private void f() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 28) {
            Rect rectHnadsa = d.hnadsa();
            if (hnadsa(this.hnadsp) && (rectHnadsa.left > 0 || rectHnadsa.right > 0)) {
                if (i2 >= 31) {
                    com.hihonor.adsdk.common.b.b.hnadsc(p, "Build.VERSION.SDK_INT >= Build.VERSION_CODES.S!", new Object[0]);
                    this.hnadsc = hnadsa(this.hnadsp.getResources().getConfiguration().screenWidthDp, this.hnadse);
                } else {
                    this.hnadsc = (hnadsa(this.hnadsp.getResources().getConfiguration().screenWidthDp, this.hnadse) - rectHnadsa.left) - rectHnadsa.right;
                }
                com.hihonor.adsdk.common.b.b.hnadsc(p, "mWidthPixel: " + this.hnadsc, new Object[0]);
            }
        }
        if (hnadsa(this.hnadsp) && (hnadsb().right > 0 || hnadsb().left > 0)) {
            this.hnadsc -= hnadsb().right + hnadsb().left;
        }
        if (hnadsa(this.hnadsp)) {
            return;
        }
        if (hnadsb().bottom > 0 || hnadsb().top > 0) {
            this.hnadsd -= hnadsb().bottom + hnadsb().top;
        }
    }

    private boolean hnadsb(int i2) {
        return i2 >= 0 && i2 < M.length && i2 < N.length && i2 < K.length && i2 < L.length;
    }

    private void hnadsw() {
        Context context = this.hnadsp;
        if (context == null) {
            return;
        }
        this.hnadsn = context.getResources().getInteger(R.integer.honor_ads_hwcolumnsystem_cs_total_count);
        int i2 = this.hnadsb;
        if (i2 == 12 || i2 == 13 || i2 == 14) {
            g();
        }
        hnadsx();
        com.hihonor.adsdk.common.b.b.hnadsa(p, (Object) ("mWidth:" + this.hnadsc + "mDensity:" + this.hnadse + "mMargin:" + this.hnadsh + "mGutter:" + this.hnadsi + "mColumnCount:" + this.hnadsj + "mMaxColumnCount" + this.hnadsk + "mTotalColumn:" + this.hnadsn));
    }

    private void e() {
        WindowManager windowManager;
        Context context = this.hnadsp;
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 30 || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
                return;
            }
            this.hnadsc = windowManager.getCurrentWindowMetrics().getBounds().width();
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "setApplyWindowWidth error msg = " + e2.getMessage(), new Object[0]);
        }
    }

    private void hnadsa(boolean z2, String str, float f2, int i2, int i3) {
        this.hnadsc = i2;
        this.hnadsd = i3;
        this.hnadse = f2;
        if (!z2) {
            Matcher matcher = Pattern.compile(O).matcher(str);
            if (matcher.find() && matcher.groupCount() == 4) {
                try {
                    this.hnadsh = hnadsa(q.hnadsd(matcher.group(2), true), this.hnadse);
                    this.hnadsi = hnadsa(q.hnadsd(matcher.group(3), true), this.hnadse);
                    this.hnadsj = q.hnadsd(matcher.group(1), true);
                    this.hnadsn = q.hnadsd(matcher.group(4), true);
                    this.hnadsk = this.hnadsj;
                } catch (Exception e2) {
                    com.hihonor.adsdk.common.b.b.hnadsb(p, "NormalMatcher:false,Set column system input error: " + e2.getMessage(), new Object[0]);
                }
            }
        } else {
            Matcher matcher2 = Pattern.compile(P).matcher(str);
            if (matcher2.find() && matcher2.groupCount() == 3) {
                try {
                    this.hnadsh = hnadsa(q.hnadsd(matcher2.group(2), true), f2);
                    this.hnadsi = hnadsa(q.hnadsd(matcher2.group(3), true), f2);
                    this.hnadsj = q.hnadsd(matcher2.group(1), true);
                } catch (Exception e3) {
                    com.hihonor.adsdk.common.b.b.hnadsb(p, "NormalMatcher:true,Set column system input error: " + e3.getMessage(), new Object[0]);
                }
                if (this.hnadsc == this.hnadsp.getResources().getDisplayMetrics().widthPixels) {
                    f();
                }
            }
        }
        com.hihonor.adsdk.common.e.c.a.b bVar = new com.hihonor.adsdk.common.e.c.a.b();
        this.hnadso = bVar;
        bVar.hnadsa(this.hnadsc, this.hnadsd, this.hnadse);
        this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
    }

    public void hnadsc(int i2) {
        this.hnadsb = i2;
        if (this.hnadsp == null || this.hnadso == null) {
            return;
        }
        float f2 = this.hnadse;
        if (f2 != 0.0f) {
            hnadsa(this.hnadsc / f2, f2);
        }
        this.hnadso.hnadsa(this.hnadsb, this.hnadsl, this.hnadsm);
        this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
    }

    private boolean hnadsb(float f2, float f3) {
        return Math.abs(f2 - f3) < B;
    }

    public int hnadsb(Context context) {
        return hnadsa(context, false);
    }

    private Rect hnadsb() {
        WindowInsets windowInsets;
        if (Build.VERSION.SDK_INT < 30) {
            return new Rect();
        }
        try {
            windowInsets = ((WindowManager) this.hnadsp.getSystemService("window")).getCurrentWindowMetrics().getWindowInsets();
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "DecoSafeInset error msg = " + e2.getMessage(), new Object[0]);
            windowInsets = null;
        }
        if (windowInsets == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "DecoSafeInset can not instanceof windowInsets", new Object[0]);
            return new Rect();
        }
        Context context = this.hnadsp;
        Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(com.hihonor.adsdk.common.e.d.c.b.hnadsa(l, new Class[]{WindowManager.LayoutParams.class}, new Object[]{context instanceof Activity ? ((Activity) context).getWindow().getAttributes() : null}), m, new Class[]{WindowInsets.class}, new Object[]{windowInsets}, l);
        this.hnadsq = objHnadsa;
        if (objHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "DecoSafeInset can not instanceof Rect.", new Object[0]);
            return new Rect();
        }
        Object objHnadsa2 = com.hihonor.adsdk.common.e.d.c.b.hnadsa(objHnadsa, n, (Class[]) null, (Object[]) null, o);
        this.hnadsr = objHnadsa2;
        if (objHnadsa2 instanceof Rect) {
            return (Rect) objHnadsa2;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(p, "DecoSafeInset can not instanceof Rect.", new Object[0]);
        return new Rect();
    }

    private String hnadsa(int i2, float f2, String[] strArr) {
        String str;
        if (i2 >= hnadsa(900, f2)) {
            str = strArr.length > 2 ? strArr[2] : "";
            this.hnadsn = 12;
        } else if (i2 >= hnadsa(560, f2)) {
            str = strArr.length > 1 ? strArr[1] : "";
            this.hnadsn = 8;
        } else {
            str = strArr[0];
            this.hnadsn = 4;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(p, "mTotalColumn: " + this.hnadsn, new Object[0]);
        return str;
    }

    public c(Context context, String str) throws IllegalArgumentException {
        this.hnadsa = new ArrayList();
        this.hnadsb = -1;
        this.hnadsn = 4;
        this.hnadsp = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String[] strArrSplit = str.split(x.A);
        if (strArrSplit.length == 3) {
            hnadsa(Pattern.matches(P, strArrSplit[0]), hnadsa(displayMetrics.widthPixels, displayMetrics.density, strArrSplit), displayMetrics.density, displayMetrics.widthPixels, displayMetrics.heightPixels);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void hnadsx() {
        switch (this.hnadsb) {
            case -1:
            case 0:
                hnadsm();
                break;
            case 1:
                hnadsy();
                break;
            case 2:
                hnadsq();
                break;
            case 3:
                hnadsl();
                break;
            case 4:
                hnadsk();
                break;
            case 5:
                c();
                break;
            case 6:
                b();
                break;
            case 7:
                hnadst();
                break;
            case 8:
                hnadsz();
                break;
            case 9:
                hnadsr();
                break;
            case 10:
                hnadsv();
                break;
            case 11:
            case 12:
            default:
                hnadsn();
                break;
            case 13:
                a();
                break;
            case 14:
                hnadss();
                break;
            case 15:
                hnadsu();
                break;
        }
    }

    public float hnadsa(int i2) {
        if (i2 <= 0) {
            return 0.0f;
        }
        return this.hnadso.hnadsa(i2);
    }

    private boolean hnadsa(Context context) {
        int rotation;
        if (context == null) {
            return false;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            rotation = windowManager != null ? windowManager.getDefaultDisplay().getRotation() : 0;
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(p, "isPortrait error msg = " + e2.getMessage(), new Object[0]);
        }
        return rotation == 0 || rotation == 2;
    }

    private void hnadsa(int i2, int i3, float f2) {
        if (!hnadsb(i2)) {
            i2 = 0;
        }
        this.hnadsh = hnadsa(M[i2][i3], f2);
        this.hnadsi = hnadsa(N[i2][i3], f2);
        this.hnadsj = K[i2][i3];
        this.hnadsk = L[i2][i3];
        hnadso();
    }

    private void hnadsa(float f2, float f3) {
        int i2;
        if (f2 > 900.0f || hnadsb(f2, 900.0f)) {
            this.hnadsn = 12;
            i2 = 2;
        } else if (f2 > 560.0f || hnadsb(f2, 560.0f)) {
            this.hnadsn = 8;
            i2 = 1;
        } else {
            this.hnadsn = 4;
            i2 = 0;
        }
        int i3 = this.hnadsb;
        if (i3 == 12 || i3 == 13 || i3 == 14) {
            g();
        }
        hnadsa(this.hnadsb, i2, f3);
        com.hihonor.adsdk.common.b.b.hnadsa(p, (Object) ("mWidth:" + this.hnadsc + "mDensity:" + this.hnadse + "mMargin:" + this.hnadsh + "mGutter:" + this.hnadsi + "mColumnCount:" + this.hnadsj + "mMaxColumnCount" + this.hnadsk + "mTotalColumn:" + this.hnadsn));
    }

    @Deprecated
    public int hnadsa(int i2, int i3) {
        this.hnadsa.add(new Integer[]{Integer.valueOf(hnadsa(i2, this.hnadse)), Integer.valueOf(i3)});
        Collections.sort(this.hnadsa, new a());
        int iIntValue = this.hnadsj;
        for (Integer[] numArr : this.hnadsa) {
            if (this.hnadsc > numArr[0].intValue()) {
                iIntValue = numArr[1].intValue();
            }
        }
        this.hnadsj = iIntValue;
        com.hihonor.adsdk.common.e.c.a.a aVar = this.hnadso;
        if (aVar == null) {
            return -1;
        }
        aVar.hnadsb(iIntValue);
        this.hnadso.hnadsd();
        return (int) (hnadsa(iIntValue) + 0.5f);
    }

    public c(Context context, String str, int i2, int i3, float f2) throws IllegalArgumentException {
        this.hnadsa = new ArrayList();
        this.hnadsb = -1;
        this.hnadsn = 4;
        this.hnadsp = context;
        String[] strArrSplit = str.split(x.A);
        if (strArrSplit.length == 3) {
            hnadsa(Pattern.matches(P, strArrSplit[0]), hnadsa(i2, f2, strArrSplit), f2, i2, i3);
            return;
        }
        throw new IllegalArgumentException();
    }

    public int hnadsa(int i2, int i3, int i4) {
        this.hnadsa.add(new Integer[]{Integer.valueOf(hnadsa(i2, this.hnadse)), Integer.valueOf(i3), Integer.valueOf(i4)});
        Collections.sort(this.hnadsa, new b());
        int iIntValue = this.hnadsj;
        int iIntValue2 = this.hnadsn;
        for (Integer[] numArr : this.hnadsa) {
            if (this.hnadsc > numArr[0].intValue()) {
                iIntValue = numArr[1].intValue();
                iIntValue2 = numArr[2].intValue();
            }
        }
        this.hnadsj = iIntValue;
        this.hnadsn = iIntValue2;
        com.hihonor.adsdk.common.e.c.a.a aVar = this.hnadso;
        if (aVar == null) {
            return -1;
        }
        aVar.hnadsb(iIntValue);
        com.hihonor.adsdk.common.e.c.a.a aVar2 = this.hnadso;
        int i5 = this.hnadsh;
        int i6 = this.hnadsi;
        int i7 = this.hnadsj;
        aVar2.hnadsa(i5, i6, i7, i7, this.hnadsn);
        return (int) (hnadsa(iIntValue) + 0.5f);
    }

    public int hnadsa(Context context, boolean z2) {
        if (context == null) {
            return hnadsh();
        }
        this.hnadsp = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels != this.hnadsc || displayMetrics.density != this.hnadse) {
            hnadsp();
        }
        if (z2 && this.hnadso != null) {
            e();
            this.hnadso.hnadsa(this.hnadsc, this.hnadsd, this.hnadse);
            this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
        }
        return hnadsh();
    }

    public int hnadsa(Context context, int i2, int i3, float f2) {
        if (context != null && i2 > 0 && f2 >= 0.0f && !hnadsb(f2, 0.0f)) {
            this.hnadsp = context;
            this.hnadsc = i2;
            this.hnadsd = i3;
            this.hnadse = f2;
            hnadsa(i2 / f2, f2);
            if (this.hnadso == null) {
                this.hnadso = new com.hihonor.adsdk.common.e.c.a.b();
            }
            this.hnadso.hnadsa(i2, i3, f2);
            this.hnadso.hnadsa(this.hnadsh, this.hnadsi, this.hnadsj, this.hnadsk, this.hnadsn);
            this.hnadso.hnadsd();
            return hnadsh();
        }
        com.hihonor.adsdk.common.b.b.hnadse(p, "width and density should not below to zero!", new Object[0]);
        return hnadsh();
    }
}
