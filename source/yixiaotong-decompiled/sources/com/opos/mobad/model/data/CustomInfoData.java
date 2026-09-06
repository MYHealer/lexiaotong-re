package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.opos.mobad.j.b.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CustomInfoData implements Parcelable {
    public static final Parcelable.Creator<CustomInfoData> CREATOR = new Parcelable.Creator<CustomInfoData>() { // from class: com.opos.mobad.model.data.CustomInfoData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomInfoData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new CustomInfoData(parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomInfoData[] newArray(int i) {
            return new CustomInfoData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7190a;
    private JSONObject b;

    public CustomInfoData(String str) {
        str = str == null ? "" : str;
        this.f7190a = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b = new JSONObject(this.f7190a);
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.a("", e);
        }
    }

    public int a() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_il", 0);
        }
        return 0;
    }

    public int b() {
        JSONObject jSONObject = this.b;
        return jSONObject != null ? jSONObject.optInt("c_vp", c.b()) : c.b();
    }

    public int c() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_iom", 0);
        }
        return 0;
    }

    public int d() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_ct", 3000);
        }
        return 3000;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_dpt", 2000);
        }
        return 2000;
    }

    public String toString() {
        return "CustomInfoData{mInfoString='" + this.f7190a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7190a);
    }
}
