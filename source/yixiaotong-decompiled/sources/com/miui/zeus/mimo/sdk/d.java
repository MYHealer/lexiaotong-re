package com.miui.zeus.mimo.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.miui.zeus.mimo.sdk.a<IDownloadListener> {
    public String e;
    public int f;
    public boolean g;
    public boolean h;
    public b i;
    public a j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5399a;
        public String b;
        public String c;
        public String d;
        public long e;
        public String f;
        public int g;
        public int h;

        public a() {
            this.g = 0;
            this.h = 0;
        }

        public a(String str, String str2, String str3, String str4, int i, String str5, int i2, int i3) {
            this.f5399a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
            this.f = str5;
            this.g = i2;
            this.h = i3;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5400a;
        public boolean b;

        public b(boolean z, boolean z2) {
            this.f5400a = z;
            this.b = z2;
        }

        public static b a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new b(jSONObject.optBoolean(ijiami_1011.s.s.s.d(new byte[]{5, 84, 91, 116, 84, 91, 2, 1, 10}, "f55755")), jSONObject.optBoolean(ijiami_1011.s.s.s.d(new byte[]{80, 93, 69, 93, 88, 75, Ascii.DC2, 51, 14, 7, 95, 33, 91, 67, 88, 92, 94, 89, 5, 55, Ascii.DC2, 3, 67, 17}, "446018")));
            } catch (Exception e) {
                Log.e(ijiami_1011.s.s.s.d(new byte[]{119, 90, 19, 10, 85, 9, 0, 0, 39, 1, 69, 12, 92, 91}, "35dd9f"), ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 81, 70, Ascii.SYN, 93, 66, 44, 13, 8, 11, 114, 4, Ascii.ETB, 84, 119, 10, 86, 4, 8, 3, 70, 7, 17, 95, 69}, "e04e8b"), e);
                return null;
            }
        }
    }

    public d(Parcel parcel) {
        super(parcel);
        try {
            String string = parcel.readString();
            this.e = string;
            if (TextUtils.isEmpty(string)) {
                this.e = b();
            }
            this.f = parcel.readInt();
            this.g = a(parcel.readInt());
            this.h = a(parcel.readInt());
            this.i = b.a(parcel.readString());
            a aVarB = b(parcel.readString());
            this.j = aVarB;
            if (aVarB == null) {
                this.j = new a();
            }
        } catch (Exception e) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{114, 10, Ascii.SYN, 10, 10, 90, 0, 0, 39, 1, 69, 12, 89, 11}, "6eadf5"), ijiami_1011.s.s.s.d(new byte[]{113, 94, 66, 92, 92, 90, 0, 0, 39, 1, 69, 12, 90, 95, Ascii.NAK, 66, 81, 71, Ascii.DC2, 1, 70, Ascii.DC2, 80, Ascii.ETB, 86, 84, 89, Ascii.DC2, 85, Ascii.NAK, 91, 68}, "515205"), e);
        }
    }

    public static String b() {
        String str = ijiami_1011.s.s.s.d(new byte[]{117, 117, 47, 38, 109, 50, 32, 39, 45, 35, 118, 32, 9}, "34dc2b") + String.valueOf(System.currentTimeMillis()).hashCode();
        Log.w(ijiami_1011.s.s.s.d(new byte[]{119, 92, 19, 89, 93, 86, 0, 0, 39, 1, 69, 12, 92, 93}, "33d719"), ijiami_1011.s.s.s.d(new byte[]{81, 87, 10, 87, 70, 82, Ascii.NAK, 1, 70, 4, 80, 14, 83, Ascii.DC2, Ascii.DC4, 83, 87, 88, 0, 3, 3, 44, 80, 8, 83, 105}, "62d243") + str + ijiami_1011.s.s.s.d(new byte[]{59}, "fedda6"));
        return str;
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public int a() {
        return 3;
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public IInterface a(IBinder iBinder) {
        return IDownloadListener.Stub.asInterface(iBinder);
    }

    public final a b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{6, 11, 17, 94, 8, 88, 0, 0, 51, 16, 93}, "bdf0d7")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{11, 86, 9, 11, 96, 67, 13}, "b5fe51")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{17, 12, Ascii.SYN, 15, 4}, "eebca5")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 16, 84, 94, 88, Ascii.SYN, Ascii.CAN}, "ae939d")), jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{65, 95, 79, 0}, "265e17")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{0, 83, 65, 86, 5, 14, 19, Ascii.GS}, "c253ba")), jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{91, 83, 75, 93, 92, 71, 37, 11, 17, 12, 93, 10, 87, 86, 109, 79, 73, 86}, "629693")), jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{91, 7, Ascii.ETB, 14, 85, 76, 39, 8, 9, 3, 69, 38, 87, Ascii.DC4, 1, 53, 95, 75, 8, 16, 15, 13, 95}, "6fee08")));
        } catch (Exception e) {
            try {
                Log.e(ijiami_1011.s.s.s.d(new byte[]{125, 93, 65, 12, 9, 95, 0, 0, 39, 1, 69, 12, 86, 92}, "926be0"), ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 81, 19, 70, 92, Ascii.CAN, 44, 13, 8, 11, 114, 4, Ascii.ETB, 84, 34, 90, 87, 94, 8, 3, 70, 7, 17, 95, 69}, "e0a598"), e);
                return null;
            } catch (Exception e2) {
                Log.e(ijiami_1011.s.s.s.d(new byte[]{32, 88, 79, 15, 15, 91, 0, 0, 39, 1, 69, 12, 11, 89}, "d78ac4"), ijiami_1011.s.s.s.d(new byte[]{67, 83, 75, 71, 0, 16, 37, 11, 17, 12, 93, 10, 82, 86, 112, 90, 3, 95, 65, 1, 70, 88, 17}, "3294e0"), e2);
                return null;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(a(this.g));
        parcel.writeInt(a(this.h));
        b bVar = this.i;
        bVar.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{2, 81, 11, 123, 84, 93, 2, 1, 10}, "a0e853"), bVar.f5400a);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{85, 89, Ascii.SYN, 93, 92, Ascii.DC2, Ascii.DC2, 51, 14, 7, 95, 33, 94, 71, 11, 92, 90, 0, 5, 55, Ascii.DC2, 3, 67, 17}, "10e05a"), bVar.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        parcel.writeString(jSONObject.toString());
        a aVar = this.j;
        aVar.getClass();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{0, 11, 69, 93, 13, 94, 0, 0, 51, 16, 93}, "dd23a1"), aVar.f5399a);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{94, 2, 14, 8, 49, 74, 13}, "7aafd8"), aVar.b);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{17, 81, Ascii.DC2, 85, 85}, "e8f902"), aVar.c);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, Ascii.ETB, 84, 84, 87, 75, Ascii.CAN}, "eb9969"), aVar.d);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{74, 94, 67, 86}, "97933c"), aVar.e);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{5, 84, 17, 3, 85, 89, 19, Ascii.GS}, "f5ef26"), aVar.f);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{84, 81, 17, 83, 86, Ascii.SYN, 37, 11, 17, 12, 93, 10, 88, 84, 55, 65, 67, 7}, "90c83b"), aVar.g);
            jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{90, 89, 66, 10, 93, 65, 39, 8, 9, 3, 69, 38, 86, 74, 84, 49, 87, 70, 8, 16, 15, 13, 95}, "780a85"), aVar.h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        parcel.writeString(jSONObject2.toString());
    }
}
