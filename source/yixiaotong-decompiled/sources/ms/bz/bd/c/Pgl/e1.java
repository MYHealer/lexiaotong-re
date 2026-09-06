package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.MessageDigest;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e1 {
    ServiceConnection c;
    private final Context tt;
    private f1 uj;
    private String ve;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e1.this.uj = new f1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            e1.this.uj = null;
        }
    }

    public e1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8ea24d", new byte[]{6, 82, 59, 98});
        this.c = new pgla();
        this.tt = context;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006a  */
    private String c(f1 f1Var, String str) {
        Signature[] signatureArr;
        String string;
        String packageName = this.tt.getPackageName();
        String string2 = null;
        if (this.ve == null) {
            try {
                signatureArr = this.tt.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f67ad6", new byte[]{68, Ascii.FS, 101, 68}));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    } else {
                        string = null;
                    }
                } catch (Exception unused2) {
                }
            }
            this.ve = string;
        }
        String str2 = this.ve;
        f1Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4e77bc", new byte[]{38, 104, 73, 13, 85, 113, 46, 80, 103, 119, 107, 104, 84, 70, 83, 125, 51, 10, 79, 72, 53, 98, 74, 106, 121}));
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str);
                f1Var.c.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string2 = parcelObtain2.readString();
            } catch (Exception unused3) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d4e50b", new byte[]{122, 38, Ascii.US});
            }
            return string2;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public final void c(pblk.pblb pblbVar) {
        boolean z;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c79b4c", new byte[]{81, 52, 68, Ascii.CAN, 4, 96, 32, 4, 125, 60, 50, 58, 68, 86, 38, 117, 105, Ascii.CAN, 92, 58, 96, 48, 75, Ascii.DC2}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d01b79", new byte[]{118, Base64.padSymbol, 79, 88, 0, 43, 126, 5, 97, 34, 59, Base64.padSymbol, 82, 19, 6, 39, 99}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "126c53", new byte[]{35, Utf8.REPLACEMENT_BYTE, 72, 89, 2, 33, 43, 7, 102, 35, 110, Utf8.REPLACEMENT_BYTE, 85, Ascii.DC2, 4, 45, 54, 93, 78, 55, 37, 62, 81, Ascii.RS, 12, Base64.padSymbol, 1, Ascii.SYN, 117, 37, 41, 51, SignedBytes.MAX_POWER_OF_TWO})));
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9aa7f0", new byte[]{41, 96, 6, 74, 86, 41, 116, 67, Utf8.REPLACEMENT_BYTE, 106, 102, 107, Ascii.ETB, 90, 77, 38, 42, 14, Utf8.REPLACEMENT_BYTE, 119, 45, 109, Ascii.ESC, 71, Ascii.ETB, 8, 10, 101, Ascii.RS, 88, 1, 71, 45, 112, 124, Ascii.NAK, 12, 105, 19, 66}));
        try {
            z = true;
            if (this.tt.bindService(intent, this.c, 1)) {
                try {
                    try {
                        SystemClock.sleep(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    } catch (Exception unused) {
                    }
                    f1 f1Var = this.uj;
                    if (f1Var != null) {
                        String strC = c(f1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2d3ffa", new byte[]{12, 83, 105, 54}));
                        if (pblbVar != null) {
                            pblbVar.c(strC);
                        }
                    }
                } catch (Throwable unused2) {
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "00fb13", new byte[]{46, 34});
                    } finally {
                        if (z) {
                            this.tt.unbindService(this.c);
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            z = false;
        }
    }
}
