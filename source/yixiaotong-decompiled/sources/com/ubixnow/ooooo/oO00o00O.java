package com.ubixnow.ooooo;

import com.ubixnow.ooooo.oO0OOO00;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO00o00O<M extends oO0OOO00<M>, T> {
    public static final int OooO = 9;
    public static final int OooO00o = 1;
    public static final int OooO0O0 = 2;
    public static final int OooO0OO = 3;
    public static final int OooO0Oo = 4;
    public static final int OooO0o = 6;
    public static final int OooO0o0 = 5;
    public static final int OooO0oO = 7;
    public static final int OooO0oo = 8;
    public static final int OooOO0 = 10;
    public static final int OooOO0O = 11;
    public static final int OooOO0o = 12;
    public static final int OooOOO = 14;
    public static final int OooOOO0 = 13;
    public static final int OooOOOO = 15;
    public static final int OooOOOo = 16;
    public static final int OooOOo = 18;
    public static final int OooOOo0 = 17;
    public final int OooOOoo;
    public final int OooOo0;
    public final Class<T> OooOo00;
    public final boolean OooOo0O;

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0<M extends oO0OOO00<M>, T> extends oO00o00O<M, T> {
        private final int OooOo;
        private final int OooOo0o;

        public OooO0O0(int i, Class<T> cls, int i2, boolean z, int i3, int i4) {
            super(i, cls, i2, z, null);
            this.OooOo0o = i3;
            this.OooOo = i4;
        }

        private int OooO0Oo(Object obj) {
            int iOooO0O0;
            int length = Array.getLength(obj);
            int i = 0;
            switch (this.OooOOoo) {
                case 1:
                case 6:
                case 16:
                    return length * 8;
                case 2:
                case 7:
                case 15:
                    return length * 4;
                case 3:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0O0(Array.getLong(obj, i));
                        i++;
                    }
                    break;
                case 4:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0o(Array.getLong(obj, i));
                        i++;
                    }
                    break;
                case 5:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0OO(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 8:
                    return length;
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    throw new IllegalArgumentException("Unexpected non-packable type " + this.OooOOoo);
                case 13:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0oo(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 14:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO00o(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 17:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0o(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 18:
                    iOooO0O0 = 0;
                    while (i < length) {
                        iOooO0O0 += oO00o00.OooO0o0(Array.getLong(obj, i));
                        i++;
                    }
                    break;
            }
            return iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oO00o00O
        public int OooO00o(Object obj) {
            int i = this.OooOo0;
            if (i == this.OooOo0o) {
                return super.OooO00o(obj);
            }
            if (i != this.OooOo) {
                throw new IllegalArgumentException("Unexpected repeated extension tag " + this.OooOo0 + ", unequal to both non-packed variant " + this.OooOo0o + " and packed variant " + this.OooOo);
            }
            int iOooO0Oo = OooO0Oo(obj);
            return iOooO0Oo + oO00o00.OooO0Oo(iOooO0Oo) + oO00o00.OooO0Oo(this.OooOo0);
        }

        @Override // com.ubixnow.ooooo.oO00o00O
        public Object OooO00o(oO00o000 oo00o000) {
            try {
                return oo00o000.OooO0o0(this.OooOOoo);
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        @Override // com.ubixnow.ooooo.oO00o00O
        public void OooO00o(oO0 oo0, List<Object> list) {
            int i = oo0.OooO00o;
            int i2 = this.OooOo0o;
            byte[] bArr = oo0.OooO0O0;
            if (i == i2) {
                list.add(OooO00o(oO00o000.OooO00o(bArr)));
                return;
            }
            oO00o000 oo00o000OooO00o = oO00o000.OooO00o(bArr);
            try {
                oo00o000OooO00o.OooO0Oo(oo00o000OooO00o.OooOOOo());
                while (!oo00o000OooO00o.OooO0OO()) {
                    list.add(OooO00o(oo00o000OooO00o));
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.ubixnow.ooooo.oO00o00O
        public void OooO00o(Object obj, oO00o00 oo00o00) {
            int i = this.OooOo0;
            if (i == this.OooOo0o) {
                super.OooO00o(obj, oo00o00);
                return;
            }
            if (i != this.OooOo) {
                throw new IllegalArgumentException("Unexpected repeated extension tag " + this.OooOo0 + ", unequal to both non-packed variant " + this.OooOo0o + " and packed variant " + this.OooOo);
            }
            int length = Array.getLength(obj);
            int iOooO0Oo = OooO0Oo(obj);
            try {
                oo00o00.OooOOOO(this.OooOo0);
                oo00o00.OooOOOO(iOooO0Oo);
                int i2 = 0;
                switch (this.OooOOoo) {
                    case 1:
                        while (i2 < length) {
                            oo00o00.OooO0O0(Array.getDouble(obj, i2));
                            i2++;
                        }
                        return;
                    case 2:
                        while (i2 < length) {
                            oo00o00.OooO0O0(Array.getFloat(obj, i2));
                            i2++;
                        }
                        return;
                    case 3:
                        while (i2 < length) {
                            oo00o00.OooO(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 4:
                        while (i2 < length) {
                            oo00o00.OooOOO(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 5:
                        while (i2 < length) {
                            oo00o00.OooOO0o(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 6:
                        while (i2 < length) {
                            oo00o00.OooO0oo(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 7:
                        while (i2 < length) {
                            oo00o00.OooOO0O(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 8:
                        while (i2 < length) {
                            oo00o00.OooO0O0(Array.getBoolean(obj, i2));
                            i2++;
                        }
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    default:
                        throw new IllegalArgumentException("Unpackable type " + this.OooOOoo);
                    case 13:
                        while (i2 < length) {
                            oo00o00.OooOOo(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 14:
                        while (i2 < length) {
                            oo00o00.OooOO0(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 15:
                        while (i2 < length) {
                            oo00o00.OooOOOo(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 16:
                        while (i2 < length) {
                            oo00o00.OooOO0o(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 17:
                        while (i2 < length) {
                            oo00o00.OooOOo0(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 18:
                        while (i2 < length) {
                            oo00o00.OooOOO0(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.ubixnow.ooooo.oO00o00O
        public final void OooO0O0(Object obj, oO00o00 oo00o00) {
            try {
                oo00o00.OooOOOO(this.OooOo0);
                switch (this.OooOOoo) {
                    case 1:
                        oo00o00.OooO0O0(((Double) obj).doubleValue());
                        return;
                    case 2:
                        oo00o00.OooO0O0(((Float) obj).floatValue());
                        return;
                    case 3:
                        oo00o00.OooO(((Long) obj).longValue());
                        return;
                    case 4:
                        oo00o00.OooOOO(((Long) obj).longValue());
                        return;
                    case 5:
                        oo00o00.OooOO0o(((Integer) obj).intValue());
                        return;
                    case 6:
                        oo00o00.OooO0oo(((Long) obj).longValue());
                        return;
                    case 7:
                        oo00o00.OooOO0O(((Integer) obj).intValue());
                        return;
                    case 8:
                        oo00o00.OooO0O0(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        oo00o00.OooO0O0((String) obj);
                        return;
                    case 10:
                    case 11:
                    default:
                        throw new IllegalArgumentException("Unknown type " + this.OooOOoo);
                    case 12:
                        oo00o00.OooO0OO((byte[]) obj);
                        return;
                    case 13:
                        oo00o00.OooOOo(((Integer) obj).intValue());
                        return;
                    case 14:
                        oo00o00.OooOO0(((Integer) obj).intValue());
                        return;
                    case 15:
                        oo00o00.OooOOOo(((Integer) obj).intValue());
                        return;
                    case 16:
                        oo00o00.OooOO0o(((Long) obj).longValue());
                        return;
                    case 17:
                        oo00o00.OooOOo0(((Integer) obj).intValue());
                        return;
                    case 18:
                        oo00o00.OooOOO0(((Long) obj).longValue());
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.ubixnow.ooooo.oO00o00O
        public final int OooO0OO(Object obj) {
            int iOooO00o = oO0O000.OooO00o(this.OooOo0);
            switch (this.OooOOoo) {
                case 1:
                    return oO00o00.OooO00o(iOooO00o, ((Double) obj).doubleValue());
                case 2:
                    return oO00o00.OooO00o(iOooO00o, ((Float) obj).floatValue());
                case 3:
                    return oO00o00.OooO0O0(iOooO00o, ((Long) obj).longValue());
                case 4:
                    return oO00o00.OooO0o0(iOooO00o, ((Long) obj).longValue());
                case 5:
                    return oO00o00.OooO0OO(iOooO00o, ((Integer) obj).intValue());
                case 6:
                    return oO00o00.OooO00o(iOooO00o, ((Long) obj).longValue());
                case 7:
                    return oO00o00.OooO0O0(iOooO00o, ((Integer) obj).intValue());
                case 8:
                    return oO00o00.OooO00o(iOooO00o, ((Boolean) obj).booleanValue());
                case 9:
                    return oO00o00.OooO00o(iOooO00o, (String) obj);
                case 10:
                case 11:
                default:
                    throw new IllegalArgumentException("Unknown type " + this.OooOOoo);
                case 12:
                    return oO00o00.OooO00o(iOooO00o, (byte[]) obj);
                case 13:
                    return oO00o00.OooO0o(iOooO00o, ((Integer) obj).intValue());
                case 14:
                    return oO00o00.OooO00o(iOooO00o, ((Integer) obj).intValue());
                case 15:
                    return oO00o00.OooO0Oo(iOooO00o, ((Integer) obj).intValue());
                case 16:
                    return oO00o00.OooO0OO(iOooO00o, ((Long) obj).longValue());
                case 17:
                    return oO00o00.OooO0o0(iOooO00o, ((Integer) obj).intValue());
                case 18:
                    return oO00o00.OooO0Oo(iOooO00o, ((Long) obj).longValue());
            }
        }
    }

    private oO00o00O(int i, Class<T> cls, int i2, boolean z) {
        this.OooOOoo = i;
        this.OooOo00 = cls;
        this.OooOo0 = i2;
        this.OooOo0O = z;
    }

    public /* synthetic */ oO00o00O(int i, Class cls, int i2, boolean z, OooO00o oooO00o) {
        this(i, cls, i2, z);
    }

    @Deprecated
    public static <M extends oO0OOO00<M>, T extends oOo0000O> oO00o00O<M, T> OooO00o(int i, Class<T> cls, int i2) {
        return new oO00o00O<>(i, cls, i2, false);
    }

    public static <M extends oO0OOO00<M>, T extends oOo0000O> oO00o00O<M, T> OooO00o(int i, Class<T> cls, long j) {
        return new oO00o00O<>(i, cls, (int) j, false);
    }

    public static <M extends oO0OOO00<M>, T> oO00o00O<M, T> OooO00o(int i, Class<T> cls, long j, long j2, long j3) {
        return new OooO0O0(i, cls, (int) j, true, (int) j2, (int) j3);
    }

    private T OooO00o(List<oO0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            oO0 oo0 = list.get(i);
            if (oo0.OooO0O0.length != 0) {
                OooO00o(oo0, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.OooOo00;
        T tCast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    public static <M extends oO0OOO00<M>, T> oO00o00O<M, T> OooO0O0(int i, Class<T> cls, long j) {
        return new OooO0O0(i, cls, (int) j, false, 0, 0);
    }

    private T OooO0O0(List<oO0> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.OooOo00.cast(OooO00o(oO00o000.OooO00o(list.get(list.size() - 1).OooO0O0)));
    }

    public static <M extends oO0OOO00<M>, T extends oOo0000O> oO00o00O<M, T[]> OooO0OO(int i, Class<T[]> cls, long j) {
        return new oO00o00O<>(i, cls, (int) j, true);
    }

    public int OooO00o(Object obj) {
        int length = Array.getLength(obj);
        int iOooO0OO = 0;
        for (int i = 0; i < length; i++) {
            if (Array.get(obj, i) != null) {
                iOooO0OO += OooO0OO(Array.get(obj, i));
            }
        }
        return iOooO0OO;
    }

    public Object OooO00o(oO00o000 oo00o000) {
        Class componentType = this.OooOo0O ? this.OooOo00.getComponentType() : this.OooOo00;
        try {
            int i = this.OooOOoo;
            if (i == 10) {
                oOo0000O ooo0000o = (oOo0000O) componentType.newInstance();
                oo00o000.OooO00o(ooo0000o, oO0O000.OooO00o(this.OooOo0));
                return ooo0000o;
            }
            if (i != 11) {
                throw new IllegalArgumentException("Unknown type " + this.OooOOoo);
            }
            oOo0000O ooo0000o2 = (oOo0000O) componentType.newInstance();
            oo00o000.OooO00o(ooo0000o2);
            return ooo0000o2;
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e3);
        }
    }

    public void OooO00o(oO0 oo0, List<Object> list) {
        list.add(OooO00o(oO00o000.OooO00o(oo0.OooO0O0)));
    }

    public void OooO00o(Object obj, oO00o00 oo00o00) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                OooO0O0(obj2, oo00o00);
            }
        }
    }

    public int OooO0O0(Object obj) {
        return this.OooOo0O ? OooO00o(obj) : OooO0OO(obj);
    }

    public void OooO0O0(Object obj, oO00o00 oo00o00) {
        try {
            oo00o00.OooOOOO(this.OooOo0);
            int i = this.OooOOoo;
            if (i != 10) {
                if (i != 11) {
                    throw new IllegalArgumentException("Unknown type " + this.OooOOoo);
                }
                oo00o00.OooO0Oo((oOo0000O) obj);
            } else {
                int iOooO00o = oO0O000.OooO00o(this.OooOo0);
                oo00o00.OooO0OO((oOo0000O) obj);
                oo00o00.OooOO0o(iOooO00o, 4);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public int OooO0OO(Object obj) {
        int iOooO00o = oO0O000.OooO00o(this.OooOo0);
        int i = this.OooOOoo;
        if (i == 10) {
            return oO00o00.OooO00o(iOooO00o, (oOo0000O) obj);
        }
        if (i == 11) {
            return oO00o00.OooO0O0(iOooO00o, (oOo0000O) obj);
        }
        throw new IllegalArgumentException("Unknown type " + this.OooOOoo);
    }

    public final T OooO0OO(List<oO0> list) {
        if (list == null) {
            return null;
        }
        return this.OooOo0O ? OooO00o(list) : OooO0O0(list);
    }

    public void OooO0OO(Object obj, oO00o00 oo00o00) throws IOException {
        if (this.OooOo0O) {
            OooO00o(obj, oo00o00);
        } else {
            OooO0O0(obj, oo00o00);
        }
    }
}
