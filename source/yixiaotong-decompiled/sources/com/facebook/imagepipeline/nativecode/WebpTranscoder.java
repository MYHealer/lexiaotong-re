package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.webp.WebpSupportStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class WebpTranscoder {
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    static {
        ImagePipelineNativeLoader.load();
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.nativecode.WebpTranscoder$1, reason: invalid class name */
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
        }
    }

    public static boolean isWebpNativelySupported(ImageFormat imageFormat) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$imageformat$ImageFormat[imageFormat.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2 || i == 3 || i == 4) {
            return WebpSupportStatus.sIsExtendedWebpSupported;
        }
        if (i != 5) {
            Preconditions.checkArgument(false);
        }
        return false;
    }

    public static void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        nativeTranscodeWebpToJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i);
    }

    public static void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException {
        nativeTranscodeWebpToPng((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream));
    }
}
