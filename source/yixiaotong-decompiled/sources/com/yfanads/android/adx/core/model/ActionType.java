package com.yfanads.android.adx.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ubixnow.ooooo.oOOOoo00;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ActionType implements Parcelable {
    public static final Parcelable.Creator<ActionType> CREATOR = new Parcelable.Creator<ActionType>() { // from class: com.yfanads.android.adx.core.model.ActionType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionType createFromParcel(Parcel parcel) {
            return new ActionType(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionType[] newArray(int i) {
            return new ActionType[i];
        }
    };

    @SerializedName("click")
    public ActionValue click;

    @SerializedName("move")
    public ActionValue move;

    @SerializedName("rolling")
    public ActionValue rolling;

    @SerializedName("shake")
    public ActionValue shake;

    public static class ActionValue implements Parcelable {
        public static final Parcelable.Creator<ActionValue> CREATOR = new Parcelable.Creator<ActionValue>() { // from class: com.yfanads.android.adx.core.model.ActionType.ActionValue.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ActionValue createFromParcel(Parcel parcel) {
                return new ActionValue(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ActionValue[] newArray(int i) {
                return new ActionValue[i];
            }
        };

        @SerializedName("default")
        public String defaultValue;

        @SerializedName(oOOOoo00.OooOo0o)
        public String value;

        public ActionValue(Parcel parcel) {
            this.value = parcel.readString();
            this.defaultValue = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.value);
            parcel.writeString(this.defaultValue);
        }
    }

    public ActionType(Parcel parcel) {
        this.click = (ActionValue) parcel.readParcelable(ActionValue.class.getClassLoader());
        this.move = (ActionValue) parcel.readParcelable(ActionValue.class.getClassLoader());
        this.shake = (ActionValue) parcel.readParcelable(ActionValue.class.getClassLoader());
        this.rolling = (ActionValue) parcel.readParcelable(ActionValue.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.click, i);
        parcel.writeParcelable(this.move, i);
        parcel.writeParcelable(this.shake, i);
        parcel.writeParcelable(this.rolling, i);
    }
}
