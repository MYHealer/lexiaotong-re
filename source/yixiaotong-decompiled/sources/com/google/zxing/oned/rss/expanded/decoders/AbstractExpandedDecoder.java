package com.google.zxing.oned.rss.expanded.decoders;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    protected final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    protected final BitArray getInformation() {
        return this.information;
    }

    public abstract String parseInformation() throws NotFoundException, FormatException;

    AbstractExpandedDecoder(BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new GeneralAppIdDecoder(bitArray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new AI01AndOtherAIs(bitArray);
        }
        if (!bitArray.get(2)) {
            return new AnyAIDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
        if (iExtractNumericValueFromBitArray == 4) {
            return new AI013103decoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray == 5) {
            return new AI01320xDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
        if (iExtractNumericValueFromBitArray2 == 12) {
            return new AI01392xDecoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray2 == 13) {
            return new AI01393xDecoder(bitArray);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
            case 56:
                return new AI013x0x1xDecoder(bitArray, "310", "11");
            case 57:
                return new AI013x0x1xDecoder(bitArray, "320", "11");
            case 58:
                return new AI013x0x1xDecoder(bitArray, "310", BaseWrapper.ENTER_ID_GAME_CENTER);
            case 59:
                return new AI013x0x1xDecoder(bitArray, "320", BaseWrapper.ENTER_ID_GAME_CENTER);
            case 60:
                return new AI013x0x1xDecoder(bitArray, "310", "15");
            case 61:
                return new AI013x0x1xDecoder(bitArray, "320", "15");
            case 62:
                return new AI013x0x1xDecoder(bitArray, "310", BaseWrapper.ENTER_ID_17);
            case 63:
                return new AI013x0x1xDecoder(bitArray, "320", BaseWrapper.ENTER_ID_17);
            default:
                throw new IllegalStateException("unknown decoder: " + bitArray);
        }
    }
}
