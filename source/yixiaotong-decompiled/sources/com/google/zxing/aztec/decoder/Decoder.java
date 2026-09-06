package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.util.i;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.am;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class Decoder {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table;
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", PPSLabelView.Code, "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", PPSLabelView.Code, "a", t.l, "c", t.t, "e", "f", OapsKey.KEY_GRADE, IAdInterListener.AdReqParam.HEIGHT, "i", "j", t.f4727a, t.d, "m", "n", "o", "p", "q", t.k, "s", "t", "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", PPSLabelView.Code, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", IOUtils.LINE_SEPARATOR_UNIX, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", IOUtils.LINE_SEPARATOR_WINDOWS, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", x.A, ".", "/", x.bQ, ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", i.d, "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", PPSLabelView.Code, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Table[] valuesCustom() {
            Table[] tableArrValuesCustom = values();
            int length = tableArrValuesCustom.length;
            Table[] tableArr = new Table[length];
            System.arraycopy(tableArrValuesCustom, 0, tableArr, 0, length);
            return tableArr;
        }
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Table.valuesCustom().length];
        try {
            iArr2[Table.BINARY.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Table.DIGIT.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Table.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Table.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Table.PUNCT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Table.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table = iArr2;
        return iArr2;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(aztecDetectorResult.getBits()))), null, null);
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            if (table2 != Table.BINARY) {
                int i2 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int code = readCode(zArr, i, i2);
                i += i2;
                String character = getCharacter(table2, code);
                if (character.startsWith("CTRL_")) {
                    Table table3 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table = table3;
                    } else {
                        table2 = table3;
                    }
                } else {
                    sb.append(character);
                }
                table2 = table;
            } else {
                if (length - i < 5) {
                    break;
                }
                int code2 = readCode(zArr, i, 5);
                int i3 = i + 5;
                if (code2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    code2 = readCode(zArr, i3, 11) + 31;
                    i3 = i + 16;
                }
                int i4 = i3;
                int i5 = code2;
                int i6 = i4;
                int i7 = 0;
                while (true) {
                    if (i7 >= i5) {
                        i = i6;
                        break;
                    }
                    if (length - i6 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i6, 8));
                    i6 += 8;
                    i7++;
                }
                table2 = table;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        if (c == 'L') {
            return Table.LOWER;
        }
        if (c == 'M') {
            return Table.MIXED;
        }
        return Table.UPPER;
    }

    private static String getCharacter(Table table, int i) {
        int i2 = $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table()[table.ordinal()];
        if (i2 == 1) {
            return UPPER_TABLE[i];
        }
        if (i2 == 2) {
            return LOWER_TABLE[i];
        }
        if (i2 == 3) {
            return MIXED_TABLE[i];
        }
        if (i2 == 4) {
            return DIGIT_TABLE[i];
        }
        if (i2 == 5) {
            return PUNCT_TABLE[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        int i;
        GenericGF genericGF;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i = 6;
        } else {
            i = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = GenericGF.AZTEC_DATA_10;
                i = 10;
            } else {
                genericGF = GenericGF.AZTEC_DATA_12;
                i = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i;
        int i2 = length - nbDatablocks;
        int[] iArr = new int[length];
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = readCode(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, i2);
            int i4 = 1 << i;
            int i5 = i4 - 1;
            int i6 = 0;
            for (int i7 = 0; i7 < nbDatablocks; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0 || i8 == i5) {
                    throw FormatException.getFormatInstance();
                }
                if (i8 == 1 || i8 == i4 - 2) {
                    i6++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i) - i6];
            int i9 = 0;
            for (int i10 = 0; i10 < nbDatablocks; i10++) {
                int i11 = iArr[i10];
                if (i11 == 1 || i11 == i4 - 2) {
                    Arrays.fill(zArr2, i9, (i9 + i) - 1, i11 > 1);
                    i9 += i - 1;
                } else {
                    int i12 = i - 1;
                    while (i12 >= 0) {
                        int i13 = i9 + 1;
                        zArr2[i9] = ((1 << i12) & i11) != 0;
                        i12--;
                        i9 = i13;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    boolean[] extractBits(BitMatrix bitMatrix) {
        boolean zIsCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i = nbLayers * 4;
        int i2 = zIsCompact ? i + 11 : i + 14;
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, zIsCompact)];
        int i3 = 2;
        if (zIsCompact) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            int i7 = 0;
            while (i7 < i5) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
                i7++;
                i3 = 2;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < nbLayers; i10++) {
            int i11 = (nbLayers - i10) * 4;
            int i12 = zIsCompact ? i11 + 9 : i11 + 12;
            int i13 = i10 * 2;
            int i14 = (i2 - 1) - i13;
            for (int i15 = 0; i15 < i12; i15++) {
                int i16 = i15 * 2;
                int i17 = 0;
                while (i17 < i3) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i9 + i16 + i17] = bitMatrix.get(iArr[i18], iArr[i19]);
                    int i20 = i14 - i17;
                    zArr[(i12 * 2) + i9 + i16 + i17] = bitMatrix.get(iArr[i19], iArr[i20]);
                    int i21 = i14 - i15;
                    zArr[(i12 * 4) + i9 + i16 + i17] = bitMatrix.get(iArr[i20], iArr[i21]);
                    zArr[(i12 * 6) + i9 + i16 + i17] = bitMatrix.get(iArr[i21], iArr[i18]);
                    i17++;
                    i3 = 2;
                }
            }
            i9 += i12 * 8;
        }
        return zArr;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }
}
