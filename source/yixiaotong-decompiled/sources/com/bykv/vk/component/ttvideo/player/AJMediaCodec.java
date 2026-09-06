package com.bykv.vk.component.ttvideo.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.ml.camera.CountryCodeBean;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "aj_media_codec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private MediaCodec.BufferInfo mBufferInfo;
    private Surface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
                return str3;
            } catch (Exception e) {
                m.c(e);
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public AJMediaCodec() {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        m.c(TAG, "initialize, need workaround " + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    private boolean isHisiByteVC1BlockList() {
        double d;
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (!property.startsWith("kirin960") && !property.startsWith("hi3660")) {
            return false;
        }
        try {
            d = Double.parseDouble(getProperty(VERSION_PROPERTY, "0.0"));
        } catch (NumberFormatException unused) {
            m.tt(TAG, "vendor property abnormal");
            d = 0.0d;
        }
        return d < FIX_VERSION;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
            m.c(TAG, "oppo property = ".concat(String.valueOf(property)));
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                m.tt(TAG, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    public int createByCodecName(String str) {
        m.c(TAG, "createByCodecName = ".concat(String.valueOf(str)));
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), byteBuffer);
    }

    private void createDummySurface() {
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10) {
        Surface surface2 = surface;
        int i11 = i6;
        int i12 = i7;
        m.c(TAG, "configure =" + surface2 + ", surfaceConfigure =" + z);
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        maybeSetInteger(mediaFormat, "width", i);
        maybeSetInteger(mediaFormat, "height", i2);
        if (i11 != -1 && i12 != -1) {
            if (i11 <= i) {
                i11 = i;
            }
            maybeSetInteger(mediaFormat, "max-width", i11);
            if (i12 <= i2) {
                i12 = i2;
            }
            maybeSetInteger(mediaFormat, "max-height", i12);
        }
        maybeSetInteger(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, i4);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, i5);
        m.c(TAG, "format  = ".concat(String.valueOf(mediaFormat)));
        int maxInputSize = getMaxInputSize(str, i, i2);
        m.c(TAG, "max input = ".concat(String.valueOf(maxInputSize)));
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z) {
            if (Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            if ((surface2 == null || !surface.isValid()) && this.mDummySurface == null && Util.SDK_INT >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                m.c(TAG, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (Util.SDK_INT >= 23 && z2) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            VendorQTI.setupVpp(mediaFormat, i8);
        }
        if (z4) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z5) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i10 > 0 && i9 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i9, i10);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split("\\."));
            if (dolbyVisionProfileAndLevel != null) {
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public int start() {
        m.c(TAG, "start");
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            m.c(TAG, "start end");
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    public int open(int i, int i2, int i3, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        m.c(TAG, "open, rotation = " + i3 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            m.c(TAG, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString("mime", str2);
            maybeSetInteger(mediaFormat, "width", i);
            maybeSetInteger(mediaFormat, "height", i2);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            m.c(TAG, "mediacodec start");
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            this.mInputBuffersValid = true;
            String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2));
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int stop() {
        if (this.mInputBuffersValid) {
            m.c(TAG, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            Surface surface = this.mDummySurface;
            if (surface != null) {
                surface.release();
                this.mDummySurface = null;
            }
            m.c(TAG, "codec release end");
        } catch (Exception unused) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            m.c(TAG, "codec release end");
        } catch (Throwable th) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            m.c(TAG, "codec release end");
            throw th;
        }
    }

    public void close() {
        m.c(TAG, "close start");
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            this.mMediaCodec = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJMediaCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.c(AJMediaCodec.TAG, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable unused) {
                m.tt(TAG, "new thread failed");
                releaseCodec(mediaCodec);
            }
        }
        m.c(TAG, "close end");
    }

    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception unused) {
            return CODEC_ERROR;
        }
    }

    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                codecException.isRecoverable();
                codecException.getErrorCode();
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                codecException.isRecoverable();
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        return exc instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        return exc instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int setOutputSurface(Surface surface) {
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            m.c(TAG, "use dummy surface");
        }
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame != null && aJMediaCodecFrame.data != null) {
            try {
                int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(INPUT_TIMEOUT_US);
                if (iDequeueInputBuffer < 0) {
                    return iDequeueInputBuffer == -1 ? 4 : -1;
                }
                this.mInputBuffers[iDequeueInputBuffer].put(aJMediaCodecFrame.data);
                this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                return 0;
            } catch (Exception e) {
                m.uj(TAG, "write meet exception =".concat(String.valueOf(e)));
            }
        }
        return -1;
    }

    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) {
        while (true) {
            try {
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (iDequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[iDequeueOutputBuffer];
                    aJMediaCodecFrame.pts = this.mBufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = iDequeueOutputBuffer;
                    aJMediaCodecFrame.size = this.mBufferInfo.size;
                    aJMediaCodecFrame.flags = this.mBufferInfo.flags;
                    return 0;
                }
                if (iDequeueOutputBuffer != -3) {
                    if (iDequeueOutputBuffer != -2) {
                        if (iDequeueOutputBuffer != -1) {
                            m.uj(TAG, "error, idx = ".concat(String.valueOf(iDequeueOutputBuffer)));
                        }
                        return -1;
                    }
                    m.c(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers == null) {
                            try {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            } catch (Exception e) {
                                m.c(TAG, "getOutputBuffers e = ".concat(String.valueOf(e)));
                                return handleCodecException(e);
                            }
                        }
                        return iDequeueOutputBuffer;
                    } catch (Exception e2) {
                        m.c(TAG, "getOutputFormat e =".concat(String.valueOf(e2)));
                        return handleCodecException(e2);
                    }
                }
                m.c(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                } catch (Exception e3) {
                    m.c(TAG, "getOutputBuffers e = ".concat(String.valueOf(e3)));
                    return handleCodecException(e3);
                }
            } catch (Exception e4) {
                m.c(TAG, "dequeueOutputBuffer e :".concat(String.valueOf(e4)));
                return handleCodecException(e4);
            }
        }
    }

    public void flush() {
        m.c(TAG, "flush");
        try {
            this.mMediaCodec.flush();
        } catch (Exception unused) {
        }
        m.c(TAG, "flush done");
    }

    public int releaseBuffer(int i, boolean z, long j) {
        if (Util.SDK_INT >= 21 && z) {
            return renderOutputBufferV21(i, j);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    public void speedEnhance(float f) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f <= 30.0f) {
            return;
        }
        m.c(TAG, "rate ".concat(String.valueOf(f)));
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            m.tt(TAG, "setParameters failed ret = ".concat(String.valueOf(e)));
        }
    }

    public void decodeFRC(int i) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        m.c(TAG, "frc level = ".concat(String.valueOf(i)));
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            m.tt(TAG, "setParameters failed ret = ".concat(String.valueOf(e)));
        }
    }

    public String getBestCodecName(String str) {
        String[] supportedTypes;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16 || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(MimeTypes.VIDEO_H265) && mIsByteVC1Blocklist) {
            m.tt(TAG, "the device is hw decoder blocklist," + Util.HARDWARE);
            return null;
        }
        m.c(TAG, "detect hardware codec by codecType = ".concat(String.valueOf(str)));
        ArrayList<AJMediaCodecRank> arrayList = new ArrayList();
        synchronized (mCodecListLock) {
            try {
                boolean z = !mVideoHWDecoderCodecs.isEmpty();
                try {
                    int size = z ? mVideoHWDecoderCodecs.size() : MediaCodecList.getCodecCount();
                    for (int i = 0; i < size && (!z || arrayList.isEmpty()); i++) {
                        MediaCodecInfo codecInfoAt = z ? mVideoHWDecoderCodecs.get(i) : MediaCodecList.getCodecInfoAt(i);
                        String name = codecInfoAt.getName();
                        if (!codecInfoAt.isEncoder() && !name.startsWith("OMX.google") && !name.startsWith("c2.android") && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                            for (String str2 : supportedTypes) {
                                if (!TextUtils.isEmpty(str2)) {
                                    if (!z && str2.startsWith("video/")) {
                                        mVideoHWDecoderCodecs.add(codecInfoAt);
                                    }
                                    if (str2.equalsIgnoreCase(str) && ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains(ClientCookie.SECURE_ATTR) && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(codecInfoAt, str)) != null))) {
                                        m.c(TAG, "codec : " + aJMediaCodecRank.mMediaCodecInfo.getName() + ",  rank : " + aJMediaCodecRank.mRank);
                                        if (aJMediaCodecRank.mRank == 40 && Util.SDK_INT < 21) {
                                            m.tt(TAG, "skip vendor mediacodec api impl ambiguous");
                                        } else if (aJMediaCodecRank.mRank == 20) {
                                            m.tt(TAG, "skip vendor software codec");
                                        } else {
                                            arrayList.add(aJMediaCodecRank);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    AJMediaCodecRank aJMediaCodecRank2 = (AJMediaCodecRank) arrayList.get(0);
                    for (AJMediaCodecRank aJMediaCodecRank3 : arrayList) {
                        if (aJMediaCodecRank3.mRank > aJMediaCodecRank2.mRank) {
                            aJMediaCodecRank2 = aJMediaCodecRank3;
                        }
                    }
                    return aJMediaCodecRank2.mMediaCodecInfo.getName();
                } catch (Exception unused) {
                    m.tt(TAG, "mediaserver died");
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:49:0x0087, B:50:0x0089, B:10:0x0018, B:12:0x001c, B:34:0x005d, B:39:0x006e, B:42:0x0078, B:33:0x005b, B:19:0x0035, B:22:0x003f, B:25:0x0049, B:51:0x008b), top: B:57:0x0003 }] */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        byte b;
        synchronized (AJMediaCodec.class) {
            if (!mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                if (Util.SDK_INT <= 27 && "dangal".equals(Util.DEVICE)) {
                    mDeviceNeedsSetOutputSurfaceWorkaround = true;
                } else if (Util.SDK_INT < 27) {
                    String str = Util.DEVICE;
                    int iHashCode = str.hashCode();
                    byte b2 = 0;
                    if (iHashCode != 99329) {
                        if (iHashCode != 3351335) {
                            if (iHashCode == 1865889110 && str.equals("santoni")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("mido")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (str.equals("deb")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0 || b == 1 || b == 2) {
                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                    }
                    String str2 = Util.MODEL;
                    int iHashCode2 = str2.hashCode();
                    if (iHashCode2 != 2006354) {
                        if (iHashCode2 == 2006367 && str2.equals("AFTN")) {
                            b2 = 1;
                        } else {
                            b2 = -1;
                        }
                    } else if (!str2.equals("AFTA")) {
                        b2 = -1;
                    }
                    if (b2 == 0 || b2 == 1) {
                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                    }
                }
                mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            m.tt(TAG, "setoutputsurface failed = ".concat(String.valueOf(e)));
            return -1;
        }
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    private static int getMaxInputSize(String str, int i, int i2) {
        int iCeilDivide;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        if (str.equals(MimeTypes.VIDEO_H263) || str.equals(MimeTypes.VIDEO_MP4V)) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else if (str.equals(MimeTypes.VIDEO_H264)) {
            if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            }
            iCeilDivide = ceilDivide(i, 16) * ceilDivide(i2, 16) * 256;
            i3 = 2;
        } else if (str.equals(MimeTypes.VIDEO_VP8)) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else {
            if (!str.equals(MimeTypes.VIDEO_H265) && !str.equals(MimeTypes.VIDEO_VP9)) {
                return -1;
            }
            iCeilDivide = i * i2;
            i3 = 4;
        }
        return (iCeilDivide * 3) / (i3 * 2);
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        if (Util.SDK_INT < 18) {
            return true;
        }
        if (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }
}
