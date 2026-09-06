package com.xiaomi.onetrack.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.b.n;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9396a = s.d(new byte[]{36, 6, 120, 93, 89, 13, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 10, 3, 81, 102, 94, 9, 4, Ascii.SYN}, "eb527d");
    private static volatile b b;
    private a c;

    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, long j) {
            removeMessages(i);
            p.a(s.d(new byte[]{113, 7, 43, 89, 10, 94, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 95, 2, 2, 98, 13, 90, 4, Ascii.SYN}, "0cf6d7"), s.d(new byte[]{70, 94, 13, 91, Ascii.SYN, 65, 14, Ascii.ETB, Ascii.DC2, 66, 92, Ascii.SYN, 86, Ascii.ESC, 65, 71, 68, 88, 14, 89}, "17a761") + i + s.d(new byte[]{77, 69, 93, 6, 9, 2, Ascii.CAN, 89}, "ae9cec") + j);
            sendEmptyMessageDelayed(i, j);
        }

        public void a(int i) {
            if (hasMessages(i)) {
                p.a(s.d(new byte[]{120, 5, 125, 12, 95, 81, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 86, 0, 84, 55, 88, 85, 4, Ascii.SYN}, "9a0c18"), s.d(new byte[]{93, 84, Ascii.DC2, 17, 85, 7, Ascii.DC2, Ascii.ETB, 7, 5, 84, -122, -75, -75, 17, 67, 81, 13, 92}, "55a18b") + i);
            } else {
                long jA = n.a(i);
                p.a(s.d(new byte[]{36, 7, 47, 92, 94, 93, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 10, 2, 6, 103, 89, 89, 4, Ascii.SYN}, "ecb304"), s.d(new byte[]{Ascii.NAK, 80, 92, 85, Ascii.EM, 82, 9, 1, 5, 9, 17, Ascii.NAK, 16, 80, 95, 4}, "b90991") + i + s.d(new byte[]{72, 70, 84, 80, 89, 7, Ascii.CAN, 89}, "df055f") + jA);
                a(i, jA);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            p.a(s.d(new byte[]{39, 82, 46, 12, 8, 95, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 9, 87, 7, 55, 15, 91, 4, Ascii.SYN}, "f6ccf6"), s.d(new byte[]{115, 82, 41, 93, 92, 12, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 93, 87, 0, 102, 91, 8, 4, Ascii.SYN, 72, 10, 80, 11, 86, 90, 1, 127, 87, Ascii.SYN, Ascii.DC2, 5, 1, 7, Ascii.GS, 69, 95, 69, 3, Ascii.FS, 69, 13, 0, 16, 91}, "26d22e") + message.what);
            c.a();
        }
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread(s.d(new byte[]{86, 89, 84, 67, 19, 80, 2, 15, 57, 3, 85, 58, 84, 88, 95, 94, Ascii.NAK, 94, 19, 59, 19, Ascii.DC2, 93, 10, 88, 83, 84, 69}, "9717a1"));
        handlerThread.start();
        this.c = new a(handlerThread.getLooper());
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public void a(boolean z) {
        a aVar;
        if (!z || (aVar = this.c) == null) {
            return;
        }
        aVar.a(0, 1000L);
    }

    public void b() {
        this.c.a(0);
    }
}
