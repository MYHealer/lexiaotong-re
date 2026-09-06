package com.huawei.hms.ml.common.utils;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class ImageConvertUtils {
    public static final int INDEX_PLANE_U = 1;
    public static final int INDEX_PLANE_V = 2;
    public static final int INDEX_PLANE_Y = 0;
    private static final ImageConvertUtils INSTANCE = new ImageConvertUtils();
    public static final int YUV_FORMAT_I420 = 1;
    public static final int YUV_FORMAT_NV21 = 2;

    private static int getChannelOffset(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i2 == 1 ? (int) (((double) i3) * 1.25d) : i3;
        }
        return i2 == 1 ? i3 : i3 + 1;
    }

    public static ImageConvertUtils getInstance() {
        return INSTANCE;
    }

    private static int getOutputStride(int i, int i2) {
        return (i == 0 || i2 == 1) ? 1 : 2;
    }

    private ImageConvertUtils() {
    }

    public static byte[] buffer2Byte(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    public static byte[] nv21ToJpeg(byte[] bArr, int i, int i2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new YuvImage(bArr, 17, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    public static byte[] bitmap2Jpeg(Bitmap bitmap, int i) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    public static byte[] yuv2Buffer(Image image) {
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        int iRemaining = buffer.remaining();
        int iRemaining2 = buffer2.remaining();
        int iRemaining3 = buffer3.remaining();
        int i = iRemaining + iRemaining2 + iRemaining3;
        byte[] bArr = new byte[i];
        buffer.get(bArr, 0, iRemaining);
        buffer3.get(bArr, iRemaining, iRemaining3);
        buffer2.get(bArr, i - iRemaining2, iRemaining2);
        return bArr;
    }

    public static byte[] byteToNv21(byte[] bArr) {
        int length = bArr.length;
        int i = (length * 2) / 3;
        int i2 = length - i;
        int i3 = length / 6;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 % 2 == 0) {
                bArr2[i + i4] = bArr[(i4 / 2) + i];
            } else {
                bArr2[i + i4] = bArr[i + i3 + (i4 / 2)];
            }
        }
        return bArr2;
    }

    public static byte[] bitmapToNv21(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.getWidth() < i || bitmap.getHeight() < i2) {
            return new byte[0];
        }
        int[] iArr = new int[i * i2];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        return argbToNv21(iArr, i, i2);
    }

    private static byte[] argbToNv21(int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = 0;
            while (i8 < i) {
                int i9 = iArr[i6];
                int i10 = (16711680 & i9) >> 16;
                int i11 = (65280 & i9) >> 8;
                int i12 = 255;
                int i13 = i9 & 255;
                int i14 = (((((i10 * 66) + (i11 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                int i15 = (((((i10 * (-38)) - (i11 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                int i16 = (((((i10 * 112) - (i11 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                int i17 = i5 + 1;
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 255) {
                    i14 = 255;
                }
                bArr[i5] = (byte) i14;
                if (i7 % 2 == 0 && i6 % 2 == 0 && i3 < i4 - 2) {
                    int i18 = i3 + 1;
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 > 255) {
                        i16 = 255;
                    }
                    bArr[i3] = (byte) i16;
                    i3 += 2;
                    if (i15 < 0) {
                        i12 = 0;
                    } else if (i15 <= 255) {
                        i12 = i15;
                    }
                    bArr[i18] = (byte) i12;
                }
                i6++;
                i8++;
                i5 = i17;
            }
        }
        return bArr;
    }

    public static byte[] nv21ToGray(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 2;
        byte[] bArr2 = new byte[i4];
        Arrays.fill(bArr2, (byte) -128);
        System.arraycopy(bArr2, 0, bArr, i3, i4);
        return bArr;
    }

    private static boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 35 || format == 17 || format == 842094169;
    }

    public static byte[] getDataFromImage(Image image, int i) {
        int i2;
        checkFormat(image, i);
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int iWidth = cropRect.width();
        int iHeight = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i3 = iWidth * iHeight;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i3) / 8];
        int i4 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i5 = 0;
        while (i5 < planes.length) {
            ByteBuffer buffer = planes[i5].getBuffer();
            int rowStride = planes[i5].getRowStride();
            int pixelStride = planes[i5].getPixelStride();
            int channelOffset = getChannelOffset(i5, i, i3);
            int outputStride = getOutputStride(i5, i);
            int i6 = i5 == 0 ? i4 : 1;
            int i7 = iWidth >> i6;
            int i8 = iHeight >> i6;
            int i9 = iWidth;
            buffer.position(((cropRect.top >> i6) * rowStride) + ((cropRect.left >> i6) * pixelStride));
            int i10 = 0;
            while (i10 < i8) {
                if (pixelStride != 1 || outputStride != 1) {
                    i2 = ((i7 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i11 = 0; i11 < i7; i11++) {
                        bArr[channelOffset] = bArr2[i11 * pixelStride];
                        channelOffset += outputStride;
                    }
                } else {
                    buffer.get(bArr, channelOffset, i7);
                    channelOffset += i7;
                    i2 = i7;
                }
                if (i10 < i8 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
                i10++;
                cropRect = cropRect;
            }
            i5++;
            iWidth = i9;
            i4 = 0;
        }
        return bArr;
    }

    private static void checkFormat(Image image, int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("only support YUV_FORMAT_I420 and YUV_FORMAT_NV21");
        }
        if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
    }
}
