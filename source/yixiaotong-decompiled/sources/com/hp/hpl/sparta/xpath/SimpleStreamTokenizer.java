package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SimpleStreamTokenizer {
    private static final int QUOTE = -6;
    public static final int TT_EOF = -1;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    private static final int WHITESPACE = -5;
    private int nextType_;
    private final Reader reader_;
    public int ttype = Integer.MIN_VALUE;
    public int nval = Integer.MIN_VALUE;
    public String sval = "";
    private final StringBuffer buf_ = new StringBuffer();
    private final int[] charType_ = new int[256];
    private boolean pushedBack_ = false;
    private char inQuote_ = 0;

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        char c = 0;
        this.reader_ = reader;
        while (true) {
            int[] iArr = this.charType_;
            if (c >= iArr.length) {
                nextToken();
                return;
            }
            if (('A' <= c && c <= 'Z') || (('a' <= c && c <= 'z') || c == '-')) {
                iArr[c] = -3;
            } else if ('0' <= c && c <= '9') {
                iArr[c] = -2;
            } else if (c < 0 || c > ' ') {
                iArr[c] = c;
            } else {
                iArr[c] = -5;
            }
            c = (char) (c + 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a8  */
    public int nextToken() throws IOException {
        int i;
        int i2;
        char c;
        boolean z;
        boolean z2;
        String string;
        int i3;
        int i4;
        if (this.pushedBack_) {
            this.pushedBack_ = false;
            return this.ttype;
        }
        this.ttype = this.nextType_;
        do {
            boolean z3 = false;
            do {
                i = this.reader_.read();
                if (i != -1) {
                    i2 = this.charType_[i];
                } else {
                    if (this.inQuote_ != 0) {
                        throw new IOException("Unterminated quote");
                    }
                    i2 = -1;
                }
                c = this.inQuote_;
                z = c == 0 && i2 == -5;
                z3 = z3 || z;
            } while (z);
            if (i2 == 39 || i2 == 34) {
                if (c == 0) {
                    this.inQuote_ = (char) i2;
                } else if (c == i2) {
                    this.inQuote_ = (char) 0;
                }
            }
            char c2 = this.inQuote_;
            if (c2 != 0) {
                i2 = c2;
            }
            z2 = z3 || !(((i4 = this.ttype) < -1 || i4 == 39 || i4 == 34) && i4 == i2);
            if (z2) {
                int i5 = this.ttype;
                if (i5 != -3) {
                    if (i5 == -2) {
                        this.nval = Integer.parseInt(this.buf_.toString());
                        this.buf_.setLength(0);
                    } else if (i5 == 34 || i5 == 39) {
                        string = this.buf_.toString().substring(1, this.buf_.length() - 1);
                    }
                    if (i2 != -5) {
                        if (i2 == -6) {
                            i3 = i;
                        } else {
                            i3 = i2;
                        }
                        this.nextType_ = i3;
                    }
                } else {
                    string = this.buf_.toString();
                }
                this.sval = string;
                this.buf_.setLength(0);
                if (i2 != -5) {
                    if (i2 == -6) {
                        i3 = i;
                    } else {
                        i3 = i2;
                    }
                    this.nextType_ = i3;
                }
            }
            if (i2 == -3 || i2 == -2 || i2 == 34 || i2 == 39) {
                this.buf_.append((char) i);
            }
        } while (!z2);
        return this.ttype;
    }

    public void ordinaryChar(char c) {
        this.charType_[c] = c;
    }

    public void pushBack() {
        this.pushedBack_ = true;
    }

    public String toString() {
        int i = this.ttype;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.nval);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                return i != 39 ? new StringBuffer("'").append((char) this.ttype).append("'").toString() : new StringBuffer("'").append(this.sval).append("'").toString();
            }
        }
        return new StringBuffer("\"").append(this.sval).append("\"").toString();
    }

    public void wordChars(char c, char c2) {
        while (c <= c2) {
            this.charType_[c] = -3;
            c = (char) (c + 1);
        }
    }
}
