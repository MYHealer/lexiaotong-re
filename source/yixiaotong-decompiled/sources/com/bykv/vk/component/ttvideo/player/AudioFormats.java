package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {4000, 8000, 11025, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 22050, 32000, 37800, 44056, SWCommandUtil.SampleRate, 47250, OpusUtil.SAMPLE_RATE, 50000, 50400, 88200, 96000, 176400, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length - 3;
        for (int i = 0; i < length; i++) {
            iArr[i] = validSampleRates[i];
        }
        return length;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
