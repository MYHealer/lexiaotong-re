package com.hp.hpl.sparta;

import com.google.android.exoplayer2.audio.WavUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class ParseByteStream implements ParseSource {
    private ParseCharStream parseSource_;

    public ParseByteStream(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        parseLog = parseLog == null ? ParseSource.DEFAULT_LOG : parseLog;
        if (!inputStream.markSupported()) {
            throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        }
        inputStream.mark(ParseSource.MAXLOOKAHEAD);
        byte[] bArr = new byte[4];
        str2 = str2 == null ? guessEncoding(str, bArr, inputStream.read(bArr), parseLog) : str2;
        try {
            inputStream.reset();
            try {
                this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding(str2)), parseLog, str2, parseHandler);
            } catch (IOException unused) {
                parseLog.note(new StringBuffer("Problem reading with assumed encoding of ").append(str2).append(" so restarting with euc-jp").toString(), str, 1);
                inputStream.reset();
                try {
                    this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding("euc-jp")), parseLog, (String) null, parseHandler);
                } catch (UnsupportedEncodingException unused2) {
                    throw new ParseException(parseLog, str, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                }
            }
        } catch (EncodingMismatchException e) {
            String declaredEncoding = e.getDeclaredEncoding();
            parseLog.note(new StringBuffer("Encoding declaration of ").append(declaredEncoding).append(" is different that assumed ").append(str2).append(" so restarting the parsing with the new encoding").toString(), str, 1);
            inputStream.reset();
            try {
                this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding(declaredEncoding)), parseLog, (String) null, parseHandler);
            } catch (UnsupportedEncodingException unused3) {
                throw new ParseException(parseLog, str, 1, 0, declaredEncoding, new StringBuffer("\"").append(declaredEncoding).append("\" is not a supported encoding").toString());
            }
        }
    }

    private static boolean equals(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    private static boolean equals(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }

    private static String fixEncoding(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    private static String guessEncoding(String str, byte[] bArr, int i, ParseLog parseLog) throws IOException {
        String str2;
        if (i == 4) {
            if (equals(bArr, 65279) || equals(bArr, -131072) || equals(bArr, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE) || equals(bArr, -16842752) || equals(bArr, 60) || equals(bArr, 1006632960) || equals(bArr, 15360) || equals(bArr, 3932160)) {
                str2 = "UCS-4";
            } else if (equals(bArr, 3932223)) {
                str2 = CharEncoding.UTF_16BE;
            } else if (equals(bArr, 1006649088)) {
                str2 = "UTF-16LE";
            } else if (!equals(bArr, 1010792557)) {
                if (equals(bArr, 1282385812)) {
                    str2 = "EBCDIC";
                } else if (equals(bArr, (short) -2) || equals(bArr, (short) -257)) {
                    str2 = "UTF-16";
                }
            }
            if (!str2.equals("UTF-8")) {
                parseLog.note(new StringBuffer("From start ").append(hex(bArr[0])).append(PPSLabelView.Code).append(hex(bArr[1])).append(PPSLabelView.Code).append(hex(bArr[2])).append(PPSLabelView.Code).append(hex(bArr[3])).append(" deduced encoding = ").append(str2).toString(), str, 1);
            }
            return str2;
        }
        parseLog.error(i <= 0 ? "no characters in input" : new StringBuffer("less than 4 characters in input: \"").append(new String(bArr, 0, i)).append("\"").toString(), str, 1);
        str2 = "UTF-8";
        if (!str2.equals("UTF-8")) {
            parseLog.note(new StringBuffer("From start ").append(hex(bArr[0])).append(PPSLabelView.Code).append(hex(bArr[1])).append(PPSLabelView.Code).append(hex(bArr[2])).append(PPSLabelView.Code).append(hex(bArr[3])).append(" deduced encoding = ").append(str2).toString(), str, 1);
        }
        return str2;
    }

    private static String hex(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        return new StringBuffer("0").append(hexString).toString();
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public int getLineNumber() {
        return this.parseSource_.getLineNumber();
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String getSystemId() {
        return this.parseSource_.getSystemId();
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String toString() {
        return this.parseSource_.toString();
    }
}
