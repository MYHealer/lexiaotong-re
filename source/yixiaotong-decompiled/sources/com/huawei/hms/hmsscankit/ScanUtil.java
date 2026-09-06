package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.k4;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import com.huawei.openalliance.ad.constant.ai;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ScanUtil {
    public static final int CAMERA_ININT_ERROR = -1000;
    static final String CONTEXT_METHOD = "initializeModule";
    static final String CONTEXT_PATH = "com.huawei.hms.feature.DynamicModuleInitializer";
    static final String CREATOR_PATH = "com.huawei.hms.scankit.Creator";
    public static final int ERROR_ABNORMAL_RESTART = 3;
    public static final int ERROR_NO_CAMERA_PERMISSION = 1;
    public static final int ERROR_NO_READ_PERMISSION = 2;
    private static final int MAX_BITMAP_SIZE = 52428800;
    static final String MODULE_SCANKIT = "huawei_module_scankit";
    static final String MODULE_SCANKIT_LOCAL = "huawei_module_scankit_local";
    public static final String RESULT = "SCAN_RESULT";
    public static final int SUCCESS = 0;

    public static Bitmap buildBitmap(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        return new k4().a(str, i, i2, i3, hmsBuildBitmapOption);
    }

    public static Bitmap compressBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        dealBitmapFactoryOption(context, options);
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0045 A[Catch: Exception -> 0x0063, NullPointerException -> 0x006d, all -> 0x008d, TRY_LEAVE, TryCatch #5 {all -> 0x008d, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x003a, B:11:0x0045, B:19:0x0063, B:24:0x006d), top: B:45:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x005a A[DONT_INVERT, PHI: r4
  0x005a: PHI (r4v8 android.net.Uri) = (r4v11 android.net.Uri), (r4v17 android.net.Uri) binds: [B:8:0x0038, B:10:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x005c A[Catch: Exception -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0078, blocks: (B:14:0x005c, B:21:0x0068, B:26:0x0074), top: B:41:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x003a A[Catch: Exception -> 0x0063, NullPointerException -> 0x006d, all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x003a, B:11:0x0045, B:19:0x0063, B:24:0x006d), top: B:45:0x0008 }] */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008e: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:32:0x008e */
    public static Bitmap compressBitmapForAndroid29(Context context, String str) {
        Cursor cursor;
        Cursor cursorQuery;
        Uri uriWithAppendedPath;
        Uri uri = null;
        uri = null;
        uri = null;
        uri = null;
        uri = null;
        uri = null;
        Cursor cursor2 = null;
        try {
            try {
                try {
                    cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                uriWithAppendedPath = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                            } else if (new File(str).exists()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("_data", str);
                                uriWithAppendedPath = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            } else if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            uri = uriWithAppendedPath;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (NullPointerException unused) {
                            x3.b("exception", "NullPointerException");
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            getBitmapFromUri(context, uri, options);
                            dealBitmapFactoryOption(context, options);
                            return getBitmapFromUri(context, uri, options);
                        } catch (Exception unused2) {
                            x3.b("exception", "Exception");
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inJustDecodeBounds = true;
                            getBitmapFromUri(context, uri, options2);
                            dealBitmapFactoryOption(context, options2);
                            return getBitmapFromUri(context, uri, options2);
                        }
                    } else if (new File(str).exists()) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("_data", str);
                        uriWithAppendedPath = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
                        uri = uriWithAppendedPath;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception unused3) {
                    x3.b("exception", "Exception");
                }
            } catch (NullPointerException unused4) {
                cursorQuery = null;
            } catch (Exception unused5) {
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception unused6) {
                        x3.b("exception", "Exception");
                    }
                }
                throw th;
            }
            BitmapFactory.Options options3 = new BitmapFactory.Options();
            options3.inJustDecodeBounds = true;
            getBitmapFromUri(context, uri, options3);
            dealBitmapFactoryOption(context, options3);
            return getBitmapFromUri(context, uri, options3);
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
        }
    }

    private static void dealBitmapFactoryOption(Context context, BitmapFactory.Options options) {
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

    public static HmsScan[] decodeWithBitmap(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        if (bitmap != null && bitmap.getWidth() * bitmap.getHeight() <= 52428800) {
            return e.a(context, bitmap, hmsScanAnalyzerOptions);
        }
        if (bitmap != null) {
            x3.d("ScanUtil", "input image is too large:" + bitmap.getWidth());
        }
        return new HmsScan[0];
    }

    public static HmsScan[] detectForHmsDector(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return a.a(context, mLFrame, hmsScanAnalyzerOptions);
    }

    private static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            x3.a("ScanBitmap", "uri == null");
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.k);
            Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, options);
            parcelFileDescriptorOpenFileDescriptor.close();
            return bitmapDecodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            x3.b("exception", "FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            x3.b("exception", "IOException");
            return null;
        } catch (Exception unused3) {
            x3.b("exception", "Exception");
            return null;
        }
    }

    public static boolean isScanAvailable(Context context) {
        return true;
    }

    public static int startScan(Activity activity, int i, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        int i2;
        try {
            i2 = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 16384).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            x3.b("exception", "NameNotFoundException");
            i2 = 28;
        } catch (RuntimeException unused2) {
            x3.b("exception", "RuntimeException");
            i2 = 28;
        }
        boolean zSelfPermissionGranted = selfPermissionGranted(activity, i2, PermissionUtil.PERSSION_CAMERA);
        if (!y6.c) {
            return 3;
        }
        if (!zSelfPermissionGranted) {
            return 1;
        }
        Intent intent = new Intent(activity, (Class<?>) ScanKitActivity.class);
        if (hmsScanAnalyzerOptions != null) {
            intent.putExtra(HmsScanBase.SCAN_FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
            intent.putExtra(HmsScanBase.SCAN_VIEW_FLAG, hmsScanAnalyzerOptions.viewType);
        }
        activity.startActivityForResult(intent, i);
        return 0;
    }

    public static boolean selfPermissionGranted(Context context, int i, String str) {
        if (i >= 23) {
            if (y6.a(str) == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
        } else if (y6.a(context, str) == 0) {
            return true;
        }
        return false;
    }
}
