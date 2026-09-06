package com.huawei.hms.ml.common.card.bcr;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.base.common.AbstractSafeParcelable;
import com.huawei.hms.base.common.ParcelReader;
import com.huawei.hms.base.common.ParcelWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDetectorBorderPointParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BcrDetectorBorderPointParcel> CREATOR = new Parcelable.Creator<BcrDetectorBorderPointParcel>() { // from class: com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderPointParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorBorderPointParcel createFromParcel(Parcel parcel) {
            return new BcrDetectorBorderPointParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorBorderPointParcel[] newArray(int i) {
            return new BcrDetectorBorderPointParcel[i];
        }
    };
    public Point leftBottom;
    public Point leftTop;
    public Point rightBottom;
    public Point rightTop;

    public BcrDetectorBorderPointParcel() {
    }

    public BcrDetectorBorderPointParcel(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.leftTop = (Point) parcelReader.readParcelable(2, Point.CREATOR, null);
        this.rightTop = (Point) parcelReader.readParcelable(3, Point.CREATOR, null);
        this.leftBottom = (Point) parcelReader.readParcelable(4, Point.CREATOR, null);
        this.rightBottom = (Point) parcelReader.readParcelable(5, Point.CREATOR, null);
        parcelReader.finish();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWriter parcelWriter = new ParcelWriter(parcel);
        int iBeginObjectHeader = parcelWriter.beginObjectHeader();
        parcelWriter.writeParcelable(2, this.leftTop, i, false);
        parcelWriter.writeParcelable(3, this.rightTop, i, false);
        parcelWriter.writeParcelable(4, this.leftBottom, i, false);
        parcelWriter.writeParcelable(5, this.rightBottom, i, false);
        parcelWriter.finishObjectHeader(iBeginObjectHeader);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder("leftTop=");
        Object obj = this.leftTop;
        if (obj == null) {
            obj = "NULL";
        }
        stringBuffer.append(sb.append(obj).toString());
        stringBuffer.append(", ");
        StringBuilder sb2 = new StringBuilder("rightTop=");
        Object obj2 = this.rightTop;
        if (obj2 == null) {
            obj2 = "NULL";
        }
        stringBuffer.append(sb2.append(obj2).toString());
        stringBuffer.append(", ");
        StringBuilder sb3 = new StringBuilder("rightBottom=");
        Object obj3 = this.rightBottom;
        if (obj3 == null) {
            obj3 = "NULL";
        }
        stringBuffer.append(sb3.append(obj3).toString());
        stringBuffer.append(", ");
        StringBuilder sb4 = new StringBuilder("leftBottom=");
        Point point = this.leftBottom;
        stringBuffer.append(sb4.append(point != null ? point : "NULL").toString());
        return stringBuffer.toString();
    }
}
