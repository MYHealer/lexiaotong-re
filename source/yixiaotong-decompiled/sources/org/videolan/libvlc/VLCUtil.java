package org.videolan.libvlc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class VLCUtil {
    private static final int ELF_HEADER_SIZE = 52;
    private static final int EM_386 = 3;
    private static final int EM_AARCH64 = 183;
    private static final int EM_ARM = 40;
    private static final int EM_MIPS = 8;
    private static final int EM_X86_64 = 62;
    private static final int SECTION_HEADER_SIZE = 40;
    private static final int SHT_ARM_ATTRIBUTES = 1879048195;
    private static String errorMsg;
    private static boolean isCompatible;
    private static MachineSpecs machineSpecs;
    public static final String TAG = s.d(new byte[]{100, 121, 115, Ascii.GS, 116, 8, 3, 50, 42, 33, Ascii.RS, 48, 70, 92, 92}, "25028a");
    private static final String URI_AUTHORIZED_CHARS = s.d(new byte[]{17, Ascii.RS, 16, 79}, "669eb1");
    private static final String[] CPU_archs = {s.d(new byte[]{Ascii.CAN, 101, Ascii.ETB, 86, Ascii.NAK, Ascii.NAK, 85}, "25e38c"), s.d(new byte[]{19, 66, 3}, "947f7f"), s.d(new byte[]{75, Ascii.ETB, 4, 98}, "aa06d1"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 13, 98}, "686e22"), s.d(new byte[]{Ascii.NAK, 81, 100, 35}, "cd0f71"), s.d(new byte[]{67, 1, 100, 118, 125}, "54037c"), s.d(new byte[]{71, 2}, "1448c7"), s.d(new byte[]{65, 2, 126, 105}, "74539c"), s.d(new byte[]{67, 85, 98, 6}, "5c6483"), s.d(new byte[]{71, 3, 125}, "156039"), s.d(new byte[]{65, 1}, "76ad90"), s.d(new byte[]{75, 78, 83, 72, 125}, "a8ee05"), s.d(new byte[]{Ascii.ESC, 67, 5, 97, 72, 117}, "1532e8"), s.d(new byte[]{Ascii.FS, 19, 0, 32, Ascii.FS, 46}, "6e7e1c"), s.d(new byte[]{Ascii.ESC, SignedBytes.MAX_POWER_OF_TWO, 13}, "1654a3")};

    /* JADX INFO: renamed from: org.videolan.libvlc.VLCUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ElfData {
        public String att_arch;
        public boolean att_fpu;
        public int e_machine;
        public int e_shnum;
        public int e_shoff;
        public boolean is64bits;
        public ByteOrder order;
        public int sh_offset;
        public int sh_size;

        private ElfData() {
        }

        public /* synthetic */ ElfData(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class MachineSpecs {
        public float bogoMIPS;
        public float frequency;
        public boolean hasArmV6;
        public boolean hasArmV7;
        public boolean hasFpu;
        public boolean hasMips;
        public boolean hasNeon;
        public boolean hasX86;
        public boolean is64bits;
        public int processors;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0038  */
    public static Uri UriFromMrl(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(charArray.length * 2);
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c != '%' || charArray.length - i < 3) {
                sb.append(c);
            } else {
                try {
                    int i2 = Integer.parseInt(new String(charArray, i + 1, 2), 16);
                    if (URI_AUTHORIZED_CHARS.indexOf(i2) != -1) {
                        sb.append((char) i2);
                        i += 2;
                    } else {
                        sb.append(c);
                    }
                } catch (NumberFormatException unused) {
                }
            }
            i++;
        }
        return Uri.parse(sb.toString());
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String encodeVLCString(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(charArray.length * 2);
        for (char c : charArray) {
            if (URI_AUTHORIZED_CHARS.indexOf(c) != -1) {
                sb.append(s.d(new byte[]{19}, "626afa")).append(Integer.toHexString(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String encodeVLCUri(Uri uri) {
        return encodeVLCString(uri.toString());
    }

    public static String[] getABIList() {
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    public static String[] getABIList21() {
        String[] strArr = Build.SUPPORTED_ABIS;
        return (strArr == null || strArr.length == 0) ? getABIList() : strArr;
    }

    public static String getErrorMsg() {
        return errorMsg;
    }

    public static MachineSpecs getMachineSpecs() {
        return machineSpecs;
    }

    private static String getString(ByteBuffer byteBuffer) {
        char c;
        StringBuilder sb = new StringBuilder(byteBuffer.limit());
        while (byteBuffer.remaining() > 0 && (c = (char) byteBuffer.get()) != 0) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static byte[] getThumbnail(LibVLC libVLC, Uri uri, int i, int i2) {
        if (uri.getLastPathSegment().endsWith(s.d(new byte[]{Ascii.US, 15, 66, 9}, "1f1f5c"))) {
            uri = Uri.parse(s.d(new byte[]{6, 69, 87, 16, 13, 84, 17, 8, 3, 88, Ascii.RS, 74}, "b33cd9") + uri.getEncodedPath());
        }
        Media media = new Media(libVLC, uri);
        byte[] thumbnail = getThumbnail(media, i, i2);
        media.release();
        return thumbnail;
    }

    public static byte[] getThumbnail(Media media, int i, int i2) {
        media.addOption(s.d(new byte[]{94, 87, 14, 73, 87, 65, 5, 13, 9}, "d9ad64"));
        media.addOption(s.d(new byte[]{91, 93, 86, 79, 68, 19, Ascii.DC4}, "a39b7c"));
        media.addOption(s.d(new byte[]{94, 92, 89, Ascii.FS, 89, 75, 5}, "d26168"));
        media.addOption(s.d(new byte[]{8, 13, 95, 65, 19, SignedBytes.MAX_POWER_OF_TWO, 76, 2, 7, 17, 69, 72, 65, 1, 84, 90}, "2d11f4"));
        return nativeGetThumbnail(media, i, i2);
    }

    private static int getUleb128(ByteBuffer byteBuffer) {
        byte b;
        int i = 0;
        do {
            b = byteBuffer.get();
            i = (i << 7) | (b & 127);
        } while ((b & 128) > 0);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:108:0x02eb A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02f2 A[Catch: IOException -> 0x0332, all -> 0x0343, TRY_LEAVE, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:115:0x030d A[Catch: all -> 0x0330, IOException -> 0x0347, TRY_LEAVE, TryCatch #13 {IOException -> 0x0347, all -> 0x0330, blocks: (B:113:0x02fc, B:115:0x030d, B:116:0x0320), top: B:224:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0335  */
    /* JADX WARN: Code duplicated, block: B:140:0x0376  */
    /* JADX WARN: Code duplicated, block: B:141:0x0378  */
    /* JADX WARN: Code duplicated, block: B:144:0x037f  */
    /* JADX WARN: Code duplicated, block: B:146:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:153:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x03c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:161:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:163:0x03d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:167:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:173:0x041f  */
    /* JADX WARN: Code duplicated, block: B:175:0x0433 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x0446  */
    /* JADX WARN: Code duplicated, block: B:180:0x044a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:183:0x045c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x048d A[Catch: all -> 0x0495, NumberFormatException -> 0x049a, IOException -> 0x049d, TRY_LEAVE, TryCatch #11 {IOException -> 0x049d, NumberFormatException -> 0x049a, all -> 0x0495, blocks: (B:188:0x0487, B:190:0x048d), top: B:227:0x0487 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04f1 A[PHI: r1 r9
  0x04f1: PHI (r1v16 ??) = (r1v46 ??), (r1v47 ??) binds: [B:202:0x04ef, B:189:0x048b] A[DONT_GENERATE, DONT_INLINE]
  0x04f1: PHI (r9v10 java.io.BufferedReader) = (r9v6 java.io.BufferedReader), (r9v28 java.io.BufferedReader) binds: [B:202:0x04ef, B:189:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:237:0x033c A[EDGE_INSN: B:237:0x033c->B:124:0x033c BREAK  A[LOOP:1: B:60:0x01ab->B:118:0x032b, LOOP_LABEL: LOOP:1: B:60:0x01ab->B:118:0x032b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01b3 A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f3 A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0230  */
    /* JADX WARN: Code duplicated, block: B:81:0x0234 A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:86:0x025d A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0270  */
    /* JADX WARN: Code duplicated, block: B:89:0x0274  */
    /* JADX WARN: Code duplicated, block: B:92:0x0286 A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:96:0x029b  */
    /* JADX WARN: Code duplicated, block: B:99:0x02ae A[Catch: IOException -> 0x0332, all -> 0x0343, TryCatch #16 {IOException -> 0x0332, all -> 0x0343, blocks: (B:61:0x01ad, B:63:0x01b3, B:90:0x0275, B:92:0x0286, B:97:0x029d, B:99:0x02ae, B:101:0x02c1, B:106:0x02da, B:108:0x02eb, B:111:0x02f2, B:66:0x01c7, B:69:0x01dd, B:72:0x01f3, B:75:0x0207, B:78:0x021d, B:81:0x0234, B:83:0x0247, B:86:0x025d), top: B:220:0x01ad }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean hasCompatibleCPU(Context context) throws Throwable {
        ElfData lib;
        ?? fileReader;
        boolean z;
        boolean z2;
        boolean z3;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileReader fileReader2;
        boolean z4;
        float f;
        boolean z5;
        boolean z6;
        boolean z7;
        int i;
        int i2;
        BufferedReader bufferedReader3;
        ?? r1;
        BufferedReader bufferedReader4;
        ?? r2;
        float f2;
        ?? r3;
        String line;
        boolean z8;
        boolean z9;
        String strD;
        boolean z10;
        float f3;
        String line2;
        int i3;
        byte[] bArr;
        int i4;
        byte[] bArr2;
        int i5;
        byte[] bArr3;
        String strD2;
        if (errorMsg != null || isCompatible) {
            return isCompatible;
        }
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        for (String str : getABIList21()) {
            if (str.equals(s.d(new byte[]{Ascii.RS, 12, 15}, "f49dcb"))) {
                z13 = true;
            } else if (str.equals(s.d(new byte[]{65, 93, 83, 103, 0, 85}, "9ee86a"))) {
                z13 = true;
                z14 = true;
            } else if (str.equals(s.d(new byte[]{3, 69, 8, 85, 87, 87, 8, 73, 16, 85, 80}, "b7e065"))) {
                z11 = true;
                z12 = true;
            } else if (str.equals(s.d(new byte[]{83, 70, 95, 93, 86, 91, 8}, "242879"))) {
                z11 = true;
            } else if (str.equals(s.d(new byte[]{86, 68, 15, 6, 2, 78, Ascii.ETB, 92, 7}, "76b06c"))) {
                z11 = true;
                z12 = true;
                z14 = true;
                z15 = true;
            }
        }
        File fileSearchLibrary = searchLibrary(context.getApplicationInfo());
        FileReader fileReader3 = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader5 = null;
        bufferedReader = null;
        BufferedReader bufferedReader6 = null;
        ?? r17 = 0;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                if (fileSearchLibrary != null) {
                                    lib = readLib(fileSearchLibrary);
                                    if (lib != null) {
                                        int i6 = lib.e_machine;
                                        boolean z16 = i6 == 3 || i6 == 62;
                                        z3 = i6 == 40 || i6 == 183;
                                        z2 = i6 == 8;
                                        z = lib.is64bits;
                                        String str2 = TAG;
                                        StringBuilder sbAppend = new StringBuilder().append(s.d(new byte[]{38, 122, 35, 65, 37, 115, 40, 68, 91, 66}, "c6ead1")).append(z3 ? s.d(new byte[]{2, 17, 89}, "cc4eb1") : z16 ? s.d(new byte[]{74, 12, 4}, "2423ff") : s.d(new byte[]{92, 10, 69, 67}, "1c50ca")).append(s.d(new byte[]{74, 17}, "f1c2d9"));
                                        byte[] bArr4 = {5, 2, 87, 15, SignedBytes.MAX_POWER_OF_TWO, 74};
                                        if (z) {
                                            // fill-array-data instruction
                                            bArr4[0] = 1;
                                            bArr4[1] = 5;
                                            bArr4[2] = 6;
                                            bArr4[3] = 88;
                                            bArr4[4] = 18;
                                            bArr4[5] = 64;
                                            strD2 = s.d(bArr4, "71d1f3");
                                        } else {
                                            strD2 = s.d(bArr4, "605f49");
                                        }
                                        Log.i(str2, sbAppend.append(strD2).toString());
                                        Log.i(str2, s.d(new byte[]{36, 40, 113, Ascii.NAK, 88, 66, 2, 12, 70, 95, 17}, "ad7590") + lib.att_arch);
                                        Log.i(str2, s.d(new byte[]{124, 120, 37, 70, 2, 73, Ascii.DC4, 68, 91, 66}, "94cfd9") + lib.att_fpu);
                                        fileReader = z16;
                                    }
                                    fileReader2 = new FileReader(s.d(new byte[]{Ascii.RS, 71, SignedBytes.MAX_POWER_OF_TWO, 12, 5, Ascii.FS, 2, Ascii.DC4, 19, 11, 95, 3, 94}, "172cf3"));
                                    bufferedReader2 = new BufferedReader(fileReader2);
                                    z5 = false;
                                    z6 = false;
                                    z10 = false;
                                    z7 = false;
                                    i = 0;
                                    loop1: while (true) {
                                        f3 = -1.0f;
                                        while (true) {
                                            try {
                                                line2 = bufferedReader2.readLine();
                                                if (line2 != null) {
                                                    break loop1;
                                                }
                                                if (line2.contains(s.d(new byte[]{35, 39, 16, 86, 91, 83, 85}, "bfb53e")) || line2.contains(s.d(new byte[]{117, 49, 41, Ascii.DC2, 82}, "4cdde0"))) {
                                                    i3 = 4;
                                                    z11 = true;
                                                    z12 = true;
                                                } else if (line2.contains(s.d(new byte[]{39, 100, 116, 78, 85}, "f698c2"))) {
                                                    i3 = 4;
                                                    z11 = true;
                                                } else if (line2.contains(s.d(new byte[]{6, 9, 4, 84, SignedBytes.MAX_POWER_OF_TWO, 17, 9, 68, Ascii.NAK, 11, 75, 0}, "eeb85b")) || line2.contains(s.d(new byte[]{33, 6, 8, SignedBytes.MAX_POWER_OF_TWO, 89, 86, 4, 45, 8, Ascii.SYN, 84, 9}, "fcf508"))) {
                                                    i3 = 4;
                                                    z13 = true;
                                                } else if (line2.contains(s.d(new byte[]{66, 94, 81, 82, 86, 88, 14, 8, 2, 7, 67}, "220130"))) {
                                                    i3 = 4;
                                                    z6 = true;
                                                } else if (!line2.contains(s.d(new byte[]{37, 52, 109, 66, 11, 93, 17, 8, 3, 15, 84, 11, Ascii.DC2, 1, 74}, "fd8bb0")) && line2.contains(s.d(new byte[]{81, SignedBytes.MAX_POWER_OF_TWO, 6, 13}, "a80493"))) {
                                                    i3 = 4;
                                                    z7 = true;
                                                } else if (line2.contains(s.d(new byte[]{84, 8, 87, 19, 94, SignedBytes.MAX_POWER_OF_TWO, 4, 7, 9, 12, 85, 69, 77, 8, 89, 4, 67, SignedBytes.MAX_POWER_OF_TWO}, "9a4a13"))) {
                                                    i3 = 4;
                                                    z10 = true;
                                                } else {
                                                    i3 = 4;
                                                }
                                                bArr = new byte[i3];
                                                // fill-array-data instruction
                                                bArr[0] = 92;
                                                bArr[1] = 6;
                                                bArr[2] = 12;
                                                bArr[3] = 11;
                                                if (!line2.contains(s.d(bArr, "2cce85")) || line2.contains(s.d(new byte[]{3, 66, 91, 8, 85}, "b12e12"))) {
                                                    i4 = 3;
                                                    z15 = true;
                                                } else {
                                                    i4 = 3;
                                                }
                                                bArr2 = new byte[i4];
                                                // fill-array-data instruction
                                                bArr2[0] = 67;
                                                bArr2[1] = 86;
                                                bArr2[2] = 73;
                                                if (!line2.contains(s.d(bArr2, "509693")) || (line2.contains(s.d(new byte[]{118, 92, 84, 69, 66, 74, 4, Ascii.ETB}, "095178")) && line2.contains(s.d(new byte[]{81, 68}, "7414cd")))) {
                                                    i5 = 9;
                                                    z5 = true;
                                                } else {
                                                    i5 = 9;
                                                }
                                                bArr3 = new byte[i5];
                                                // fill-array-data instruction
                                                bArr3[0] = 65;
                                                bArr3[1] = 71;
                                                bArr3[2] = 10;
                                                bArr3[3] = 91;
                                                bArr3[4] = 84;
                                                bArr3[5] = 70;
                                                bArr3[6] = 18;
                                                bArr3[7] = 11;
                                                bArr3[8] = 20;
                                                if (line2.startsWith(s.d(bArr3, "15e815"))) {
                                                    i++;
                                                }
                                                if (f3 < 0.0f) {
                                                    bufferedReader = bufferedReader2;
                                                    try {
                                                        if (line2.toLowerCase(Locale.ENGLISH).contains(s.d(new byte[]{82, 89, 86, 87, 14, 94, 17, Ascii.ETB}, "0618c7"))) {
                                                            try {
                                                                f3 = Float.parseFloat(line2.split(s.d(new byte[]{8}, "256315"))[1].trim());
                                                            } catch (NumberFormatException unused) {
                                                                bufferedReader2 = bufferedReader;
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } catch (IOException unused2) {
                                                        z4 = z10;
                                                        f = f3;
                                                        bufferedReader2 = bufferedReader;
                                                        close(bufferedReader2);
                                                        close(fileReader2);
                                                        if (i == 0) {
                                                            i2 = 1;
                                                        } else {
                                                            i2 = i;
                                                        }
                                                        isCompatible = true;
                                                        if (lib != null) {
                                                            if (fileReader != 0) {
                                                                z8 = false;
                                                                if (!z3) {
                                                                }
                                                            } else {
                                                                z8 = false;
                                                                if (!z3) {
                                                                }
                                                            }
                                                            fileReader = 29;
                                                            fileReader = 29;
                                                            if (z2) {
                                                                z9 = false;
                                                                if (z3) {
                                                                }
                                                            } else {
                                                                z9 = false;
                                                                if (z3) {
                                                                }
                                                            }
                                                            if (lib.e_machine == 40) {
                                                                errorMsg = s.d(new byte[]{37, 103, 121, 66, 85, Ascii.EM, 3, 17, 15, 14, 85, 69, 11, 91, Ascii.DC4, 90, 13, 87, 76, 37, 52, 47, 71, 82, 68, 81, 81, 66, 11, 90, 4}, "d544b9");
                                                                isCompatible = false;
                                                            }
                                                            if (lib.e_machine == 40) {
                                                                if (!lib.att_arch.startsWith(s.d(new byte[]{69, 3}, "353859"))) {
                                                                    if (!lib.att_fpu) {
                                                                    }
                                                                } else if (!lib.att_fpu) {
                                                                }
                                                            }
                                                            if (z) {
                                                                fileReader = "ebd5f9";
                                                                errorMsg = s.d(new byte[]{83, 86, 6, 92, Ascii.DC2, 74, 65, 6, 19, 11, 93, 1, 69, 13, 10, Ascii.NAK, 85, 11, 3, 13, Ascii.DC2, 17, 17, 1, 0, Ascii.DC4, 13, 86, 3}, "ebd5f9");
                                                                isCompatible = false;
                                                            }
                                                        }
                                                        fileReader = new FileReader(s.d(new byte[]{Ascii.FS, 17, 73, 70, Ascii.US, 2, 4, Ascii.DC2, 15, 1, 84, Ascii.SYN, Ascii.FS, 17, 73, 70, 68, 3, 12, 75, 5, Ascii.DC2, 68, 74, 80, Ascii.DC2, 69, 5, Ascii.US, 5, 17, 17, 0, 16, 84, Ascii.DC4, Ascii.FS, 1, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 89, 8, 7, 11, 57, 15, 80, Ascii.GS, 108, 4, 66, 80, 65}, "3b050f"));
                                                        bufferedReader4 = new BufferedReader(fileReader);
                                                        line = bufferedReader4.readLine();
                                                        r2 = fileReader;
                                                        if (line != null) {
                                                            f2 = Float.parseFloat(line) / 1000.0f;
                                                            r3 = fileReader;
                                                        } else {
                                                            f2 = -1.0f;
                                                            r3 = r2;
                                                        }
                                                        close(bufferedReader4);
                                                        close(r3);
                                                        machineSpecs = new MachineSpecs();
                                                        Log.d(TAG, s.d(new byte[]{11, 5, 90, 12, 12, 93, 4, 55, Ascii.SYN, 7, 82, Ascii.SYN, 92, 68, 81, 5, Ascii.SYN, 114, 19, 9, 48, 84, 11, 69}, "fd9de3") + z11 + s.d(new byte[]{79, 66, 90, 83, 66, 118, 19, 9, 48, 85, 11, 69}, "cb2217") + z12 + s.d(new byte[]{78, 16, 12, 83, 70, 59, 89, 82, 92, 66}, "b0d25c") + z13 + s.d(new byte[]{Ascii.DC4, 19, 10, 17, 15, 80, 3, 13, Ascii.DC2, 17, 11, 69}, "83cb9d") + z14);
                                                        MachineSpecs machineSpecs2 = machineSpecs;
                                                        machineSpecs2.hasArmV6 = z11;
                                                        machineSpecs2.hasArmV7 = z12;
                                                        machineSpecs2.hasFpu = z5;
                                                        machineSpecs2.hasMips = z4;
                                                        machineSpecs2.hasNeon = z15;
                                                        machineSpecs2.hasX86 = z13;
                                                        machineSpecs2.is64bits = z14;
                                                        machineSpecs2.bogoMIPS = f;
                                                        machineSpecs2.processors = i2;
                                                        machineSpecs2.frequency = f2;
                                                        return isCompatible;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        fileReader3 = fileReader2;
                                                        close(bufferedReader);
                                                        close(fileReader3);
                                                        throw th;
                                                    }
                                                } else {
                                                    bufferedReader = bufferedReader2;
                                                }
                                                bufferedReader2 = bufferedReader;
                                            } catch (IOException unused3) {
                                                bufferedReader = bufferedReader2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedReader = bufferedReader2;
                                            }
                                        }
                                    }
                                    z4 = z10;
                                    f = f3;
                                    close(bufferedReader2);
                                    close(fileReader2);
                                    if (i == 0) {
                                        i2 = 1;
                                    } else {
                                        i2 = i;
                                    }
                                    isCompatible = true;
                                    if (lib != null) {
                                        if (fileReader != 0 || z13) {
                                            z8 = false;
                                            if (!z3 && !z11) {
                                                errorMsg = s.d(new byte[]{116, 101, 46, Ascii.ETB, 90, 69, 8, 8, 2, 66, 94, 11, Ascii.NAK, 89, 12, 89, Ascii.CAN, 113, 51, 41, 70, 6, 84, 19, 92, 84, 6}, "57c780");
                                                isCompatible = z8;
                                            }
                                        } else if (z6 && z7) {
                                            Log.d(TAG, s.d(new byte[]{118, 93, 69, 9, 88, 66, 4, 0, 70, 3, 67, 8, 69, 7, 16, 1, 92, 66, 4, 7, Ascii.DC2, 7, 85, 73, 19, 68, 66, Ascii.FS, 80, 88, 6, 68, Ascii.DC2, 13, 17, 9, 82, 69, 94, 6, 81, Ascii.SYN, Ascii.EM, 92, 80, 66, 93, 12, 81, 66, 81, Ascii.ETB, 80, 83, Ascii.DC2}, "300e96"));
                                        } else {
                                            errorMsg = s.d(new byte[]{79, 8, 85, 66, 81, SignedBytes.MAX_POWER_OF_TWO, 8, 8, 2, 66, 94, 11, Ascii.ETB, 94, 12, 12, Ascii.RS, 77, 89, 82, 70, 6, 84, 19, 94, 83, 6}, "70cb35");
                                            z8 = false;
                                            isCompatible = z8;
                                        }
                                        fileReader = 29;
                                        fileReader = 29;
                                        if (z2 || z4) {
                                            z9 = false;
                                            if (z3 || !z4) {
                                                if (lib.e_machine == 40 && lib.att_arch.startsWith(s.d(new byte[]{78, 81}, "8f3bc2")) && !z12) {
                                                    errorMsg = s.d(new byte[]{37, 103, 121, 66, 85, Ascii.EM, 3, 17, 15, 14, 85, 69, 11, 91, Ascii.DC4, 90, 13, 87, 76, 37, 52, 47, 71, 82, 68, 81, 81, 66, 11, 90, 4}, "d544b9");
                                                    isCompatible = false;
                                                }
                                                if (lib.e_machine == 40) {
                                                    if (!lib.att_arch.startsWith(s.d(new byte[]{69, 3}, "353859")) && !z11) {
                                                        strD = s.d(new byte[]{121, 52, 46, 69, 83, Ascii.EM, 3, 17, 15, 14, 85, 69, 87, 8, 67, 93, 10, 87, 76, 37, 52, 47, 71, 83, Ascii.CAN, 2, 6, 69, 12, 90, 4}, "8fc3e9");
                                                    } else if (!lib.att_fpu && !z5) {
                                                        strD = s.d(new byte[]{127, 104, 109, Ascii.RS, 93, 11, 0, 6, 10, 7, 85, 69, 91, 77, 81, 95, 92, 69, 14, 10, 70, 12, 94, 11, Ascii.DC4, 126, 104, 102, Ascii.CAN, 1, 4, Ascii.DC2, 15, 1, 84}, "98838e");
                                                    }
                                                    errorMsg = strD;
                                                    isCompatible = false;
                                                }
                                                if (z && !z14) {
                                                    fileReader = "ebd5f9";
                                                    errorMsg = s.d(new byte[]{83, 86, 6, 92, Ascii.DC2, 74, 65, 6, 19, 11, 93, 1, 69, 13, 10, Ascii.NAK, 85, 11, 3, 13, Ascii.DC2, 17, 17, 1, 0, Ascii.DC4, 13, 86, 3}, "ebd5f9");
                                                    isCompatible = false;
                                                }
                                            } else {
                                                errorMsg = s.d(new byte[]{115, 55, 44, Ascii.DC4, 84, 76, 8, 8, 2, 66, 94, 11, Ascii.DC2, 40, 40, 100, 101, Ascii.EM, 5, 1, 16, 11, 82, 0}, "2ea469");
                                            }
                                        } else {
                                            errorMsg = s.d(new byte[]{126, 45, 99, 106, Ascii.EM, 4, Ascii.DC4, 13, 10, 6, 17, 10, 93, 68, 93, 86, 87, 75, 44, 45, 54, 49, 17, 1, 86, Ascii.DC2, 90, 90, 92}, "3d399f");
                                            z9 = false;
                                        }
                                        isCompatible = z9;
                                        if (lib.e_machine == 40) {
                                            errorMsg = s.d(new byte[]{37, 103, 121, 66, 85, Ascii.EM, 3, 17, 15, 14, 85, 69, 11, 91, Ascii.DC4, 90, 13, 87, 76, 37, 52, 47, 71, 82, 68, 81, 81, 66, 11, 90, 4}, "d544b9");
                                            isCompatible = false;
                                        }
                                        if (lib.e_machine == 40) {
                                            if (!lib.att_arch.startsWith(s.d(new byte[]{69, 3}, "353859"))) {
                                                if (!lib.att_fpu) {
                                                }
                                            } else if (!lib.att_fpu) {
                                            }
                                        }
                                        if (z) {
                                            fileReader = "ebd5f9";
                                            errorMsg = s.d(new byte[]{83, 86, 6, 92, Ascii.DC2, 74, 65, 6, 19, 11, 93, 1, 69, 13, 10, Ascii.NAK, 85, 11, 3, 13, Ascii.DC2, 17, 17, 1, 0, Ascii.DC4, 13, 86, 3}, "ebd5f9");
                                            isCompatible = false;
                                        }
                                    }
                                    fileReader = new FileReader(s.d(new byte[]{Ascii.FS, 17, 73, 70, Ascii.US, 2, 4, Ascii.DC2, 15, 1, 84, Ascii.SYN, Ascii.FS, 17, 73, 70, 68, 3, 12, 75, 5, Ascii.DC2, 68, 74, 80, Ascii.DC2, 69, 5, Ascii.US, 5, 17, 17, 0, 16, 84, Ascii.DC4, Ascii.FS, 1, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 89, 8, 7, 11, 57, 15, 80, Ascii.GS, 108, 4, 66, 80, 65}, "3b050f"));
                                    bufferedReader4 = new BufferedReader(fileReader);
                                    line = bufferedReader4.readLine();
                                    r2 = fileReader;
                                    if (line != null) {
                                        f2 = Float.parseFloat(line) / 1000.0f;
                                        r3 = fileReader;
                                    } else {
                                        f2 = -1.0f;
                                        r3 = r2;
                                    }
                                    close(bufferedReader4);
                                    close(r3);
                                    machineSpecs = new MachineSpecs();
                                    Log.d(TAG, s.d(new byte[]{11, 5, 90, 12, 12, 93, 4, 55, Ascii.SYN, 7, 82, Ascii.SYN, 92, 68, 81, 5, Ascii.SYN, 114, 19, 9, 48, 84, 11, 69}, "fd9de3") + z11 + s.d(new byte[]{79, 66, 90, 83, 66, 118, 19, 9, 48, 85, 11, 69}, "cb2217") + z12 + s.d(new byte[]{78, 16, 12, 83, 70, 59, 89, 82, 92, 66}, "b0d25c") + z13 + s.d(new byte[]{Ascii.DC4, 19, 10, 17, 15, 80, 3, 13, Ascii.DC2, 17, 11, 69}, "83cb9d") + z14);
                                    MachineSpecs machineSpecs3 = machineSpecs;
                                    machineSpecs3.hasArmV6 = z11;
                                    machineSpecs3.hasArmV7 = z12;
                                    machineSpecs3.hasFpu = z5;
                                    machineSpecs3.hasMips = z4;
                                    machineSpecs3.hasNeon = z15;
                                    machineSpecs3.hasX86 = z13;
                                    machineSpecs3.is64bits = z14;
                                    machineSpecs3.bogoMIPS = f;
                                    machineSpecs3.processors = i2;
                                    machineSpecs3.frequency = f2;
                                    return isCompatible;
                                }
                                lib = null;
                                line = bufferedReader4.readLine();
                                r2 = fileReader;
                                if (line != null) {
                                    f2 = Float.parseFloat(line) / 1000.0f;
                                    r3 = fileReader;
                                } else {
                                    f2 = -1.0f;
                                    r3 = r2;
                                }
                            } catch (IOException unused4) {
                                bufferedReader6 = bufferedReader4;
                                Log.w(TAG, s.d(new byte[]{118, 86, 67, 94, 82, 16, 15, 11, Ascii.DC2, 66, 87, 12, 91, 93, Ascii.SYN, 95, 87, 72, 8, 9, 19, 15, 17, 38, 101, 108, Ascii.SYN, 84, 68, 85, 16, 17, 3, 12, 82, Ascii.FS, Ascii.DC4}, "596260"));
                                r1 = fileReader;
                                bufferedReader4 = bufferedReader6;
                                r2 = r1;
                            } catch (NumberFormatException unused5) {
                                bufferedReader6 = bufferedReader4;
                                String str3 = TAG;
                                Log.w(str3, s.d(new byte[]{112, 93, 70, 93, 92, Ascii.NAK, 15, 11, Ascii.DC2, 66, 65, 4, 65, 65, 86, 17, 85, 84, Ascii.EM, 13, 11, Ascii.ETB, 92, 69, 112, 98, 102, 17, 94, 71, 4, Ascii.NAK, 19, 7, 95, 6, 74, 19}, "323185"));
                                Log.w(str3, s.d(new byte[]{117, 86, 88, 93, 86, 5, 65, 16, 9, 66, 65, 4, 65, 68, 84, 11, 19}, "37113a") + "");
                                r1 = fileReader;
                                bufferedReader4 = bufferedReader6;
                                r2 = r1;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader5 = bufferedReader4;
                                BufferedReader bufferedReader7 = bufferedReader5;
                                r17 = fileReader;
                                bufferedReader3 = bufferedReader7;
                                close(bufferedReader3);
                                close(r17);
                                throw th;
                            }
                            bufferedReader4 = new BufferedReader(fileReader);
                        } catch (IOException unused6) {
                        } catch (NumberFormatException unused7) {
                        }
                        fileReader = new FileReader(s.d(new byte[]{Ascii.FS, 17, 73, 70, Ascii.US, 2, 4, Ascii.DC2, 15, 1, 84, Ascii.SYN, Ascii.FS, 17, 73, 70, 68, 3, 12, 75, 5, Ascii.DC2, 68, 74, 80, Ascii.DC2, 69, 5, Ascii.US, 5, 17, 17, 0, 16, 84, Ascii.DC4, Ascii.FS, 1, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 89, 8, 7, 11, 57, 15, 80, Ascii.GS, 108, 4, 66, 80, 65}, "3b050f"));
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (IOException unused8) {
                    fileReader = 0;
                } catch (NumberFormatException unused9) {
                    fileReader = 0;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader3 = null;
                    close(bufferedReader3);
                    close(r17);
                    throw th;
                }
                bufferedReader2 = new BufferedReader(fileReader2);
                z5 = false;
                z6 = false;
                z10 = false;
                z7 = false;
                i = 0;
                loop1: while (true) {
                    f3 = -1.0f;
                    while (true) {
                        line2 = bufferedReader2.readLine();
                        if (line2 != null) {
                            break loop1;
                            break loop1;
                        }
                        if (line2.contains(s.d(new byte[]{35, 39, 16, 86, 91, 83, 85}, "bfb53e"))) {
                            if (line2.contains(s.d(new byte[]{39, 100, 116, 78, 85}, "f698c2"))) {
                                i3 = 4;
                                z11 = true;
                            } else {
                                if (line2.contains(s.d(new byte[]{6, 9, 4, 84, SignedBytes.MAX_POWER_OF_TWO, 17, 9, 68, Ascii.NAK, 11, 75, 0}, "eeb85b"))) {
                                    if (line2.contains(s.d(new byte[]{66, 94, 81, 82, 86, 88, 14, 8, 2, 7, 67}, "220130"))) {
                                        i3 = 4;
                                        z6 = true;
                                    } else if (!line2.contains(s.d(new byte[]{37, 52, 109, 66, 11, 93, 17, 8, 3, 15, 84, 11, Ascii.DC2, 1, 74}, "fd8bb0"))) {
                                        if (line2.contains(s.d(new byte[]{84, 8, 87, 19, 94, SignedBytes.MAX_POWER_OF_TWO, 4, 7, 9, 12, 85, 69, 77, 8, 89, 4, 67, SignedBytes.MAX_POWER_OF_TWO}, "9a4a13"))) {
                                            i3 = 4;
                                            z10 = true;
                                        } else {
                                            i3 = 4;
                                        }
                                    } else if (line2.contains(s.d(new byte[]{84, 8, 87, 19, 94, SignedBytes.MAX_POWER_OF_TWO, 4, 7, 9, 12, 85, 69, 77, 8, 89, 4, 67, SignedBytes.MAX_POWER_OF_TWO}, "9a4a13"))) {
                                        i3 = 4;
                                        z10 = true;
                                    } else {
                                        i3 = 4;
                                    }
                                }
                                i3 = 4;
                                z13 = true;
                            }
                            bArr = new byte[i3];
                            // fill-array-data instruction
                            bArr[0] = 92;
                            bArr[1] = 6;
                            bArr[2] = 12;
                            bArr[3] = 11;
                            if (line2.contains(s.d(bArr, "2cce85"))) {
                                i4 = 3;
                                z15 = true;
                            } else {
                                i4 = 3;
                                z15 = true;
                            }
                            bArr2 = new byte[i4];
                            // fill-array-data instruction
                            bArr2[0] = 67;
                            bArr2[1] = 86;
                            bArr2[2] = 73;
                            if (line2.contains(s.d(bArr2, "509693"))) {
                                i5 = 9;
                                z5 = true;
                            } else {
                                i5 = 9;
                                z5 = true;
                            }
                            bArr3 = new byte[i5];
                            // fill-array-data instruction
                            bArr3[0] = 65;
                            bArr3[1] = 71;
                            bArr3[2] = 10;
                            bArr3[3] = 91;
                            bArr3[4] = 84;
                            bArr3[5] = 70;
                            bArr3[6] = 18;
                            bArr3[7] = 11;
                            bArr3[8] = 20;
                            if (line2.startsWith(s.d(bArr3, "15e815"))) {
                                i++;
                            }
                            if (f3 < 0.0f) {
                                bufferedReader = bufferedReader2;
                                if (line2.toLowerCase(Locale.ENGLISH).contains(s.d(new byte[]{82, 89, 86, 87, 14, 94, 17, Ascii.ETB}, "0618c7"))) {
                                    f3 = Float.parseFloat(line2.split(s.d(new byte[]{8}, "256315"))[1].trim());
                                } else {
                                    continue;
                                }
                            } else {
                                bufferedReader = bufferedReader2;
                            }
                            bufferedReader2 = bufferedReader;
                        }
                        i3 = 4;
                        z11 = true;
                        z12 = true;
                        bArr = new byte[i3];
                        // fill-array-data instruction
                        bArr[0] = 92;
                        bArr[1] = 6;
                        bArr[2] = 12;
                        bArr[3] = 11;
                        if (line2.contains(s.d(bArr, "2cce85"))) {
                            i4 = 3;
                            z15 = true;
                        } else {
                            i4 = 3;
                            z15 = true;
                        }
                        bArr2 = new byte[i4];
                        // fill-array-data instruction
                        bArr2[0] = 67;
                        bArr2[1] = 86;
                        bArr2[2] = 73;
                        if (line2.contains(s.d(bArr2, "509693"))) {
                            i5 = 9;
                            z5 = true;
                        } else {
                            i5 = 9;
                            z5 = true;
                        }
                        bArr3 = new byte[i5];
                        // fill-array-data instruction
                        bArr3[0] = 65;
                        bArr3[1] = 71;
                        bArr3[2] = 10;
                        bArr3[3] = 91;
                        bArr3[4] = 84;
                        bArr3[5] = 70;
                        bArr3[6] = 18;
                        bArr3[7] = 11;
                        bArr3[8] = 20;
                        if (line2.startsWith(s.d(bArr3, "15e815"))) {
                            i++;
                        }
                        if (f3 < 0.0f) {
                            bufferedReader = bufferedReader2;
                            if (line2.toLowerCase(Locale.ENGLISH).contains(s.d(new byte[]{82, 89, 86, 87, 14, 94, 17, Ascii.ETB}, "0618c7"))) {
                                f3 = Float.parseFloat(line2.split(s.d(new byte[]{8}, "256315"))[1].trim());
                            } else {
                                continue;
                            }
                        } else {
                            bufferedReader = bufferedReader2;
                        }
                        bufferedReader2 = bufferedReader;
                    }
                }
                z4 = z10;
                f = f3;
            } catch (IOException unused10) {
                bufferedReader2 = null;
                z4 = false;
                f = -1.0f;
                z5 = false;
                z6 = false;
                z7 = false;
                i = 0;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            fileReader2 = new FileReader(s.d(new byte[]{Ascii.RS, 71, SignedBytes.MAX_POWER_OF_TWO, 12, 5, Ascii.FS, 2, Ascii.DC4, 19, 11, 95, 3, 94}, "172cf3"));
        } catch (IOException unused11) {
            bufferedReader2 = null;
            fileReader2 = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
        }
        Log.w(TAG, s.d(new byte[]{53, 112, 51, 124, 122, 42, 38, 94, 70, 55, 95, 4, 0, 93, 4, Ascii.DC2, 71, 11, 65, Ascii.SYN, 3, 3, 85, 69, 14, 88, 3, 68, 95, 7, 11, 10, 15, 76, 66, 10, 89, 17, 2, 83, 93, 10, 14, 16, 70, 1, 89, 0, 1, 90, 65, 86, 86, Ascii.DC2, 8, 7, 3, 66, 112, 39, 43, 16}, "b1a23d"));
        fileReader = 0;
        z = false;
        z2 = false;
        z3 = false;
        close(bufferedReader2);
        close(fileReader2);
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = i;
        }
        isCompatible = true;
        if (lib != null) {
            if (fileReader != 0) {
                z8 = false;
                if (!z3) {
                }
            } else {
                z8 = false;
                if (!z3) {
                }
            }
            fileReader = 29;
            fileReader = 29;
            if (z2) {
                z9 = false;
                if (z3) {
                }
            } else {
                z9 = false;
                if (z3) {
                }
            }
            if (lib.e_machine == 40) {
                errorMsg = s.d(new byte[]{37, 103, 121, 66, 85, Ascii.EM, 3, 17, 15, 14, 85, 69, 11, 91, Ascii.DC4, 90, 13, 87, 76, 37, 52, 47, 71, 82, 68, 81, 81, 66, 11, 90, 4}, "d544b9");
                isCompatible = false;
            }
            if (lib.e_machine == 40) {
                if (!lib.att_arch.startsWith(s.d(new byte[]{69, 3}, "353859"))) {
                    if (!lib.att_fpu) {
                    }
                } else if (!lib.att_fpu) {
                }
            }
            if (z) {
                fileReader = "ebd5f9";
                errorMsg = s.d(new byte[]{83, 86, 6, 92, Ascii.DC2, 74, 65, 6, 19, 11, 93, 1, 69, 13, 10, Ascii.NAK, 85, 11, 3, 13, Ascii.DC2, 17, 17, 1, 0, Ascii.DC4, 13, 86, 3}, "ebd5f9");
                isCompatible = false;
            }
        }
        close(bufferedReader4);
        close(r3);
        machineSpecs = new MachineSpecs();
        Log.d(TAG, s.d(new byte[]{11, 5, 90, 12, 12, 93, 4, 55, Ascii.SYN, 7, 82, Ascii.SYN, 92, 68, 81, 5, Ascii.SYN, 114, 19, 9, 48, 84, 11, 69}, "fd9de3") + z11 + s.d(new byte[]{79, 66, 90, 83, 66, 118, 19, 9, 48, 85, 11, 69}, "cb2217") + z12 + s.d(new byte[]{78, 16, 12, 83, 70, 59, 89, 82, 92, 66}, "b0d25c") + z13 + s.d(new byte[]{Ascii.DC4, 19, 10, 17, 15, 80, 3, 13, Ascii.DC2, 17, 11, 69}, "83cb9d") + z14);
        MachineSpecs machineSpecs4 = machineSpecs;
        machineSpecs4.hasArmV6 = z11;
        machineSpecs4.hasArmV7 = z12;
        machineSpecs4.hasFpu = z5;
        machineSpecs4.hasMips = z4;
        machineSpecs4.hasNeon = z15;
        machineSpecs4.hasX86 = z13;
        machineSpecs4.is64bits = z14;
        machineSpecs4.bogoMIPS = f;
        machineSpecs4.processors = i2;
        machineSpecs4.frequency = f2;
        return isCompatible;
    }

    private static native byte[] nativeGetThumbnail(Media media, int i, int i2);

    private static boolean readArmAttributes(RandomAccessFile randomAccessFile, ElfData elfData) throws IOException {
        byte[] bArr = new byte[elfData.sh_size];
        randomAccessFile.seek(elfData.sh_offset);
        randomAccessFile.readFully(bArr);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(elfData.order);
        if (byteBufferWrap.get() != 65) {
            return false;
        }
        while (byteBufferWrap.remaining() > 0) {
            int iPosition = byteBufferWrap.position();
            int i = byteBufferWrap.getInt();
            if (getString(byteBufferWrap).equals(s.d(new byte[]{84, 81, 81, 3, 13}, "540ad1"))) {
                while (byteBufferWrap.position() < iPosition + i) {
                    int iPosition2 = byteBufferWrap.position();
                    byte b = byteBufferWrap.get();
                    int i2 = byteBufferWrap.getInt();
                    if (b != 1) {
                        byteBufferWrap.position(iPosition2 + i2);
                    } else {
                        while (byteBufferWrap.position() < iPosition2 + i2) {
                            int uleb128 = getUleb128(byteBufferWrap);
                            if (uleb128 == 6) {
                                elfData.att_arch = CPU_archs[getUleb128(byteBufferWrap)];
                            } else if (uleb128 == 27) {
                                getUleb128(byteBufferWrap);
                                elfData.att_fpu = true;
                            } else {
                                int i3 = uleb128 % 128;
                                if (i3 == 4 || i3 == 5 || i3 == 32 || (i3 > 32 && (i3 & 1) != 0)) {
                                    getString(byteBufferWrap);
                                } else {
                                    getUleb128(byteBufferWrap);
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
        return true;
    }

    private static boolean readHeader(RandomAccessFile randomAccessFile, ElfData elfData) throws IOException {
        byte b;
        byte[] bArr = new byte[52];
        randomAccessFile.readFully(bArr);
        if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70 || ((b = bArr[4]) != 1 && b != 2)) {
            Log.e(TAG, s.d(new byte[]{114, 123, 32, 16, 91, 92, 0, 0, 3, 16, 17, 12, 89, 65, 7, 92, 90, 93}, "77f039"));
            return false;
        }
        elfData.is64bits = b == 2;
        elfData.order = bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(elfData.order);
        elfData.e_machine = byteBufferWrap.getShort(18);
        elfData.e_shoff = byteBufferWrap.getInt(32);
        elfData.e_shnum = byteBufferWrap.getShort(48);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0079: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:32:0x0079 */
    private static ElfData readLib(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3 = null;
        Object[] objArr = 0;
        try {
            try {
                RandomAccessFile randomAccessFile4 = new RandomAccessFile(file, s.d(new byte[]{74}, "8de726"));
                try {
                    ElfData elfData = new ElfData(objArr == true ? 1 : 0);
                    if (!readHeader(randomAccessFile4, elfData)) {
                        close(randomAccessFile4);
                        return null;
                    }
                    int i = elfData.e_machine;
                    if (i != 3 && i != 8) {
                        if (i == 40) {
                            randomAccessFile4.close();
                            randomAccessFile = new RandomAccessFile(file, s.d(new byte[]{68}, "66bace"));
                            try {
                                if (!readSection(randomAccessFile, elfData)) {
                                    close(randomAccessFile);
                                    return null;
                                }
                                randomAccessFile.close();
                                randomAccessFile4 = new RandomAccessFile(file, s.d(new byte[]{Ascii.DC4}, "f160a7"));
                                boolean armAttributes = readArmAttributes(randomAccessFile4, elfData);
                                close(randomAccessFile4);
                                if (armAttributes) {
                                    return elfData;
                                }
                                return null;
                            } catch (IOException e) {
                                e = e;
                            }
                        } else if (i != 62 && i != 183) {
                            close(randomAccessFile4);
                            return null;
                        }
                    }
                    close(randomAccessFile4);
                    return elfData;
                } catch (IOException e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile4;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile3 = randomAccessFile4;
                    close(randomAccessFile3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile3 = randomAccessFile2;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
        }
        e.printStackTrace();
        close(randomAccessFile);
        return null;
    }

    private static boolean readSection(RandomAccessFile randomAccessFile, ElfData elfData) throws IOException {
        byte[] bArr = new byte[40];
        randomAccessFile.seek(elfData.e_shoff);
        for (int i = 0; i < elfData.e_shnum; i++) {
            randomAccessFile.readFully(bArr);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.order(elfData.order);
            if (byteBufferWrap.getInt(4) == SHT_ARM_ATTRIBUTES) {
                elfData.sh_offset = byteBufferWrap.getInt(16);
                elfData.sh_size = byteBufferWrap.getInt(20);
                return true;
            }
        }
        return false;
    }

    private static File searchLibrary(ApplicationInfo applicationInfo) {
        String str;
        String strD;
        String[] strArrSplit = (applicationInfo.flags & 1) != 0 ? System.getProperty(s.d(new byte[]{82, 87, Ascii.DC4, 87, Ascii.RS, 92, 8, 6, Ascii.DC4, 3, 67, Ascii.FS, Ascii.SYN, 70, 3, 66, 88}, "86b600")).split(s.d(new byte[]{10}, "013efd")) : new String[]{applicationInfo.nativeLibraryDir};
        if (strArrSplit[0] == null) {
            str = TAG;
            strD = s.d(new byte[]{6, 83, 95, 16, SignedBytes.MAX_POWER_OF_TWO, 69, 7, 13, 8, 6, 17, 9, 12, 80, 67, 86, 70, Ascii.FS, 65, Ascii.DC4, 7, Ascii.SYN, 89}, "e2174e");
        } else {
            for (String str2 : strArrSplit) {
                File file = new File(str2, s.d(new byte[]{95, 88, 1, Ascii.DC4, 13, 0, 11, 10, 15, 76, 66, 10}, "31cbac"));
                if (file.exists() && file.canRead()) {
                    return file;
                }
            }
            str = TAG;
            strD = s.d(new byte[]{99, 35, 103, 42, 42, 124, 38, 94, 70, 33, 80, 11, 19, Ascii.SYN, Ascii.NAK, 2, 10, 92, 5, 68, Ascii.NAK, 10, 80, Ascii.ETB, 81, 6, Ascii.NAK, 8, 10, 80, 19, 5, Ascii.DC4, Ascii.ESC}, "4b5dc2");
        }
        Log.e(str, strD);
        return null;
    }
}
