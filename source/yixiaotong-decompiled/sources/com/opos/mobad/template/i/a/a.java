package com.opos.mobad.template.i.a;

import android.text.TextUtils;
import com.opos.mobad.template.d.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: com.opos.mobad.template.i.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8160a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f8160a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.TILT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8160a[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8160a[com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8160a[com.opos.mobad.template.e.a.FORWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(int i) {
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getBigButtonBottomMarginInDp()==>splashType=" + i);
        switch (i) {
            case 0:
            case 1:
            case 5:
            case 9:
            case 10:
            case 11:
                return 42;
            case 2:
                return 79;
            case 3:
                return 28;
            case 4:
                return 30;
            case 6:
            case 7:
            case 8:
            default:
                return 81;
            case 12:
                return 24;
        }
    }

    public static int a(boolean z, int i) {
        if (!z) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return 37;
                }
                if (i == 11 || i == 12) {
                    return 28;
                }
                return 81;
            }
            return 87;
        }
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return 28;
                    }
                    if (i != 5) {
                        switch (i) {
                            case 9:
                            case 10:
                                break;
                            case 11:
                                break;
                            case 12:
                                return 28;
                            default:
                                return 81;
                        }
                    }
                }
                return 18;
            }
            return 87;
        }
        return 46;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0028  */
    public static String a(b bVar, boolean z) {
        String str;
        com.opos.mobad.template.e.a aVar = com.opos.mobad.template.e.a.UNKNOWN;
        String string = "点击";
        if (bVar != null) {
            aVar = bVar.L;
            if (z) {
                int i = AnonymousClass1.f8160a[aVar.ordinal()];
                if (i == 1) {
                    str = "倾斜或";
                } else if (i == 2 || i == 3) {
                    str = "摇动或";
                } else if (i != 4) {
                    str = "";
                } else {
                    str = "前倾或";
                }
            } else {
                str = "";
            }
            string = ((TextUtils.isEmpty(bVar.j) || !bVar.j.contains("点击")) ? new StringBuilder().append(str).append("点击") : new StringBuilder().append(str)).append(bVar.j).toString();
        }
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getClickBtnText()==>", "btnText=", string, ", isSupport=", Boolean.valueOf(z), ", mode=", aVar);
        return string;
    }

    public static int b(int i) {
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getClickViewBottomMarginInDp()==>splashType=" + i);
        switch (i) {
            case 0:
            case 1:
            case 5:
            case 9:
            case 10:
                return 78;
            case 2:
                return 79;
            case 3:
                return 28;
            case 4:
            case 11:
            case 12:
                return 24;
            case 6:
            case 7:
            case 8:
            default:
                return 81;
        }
    }

    public static boolean c(int i) {
        return i == 71 || i == 2073 || i == 2024 || i == 59 || i == 68 || i == 2053 || i == 2061;
    }

    public static boolean d(int i) {
        return i == 2073 || i == 59 || i == 68 || i == 2061;
    }

    public static boolean e(int i) {
        return i == 59 || i == 68 || i == 71 || i == 2024 || i == 2041 || i == 2053 || i == 2058 || i == 2061 || i == 2073;
    }

    public static boolean f(int i) {
        return i == 59 || i == 60;
    }
}
