package com.huawei.hms.base.common;

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
public class ParcelWriter {
    private static final int FIELDID_HEADER = 65262;
    private Parcel parcel;

    public ParcelWriter(Parcel parcel) {
        this.parcel = parcel;
    }

    private void writeFieldHeader(int i, int i2) {
        if (i2 >= 65535) {
            this.parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            this.parcel.writeInt(i2);
        } else {
            this.parcel.writeInt(i | (i2 << 16));
        }
    }

    private int beginFieldHeader(int i) {
        this.parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        this.parcel.writeInt(0);
        return this.parcel.dataPosition();
    }

    private void finishFieldHeader(int i) {
        int iDataPosition = this.parcel.dataPosition();
        this.parcel.setDataPosition(i - 4);
        this.parcel.writeInt(iDataPosition - i);
        this.parcel.setDataPosition(iDataPosition);
    }

    public int beginObjectHeader() {
        return beginFieldHeader(65262);
    }

    public void finishObjectHeader(int i) {
        finishFieldHeader(i);
    }

    public void writeBoolean(int i, boolean z) {
        writeFieldHeader(i, 4);
        this.parcel.writeInt(z ? 1 : 0);
    }

    public void writeBooleanObject(int i, Boolean bool) {
        writeBooleanObject(i, bool, false);
    }

    public void writeBooleanObject(int i, Boolean bool, boolean z) {
        if (bool != null) {
            writeFieldHeader(i, 4);
            this.parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            writeFieldHeader(i, 0);
        }
    }

    public void writeByte(int i, byte b) {
        writeFieldHeader(i, 4);
        this.parcel.writeInt(b);
    }

    public void writeChar(int i, char c) {
        writeFieldHeader(i, 4);
        this.parcel.writeInt(c);
    }

    public void writeShort(int i, short s) {
        writeFieldHeader(i, 4);
        this.parcel.writeInt(s);
    }

    public void writeInt(int i, int i2) {
        writeFieldHeader(i, 4);
        this.parcel.writeInt(i2);
    }

    public void writeIntegerObject(int i, Integer num, boolean z) {
        if (num != null) {
            writeFieldHeader(i, 4);
            this.parcel.writeInt(num.intValue());
        } else if (z) {
            writeFieldHeader(i, 0);
        }
    }

    public void writeLong(int i, long j) {
        writeFieldHeader(i, 8);
        this.parcel.writeLong(j);
    }

    public void writeLongObject(int i, Long l, boolean z) {
        if (l != null) {
            writeFieldHeader(i, 8);
            this.parcel.writeLong(l.longValue());
        } else if (z) {
            writeFieldHeader(i, 0);
        }
    }

