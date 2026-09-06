package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    public BaseImageDecoder(boolean z) {
        this.loggingEnabled = z;
    }

    @Override // com.kwad.sdk.core.imageloader.core.decode.ImageDecoder
    public DecodedResult decode(ImageDecodingInfo imageDecodingInfo) {
        DecodedResult decodedResult = new DecodedResult();
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            if (imageDecodingInfo.getLoadListener() == null || !imageDecodingInfo.getLoadListener().onDecode(imageDecodingInfo.getImageUri(), imageStream, decodedResult)) {
                ImageFileInfo imageFileInfoDefineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
                imageStream = resetStream(imageStream, imageDecodingInfo);
                decodedResult.mBitmap = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(imageFileInfoDefineImageSizeAndRotation.imageSize, imageDecodingInfo));
                b.closeQuietly(imageStream);
                if (decodedResult.mBitmap == null && decodedResult.mFrameSequence == null) {
                    L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
                } else {
                    decodedResult.mBitmap = considerExactScaleAndOrientatiton(decodedResult.mBitmap, imageDecodingInfo, imageFileInfoDefineImageSizeAndRotation.exif.rotation, imageFileInfoDefineImageSizeAndRotation.exif.flipHorizontal);
                }
                return decodedResult;
            }
            b.closeQuietly(imageStream);
            return decodedResult;
        } catch (Throwable th) {
            b.closeQuietly(imageStream);
            throw th;
        }
    }

    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        ExifInfo exifInfo;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        if (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exifInfo = defineExifOrientation(imageUri);
        } else {
            exifInfo = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    private boolean canDefineExifParams(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected ExifInfo defineExifOrientation(String str) {
        boolean z;
        int i;
        int i2 = 0;
        try {
            boolean z2 = true;
            switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
                case 1:
                    z2 = false;
                    z = z2;
                    break;
                case 2:
                    z = z2;
                    break;
                case 3:
                    i = 180;
                    int i3 = i2;
                    i2 = i;
                    z = i3;
                    break;
                case 4:
                    i2 = 1;
                    i = 180;
                    int i4 = i2;
                    i2 = i;
                    z = i4;
                    break;
                case 5:
                    i2 = 1;
                    i = 270;
                    int i5 = i2;
                    i2 = i;
                    z = i5;
                    break;
                case 6:
                    i = 90;
                    int i6 = i2;
                    i2 = i;
                    z = i6;
                    break;
                case 7:
                    i2 = 1;
                    i = 90;
                    int i7 = i2;
                    i2 = i;
                    z = i7;
                    break;
                case 8:
                    i = 270;
                    int i8 = i2;
                    i2 = i;
                    z = i8;
                    break;
                default:
                    z = 0;
                    break;
            }
        } catch (IOException unused) {
            L.w("Can't read EXIF tags from file [%s]", str);
        }
        return new ExifInfo(i2, z);
    }

    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        int iComputeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            iComputeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            iComputeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            iComputeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (iComputeImageSampleSize > 1 && this.loggingEnabled) {
            L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(iComputeImageSampleSize), Integer.valueOf(iComputeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = iComputeImageSampleSize;
        return decodingOptions;
    }

    protected InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        b.closeQuietly(inputStream);
        return getImageStream(imageDecodingInfo);
    }

    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            float fComputeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(fComputeImageScale, 1.0f) != 0) {
                matrix.setScale(fComputeImageScale, fComputeImageScale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(fComputeImageScale), Float.valueOf(fComputeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(i), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i, boolean z) {
            this.rotation = i;
            this.flipHorizontal = z;
        }
    }

    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }
}
