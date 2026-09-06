package com.google.zxing.datamatrix.encoder;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 134, 240, 92, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE}, new int[]{28, 24, 185, 166, 223, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 116, 255, 110, 61}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 138, 205, 12, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, Opcodes.JSR, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 213, 97, 178, 100, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE}, new int[]{156, 97, 192, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 95, 9, 157, 119, 138, 45, 18, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 83, 185}, new int[]{83, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 100, 39, 188, 75, 66, 61, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 213, 109, 129, 94, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, JfifUtil.MARKER_APP1, 48, 90, 188}, new int[]{15, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 9, 233, 71, Opcodes.JSR, 2, 188, 160, 153, 145, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 79, 108, 82, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 172}, new int[]{52, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 88, 205, 109, 39, 176, 21, 155, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 223, 155, 21, 5, 172, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 12, 181, 184, 96, 50, 193}, new int[]{211, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 43, 97, 71, 96, 103, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 37, 151, 170, 53, 75, 34, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 121, 17, 138, 110, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 120, 151, 233, Opcodes.JSR, 93, 255}, new int[]{245, 127, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, JfifUtil.MARKER_SOS, 130, 250, 162, 181, 102, 120, 84, 179, 220, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 80, 182, 229, 18, 2, 4, 68, 33, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 95, 119, 115, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 184, 59, 25, JfifUtil.MARKER_APP1, 98, 81, 112}, new int[]{77, 193, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 31, 19, 38, 22, 153, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 105, 122, 2, 245, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 57, 54, 101, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, AppTypeIdUtil.Drink4GCostControl_1, 22, 238, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 238, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 205, 188, 237, 87, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 240, 82, 44, 176, 87, 187, 147, 160, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 69, 213, 92, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, JfifUtil.MARKER_APP1, 19}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 9, 223, 238, 12, 17, 220, 208, 100, 29, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 170, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, JfifUtil.MARKER_SOS, 234, AppTypeIdUtil.Drink4GCostControl_1, 203, 29, 232, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 238, 22, 150, 201, AppTypeIdUtil.Drink4GCostControl_1, 62, 207, 164, 13, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 245, 127, 67, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 28, 155, 43, 203, 107, 233, 53, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 46}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 93, Opcodes.RET, 50, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 210, 39, 118, 202, 188, 201, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 108, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 37, 185, 112, 134, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 245, 63, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 250, 106, 185, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 64, 114, 71, 161, 44, 147, 6, 27, JfifUtil.MARKER_SOS, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 86, 47, 11, 204}, new int[]{220, 228, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 89, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, Opcodes.FCMPL, 159, 56, 89, 33, 147, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 154, 36, 73, 127, 213, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 180, 234, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 223, 239, 181, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i *= 2;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, strCreateECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt != 0 && (i5 = iArr2[i9]) != 0) {
                    char c = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c);
                } else {
                    cArr[i9] = cArr[i9 - 1];
                }
                i9--;
            }
            if (iCharAt != 0 && (i4 = iArr2[0]) != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
