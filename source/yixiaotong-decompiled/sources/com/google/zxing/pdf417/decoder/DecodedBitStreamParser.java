package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class DecodedBitStreamParser {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = null;
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = {';', Typography.less, Typography.greater, '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', FilenameUtils.EXTENSION_SEPARATOR, Typography.dollar, IOUtils.DIR_SEPARATOR_UNIX, Typography.quote, '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', Typography.amp, '\r', '\t', ',', ':', '#', '-', FilenameUtils.EXTENSION_SEPARATOR, Typography.dollar, IOUtils.DIR_SEPARATOR_UNIX, '+', '%', '*', '=', '^'};
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] modeArrValuesCustom = values();
            int length = modeArrValuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(modeArrValuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Mode.valuesCustom().length];
        try {
            iArr2[Mode.ALPHA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Mode.ALPHA_SHIFT.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Mode.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Mode.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Mode.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Mode.PUNCT_SHIFT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr2;
        return iArr2;
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int iTextCompaction;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = DEFAULT_ENCODING;
        int i = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        for (int i2 = 2; i2 < iArr[0]; i2 = iTextCompaction + 1) {
            if (i != 913) {
                switch (i) {
                    case 900:
                        iTextCompaction = textCompaction(iArr, i2, sb);
                        break;
                    case 901:
                        iTextCompaction = byteCompaction(i, iArr, charset, i2, sb);
                        break;
                    case 902:
                        iTextCompaction = numericCompaction(iArr, i2, sb);
                        break;
                    default:
                        switch (i) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                iTextCompaction = byteCompaction(i, iArr, charset, i2, sb);
                                break;
                            case 925:
                                iTextCompaction = i2 + 1;
                                break;
                            case 926:
                                iTextCompaction = i2 + 2;
                                break;
                            case 927:
                                int i3 = i2 + 1;
                                Charset charsetForName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                iTextCompaction = i3;
                                charset = charsetForName;
                                break;
                            case 928:
                                iTextCompaction = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                iTextCompaction = textCompaction(iArr, i2 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                sb.append((char) iArr[i2]);
                iTextCompaction = i2 + 1;
            }
            if (iTextCompaction < iArr.length) {
                i = iArr[iTextCompaction];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iTextCompaction = textCompaction(iArr, i, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i3 = iArr[iTextCompaction];
        if (i3 != 923) {
            if (i3 != 922) {
                return iTextCompaction;
            }
            pDF417ResultMetadata.setLastSegment(true);
            return iTextCompaction + 1;
        }
        int i4 = iTextCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr3[i5] = i7;
                i5++;
                i4 = i6;
            } else if (i7 == 922) {
                pDF417ResultMetadata.setLastSegment(true);
                i4 += 2;
                z = true;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0037. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) * 2];
        int[] iArr3 = new int[(i2 - i) * 2];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                z = true;
            } else {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = Mode.ALPHA;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c = ' ';
            switch ($SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode()[mode2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i4 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i4 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    break;
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 != 27) {
                            if (i4 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c = 0;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c = 0;
                        Mode mode5 = mode;
                        mode3 = mode2;
                        mode2 = mode5;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c = MIXED_CHARS[i4];
                    } else {
                        if (i4 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c = 0;
                                Mode mode6 = mode;
                                mode3 = mode2;
                                mode2 = mode6;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c = 0;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                    } else {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    break;
                case 5:
                    if (i4 < 26) {
                        c = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        mode2 = i4 == 900 ? Mode.ALPHA : mode3;
                        c = 0;
                        break;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                        mode2 = mode3;
                    } else {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    break;
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 922;
        int i7 = 923;
        int i8 = 928;
        long j = 900;
        if (i == 901) {
            int[] iArr2 = new int[6];
            i3 = i2 + 1;
            int i9 = iArr[i2];
            long j2 = 0;
            boolean z = false;
            int i10 = 0;
            while (true) {
                i4 = iArr[0];
                if (i3 >= i4 || z) {
                    break;
                }
                int i11 = i10 + 1;
                iArr2[i10] = i9;
                j2 = (j2 * j) + ((long) i9);
                int i12 = i3 + 1;
                i9 = iArr[i3];
                if (i9 == 900 || i9 == 901 || i9 == 902 || i9 == 924 || i9 == 928 || i9 == i7 || i9 == i6) {
                    i10 = i11;
                    i6 = 922;
                    i7 = 923;
                    j = 900;
                    z = true;
                } else if (i11 % 5 != 0 || i11 <= 0) {
                    i3 = i12;
                    i10 = i11;
                    i6 = 922;
                    i7 = 923;
                    j = 900;
                } else {
                    int i13 = 0;
                    while (i13 < 6) {
                        byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                        i13++;
                        i6 = 922;
                        i7 = 923;
                    }
                    i3 = i12;
                    i10 = 0;
                    j = 900;
                    j2 = 0;
                }
            }
            if (i3 != i4 || i9 >= 900) {
                i5 = i10;
            } else {
                i5 = i10 + 1;
                iArr2[i10] = i9;
            }
            for (int i14 = 0; i14 < i5; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == 924) {
            int i15 = i2;
            boolean z2 = false;
            int i16 = 0;
            loop3: while (true) {
                long j3 = 0;
                while (true) {
                    if (i15 >= iArr[0] || z2) {
                        break loop3;
                    }
                    int i17 = i15 + 1;
                    int i18 = iArr[i15];
                    if (i18 < 900) {
                        i16++;
                        j3 = (j3 * 900) + ((long) i18);
                        i15 = i17;
                    } else {
                        if (i18 != 900 && i18 != 901 && i18 != 902 && i18 != 924 && i18 != i8) {
                            if (i18 != 923 && i18 != 922) {
                                i15 = i17;
                            }
                        }
                        z2 = true;
                    }
                    if (i16 % 5 != 0 || i16 <= 0) {
                        i8 = 928;
                    }
                }
                for (int i19 = 0; i19 < 6; i19++) {
                    byteArrayOutputStream.write((byte) (j3 >> ((5 - i19) * 8)));
                }
                i16 = 0;
                i8 = 928;
            }
            i3 = i15;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0007 A[SYNTHETIC] */
    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i >= i3 || z) {
                break;
            }
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == i3) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i2] = i5;
                i2++;
            } else {
                if (i5 == 900 || i5 == 901 || i5 == 924 || i5 == 928 || i5 == 923 || i5 == 922) {
                    z = true;
                }
                if (i2 % 15 != 0 || i5 == 902 || z) {
                    if (i2 > 0) {
                        sb.append(decodeBase900toBase10(iArr2, i2));
                        i2 = 0;
                    }
                }
            }
            i = i4;
            if (i2 % 15 != 0) {
            }
            if (i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return string.substring(1);
    }
}
