package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.auth.aidl.ICheckIDService;
import com.miui.zeus.auth.aidl.ICheckListener;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.server.MimoAdServer;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<? extends i> f5368a;
    public static d9 b;

    public static int a(l6 l6Var) {
        if (l6Var != null) {
            return a(l6Var.i, ijiami_1011.s.s.s.d(new byte[]{102, 9, 88, 8, 84}, "5a9c1b")) ? 2 : 5;
        }
        return 0;
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int a(List<String> list) {
        if (list.isEmpty()) {
            return -1;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                int iE = e(it.next());
                if (iE != -1) {
                    return iE;
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Activity a(View view) {
        while (view != null) {
            Context context = view.getContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int i2 = i;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            int i3 = width * height;
            int[] iArr = new int[i3];
            bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
            int i4 = width - 1;
            int i5 = height - 1;
            int i6 = i2 + i2;
            int i7 = i6 + 1;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            int[] iArr4 = new int[i3];
            int[] iArr5 = new int[Math.max(width, height)];
            int i8 = (i6 + 2) >> 1;
            int i9 = i8 * i8;
            int i10 = i9 * 256;
            int[] iArr6 = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr6[i11] = i11 / i9;
            }
            int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
            int i12 = i2 + 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                bitmap2 = bitmapCopy;
                if (i13 >= height) {
                    break;
                }
                int i16 = -i2;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i16 <= i2) {
                    int i26 = i5;
                    int i27 = height;
                    int i28 = iArr[i14 + Math.min(i4, Math.max(i16, 0))];
                    int[] iArr8 = iArr7[i16 + i2];
                    iArr8[0] = (i28 & 16711680) >> 16;
                    iArr8[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr8[2] = i28 & 255;
                    int iAbs = i12 - Math.abs(i16);
                    int i29 = iArr8[0];
                    i19 += i29 * iAbs;
                    int i30 = iArr8[1];
                    i18 += i30 * iAbs;
                    int i31 = iArr8[2];
                    i17 += iAbs * i31;
                    if (i16 > 0) {
                        i25 += i29;
                        i24 += i30;
                        i23 += i31;
                    } else {
                        i22 += i29;
                        i21 += i30;
                        i20 += i31;
                    }
                    i16++;
                    height = i27;
                    i5 = i26;
                }
                int i32 = i5;
                int i33 = height;
                int i34 = i2;
                int i35 = 0;
                while (i35 < width) {
                    iArr2[i14] = iArr6[i19];
                    iArr3[i14] = iArr6[i18];
                    iArr4[i14] = iArr6[i17];
                    int i36 = i19 - i22;
                    int i37 = i18 - i21;
                    int i38 = i17 - i20;
                    int[] iArr9 = iArr7[((i34 - i2) + i7) % i7];
                    int i39 = i22 - iArr9[0];
                    int i40 = i21 - iArr9[1];
                    int i41 = i20 - iArr9[2];
                    if (i13 == 0) {
                        iArr5[i35] = Math.min(i35 + i2 + 1, i4);
                    }
                    int i42 = iArr[i15 + iArr5[i35]];
                    int i43 = (i42 & 16711680) >> 16;
                    iArr9[0] = i43;
                    int i44 = (i42 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr9[1] = i44;
                    int i45 = i42 & 255;
                    iArr9[2] = i45;
                    int i46 = i25 + i43;
                    int i47 = i24 + i44;
                    int i48 = i23 + i45;
                    i19 = i36 + i46;
                    i18 = i37 + i47;
                    i17 = i38 + i48;
                    i34 = (i34 + 1) % i7;
                    int[] iArr10 = iArr7[i34 % i7];
                    int i49 = iArr10[0];
                    i22 = i39 + i49;
                    int i50 = iArr10[1];
                    i21 = i40 + i50;
                    int i51 = iArr10[2];
                    i20 = i41 + i51;
                    i25 = i46 - i49;
                    i24 = i47 - i50;
                    i23 = i48 - i51;
                    i14++;
                    i35++;
                    iArr6 = iArr6;
                }
                i15 += width;
                i13++;
                bitmapCopy = bitmap2;
                height = i33;
                i5 = i32;
            }
            int[] iArr11 = iArr6;
            int i52 = i5;
            int i53 = height;
            int i54 = 0;
            while (i54 < width) {
                int i55 = -i2;
                int i56 = i55 * width;
                int i57 = 0;
                int i58 = 0;
                int i59 = 0;
                int i60 = 0;
                int i61 = 0;
                int i62 = 0;
                int i63 = 0;
                int i64 = 0;
                int i65 = 0;
                while (i55 <= i2) {
                    int[] iArr12 = iArr5;
                    int iMax = Math.max(0, i56) + i54;
                    int[] iArr13 = iArr7[i55 + i2];
                    iArr13[0] = iArr2[iMax];
                    iArr13[1] = iArr3[iMax];
                    iArr13[2] = iArr4[iMax];
                    int iAbs2 = i12 - Math.abs(i55);
                    i59 += iArr2[iMax] * iAbs2;
                    i58 += iArr3[iMax] * iAbs2;
                    i57 += iArr4[iMax] * iAbs2;
                    if (i55 > 0) {
                        i65 += iArr13[0];
                        i64 += iArr13[1];
                        i63 += iArr13[2];
                    } else {
                        i62 += iArr13[0];
                        i61 += iArr13[1];
                        i60 += iArr13[2];
                    }
                    int i66 = i52;
                    if (i55 < i66) {
                        i56 += width;
                    }
                    i55++;
                    i52 = i66;
                    iArr5 = iArr12;
                }
                int[] iArr14 = iArr5;
                int i67 = i52;
                int i68 = i2;
                int i69 = i54;
                int i70 = i53;
                int i71 = 0;
                while (i71 < i70) {
                    iArr[i69] = (iArr[i69] & (-16777216)) | (iArr11[i59] << 16) | (iArr11[i58] << 8) | iArr11[i57];
                    int i72 = i59 - i62;
                    int i73 = i58 - i61;
                    int i74 = i57 - i60;
                    int[] iArr15 = iArr7[((i68 - i2) + i7) % i7];
                    int i75 = i62 - iArr15[0];
                    int i76 = i61 - iArr15[1];
                    int i77 = i60 - iArr15[2];
                    if (i54 == 0) {
                        iArr14[i71] = Math.min(i71 + i12, i67) * width;
                    }
                    int i78 = iArr14[i71] + i54;
                    int i79 = iArr2[i78];
                    iArr15[0] = i79;
                    int i80 = iArr3[i78];
                    iArr15[1] = i80;
                    int i81 = iArr4[i78];
                    iArr15[2] = i81;
                    int i82 = i65 + i79;
                    int i83 = i64 + i80;
                    int i84 = i63 + i81;
                    i59 = i72 + i82;
                    i58 = i73 + i83;
                    i57 = i74 + i84;
                    i68 = (i68 + 1) % i7;
                    int[] iArr16 = iArr7[i68];
                    int i85 = iArr16[0];
                    i62 = i75 + i85;
                    int i86 = iArr16[1];
                    i61 = i76 + i86;
                    int i87 = iArr16[2];
                    i60 = i77 + i87;
                    i65 = i82 - i85;
                    i64 = i83 - i86;
                    i63 = i84 - i87;
                    i69 += width;
                    i71++;
                    i2 = i;
                }
                i54++;
                i2 = i;
                i53 = i70;
                i52 = i67;
                iArr5 = iArr14;
            }
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, i53);
            return bitmap2;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    public static Rect a(View view, int i, int i2) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (view.getGlobalVisibleRect(rect2)) {
            int iWidth = rect2.left + (rect2.width() / 2);
            int iHeight = rect2.top + (rect2.height() / 2);
            rect.set(iWidth - (view.getWidth() / 2), iHeight - (view.getHeight() / 2), iWidth + (view.getWidth() / 2), iHeight + (view.getHeight() / 2));
        } else {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i3 = iArr[0];
            rect.set(i3, iArr[1], view.getMeasuredWidth() + i3, iArr[1] + view.getMeasuredHeight());
        }
        rect.offset(-i, -i2);
        return rect;
    }

    public static MimoAdServer a() {
        if (MimoSdkInitHolder.getRequestEnvironment() == 1) {
            return new MimoAdServer(ijiami_1011.s.s.s.d(new byte[]{11, Ascii.ETB, 16, 67, 14, Ascii.CAN, 78, 16, 3, 17, 69, 75, 2, 7, 74, 75, 93, 86, 14, 9, 15, 76, 82, 10, 14, 76, 17, 93, 93, 88, 15, 75, 0, 7, 69, 6, 11, 34, 0, SignedBytes.MAX_POWER_OF_TWO}, "ccd347"));
        }
        return MimoSdkInitHolder.getRequestEnvironment() == 2 ? new MimoAdServer(ijiami_1011.s.s.s.d(new byte[]{94, 70, Ascii.DC2, 71, SignedBytes.MAX_POWER_OF_TWO, 8, 78, 75, Ascii.SYN, 16, 84, 19, 95, 87, 17, Ascii.EM, 82, 86, 79, Ascii.FS, 15, 3, 94, 8, 95, Ascii.FS, 5, 88, 94, Ascii.GS, Ascii.DC4, 10, 15, 13, 95, 74, 80, 87, Ascii.DC2, 84, 91, 115, 5, Ascii.ETB}, "62f732")) : new MimoAdServer(ijiami_1011.s.s.s.d(new byte[]{11, 70, Ascii.DC2, 71, 68, 10, 78, 75, 7, Ascii.DC2, 88, 75, 2, 86, 72, 79, 94, 81, 14, 9, 15, 76, 82, 10, 14, Ascii.GS, 19, 89, 94, 95, 15, 75, 0, 7, 69, 6, 11, 115, 2, 68}, "c2f770"));
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        return obj.getClass().getDeclaredMethod(str, clsArr).invoke(obj, objArr);
    }

    public static String a(double d, int i) {
        try {
            return String.format(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 26}, "e4038e") + i + ijiami_1011.s.s.s.d(new byte[]{5}, "c6d772"), Double.valueOf(new BigDecimal(d).setScale(i, 1).doubleValue()));
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e7 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:30:0x00f5  */
    public static String a(int i) {
        String strD;
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{74, 4, Ascii.ESC, 65, -124, -107, -62, -127, -34, -38, -40, -27, -39, -35, -116, -16, -115, -124, -19, -127, -23, -51, -43, -34, -57, -48, -115, -36, -123, -83, -60, 110}, "b52ab8"));
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 5, 79, Ascii.NAK, -123, -50, -24, -128, -34, -30, -41, -53, -125, -47, -15, -125, -117, -12, -43, -126, -18, -12, -41, -2, -126, -47, -21, -105, -122, -37, -31, -127, -23, -46, -44, -43, -71, -48, -41, -122, -118, -51, -33, -127, -62, -27, -41, -48, -67, -33, -55, -96}, "67f5bc");
        } else if (i == 3002) {
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 4, 16, Ascii.SYN, -118, -101, -42, -126, -24, -16, -41, -6, -110, -35, -66, -100, -121, -125, -48, -125, -4, -26, -43, -34, -108, -46, -103, -73, -117, -76, -38, -116, -40, -13, -34, -39, -69, -46, -104, -104, -122, -117, -4, -126, -53, -63, -42, -60, -103, -46, -93, -78, -124, -70, -60, -127, -29, -57}, "7596b4");
        } else if (i == 3008) {
            strD = ijiami_1011.s.s.s.d(new byte[]{73, 3, Ascii.CAN, 67, -114, -55, -42, -125, -57, -52, -39, -53, -59, -41, -116, -16, -125, -17, -20, -127, -33, -35, -44, -12, -21, -42, -116, -18, -113, -29, -20, -125, -37, -52, -42, -1, -27, -44, -87, -52, -125, -10, -57, -128, -34, -40, -44, -21, -2, -43, -91, -4, -128, -50, -64, -125, -17, -22, -44, -36, -34, -41, -96, -23}, "a21cff");
        } else if (i == 4001) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{78, 8, Ascii.RS, 17, -127, -64, -29, -126, -8, -2, -41, -25, -50, -33, -81, -98, -125, -51, -9, -125, -17, -22, -44, -33, -14, -34, -93, -103, -128, -34, -11, -115, -6, -30, -39, -61, -25, -35, -118, -114, -125, -14, -55, -127, -38, -30, -44, -44, -23, -36, -114, -114, -127, -9, -21, -117, -38, -18, -39, -54, -47, -48, -73, -72, -126, -19, -56, -125, -43, -39, -42, -34, -7, -36, -117, -79, -127, -41, -18, -117, -38, -22, -42, -42, -35, -34, -116, -82, -127, -38, -31, -127, -41, -19, -41, -14, -58, -48, -85, -79, -128, -35, -38, -128, -37, -9, -43, -34, -59, -34, -105, -80, -126, -24, -60, -127, -29, -57, -44, -10, -7, -42, -117, -72, 110}, "f971df"));
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 81, Ascii.RS, 19, -36, -110, -29, -126, -8, -2, -41, -25, -103, -123, -81, -100, -33, -100, -53, -125, -17, -22, -44, -33, -91, -124, -93, -101, -35, -116, -11, -115, -6, -30, -39, -61, -80, -121, -118, -116, -34, -96, -55, -127, -38, -30, -44, -44, -66, -122, -114, -116, -36, -91, -21, -117, -38, -18, -39, -54, -122, -123, -71, -95, -33, -85, -60, -116, -31, -56, -44, -46, -128, -124, -83, -73, -35, -113, -62, -125, -58, -29, -40, -27, -118, -117, -119, -94, -42, -120, -19, -125, -57, -52, -43, -38, -84, -123, -102, -112, -34, -107, -49, -125, -4, -26, -41, -21, -108, -122, -78, -106}, "1c7394");
        } else if (i == 5007) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{73, 84, Ascii.FS, 70, -36, -105, -42, -126, -3, -42, -41, -24, -61, -128, -123, -23, -45, -119, -46, -116, -56, -36, -44, -63, -26, -125, -128, -19, -36, -105, -12}, "ae5f48"));
            sb.append(ijiami_1011.s.s.s.d(new byte[]{78, 3, 75, 66, -40, -105, -42, -127, -18, -27, -41, -24, -60, -44, -22, -46, -41, -97, -38, -127, -20, -54, -42, -40, -9, -42, -39, -2, -42, -115, -22, -116, -55, -9}, "f1bb08"));
            strD = ijiami_1011.s.s.s.d(new byte[]{26, 3, Ascii.RS, 19, -116, -51, -42, -127, -6, -54, -44, -19, -81, -43, -112, -72, -127, -18, -9, -126, -15, -44, -41, -20, -95, -43, -117, -77, 0, 7, 3, 17, 1, -121, -115, -27, -41, -75, -124, 19, 73, 92, 65, -127, -62, -17, -42, -21, -126, -43, -85, -119, -126, -5, -50, 68, 75, 92, 17, -125, -72, -93, -46, -68, -14, 14, 14, 3, 5, 3, 69, -125, -91, -107, -46, -116, -13, -122, -34, -59, -128, -29, -98, 69, Ascii.US, 16, 9, 19, -116, -29, -11, -125, -43, -39, -42, -44, -127, -41, -84, -84, -116, -59, -62, -127, -32, -47}, "2073db");
        } else if (i == 300001) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{16, 4, 79, 70, -118, -104, -42, -125, -57, -52, -39, -53, -100, -48, -33, -39, -121, -90, -21, -128, -37, -17, -41, -3, -105, -48, -10, -64, -124, -81, -50, -127, -47, -48, -40, -32, -75, -46, -37, -56, -124, -65, -9, -115, -29, -17, -42, -40, -106, -45, -53, -59, -123, -106, -49, 110}, "85ffb7"));
            strD = ijiami_1011.s.s.s.d(new byte[]{76, 86, 16, Ascii.EM, -117, -50, -42, -125, -57, -52, -39, -53, -64, -127, -128, -122, -122, -16, -21, -128, -37, -17, -41, -3, -53, -127, -87, -97, -123, -7, -50, -127, -38, -30, -44, -11, -53, -125, -77, -113, -123, -31, -32}, "dd99ca");
        } else if (i == 300250) {
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 1, Ascii.EM, Ascii.ETB, -118, -106, -42, -126, -3, -42, -41, -24, -107, -43, -128, -72, -123, -120, -46, -116, -56, -36, -44, -63, -80, -42, -123, -68, -118, -106, -12}, "7007b9");
        } else if (i != 300255) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                case 9000:
                                case 9001:
                                case 9002:
                                    break;
                                default:
                                    switch (i) {
                                        case 300215:
                                            sb.append(ijiami_1011.s.s.s.d(new byte[]{74, 4, Ascii.ESC, 65, -124, -107, -62, -127, -34, -38, -40, -27, -39, -35, -116, -16, -115, -124, -19, -127, -23, -51, -43, -34, -57, -48, -115, -36, -123, -83, -60, 110}, "b52ab8"));
                                            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 5, 79, Ascii.NAK, -123, -50, -24, -128, -34, -30, -41, -53, -125, -47, -15, -125, -117, -12, -43, -126, -18, -12, -41, -2, -126, -47, -21, -105, -122, -37, -31, -127, -23, -46, -44, -43, -71, -48, -41, -122, -118, -51, -33, -127, -62, -27, -41, -48, -67, -33, -55, -96}, "67f5bc");
                                            break;
                                        case 300216:
                                            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 1, Ascii.EM, Ascii.ETB, -118, -106, -42, -126, -3, -42, -41, -24, -107, -43, -128, -72, -123, -120, -46, -116, -56, -36, -44, -63, -80, -42, -123, -68, -118, -106, -12}, "7007b9");
                                            break;
                                        default:
                                            sb.append(ijiami_1011.s.s.s.d(new byte[]{26, 4, Ascii.EM, 65, -33, -98, -42, -127, -23, -32, -39, -27, -79, -48, -97, -40, -48, -128, -46, -125, -3, -3, -44, -54, -117, -45, -66, -60, -47, -89, -26, -126, -57, -63, -43, -35, -97, -36, -92, -8, -33, -98, -50, -125, -58, -29, -39, -54, -122, -45, -88, -17, Base64.padSymbol}, "250a71"));
                                            strD = ijiami_1011.s.s.s.d(new byte[]{77, 11, 16, 19, -35, -54, -42, -116, -25, -10, -42, -42, -34, -34, -120, -128, -46, -2, -2, -116, -63, -63, -44, -29, -42}, "e9935e");
                                            break;
                                    }
                                    break;
                            }
                        case 5009:
                        case 5010:
                        case 5011:
                        case 5012:
                            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 4, 16, Ascii.SYN, -118, -101, -42, -126, -24, -16, -41, -6, -110, -35, -66, -100, -121, -125, -48, -125, -4, -26, -43, -34, -108, -46, -103, -73, -117, -76, -38, -116, -40, -13, -34, -39, -69, -46, -104, -104, -122, -117, -4, -126, -53, -63, -42, -60, -103, -46, -93, -78, -124, -70, -60, -127, -29, -57}, "7596b4");
                            break;
                    }
                case 5000:
                case 5001:
                case 5002:
                case 5003:
                case 5004:
                case 5005:
                    strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 4, 16, Ascii.SYN, -118, -101, -42, -126, -24, -16, -41, -6, -110, -35, -66, -100, -121, -125, -48, -125, -4, -26, -43, -34, -108, -46, -103, -73, -117, -76, -38, -116, -40, -13, -34, -39, -69, -46, -104, -104, -122, -117, -4, -126, -53, -63, -42, -60, -103, -46, -93, -78, -124, -70, -60, -127, -29, -57}, "7596b4");
                    break;
            }
        } else {
            strD = ijiami_1011.s.s.s.d(new byte[]{76, 8, Ascii.US, 69, -33, -73, -13, -126, -7, -57, -39, -30, -50, -36, -127, -44, -34, -93, -27, -128, -35, -63, -42, -59, -27, -42, -118, -23, -47, -106, -42, -128, -37, -35, -42, -15, -52, -33, -101, -58, -34, -104, -49, -125, -4, -26, -44, -36, -37, -36, -89, -17, -36, -106, -40, -116, -41, -61, -44, -21, -33, -36, -68, -59, -47, -124, -36, -127, -33, -35, -44, -12, -18}, "d96e99");
        }
        sb.append(strD);
        return sb.toString();
    }

    public static String a(int i, String str, int i2) {
        String strD;
        StringBuilder sb = new StringBuilder();
        sb.append(i2 == 0 ? ijiami_1011.s.s.s.d(new byte[]{26, 85, Ascii.ESC, 69, -45, -127, -34, -127, -9, -24, -44, -17, -110, -116, -113, -40, -45, -100, -48, -116, -46, -57, Ascii.GS, 69, -38, -53, -108, -125, -75, -67, -119, -61, -25, -115, -115, -1}, "2d2e68") : ijiami_1011.s.s.s.d(new byte[]{17, 0, 16, Ascii.SYN, -43, -118, -34, -127, -9, -24, -44, -44, -84, -42, -99, -116, -43, -105, -48, -116, -46, -57, Ascii.GS, 69, -47, -98, -97, -48, -77, -74, -119, -61, -25, -115, -115, -1}, "919603"));
        if (i == 1) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-36, -104, -124, -121, -124, -75, -121, -20, -10, -121, -69, -6, -37, -117, -65, -123, -120, -79, -121, -13, -58, -121, -95, -19, -35, -73, -79, -122, -81, -77, -124, -35, -39, -121, -96, -17, -36, -120, -89, -124, -82, -87}, "473a57");
        } else if (i == 3002) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-126, -38, -109, -125, -28, -110, -122, -2, -30, 33, 94, 11, Ascii.DC2, 7, 90, 8, 4, 69, -122, -2, -30, 53, 88, 1, Ascii.DC2, 14, -43, -18, -9, 127, 4, 13, 1, 10, 69, -128, -62, -52, -42, -42, -18}, "ff3fa7");
        } else if (i == 3008) {
            strD = ijiami_1011.s.s.s.d(new byte[]{11, 2, 50, 83, 93, Ascii.DC2, 13, 5, Ascii.DC2, 7, -44, -56, -12, -47, -56, -125, -44, -38, -37, -125, -49, -40}, "c7f60b");
        } else if (i == 4001) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-41, -97, -82, -122, -72, -72, -124, -34, -14, -123, -91, -51, -44, -116, -75, -119, -78, -115, -119, -25, -37, -122, -116, -38, -41, -96, -112, -122, -128, -125, -122, -1, -7, 49, 117, 46, -43, -120, -72, -124, -128, -65, -124, -35, -39, -121, -96, -17}, "048a10");
        } else if (i == 5007) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-39, -97, -65, -120, -60, -89, -122, -48, -58, -124, -84, -11, -43, -128, -78, -119, -37, -117, -124, -64, -41, -118, -123, -64}, "189af6");
        } else if (i == 300001) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-35, -82, -5, -45, -43, -15, -122, -2, -30, -121, -120, -38, -47, -94, -17, -47, -37, -23}, "43e5fd");
        } else if (i == 300250) {
            strD = ijiami_1011.s.s.s.d(new byte[]{-46, -120, -89, -36, -17, -70, -124, -35, -39, -121, -96, -17, -45, -120, -71, -47, -40, -119, -124, -20, -42, -122, -117, -29, -34, -88, -86, -36, -42, -72, -122, -43, -43, -118, -97, -37, -46, -111, -77, -34, -4, -77, -119, -54, -39, -117, -90, -53, -47, -103, -107, -33, -13, -121}, "7549f7");
        } else if (i != 300255) {
            switch (i) {
                case 5001:
                    strD = ijiami_1011.s.s.s.d(new byte[]{124, 88, Ascii.ETB, 11, Ascii.ETB, 92, 32, 0, 48, 11, 84, Ascii.DC2, -42, -127, -18, -118, -30, -124, -123, -36, -36, -123, -104, -33}, "29cba9");
                    break;
                case 5002:
                    strD = ijiami_1011.s.s.s.d(new byte[]{-125, -115, -36, -35, -87, -20, -124, -36, -27, -121, -128, -27, -128, -122, -62, -34, -92, -17, -121, -45, -35, -121, -69, -59, 34, 93, 17, 93, 91, Ascii.DC2, 37, 11, 17, 12, 93, 10, 7, 80, 53, 81, 93, 17, -122, -33, -30, -122, -118, -45}, "f4c88f");
                    break;
                case 5003:
                    strD = ijiami_1011.s.s.s.d(new byte[]{-121, -127, -38, -47, -16, -70, -121, -60, -33, -121, -119, -26, -121, -119, -27, -36, -50, -121, -123, -39, -39, -123, -91, -51, 44, 89, 17, 93, Ascii.ETB, 85, 32, 0, 48, 11, 84, Ascii.DC2, -123, -125, -31, -48, -38, -122}, "b8e4a0");
                    break;
                case 5004:
                    strD = ijiami_1011.s.s.s.d(new byte[]{-35, -116, -34, -46, -90, -70, -121, -60, -33, -121, -119, -26, -35, -124, -31, -33, -120, -73, -124, -44, -23}, "85a770");
                    break;
                case 5005:
                    strD = ijiami_1011.s.s.s.d(new byte[]{-45, -35, -119, -42, -45, -92, -124, -35, -39, -121, -96, -17, -47, -23, -88, -43, -25, -70, -122, -48, -58, -124, -84, -11, -46, -42, -120, -42, -23, -107}, "4a33c5");
                    break;
                default:
                    switch (i) {
                        case 5009:
                            strD = ijiami_1011.s.s.s.d(new byte[]{-44, -35, -114, -42, -126, -89, -124, -1, -40, -123, -72, -30, -43, -23, -94, -37, -107, -80, -120, -58, -9, -123, -118, -31, -41, -38, -126}, "3a4326");
                            break;
                        case 5010:
                            strD = ijiami_1011.s.s.s.d(new byte[]{-128, -127, -37, -121, -94, -72, 35, 17, Ascii.DC2, Ascii.SYN, 94, 11, -128, -75, -60, -124, -100, -90, -119, -37, -31, -121, -107, -62}, "e8db32");
                            break;
                        case 5011:
                            strD = ijiami_1011.s.s.s.d(new byte[]{-44, -35, -116, -122, -94, -65, 35, 17, Ascii.DC2, Ascii.SYN, 94, 11, -44, -44, -119, -122, -100, -115, -119, -37, -31, -121, -127, -22}, "1d3c35");
                            break;
                        case 5012:
                            strD = ijiami_1011.s.s.s.d(new byte[]{-42, -120, -121, -45, -89, -67, 35, 17, Ascii.DC2, Ascii.SYN, 94, 11, -42, -127, -126, -45, -103, -113, -119, -37, -31, -121, -107, -62}, "318667");
                            break;
                        default:
                            switch (i) {
                                case 9000:
                                    strD = ijiami_1011.s.s.s.d(new byte[]{-41, -116, -112, -48, -29, -57, -122, -2, -30, 33, 94, 11, 71, 85, 72, 65, -126, -38, -37, -125, -49, -40}, "3005fb");
                                    break;
                                case 9001:
                                    strD = ijiami_1011.s.s.s.d(new byte[]{-122, -118, -58, -124, -77, -111, -122, -2, -30, 33, 94, 11, Ascii.SYN, 87, 15, 15, 83, 70, -123, -36, -36, -123, -104, -33}, "b6fa64");
                                    break;
                                case 9002:
                                    strD = ijiami_1011.s.s.s.d(new byte[]{-47, -115, -62, -36, -80, -57, -122, -2, -30, 35, 82, 17, 92, 71, 11, 77, 76, -122, -39, -34, -127, -53, -117}, "51b95b");
                                    break;
                                default:
                                    switch (i) {
                                        case 300215:
                                            strD = ijiami_1011.s.s.s.d(new byte[]{-117, -104, -124, -41, -123, -32, -120, -58, -9, -123, -65, -30, -117, -120, -76, -40, -97, -6}, "c7314b");
                                            break;
                                        case 300216:
                                            strD = ijiami_1011.s.s.s.d(new byte[]{-43, -34, -90, -41, -67, -68, -119, -54, -40, -121, -107, -30, -43, -20, -94, -41, -68, -127, -120, -3, -10, -121, -71, -45}, "0c5241");
                                            break;
                                        default:
                                            strD = (TextUtils.isEmpty(str) ? new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{-48, -83, -102, -45, -4, -106, -120, -16, -1, -118, -98, -54, 26, 17, 85, 70, 17, 92, 19, 39, 9, 6, 84, 69, 11, 17}, "6104c3")).append(i) : new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{-46, -87, -52, -34, -5, -57, -120, -16, -1, -118, -98, -54, Ascii.CAN, Ascii.NAK, 3, 75, Ascii.SYN, 13, 19, 39, 9, 6, 84, 69, 9, Ascii.NAK}, "45f9db")).append(i).append(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, Ascii.SYN, 81, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 86, 19, 41, 3, 17, 66, 4, 83, 83, Ascii.DC4, 88, Ascii.DC2}, "464e29")).append(str)).toString();
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            strD = ijiami_1011.s.s.s.d(new byte[]{-121, -119, -90, -125, -24, -66, -124, -35, -39, -121, -96, -17, -122, -119, -72, -126, -36, -116, -122, -16, -50, -122, -117, -29, -117, -96, -84, -114, -50, -100, -122, -2, -30, -124, -65, -64, -121, -79, -112, -127, -5, -73, -121, -14, -33, -121, -115, -22}, "b45fa3");
        }
        sb.append(strD);
        return sb.toString();
    }

    public static String a(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static void a(Context context, String str, ICheckListener iCheckListener) {
        t9.e.submit(b$$Lambda$1.lambdaFactory$(context, str, iCheckListener));
    }

    public static void a(LinearLayout linearLayout, AdMarkICP adMarkICP, BrandICP brandICP) {
        if (linearLayout != null) {
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new u6(linearLayout, adMarkICP, brandICP));
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(ClassLoader classLoader, File file) throws IllegalAccessException {
        Object obj = v6.a(classLoader, ijiami_1011.s.s.s.d(new byte[]{73, 84, 70, 11, 45, 11, Ascii.DC2, 16}, "952cab")).get(classLoader);
        List list = (List) v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{95, 0, 68, 92, 78, 87, 45, 13, 4, 16, 80, Ascii.ETB, 72, 37, 89, 71, 93, 81, Ascii.NAK, 11, Ascii.DC4, 11, 84, Ascii.SYN}, "1a0582")).get(obj);
        list.add(0, file);
        List list2 = (List) v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{70, 72, 74, 69, 93, 90, 47, 5, Ascii.DC2, 11, 71, 0, 121, 88, 91, 67, 89, 69, Ascii.CAN, 32, 15, 16, 84, 6, 65, 94, 75, 88, 93, 68}, "519187")).get(obj);
        Method methodA = v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{92, 82, 88, 3, 101, 84, Ascii.NAK, 12, 35, 14, 84, 8, 84, 93, 71, Ascii.NAK}, "133f55"), List.class);
        list.addAll(list2);
        Object[] objArr = (Object[]) methodA.invoke(obj, list);
        Field fieldA = v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{93, 86, 77, 93, 16, 80, 45, 13, 4, 16, 80, Ascii.ETB, 74, 103, 88, SignedBytes.MAX_POWER_OF_TWO, 14, 112, 13, 1, 11, 7, 95, 17, SignedBytes.MAX_POWER_OF_TWO}, "3794f5"));
        fieldA.setAccessible(true);
        fieldA.set(obj, objArr);
    }

    public static void a(String str, s3 s3Var, String str2, String str3, long j, String str4) {
        a(str, null, s3Var, str2, str3, null, j, null, str4);
    }

    public static void a(String str, s3 s3Var, String str2, String str3, long j, String str4, String str5) {
        a(str, null, s3Var, str2, str3, null, j, str4, str5);
    }

    public static boolean a(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean a(Context context) {
        try {
            return ((AccessibilityManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{2, 0, 6, 1, 65, 71, 8, 6, 15, 14, 88, 17, 26}, "cced24"))).isEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(View view, double d) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        return measuredHeight > 0 && measuredWidth > 0 && ((double) (rect.bottom - rect.top)) >= ((double) measuredHeight) * d;
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length != charArray2.length) {
            return false;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            char c2 = charArray2[i];
            if (c != c2 && c + ' ' != c2 && c - ' ' != c2) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, List<String> list) {
        Uri uri;
        Set<String> queryParameterNames;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return false;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null || queryParameterNames.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (queryParameterNames.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public static float b(View view) {
        if (view == null) {
            return 0.0f;
        }
        try {
            float alpha = view.getAlpha();
            int i = 0;
            while (view.getParent() != null && i <= 5 && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
                alpha = Math.min(alpha, view.getAlpha());
                i++;
                if (alpha == 0.0f) {
                    break;
                }
            }
            return alpha;
        } catch (Exception e) {
            e.printStackTrace();
            return 1.0f;
        }
    }

    public static String b() {
        return z8.a(UUID.randomUUID().toString());
    }

    public static String b(double d, int i) {
        try {
            return String.format(ijiami_1011.s.s.s.d(new byte[]{65, Ascii.EM}, "d79e13") + i + ijiami_1011.s.s.s.d(new byte[]{4}, "b35ef6"), Double.valueOf(new BigDecimal(d).setScale(i, 1).doubleValue()));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(File file) throws Throwable {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i));
                    }
                    a(fileInputStream2);
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    m.b(ijiami_1011.s.s.s.d(new byte[]{113, 91, 9, 87, 99, 70, 8, 8, Ascii.NAK}, "72e262"), ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 86, 80, 93, 115, 10, 13, 1}, "d3195c"));
                    a(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str, String str2) {
        try {
            return (String) Class.forName(ijiami_1011.s.s.s.d(new byte[]{5, 90, 86, 17, 11, 10, 5, 74, 9, 17, Ascii.US, 54, Ascii.GS, 71, 70, 6, 9, 51, 19, 11, Ascii.SYN, 7, 67, 17, 13, 81, 65}, "d42cdc")).getMethod(ijiami_1011.s.s.s.d(new byte[]{80, 87, 76}, "728ca3"), String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{99, 49, 67, 95, 69}, "0a1052"), ijiami_1011.s.s.s.d(new byte[]{127, 1, 77, Ascii.DC2, 6, 26, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 86}, "8d92cb"), e);
            return str2;
        }
    }

    public static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
        Object obj = v6.a(classLoader, ijiami_1011.s.s.s.d(new byte[]{72, 86, 69, 14, 116, 95, Ascii.DC2, 16}, "871f86")).get(classLoader);
        List list = (List) v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{95, 0, SignedBytes.MAX_POWER_OF_TWO, 81, 70, 86, 45, 13, 4, 16, 80, Ascii.ETB, 72, 37, 93, 74, 85, 80, Ascii.NAK, 11, Ascii.DC4, 11, 84, Ascii.SYN}, "1a4803")).get(obj);
        list.add(0, file);
        List list2 = (List) v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{67, 65, Ascii.ETB, 68, 1, 85, 47, 5, Ascii.DC2, 11, 71, 0, 124, 81, 6, 66, 5, 74, Ascii.CAN, 32, 15, 16, 84, 6, 68, 87, Ascii.SYN, 89, 1, 75}, "08d0d8")).get(obj);
        Method methodA = v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{90, 4, 90, 0, 52, 7, Ascii.NAK, 12, 35, 14, 84, 8, 82, 11, 69, Ascii.SYN}, "7e1edf"), List.class, File.class, List.class);
        ArrayList arrayList = new ArrayList();
        list.addAll(list2);
        Object[] objArr = (Object[]) methodA.invoke(obj, list, null, arrayList);
        Field fieldA = v6.a(obj, ijiami_1011.s.s.s.d(new byte[]{94, 4, 16, 88, 70, 80, 45, 13, 4, 16, 80, Ascii.ETB, 73, 53, 5, 69, 88, 112, 13, 1, 11, 7, 95, 17, 67}, "0ed105"));
        fieldA.setAccessible(true);
        fieldA.set(obj, objArr);
    }

    public static boolean b(Context context, String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent uri2 = null;
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host)) {
            return false;
        }
        try {
            uri2 = Intent.parseUri(str, 0);
        } catch (URISyntaxException unused2) {
        }
        return (uri2 == null || uri2.resolveActivity(context.getPackageManager()) == null) ? false : true;
    }

    public static boolean b(String str) {
        try {
            Uri uri = Uri.parse(str);
            if (TextUtils.equals(uri.getScheme(), ijiami_1011.s.s.s.d(new byte[]{12, Ascii.SYN, Ascii.ETB, 69, 74}, "dbc59d"))) {
                String host = uri.getHost();
                if (!TextUtils.isEmpty(host)) {
                    return host.endsWith(ijiami_1011.s.s.s.d(new byte[]{17, 81, 70, 85, Ascii.ESC, 6, 79, 9, 15, 76, 82, 10, 15}, "b8205c")) || host.endsWith(ijiami_1011.s.s.s.d(new byte[]{67, 17, 85, 81, 90, 12, 6, 73, Ascii.NAK, 11, 69, 0, Ascii.RS, 0, 26, 91, 90, 76, 2, 11, 11}, "0e463b")) || host.endsWith(ijiami_1011.s.s.s.d(new byte[]{95, 10, Ascii.ETB, 87, Ascii.EM, 0, 79, 9, 7, 16, 90, 0, 71, 77, Ascii.ESC, 91, 86, 14, 12, 13, 72, 1, 94, 8}, "3cc27a"));
                }
            }
        } catch (Exception e) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{101, SignedBytes.MAX_POWER_OF_TWO, 13, 103, 76, 12, 13, Ascii.ETB}, "02a28e"), ijiami_1011.s.s.s.d(new byte[]{2, 14, 93, 0, 9, 55, 19, 8}, "af8cbb"), e);
        }
        return false;
    }

    public static i c(Context context) {
        i iVarNewInstance;
        Class<? extends i> cls = f5368a;
        if (cls != null) {
            try {
                iVarNewInstance = cls.newInstance();
            } catch (Exception e) {
                Log.w(ijiami_1011.s.s.s.d(new byte[]{104, 82, 76, 66, 50, 8, 0, Ascii.GS, 3, 16, 119, 4, 81, 67, 86, 67, Ascii.ESC}, "2791bd"), ijiami_1011.s.s.s.d(new byte[]{11, 89, 12, 16, 65, Ascii.SYN, 13, 5, Ascii.US, 7, 67, 69, 11, 89, Ascii.SYN, 16, 0, 8, 2, 1, 70, 7, 67, Ascii.ETB, 13, 69, 95, 68}, "b7edaf") + e.getMessage());
                iVarNewInstance = null;
            }
        } else {
            iVarNewInstance = null;
        }
        if (iVarNewInstance == null) {
            iVarNewInstance = new j();
        }
        if (iVarNewInstance instanceof g) {
            ((g) iVarNewInstance).setContext(context);
        }
        return iVarNewInstance;
    }

    public static void c(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        Object obj = v6.a(classLoader, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 0, 65, 95, 47, 93, Ascii.DC2, 16}, "fa57c4")).get(classLoader);
        File[] fileArr = {file};
        Field declaredField = obj.getClass().getDeclaredField(ijiami_1011.s.s.s.d(new byte[]{89, 4, Ascii.SYN, 95, SignedBytes.MAX_POWER_OF_TWO, 4, 45, 13, 4, 16, 80, Ascii.ETB, 78, 33, 11, 68, 83, 2, Ascii.NAK, 11, Ascii.DC4, 11, 84, Ascii.SYN}, "7eb66a"));
        declaredField.setAccessible(true);
        declaredField.set(obj, fileArr);
    }

    public static int d(String str) {
        try {
            return Integer.parseInt(str) - 180;
        } catch (Exception unused) {
            return -999;
        }
    }

    public static int e(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                return options.outWidth > options.outHeight ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static int f(String str) {
        try {
            return (int) (Float.parseFloat(str) * 100.0f);
        } catch (Exception unused) {
            return -999;
        }
    }

    public static boolean g(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean h(String str) {
        return !g(str);
    }

    public static Set<String> i(String str) {
        HashSet hashSet = new HashSet();
        Matcher matcher = Pattern.compile(ijiami_1011.s.s.s.d(new byte[]{79, 82, Ascii.SYN, 111, Ascii.NAK, 26, 5, 5, Ascii.DC2, 3, 109, Ascii.SYN, 19, 14, 56, SignedBytes.MAX_POWER_OF_TWO, 76, Ascii.EM, Base64.padSymbol, Ascii.US, 72, 72, 14, 57, 68, 26, 95}, "93d3f1")).matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            HashSet hashSet2 = new HashSet();
            try {
                JSONObject jSONObject = new JSONObject(strGroup);
                if (jSONObject.has(ijiami_1011.s.s.s.d(new byte[]{10, 86, 10, 88, 97, 67, 13}, "c5e641"))) {
                    hashSet2.add(jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{88, 1, 89, 94, 51, Ascii.ETB, 13}, "1b60fe")));
                }
                if (jSONObject.has(ijiami_1011.s.s.s.d(new byte[]{81, 95, 86, 103, 67, 85, Ascii.DC2}, "821219"))) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ijiami_1011.s.s.s.d(new byte[]{80, 12, 87, 101, 65, 15, Ascii.DC2}, "9a003c"));
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        hashSet2.add(jSONArrayOptJSONArray.optString(i));
                    }
                }
                if (jSONObject.has(ijiami_1011.s.s.s.d(new byte[]{7, 71, 67, 49, 71, 92, 19, 1, 48, 11, 85, 0, 9}, "f73b33"))) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{2, 69, 71, 55, 77, 88, 19, 1, 48, 11, 85, 0, 12}, "c57d97"));
                    hashSet2.add(jSONObjectOptJSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 11, 93, 86, 91, 96, 19, 8}, "ab9345")));
                    hashSet2.add(jSONObjectOptJSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{82, 13, 71, 4, 66, 49, 19, 8}, "1b1a0d")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    public static float a(View view, boolean z) {
        ViewGroup viewGroup;
        Rect rect = new Rect();
        float f = 0.0f;
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0f;
        }
        float fHeight = ((rect.height() * rect.width()) * 1.0f) / (view.getHeight() * view.getWidth());
        if (!z) {
            return fHeight;
        }
        Rect rect2 = new Rect();
        int i = 0;
        View view2 = view;
        loop0: while ((view2.getParent() instanceof ViewGroup) && i < 5 && (iIndexOfChild = (viewGroup = (ViewGroup) view2.getParent()).indexOfChild(view2)) >= 0) {
            while (true) {
                int iIndexOfChild = iIndexOfChild + 1;
                if (iIndexOfChild < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(iIndexOfChild);
                    if (childAt.getVisibility() == 0 && !(childAt instanceof h8)) {
                        boolean globalVisibleRect = childAt.getGlobalVisibleRect(rect2);
                        float fMin = !Rect.intersects(rect, rect2) ? 0.0f : Math.min(Math.max(((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) / (rect.width() * rect.height()), 0.0f), 1.0f);
                        if (globalVisibleRect && fMin > 0.0f) {
                            f = fMin;
                            break loop0;
                        }
                    }
                }
            }
            i++;
            view2 = viewGroup;
        }
        return Math.min(fHeight, 1.0f - f);
    }

    public static boolean b(Context context) {
        return (context instanceof Activity) && a((Activity) context);
    }

    public static void c(String str) {
        l4 l4Var = l4.a.f5519a;
        if (l4Var.a()) {
            l4Var.b.remove(str);
        }
        if (l4Var.a()) {
            l4Var.c.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0079  */
    public static void b(Context context, String str, ICheckListener iCheckListener) {
        String strD;
        String str2;
        String strD2;
        PackageInfo packageInfo;
        f fVar = new f(context, ICheckIDService.class, str, iCheckListener);
        Intent intent = new Intent();
        intent.setAction(ijiami_1011.s.s.s.d(new byte[]{8, 80, 77, 90, 74, 80, 15, 16, 3, 12, 69, 75, 4, 90, 76, 90, 11, 87, 79, 5, 2, 76, 103, 36, 41, 112, 124, 114, 48, 124, 32, 32, 57, 49, 116, 55, 51, 112, 123, 118}, "e983d9"));
        Boolean bool = null;
        try {
            Object obj = Class.forName(ijiami_1011.s.s.s.d(new byte[]{9, 91, Ascii.DC4, 81, Ascii.RS, 92, Ascii.DC2, 74, 36, Ascii.ETB, 88, 9, 0}, "d2a803")).getField(ijiami_1011.s.s.s.d(new byte[]{43, 53, 108, 113, 123, 97, 36, 54, 40, 35, 101, 44, 45, 40, 114, 116, 106, 119, 52, 45, 42, 38}, "bf3855")).get(null);
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(ijiami_1011.s.s.s.d(new byte[]{5, 9, 15, 74, 88, 92, Ascii.DC4, 13, 72, 15, 66, 4, 72, 1, 14, 11, 87, 84, 13}, "ffbd55"), 0);
                } catch (Exception unused) {
                    packageInfo = null;
                }
                if (packageInfo == null || packageInfo.applicationInfo == null) {
                    strD = ijiami_1011.s.s.s.d(new byte[]{82, 10, 88, 79, 11, 92, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 0, 88, 32, 2, 102, 14, 8, 19, Ascii.SYN, 88, 10, 95}, "1e5af5");
                } else {
                    strD = ijiami_1011.s.s.s.d(new byte[]{90, 12, 94, 72, 94, 93, Ascii.DC4, 13, 72, 15, 66, 4, Ascii.ETB, 4, 95, 9, 81, 85, 13}, "9c3f34");
                }
            } else {
                strD = ijiami_1011.s.s.s.d(new byte[]{82, 10, 88, 79, 11, 92, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 0, 88, 32, 2, 102, 14, 8, 19, Ascii.SYN, 88, 10, 95}, "1e5af5");
            }
        } catch (Exception unused2) {
        }
        intent.setPackage(strD);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            fVar.e = System.currentTimeMillis();
            fVar.c = null;
            if (fVar.f5587a.bindService(intent, fVar, 1)) {
                try {
                    bool = fVar.get();
                } catch (TimeoutException e) {
                    e = e;
                    str2 = ijiami_1011.s.s.s.d(new byte[]{88, 90, SignedBytes.MAX_POWER_OF_TWO, 92, 14, 83, 65, 33, Ascii.RS, 1, 84, Ascii.NAK, 69, 93, 89, 93, 69}, "1463e6") + fVar.d + ijiami_1011.s.s.s.d(new byte[]{67, 49, 94, 91, 7, 9, Ascii.DC4, 16}, "ce76bf");
                    strD2 = ijiami_1011.s.s.s.d(new byte[]{98, 77, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 7, 90, 50, 0, 13, 79, 99, 0, 92, 91, 71, 81, 47, 82, Ascii.NAK, 12, 9, 6, 120, 11, 71, 91, 88, 81, 16}, "1434b7");
                    q9.a(strD2, str2, e);
                } catch (Exception e2) {
                    e = e2;
                    str2 = ijiami_1011.s.s.s.d(new byte[]{80, 86, 66, 9, 93, 86, 65, 33, Ascii.RS, 1, 84, Ascii.NAK, 77, 81, 91, 8, Ascii.SYN}, "984f63") + fVar.d;
                    strD2 = ijiami_1011.s.s.s.d(new byte[]{101, 73, 65, Ascii.DC2, 82, 90, 50, 0, 13, 79, 99, 0, 91, 95, 70, 3, 122, 82, Ascii.NAK, 12, 9, 6, 120, 11, SignedBytes.MAX_POWER_OF_TWO, 95, 89, 3, 69}, "602f77");
                    q9.a(strD2, str2, e);
                }
            } else {
                q9.a(ijiami_1011.s.s.s.d(new byte[]{98, 74, 66, 66, 6, 93, 50, 0, 13, 79, 99, 0, 92, 92, 69, 83, 46, 85, Ascii.NAK, 12, 9, 6, 120, 11, 71, 92, 90, 83, 17}, "1316c0"), ijiami_1011.s.s.s.d(new byte[]{113, 4, 94, Ascii.SYN, 12, 9, Ascii.NAK, 68, 0, 11, 95, 1, Ascii.DC2, 7, 89, 88, 6, 70, Ascii.DC2, 1, Ascii.DC4, Ascii.DC4, 88, 6, 87, 69, 86, 89, 16, 70}, "2e06bf") + fVar.d);
            }
            Boolean bool2 = bool;
            if (bool2 == null || !bool2.booleanValue()) {
                try {
                    iCheckListener.onFailure(ijiami_1011.s.s.s.d(new byte[]{1, 94, 11, 2, 1, 17, 65, 6, 15, 12, 85, 69, 5, 86, 12, 10, 17, 17, 4}, "c7efdc"), -10001);
                    return;
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        }
        throw new RuntimeException(ijiami_1011.s.s.s.d(new byte[]{48, 81, 95, Ascii.SYN, 10, 93, 65, 10, 9, Ascii.SYN, 17, Ascii.ETB, Ascii.SYN, 87, 16, 12, 8, Ascii.EM, 12, 5, 15, 12, 17, 17, 11, 75, 85, 2, 2, Ascii.ETB}, "c90cf9"));
    }

    public static void c() {
        try {
            l4 l4Var = l4.a.f5519a;
            if (l4Var.a()) {
                l4Var.e = true;
            }
        } catch (Exception unused) {
        }
    }

    public static void a(MimoAdInfo mimoAdInfo, boolean z) {
        String strD;
        String strD2;
        String strD3;
        String strD4;
        String strD5;
        String strD6;
        if (mimoAdInfo == null || y8.f5752a == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = mimoAdInfo.W0;
        if (!z2 || z) {
            if (z2 && z) {
                strD4 = ijiami_1011.s.s.s.d(new byte[]{80}, "a5c25a");
                strD5 = ijiami_1011.s.s.s.d(new byte[]{84, 83, 86, 1, 3}, "fcf114");
                strD6 = ijiami_1011.s.s.s.d(new byte[]{11, 81, 66, 68, Ascii.ETB, 6, 15, 0, 3, 16, 17, 3, 7, 89, 93}, "f01dec");
            } else {
                strD = ijiami_1011.s.s.s.d(new byte[]{82}, "cc8282");
                strD2 = ijiami_1011.s.s.s.d(new byte[]{3, 3, 8, 3, 81}, "1383bd");
                strD3 = ijiami_1011.s.s.s.d(new byte[]{66, 2, 90, Ascii.CAN, 69, 4, 15, 0, 3, 16, 17, Ascii.SYN, 68, 5, 82, 93, 68, Ascii.DC2}, "1f187a");
            }
            h6 h6VarA = h6.a();
            String str = mimoAdInfo.u;
            String strValueOf = String.valueOf(mimoAdInfo.d);
            s3 s3Var = mimoAdInfo.e0;
            String strH = mimoAdInfo.h();
            h6VarA.getClass();
            x8.i.execute(new d6(h6VarA, ijiami_1011.s.s.s.d(new byte[]{43, 91, 3, 108, 19, 86, 2, 15, 3, 16}, "d5f8a7"), ijiami_1011.s.s.s.d(new byte[]{119, 86, 83, 102, Ascii.ETB, 86, 2, 15, 50, 16, 80, 6, 83, 93, 68, Ascii.DC2, 1, 94, 0, 3, 8, 13, 66, 12, 75, 108, 68, 83, 6, 92, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 76, 81, 89, 92, 95}, "8862e7"), strD5, ijiami_1011.s.s.s.d(new byte[]{99, 119, 119, 33, 114, 100, 62, 48, Utf8.REPLACEMENT_BYTE, 50, 116}, "129e76"), str, strH, jCurrentTimeMillis, strValueOf, s3Var, strD6, strD4, strD5));
        }
        strD = ijiami_1011.s.s.s.d(new byte[]{87}, "ec441a");
        strD2 = ijiami_1011.s.s.s.d(new byte[]{5, 0, 1, 8, 1}, "701801");
        strD3 = ijiami_1011.s.s.s.d(new byte[]{95, 86, Ascii.ETB, 66, 16, 84, 15, 0, 3, 16, 17, Ascii.SYN, 71, 84, 7, 7, 17, 66}, "27dbb1");
        strD4 = strD;
        strD6 = strD3;
        strD5 = strD2;
        h6 h6VarA2 = h6.a();
        String str2 = mimoAdInfo.u;
        String strValueOf2 = String.valueOf(mimoAdInfo.d);
        s3 s3Var2 = mimoAdInfo.e0;
        String strH2 = mimoAdInfo.h();
        h6VarA2.getClass();
        x8.i.execute(new d6(h6VarA2, ijiami_1011.s.s.s.d(new byte[]{43, 91, 3, 108, 19, 86, 2, 15, 3, 16}, "d5f8a7"), ijiami_1011.s.s.s.d(new byte[]{119, 86, 83, 102, Ascii.ETB, 86, 2, 15, 50, 16, 80, 6, 83, 93, 68, Ascii.DC2, 1, 94, 0, 3, 8, 13, 66, 12, 75, 108, 68, 83, 6, 92, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 76, 81, 89, 92, 95}, "8862e7"), strD5, ijiami_1011.s.s.s.d(new byte[]{99, 119, 119, 33, 114, 100, 62, 48, Utf8.REPLACEMENT_BYTE, 50, 116}, "129e76"), str2, strH2, jCurrentTimeMillis, strValueOf2, s3Var2, strD6, strD4, strD5));
    }

    public static void b(String str, m4 m4Var) {
        try {
            l4 l4Var = l4.a.f5519a;
            if (l4Var.a() && !TextUtils.isEmpty(str)) {
                List<m4> arrayList = l4Var.c.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                int iA = l4Var.a(arrayList, m4Var);
                if (iA >= 0) {
                    arrayList.remove(iA);
                }
                arrayList.add(m4Var);
                l4Var.c.put(str, arrayList);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(MimoAdInfo mimoAdInfo, String str, String str2, long j) {
        a(mimoAdInfo, str, str2, j, (String) null, (String) null);
    }

    public static void a(MimoAdInfo mimoAdInfo, String str, String str2, long j, String str3, String str4) {
        String str5;
        String str6;
        s3 s3Var;
        String str7;
        if (mimoAdInfo != null) {
            String str8 = mimoAdInfo.u;
            String strValueOf = String.valueOf(mimoAdInfo.d);
            String strH = mimoAdInfo.h();
            s3Var = mimoAdInfo.e0;
            str7 = strH;
            str6 = strValueOf;
            str5 = str8;
        } else {
            str5 = null;
            str6 = null;
            s3Var = null;
            str7 = null;
        }
        a(str5, str6, s3Var, str, str2, str7, j, str3, str4);
    }

    public static void a(String str, String str2, s3 s3Var, String str3, String str4, String str5, long j, String str6, String str7) {
        if (y8.f5752a == null) {
            return;
        }
        h6 h6VarA = h6.a();
        h6VarA.getClass();
        x8.i.execute(new d6(h6VarA, ijiami_1011.s.s.s.d(new byte[]{120, 13, 6, 54, 68, 85, 2, 15, 3, 16}, "7ccb64"), ijiami_1011.s.s.s.d(new byte[]{120, 95, 0, 97, 67, 2, 2, 15, 50, 16, 80, 6, 92, 84, Ascii.ETB, Ascii.NAK, 85, 10, 0, 3, 8, 13, 66, 12, 68, 101, Ascii.ETB, 84, 82, 8, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 67, 88, 10, 91, 11}, "71e51c"), str4, str3, str, str5, j, str2, s3Var, str7, null, str6));
    }

    public static boolean a(Collection collection) {
        return !(collection == null || collection.size() == 0);
    }

    public static String a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(key)) {
                        String strTrim = str.trim();
                        String strTrim2 = key.trim();
                        if (!TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                            str = strTrim.replaceAll(ijiami_1011.s.s.s.d(new byte[]{75}, "c8cf76") + strTrim2 + ijiami_1011.s.s.s.d(new byte[]{107, 16, 76, 4, 62, 17, 75, Utf8.REPLACEMENT_BYTE, 56, 68, Ascii.DC2, 56, Ascii.GS, 74}, "7cf9bb"), strTrim2 + ijiami_1011.s.s.s.d(new byte[]{4}, "928bb3") + value);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static void a(boolean z) {
        if (b == null) {
            b = new d9(ijiami_1011.s.s.s.d(new byte[]{108, 88, 92, 103, 5, 74}, "3558a9"));
        }
        if (z) {
            d9 d9Var = b;
            String strD = ijiami_1011.s.s.s.d(new byte[]{107, 93, 89, 57, 85, 75, 62, Ascii.ETB, 17}, "404f18");
            String strD2 = ijiami_1011.s.s.s.d(new byte[]{105, 88, 91, 111, 91, 19, 4, 10}, "65604c");
            SharedPreferences.Editor editorEdit = d9Var.f5408a.edit();
            editorEdit.putString(strD, strD2);
            editorEdit.apply();
            return;
        }
        d9 d9Var2 = b;
        String strD3 = ijiami_1011.s.s.s.d(new byte[]{111, 93, 89, 62, 85, 17, 62, Ascii.ETB, 17}, "004a1b");
        SharedPreferences.Editor editorEdit2 = d9Var2.f5408a.edit();
        editorEdit2.remove(strD3);
        editorEdit2.apply();
    }

    public static void a(AdEvent adEvent, MimoAdInfo mimoAdInfo) {
        a(adEvent, mimoAdInfo, (n6) null, (k6) null);
    }

    public static void a(AdEvent adEvent, MimoAdInfo mimoAdInfo, n6 n6Var, k6 k6Var) {
        if (y8.f5752a == null) {
            return;
        }
        h6 h6VarA = h6.a();
        String string = UUID.randomUUID().toString();
        h6VarA.getClass();
        x8.i.execute(new e6(h6VarA, ijiami_1011.s.s.s.d(new byte[]{41, 10, 83, 99, 71, 81, 2, 15, 3, 16}, "fd6750"), ijiami_1011.s.s.s.d(new byte[]{41, 93, 84, 102, 66, 88, 2, 15, 50, 16, 80, 6, 13, 86, 67, Ascii.DC2, 68, 75, 0, 7, 13, 35, 85, 32, 16, 86, 95, 70, 16, 92, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 9, 93, 11}, "f31209"), adEvent, string, mimoAdInfo, n6Var, k6Var));
    }

    public static void a(String str, m4 m4Var) {
        try {
            l4 l4Var = l4.a.f5519a;
            if (l4Var.a() && !TextUtils.isEmpty(str)) {
                List<m4> arrayList = l4Var.b.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                int iA = l4Var.a(arrayList, m4Var);
                if (iA >= 0) {
                    arrayList.remove(iA);
                }
                arrayList.add(m4Var);
                l4Var.b.put(str, arrayList);
            }
        } catch (Exception unused) {
        }
    }
}
