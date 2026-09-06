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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ParcelReader {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 65262;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer[]> f3985a = new HashMap<>();
    public Parcel b;

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.b = parcel;
        a();
    }

    private int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    private void a() {
        int i = this.b.readInt();
        int i2 = i & 65535;
        int i3 = (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : this.b.readInt();
        if (i2 != 65262) {
            throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i2), this.b);
        }
        int iDataPosition = this.b.dataPosition();
        int i4 = i3 + iDataPosition;
        if (i4 < iDataPosition || i4 > this.b.dataSize()) {
            throw new ParseException("invalid size, start=" + iDataPosition + " end=" + i4, this.b);
        }
        while (this.b.dataPosition() < i4) {
            int i5 = this.b.readInt();
            int i6 = i5 & 65535;
            int i7 = (i5 & SupportMenu.CATEGORY_MASK) != -65536 ? (i5 >> 16) & 65535 : this.b.readInt();
            int iDataPosition2 = this.b.dataPosition();
            this.f3985a.put(Integer.valueOf(i6), new Integer[]{Integer.valueOf(iDataPosition2), Integer.valueOf(i7)});
            this.b.setDataPosition(iDataPosition2 + i7);
        }
        if (this.b.dataPosition() != i4) {
            throw new ParseException("the dataPosition is not" + i4, this.b);
        }
    }

    private void a(int i, int i2) {
        Integer[] numArr = this.f3985a.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.b);
        }
        int iIntValue = numArr[1].intValue();
        if (iIntValue == i2) {
            return;
        }
        throw new ParseException("the field size is not " + i2 + " got " + iIntValue + " (0x" + Integer.toHexString(iIntValue) + ")", this.b);
    }

    private int b(int i) {
        Integer[] numArr = this.f3985a.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.b);
        }
        this.b.setDataPosition(numArr[0].intValue());
        return numArr[1].intValue();
    }

    private int b(int i, int i2) {
        Integer[] numArr = this.f3985a.get(Integer.valueOf(i));
        if (numArr == null) {
            throw new ParseException("Field is null:" + numArr, this.b);
        }
        this.b.setDataPosition(numArr[0].intValue());
        a(i, i2);
        return i2;
    }

    public BigDecimal createBigDecimal(int i, BigDecimal bigDecimal) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bigDecimal;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        byte[] bArrCreateByteArray = this.b.createByteArray();
        int i2 = this.b.readInt();
        this.b.setDataPosition(iDataPosition + iB);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    public BigDecimal[] createBigDecimalArray(int i, BigDecimal[] bigDecimalArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bigDecimalArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            byte[] bArrCreateByteArray = this.b.createByteArray();
            bigDecimalArr2[i2] = new BigDecimal(new BigInteger(bArrCreateByteArray), this.b.readInt());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i, BigInteger bigInteger) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bigInteger;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        byte[] bArrCreateByteArray = this.b.createByteArray();
        this.b.setDataPosition(iDataPosition + iB);
        return new BigInteger(bArrCreateByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i, BigInteger[] bigIntegerArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bigIntegerArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            bigIntegerArr2[i2] = new BigInteger(this.b.createByteArray());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i, boolean[] zArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return zArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        boolean[] zArrCreateBooleanArray = this.b.createBooleanArray();
        this.b.setDataPosition(iDataPosition + iB);
        return zArrCreateBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i, ArrayList<Boolean> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Boolean.valueOf(this.b.readInt() != 0));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public byte[] createByteArray(int i, byte[] bArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        byte[] bArrCreateByteArray = this.b.createByteArray();
        this.b.setDataPosition(iDataPosition + iB);
        return bArrCreateByteArray;
    }

    public byte[][] createByteArrayArray(int i, byte[][] bArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        byte[][] bArr2 = new byte[iA][];
        for (int i2 = 0; i2 < iA; i2++) {
            bArr2[i2] = this.b.createByteArray();
        }
        this.b.setDataPosition(iDataPosition + iB);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i, SparseArray<byte[]> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.createByteArray());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public char[] createCharArray(int i, char[] cArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return cArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        char[] cArrCreateCharArray = this.b.createCharArray();
        this.b.setDataPosition(iDataPosition + iB);
        return cArrCreateCharArray;
    }

    public double[] createDoubleArray(int i, double[] dArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return dArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        double[] dArrCreateDoubleArray = this.b.createDoubleArray();
        this.b.setDataPosition(iDataPosition + iB);
        return dArrCreateDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i, ArrayList<Double> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Double.valueOf(this.b.readDouble()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i, SparseArray<Double> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), Double.valueOf(this.b.readDouble()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public float[] createFloatArray(int i, float[] fArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return fArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        float[] fArrCreateFloatArray = this.b.createFloatArray();
        this.b.setDataPosition(iDataPosition + iB);
        return fArrCreateFloatArray;
    }

    public ArrayList<Float> createFloatList(int i, ArrayList<Float> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Float.valueOf(this.b.readFloat()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i, SparseArray<Float> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), Float.valueOf(this.b.readFloat()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i, IBinder[] iBinderArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return iBinderArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        IBinder[] iBinderArrCreateBinderArray = this.b.createBinderArray();
        this.b.setDataPosition(iDataPosition + iB);
        return iBinderArrCreateBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i, ArrayList<IBinder> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<IBinder> arrayListCreateBinderArrayList = this.b.createBinderArrayList();
        this.b.setDataPosition(iDataPosition + iB);
        return arrayListCreateBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i, SparseArray<IBinder> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readStrongBinder());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public int[] createIntArray(int i, int[] iArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return iArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int[] iArrCreateIntArray = this.b.createIntArray();
        this.b.setDataPosition(iDataPosition + iB);
        return iArrCreateIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i, ArrayList<Integer> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Integer.valueOf(this.b.readInt()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public long[] createLongArray(int i, long[] jArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return jArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        long[] jArrCreateLongArray = this.b.createLongArray();
        this.b.setDataPosition(iDataPosition + iB);
        return jArrCreateLongArray;
    }

    public ArrayList<Long> createLongList(int i, ArrayList<Long> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            arrayList2.add(Long.valueOf(this.b.readLong()));
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public Parcel createParcel(int i, Parcel parcel) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return parcel;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(this.b, iDataPosition, iB);
        this.b.setDataPosition(iDataPosition + iB);
        return parcelObtain;
    }

    public Parcel[] createParcelArray(int i, Parcel[] parcelArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return parcelArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        Parcel[] parcelArr2 = new Parcel[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.b.readInt();
            if (i3 != 0) {
                int iDataPosition2 = this.b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.b, iDataPosition2, i3);
                parcelArr2[i2] = parcelObtain;
                this.b.setDataPosition(iDataPosition2 + i3);
            } else {
                parcelArr2[i2] = null;
            }
        }
        this.b.setDataPosition(iDataPosition + iB);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i, ArrayList<Parcel> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.b.readInt();
            if (i3 != 0) {
                int iDataPosition2 = this.b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.b, iDataPosition2, i3);
                arrayList2.add(parcelObtain);
                this.b.setDataPosition(iDataPosition2 + i3);
            } else {
                arrayList2.add(null);
            }
        }
        this.b.setDataPosition(iDataPosition + iB);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i, SparseArray<Parcel> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < iA; i2++) {
            int i3 = this.b.readInt();
            int i4 = this.b.readInt();
            if (i4 != 0) {
                int iDataPosition2 = this.b.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(this.b, iDataPosition2, i4);
                sparseArray2.append(i3, parcelObtain);
                this.b.setDataPosition(iDataPosition2 + i4);
            } else {
                sparseArray2.append(i3, null);
            }
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseBooleanArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseBooleanArray sparseBooleanArray2 = this.b.readSparseBooleanArray();
        this.b.setDataPosition(iDataPosition + iB);
        return sparseBooleanArray2;
    }

    public SparseIntArray createSparseIntArray(int i, SparseIntArray sparseIntArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseIntArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseIntArray2.append(this.b.readInt(), this.b.readInt());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i, SparseLongArray sparseLongArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseLongArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseLongArray2.append(this.b.readInt(), this.b.readLong());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseLongArray2;
    }

    public String createString(int i, String str) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return str;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        String string = this.b.readString();
        this.b.setDataPosition(iDataPosition + iB);
        return string;
    }

    public String[] createStringArray(int i, String[] strArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return strArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        String[] strArrCreateStringArray = this.b.createStringArray();
        this.b.setDataPosition(iDataPosition + iB);
        return strArrCreateStringArray;
    }

    public ArrayList<String> createStringList(int i, ArrayList<String> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<String> arrayListCreateStringArrayList = this.b.createStringArrayList();
        this.b.setDataPosition(iDataPosition + iB);
        return arrayListCreateStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i, SparseArray<String> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int iA = a(this.b.readInt());
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readString());
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return tArr;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        T[] tArr2 = (T[]) this.b.createTypedArray(creator);
        this.b.setDataPosition(iDataPosition + iB);
        return tArr2;
    }

    public <T> ArrayList<T> createTypedList(int i, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        ArrayList<T> arrayListCreateTypedArrayList = this.b.createTypedArrayList(creator);
        this.b.setDataPosition(iDataPosition + iB);
        return arrayListCreateTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        int iA = a(this.b.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < iA; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readInt() != 0 ? creator.createFromParcel(this.b) : null);
        }
        this.b.setDataPosition(iDataPosition + iB);
        return sparseArray2;
    }

    public boolean readBoolean(int i, boolean z) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return z;
        }
        b(i, 4);
        return this.b.readInt() != 0;
    }

    public Boolean readBooleanObject(int i, Boolean bool) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bool;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        int i2 = this.b.readInt();
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        if (i2 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i, Bundle bundle) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return bundle;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        Bundle bundle2 = this.b.readBundle();
        this.b.setDataPosition(iDataPosition + iB);
        return bundle2;
    }

    public byte readByte(int i, byte b) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return b;
        }
        b(i, 4);
        return (byte) this.b.readInt();
    }

    public char readChar(int i, char c2) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return c2;
        }
        b(i, 4);
        return (char) this.b.readInt();
    }

    public double readDouble(int i, double d2) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return d2;
        }
        b(i, 8);
        return this.b.readDouble();
    }

    public Double readDoubleObject(int i, Double d2) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return d2;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 8);
        return Double.valueOf(this.b.readDouble());
    }

    public float readFloat(int i, float f) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return f;
        }
        b(i, 4);
        return this.b.readFloat();
    }

    public Float readFloatObject(int i, Float f) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return f;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        return Float.valueOf(this.b.readFloat());
    }

    public IBinder readIBinder(int i, IBinder iBinder) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return iBinder;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        IBinder strongBinder = this.b.readStrongBinder();
        this.b.setDataPosition(iDataPosition + iB);
        return strongBinder;
    }

    public int readInt(int i, int i2) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return i2;
        }
        b(i, 4);
        return this.b.readInt();
    }

    public Integer readIntegerObject(int i, Integer num) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return num;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 4);
        return Integer.valueOf(this.b.readInt());
    }

    public void readList(int i, List list, ClassLoader classLoader) {
        if (this.f3985a.containsKey(Integer.valueOf(i))) {
            int iB = b(i);
            int iDataPosition = this.b.dataPosition();
            if (iB != 0) {
                this.b.readList(list, classLoader);
                this.b.setDataPosition(iDataPosition + iB);
            }
        }
    }

    public long readLong(int i, long j) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return j;
        }
        b(i, 8);
        return this.b.readLong();
    }

    public Long readLongObject(int i, Long l) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return l;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        a(iB, 8);
        return Long.valueOf(this.b.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i, Parcelable.Creator<T> creator, T t) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return t;
        }
        int iB = b(i);
        if (iB == 0) {
            return null;
        }
        int iDataPosition = this.b.dataPosition();
        T tCreateFromParcel = creator.createFromParcel(this.b);
        this.b.setDataPosition(iDataPosition + iB);
        return tCreateFromParcel;
    }

    public short readShort(int i, short s) {
        if (!this.f3985a.containsKey(Integer.valueOf(i))) {
            return s;
        }
        b(i, 4);
        return (short) this.b.readInt();
    }
}
