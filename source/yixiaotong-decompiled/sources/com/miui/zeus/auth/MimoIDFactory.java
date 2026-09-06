package com.miui.zeus.auth;

import android.content.Context;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import com.miui.zeus.auth.aidl.ICheckListener;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.q9;
import ijiami_1011.s.s.s;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoIDFactory extends ICheckListener.Stub {
    public static MimoIDFactory INSTANCE = new MimoIDFactory();
    private long lastGenerateTime;
    private String TAG = getClass().getSimpleName();
    private int validTime = 30;
    private String mimoID = "";

    private MimoIDFactory() {
    }

    private String generateMimoID() {
        Random random = new Random(System.nanoTime());
        try {
            return getMd5(UUID.randomUUID().toString() + s.d(new byte[]{95}, "ef5147") + random.nextLong());
        } catch (Exception unused) {
            return getMd5(Long.toString(random.nextLong()));
        }
    }

    private String getMd5(String str) {
        if (str == null) {
            str = "";
        }
        return getMd5(str.getBytes());
    }

    private String getMd5(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(s.d(new byte[]{41, 125, 80}, "d9ed1a"));
            messageDigest.update(bArr);
            str = String.format(s.d(new byte[]{17, 0, Ascii.DC4, 3, 3, 3, 57}, "410301"), new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    public String getMimoID(Context context) {
        if (this.mimoID.isEmpty() || SystemClock.elapsedRealtime() - this.lastGenerateTime > ((long) (this.validTime * 60)) * 1000) {
            this.lastGenerateTime = SystemClock.elapsedRealtime();
            String strGenerateMimoID = generateMimoID();
            this.mimoID = strGenerateMimoID;
            b.a(context, strGenerateMimoID, this);
        }
        return this.mimoID;
    }

    @Override // com.miui.zeus.auth.aidl.ICheckListener
    public void onFailure(String str, int i) {
        q9.a(this.TAG, s.d(new byte[]{7, 17, 69, 88, Ascii.ETB, 9, 92, 89}, "bc77e4") + i + s.d(new byte[]{8, 15, 94}, "52c820") + str);
    }

    @Override // com.miui.zeus.auth.aidl.ICheckListener
    public void onSuccess(String str) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    return;
                }
                int iOptInt = new JSONObject(str).optInt(s.d(new byte[]{90, 87, Ascii.NAK, 4, Ascii.SYN, Ascii.DC4, 0, 8, 50, 11, 92, 0}, "39aadb"));
                if (iOptInt > 0) {
                    this.validTime = iOptInt;
                }
                q9.a(this.TAG, s.d(new byte[]{13, 8, 107, 19, 82, 80, 4, Ascii.ETB, Ascii.NAK, 95, 12, 88}, "bf8f13") + this.validTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
