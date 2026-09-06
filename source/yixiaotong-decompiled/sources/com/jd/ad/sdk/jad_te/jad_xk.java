package com.jd.ad.sdk.jad_te;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_xk<T> implements com.jd.ad.sdk.jad_ju.jad_ly<T, Bitmap> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Long> jad_dq = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new jad_an());
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Integer> jad_er = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new jad_bo());
    public static final jad_er jad_fs = new jad_er();
    public final jad_fs<T> jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_bo;
    public final jad_er jad_cp;

    public class jad_an implements com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<Long> {
        public final ByteBuffer jad_an = ByteBuffer.allocate(8);

        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(byte[] bArr, Long l, MessageDigest messageDigest) {
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.jad_an) {
                this.jad_an.position(0);
                messageDigest.update(this.jad_an.putLong(l2.longValue()).array());
            }
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<Integer> {
        public final ByteBuffer jad_an = ByteBuffer.allocate(4);

        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(byte[] bArr, Integer num, MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.jad_an) {
                this.jad_an.position(0);
                messageDigest.update(this.jad_an.putInt(num2.intValue()).array());
            }
        }
    }

    public static final class jad_cp implements jad_fs<AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    public static final class jad_dq implements jad_fs<ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new jad_yl(this, byteBuffer));
        }
    }

    public static class jad_er {
    }

    public interface jad_fs<T> {
        void jad_an(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class jad_hu extends RuntimeException {
        public jad_hu() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public static final class jad_jt implements jad_fs<ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public jad_xk(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, jad_fs<T> jad_fsVar, jad_er jad_erVar2) {
        this.jad_bo = jad_erVar;
        this.jad_an = jad_fsVar;
        this.jad_cp = jad_erVar2;
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<AssetFileDescriptor, Bitmap> jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_cp(), jad_fs);
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<ByteBuffer, Bitmap> jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_dq(), jad_fs);
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<ParcelFileDescriptor, Bitmap> jad_cp(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_jt(), jad_fs);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(T t, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(T t, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) throws IOException {
        int i3;
        long jLongValue = ((Long) jad_jwVar.jad_an(jad_dq)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) jad_jwVar.jad_an(jad_er);
        if (num == null) {
            num = 2;
        }
        jad_iv jad_ivVar = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        if (jad_ivVar == null) {
            jad_ivVar = jad_iv.jad_cp;
        }
        jad_iv jad_ivVar2 = jad_ivVar;
        this.jad_cp.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.jad_an.jad_an(mediaMetadataRetriever, t);
            Bitmap bitmapJad_an = jad_an(mediaMetadataRetriever, jLongValue, num.intValue(), i, i2, jad_ivVar2);
            return com.jd.ad.sdk.jad_te.jad_er.jad_an(bitmapJad_an, this.jad_bo);
        } finally {
            i3 = Build.VERSION.SDK_INT;
            mediaMetadataRetriever.release();
        }
    }

    public static Bitmap jad_an(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, jad_iv jad_ivVar) {
        Bitmap frameAtTime = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && jad_ivVar != jad_iv.jad_bo) {
            try {
                int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (i6 == 90 || i6 == 270) {
                    i5 = i4;
                    i4 = i5;
                }
                float fJad_bo = jad_ivVar.jad_bo(i4, i5, i2, i3);
                frameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fJad_bo), Math.round(fJad_bo * i5));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Logger.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                }
            }
        }
        if (frameAtTime == null) {
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new jad_hu();
    }
}
