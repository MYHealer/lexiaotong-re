package com.miui.zeus.mimo.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a<T extends IInterface> implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0858a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5278a;
    public b b;
    public T c;
    public boolean d;

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.a$a, reason: collision with other inner class name */
    public class C0858a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            if (i == 0) {
                Log.d(ijiami_1011.s.s.s.d(new byte[]{113, 85, 17, 81, 9, 87, 34, Ascii.SYN, 3, 3, 69, 10, 66}, "06e8f9"), ijiami_1011.s.s.s.d(new byte[]{84, 66, 69, 12, 68, Ascii.ETB, 91, 68, 39, 1, 69, 12, 94, 94, Ascii.ETB, 0, 87, 89, 70, 16, 70, 0, 84, 69, 88, 94, 68, Ascii.ETB, 87, 89, Ascii.NAK, 13, 7, Ascii.SYN, 88, 10, 95}, "107c67"));
            } else {
                if (i == 1) {
                    return new c(parcel);
                }
                if (i == 2) {
                    return new e(parcel);
                }
                if (i == 3) {
                    return new d(parcel);
                }
                Log.d(ijiami_1011.s.s.s.d(new byte[]{120, 84, 66, 95, 92, 12, 34, Ascii.SYN, 3, 3, 69, 10, 75}, "97663b"), ijiami_1011.s.s.s.d(new byte[]{19, 88, 13, 88, 12, 65, 15, 68, 7, 1, 69, 12, 9, 88, 70, 66, 26, 70, 4, 68, 92, 66}, "f6f6c6") + i);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5279a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.f5279a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
        }
    }

    public a(Parcel parcel) {
        this.f5278a = a();
        if (parcel != null) {
            this.f5278a = a();
            this.b = a(parcel.readString());
            this.c = (T) a(parcel.readStrongBinder());
            this.d = a(parcel.readInt());
        }
    }

    public int a() {
        throw null;
    }

    public int a(boolean z) {
        return z ? 1 : 0;
    }

    public T a(IBinder iBinder) {
        throw null;
    }

    public final b a(String str) {
        b bVar = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar = new b(jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{88, 81, 98, 2, 67, 70, 3, 5, 5, 9}, "952c05")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{87, 92, 10, 82, 91, 3, 42, 1, Ascii.US}, "43d42d")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 92, 81}, "f97662")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{87, 67, 10, 117, 92, 84, 15, 10, 3, 14}, "63a645")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{70, 68, 4, 91, 91, 103, 0, 7, 13, 3, 86, 0}, "26e807")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{3, 72, Ascii.DC4, 34, 93, 88, 4, 10, Ascii.DC2, 43, 85}, "b8da11")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{4, 66, SignedBytes.MAX_POWER_OF_TWO, 50, 10, 1, 15, 5, Ascii.DC2, Ascii.ETB, 67, 0}, "e20acf")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{15, 10, 87, 1, 87}, "ae9b2f")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return bVar;
        } catch (Exception e2) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{39, 82, 17, 91, 13, 11}, "f1e2be"), ijiami_1011.s.s.s.d(new byte[]{72, 87, 69, SignedBytes.MAX_POWER_OF_TWO, 1, 118, 5, 48, Ascii.DC4, 3, 82, 14, 113, 88, 81, 92, 68, 82, 65, 94, 70}, "8673d7"), e2);
            return bVar;
        }
    }

    public boolean a(int i) {
        return i > 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String string;
        parcel.writeInt(this.f5278a);
        b bVar = this.b;
        if (bVar == null) {
            string = "";
        } else {
            bVar.getClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{85, 6, 96, 87, 17, Ascii.DC2, 3, 5, 5, 9}, "4b06ba"), bVar.f5279a);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{83, 89, 93, 0, 8, 85, 42, 1, Ascii.US}, "063fa2"), bVar.b);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{75, 84, 94}, "91841d"), bVar.c);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{86, 67, 92, 115, 93, 89, 15, 10, 3, 14}, "737058"), bVar.d);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 19, 83, 85, 10, 52, 0, 7, 13, 3, 86, 0}, "aa26ad"), bVar.e);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{80, Ascii.DC4, Ascii.NAK, 122, 89, 95, 4, 10, Ascii.DC2, 43, 85}, "1de956"), bVar.f);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{80, 71, 65, 54, 95, 83, 15, 5, Ascii.DC2, Ascii.ETB, 67, 0}, "171e64"), bVar.g);
                jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{91, 12, 11, 0, 80}, "5cec56"), bVar.h);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            string = jSONObject.toString();
        }
        parcel.writeString(string);
        parcel.writeStrongInterface(this.c);
        parcel.writeInt(a(this.d));
    }
}
