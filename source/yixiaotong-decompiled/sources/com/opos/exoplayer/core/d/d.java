package com.opos.exoplayer.core.d;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.i.y;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {
    private static final SparseIntArray d;
    private static final SparseIntArray e;
    private static final Map<String, Integer> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.opos.exoplayer.core.d.a f6378a = com.opos.exoplayer.core.d.a.a("OMX.google.raw.decoder");
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<c, List<com.opos.exoplayer.core.d.a>> c = new HashMap<>();
    private static int g = -1;

    public static class a extends com.opos.exoplayer.core.i.b {
        private a(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        /* synthetic */ a(Throwable th, b bVar) {
            this(th);
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "DecoderQueryException";
        }
    }

    static /* synthetic */ class b {
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6379a;
        public final boolean b;

        public c(String str, boolean z) {
            this.f6379a = str;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != c.class) {
                return false;
            }
            c cVar = (c) obj;
            return TextUtils.equals(this.f6379a, cVar.f6379a) && this.b == cVar.b;
        }

        public int hashCode() {
            String str = this.f6379a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.d.d$d, reason: collision with other inner class name */
    private interface InterfaceC0915d {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    private static final class e implements InterfaceC0915d {
        private e() {
        }

        /* synthetic */ e(b bVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return MimeTypes.VIDEO_H264.equals(str);
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public boolean b() {
            return false;
        }
    }

    private static final class f implements InterfaceC0915d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6380a;
        private MediaCodecInfo[] b;

        public f(boolean z) {
            this.f6380a = z ? 1 : 0;
        }

        private void c() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f6380a).getCodecInfos();
            }
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public int a() {
            c();
            return this.b.length;
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public MediaCodecInfo a(int i) {
            c();
            return this.b[i];
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.opos.exoplayer.core.d.d.InterfaceC0915d
        public boolean b() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", 4096);
        map.put("L150", 16384);
        map.put("L153", 65536);
        map.put("L156", 262144);
        map.put("L180", 1048576);
        map.put("L183", 4194304);
        map.put("L186", 16777216);
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", 512);
        map.put("H120", 2048);
        map.put("H123", 8192);
        map.put("H150", 32768);
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    private static int a(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static Pair<Integer, Integer> a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        byte b2 = 0;
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3006243:
                if (!str2.equals("avc1")) {
                    b2 = -1;
                }
                break;
            case 3006244:
                b2 = !str2.equals("avc2") ? (byte) -1 : (byte) 1;
                break;
            case 3199032:
                b2 = !str2.equals("hev1") ? (byte) -1 : (byte) 2;
                break;
            case 3214780:
                b2 = !str2.equals("hvc1") ? (byte) -1 : (byte) 3;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
                return b(str, strArrSplit);
            case 2:
            case 3:
                return a(str, strArrSplit);
            default:
                return null;
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        StringBuilder sb;
        int i;
        StringBuilder sbAppend;
        if (strArr.length < 4) {
            sb = new StringBuilder("Ignoring malformed HEVC codec string: ");
        } else {
            Matcher matcher = b.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                if ("1".equals(str)) {
                    i = 1;
                } else if ("2".equals(str)) {
                    i = 2;
                } else {
                    sb = new StringBuilder("Unknown HEVC profile string: ");
                }
                Integer num = f.get(strArr[3]);
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i), num);
                }
                sbAppend = new StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
                com.opos.cmn.an.f.a.c("MediaCodecUtil", sbAppend.toString());
                return null;
            }
            sb = new StringBuilder("Ignoring malformed HEVC codec string: ");
        }
        sbAppend = sb.append(str);
        com.opos.cmn.an.f.a.c("MediaCodecUtil", sbAppend.toString());
        return null;
    }

    public static com.opos.exoplayer.core.d.a a() {
        return f6378a;
    }

    public static com.opos.exoplayer.core.d.a a(String str, boolean z) {
        List<com.opos.exoplayer.core.d.a> listB = b(str, z);
        if (listB.isEmpty()) {
            return null;
        }
        return listB.get(0);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b A[PHI: r16
  0x004b: PHI (r16v6 int) = (r16v5 int), (r16v7 int) binds: [B:23:0x0055, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    private static ArrayList<com.opos.exoplayer.core.d.a> a(c cVar, InterfaceC0915d interfaceC0915d, String str) throws a {
        int i;
        try {
            ArrayList<com.opos.exoplayer.core.d.a> arrayList = new ArrayList<>();
            String str2 = cVar.f6379a;
            int iA = interfaceC0915d.a();
            boolean zB = interfaceC0915d.b();
            int i2 = 0;
            while (i2 < iA) {
                MediaCodecInfo mediaCodecInfoA = interfaceC0915d.a(i2);
                String name = mediaCodecInfoA.getName();
                if (a(mediaCodecInfoA, name, zB, str)) {
                    String[] supportedTypes = mediaCodecInfoA.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str3 = supportedTypes[i3];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(str3);
                                boolean zA = interfaceC0915d.a(str2, capabilitiesForType);
                                boolean zB2 = b(name);
                                if (zB) {
                                    i = iA;
                                    try {
                                        if (cVar.b == zA) {
                                            arrayList.add(com.opos.exoplayer.core.d.a.a(name, str2, capabilitiesForType, zB2, false));
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (y.f6517a <= 23 || arrayList.isEmpty()) {
                                            com.opos.cmn.an.f.a.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e;
                                        }
                                        com.opos.cmn.an.f.a.d("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                        i3++;
                                        interfaceC0915d = interfaceC0915d;
                                        iA = i;
                                    }
                                } else {
                                    i = iA;
                                }
                                if (!zB) {
                                    try {
                                        if (!cVar.b) {
                                            arrayList.add(com.opos.exoplayer.core.d.a.a(name, str2, capabilitiesForType, zB2, false));
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        if (y.f6517a <= 23) {
                                        }
                                        com.opos.cmn.an.f.a.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                        throw e;
                                    }
                                }
                                if (!zB && zA) {
                                    arrayList.add(com.opos.exoplayer.core.d.a.a(name + ".secure", str2, capabilitiesForType, zB2, true));
                                    return arrayList;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                i = iA;
                            }
                        } else {
                            i = iA;
                        }
                        i3++;
                        interfaceC0915d = interfaceC0915d;
                        iA = i;
                    }
                }
                i2++;
                iA = iA;
            }
            return arrayList;
        } catch (Exception e5) {
            throw new a(e5, null);
        }
    }

    private static void a(List<com.opos.exoplayer.core.d.a> list) {
        if (y.f6517a < 26) {
            if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f6374a)) {
                return;
            }
            for (int i = 1; i < list.size(); i++) {
                com.opos.exoplayer.core.d.a aVar = list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.f6374a)) {
                    list.remove(i);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (y.f6517a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (y.f6517a < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (y.f6517a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(y.b) || (Constant.DEVICE_XIAOMI.equals(y.c) && y.b.startsWith("HM")))) {
            return false;
        }
        if (y.f6517a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(y.b) || "protou".equals(y.b) || "ville".equals(y.b) || "villeplus".equals(y.b) || "villec2".equals(y.b) || y.b.startsWith("gee") || "C6602".equals(y.b) || "C6603".equals(y.b) || "C6606".equals(y.b) || "C6616".equals(y.b) || "L36h".equals(y.b) || "SO-02E".equals(y.b))) {
            return false;
        }
        if (y.f6517a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(y.b) || "C1505".equals(y.b) || "C1604".equals(y.b) || "C1605".equals(y.b))) {
            return false;
        }
        if (y.f6517a < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && y.c.equals("samsung") && (y.b.startsWith("zeroflte") || y.b.startsWith("zerolte") || y.b.startsWith("zenlte") || y.b.equals("SC-05G") || y.b.equals("marinelteatt") || y.b.equals("404SC") || y.b.equals("SC-04G") || y.b.equals("SCV31")))) {
            return false;
        }
        if (y.f6517a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(y.c) && (y.b.startsWith("d2") || y.b.startsWith("serrano") || y.b.startsWith("jflte") || y.b.startsWith("santos") || y.b.startsWith("t0"))) {
            return false;
        }
        if (y.f6517a <= 19 && y.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static int b() {
        if (g == -1) {
            int iMax = 0;
            com.opos.exoplayer.core.d.a aVarA = a(MimeTypes.VIDEO_H264, false);
            if (aVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = aVarA.a();
                int length = codecProfileLevelArrA.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(a(codecProfileLevelArrA[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, y.f6517a >= 21 ? 345600 : 172800);
            }
            g = iMax;
        }
        return g;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        StringBuilder sb;
        Integer numValueOf;
        Integer numValueOf2;
        StringBuilder sbAppend;
        if (strArr.length >= 2) {
            try {
                if (strArr[1].length() == 6) {
                    numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                    numValueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                } else {
                    if (strArr.length < 3) {
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                        return null;
                    }
                    Integer numValueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                    numValueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                    numValueOf2 = numValueOf3;
                }
                Integer numValueOf4 = Integer.valueOf(d.get(numValueOf2.intValue()));
                if (numValueOf4 == null) {
                    sbAppend = new StringBuilder("Unknown AVC profile: ").append(numValueOf2);
                } else {
                    Integer numValueOf5 = Integer.valueOf(e.get(numValueOf.intValue()));
                    if (numValueOf5 != null) {
                        return new Pair<>(numValueOf4, numValueOf5);
                    }
                    sbAppend = new StringBuilder("Unknown AVC level: ").append(numValueOf);
                }
            } catch (NumberFormatException unused) {
                sb = new StringBuilder("Ignoring malformed AVC codec string: ");
                sbAppend = sb.append(str);
            }
            com.opos.cmn.an.f.a.c("MediaCodecUtil", sbAppend.toString());
            return null;
        }
        sb = new StringBuilder("Ignoring malformed AVC codec string: ");
        sbAppend = sb.append(str);
        com.opos.cmn.an.f.a.c("MediaCodecUtil", sbAppend.toString());
        return null;
    }

    public static synchronized List<com.opos.exoplayer.core.d.a> b(String str, boolean z) {
        int i;
        c cVar = new c(str, z);
        HashMap<c, List<com.opos.exoplayer.core.d.a>> map = c;
        List<com.opos.exoplayer.core.d.a> list = map.get(cVar);
        if (list != null) {
            return list;
        }
        b bVar = null;
        InterfaceC0915d fVar = y.f6517a >= 21 ? new f(z) : new e(bVar);
        ArrayList<com.opos.exoplayer.core.d.a> arrayListA = a(cVar, fVar, str);
        if (z && arrayListA.isEmpty() && 21 <= (i = y.f6517a) && i <= 23) {
            fVar = new e(bVar);
            arrayListA = a(cVar, fVar, str);
            if (!arrayListA.isEmpty()) {
                com.opos.cmn.an.f.a.c("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListA.get(0).f6374a);
            }
        }
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            arrayListA.addAll(a(new c(MimeTypes.AUDIO_E_AC3, cVar.b), fVar, str));
        }
        a(arrayListA);
        List<com.opos.exoplayer.core.d.a> listUnmodifiableList = Collections.unmodifiableList(arrayListA);
        map.put(cVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    private static boolean b(String str) {
        return y.f6517a <= 22 && (y.d.equals("ODROID-XU3") || y.d.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }
}
