package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeedbackData extends a implements Parcelable {
    public static final Parcelable.Creator<FeedbackData> CREATOR = new Parcelable.Creator<FeedbackData>() { // from class: com.opos.mobad.model.data.FeedbackData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedbackData createFromParcel(Parcel parcel) {
            return new FeedbackData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedbackData[] newArray(int i) {
            return new FeedbackData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f7191a;
    private List<String> b;

    public FeedbackData() {
        this.f7191a = new ArrayList();
        this.b = new ArrayList();
    }

    protected FeedbackData(Parcel parcel) {
        if (parcel != null) {
            ArrayList arrayList = new ArrayList();
            this.f7191a = arrayList;
            parcel.readList(arrayList, Integer.class.getClassLoader());
            this.b = parcel.createStringArrayList();
        }
    }

    public List<String> a() {
        return this.b;
    }

    public void a(int i, String str) {
        this.f7191a.add(Integer.valueOf(i));
        this.b.add(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FeedbackData{types=" + this.f7191a + ", urls='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7191a);
        parcel.writeStringList(this.b);
    }
}
