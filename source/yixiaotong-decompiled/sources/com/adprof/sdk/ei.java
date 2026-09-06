package com.adprof.sdk;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b9 f257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final n6 f258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f256a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f259b = Long.MAX_VALUE;
    public int b = 2;
    public int c = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f260c = -1;

    public ei(n6 n6Var) {
        this.f258a = n6Var;
    }

    public final int a() throws IOException {
        int i;
        ((l6) this.f258a).a(1L);
        this.f256a++;
        byte bA = ((l6) this.f258a).a();
        if (bA >= 0) {
            return bA;
        }
        int i2 = bA & 127;
        ((l6) this.f258a).a(1L);
        this.f256a++;
        byte bA2 = ((l6) this.f258a).a();
        if (bA2 >= 0) {
            i = bA2 << 7;
        } else {
            i2 |= (bA2 & 127) << 7;
            ((l6) this.f258a).a(1L);
            this.f256a++;
            byte bA3 = ((l6) this.f258a).a();
            if (bA3 >= 0) {
                i = bA3 << 14;
            } else {
                i2 |= (bA3 & 127) << 14;
                ((l6) this.f258a).a(1L);
                this.f256a++;
                byte bA4 = ((l6) this.f258a).a();
                if (bA4 < 0) {
                    int i3 = i2 | ((bA4 & 127) << 21);
                    ((l6) this.f258a).a(1L);
                    this.f256a++;
                    byte bA5 = ((l6) this.f258a).a();
                    int i4 = i3 | (bA5 << Ascii.FS);
                    if (bA5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        ((l6) this.f258a).a(1L);
                        this.f256a++;
                        if (((l6) this.f258a).a() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i = bA4 << Ascii.NAK;
            }
        }
        return i2 | i;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final long m611a() throws IOException {
        if (this.b != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.b);
        }
        long j = this.f259b - this.f256a;
        ((l6) this.f258a).a(j);
        this.b = 6;
        this.f256a = this.f259b;
        this.f259b = this.f260c;
        this.f260c = -1L;
        return j;
    }

    public final void a(int i) throws IOException {
        if (this.b != i) {
            long j = this.f256a;
            long j2 = this.f259b;
            if (j > j2) {
                throw new IOException("Expected to end at " + this.f259b + " but was " + this.f256a);
            }
            if (j != j2) {
                this.b = 7;
                return;
            } else {
                this.f259b = this.f260c;
                this.f260c = -1L;
            }
        }
        this.b = 6;
    }

    public void a(long j) throws IOException {
        if (this.b != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.f1151a - 1;
        this.f1151a = i;
        if (i < 0 || this.f260c != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.f256a != this.f259b && i != 0) {
            throw new IOException("Expected to end at " + this.f259b + " but was " + this.f256a);
        }
        this.f259b = j;
    }

    public int b() throws IOException {
        int i = this.b;
        if (i == 7) {
            this.b = 2;
            return this.c;
        }
        if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.f256a < this.f259b && ((l6) this.f258a).f1279a != 0) {
            int iA = a();
            if (iA == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iA >> 3;
            this.c = i2;
            int i3 = iA & 7;
            if (i3 == 0) {
                this.f257a = b9.VARINT;
                this.b = 0;
                return i2;
            }
            if (i3 == 1) {
                this.f257a = b9.FIXED64;
                this.b = 1;
                return i2;
            }
            if (i3 == 2) {
                this.f257a = b9.LENGTH_DELIMITED;
                this.b = 2;
                int iA2 = a();
                if (iA2 < 0) {
                    throw new ProtocolException("Negative length: " + iA2);
                }
                if (this.f260c != -1) {
                    throw new IllegalStateException();
                }
                long j = this.f259b;
                this.f260c = j;
                long j2 = this.f256a + ((long) iA2);
                this.f259b = j2;
                if (j2 <= j) {
                    return this.c;
                }
                throw new EOFException();
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i3 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i3);
                }
                this.f257a = b9.FIXED32;
                this.b = 5;
                return i2;
            }
            b(i2);
        }
        return -1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m612b() throws IOException {
        if (this.b != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.f1151a + 1;
        this.f1151a = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.f260c;
        this.f260c = -1L;
        this.b = 6;
        return j;
    }

    public int c() throws IOException {
        int i = this.b;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.b);
        }
        ((l6) this.f258a).a(4L);
        this.f256a += 4;
        int iA = eo.a(((l6) this.f258a).m670a());
        a(5);
        return iA;
    }

    public int d() throws IOException {
        int i = this.b;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.b);
        }
        int iA = a();
        a(0);
        return iA;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public long m614d() throws IOException {
        int i = this.b;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.b);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            ((l6) this.f258a).a(1L);
            this.f256a++;
            byte bA = ((l6) this.f258a).a();
            j |= ((long) (bA & 127)) << i2;
            if ((bA & 128) == 0) {
                a(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void b(int i) throws IOException {
        while (this.f256a < this.f259b && ((l6) this.f258a).f1279a != 0) {
            int iA = a();
            if (iA == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iA >> 3;
            int i3 = iA & 7;
            if (i3 == 0) {
                this.b = 0;
                m614d();
            } else if (i3 == 1) {
                this.b = 1;
                m613c();
            } else if (i3 == 2) {
                long jA = a();
                this.f256a += jA;
                l6 l6Var = (l6) this.f258a;
                l6Var.getClass();
                while (jA > 0) {
                    dl dlVar = l6Var.f436a;
                    if (dlVar == null) {
                        throw new EOFException();
                    }
                    int iMin = (int) Math.min(jA, dlVar.b - dlVar.f1133a);
                    long j = iMin;
                    l6Var.f1279a -= j;
                    jA -= j;
                    dl dlVar2 = l6Var.f436a;
                    int i4 = dlVar2.f1133a + iMin;
                    dlVar2.f1133a = i4;
                    if (i4 == dlVar2.b) {
                        l6Var.f436a = dlVar2.a();
                        el.a(dlVar2);
                    }
                }
            } else if (i3 == 3) {
                b(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i3 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i3);
                }
                this.b = 5;
                c();
            }
        }
        throw new EOFException();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m613c() throws IOException {
        long jM670a;
        int i = this.b;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.b);
        }
        ((l6) this.f258a).a(8L);
        this.f256a += 8;
        l6 l6Var = (l6) this.f258a;
        long j = l6Var.f1279a;
        if (j >= 8) {
            dl dlVar = l6Var.f436a;
            int i2 = dlVar.f1133a;
            int i3 = dlVar.b;
            if (i3 - i2 < 8) {
                jM670a = ((((long) l6Var.m670a()) & 4294967295L) << 32) | (4294967295L & ((long) l6Var.m670a()));
            } else {
                byte[] bArr = dlVar.f226a;
                int i4 = i2 + 7;
                long j2 = ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
                int i5 = i2 + 8;
                jM670a = j2 | (((long) bArr[i4]) & 255);
                l6Var.f1279a = j - 8;
                if (i5 == i3) {
                    l6Var.f436a = dlVar.a();
                    el.a(dlVar);
                } else {
                    dlVar.f1133a = i5;
                }
            }
            long jA = eo.a(jM670a);
            a(1);
            return jA;
        }
        throw new IllegalStateException("size < 8: " + l6Var.f1279a);
    }
}
