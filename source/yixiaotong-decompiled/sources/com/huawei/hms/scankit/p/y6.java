package com.huawei.hms.scankit.p;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.bv.BaseConstants;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.openalliance.ad.constant.ai;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4382a = null;
    private static String b = null;
    public static boolean c = true;

    public static boolean a(int[][] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static int b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        return i;
    }

    public static int c(Context context) {
        int identifier;
        if (context.getResources() == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean e(Context context) {
        return (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean g(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 5.5d;
    }

    public static boolean h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 8.0d && ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels) > 1.3f;
    }

    public static boolean i(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }

    public static boolean j(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), a(), 0) == 0;
    }

    public static boolean a(int[] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static boolean d() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty("get", "sys.hw_multiwin_for_camera", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean e() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("samsung");
    }

    public static boolean f(Context context) {
        try {
            return "CN".equalsIgnoreCase(SystemPropUtils.getProperty("get", "ro.hw.country", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean a(byte[] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean a(byte[][] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean d(Context context) {
        String string = context.getResources().getConfiguration().toString();
        return string.contains("hwMultiwindow-magic") || string.contains("hw-magic-windows");
    }

    public static boolean a(String[] strArr, int i) {
        return i >= 0 && i < strArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(float[] fArr, int i) {
        return i >= 0 && i < fArr.length;
    }

    public static boolean c() {
        return "ar".equals(Locale.getDefault().getLanguage()) || com.huawei.openalliance.ad.constant.x.cT.equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()) || "fa".equals(Locale.getDefault().getLanguage());
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null && hmsScanArr.length != 0) {
            for (HmsScan hmsScan : hmsScanArr) {
                if (hmsScan != null) {
                    hmsScan.scanType = b(hmsScan.scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i) {
        if (i <= 0 || i >= 8192) {
            return 0;
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        int i2 = HmsScanBase.AZTEC_SCAN_TYPE;
        int iB = (i & i2) != 0 ? b(i2) : 0;
        int i3 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i & i3) != 0) {
            iB |= b(i3);
        }
        int i4 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i & i4) != 0) {
            iB |= b(i4);
        }
        int i5 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i & i5) != 0) {
            iB |= b(i5);
        }
        int i6 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i & i6) != 0) {
            iB |= b(i6);
        }
        int i7 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i & i7) != 0) {
            iB |= b(i7);
        }
        int i8 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i & i8) != 0) {
            iB |= b(i8);
        }
        int i9 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i & i9) != 0) {
            iB |= b(i9);
        }
        int i10 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i & i10) != 0) {
            iB |= b(i10);
        }
        int i11 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i & i11) != 0) {
            iB |= b(i11);
        }
        int i12 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i & i12) != 0) {
            iB |= b(i12);
        }
        int i13 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i & i13) != 0) {
            iB |= b(i13);
        }
        int i14 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        return (i & i14) != 0 ? iB | b(i14) : iB;
    }

    public static boolean b() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty("get", "sys.multiwin_for_camera", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static boolean b(Context context) {
        if (a(context) && TextUtils.isEmpty(b)) {
            b = context.getSharedPreferences("scanExt", 0).getString("scanExt", "unSet");
        }
        return "forbid".equals(b);
    }

    private static String b(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(com.huawei.openalliance.ad.constant.x.bQ)[1]);
            }
            if (!"com.android.providers.downloads.documents".equals(data.getAuthority())) {
                return null;
            }
            try {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), (String) null);
            } catch (NumberFormatException unused) {
                x3.b("ScankitUtils", "NumberFormatException in withAppendedId");
                return null;
            } catch (Exception unused2) {
                x3.b("ScankitUtils", "Exception in withAppendedId");
                return null;
            }
        }
        if ("content".equalsIgnoreCase(data.getScheme())) {
            return a(context, data, (String) null);
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, i / bitmap.getWidth(), i2 / bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        float f3 = 1.0f / f;
        float f4 = 1.0f / f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) (width * f);
        int i2 = (int) (height * f2);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[(i3 * i) + i4] = iArr[(((int) (i3 * f4)) * width) + ((int) (i4 * f3))];
            }
        }
        Log.d(">>>", "dstPixels:" + i + " x " + i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
        return bitmapCreateBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    private static String a() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        return (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) ? "navigation_gesture_on" : "navigationbar_is_min";
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        return listQueryIntentActivities.get(0);
    }

    public static boolean a(String str, Activity activity) {
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            x3.c("Utils", "NameNotFoundException Exception");
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        int i = packageInfo.applicationInfo.flags;
        return ((i & 1) == 1) || ((i & 128) == 1);
    }

    public static int a(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActivityManagerEx");
            Method declaredMethod = cls.getDeclaredMethod("getActivityWindowMode", Activity.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(cls, activity);
            if (objInvoke == null) {
                return -1;
            }
            return Integer.valueOf(String.valueOf(objInvoke)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NumberFormatException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static boolean a(Context context) {
        if (TextUtils.isEmpty(f4382a)) {
            try {
                f4382a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("scanExt", "unSet");
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("scanerror", "checkPermission NameNotFoundException");
            } catch (Exception unused2) {
                Log.e("scanerror", "checkPermission Exception");
            }
        }
        return "readUri".equals(f4382a);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f, width / 2, height / 2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmapCreateBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0) {
            return a(bitmap, 90.0f);
        }
        if (i != 2) {
            return i != 3 ? bitmap : a(bitmap, 180.0f);
        }
        return a(bitmap, 270.0f);
    }

    public static Bitmap a(Context context, Intent intent) {
        Bitmap bitmapA;
        Bitmap bitmapCompressBitmap;
        if (!a(context)) {
            String strB = b(context, intent);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 28 && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion > 28) {
                x3.a("ScanBitmap", "compressBitmap above android 29");
                bitmapCompressBitmap = ScanUtil.compressBitmapForAndroid29(context, strB);
            } else {
                x3.a("ScanBitmap", "compressBitmap below android 29");
                bitmapCompressBitmap = ScanUtil.compressBitmap(context, strB);
            }
            if (bitmapCompressBitmap != null) {
                return bitmapCompressBitmap;
            }
            x3.a("ScanBitmap", "compressBitmap above android 29");
            return ScanUtil.compressBitmapForAndroid29(context, strB);
        }
        Uri data = intent.getData();
        if (data == null || (bitmapA = a(context, data)) == null) {
            return null;
        }
        return bitmapA;
    }

    private static String a(Context context, Uri uri, String str) {
        String string = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
                cursorQuery.close();
            }
            return string;
        } catch (IllegalStateException unused) {
            x3.b("ScankitUtils", "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            x3.b("ScankitUtils", "Exception in getImagePath");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Bitmap a(Context context, Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            try {
                inputStreamOpenInputStream = StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    return null;
                }
                try {
                    try {
                        byte[] bArrA = a(inputStreamOpenInputStream);
                        BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
                        a(context, options);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                            x3.b("ScankitUtils", "IOException in getImagePath");
                        }
                        return bitmapDecodeByteArray;
                    } catch (IOException unused2) {
                        x3.b("ScankitUtils", "compressBitmapFromUri IOException");
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                            x3.b("ScankitUtils", "IOException in getImagePath");
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                x3.b("ScankitUtils", "IOException in getImagePath");
            }
        } catch (IOException unused5) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private static void a(Context context, BitmapFactory.Options options) {
        boolean z;
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i == 0 || i2 == 0) {
            return;
        }
        if (i > i2) {
            i = i2;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            z = ((double) memoryInfo.totalMem) / Math.pow(1024.0d, 3.0d) < 5.5d;
        } catch (NullPointerException unused) {
            x3.b("exception", "NullPointerException");
        } catch (Exception unused2) {
            x3.b("exception", "Exception");
        }
        int i3 = z ? ai.af : 3000;
        options.inSampleSize = i > i3 ? Math.round(i / i3) : 1;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
    }
}
