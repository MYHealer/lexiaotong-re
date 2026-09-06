package com.byazt.gi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 678, 13})
public class tt implements Parcelable {
    public static final Parcelable.Creator<tt> CREATOR = new Parcelable.Creator<tt>() { // from class: com.byazt.gi.tt.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public tt createFromParcel(Parcel parcel) {
            return new tt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public tt[] newArray(int i) {
            return new tt[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2253a;
    public int c;
    public String n;
    public int tt;
    public int uj;
    public String ve;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public tt() {
        this.ve = "";
        this.n = "";
        this.f2253a = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.tt);
        parcel.writeString(this.ve);
        parcel.writeString(this.n);
        parcel.writeString(this.f2253a);
        parcel.writeInt(this.uj);
    }

    public tt(Parcel parcel) {
        this.ve = "";
        this.n = "";
        this.f2253a = "";
        this.c = parcel.readInt();
        this.tt = parcel.readInt();
        this.ve = parcel.readString();
        this.n = parcel.readString();
        this.f2253a = parcel.readString();
        this.uj = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            tt ttVar = (tt) obj;
            if (this.c == ttVar.c && this.tt == ttVar.tt) {
                String str = this.ve;
                if (str != null) {
                    return str.equals(ttVar.ve);
                }
                if (ttVar.ve == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.c * 31) + this.tt) * 31;
        String str = this.ve;
        return i + (str != null ? str.hashCode() : 0);
    }
}
