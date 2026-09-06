package com.miui.zeus.mimo.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.auth.aidl.ICheckIDService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class r9<T, S extends IInterface> extends FutureTask<T> implements ServiceConnection {
    public static final Map<Class, IInterface> f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5587a;
    public T b;
    public S c;
    public Class<S> d;
    public long e;

    public class a extends u9 {
        public final /* synthetic */ IBinder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, IBinder iBinder) {
            super(str, str2);
            this.c = iBinder;
        }

        @Override // com.miui.zeus.mimo.sdk.u9
        public void a() {
            if (r9.a(r9.this, this.c)) {
                r9 r9Var = r9.this;
                r9Var.b = (T) r9Var.a(r9Var.c);
                r9 r9Var2 = r9.this;
                r9Var2.set(r9Var2.b);
                r9 r9Var3 = r9.this;
                r9Var3.getClass();
                new s9(r9Var3, ijiami_1011.s.s.s.d(new byte[]{102, Ascii.CAN, 69, 71, 92, 11, 50, 0, 13, 79, 99, 0, 88, 14, 66, 86, 116, 3, Ascii.NAK, 12, 9, 6, 120, 11, 67, 14, 93, 86, 75}, "5a639f"), ijiami_1011.s.s.s.d(new byte[]{103, 93, 80, 88, 93, 93, 65, Ascii.ETB, 3, 16, 71, 12, 81, 86, Ascii.DC2, 84, 75, 90, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11}, "232139")).run();
            }
        }
    }

    public r9(Context context, Class<S> cls) {
        super(r9$$Lambda$1.instance);
        this.f5587a = context;
        this.d = cls;
        String str = ijiami_1011.s.s.s.d(new byte[]{101, 122, 40, 70, 95, 7, 65}, "77af0a") + this.d.getPackage().toString() + this.d;
    }

    public static /* synthetic */ Object a() {
        throw new IllegalStateException(ijiami_1011.s.s.s.d(new byte[]{17, 9, 94, 68, Ascii.NAK, 69, 9, 11, 19, 14, 85, 69, 11, 4, 65, 82, 71, Ascii.SYN, 3, 1, 70, 1, 80, 9, 9, 4, 83}, "ea7756"));
    }

    public static boolean a(r9 r9Var, IBinder iBinder) {
        r9Var.getClass();
        try {
            r9Var.d.getCanonicalName();
            r9Var.c = (S) Class.forName(r9Var.d.getCanonicalName() + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 50, Ascii.DC2, 65, 82}, "6af400")).getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{82, Ascii.NAK, 45, 13, 70, 82, 19, 2, 7, 1, 84}, "3fdc27"), IBinder.class).invoke(null, iBinder);
            String str = ijiami_1011.s.s.s.d(new byte[]{107, 80, 71, 67, 95, 87, 4, Utf8.REPLACEMENT_BYTE}, "855564") + r9Var.d + ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, Ascii.DC4}, "948ac4") + iBinder + ijiami_1011.s.s.s.d(new byte[]{62, 67, 80, 14, 86, 93, 4, 7, Ascii.DC2, 7, 85, 68}, "cc3a83");
            return true;
        } catch (Exception e) {
            q9.a(ijiami_1011.s.s.s.d(new byte[]{49, 77, 70, 17, 1, 88, 50, 0, 13, 79, 99, 0, 15, 91, 65, 0, 41, 80, Ascii.NAK, 12, 9, 6, 120, 11, Ascii.DC4, 91, 94, 0, Ascii.SYN}, "b45ed5"), ijiami_1011.s.s.s.d(new byte[]{37, 84, 66, 77, Ascii.CAN, 90, 8, 10, 2, 7, 67, 69, 3, 77, 82, 92, 72, 76, 8, 11, 8, 66}, "f51988") + r9Var.d, e);
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        t9.e.execute(new a(ijiami_1011.s.s.s.d(new byte[]{55, SignedBytes.MAX_POWER_OF_TWO, 67, 69, 80, 89, 50, 0, 13, 79, 99, 0, 9, 86, 68, 84, 120, 81, Ascii.NAK, 12, 9, 6, 120, 11, Ascii.DC2, 86, 91, 84, 71}, "d90154"), ijiami_1011.s.s.s.d(new byte[]{89, 88, 99, 81, Ascii.ETB, 67, 8, 7, 3, 33, 94, 11, 88, 83, 83, SignedBytes.MAX_POWER_OF_TWO, 0, 81, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 66, 95, 95, 90}, "6604e5"), iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public final T a(S s) {
        T t;
        try {
            f fVar = (f) this;
            ((ICheckIDService) s).checkID(fVar.g, fVar.h);
            t = (T) Boolean.TRUE;
        } catch (Exception e) {
            q9.a(ijiami_1011.s.s.s.d(new byte[]{102, Ascii.GS, 66, 71, 3, 11, 50, 0, 13, 79, 99, 0, 88, 11, 69, 86, 43, 3, Ascii.NAK, 12, 9, 6, 120, 11, 67, 11, 90, 86, Ascii.DC4}, "5d13ff"), ijiami_1011.s.s.s.d(new byte[]{8, 88, 68, 10, 9, 87, 40, 10, Ascii.DC2, 7, 67, 11, 0, 90, Ascii.DC2, 32, 26, 81, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11, 65}, "a62eb2") + this.d, e);
            t = null;
        }
        String str = ijiami_1011.s.s.s.d(new byte[]{Utf8.REPLACEMENT_BYTE, 98, 120, 124, 41, 93, 15, 13, Ascii.DC2, 13, 67, 56, 68}, "d055d2") + this.d + ijiami_1011.s.s.s.d(new byte[]{67, 77, 85, 90, 3, Ascii.ETB, 65}, "c941fd") + (System.currentTimeMillis() - this.e) + ijiami_1011.s.s.s.d(new byte[]{91, 65}, "62bbcd");
        return t;
    }
}