    public void writeBigInteger(int i, BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeByteArray(bigInteger.toByteArray());
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeFloat(int i, float f) {
        writeFieldHeader(i, 4);
        this.parcel.writeFloat(f);
    }

    public void writeFloatObject(int i, Float f, boolean z) {
        if (f != null) {
            writeFieldHeader(i, 4);
            this.parcel.writeFloat(f.floatValue());
        } else if (z) {
            writeFieldHeader(i, 0);
        }
    }

    public void writeDouble(int i, double d) {
        writeFieldHeader(i, 8);
        this.parcel.writeDouble(d);
    }

    public void writeDoubleObject(int i, Double d, boolean z) {
        if (d != null) {
            writeFieldHeader(i, 8);
            this.parcel.writeDouble(d.doubleValue());
        } else if (z) {
            writeFieldHeader(i, 0);
        }
    }

    public void writeBigDecimal(int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.parcel.writeInt(bigDecimal.scale());
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeString(int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeString(str);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeIBinder(int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeStrongBinder(iBinder);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeParcelable(int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            parcelable.writeToParcel(this.parcel, i2);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeBundle(int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeBundle(bundle);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeByteArray(int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeByteArray(bArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeByteArrayArray(int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        this.parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            this.parcel.writeByteArray(bArr2);
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeBooleanArray(int i, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeBooleanArray(zArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeCharArray(int i, char[] cArr, boolean z) {
        if (cArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeCharArray(cArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeIntArray(int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeIntArray(iArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeLongArray(int i, long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeLongArray(jArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeBigIntegerArray(int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        this.parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            this.parcel.writeByteArray(bigInteger.toByteArray());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeFloatArray(int i, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeFloatArray(fArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeDoubleArray(int i, double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeDoubleArray(dArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeBigDecimalArray(int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int length = bigDecimalArr.length;
        this.parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            this.parcel.writeInt(bigDecimalArr[i2].scale());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeStringArray(int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeStringArray(strArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeIBinderArray(int i, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeBinderArray(iBinderArr);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeBooleanList(int i, List<Boolean> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeIntegerList(int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(list.get(i2).intValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeLongList(int i, List<Long> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeLong(list.get(i2).longValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeFloatList(int i, List<Float> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeFloat(list.get(i2).floatValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeDoubleList(int i, List<Double> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeDouble(list.get(i2).doubleValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeStringList(int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeStringList(list);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeIBinderList(int i, List<IBinder> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeBinderList(list);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public <T extends Parcelable> void writeTypedArray(int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        this.parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                this.parcel.writeInt(0);
            } else {
                writeParcelableData(t, i2);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public <T extends Parcelable> void writeTypedList(int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                this.parcel.writeInt(0);
            } else {
                writeParcelableData(t, 0);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    private <T extends Parcelable> void writeParcelableData(T t, int i) {
        int iDataPosition = this.parcel.dataPosition();
        this.parcel.writeInt(1);
        int iDataPosition2 = this.parcel.dataPosition();
        t.writeToParcel(this.parcel, i);
        int iDataPosition3 = this.parcel.dataPosition();
        this.parcel.setDataPosition(iDataPosition);
        this.parcel.writeInt(iDataPosition3 - iDataPosition2);
        this.parcel.setDataPosition(iDataPosition3);
    }

    public void writeParcel(int i, Parcel parcel, boolean z) {
        if (parcel == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.appendFrom(parcel, 0, parcel.dataSize());
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeParcelArray(int i, Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        this.parcel.writeInt(parcelArr.length);
        for (Parcel parcel : parcelArr) {
            if (parcel != null) {
                this.parcel.writeInt(parcel.dataSize());
                this.parcel.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.parcel.writeInt(0);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeParcelList(int i, List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = list.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcel parcel = list.get(i2);
            if (parcel != null) {
                this.parcel.writeInt(parcel.dataSize());
                this.parcel.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.parcel.writeInt(0);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeList(int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeList(list);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
            }
        } else {
            int iBeginFieldHeader = beginFieldHeader(i);
            this.parcel.writeSparseBooleanArray(sparseBooleanArray);
            finishFieldHeader(iBeginFieldHeader);
        }
    }

    public void writeDoubleSparseArray(int i, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            this.parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeFloatSparseArray(int i, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            this.parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeSparseIntArray(int i, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseIntArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseIntArray.keyAt(i2));
            this.parcel.writeInt(sparseIntArray.valueAt(i2));
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeSparseLongArray(int i, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseLongArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseLongArray.keyAt(i2));
            this.parcel.writeLong(sparseLongArray.valueAt(i2));
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeStringSparseArray(int i, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            this.parcel.writeString(sparseArray.valueAt(i2));
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeParcelSparseArray(int i, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            Parcel parcelValueAt = sparseArray.valueAt(i2);
            if (parcelValueAt != null) {
                this.parcel.writeInt(parcelValueAt.dataSize());
                this.parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                this.parcel.writeInt(0);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            T tValueAt = sparseArray.valueAt(i2);
            if (tValueAt == null) {
                this.parcel.writeInt(0);
            } else {
                writeParcelableData(tValueAt, 0);
            }
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeIBinderSparseArray(int i, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            this.parcel.writeStrongBinder(sparseArray.valueAt(i2));
        }
        finishFieldHeader(iBeginFieldHeader);
    }

    public void writeByteArraySparseArray(int i, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                writeFieldHeader(i, 0);
                return;
            }
            return;
        }
        int iBeginFieldHeader = beginFieldHeader(i);
        int size = sparseArray.size();
        this.parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.parcel.writeInt(sparseArray.keyAt(i2));
            this.parcel.writeByteArray(sparseArray.valueAt(i2));
        }
        finishFieldHeader(iBeginFieldHeader);
    }
}
