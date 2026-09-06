package client.android.yixiaotong.controller.bean.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RoundRectRegion extends RectRegion {
    public static final Parcelable.Creator<RoundRectRegion> CREATOR = new Parcelable.Creator<RoundRectRegion>() { // from class: client.android.yixiaotong.controller.bean.region.RoundRectRegion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoundRectRegion createFromParcel(Parcel parcel) {
            return new RoundRectRegion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoundRectRegion[] newArray(int i) {
            return new RoundRectRegion[i];
        }
    };
    public float rx;
    public float ry;

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // client.android.yixiaotong.controller.bean.region.RectRegion, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.rx);
        parcel.writeFloat(this.ry);
        parcel.writeParcelable(this.rectF, i);
    }

    public RoundRectRegion(RectF rectF, float f, float f2) {
        super(rectF);
        this.rx = f;
        this.ry = f2;
    }

    private RoundRectRegion(Parcel parcel) {
        super(parcel);
        this.rx = parcel.readFloat();
        this.ry = parcel.readFloat();
        this.rectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
