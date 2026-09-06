package com.opos.mobad.model.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.ui.c.f;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdHelper {

    /* JADX INFO: renamed from: com.opos.mobad.model.utils.AdHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class AdHelperData extends a implements Parcelable {
        public static final Parcelable.Creator<AdHelperData> CREATOR = new Parcelable.Creator<AdHelperData>() { // from class: com.opos.mobad.model.utils.AdHelper.AdHelperData.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdHelperData createFromParcel(Parcel parcel) {
                return new AdHelperData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdHelperData[] newArray(int i) {
                return new AdHelperData[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AdData f7215a;
        public final long b;

        protected AdHelperData(Parcel parcel) {
            super((AdItemData) parcel.readParcelable(AdItemData.class.getClassLoader()), (MaterialData) parcel.readParcelable(MaterialData.class.getClassLoader()), (MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            this.f7215a = (AdData) parcel.readParcelable(AdData.class.getClassLoader());
            this.b = parcel.readLong();
        }

        private AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, long j) {
            this(adData, adItemData, materialData, (MaterialFileData) null, j);
        }

        /* synthetic */ AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, long j, AnonymousClass1 anonymousClass1) {
            this(adData, adItemData, materialData, j);
        }

        private AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData, long j) {
            super(adItemData, materialData, materialFileData);
            this.f7215a = adData;
            this.b = j;
        }

        /* synthetic */ AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData, long j, AnonymousClass1 anonymousClass1) {
            this(adData, adItemData, materialData, materialFileData, j);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.c, i);
            parcel.writeParcelable(this.d, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f7215a, i);
            parcel.writeLong(this.b);
        }
    }

    public static class a {
        public final AdItemData c;
        public final MaterialData d;
        public final MaterialFileData e;

        public a(AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData) {
            this.c = adItemData;
            this.d = materialData;
            this.e = materialFileData;
        }
    }

    public static final AdHelperData a(AdData adData) {
        return a(adData, SystemClock.elapsedRealtime());
    }

    public static final AdHelperData a(AdData adData, long j) {
        List<AdItemData> listF;
        MaterialData materialData;
        MaterialFileData materialFileData;
        if (adData != null && (listF = adData.f()) != null && listF.size() > 0) {
            for (int i = 0; i < listF.size(); i++) {
                AdItemData adItemData = listF.get(i);
                if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0 && (materialData = adItemData.i().get(0)) != null) {
                    if (!f.a(materialData.Z())) {
                        return new AdHelperData(adData, adItemData, materialData, j, (AnonymousClass1) null);
                    }
                    if (materialData.D() != null && materialData.D().size() > 0 && (materialFileData = materialData.D().get(0)) != null) {
                        return new AdHelperData(adData, adItemData, materialData, materialFileData, j, null);
                    }
                }
            }
        }
        return null;
    }
}
