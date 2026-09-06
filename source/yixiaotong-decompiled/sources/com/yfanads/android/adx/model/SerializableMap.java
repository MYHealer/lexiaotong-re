package com.yfanads.android.adx.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SerializableMap implements Parcelable {
    public static final Parcelable.Creator<SerializableMap> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f9610a;

    public class a implements Parcelable.Creator<SerializableMap> {
        @Override // android.os.Parcelable.Creator
        public final SerializableMap createFromParcel(Parcel parcel) {
            return new SerializableMap(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SerializableMap[] newArray(int i) {
            return new SerializableMap[i];
        }
    }

    public SerializableMap() {
        this.f9610a = new HashMap();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9610a.size());
        for (Map.Entry<String, Object> entry : this.f9610a.entrySet()) {
            parcel.writeString(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof String) {
                parcel.writeInt(0);
                parcel.writeString((String) value);
            } else if (value instanceof Integer) {
                parcel.writeInt(1);
                parcel.writeInt(((Integer) value).intValue());
            } else if (value instanceof Long) {
                parcel.writeInt(2);
                parcel.writeLong(((Long) value).longValue());
            } else if (value instanceof Boolean) {
                parcel.writeInt(3);
                parcel.writeByte(((Boolean) value).booleanValue() ? (byte) 1 : (byte) 0);
            } else if (value instanceof Float) {
                parcel.writeInt(4);
                parcel.writeFloat(((Float) value).floatValue());
            } else if (value instanceof Double) {
                parcel.writeInt(5);
                parcel.writeDouble(((Double) value).doubleValue());
            } else if (value instanceof Parcelable) {
                parcel.writeInt(6);
                parcel.writeParcelable((Parcelable) value, i);
            } else {
                parcel.writeInt(0);
                parcel.writeString(value != null ? value.toString() : "");
            }
        }
    }

    public SerializableMap(Map<String, Object> map) {
        this.f9610a = map == null ? new HashMap<>() : map;
    }

    public SerializableMap(Parcel parcel) {
        int i = parcel.readInt();
        this.f9610a = new HashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            String string = parcel.readString();
            switch (parcel.readInt()) {
                case 0:
                    this.f9610a.put(string, parcel.readString());
                    break;
                case 1:
                    this.f9610a.put(string, Integer.valueOf(parcel.readInt()));
                    break;
                case 2:
                    this.f9610a.put(string, Long.valueOf(parcel.readLong()));
                    break;
                case 3:
                    this.f9610a.put(string, Boolean.valueOf(parcel.readByte() != 0));
                    break;
                case 4:
                    this.f9610a.put(string, Float.valueOf(parcel.readFloat()));
                    break;
                case 5:
                    this.f9610a.put(string, Double.valueOf(parcel.readDouble()));
                    break;
                case 6:
                    this.f9610a.put(string, parcel.readParcelable(getClass().getClassLoader()));
                    break;
            }
        }
    }
}
