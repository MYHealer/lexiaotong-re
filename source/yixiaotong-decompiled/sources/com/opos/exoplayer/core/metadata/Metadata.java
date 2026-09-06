package com.opos.exoplayer.core.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Entry[] f6522a;

    public interface Entry extends Parcelable {
    }

    static class a implements Parcelable.Creator<Metadata> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata[] newArray(int i) {
            return new Metadata[0];
        }
    }

    Metadata(Parcel parcel) {
        this.f6522a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f6522a;
            if (i >= entryArr.length) {
                return;
            }
            entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i++;
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list == null) {
            this.f6522a = new Entry[0];
            return;
        }
        Entry[] entryArr = new Entry[list.size()];
        this.f6522a = entryArr;
        list.toArray(entryArr);
    }

    public Metadata(Entry... entryArr) {
        this.f6522a = entryArr == null ? new Entry[0] : entryArr;
    }

    public int a() {
        return this.f6522a.length;
    }

    public Entry a(int i) {
        return this.f6522a[i];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6522a, ((Metadata) obj).f6522a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f6522a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6522a.length);
        for (Entry entry : this.f6522a) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
