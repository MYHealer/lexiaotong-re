package org.videolan.libvlc.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HWDecoderUtil {
    private static final AudioOutputBySOC[] sAudioOutputBySOCList;
    private static final DecoderBySOC[] sBlacklistedDecoderBySOCList;
    private static final DecoderBySOC[] sDecoderBySOCList;
    private static final HashMap<String, String> sSystemPropertyMap;

    public enum AudioOutput {
        OPENSLES,
        AUDIOTRACK,
        ALL
    }

    public static class AudioOutputBySOC {
        public final AudioOutput aout;
        public final String key;
        public final String value;

        public AudioOutputBySOC(String str, String str2, AudioOutput audioOutput) {
            this.key = str;
            this.value = str2;
            this.aout = audioOutput;
        }
    }

    public enum Decoder {
        UNKNOWN,
        NONE,
        OMX,
        MEDIACODEC,
        ALL
    }

    public static class DecoderBySOC {
        public final Decoder dec;
        public final String key;
        public final String value;

        public DecoderBySOC(String str, String str2, Decoder decoder) {
            this.key = str;
            this.value = str2;
            this.dec = decoder;
        }
    }

    static {
        Decoder decoder = Decoder.NONE;
        sBlacklistedDecoderBySOCList = new DecoderBySOC[]{new DecoderBySOC(s.d(new byte[]{Ascii.SYN, 12, Ascii.RS, Ascii.DC4, 71, 10, 5, 17, 5, Ascii.SYN, Ascii.US, 7, 11, 2, 66, 0}, "dc0d5e"), s.d(new byte[]{123, 100, 122, 13, 7, 7, 84}, "677555"), decoder), new DecoderBySOC(s.d(new byte[]{69, 91, Ascii.SYN, Ascii.DC2, Ascii.DC4, 95, 5, 17, 5, Ascii.SYN, Ascii.US, 7, 88, 85, 74, 6}, "748bf0"), s.d(new byte[]{9, 3, 67, 2, 90, 95}, "ab4c36"), decoder)};
        Decoder decoder2 = Decoder.MEDIACODEC;
        Decoder decoder3 = Decoder.OMX;
        Decoder decoder4 = Decoder.ALL;
        sDecoderBySOCList = new DecoderBySOC[]{new DecoderBySOC(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 90, 75, 17, Ascii.SYN, 94, 5, 17, 5, Ascii.SYN, Ascii.US, 7, SignedBytes.MAX_POWER_OF_TWO, 84, 11, 5}, "25ead1"), s.d(new byte[]{103, 113, 116, 114}, "44918d"), decoder), new DecoderBySOC(s.d(new byte[]{17, 93, Ascii.RS, 82, 87, 89, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.ETB, 84, 95, 66, 85}, "c20088"), s.d(new byte[]{9, 69, 92, 4, 87, 86, 86}, "d613ad"), decoder), new DecoderBySOC(s.d(new byte[]{75, 95, Ascii.FS, 66, 71, 10, 5, 17, 5, Ascii.SYN, Ascii.US, 7, 75, 81, 92, 86}, "90225e"), s.d(new byte[]{34, 93, 3, Ascii.FS, 94, 91}, "c0bf15"), decoder2), new DecoderBySOC(s.d(new byte[]{68, 88, 26, 81, 11, 85, 19, 0, 72, Ascii.DC2, 93, 4, 66, 81, 91, 65, 9}, "6743d4"), s.d(new byte[]{12, 12, 89, 70, 0}, "ca8632"), decoder3), new DecoderBySOC(s.d(new byte[]{70, 12, Ascii.EM, 83, 88, 88, 19, 0, 72, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 5, 88, 67, 90}, "4c7179"), s.d(new byte[]{Ascii.SYN, 93, 87, 95, 86, 88, 8, Ascii.DC4}, "d24450"), decoder3), new DecoderBySOC(s.d(new byte[]{Ascii.SYN, 87, Ascii.EM, 3, 93, 85, 19, 0, 72, Ascii.DC2, 93, 4, 16, 94, 88, 19, 95}, "d87a24"), s.d(new byte[]{74, 90, 86, 93}, "81ddbf"), decoder3), new DecoderBySOC(s.d(new byte[]{70, 13, Ascii.US, 82, 14, 4, 19, 0, 72, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 4, 94, 66, 12}, "4b10ae"), s.d(new byte[]{12, 66, 93, 1, 87, 86, 81}, "a106ae"), decoder3), new DecoderBySOC(s.d(new byte[]{16, 88, 72, 87, 12, 3, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.SYN, 81, 9, 71, 14}, "b7f5cb"), s.d(new byte[]{17, 6, 69, 86}, "b355f6"), decoder3), new DecoderBySOC(s.d(new byte[]{17, 9, Ascii.CAN, 83, 11, 85, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.ETB, 0, 89, 67, 9}, "cf61d4"), s.d(new byte[]{11, 11, 88, 65, 81, 93, 0, 10, 5}, "fd6531"), decoder3), new DecoderBySOC(s.d(new byte[]{16, 93, 79, 85, 14, 83, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.SYN, 84, 14, 69, 12}, "b2a7a2"), s.d(new byte[]{7, Ascii.RS, 93, 66, 89, 91, 5}, "bf9062"), decoder3), new DecoderBySOC(s.d(new byte[]{70, 87, Ascii.CAN, 82, 89, 84, 19, 0, 72, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 94, 89, 66, 91}, "486065"), s.d(new byte[]{16, 69, 92, 1, 15}, "c027fc"), decoder3), new DecoderBySOC(s.d(new byte[]{19, 88, Ascii.EM, 87, 86, 80, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.NAK, 81, 88, 71, 84}, "a77591"), s.d(new byte[]{4, 65, 26, 93, 87, Ascii.NAK, 85}, "a9c38f"), decoder2), new DecoderBySOC(s.d(new byte[]{70, 14, Ascii.GS, 86, 89, 88, 19, 0, 72, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 7, 92, 70, 91}, "4a3469"), s.d(new byte[]{11, 9, 5, Ascii.DC4, 7}, "dddd38"), decoder4), new DecoderBySOC(s.d(new byte[]{19, 86, 72, 6, 9, 87, 19, 0, 72, Ascii.DC2, 93, 4, Ascii.NAK, 95, 9, Ascii.SYN, 11}, "a9fdf6"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 80, 86, 65, 88}, "451395"), decoder4), new DecoderBySOC(s.d(new byte[]{70, 11, 75, 0, 92, 88, 19, 0, 72, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 2, 10, 16, 94}, "4deb39"), s.d(new byte[]{16, 0, 85, Ascii.ETB, 0, 7}, "de2ea4"), decoder4), new DecoderBySOC(s.d(new byte[]{67, 87, 79, 90, 11, 0, 19, 0, 72, Ascii.DC2, 93, 4, 69, 94, 14, 74, 9}, "18a8da"), s.d(new byte[]{9, 66, 14, 94, 6, 2, 81}, "d1cf04"), decoder4), new DecoderBySOC(s.d(new byte[]{68, 89, 75, 0, 10, 81, 19, 0, 72, Ascii.DC2, 93, 4, 66, 80, 10, 16, 8}, "66ebe0"), s.d(new byte[]{1, 65, 75, 93, 89, 65, 84}, "d92362"), decoder4), new DecoderBySOC(s.d(new byte[]{68, 12, 74, 6, 93, 0, 19, 0, 72, Ascii.DC2, 93, 4, 66, 5, 11, Ascii.SYN, 95}, "6cdd2a"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 8, 7, 82}, "2c4bfc"), decoder4), new DecoderBySOC(s.d(new byte[]{68, 13, Ascii.CAN, 90, 89, 80, 19, 0, 72, Ascii.DC2, 93, 4, 66, 4, 89, 74, 91}, "6b6861"), s.d(new byte[]{Ascii.ETB, 13, 11, 7}, "ef8691"), decoder4), new DecoderBySOC(s.d(new byte[]{Ascii.ETB, 93, Ascii.US, 90, 90, 7, 19, 0, 72, Ascii.DC2, 93, 4, 17, 84, 94, 74, 88}, "e2185f"), s.d(new byte[]{8, 68, 9, 9, 92, 87, 82, 85, 86, 82}, "e21182"), decoder4), new DecoderBySOC(s.d(new byte[]{16, 87, Ascii.ETB, 92, 80, 69, 5, 19, 7, 16, 84}, "b89417"), s.d(new byte[]{9, 65, 14, 81}, "d56b6a"), decoder4)};
        AudioOutput audioOutput = AudioOutput.OPENSLES;
        sAudioOutputBySOCList = new AudioOutputBySOC[]{new AudioOutputBySOC(s.d(new byte[]{65, 10, Ascii.SYN, 73, 65, 89, 5, 17, 5, Ascii.SYN, Ascii.US, 7, 65, 4, 86, 93}, "3e8936"), s.d(new byte[]{118, 89, 5, 78, 88, 10}, "74d47d"), audioOutput), new AudioOutputBySOC(s.d(new byte[]{69, 89, Ascii.US, 71, 66, 95, 5, 17, 5, Ascii.SYN, Ascii.US, 8, 86, 88, 68, 81, 81, 83, Ascii.NAK, 17, Ascii.DC4, 7, 67}, "761700"), s.d(new byte[]{119, 12, 83, 77, 93, 87}, "6a2729"), audioOutput)};
        sSystemPropertyMap = new HashMap<>();
    }

    public static AudioOutput getAudioOutputFromDevice() {
        for (AudioOutputBySOC audioOutputBySOC : sAudioOutputBySOCList) {
            String systemPropertyCached = getSystemPropertyCached(audioOutputBySOC.key);
            if (systemPropertyCached != null && systemPropertyCached.contains(audioOutputBySOC.value)) {
                return audioOutputBySOC.aout;
            }
        }
        return AudioOutput.ALL;
    }

    public static Decoder getDecoderFromDevice() {
        for (DecoderBySOC decoderBySOC : sBlacklistedDecoderBySOCList) {
            String systemPropertyCached = getSystemPropertyCached(decoderBySOC.key);
            if (systemPropertyCached != null && systemPropertyCached.contains(decoderBySOC.value)) {
                return decoderBySOC.dec;
            }
        }
        if (AndroidUtil.isJellyBeanMR2OrLater) {
            return Decoder.ALL;
        }
        for (DecoderBySOC decoderBySOC2 : sDecoderBySOCList) {
            String systemPropertyCached2 = getSystemPropertyCached(decoderBySOC2.key);
            if (systemPropertyCached2 != null && systemPropertyCached2.contains(decoderBySOC2.value)) {
                return decoderBySOC2.dec;
            }
        }
        return Decoder.UNKNOWN;
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(s.d(new byte[]{4, 90, 93, 67, 91, 89, 5, 74, 9, 17, Ascii.US, 54, Ascii.FS, 71, 77, 84, 89, 96, 19, 11, Ascii.SYN, 7, 67, 17, 12, 81, 74}, "e49140"));
            return (String) clsLoadClass.getMethod(s.d(new byte[]{86, 1, Ascii.SYN}, "1db77f"), String.class, String.class).invoke(clsLoadClass, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    private static String getSystemPropertyCached(String str) {
        HashMap<String, String> map = sSystemPropertyMap;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String systemProperty = getSystemProperty(str, s.d(new byte[]{92, 9, 92, 85}, "2f209a"));
        map.put(str, systemProperty);
        return systemProperty;
    }
}
