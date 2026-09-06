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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ParcelReader {
    private static final int FIELDID_HEADER = 65262;
    private static final int INDEX_POSITION = 0;
    private static final int INDEX_SIZE = 1;
    private int endPosition;
    HashMap<Integer, Integer[]> mapFields = new HashMap<>();
    private Parcel parcel;

    public ParcelReader(Parcel parcel) {
        this.parcel = parcel;
        initFields();
    }

    private void initFields() {
        int i = this.parcel.readInt();
        int i2 = i & 65535;
        int i3 = (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : this.parcel.readInt();
        if (i2 != 65262) {
            throw new ParseException("Expected object header. Got 0x" + Integer.toHexString(i2), this.parcel);
        }
        int iDataPosition = this.parcel.dataPosition();
        int i4 = i3 + iDataPosition;
        if (i4 < iDataPosition || i4 > this.parcel.dataSize()) {
            throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i4, this.parcel);
        }
        while (this.parcel.dataPosition() < i4) {
            int i5 = this.parcel.readInt();
            int i6 = i5 & 65535;
            int i7 = (i5 & SupportMenu.CATEGORY_MASK) != -65536 ? (i5 >> 16) & 65535 : this.parcel.readInt();
            int iDataPosition2 = this.parcel.dataPosition();
            this.mapFields.put(Integer.valueOf(i6), new Integer[]{Integer.valueOf(iDataPosition2), Integer.valueOf(i7)});
            this.parcel.setDataPosition(iDataPosition2 + i7);
        }
        if (this.parcel.dataPosition() != i4) {
            throw new ParseException("Overread allowed size end=" + i4, this.parcel);
        }
        this.endPosition = i4;
    }

    private int moveField(int i) {
        Integer[] numArr = this.mapFields.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field not exist:" + numArr, this.parcel);
        }
        this.parcel.setDataPosition(numArr[0].intValue());
        return numArr[1].intValue();
    }

    private void ensureFieldSize(int i, int i2) {
        Integer[] numArr = this.mapFields.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field not exist:" + numArr, this.parcel);
        }
        int iIntValue = numArr[1].intValue();
        if (iIntValue == i2) {
            return;
        }
        throw new ParseException("Expected size " + i2 + " got " + iIntValue + " (0x" + Integer.toHexString(iIntValue) + ")", this.parcel);
    }

    private int moveFieldAndEnsureSize(int i, int i2) {
        Integer[] numArr = this.mapFields.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field not exist:" + numArr, this.parcel);
        }
        this.parcel.setDataPosition(numArr[0].intValue());
        ensureFieldSize(i, i2);
        return i2;
    }

    public void finish() {
        this.parcel.setDataPosition(this.endPosition);
    }

    public boolean readBoolean(int i, boolean z) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return z;
        }
        moveFieldAndEnsureSize(i, 4);
        return this.parcel.readInt() != 0;
    }

    public Boolean readBooleanObject(int i, Boolean bool) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bool;
        }
        if (moveField(i) == 0) {
            return null;
        }
        ensureFieldSize(i, 4);
        int i2 = this.parcel.readInt();
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        if (i2 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public byte readByte(int i, byte b) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return b;
        }
        moveFieldAndEnsureSize(i, 4);
        return (byte) this.parcel.readInt();
    }

    public char readChar(int i, char c) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return c;
        }
        moveFieldAndEnsureSize(i, 4);
        return (char) this.parcel.readInt();
    }

    public short readShort(int i, short s) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return s;
        }
        moveFieldAndEnsureSize(i, 4);
        return (short) this.parcel.readInt();
    }

    public int readInt(int i, int i2) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return i2;
        }
        moveFieldAndEnsureSize(i, 4);
        return this.parcel.readInt();
    }

    public Integer readIntegerObject(int i, Integer num) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return num;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        ensureFieldSize(iMoveField, 4);
        return Integer.valueOf(this.parcel.readInt());
    }

    public long readLong(int i, long j) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return j;
        }
        moveFieldAndEnsureSize(i, 8);
        return this.parcel.readLong();
    }

    public Long readLongObject(int i, Long l) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return l;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        ensureFieldSize(iMoveField, 8);
        return Long.valueOf(this.parcel.readLong());
    }

    public BigInteger createBigInteger(int i, BigInteger bigInteger) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bigInteger;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        byte[] bArrCreateByteArray = this.parcel.createByteArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return new BigInteger(bArrCreateByteArray);
    }

    public float readFloat(int i, float f) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return f;
        }
        moveFieldAndEnsureSize(i, 4);
        return this.parcel.readFloat();
    }

    public Float readFloatObject(int i, Float f) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return f;
        }
        if (moveField(i) == 0) {
            return null;
        }
        ensureFieldSize(i, 4);
        return Float.valueOf(this.parcel.readFloat());
    }

    public double readDouble(int i, double d) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return d;
        }
        moveFieldAndEnsureSize(i, 8);
        return this.parcel.readDouble();
    }

    public Double readDoubleObject(int i, Double d) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return d;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        ensureFieldSize(iMoveField, 8);
        return Double.valueOf(this.parcel.readDouble());
    }

    public BigDecimal createBigDecimal(int i, BigDecimal bigDecimal) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bigDecimal;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        byte[] bArrCreateByteArray = this.parcel.createByteArray();
        int i2 = this.parcel.readInt();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    public String createString(int i, String str) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return str;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        String string = this.parcel.readString();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return string;
    }

    public IBinder readIBinder(int i, IBinder iBinder) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return iBinder;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        IBinder strongBinder = this.parcel.readStrongBinder();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return strongBinder;
    }

    public <T extends Parcelable> T readParcelable(int i, Parcelable.Creator<T> creator, T t) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return t;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        T tCreateFromParcel = creator.createFromParcel(this.parcel);
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return tCreateFromParcel;
    }

    public Bundle readBundle(int i, Bundle bundle) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bundle;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        Bundle bundle2 = this.parcel.readBundle();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return bundle2;
    }

    public byte[] createByteArray(int i, byte[] bArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new byte[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        byte[] bArrCreateByteArray = this.parcel.createByteArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return bArrCreateByteArray;
    }

    public byte[][] createByteArrayArray(int i, byte[][] bArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new byte[0][];
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        byte[][] bArr2 = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = this.parcel.createByteArray();
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return bArr2;
    }

    public boolean[] createBooleanArray(int i, boolean[] zArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return zArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new boolean[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        boolean[] zArrCreateBooleanArray = this.parcel.createBooleanArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return zArrCreateBooleanArray;
    }

    public char[] createCharArray(int i, char[] cArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return cArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new char[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        char[] cArrCreateCharArray = this.parcel.createCharArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return cArrCreateCharArray;
    }

    public int[] createIntArray(int i, int[] iArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return iArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new int[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        int[] iArrCreateIntArray = this.parcel.createIntArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return iArrCreateIntArray;
    }

    public long[] createLongArray(int i, long[] jArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return jArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new long[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        long[] jArrCreateLongArray = this.parcel.createLongArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return jArrCreateLongArray;
    }

    public BigInteger[] createBigIntegerArray(int i, BigInteger[] bigIntegerArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bigIntegerArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new BigInteger[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        BigInteger[] bigIntegerArr2 = new BigInteger[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerArr2[i3] = new BigInteger(this.parcel.createByteArray());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return bigIntegerArr2;
    }

    public float[] createFloatArray(int i, float[] fArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return fArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new float[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        float[] fArrCreateFloatArray = this.parcel.createFloatArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return fArrCreateFloatArray;
    }

    public double[] createDoubleArray(int i, double[] dArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return dArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new double[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        double[] dArrCreateDoubleArray = this.parcel.createDoubleArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return dArrCreateDoubleArray;
    }

    public BigDecimal[] createBigDecimalArray(int i, BigDecimal[] bigDecimalArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return bigDecimalArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new BigDecimal[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        BigDecimal[] bigDecimalArr2 = new BigDecimal[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArrCreateByteArray = this.parcel.createByteArray();
            bigDecimalArr2[i3] = new BigDecimal(new BigInteger(bArrCreateByteArray), this.parcel.readInt());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return bigDecimalArr2;
    }

    public String[] createStringArray(int i, String[] strArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return strArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new String[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        String[] strArrCreateStringArray = this.parcel.createStringArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return strArrCreateStringArray;
    }

    public IBinder[] createIBinderArray(int i, IBinder[] iBinderArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return iBinderArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new IBinder[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        IBinder[] iBinderArrCreateBinderArray = this.parcel.createBinderArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return iBinderArrCreateBinderArray;
    }

    public ArrayList<Boolean> createBooleanList(int i, ArrayList<Boolean> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(Boolean.valueOf(this.parcel.readInt() != 0));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public ArrayList<Integer> createIntegerList(int i, ArrayList<Integer> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(Integer.valueOf(this.parcel.readInt()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseBooleanArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseBooleanArray sparseBooleanArray2 = this.parcel.readSparseBooleanArray();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseBooleanArray2;
    }

    public SparseIntArray createSparseIntArray(int i, SparseIntArray sparseIntArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseIntArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseIntArray2.append(this.parcel.readInt(), this.parcel.readInt());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseIntArray2;
    }

    public SparseArray<Float> createFloatSparseArray(int i, SparseArray<Float> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), Float.valueOf(this.parcel.readFloat()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i, SparseArray<Double> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), Double.valueOf(this.parcel.readDouble()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public SparseLongArray createSparseLongArray(int i, SparseLongArray sparseLongArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseLongArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseLongArray2.append(this.parcel.readInt(), this.parcel.readLong());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseLongArray2;
    }

    public SparseArray<String> createStringSparseArray(int i, SparseArray<String> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), this.parcel.readString());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i, SparseArray<Parcel> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.parcel.readInt();
            int i5 = this.parcel.readInt();
            if (i5 != 0) {
                int iDataPosition2 = this.parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.parcel, iDataPosition2, i5);
                sparseArray2.append(i4, parcelObtain);
                this.parcel.setDataPosition(iDataPosition2 + i5);
            } else {
                sparseArray2.append(i4, null);
            }
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), this.parcel.readInt() != 0 ? creator.createFromParcel(this.parcel) : null);
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i, SparseArray<IBinder> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), this.parcel.readStrongBinder());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i, SparseArray<byte[]> sparseArray) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray2.append(this.parcel.readInt(), this.parcel.createByteArray());
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return sparseArray2;
    }

    public ArrayList<Long> createLongList(int i, ArrayList<Long> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(Long.valueOf(this.parcel.readLong()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public ArrayList<Float> createFloatList(int i, ArrayList<Float> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(Float.valueOf(this.parcel.readFloat()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public ArrayList<Double> createDoubleList(int i, ArrayList<Double> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int i2 = this.parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(Double.valueOf(this.parcel.readDouble()));
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public ArrayList<String> createStringList(int i, ArrayList<String> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<String> arrayListCreateStringArrayList = this.parcel.createStringArrayList();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayListCreateStringArrayList;
    }

    public ArrayList<IBinder> createIBinderList(int i, ArrayList<IBinder> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<IBinder> arrayListCreateBinderArrayList = this.parcel.createBinderArrayList();
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayListCreateBinderArrayList;
    }

    public <T> T[] createTypedArray(int i, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return tArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        Object[] objArrCreateTypedArray = this.parcel.createTypedArray(creator);
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return (T[]) objArrCreateTypedArray;
    }

    public <T> ArrayList<T> createTypedList(int i, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        ArrayList<T> arrayListCreateTypedArrayList = this.parcel.createTypedArrayList(creator);
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayListCreateTypedArrayList;
    }

    public Parcel createParcel(int i, Parcel parcel) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return parcel;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(this.parcel, iDataPosition, iMoveField);
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return parcelObtain;
    }

    public Parcel[] createParcelArray(int i, Parcel[] parcelArr) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return parcelArr;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return new Parcel[0];
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        Parcel[] parcelArr2 = new Parcel[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.parcel.readInt();
            if (i4 != 0) {
                int iDataPosition2 = this.parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.parcel, iDataPosition2, i4);
                parcelArr2[i3] = parcelObtain;
                this.parcel.setDataPosition(iDataPosition2 + i4);
            } else {
                parcelArr2[i3] = null;
            }
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i, ArrayList<Parcel> arrayList) {
        if (!this.mapFields.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iMoveField = moveField(i);
        if (iMoveField == 0) {
            return null;
        }
        int iDataPosition = this.parcel.dataPosition();
        int i2 = this.parcel.readInt();
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.parcel.readInt();
            if (i4 != 0) {
                int iDataPosition2 = this.parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.parcel, iDataPosition2, i4);
                arrayList2.add(parcelObtain);
                this.parcel.setDataPosition(iDataPosition2 + i4);
            } else {
                arrayList2.add(null);
            }
        }
        this.parcel.setDataPosition(iDataPosition + iMoveField);
        return arrayList2;
    }

    public void readList(int i, List list, ClassLoader classLoader) {
        if (this.mapFields.containsKey(Integer.valueOf(i))) {
            int iMoveField = moveField(i);
            int iDataPosition = this.parcel.dataPosition();
            if (iMoveField != 0) {
                this.parcel.readList(list, classLoader);
                this.parcel.setDataPosition(iDataPosition + iMoveField);
            }
        }
    }

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }
}
