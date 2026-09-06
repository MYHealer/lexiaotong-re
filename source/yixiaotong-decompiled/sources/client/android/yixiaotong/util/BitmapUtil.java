package client.android.yixiaotong.util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import androidx.core.content.ContextCompat;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.v3.util.LogUtil;
import com.kuaishou.weapon.p0.t;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BitmapUtil {
    public static Bitmap getURLimage(String str) {
        Bitmap bitmapDecodeStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmapDecodeStream;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    private static Bitmap decodeSampledBitmapFromPath(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = caculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private static int caculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 < i && i4 < i2) {
            return 1;
        }
        float f = i3 * 1.0f;
        return Math.max(Math.round(f / i), Math.round(f / i2));
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static boolean saveBitmapRefund(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            i -= 10;
            if (i < 11) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                break;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        File externalCacheDir = BaseApplication.app.getExternalCacheDir();
        if (!externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
        }
        File file = new File(externalCacheDir, str + ".jpg");
        LogUtil.e("BitmapUtil", "保存文件路径：" + file.getPath());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap rotateIfRequired(Bitmap bitmap, File file) throws IOException {
        int attributeInt = new ExifInterface(file.getPath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return rotateBitmap(bitmap, 180);
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? bitmap : rotateBitmap(bitmap, 270);
        }
        return rotateBitmap(bitmap, 90);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap getBitmapFromUri(Activity activity, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = activity.getContentResolver().openFileDescriptor(uri, t.k);
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            return BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Uri saveAlbum(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, boolean z) throws Throwable {
        Uri uri;
        OutputStream outputStreamOpenOutputStream;
        String str = System.currentTimeMillis() + "_" + i + "." + (Bitmap.CompressFormat.JPEG == compressFormat ? "JPG" : compressFormat.name());
        OutputStream outputStream = null;
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), str);
            if (!save(bitmap, file, compressFormat, i, z) || !file.exists()) {
                return null;
            }
            Uri uri2 = Uri.parse("file://" + file.getAbsolutePath());
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri2);
            context.sendBroadcast(intent);
            return uri2;
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", UrlHttpUtil.FILE_TYPE_IMAGE);
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/");
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = context.getContentResolver().insert(uri, contentValues);
        if (uriInsert == null) {
            return null;
        }
        try {
            outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriInsert);
            try {
                try {
                    bitmap.compress(compressFormat, i, outputStreamOpenOutputStream);
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    context.getContentResolver().update(uriInsert, contentValues, null, null);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return uriInsert;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    context.getContentResolver().delete(uriInsert, null, null);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                outputStream = outputStreamOpenOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStreamOpenOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    private static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i, boolean z) throws Throwable {
        boolean zCompress = false;
        if (isEmptyBitmap(bitmap)) {
            Log.e("ImageUtils", "bitmap is empty.");
            return false;
        }
        if (bitmap.isRecycled()) {
            Log.e("ImageUtils", "bitmap is recycled.");
            return false;
        }
        if (!createFile(file, true)) {
            Log.e("ImageUtils", "create or delete file <$file> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        zCompress = bitmap.compress(compressFormat, i, bufferedOutputStream2);
                        if (z && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return zCompress;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                }
            } catch (IOException e2) {
                e = e2;
            }
            return zCompress;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    private static boolean createFile(File file, boolean z) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (z) {
                if (!file.delete()) {
                    return false;
                }
            } else {
                return file.isFile();
            }
        }
        if (!createDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    private static boolean createDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isDirectory();
        }
        return file.mkdirs();
    }

    private static boolean isGranted(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
