package com.huawei.hms.ads.uiengineloader;

import com.huawei.hms.ml.camera.CountryCodeBean;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3886a = "EmuiUtil";
    private static final String b = "EMUI_SDK_INT";
    private static final String c = "com.huawei.android.os.BuildEx$VERSION";
    private static final int d = -1;
    private static final int e = 7;
    private static final int f = 8;
    private static final int g = 9;
    private static final int h = 10;
    private static final int i = 11;
    private static final int j = 14;
    private static final int k = 15;
    private static final int l = 17;
    private static final int m = 30;
    private static final int n = 31;
    private static final int o = 40;
    private static final int p = 41;
    private static final int q = 50;
    private static final int r = 60;
    private static final int s = 81;
    private static final int t = 90;
    private static int u = -1;
    private static int v = d();

    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:36:0x009c A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a4 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00af A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c5 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c8 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d3 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:61:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    static {
        int i2;
        String str;
        af.b(f3886a, "getEmuiType emuiVersionCode=" + v);
        int i3 = v;
        if (i3 < 17) {
            if (i3 >= 15) {
                i2 = 81;
            } else if (i3 >= 14) {
                u = 60;
            } else if (i3 >= 11) {
                u = 50;
            } else if (i3 >= 10) {
                u = 41;
            } else if (i3 >= 9) {
                u = 40;
            } else if (i3 >= 8) {
                u = 31;
            } else if (i3 >= 7) {
                u = 30;
            } else {
                u = -1;
            }
            if (u == -1) {
                try {
                    Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
                    af.a(f3886a, "isNeed2UseHwEmui :");
                    if (str != null) {
                        if (str.contains("EmotionUI_3.0")) {
                            u = 30;
                            return;
                        }
                        if (str.contains("EmotionUI_3.1")) {
                            u = 31;
                            return;
                        }
                        if (str.contains("EmotionUI_4.0")) {
                            u = 40;
                            return;
                        }
                        if (str.contains("EmotionUI_4.1")) {
                            u = 41;
                            return;
                        }
                        if (str.contains("EmotionUI_5.0")) {
                            u = 50;
                        } else if (str.contains("EmotionUI_6.0")) {
                            u = 60;
                        } else {
                            u = -1;
                        }
                    }
                } catch (Throwable th) {
                    af.d(f3886a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
                    return;
                }
            }
        }
        i2 = 90;
        u = i2;
        if (u == -1) {
            Class<?> cls2 = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str = (String) cls2.getDeclaredMethod("get", String.class).invoke(cls2, "ro.build.version.emui");
            af.a(f3886a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        }
    }

    public static boolean a() {
        return u == 50;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:36:0x009c A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a4 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00af A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c5 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c8 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d3 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:30:0x006a, B:32:0x0091, B:34:0x0099, B:36:0x009c, B:38:0x00a4, B:40:0x00a7, B:42:0x00af, B:44:0x00b2, B:46:0x00ba, B:48:0x00bd, B:50:0x00c5, B:52:0x00c8, B:54:0x00d0, B:56:0x00d3), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:61:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    private static void b() {
        int i2;
        String str;
        v = d();
        af.b(f3886a, "getEmuiType emuiVersionCode=" + v);
        int i3 = v;
        if (i3 < 17) {
            if (i3 >= 15) {
                i2 = 81;
            } else if (i3 >= 14) {
                u = 60;
            } else if (i3 >= 11) {
                u = 50;
            } else if (i3 >= 10) {
                u = 41;
            } else if (i3 >= 9) {
                u = 40;
            } else if (i3 >= 8) {
                u = 31;
            } else if (i3 >= 7) {
                u = 30;
            } else {
                u = -1;
            }
            if (u == -1) {
                try {
                    Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
                    af.a(f3886a, "isNeed2UseHwEmui :");
                    if (str != null) {
                        if (str.contains("EmotionUI_3.0")) {
                            u = 30;
                            return;
                        }
                        if (str.contains("EmotionUI_3.1")) {
                            u = 31;
                            return;
                        }
                        if (str.contains("EmotionUI_4.0")) {
                            u = 40;
                            return;
                        }
                        if (str.contains("EmotionUI_4.1")) {
                            u = 41;
                            return;
                        }
                        if (str.contains("EmotionUI_5.0")) {
                            u = 50;
                        } else if (str.contains("EmotionUI_6.0")) {
                            u = 60;
                        } else {
                            u = -1;
                        }
                    }
                } catch (Throwable th) {
                    af.d(f3886a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
                    return;
                }
            }
        }
        i2 = 90;
        u = i2;
        if (u == -1) {
            Class<?> cls2 = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str = (String) cls2.getDeclaredMethod("get", String.class).invoke(cls2, "ro.build.version.emui");
            af.a(f3886a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            af.a(f3886a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        } catch (Throwable th) {
            af.d(f3886a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
        }
    }

    private static int d() {
        String str;
        Object obj;
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.BuildEx$VERSION");
            Field declaredField = cls.getDeclaredField("EMUI_SDK_INT");
            AccessibleObject.setAccessible(new Field[]{declaredField}, true);
            obj = declaredField.get(cls);
        } catch (ClassNotFoundException unused) {
            str = "getEMUIVersionCode ClassNotFoundException";
            af.c(f3886a, str);
            obj = null;
        } catch (IllegalAccessException unused2) {
            str = "getEMUIVersionCode IllegalAccessException";
            af.c(f3886a, str);
            obj = null;
        } catch (NoSuchFieldException unused3) {
            str = "getEMUIVersionCode NoSuchFieldException";
            af.c(f3886a, str);
            obj = null;
        } catch (SecurityException unused4) {
            str = "getEMUIVersionCode SecurityException";
            af.c(f3886a, str);
            obj = null;
        } catch (Exception unused5) {
            str = "getEMUIVersionCode exception ";
            af.c(f3886a, str);
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }
}
