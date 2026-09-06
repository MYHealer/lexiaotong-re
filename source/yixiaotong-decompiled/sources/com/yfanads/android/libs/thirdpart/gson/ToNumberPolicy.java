package com.yfanads.android.libs.thirdpart.gson;

import com.yfanads.android.libs.thirdpart.gson.internal.LazilyParsedNumber;
import com.yfanads.android.libs.thirdpart.gson.stream.JsonReader;
import com.yfanads.android.libs.thirdpart.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE { // from class: com.yfanads.android.libs.thirdpart.gson.ToNumberPolicy.1
        @Override // com.yfanads.android.libs.thirdpart.gson.ToNumberStrategy
        public Double readNumber(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.yfanads.android.libs.thirdpart.gson.ToNumberPolicy.2
        @Override // com.yfanads.android.libs.thirdpart.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE { // from class: com.yfanads.android.libs.thirdpart.gson.ToNumberPolicy.3
        @Override // com.yfanads.android.libs.thirdpart.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strNextString));
                } catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPath(), e);
                }
            } catch (NumberFormatException unused) {
                Double dValueOf = Double.valueOf(strNextString);
                if ((dValueOf.isInfinite() || dValueOf.isNaN()) && !jsonReader.isLenient()) {
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPath());
                }
                return dValueOf;
            }
        }
    },
    BIG_DECIMAL { // from class: com.yfanads.android.libs.thirdpart.gson.ToNumberPolicy.4
        @Override // com.yfanads.android.libs.thirdpart.gson.ToNumberStrategy
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPath(), e);
            }
        }
    }
}
