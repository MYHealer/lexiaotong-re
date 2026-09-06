package com.hihonor.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private final String T;
    private int U;
    private int V;
    private char[] W;
    private int end;
    private final int length;
    private int pos;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.T = name;
        this.length = name.length();
    }

    private String e() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        int i6;
        char c2;
        char c3;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i >= i2 || this.W[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.U = i;
        this.pos = i + 1;
        while (true) {
            i3 = this.pos;
            i4 = this.length;
            if (i3 >= i4 || (c3 = this.W[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.pos = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.T);
        }
        this.end = i3;
        if (this.W[i3] == ' ') {
            while (true) {
                i5 = this.pos;
                i6 = this.length;
                if (i5 >= i6 || (c2 = this.W[i5]) == '=' || c2 != ' ') {
                    break;
                }
                this.pos = i5 + 1;
            }
            if (this.W[i5] != '=' || i5 == i6) {
                throw new IllegalStateException("Unexpected end of DN: " + this.T);
            }
        }
        this.pos++;
        while (true) {
            int i7 = this.pos;
            if (i7 >= this.length || this.W[i7] != ' ') {
                break;
            }
            this.pos = i7 + 1;
        }
        int i8 = this.end;
        int i9 = this.U;
        if (i8 - i9 > 4) {
            char[] cArr = this.W;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.U = i9 + 4;
            }
        }
        char[] cArr2 = this.W;
        int i10 = this.U;
        return new String(cArr2, i10, this.end - i10);
    }

    private String f() {
        int i = this.pos + 1;
        this.pos = i;
        this.U = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.T);
            }
            char[] cArr = this.W;
            char c = cArr[i2];
            if (c == '\"') {
                this.pos = i2 + 1;
                while (true) {
                    int i3 = this.pos;
                    if (i3 >= this.length || this.W[i3] != ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
                char[] cArr2 = this.W;
                int i4 = this.U;
                return new String(cArr2, i4, this.end - i4);
            }
            if (c == '\\') {
                cArr[this.end] = i();
            } else {
                cArr[this.end] = c;
            }
            this.pos++;
            this.end++;
        }
    }

    private String g() {
        char[] cArr;
        char c;
        int i = this.pos;
        if (i + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.T);
        }
        this.U = i;
        this.pos = i + 1;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length || (c = (cArr = this.W)[i2]) == '+' || c == ',' || c == ';') {
                this.end = i2;
                break;
            }
            if (c == ' ') {
                this.end = i2;
                this.pos = i2 + 1;
                while (true) {
                    int i3 = this.pos;
                    if (i3 >= this.length || this.W[i3] != ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.pos = i2 + 1;
            }
        }
        int i4 = this.end;
        int i5 = this.U;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.T);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (byte b = 0; b < i7; b = (byte) (b + 1)) {
            bArr[b] = (byte) a(i8);
            i8 += 2;
        }
        return new String(this.W, this.U, i6);
    }

    private String h() {
        int i;
        int i2;
        char c;
        int i3 = this.pos;
        this.U = i3;
        this.end = i3;
        while (true) {
            int i4 = this.pos;
            if (i4 >= this.length) {
                char[] cArr = this.W;
                int i5 = this.U;
                return new String(cArr, i5, this.end - i5);
            }
            char[] cArr2 = this.W;
            char c2 = cArr2[i4];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 == '\\') {
                        int i6 = this.end;
                        this.end = i6 + 1;
                        cArr2[i6] = i();
                        this.pos++;
                    } else if (c2 != '+' && c2 != ',') {
                        int i7 = this.end;
                        this.end = i7 + 1;
                        cArr2[i7] = c2;
                        this.pos = i4 + 1;
                    }
                }
                char[] cArr3 = this.W;
                int i8 = this.U;
                return new String(cArr3, i8, this.end - i8);
            }
            int i9 = this.end;
            this.V = i9;
            this.pos = i4 + 1;
            this.end = i9 + 1;
            cArr2[i9] = ' ';
            while (true) {
                i = this.pos;
                i2 = this.length;
                if (i >= i2) {
                    break;
                }
                char[] cArr4 = this.W;
                if (cArr4[i] != ' ') {
                    break;
                }
                int i10 = this.end;
                this.end = i10 + 1;
                cArr4[i10] = ' ';
                this.pos = i + 1;
            }
            if (i == i2 || (c = this.W[i]) == ',' || c == '+' || c == ';') {
                char[] cArr5 = this.W;
                int i11 = this.U;
                return new String(cArr5, i11, this.V - i11);
            }
        }
    }

    private char i() {
        int i = this.pos + 1;
        this.pos = i;
        if (i == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.T);
        }
        char c = this.W[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return j();
                }
        }
    }

    private char j() {
        int i;
        byte b;
        int iA = a(this.pos);
        this.pos++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i = iA & 31;
            b = 1;
        } else if (iA <= 239) {
            i = iA & 15;
            b = 2;
        } else {
            i = iA & 7;
            b = 3;
        }
        for (byte b2 = 0; b2 < b; b2 = (byte) (b2 + 1)) {
            int i2 = this.pos;
            int i3 = i2 + 1;
            this.pos = i3;
            if (i3 == this.length || this.W[i3] != '\\') {
                return '?';
            }
            int i4 = i2 + 2;
            this.pos = i4;
            int iA2 = a(i4);
            this.pos++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (iA2 & 63);
        }
        return (char) i;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.T);
        }
        char[] cArr = this.W;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.T);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.T);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public String findMostSpecific(String str) {
        String strF;
        this.pos = 0;
        this.U = 0;
        this.end = 0;
        this.V = 0;
        this.W = this.T.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.W[i];
            if (c == '\"') {
                strF = f();
            } else if (c == '#') {
                strF = g();
            } else {
                strF = (c == '+' || c == ',' || c == ';') ? "" : h();
            }
            if (str.equalsIgnoreCase(strE)) {
                return strF;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char c2 = this.W[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.T);
            }
            this.pos = i2 + 1;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.T);
    }

    public List<String> a(String str) {
        String strF;
        this.pos = 0;
        this.U = 0;
        this.end = 0;
        this.V = 0;
        this.W = this.T.toCharArray();
        List<String> listEmptyList = Collections.emptyList();
        String strE = e();
        if (strE == null) {
            return listEmptyList;
        }
        do {
            int i = this.pos;
            if (i < this.length) {
                char c = this.W[i];
                if (c == '\"') {
                    strF = f();
                } else if (c == '#') {
                    strF = g();
                } else {
                    strF = (c == '+' || c == ',' || c == ';') ? "" : h();
                }
                if (str.equalsIgnoreCase(strE)) {
                    if (listEmptyList.isEmpty()) {
                        listEmptyList = new ArrayList<>();
                    }
                    listEmptyList.add(strF);
                }
                int i2 = this.pos;
                if (i2 < this.length) {
                    char c2 = this.W[i2];
                    if (c2 != ',' && c2 != ';' && c2 != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.T);
                    }
                    this.pos = i2 + 1;
                    strE = e();
                }
            }
            return listEmptyList;
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.T);
    }
}
