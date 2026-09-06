package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5726a = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 5}, "e308da");
    public static int b = 200;
    public static int c = -2;

    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5727a;
        public final /* synthetic */ Context b;

        public a(String str, Context context) {
            this.f5727a = str;
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            String str = w6.f5726a;
            m.a(str, ijiami_1011.s.s.s.d(new byte[]{92, Ascii.DC2, 32, 67, 73, 113, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 80, 5}, "5aa398"));
            Uri uri = Uri.parse(ijiami_1011.s.s.s.d(new byte[]{5, 90, 94, 68, 87, 13, Ascii.NAK, 94, 73, 77, 82, 10, 11, Ascii.ESC, 72, 89, 83, 12, 12, 13, 72, 15, 80, Ascii.ETB, 13, 80, 68, Ascii.RS, 66, 17, 14, Ascii.DC2, 15, 6, 84, Ascii.ETB, 72, 113, 89, 66, 87, 0, Ascii.NAK, 41, 7, 11, 93, 53, Ascii.DC4, 90, 70, 89, 86, 6, 19, 75, Ascii.NAK, Ascii.SYN, 80, 17, 19, 70}, "f5002c"));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(ijiami_1011.s.s.s.d(new byte[]{66, 80, 5, 93, 3, 82, 4, 42, 7, 15, 84, Ascii.SYN}, "21f6b5"), new ArrayList<>(Collections.singletonList(this.f5727a)));
            Bundle bundleCall = this.b.getContentResolver().call(uri, ijiami_1011.s.s.s.d(new byte[]{19, 77, 92, 74, 78, 96, 17, 15, 47, 12, 66, 17, 3, 84, 85, 107, 67, 83, Ascii.NAK, 17, Ascii.NAK}, "b89872"), (String) null, bundle);
            if (bundleCall != null) {
                ArrayList parcelableArrayList = bundleCall.getParcelableArrayList(ijiami_1011.s.s.s.d(new byte[]{73, 0, 80, 92, 5, 94, 4, 42, 7, 15, 84, Ascii.SYN}, "9a37d9"));
                if (b.a((Collection) parcelableArrayList)) {
                    Bundle bundle2 = (Bundle) parcelableArrayList.get(0);
                    String string = bundle2.getString(ijiami_1011.s.s.s.d(new byte[]{65, 0, 90, 90, 0, 1, 4, 42, 7, 15, 84}, "1a91af"));
                    if (TextUtils.equals(string, this.f5727a)) {
                        int i = bundle2.getInt(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 67, 81, 76, 67, SignedBytes.MAX_POWER_OF_TWO}, "d70863"));
                        m.b(str, string + ijiami_1011.s.s.s.d(new byte[]{91, 11, 94, Ascii.ETB, 70, 80, Ascii.NAK, 17, 3, 17, 12, 88, 91}, "f6cd21") + i);
                        return Boolean.valueOf(i == 1);
                    }
                }
            }
            return Boolean.FALSE;
        }
    }

    public static boolean a(Context context, MimoAdInfo mimoAdInfo) {
        boolean zC = mimoAdInfo.C();
        String str = mimoAdInfo.C;
        if (!zC) {
            return f9.b(context, str);
        }
        try {
            b = mimoAdInfo.j1;
            FutureTask futureTask = new FutureTask(new a(str, context));
            x8.i.execute(futureTask);
            try {
                return ((Boolean) futureTask.get(b, TimeUnit.MILLISECONDS)).booleanValue();
            } catch (Exception e) {
                m.b(f5726a, ijiami_1011.s.s.s.d(new byte[]{15, 66, 117, 66, Ascii.SYN, 43, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 3, 85}, "f142fb"), e);
                if (!futureTask.isDone() && !futureTask.isCancelled()) {
                    futureTask.cancel(true);
                }
                return false;
            }
        } catch (Exception e2) {
            m.b(f5726a, ijiami_1011.s.s.s.d(new byte[]{91, 16, 120, Ascii.DC2, Ascii.DC4, 112, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 87, 7}, "2c9bd9"), e2);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r0 != 0) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a() {
        Context context = y8.f5752a;
        if (context != null && r6.a(context, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 65, SignedBytes.MAX_POWER_OF_TWO, 12, Ascii.DC4, Ascii.NAK, 53, 19, 11, 82, 14, 116, 0, 92, 85, 39, 15, 19, 1, 5, Ascii.SYN, 124, 4, 90, 13}, "3a10cf"))) {
            int i = c;
            if (i == -2) {
                int iBooleanValue = 14;
                iBooleanValue = 14;
                iBooleanValue = 14;
                try {
                    FutureTask futureTask = new FutureTask(new x6());
                    x8.i.execute(futureTask);
                    try {
                        iBooleanValue = ((Boolean) futureTask.get(b, TimeUnit.MILLISECONDS)).booleanValue();
                        iBooleanValue = iBooleanValue;
                    } catch (Exception e) {
                        m.b(f5726a, ijiami_1011.s.s.s.d(new byte[]{80, 75, 32, 71, Ascii.DC4, 47, 15, Ascii.ETB, Ascii.DC2, 3, 93, 9, 92, 92}, "98a7df"), e);
                    }
                } catch (Exception e2) {
                    byte[] bArr = new byte[iBooleanValue];
                    // fill-array-data instruction
                    bArr[0] = 15;
                    bArr[1] = 75;
                    bArr[2] = 116;
                    bArr[3] = 73;
                    bArr[4] = 22;
                    bArr[5] = 123;
                    bArr[6] = 15;
                    bArr[7] = 23;
                    bArr[8] = 18;
                    bArr[9] = 3;
                    bArr[10] = 93;
                    bArr[11] = 9;
                    bArr[12] = 3;
                    bArr[13] = 92;
                    m.b(f5726a, ijiami_1011.s.s.s.d(bArr, "f859f2"), e2);
                }
            } else if (i == 0) {
                return true;
            }
        }
        return false;
        return false;
    }
}
