package com.ubixnow.ooooo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOo00o0o implements Cloneable {
    private oO00o00O<?, ?> OooO00o;
    private Object OooO0O0;
    private List<oO0> OooO0OO;

    public oOo00o0o() {
        this.OooO0OO = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> oOo00o0o(oO00o00O<?, T> oo00o00o, T t) {
        this.OooO00o = oo00o00o;
        this.OooO0O0 = t;
    }

    private byte[] OooO0Oo() throws IOException {
        byte[] bArr = new byte[OooO0O0()];
        OooO00o(oO00o00.OooO0O0(bArr));
        return bArr;
    }

    public oO0 OooO00o(int i) {
        List<oO0> list = this.OooO0OO;
        if (list != null && i < list.size()) {
            return this.OooO0OO.get(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
    public final oOo00o0o clone() {
        Object objClone;
        oOo00o0o ooo00o0o = new oOo00o0o();
        try {
            ooo00o0o.OooO00o = this.OooO00o;
            List<oO0> list = this.OooO0OO;
            if (list == null) {
                ooo00o0o.OooO0OO = null;
            } else {
                ooo00o0o.OooO0OO.addAll(list);
            }
            Object obj = this.OooO0O0;
            if (obj != null) {
                if (obj instanceof oOo0000O) {
                    objClone = ((oOo0000O) obj).clone();
                } else if (obj instanceof byte[]) {
                    objClone = ((byte[]) obj).clone();
                } else {
                    int i = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        ooo00o0o.OooO0O0 = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (obj instanceof boolean[]) {
                        objClone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        objClone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        objClone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        objClone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        objClone = ((double[]) obj).clone();
                    } else if (obj instanceof oOo0000O[]) {
                        oOo0000O[] ooo0000oArr = (oOo0000O[]) obj;
                        oOo0000O[] ooo0000oArr2 = new oOo0000O[ooo0000oArr.length];
                        ooo00o0o.OooO0O0 = ooo0000oArr2;
                        while (i < ooo0000oArr.length) {
                            ooo0000oArr2[i] = ooo0000oArr[i].clone();
                            i++;
                        }
                    }
                }
                ooo00o0o.OooO0O0 = objClone;
            }
            return ooo00o0o;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T OooO00o(oO00o00O<?, T> oo00o00o) {
        if (this.OooO0O0 == null) {
            this.OooO00o = oo00o00o;
            this.OooO0O0 = oo00o00o.OooO0OO(this.OooO0OO);
            this.OooO0OO = null;
        } else if (this.OooO00o != oo00o00o) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.OooO0O0;
    }

    public void OooO00o(oO00o00 oo00o00) throws IOException {
        Object obj = this.OooO0O0;
        if (obj != null) {
            this.OooO00o.OooO0OO(obj, oo00o00);
            return;
        }
        Iterator<oO0> it = this.OooO0OO.iterator();
        while (it.hasNext()) {
            it.next().OooO00o(oo00o00);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void OooO00o(oO00o00O<?, T> oo00o00o, T t) {
        this.OooO00o = oo00o00o;
        this.OooO0O0 = t;
        this.OooO0OO = null;
    }

    public void OooO00o(oO0 oo0) {
        this.OooO0OO.add(oo0);
    }

    public int OooO0O0() {
        Object obj = this.OooO0O0;
        if (obj != null) {
            return this.OooO00o.OooO0O0(obj);
        }
        Iterator<oO0> it = this.OooO0OO.iterator();
        int iOooO00o = 0;
        while (it.hasNext()) {
            iOooO00o += it.next().OooO00o();
        }
        return iOooO00o;
    }

    public int OooO0OO() {
        List<oO0> list = this.OooO0OO;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean equals(Object obj) {
        List<oO0> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oOo00o0o)) {
            return false;
        }
        oOo00o0o ooo00o0o = (oOo00o0o) obj;
        if (this.OooO0O0 == null || ooo00o0o.OooO0O0 == null) {
            List<oO0> list2 = this.OooO0OO;
            if (list2 != null && (list = ooo00o0o.OooO0OO) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(OooO0Oo(), ooo00o0o.OooO0Oo());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        oO00o00O<?, ?> oo00o00o = this.OooO00o;
        if (oo00o00o != ooo00o0o.OooO00o) {
            return false;
        }
        if (!oo00o00o.OooOo00.isArray()) {
            return this.OooO0O0.equals(ooo00o0o.OooO0O0);
        }
        Object obj2 = this.OooO0O0;
        if (obj2 instanceof byte[]) {
            return Arrays.equals((byte[]) obj2, (byte[]) ooo00o0o.OooO0O0);
        }
        if (obj2 instanceof int[]) {
            return Arrays.equals((int[]) obj2, (int[]) ooo00o0o.OooO0O0);
        }
        if (obj2 instanceof long[]) {
            return Arrays.equals((long[]) obj2, (long[]) ooo00o0o.OooO0O0);
        }
        if (obj2 instanceof float[]) {
            return Arrays.equals((float[]) obj2, (float[]) ooo00o0o.OooO0O0);
        }
        if (obj2 instanceof double[]) {
            return Arrays.equals((double[]) obj2, (double[]) ooo00o0o.OooO0O0);
        }
        return obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) ooo00o0o.OooO0O0) : Arrays.deepEquals((Object[]) obj2, (Object[]) ooo00o0o.OooO0O0);
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(OooO0Oo()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
