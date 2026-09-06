package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bu f9109a;
    private final ch b;

    public ay() {
        this(new bo.a());
    }

    public ay(bw bwVar) {
        ch chVar = new ch();
        this.b = chVar;
        this.f9109a = bwVar.a(chVar);
    }

    public void a(av avVar, byte[] bArr) throws bb {
        try {
            this.b.a(bArr);
            avVar.read(this.f9109a);
        } finally {
            this.b.e();
            this.f9109a.B();
        }
    }

    public void a(av avVar, String str, String str2) throws bb {
        try {
            try {
                a(avVar, str.getBytes(str2));
                this.f9109a.B();
            } catch (UnsupportedEncodingException unused) {
                throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } catch (Throwable th) {
            this.f9109a.B();
            throw th;
        }
    }

    public void a(av avVar, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    avVar.read(this.f9109a);
                }
                this.b.e();
                this.f9109a.B();
            } catch (Exception e) {
                throw new bb(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.f9109a.B();
            throw th;
        }
    }

    public Boolean a(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Boolean) a((byte) 2, bArr, bcVar, bcVarArr);
    }

    public Byte b(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Byte) a((byte) 3, bArr, bcVar, bcVarArr);
    }

    public Double c(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Double) a((byte) 4, bArr, bcVar, bcVarArr);
    }

    public Short d(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Short) a((byte) 6, bArr, bcVar, bcVarArr);
    }

    public Integer e(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Integer) a((byte) 8, bArr, bcVar, bcVarArr);
    }

    public Long f(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Long) a((byte) 10, bArr, bcVar, bcVarArr);
    }

    public String g(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (String) a((byte) 11, bArr, bcVar, bcVarArr);
    }

    public ByteBuffer h(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (ByteBuffer) a((byte) 100, bArr, bcVar, bcVarArr);
    }

    public Short i(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    this.f9109a.j();
                    Short shValueOf = Short.valueOf(this.f9109a.l().c);
                    this.b.e();
                    this.f9109a.B();
                    return shValueOf;
                }
                this.b.e();
                this.f9109a.B();
                return null;
            } catch (Exception e) {
                throw new bb(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.f9109a.B();
            throw th;
        }
        this.b.e();
        this.f9109a.B();
        throw th;
    }

    private Object a(byte b, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                bp bpVarJ = j(bArr, bcVar, bcVarArr);
                if (bpVarJ != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && bpVarJ.b == 11) {
                                                    String strZ = this.f9109a.z();
                                                    this.b.e();
                                                    this.f9109a.B();
                                                    return strZ;
                                                }
                                            } else if (bpVarJ.b == 10) {
                                                Long lValueOf = Long.valueOf(this.f9109a.x());
                                                this.b.e();
                                                this.f9109a.B();
                                                return lValueOf;
                                            }
                                        } else if (bpVarJ.b == 11) {
                                            ByteBuffer byteBufferA = this.f9109a.A();
                                            this.b.e();
                                            this.f9109a.B();
                                            return byteBufferA;
                                        }
                                    } else if (bpVarJ.b == 8) {
                                        Integer numValueOf = Integer.valueOf(this.f9109a.w());
                                        this.b.e();
                                        this.f9109a.B();
                                        return numValueOf;
                                    }
                                } else if (bpVarJ.b == 6) {
                                    Short shValueOf = Short.valueOf(this.f9109a.v());
                                    this.b.e();
                                    this.f9109a.B();
                                    return shValueOf;
                                }
                            } else if (bpVarJ.b == 4) {
                                Double dValueOf = Double.valueOf(this.f9109a.y());
                                this.b.e();
                                this.f9109a.B();
                                return dValueOf;
                            }
                        } else if (bpVarJ.b == 3) {
                            Byte bValueOf = Byte.valueOf(this.f9109a.u());
                            this.b.e();
                            this.f9109a.B();
                            return bValueOf;
                        }
                    } else if (bpVarJ.b == 2) {
                        Boolean boolValueOf = Boolean.valueOf(this.f9109a.t());
                        this.b.e();
                        this.f9109a.B();
                        return boolValueOf;
                    }
                }
                this.b.e();
                this.f9109a.B();
                return null;
            } catch (Exception e) {
                throw new bb(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.f9109a.B();
            throw th;
        }
    }

    private bp j(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        this.b.a(bArr);
        int length = bcVarArr.length + 1;
        bc[] bcVarArr2 = new bc[length];
        int i = 0;
        bcVarArr2[0] = bcVar;
        int i2 = 0;
        while (i2 < bcVarArr.length) {
            int i3 = i2 + 1;
            bcVarArr2[i3] = bcVarArr[i2];
            i2 = i3;
        }
        this.f9109a.j();
        bp bpVarL = null;
        while (i < length) {
            bpVarL = this.f9109a.l();
            if (bpVarL.b == 0 || bpVarL.c > bcVarArr2[i].a()) {
                return null;
            }
            if (bpVarL.c != bcVarArr2[i].a()) {
                bx.a(this.f9109a, bpVarL.b);
                this.f9109a.m();
            } else {
                i++;
                if (i < length) {
                    this.f9109a.j();
                }
            }
        }
        return bpVarL;
    }

    public void a(av avVar, String str) throws bb {
        a(avVar, str.getBytes());
    }
}
