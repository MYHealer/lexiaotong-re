package com.miui.zeus.mimo.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.feedback.DislikeManagerV2;
import com.xiaomi.ad.feedback.IAdFeedbackService;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a9<T, S extends IInterface> extends FutureTask<T> implements ServiceConnection {
    public static final Map<Class, IInterface> f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5284a;
    public T b;
    public S c;
    public Class<S> d;
    public long e;

    public class a implements Callable<T> {
        @Override // java.util.concurrent.Callable
        public T call() {
            throw new IllegalStateException(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 94, 88, 68, Ascii.CAN, Ascii.ETB, 9, 11, 19, 14, 85, 69, 13, 83, 71, 82, 74, 68, 3, 1, 70, 1, 80, 9, 15, 83, 85}, "c6178d"));
        }
    }

    public class b extends g9 {
        public final /* synthetic */ IBinder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, IBinder iBinder) {
            super(str, str2);
            this.c = iBinder;
        }

        @Override // com.miui.zeus.mimo.sdk.g9
        public void a() {
            if (a9.a(a9.this, this.c)) {
                a9 a9Var = a9.this;
                a9.a(a9Var, (IInterface) a9Var.c);
                a9Var.b = null;
                a9 a9Var2 = a9.this;
                a9Var2.set(a9Var2.b);
                a9 a9Var3 = a9.this;
                a9Var3.getClass();
                new b9(a9Var3, ijiami_1011.s.s.s.d(new byte[]{97, 7, 92, 12, Ascii.DC2, 85, 44, 1, Ascii.DC2, 10, 94, 1, 122, 12, 71, 12, 13, 85, 19}, "3b1cf0"), ijiami_1011.s.s.s.d(new byte[]{96, 8, 81, 15, 93, 0, 65, Ascii.ETB, 3, 16, 71, 12, 86, 3, 19, 3, 75, 7, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11}, "5f3f3d")).run();
            }
        }
    }

    public a9(Context context, Class<S> cls) {
        super(new a());
        this.f5284a = context;
        this.d = cls;
        m.d(ijiami_1011.s.s.s.d(new byte[]{99, 93, 89, 95, 67, 1, 44, 1, Ascii.DC2, 10, 94, 1, 120, 86, 66, 95, 92, 1, 19}, "18407d"), ijiami_1011.s.s.s.d(new byte[]{49, 127, 125, 70, 12, 80, 65}, "c24fc6") + this.d.getPackage().toString() + this.d);
    }

    public static boolean a(a9 a9Var, IBinder iBinder) {
        a9Var.getClass();
        try {
            m.d(ijiami_1011.s.s.s.d(new byte[]{49, 86, 12, 86, 70, 87, 44, 1, Ascii.DC2, 10, 94, 1, 42, 93, Ascii.ETB, 86, 89, 87, 19}, "c3a922"), a9Var.d.getCanonicalName());
            a9Var.c = (S) Class.forName(a9Var.d.getCanonicalName() + ijiami_1011.s.s.s.d(new byte[]{19, 99, 16, Ascii.SYN, 1}, "70dcc3")).getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{4, SignedBytes.MAX_POWER_OF_TWO, 126, 95, 17, 87, 19, 2, 7, 1, 84}, "e371e2"), IBinder.class).invoke(null, iBinder);
            m.d(ijiami_1011.s.s.s.d(new byte[]{96, 87, 85, 13, 70, 7, 44, 1, Ascii.DC2, 10, 94, 1, 123, 92, 78, 13, 89, 7, 19}, "228b2b"), ijiami_1011.s.s.s.d(new byte[]{97, 3, Ascii.ETB, Ascii.NAK, 13, 5, 4, Utf8.REPLACEMENT_BYTE}, "2fecdf") + a9Var.d + ijiami_1011.s.s.s.d(new byte[]{72, 67}, "dcca30") + iBinder + ijiami_1011.s.s.s.d(new byte[]{107, 69, 84, 88, 93, 11, 4, 7, Ascii.DC2, 7, 85, 68}, "6e773e"));
            return true;
        } catch (Exception e) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{97, 81, 88, 89, Ascii.SYN, 0, 44, 1, Ascii.DC2, 10, 94, 1, 122, 90, 67, 89, 9, 0, 19}, "3456be"), ijiami_1011.s.s.s.d(new byte[]{37, 83, 67, 69, Ascii.ETB, 1, 8, 10, 2, 7, 67, 69, 3, 74, 83, 84, 71, Ascii.ETB, 8, 11, 8, 66}, "f2017c") + a9Var.d, e);
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x8.i.execute(new b(ijiami_1011.s.s.s.d(new byte[]{52, 3, 12, 87, 67, 82, 44, 1, Ascii.DC2, 10, 94, 1, 47, 8, Ascii.ETB, 87, 92, 82, 19}, "ffa877"), ijiami_1011.s.s.s.d(new byte[]{89, 8, 50, 4, 66, 71, 8, 7, 3, 33, 94, 11, 88, 3, 2, Ascii.NAK, 85, 85, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 66, 15, 14, 15}, "6faa01"), iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public static Object a(a9 a9Var, IInterface iInterface) {
        a9Var.getClass();
        try {
            DislikeManagerV2.a aVar = (DislikeManagerV2.a) a9Var;
            try {
                ((IAdFeedbackService) iInterface).showFeedbackWindowAndTrackResult(aVar.g, aVar.h, aVar.i, aVar.j);
            } catch (Exception e) {
                Log.e(ijiami_1011.s.s.s.d(new byte[]{38, 13, 71, 85, 89, 14, 4, 41, 7, 12, 80, 2, 7, Ascii.SYN, 98, 11}, "bd490e"), ijiami_1011.s.s.s.d(new byte[]{67, 90, 94, 67, 117, 89, Ascii.DC2, 8, 15, 9, 84, 50, 89, 92, 85, 91, 70, 67, 91, 68}, "021410"), e);
            }
        } catch (Exception e2) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{98, 7, 92, 92, Ascii.NAK, 3, 44, 1, Ascii.DC2, 10, 94, 1, 121, 12, 71, 92, 10, 3, 19}, "0b13af"), ijiami_1011.s.s.s.d(new byte[]{91, 11, 66, 91, 91, 93, 40, 10, Ascii.DC2, 7, 67, 11, 83, 9, Ascii.DC4, 113, 72, 91, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11, Ascii.DC2}, "2e4408") + a9Var.d, e2);
        }
        m.d(ijiami_1011.s.s.s.d(new byte[]{97, 6, 93, 86, 70, 86, 44, 1, Ascii.DC2, 10, 94, 1, 122, 13, 70, 86, 89, 86, 19}, "3c0923"), ijiami_1011.s.s.s.d(new byte[]{Base64.padSymbol, 103, 126, 121, 121, 94, 15, 13, Ascii.DC2, 13, 67, 56, 70}, "f53041") + a9Var.d + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 71, 80, 90, 93, Ascii.SYN, 65}, "83118e") + (System.currentTimeMillis() - a9Var.e) + ijiami_1011.s.s.s.d(new byte[]{93, Ascii.DC2}, "0a70f3"));
        return null;
    }
}
