package client.android.yixiaotong.controller.bean.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CircleRegion extends RectRegion {
    public static final Parcelable.Creator<CircleRegion> CREATOR = new Parcelable.Creator<CircleRegion>() { // from class: client.android.yixiaotong.controller.bean.region.CircleRegion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleRegion createFromParcel(Parcel parcel) {
            return new CircleRegion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleRegion[] newArray(int i) {
            return new CircleRegion[i];
        }
    };
    public float radius;

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.radius);
        parcel.writeParcelable(this.rectF, i);
    }

    public CircleRegion(RectF rectF, float f) {
        super(rectF);
        this.radius = f;
    }

    private CircleRegion(Parcel parcel) {
        super(parcel);
        this.radius = parcel.readFloat();
        this.rectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
