package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ParcelWrite {
    public static final int b = 65262;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Parcel f3987a;

    public ParcelWrite(Parcel parcel) {
        this.f3987a = parcel;
    }

    private int a(int i) {
        this.f3987a.writeInt(i | SupportMenu.CATEGORY_MASK);
        this.f3987a.writeInt(0);
        return this.f3987a.dataPosition();
    }

    private void a(int i, int i2) {
        if (i2 < 65535) {
            this.f3987a.writeInt(i | (i2 << 16));
        } else {
            this.f3987a.writeInt(i | SupportMenu.CATEGORY_MASK);
            this.f3987a.writeInt(i2);
        }
    }

    private <T extends Parcelable> void a(T t, int i) {
        int iDataPosition = this.f3987a.dataPosition();
        this.f3987a.writeInt(1);
        int iDataPosition2 = this.f3987a.dataPosition();
        t.writeToParcel(this.f3987a, i);
        int iDataPosition3 = this.f3987a.dataPosition();
        this.f3987a.setDataPosition(iDataPosition);
        this.f3987a.writeInt(iDataPosition3 - iDataPosition2);
        this.f3987a.setDataPosition(iDataPosition3);
    }

    private void b(int i) {
        int iDataPosition = this.f3987a.dataPosition();
        this.f3987a.setDataPosition(i - 4);
        this.f3987a.writeInt(iDataPosition - i);
        this.f3987a.setDataPosition(iDataPosition);
    }

    public int beginObjectHeader() {
        return a(65262);
    }

    public void finishObjectHeader(int i) {
        b(i);
    }

    public void writeBigDecimal(int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f3987a.writeInt(bigDecimal.scale());
            b(iA);
        }
    }

    public void writeBigDecimalArray(int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int length = bigDecimalArr.length;
        this.f3987a.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f3987a.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            this.f3987a.writeInt(bigDecimalArr[i2].scale());
        }
        b(iA);
    }

    public void writeBigInteger(int i, BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeByteArray(bigInteger.toByteArray());
            b(iA);
        }
    }

    public void writeBigIntegerArray(int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        this.f3987a.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            this.f3987a.writeByteArray(bigInteger.toByteArray());
        }
        b(iA);
    }

    public void writeBoolean(int i, boolean z) {
        a(i, 4);
        this.f3987a.writeInt(z ? 1 : 0);
    }

    public void writeBooleanArray(int i, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeBooleanArray(zArr);
            b(iA);
        }
    }

    public void writeBooleanList(int i, List<Boolean> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(list.get(i2).booleanValue() ? 1 : 0);
        }
        b(iA);
    }

    public void writeBooleanObject(int i, Boolean bool) {
        writeBooleanObject(i, bool, false);
    }

    public void writeBooleanObject(int i, Boolean bool, boolean z) {
        if (bool != null) {
            a(i, 4);
            this.f3987a.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBundle(int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeBundle(bundle);
            b(iA);
        }
    }

    public void writeByte(int i, byte b2) {
        a(i, 4);
        this.f3987a.writeInt(b2);
    }

    public void writeByteArray(int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeByteArray(bArr);
            b(iA);
        }
    }

    public void writeByteArrayArray(int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        this.f3987a.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            this.f3987a.writeByteArray(bArr2);
        }
        b(iA);
    }

    public void writeByteArraySparseArray(int i, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            this.f3987a.writeByteArray(sparseArray.valueAt(i2));
        }
        b(iA);
    }

    public void writeChar(int i, char c) {
        a(i, 4);
        this.f3987a.writeInt(c);
    }

    public void writeCharArray(int i, char[] cArr, boolean z) {
        if (cArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeCharArray(cArr);
            b(iA);
        }
    }

    public void writeDouble(int i, double d) {
        a(i, 8);
        this.f3987a.writeDouble(d);
    }

    public void writeDoubleArray(int i, double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeDoubleArray(dArr);
            b(iA);
        }
    }

    public void writeDoubleList(int i, List<Double> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeDouble(list.get(i2).doubleValue());
        }
        b(iA);
    }

    public void writeDoubleObject(int i, Double d, boolean z) {
        if (d != null) {
            a(i, 8);
            this.f3987a.writeDouble(d.doubleValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeDoubleSparseArray(int i, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            this.f3987a.writeDouble(sparseArray.valueAt(i2).doubleValue());
        }
        b(iA);
    }

    public void writeFloat(int i, float f) {
        a(i, 4);
        this.f3987a.writeFloat(f);
    }

    public void writeFloatArray(int i, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeFloatArray(fArr);
            b(iA);
        }
    }

    public void writeFloatList(int i, List<Float> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeFloat(list.get(i2).floatValue());
        }
        b(iA);
    }

    public void writeFloatObject(int i, Float f, boolean z) {
        if (f != null) {
            a(i, 4);
            this.f3987a.writeFloat(f.floatValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeFloatSparseArray(int i, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            this.f3987a.writeFloat(sparseArray.valueAt(i2).floatValue());
        }
        b(iA);
    }

    public void writeIBinder(int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeStrongBinder(iBinder);
            b(iA);
        }
    }

    public void writeIBinderArray(int i, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeBinderArray(iBinderArr);
            b(iA);
        }
    }

    public void writeIBinderList(int i, List<IBinder> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeBinderList(list);
            b(iA);
        }
    }

    public void writeIBinderSparseArray(int i, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            this.f3987a.writeStrongBinder(sparseArray.valueAt(i2));
        }
        b(iA);
    }

    public void writeInt(int i, int i2) {
        a(i, 4);
        this.f3987a.writeInt(i2);
    }

    public void writeIntArray(int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeIntArray(iArr);
            b(iA);
        }
    }

    public void writeIntegerList(int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(list.get(i2).intValue());
        }
        b(iA);
    }

    public void writeIntegerObject(int i, Integer num, boolean z) {
        if (num != null) {
            a(i, 4);
            this.f3987a.writeInt(num.intValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeList(int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeList(list);
            b(iA);
        }
    }

    public void writeLong(int i, long j) {
        a(i, 8);
        this.f3987a.writeLong(j);
    }

    public void writeLongArray(int i, long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeLongArray(jArr);
            b(iA);
        }
    }

    public void writeLongList(int i, List<Long> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeLong(list.get(i2).longValue());
        }
        b(iA);
    }

    public void writeLongObject(int i, Long l, boolean z) {
        if (l != null) {
            a(i, 8);
            this.f3987a.writeLong(l.longValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcel(int i, Parcel parcel, boolean z) {
        if (parcel == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.appendFrom(parcel, 0, parcel.dataSize());
            b(iA);
        }
    }

    public void writeParcelArray(int i, Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        this.f3987a.writeInt(parcelArr.length);
        for (Parcel parcel : parcelArr) {
            if (parcel != null) {
                this.f3987a.writeInt(parcel.dataSize());
                this.f3987a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f3987a.writeInt(0);
            }
        }
        b(iA);
    }

    public void writeParcelList(int i, List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcel parcel = list.get(i2);
            if (parcel != null) {
                this.f3987a.writeInt(parcel.dataSize());
                this.f3987a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f3987a.writeInt(0);
            }
        }
        b(iA);
    }

    public void writeParcelSparseArray(int i, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            Parcel parcelValueAt = sparseArray.valueAt(i2);
            if (parcelValueAt != null) {
                this.f3987a.writeInt(parcelValueAt.dataSize());
                this.f3987a.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                this.f3987a.writeInt(0);
            }
        }
        b(iA);
    }

    public void writeParcelable(int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            parcelable.writeToParcel(this.f3987a, i2);
            b(iA);
        }
    }

    public void writeShort(int i, short s) {
        a(i, 4);
        this.f3987a.writeInt(s);
    }

    public void writeSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeSparseBooleanArray(sparseBooleanArray);
            b(iA);
        }
    }

    public void writeSparseIntArray(int i, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseIntArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseIntArray.keyAt(i2));
            this.f3987a.writeInt(sparseIntArray.valueAt(i2));
        }
        b(iA);
    }

    public void writeSparseLongArray(int i, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseLongArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseLongArray.keyAt(i2));
            this.f3987a.writeLong(sparseLongArray.valueAt(i2));
        }
        b(iA);
    }

    public void writeString(int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeString(str);
            b(iA);
        }
    }

    public void writeStringArray(int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeStringArray(strArr);
            b(iA);
        }
    }

    public void writeStringList(int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
            }
        } else {
            int iA = a(i);
            this.f3987a.writeStringList(list);
            b(iA);
        }
    }

    public void writeStringSparseArray(int i, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            this.f3987a.writeString(sparseArray.valueAt(i2));
        }
        b(iA);
    }

    public <T extends Parcelable> void writeTypedArray(int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        this.f3987a.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                this.f3987a.writeInt(0);
            } else {
                a(t, i2);
            }
        }
        b(iA);
    }

    public <T extends Parcelable> void writeTypedList(int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = list.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                this.f3987a.writeInt(0);
            } else {
                a(t, 0);
            }
        }
        b(iA);
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(i, 0);
                return;
            }
            return;
        }
        int iA = a(i);
        int size = sparseArray.size();
        this.f3987a.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f3987a.writeInt(sparseArray.keyAt(i2));
            T tValueAt = sparseArray.valueAt(i2);
            if (tValueAt == null) {
                this.f3987a.writeInt(0);
            } else {
                a(tValueAt, 0);
            }
        }
        b(iA);
    }
}
