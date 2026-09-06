package com.fancy.adsdk.lib.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.fancy._b5;
import com.fancy._by;
import com.fancy._bz;
import com.fancy._df;
import com.fancy._fq;
import com.fancy._fy;
import com.fancy._ie;
import com.fancy._m3;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
final class Decoder {
    private static final String DOODLE_LOG_TAG = "PtgImageDecoder";
    private static final String TAG = "Decoder";

    private static Bitmap centerCrop(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = width * i2;
        int i4 = i * height;
        int i5 = i3 - i4;
        if (i5 > 0) {
            float f = width;
            float f2 = (f - (i4 / i2)) * 0.5f;
            if (f2 <= 0.0f) {
                return bitmap;
            }
            float f3 = 2.0f * f2;
            return f3 < f ? Bitmap.createBitmap(bitmap, Math.round(f2), 0, Math.round(f - f3), height) : bitmap;
        }
        if (i5 >= 0) {
            return bitmap;
        }
        float f4 = height;
        float f5 = (f4 - (i3 / i)) * 0.5f;
        if (f5 <= 0.0f) {
            return bitmap;
        }
        float f6 = 2.0f * f5;
        return f6 < f4 ? Bitmap.createBitmap(bitmap, 0, Math.round(f5), width, Math.round(f4 - f6)) : bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r0 != 5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r0.equals("mov") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decode(_bz _bzVar, _m3 _m3Var) {
        int i_c = _bzVar._c();
        if (i_c != 1) {
            if (i_c != 2) {
                if (i_c != 3) {
                    if (i_c != 4) {
                    }
                }
            }
            return decodeVideo(_bzVar, _m3Var);
        }
        if (!_bzVar._a.startsWith("content://media/external/video/")) {
            int length = _bzVar._a.length();
            if (length > 3) {
                String lowerCase = _bzVar._a.substring(length - 3, length).toLowerCase();
                if (!lowerCase.equals("mp4")) {
                }
            }
            return decodeImage(_bzVar, _m3Var);
        }
        return decodeVideo(_bzVar, _m3Var);
    }

    public static Bitmap decodeFile(String str, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0141  */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x0159. Please report as an issue. */
    private static Bitmap decodeImage(_bz _bzVar, _m3 _m3Var) {
        int i_a;
        boolean z;
        Bitmap bitmap_b;
        int iRound;
        int iMin;
        int iRound2;
        int iMin2;
        int i_c;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inMutable = true;
        int i = _m3Var._g;
        if (i != 0) {
            boolean z2 = i == 2 || (i == 3 && ((i_c = _bzVar._c()) == 7 || i_c == 9 || i_c == 11 || i_c == 13));
            options.inPreferredConfig = z2 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
            if (z2) {
                _m3Var._g = 2;
                options.inDither = true;
            }
        }
        if (_bzVar._d()) {
            i_a = _bzVar._f != null ? _df._a(new ByteArrayInputStream(_bzVar._f)) : _bzVar._b._a();
            z = i_a >= 5;
        } else {
            i_a = 0;
            z = false;
        }
        _b5 _b5Var = _m3Var._f;
        if (_b5Var == _b5.NOT_SET) {
            _b5Var = _b5.NO_CLIP;
        }
        _b5 _b5Var2 = _b5.NO_CLIP;
        if (_b5Var != _b5Var2) {
            options.inJustDecodeBounds = true;
            _bzVar._b(options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                _b5Var = _b5Var2;
            }
            options.inJustDecodeBounds = false;
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int i4 = z ? _m3Var._e : _m3Var._d;
        int i5 = z ? _m3Var._d : _m3Var._e;
        int iOrdinal = _b5Var.ordinal();
        if (iOrdinal == 1) {
            bitmap_b = _bzVar._b(options);
        } else if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                int i6 = i2 * i5;
                int i7 = i4 * i3;
                if (iOrdinal != 5) {
                    if (i6 > i7) {
                        if (i2 > i4) {
                            options.inScaled = true;
                            options.inTargetDensity = i4;
                            options.inDensity = i2;
                        }
                    } else if (i3 > i5) {
                        options.inScaled = true;
                        options.inTargetDensity = i5;
                        options.inDensity = i3;
                    }
                    bitmap_b = _bzVar._b(options);
                } else {
                    if (i6 > i7) {
                        if (i3 > i5) {
                            options.inScaled = true;
                            options.inTargetDensity = i5;
                            options.inDensity = i3;
                        }
                    } else if (i2 > i4) {
                        options.inScaled = true;
                        options.inTargetDensity = i4;
                        options.inDensity = i2;
                    }
                    bitmap_b = _bzVar._b(options);
                    if (bitmap_b != null) {
                        bitmap_b = centerCrop(bitmap_b, i4, i5);
                    }
                }
            } else if (i2 > i4 || i3 > i5) {
                if (i2 > i4) {
                    iRound = Math.round((i2 - i4) * 0.5f);
                    iMin = Math.min(i4 + iRound, i2);
                } else {
                    iRound = 0;
                    iMin = i2;
                }
                if (i3 > i5) {
                    iRound2 = Math.round((i3 - i5) * 0.5f);
                    iMin2 = Math.min(i5 + iRound2, i3);
                } else {
                    iRound2 = 0;
                    iMin2 = i3;
                }
                Rect rect = new Rect(iRound, iRound2, iMin, iMin2);
                byte[] bArr = _bzVar._f;
                bitmap_b = bArr != null ? BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, options) : _bzVar._b._a(rect, options);
            } else {
                bitmap_b = _bzVar._b(options);
            }
        } else if (i2 > i4 || i3 > i5) {
            Rect rect2 = new Rect(0, 0, Math.min(i2, i4), Math.min(i3, i5));
            byte[] bArr2 = _bzVar._f;
            bitmap_b = bArr2 != null ? BitmapRegionDecoder.newInstance(bArr2, 0, bArr2.length, false).decodeRegion(rect2, options) : _bzVar._b._a(rect2, options);
        } else {
            bitmap_b = _bzVar._b(options);
        }
        Bitmap bitmapCreateBitmap = bitmap_b;
        if (bitmapCreateBitmap == null) {
            throw new IllegalArgumentException(_ie._a("Not support to decode the file: ").append(_fy._a(_bzVar._c())).toString());
        }
        if (i_a > 1) {
            Matrix matrix = new Matrix();
            switch (i_a) {
                case 2:
                    matrix.setScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 3:
                    matrix.setRotate(180.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 4:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 5:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 6:
                    matrix.setRotate(90.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 7:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 8:
                    matrix.setRotate(-90.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
            }
        }
        if (_fq._a()) {
            logResult(bitmapCreateBitmap, _m3Var, i2, i3);
        }
        return bitmapCreateBitmap;
    }

    private static Bitmap decodeVideo(_bz _bzVar, _m3 _m3Var) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (_bzVar._f != null) {
                mediaMetadataRetriever.setDataSource(new _by(_bzVar));
            } else {
                _bzVar._b._a(mediaMetadataRetriever);
            }
            int i6 = _m3Var._d;
            int i7 = _m3Var._e;
            _b5 _b5Var = _m3Var._f;
            int i8 = 0;
            Bitmap frameAtTime = null;
            if (Build.VERSION.SDK_INT < 27 || i6 <= 0 || i7 <= 0 || _b5Var == _b5.NO_CLIP || _b5Var == _b5.MATRIX || _b5Var == _b5.CENTER) {
                i = 0;
            } else {
                try {
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                    if (TextUtils.isEmpty(strExtractMetadata) || TextUtils.isEmpty(strExtractMetadata2) || TextUtils.isEmpty(strExtractMetadata3)) {
                        i4 = 0;
                        i3 = 0;
                    } else {
                        i2 = Integer.parseInt(strExtractMetadata);
                        try {
                            i3 = Integer.parseInt(strExtractMetadata2);
                            try {
                                i8 = Integer.parseInt(strExtractMetadata3);
                            } catch (Throwable th) {
                                th = th;
                                _fq._a(TAG, th);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i3 = 0;
                        }
                        int i9 = i8;
                        i8 = i2;
                        i4 = i9;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i2 = 0;
                    i3 = 0;
                }
                if (i8 <= 0 || i3 <= 0) {
                    i = i3;
                } else {
                    if (i4 == 90 || i4 == 270) {
                        i5 = i3;
                        i = i8;
                    } else {
                        i = i3;
                        i5 = i8;
                    }
                    float fMin = Math.min(getScale(i5, i, i6, i7, _b5Var, false), 1.0f);
                    try {
                        frameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(-1L, 2, Math.round(i5 * fMin), Math.round(fMin * i));
                    } catch (Throwable th4) {
                        _fq._a(TAG, th4);
                    }
                    i8 = i5;
                }
            }
            if (frameAtTime == null) {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L, 2);
            }
            Bitmap bitmapHandleScaleAndCrop = handleScaleAndCrop(frameAtTime, _m3Var);
            if (_fq._a()) {
                logResult(bitmapHandleScaleAndCrop, _m3Var, i8, i);
            }
            int i10 = Build.VERSION.SDK_INT;
            mediaMetadataRetriever.release();
            if (bitmapHandleScaleAndCrop != null) {
                return bitmapHandleScaleAndCrop;
            }
            throw new IllegalArgumentException("Not support to decode the file");
        } catch (Throwable th5) {
            int i11 = Build.VERSION.SDK_INT;
            mediaMetadataRetriever.release();
            throw th5;
        }
    }

    public static int findResourceId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "drawable", context.getPackageName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        return r6 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        return r5 / r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getScale(int i, int i2, int i3, int i4, _b5 _b5Var, boolean z) {
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            if (_b5Var != _b5.CENTER_CROP) {
                boolean z2 = _b5Var == _b5.CENTER_INSIDE;
                if (i * i4 > i3 * i2) {
                    if (!z2) {
                    }
                } else if (!z2) {
                }
            } else if (i * i4 > i3 * i2) {
                if (!z) {
                }
            } else if (!z) {
            }
        }
        return 1.0f;
    }

    public static Bitmap handleScaleAndCrop(Bitmap bitmap, _m3 _m3Var) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null) {
            return null;
        }
        int i = _m3Var._d;
        int i2 = _m3Var._e;
        _b5 _b5Var = _m3Var._f;
        if (i <= 0 || i2 <= 0 || _b5Var == _b5.NO_CLIP || _b5Var == _b5.MATRIX || _b5Var == _b5.CENTER) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scale = getScale(width, height, i, i2, _b5Var, false);
        if (scale != 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } else {
            bitmapCreateBitmap = bitmap;
        }
        return (bitmapCreateBitmap == null || _b5Var != _b5.CENTER_CROP) ? bitmapCreateBitmap : centerCrop(bitmapCreateBitmap, i, i2);
    }

    private static void logResult(Bitmap bitmap, _m3 _m3Var, int i, int i2) {
        if (bitmap != null) {
            Log.i(TAG, "source:" + i + "x" + i2 + " target:" + _m3Var._d + "x" + _m3Var._e + " result:" + bitmap.getWidth() + "x" + bitmap.getHeight());
        }
    }

    private static void printELog(String str) {
    }

    public static void ptgOnDecodeFailure(int i) {
        printELog("ptgOnDecodeFailure failed: code=" + i);
    }
}
