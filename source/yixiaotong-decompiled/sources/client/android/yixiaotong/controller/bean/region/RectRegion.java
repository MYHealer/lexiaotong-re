package client.android.yixiaotong.controller.bean.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RectRegion implements Parcelable {
    public static final Parcelable.Creator<RectRegion> CREATOR = new Parcelable.Creator<RectRegion>() { // from class: client.android.yixiaotong.controller.bean.region.RectRegion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RectRegion createFromParcel(Parcel parcel) {
            return new RectRegion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RectRegion[] newArray(int i) {
            return new RectRegion[i];
        }
    };
    public RectF rectF;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.rectF, i);
    }

    public RectRegion(RectF rectF) {
        this.rectF = rectF;
    }

    RectRegion(Parcel parcel) {
        this.rectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
