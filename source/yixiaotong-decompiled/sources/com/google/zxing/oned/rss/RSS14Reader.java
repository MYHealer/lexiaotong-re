package com.google.zxing.oned.rss;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        int size = this.possibleLeftPairs.size();
        for (int i2 = 0; i2 < size; i2++) {
            Pair pair = this.possibleLeftPairs.get(i2);
            if (pair.getCount() > 1) {
                int size2 = this.possibleRightPairs.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Pair pair2 = this.possibleRightPairs.get(i3);
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair == null) {
            return;
        }
        for (Pair pair2 : collection) {
            if (pair2.getValue() == pair.getValue()) {
                pair2.incrementCount();
                return;
            }
        }
        collection.add(pair);
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String strValueOf = String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int iCharAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                iCharAt *= 3;
            }
            i += iCharAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(sb.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        try {
            int[] iArrFindFinderPattern = findFinderPattern(bitArray, 0, z);
            FinderPattern foundFinderPattern = parseFoundFinderPattern(bitArray, i, z, iArrFindFinderPattern);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float size = (iArrFindFinderPattern[0] + iArrFindFinderPattern[1]) / 2.0f;
                if (z) {
                    size = (bitArray.getSize() - 1) - size;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(size, i));
            }
            DataCharacter dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, true);
            DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, false);
            return new Pair((dataCharacterDecodeDataCharacter.getValue() * 1597) + dataCharacterDecodeDataCharacter2.getValue(), dataCharacterDecodeDataCharacter.getChecksumPortion() + (dataCharacterDecodeDataCharacter2.getChecksumPortion() * 4), foundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f3 A[PHI: r4
  0x00f3: PHI (r4v13 ??) = (r4v16 ??), (r4v10 ??) binds: [B:40:0x00f1, B:43:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r11v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r12v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [int] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        ?? r4;
        ?? r3;
        int[] dataCharacterCounters = getDataCharacterCounters();
        boolean z2 = false;
        dataCharacterCounters[0] = 0;
        boolean z3 = true;
        z3 = true;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int length = dataCharacterCounters.length - 1;
            int i = 0;
            while (i < length) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
                length--;
                z2 = false;
                z3 = true;
            }
        }
        int i3 = z ? 16 : 15;
        float fCount = count(dataCharacterCounters) / i3;
        ?? oddCounts = getOddCounts();
        ?? evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        ?? r5 = z3;
        for (?? r0 = z2; r0 < dataCharacterCounters.length; r0++) {
            float f = dataCharacterCounters[r0] / fCount;
            int i4 = (int) (f + 0.5f);
            if (i4 < r5) {
                r4 = r5;
                r3 = i4;
                r4 = r5;
                r3 = r4;
            } else {
                r4 = 8;
                if (i4 > 8) {
                    r4 = r5;
                    r3 = i4;
                    r4 = r5;
                    r3 = r4;
                }
            }
            r4 = r5;
            r3 = i4;
            int i5 = r0 / 2;
            if ((r0 & 1) == 0) {
                oddCounts[i5] = r3;
                oddRoundingErrors[i5] = f - ((float) r3);
            } else {
                evenCounts[i5] = r3;
                evenRoundingErrors[i5] = f - ((float) r3);
            }
            z2 = false;
            r5 = 1;
        }
        adjustOddEvenCounts(z, i3);
        boolean z4 = z2;
        ?? r8 = z4;
        int length2 = oddCounts.length - r5;
        ?? r2 = z4;
        while (length2 >= 0) {
            ?? r9 = oddCounts[length2];
            length2--;
            r2 = (r2 * 9) + r9;
            r8 += r9;
        }
        boolean z5 = z2;
        ?? r10 = z5;
        int length3 = evenCounts.length - r5;
        ?? r11 = z5;
        while (length3 >= 0) {
            ?? r13 = evenCounts[length3];
            length3--;
            r11 = (r11 * 9) + r13;
            r10 += r13;
        }
        int i6 = r2 + (r11 * 3);
        if (!z) {
            if ((r10 & 1) != 0 || r10 > 10 || r10 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i7 = (10 - r10) / 2;
            int i8 = INSIDE_ODD_WIDEST[i7];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i8, z2) * INSIDE_ODD_TOTAL_SUBSET[i7]) + RSSUtils.getRSSvalue(oddCounts, i8, r5) + INSIDE_GSUM[i7], i6);
        }
        if ((r8 & 1) != 0 || r8 > 12 || r8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i9 = (12 - r8) / 2;
        int i10 = OUTSIDE_ODD_WIDEST[i9];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i10, z2) * OUTSIDE_EVEN_TOTAL_SUBSET[i9]) + RSSUtils.getRSSvalue(evenCounts, 9 - i10, r5) + OUTSIDE_GSUM[i9], i6);
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (z == z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) ^ z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else {
                    if (isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i2, i};
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int size;
        int i2;
        boolean z2 = bitArray.get(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && (bitArray.get(i3) ^ z2)) {
            i3--;
        }
        int i4 = i3 + 1;
        int i5 = iArr[0] - i4;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i5;
        int finderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i6 = iArr[1];
        if (z) {
            int size2 = (bitArray.getSize() - 1) - i4;
            size = (bitArray.getSize() - 1) - i6;
            i2 = size2;
        } else {
            size = i6;
            i2 = i4;
        }
        return new FinderPattern(finderValue, new int[]{i4, iArr[1]}, i2, size, i);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004d A[PHI: r7 r8
  0x004d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v10 boolean) binds: [B:30:0x004b, B:18:0x0034] A[DONT_GENERATE, DONT_INLINE]
  0x004d: PHI (r8v4 boolean) = (r8v2 boolean), (r8v14 boolean) binds: [B:30:0x004b, B:18:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0051 A[PHI: r7 r8
  0x0051: PHI (r7v5 boolean) = (r7v2 boolean), (r7v10 boolean) binds: [B:32:0x004f, B:20:0x0037] A[DONT_GENERATE, DONT_INLINE]
  0x0051: PHI (r8v5 boolean) = (r8v2 boolean), (r8v14 boolean) binds: [B:32:0x004f, B:20:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x0054 A[PHI: r7 r8
  0x0054: PHI (r7v7 boolean) = (r7v2 boolean), (r7v10 boolean) binds: [B:32:0x004f, B:20:0x0037] A[DONT_GENERATE, DONT_INLINE]
  0x0054: PHI (r8v11 boolean) = (r8v2 boolean), (r8v14 boolean) binds: [B:32:0x004f, B:20:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x009b  */
    /* JADX WARN: Code duplicated, block: B:70:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:75:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        int iCount = count(getOddCounts());
        int iCount2 = count(getEvenCounts());
        int i2 = (iCount + iCount2) - i;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = (iCount & 1) == z;
        boolean z8 = (iCount2 & 1) == 1;
        if (z) {
            if (iCount > 12) {
                z2 = false;
                z3 = true;
            } else if (iCount < 4) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iCount2 > 12) {
                z4 = true;
            } else if (iCount2 < 4) {
                z4 = false;
                z5 = true;
            } else {
                z4 = false;
            }
        } else {
            if (iCount > 11) {
                z2 = false;
                z3 = true;
            } else if (iCount < 5) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iCount2 > 10) {
                z4 = true;
            } else if (iCount2 < 4) {
                z4 = false;
                z5 = true;
            } else {
                z4 = false;
            }
        }
        if (i2 != 1) {
            if (i2 == -1) {
                if (z7) {
                    if (z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z5 = true;
                }
            } else {
                if (i2 != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z7) {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (iCount < iCount2) {
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = true;
                    }
                } else if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z6) {
                if (!z3) {
                    throw NotFoundException.getNotFoundInstance();
                }
                increment(getOddCounts(), getOddRoundingErrors());
            }
            if (z3) {
                decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z5) {
                if (!z4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                increment(getEvenCounts(), getOddRoundingErrors());
            }
            if (z4) {
                decrement(getEvenCounts(), getEvenRoundingErrors());
            }
        }
        if (z7) {
            if (z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z3 = true;
        } else {
            if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z4 = true;
        }
        z6 = z2;
        if (z6) {
            if (!z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z5) {
            if (!z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
