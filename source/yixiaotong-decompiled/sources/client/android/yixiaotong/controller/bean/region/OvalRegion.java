package client.android.yixiaotong.controller.bean.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OvalRegion extends RectRegion {
    public static final Parcelable.Creator<OvalRegion> CREATOR = new Parcelable.Creator<OvalRegion>() { // from class: client.android.yixiaotong.controller.bean.region.OvalRegion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OvalRegion createFromParcel(Parcel parcel) {
            return new OvalRegion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OvalRegion[] newArray(int i) {
            return new OvalRegion[i];
        }
    };

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.rectF, i);
    }

    public OvalRegion(RectF rectF) {
        super(rectF);
    }

    private OvalRegion(Parcel parcel) {
        super(parcel);
        this.rectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
