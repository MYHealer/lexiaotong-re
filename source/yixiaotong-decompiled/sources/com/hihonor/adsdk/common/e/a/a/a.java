package com.hihonor.adsdk.common.e.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String A = "setOnlyClip";
    private static final String B = "setEmpty";
    private static final String C = "setAlpha";
    private static final String D = "setSVGTreeRoot";
    private static final String E = "maskColor";
    private static final String F = "blurMode";
    private static final String G = "edgeTreatment";
    private static final String H = "radiusX";
    private static final String I = "radiusY";
    private static final String J = "saturation";
    private static final String K = "scaleX";
    private static final String L = "scaleY";
    private static final String M = "skipFrameNum";
    private static final String O = "sf.hwui.viewBlurBackground";
    private static final String P = "getHnBlurVersion";
    private static final int Q = -1;
    private static final int R = -1;
    private static final int S = 16777215;
    private static final int T = -16777216;
    private static final int U = 7;
    private static final int V = 8;
    public static final int W = 4;
    private static final int X = 255;
    private static final int Y = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3514a = 201;
    public static final int b = 202;
    private static final int b0 = 2;
    public static final int c = 203;
    private static Class<?> c0 = null;
    public static final int d = 204;
    public static final int e = 205;
    private static final int e0 = -1728053248;
    public static final int f = 206;
    private static final int f0 = 1627389952;
    public static final int g = 207;
    public static final int h = 300;
    public static final int hnadsq = -1;
    public static final int hnadsr = 100;
    public static final int hnadss = 101;
    public static final int hnadst = 102;
    public static final int hnadsu = 103;
    public static final int hnadsv = 104;
    public static final int hnadsw = 105;
    public static final int hnadsx = 106;
    public static final int hnadsy = 107;
    public static final int hnadsz = 200;
    public static final int i = 301;
    public static final int j = 302;
    public static final int k = 303;
    public static final int l = 304;
    public static final int m = 305;
    public static final int n = 306;
    public static final int o = 307;
    public static final int p = 308;
    public static final int q = 309;
    private static final String r = "HnBlurSwitch";
    private static final String s = "com.hihonor.android.view.ViewEx";
    private static final String t = "com.hihonor.android.view.HnBlurParametersEx";
    private static final String u = "com.hihonor.android.graphics.BlurOutlineEx";
    private static final String v = "setHnBlurParameters";
    private static final String w = "setRect";
    private static final String x = "setRoundRect";
    private static final String y = "setPath";
    private static final String z = "setBlurOutline";
    private Object hnadsa;
    private Object hnadsb;
    private Class<?> hnadsc;
    private Class<?> hnadsd;
    private Context hnadse;
    private View hnadsf;
    private int hnadsg;
    private boolean hnadsi;
    private boolean hnadsj;
    private int hnadsl;
    private int hnadso;
    private int hnadsp;
    private static final String Z = "get";
    private static final String N = "com.hihonor.android.os.SystemPropertiesEx";
    private static final boolean a0 = "1".equals(com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, Z, new Class[]{String.class, String.class}, new Object[]{"hn.uikit.debugblur", "0"}, N));
    private static int d0 = -1;
    private static final Object g0 = c.hnadsa;
    private static boolean h0 = false;
    private boolean hnadsh = true;
    private boolean hnadsk = true;
    private HashMap<View, Drawable> hnadsm = new HashMap<>();
    private HashMap<View, Drawable> hnadsn = new HashMap<>();

    public a(Context context, View view, int i2) {
        this.hnadsg = 100;
        boolean z2 = true;
        this.hnadsj = true;
        this.hnadso = -1;
        this.hnadsp = -1;
        if (context == null || view == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "HnBlurSwitch: context or blurView is null", new Object[0]);
            return;
        }
        this.hnadse = context;
        this.hnadsf = view;
        this.hnadsg = i2;
        this.hnadsi = view.getClipToOutline();
        if (d0 <= 0 && !hnadsa(context)) {
            z2 = false;
        }
        this.hnadsj = z2;
        try {
            this.hnadso = this.hnadse.getResources().getIdentifier("color_enhance_view", "id", "androidhnext");
            this.hnadsp = this.hnadse.getResources().getIdentifier("hn_color_enhance_tertiary", "id", "androidhnext");
        } catch (Resources.NotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "Unable to obtain contrast enhance ability flag", new Object[0]);
            this.hnadso = -1;
            this.hnadsp = -1;
        }
        hnadsd();
    }

    public static void hnadsa(boolean z2) {
        h0 = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void hnadsa(boolean z2, View view) {
        if (view instanceof b) {
            ((b) view).hnadsa(z2);
            return;
        }
        int i2 = 0;
        if (Boolean.TRUE.equals(view.getTag(this.hnadso))) {
            Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(view, "isDoChildColorEnhance", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z2)}, view.getClass());
            if ((objHnadsa instanceof Boolean) && ((Boolean) objHnadsa).booleanValue()) {
                return;
            }
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            hnadsa(z2, viewGroup.getChildAt(i2));
            i2++;
        }
    }

    public int hnadsa() {
        if (this.hnadsj) {
            return this.hnadsg;
        }
        return -1;
    }

    public void hnadsd(boolean z2) {
        this.hnadsk = z2;
    }

    public void hnadse(boolean z2) {
        this.hnadsh = z2;
    }

    public void hnadsb(boolean z2) {
        if (!this.hnadsj || this.hnadsb == null) {
            return;
        }
        Class cls = Boolean.TYPE;
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(A, new Class[]{cls}, u)) {
            this.hnadsj = false;
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, A, new Class[]{cls}, new Object[]{Boolean.valueOf(z2)}, u);
            hnadsg();
        }
    }

    public void hnadsc(float f2) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null || f2 < 0.0f) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(J, obj, Float.valueOf(f2), this.hnadsc);
    }

    private void hnadsd() {
        if (this.hnadsj) {
            try {
                Class<?> cls = Class.forName(t);
                this.hnadsc = cls;
                int i2 = this.hnadsg;
                if (i2 == -1) {
                    this.hnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(cls, (Class[]) null, (Object[]) null);
                } else {
                    this.hnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(cls, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)});
                }
                try {
                    Class<?> cls2 = Class.forName(u);
                    this.hnadsd = cls2;
                    this.hnadsb = com.hihonor.adsdk.common.e.d.c.b.hnadsa(cls2, (Class[]) null, (Object[]) null);
                } catch (ClassNotFoundException unused) {
                    com.hihonor.adsdk.common.b.b.hnadsb(r, "BlurOutlineEx : ClassNotFoundException in reflect call", new Object[0]);
                }
            } catch (ClassNotFoundException unused2) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "HnBlurParametersEx : ClassNotFoundException in reflect call", new Object[0]);
            }
        }
    }

    public void hnadse() {
        if (this.hnadsb == null) {
            return;
        }
        if (com.hihonor.adsdk.common.e.d.c.b.hnadsa(B, (Class[]) null, u)) {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, B, (Class[]) null, (Object[]) null, u);
        } else {
            this.hnadsj = false;
        }
    }

    public void hnadsc(int i2) {
        Class<?> cls;
        Object[] enumConstants;
        if (c0 == null) {
            hnadsc();
        }
        if (!this.hnadsj || this.hnadsa == null || (cls = c0) == null || i2 < 0 || (enumConstants = cls.getEnumConstants()) == null || i2 >= enumConstants.length) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(F, this.hnadsa, enumConstants[i2], this.hnadsc);
    }

    private void hnadsg() {
        if (this.hnadsf == null || this.hnadsb == null || !this.hnadsj) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "set HnBlur outLine fail because of: mBlurView is null = " + (this.hnadsf == null) + "mBlurOutline is null = " + (this.hnadsb == null) + "device blur ability = " + this.hnadsj, new Object[0]);
            return;
        }
        try {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, z, new Class[]{View.class, Class.forName(u)}, new Object[]{this.hnadsf, this.hnadsb}, s);
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "Can't find method : setHnBlurOutLine", new Object[0]);
        }
    }

    public a hnadsf(boolean z2) {
        View view = this.hnadsf;
        if (view != null && this.hnadsc != null && this.hnadsj) {
            if (z2) {
                if (this.hnadsh) {
                    view.setClipToOutline(true);
                }
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setViewBlurEnableBlurView = " + this.hnadsf + "isBlurEnable = " + z2, new Object[0]);
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{this.hnadsf, this.hnadsa}, s);
            } else {
                view.setClipToOutline(this.hnadsi);
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{this.hnadsf, g0}, s);
            }
            if (this.hnadsk) {
                hnadsa(z2, this.hnadsf);
            }
        }
        return this;
    }

    public void hnadse(float f2) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null || f2 < 0.0f) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa("scaleY", obj, Float.valueOf(f2), this.hnadsc);
    }

    public static boolean hnadsc() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.view.HnBlurParametersEx$BlurMode");
            c0 = cls;
            Object[] enumConstants = cls.getEnumConstants();
            return enumConstants != null && 8 < enumConstants.length;
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "BlurModeEnum : ClassNotFoundException in reflect call", new Object[0]);
            return false;
        }
    }

    public void hnadsb(float f2) {
        if (this.hnadsb == null) {
            return;
        }
        Class cls = Float.TYPE;
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(C, new Class[]{cls}, u)) {
            this.hnadsj = false;
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, C, new Class[]{cls}, new Object[]{Float.valueOf(f2)}, u);
            hnadsg();
        }
    }

    public void hnadse(int i2) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null || i2 < 0) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(M, obj, Integer.valueOf(i2), this.hnadsc);
    }

    public void hnadsg(int i2) {
        if (!this.hnadsj || this.hnadsa == null || !hnadsa(i2) || hnadsb() == -1) {
            return;
        }
        int iHnadsb = hnadsb();
        this.hnadsl = iHnadsb;
        int i3 = (i2 & 16777215) | (iHnadsb & (-16777216));
        com.hihonor.adsdk.common.b.b.hnadsa(r, (Object) ("setCustomizeBlurMaskColor : TargetColor = " + hnadsb(i3)));
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(E, this.hnadsa, Integer.valueOf(i3), this.hnadsc);
    }

    public static boolean hnadsa(Context context) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure: Context is null in get device's blurability", new Object[0]);
            return false;
        }
        if (hnadsa(context.getResources(), context.getPackageName())) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "isDeviceBlurAbilityOn: Current theme not supported", new Object[0]);
            return false;
        }
        return hnadsa(context.getResources());
    }

    public static boolean hnadsa(Resources resources) {
        Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, P, (Class[]) null, (Object[]) null, t);
        if ((objHnadsa instanceof Integer) && ((Integer) objHnadsa).intValue() == 2) {
            if (!a0) {
                Object objHnadsa2 = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "getBoolean", new Class[]{String.class, Boolean.TYPE}, new Object[]{O, Boolean.FALSE}, N);
                if (objHnadsa2 == null || !((Boolean) objHnadsa2).booleanValue()) {
                    com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure：The device is not configured with blur parameters", new Object[0]);
                    d0 = 0;
                    return false;
                }
                if (resources == null) {
                    com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure：Resource is null in getting device's blurability", new Object[0]);
                    d0 = 0;
                    return false;
                }
            }
            try {
                Class.forName(t);
                if (resources != null) {
                    try {
                        d0 = resources.getInteger(resources.getIdentifier("hn_uikit_blur_type", TypedValues.Custom.S_INT, "androidhnext"));
                    } catch (Resources.NotFoundException unused) {
                        com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure: Device's blurswitch is off.", new Object[0]);
                        d0 = 0;
                    }
                }
                return d0 > 0;
            } catch (ClassNotFoundException unused2) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure：Device has no blur ability.", new Object[0]);
                d0 = 0;
                return false;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsb(r, "Failure：The blur version is not supported", new Object[0]);
        d0 = 0;
        return false;
    }

    public void hnadsc(boolean z2) {
        Class<?> cls;
        if (this.hnadsa == null || (cls = c0) == null) {
            return;
        }
        int i2 = z2 ? 7 : 8;
        Object[] enumConstants = cls.getEnumConstants();
        if (enumConstants == null || i2 >= enumConstants.length) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(F, this.hnadsa, enumConstants[i2], this.hnadsc);
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(G, this.hnadsa, Shader.TileMode.CLAMP, this.hnadsc);
    }

    public void hnadsd(int i2) {
        if (!this.hnadsj || this.hnadsa == null || i2 < 0 || i2 > 255) {
            return;
        }
        int iHnadsb = hnadsb();
        this.hnadsl = iHnadsb;
        if (iHnadsb != -1) {
            int i3 = (i2 << 24) | (iHnadsb & 16777215);
            com.hihonor.adsdk.common.b.b.hnadsa(r, (Object) ("setBlurMaskColorAlpha : NewColor = " + hnadsb(i3)));
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(E, this.hnadsa, Integer.valueOf(i3), this.hnadsc);
        }
    }

    public int hnadsb() {
        Object obj;
        if (this.hnadsj && (obj = this.hnadsa) != null) {
            Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(obj, E, this.hnadsc);
            if (objHnadsa instanceof Integer) {
                return ((Integer) objHnadsa).intValue();
            }
        }
        return -1;
    }

    public void hnadsf() {
        Class<?> cls;
        if (this.hnadsj) {
            Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsc, (Class[]) null, (Object[]) null);
            this.hnadsa = objHnadsa;
            Class<?>[] declaredClasses = this.hnadsc.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i2];
                if (cls.isEnum() && cls.getSimpleName().equals("BlurMode")) {
                    com.hihonor.adsdk.common.b.b.hnadsc(r, "setChildBlur: innerEnumClass " + cls, new Object[0]);
                    break;
                }
                i2++;
            }
            if (cls == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setChildBlur: innerEnumClass is null", new Object[0]);
                return;
            }
            try {
                Field declaredField = this.hnadsc.getDeclaredField(F);
                declaredField.setAccessible(true);
                declaredField.set(this.hnadsa, Enum.valueOf(cls, "BitmapBackgroundBlur"));
            } catch (IllegalAccessException unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setChildBlur: IllegalAccessException", new Object[0]);
            } catch (NoSuchFieldException unused2) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setChildBlur: NoSuchFieldException", new Object[0]);
            }
            com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{this.hnadsf, objHnadsa}, s);
        }
    }

    private String hnadsb(int i2) {
        return String.format("#%08X", Integer.valueOf(i2));
    }

    public void hnadsd(float f2) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null || f2 < 0.0f) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa("scaleX", obj, Float.valueOf(f2), this.hnadsc);
    }

    public void hnadsf(int i2) {
        if (this.hnadsj && this.hnadsa != null) {
            try {
                Field declaredField = this.hnadsc.getDeclaredField(E);
                declaredField.setAccessible(true);
                declaredField.set(this.hnadsa, Integer.valueOf(i2));
            } catch (IllegalAccessException unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setChildBlurAlpha: IllegalAccessException", new Object[0]);
            } catch (NoSuchFieldException unused2) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setChildBlurAlpha: NoSuchFieldException", new Object[0]);
            }
            com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{this.hnadsf, this.hnadsa}, s);
        }
    }

    public void hnadsa(Rect rect) {
        if (!this.hnadsj || this.hnadsb == null) {
            return;
        }
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(w, new Class[]{Rect.class}, u)) {
            this.hnadsj = false;
            return;
        }
        if (rect != null) {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, w, new Class[]{Rect.class}, new Object[]{rect}, u);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "Rect should not be empty", new Object[0]);
        }
        hnadsg();
    }

    public void hnadsa(int i2, int i3, int i4, int i5) {
        hnadsa(i2, i3, i4, i5, 0.0f);
    }

    public void hnadsa(int i2, int i3, int i4, int i5, float f2) {
        if (!this.hnadsj || this.hnadsb == null) {
            return;
        }
        Class cls = Integer.TYPE;
        Class cls2 = Float.TYPE;
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(x, new Class[]{cls, cls, cls, cls, cls2}, u)) {
            this.hnadsj = false;
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, x, new Class[]{cls, cls, cls, cls, cls2}, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2)}, u);
            hnadsg();
        }
    }

    public void hnadsa(Path path) {
        if (!this.hnadsj || this.hnadsb == null) {
            return;
        }
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(y, new Class[]{Path.class}, u)) {
            this.hnadsj = false;
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, y, new Class[]{Path.class}, new Object[]{path}, u);
            hnadsg();
        }
    }

    private boolean hnadsa(int i2) {
        int iAlpha = Color.alpha(i2);
        int iRed = Color.red(i2);
        int iGreen = Color.green(i2);
        int iBlue = Color.blue(i2);
        return iAlpha >= 0 && iAlpha <= 255 && iRed >= 0 && iRed <= 255 && iGreen >= 0 && iGreen <= 255 && iBlue >= 0 && iBlue <= 255;
    }

    public void hnadsa(float f2) {
        hnadsd((int) (f2 * 255.0f));
    }

    public void hnadsa(float f2, float f3) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null) {
            return;
        }
        if (f2 < 0.0f) {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(H, obj, Float.valueOf(0.0f), this.hnadsc);
            com.hihonor.adsdk.common.b.b.hnadsb(r, "setBlurRadius: RadiusX < 0,force blurring off", new Object[0]);
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(H, obj, Float.valueOf(f2), this.hnadsc);
        }
        if (f3 < 0.0f) {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(I, this.hnadsa, Float.valueOf(0.0f), this.hnadsc);
            com.hihonor.adsdk.common.b.b.hnadsb(r, "setBlurRadius: RadiusY < 0,force blurring off", new Object[0]);
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(I, this.hnadsa, Float.valueOf(f3), this.hnadsc);
        }
    }

    public void hnadsa(Shader.TileMode tileMode) {
        Object obj;
        if (!this.hnadsj || (obj = this.hnadsa) == null) {
            return;
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa(G, obj, tileMode, this.hnadsc);
    }

    public void hnadsa(long j2) {
        if (this.hnadsb == null) {
            return;
        }
        if (!com.hihonor.adsdk.common.e.d.c.b.hnadsa(D, new Class[]{Long.class}, u)) {
            this.hnadsj = false;
        } else {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa(this.hnadsb, D, new Class[]{Long.class}, new Object[]{Long.valueOf(j2)}, u);
            hnadsg();
        }
    }

    public void hnadsa(Bitmap bitmap) {
        if (this.hnadsj) {
            View view = this.hnadsf;
            if (view == null || bitmap == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(r, "setRootViewBitmapBlur: rootView or mBlurView is null", new Object[0]);
            } else {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "setBluredBackground", new Class[]{View.class, Bitmap.class}, new Object[]{view, bitmap}, s);
            }
        }
    }

    public static boolean hnadsa(Resources resources, String str) {
        if (h0) {
            return false;
        }
        if (resources != null && str != null) {
            Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "isPackageInThemes", new Class[]{Resources.class, String.class}, new Object[]{resources, str}, "com.hihonor.android.content.res.ResourcesEx");
            if (objHnadsa instanceof Boolean) {
                return ((Boolean) objHnadsa).booleanValue();
            }
            com.hihonor.adsdk.common.b.b.hnadsb(r, "isPackageInTheme: Can't get theme", new Object[0]);
            return false;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(r, "isPackageInTheme : Package name is null", new Object[0]);
        return false;
    }

    public a hnadsa(View view, boolean z2) {
        if (!this.hnadsj) {
            return this;
        }
        boolean z3 = view instanceof TextView;
        if (!z3 && !(view instanceof ImageView)) {
            com.hihonor.adsdk.common.b.b.hnadsb(r, "HnBlurSwitch: enhancedView is illegal", new Object[0]);
            return this;
        }
        if (z3) {
            hnadsa((TextView) view, z2);
        }
        if (view instanceof ImageView) {
            hnadsa((ImageView) view, z2);
        }
        return this;
    }

    private void hnadsa(TextView textView, boolean z2) {
        int i2 = this.hnadse.getResources().getConfiguration().uiMode;
        this.hnadse.getResources().getConfiguration();
        boolean z3 = (i2 & 48) == 32;
        if (z2) {
            Drawable background = textView.getBackground();
            if (background != null) {
                this.hnadsm.put(textView, background);
            }
            textView.setBackground(null);
        } else if (this.hnadsm.get(textView) != null) {
            textView.setBackground(this.hnadsm.get(textView));
        }
        if (!z2) {
            com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{textView, g0}, s);
            return;
        }
        if (textView.getCurrentTextColor() == e0) {
            if (z3) {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{textView, c.hnadsc()}, s);
                return;
            } else {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{textView, c.hnadsd()}, s);
                return;
            }
        }
        if (textView.getCurrentTextColor() == f0 || textView.getCurrentHintTextColor() == f0) {
            if (z3) {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{textView, c.hnadse()}, s);
            } else {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{textView, c.hnadsf()}, s);
            }
        }
    }

    private void hnadsa(ImageView imageView, boolean z2) {
        if (z2) {
            Drawable background = imageView.getBackground();
            if (background != null) {
                this.hnadsn.put(imageView, background);
            }
            imageView.setBackground(null);
            if (!Boolean.TRUE.equals(imageView.getTag(this.hnadsp))) {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{imageView, c.hnadsa()}, s);
                return;
            } else {
                com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{imageView, c.hnadsb()}, s);
                return;
            }
        }
        com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, v, new Class[]{View.class, this.hnadsc}, new Object[]{imageView, g0}, s);
        if (this.hnadsn.get(imageView) != null) {
            imageView.setBackground(this.hnadsn.get(imageView));
        }
    }
}
