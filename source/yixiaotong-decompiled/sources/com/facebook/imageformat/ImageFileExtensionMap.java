package com.facebook.imageformat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ImageFileExtensionMap {
    private ImageFileExtensionMap() {
    }

    /* JADX INFO: renamed from: com.facebook.imageformat.ImageFileExtensionMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imageformat$ImageFormat;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            $SwitchMap$com$facebook$imageformat$ImageFormat = iArr;
            try {
                iArr[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_ANIMATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.PNG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.GIF.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.BMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String getFileExtension(ImageFormat imageFormat) throws UnsupportedOperationException {
        switch (AnonymousClass1.$SwitchMap$com$facebook$imageformat$ImageFormat[imageFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "webp";
            case 6:
                return "jpeg";
            case 7:
                return "png";
            case 8:
                return "gif";
            case 9:
                return "bmp";
            default:
                throw new UnsupportedOperationException("Unknown image format " + imageFormat.name());
        }
    }
}
