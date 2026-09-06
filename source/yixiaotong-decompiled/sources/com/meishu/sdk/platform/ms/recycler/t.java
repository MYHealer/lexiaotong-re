package com.meishu.sdk.platform.ms.recycler;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.meishu.sdk.core.view.TouchPoint;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: SlideEventRecord.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5230a;
    public static float b;
    public static float c;
    public static float d;
    public static float e;
    public static int f;
    public static long g;
    public static SoftReference<a> h;

    /* JADX INFO: compiled from: SlideEventRecord.java */
    public interface a {
        void a(float f, float f2, long j, float f3, float f4, float f5, int i);
    }

    public static void a() {
        f5230a = null;
        b = 0.0f;
        c = 0.0f;
        d = 0.0f;
        e = 0.0f;
        f = 0;
        g = 0L;
    }

    public static void a(String str, MotionEvent motionEvent, a aVar) {
        if (TextUtils.isEmpty(str) || motionEvent.getAction() != 0) {
            return;
        }
        f5230a = str;
        h = new SoftReference<>(aVar);
        b = motionEvent.getX();
        c = motionEvent.getY();
        d = motionEvent.getRawX();
        e = motionEvent.getRawY();
        f = 0;
        g = System.currentTimeMillis();
    }

    public static TouchPoint a(String str, MotionEvent motionEvent, float f2, int i) {
        if (b > 0.0f && c > 0.0f) {
            try {
                if (TextUtils.isEmpty(str) || !str.equals(f5230a)) {
                    try {
                        SoftReference<a> softReference = h;
                        if (softReference != null && softReference.get() != null) {
                            h.get().a(b, c, g, motionEvent.getX(), motionEvent.getY(), f2, i);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    a();
                    return null;
                }
                TouchPoint touchPoint = new TouchPoint(b, c, g, motionEvent.getX(), motionEvent.getY(), System.currentTimeMillis());
                a();
                return touchPoint;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    return new TouchPoint(b, c, g, motionEvent.getX(), motionEvent.getY(), System.currentTimeMillis());
                } finally {
                    a();
                }
            }
        }
        a();
        return null;
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str) || !str.equals(f5230a)) {
            return;
        }
        f = i;
    }
}
