package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.util.Log;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: DecodeMultiCodes.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4252a = true;
    private static boolean b;
    private static boolean c;
    private static int d;
    private static LinkedList<y1> e = new LinkedList<>();
    private static LinkedList<h5> f = new LinkedList<>();
    private static LinkedList<h5> g = new LinkedList<>();
    private static boolean h;
    private static boolean i;
    private static long j;

    static {
        h = !b3.f4215a || b3.c;
        i = false;
        if (DynamicModuleInitializer.getContext() == null) {
            Log.e("ScankitDecode", "static initializer: context null");
            return;
        }
        Log.i("ScankitDecode", "static initializer: InitModuleBegin");
        g4.c(DynamicModuleInitializer.getContext(), "detect.ms");
        g4.a(DynamicModuleInitializer.getContext(), "angle.ms");
        g4.b(DynamicModuleInitializer.getContext(), "corner.ms");
        Log.i("ScankitDecode", "static initializer: InitModuleEnd");
    }

    public static w5 a(List<BarcodeFormat> list, h1 h1Var) {
        if (list.size() > 0) {
            return h1Var.d(list, null);
        }
        return null;
    }

    public static w5[] b(Bitmap bitmap, b6 b6Var) {
        byte[] bArrB;
        try {
            b6Var.f4217a = bitmap.getWidth();
            int height = bitmap.getHeight();
            b6Var.b = height;
            int i2 = b6Var.f4217a;
            int[] iArr = new int[i2 * height];
            bitmap.getPixels(iArr, 0, i2, 0, 0, i2, height);
            bArrB = new q5(b6Var.f4217a, b6Var.b, iArr).b();
        } catch (IllegalArgumentException unused) {
            x3.b("exception", "IllegalArgumentException");
            bArrB = null;
        } catch (Exception unused2) {
            x3.b("exception", "Exception");
            bArrB = null;
        } catch (OutOfMemoryError unused3) {
            x3.b("exception", "OutOfMemoryError");
            bArrB = null;
        } catch (UnsatisfiedLinkError unused4) {
            x3.b("exception", "UnsatisfiedLinkError");
            bArrB = null;
        } catch (UnsupportedOperationException unused5) {
            x3.b("exception", "UnsupportedArgumentException");
            bArrB = null;
        }
        return c(bArrB, b6Var);
    }

    public static w5[] a(Bitmap bitmap, b6 b6Var) {
        byte[] bArrB;
        try {
            b6Var.f4217a = bitmap.getWidth();
            int height = bitmap.getHeight();
            b6Var.b = height;
            int i2 = b6Var.f4217a;
            int[] iArr = new int[i2 * height];
            bitmap.getPixels(iArr, 0, i2, 0, 0, i2, height);
            bArrB = new q5(b6Var.f4217a, b6Var.b, iArr).b();
        } catch (IllegalArgumentException unused) {
            x3.b("exception", "IllegalArgumentException");
            bArrB = null;
        } catch (Exception unused2) {
            x3.b("exception", "Exception");
            bArrB = null;
        } catch (OutOfMemoryError unused3) {
            x3.b("exception", "OutOfMemoryError");
            bArrB = null;
        } catch (UnsatisfiedLinkError unused4) {
            x3.b("exception", "UnsatisfiedLinkError");
            bArrB = null;
        } catch (UnsupportedOperationException unused5) {
            x3.b("exception", "UnsupportedArgumentException");
            bArrB = null;
        }
        return b(bArrB, b6Var);
    }

    public static w5[] c(byte[] bArr, b6 b6Var) {
        w5[] w5VarArr = new w5[0];
        try {
            return a(bArr, b6Var, true);
        } catch (IllegalArgumentException unused) {
            x3.b("exception", "IllegalArgumentException");
            return w5VarArr;
        } catch (Exception unused2) {
            x3.b("exception", "Exception");
            return w5VarArr;
        } catch (OutOfMemoryError unused3) {
            x3.b("exception", "OutOfMemoryError");
            return w5VarArr;
        } catch (UnsatisfiedLinkError unused4) {
            x3.b("exception", "UnsatisfiedLinkError");
            return w5VarArr;
        } catch (UnsupportedOperationException unused5) {
            x3.b("exception", "UnsupportedArgumentException");
            return w5VarArr;
        }
    }

    public static w5[] b(y3 y3Var, b6 b6Var) {
        w5 w5VarB;
        boolean zB;
        w5 w5Var;
        x3.c("ScankitDecode", "scankit mode:FULLSDK20900300 VERSION_NAME: 2.9.0.300");
        b3.a(b6Var);
        List<y1> arrayList = new ArrayList<>();
        if (b6Var.f4217a >= 30 && b6Var.b >= 30 && y3Var != null) {
            List<List<BarcodeFormat>> listA = x2.a(b6Var.c);
            List<BarcodeFormat> list = listA.get(0);
            List<BarcodeFormat> list2 = listA.get(1);
            List<BarcodeFormat> list3 = listA.get(2);
            List<BarcodeFormat> list4 = listA.get(3);
            List<BarcodeFormat> list5 = listA.get(4);
            h1 h1Var = new h1(y3Var);
            w5 w5VarA = null;
            if (!f4252a || c) {
                w5VarB = null;
            } else {
                w5VarB = a(list, h1Var);
                i = false;
                j = System.currentTimeMillis();
            }
            if (a(w5VarB)) {
                arrayList = h1Var.a(0, b3.m);
            }
            if (arrayList.size() > 0) {
                w5VarB = b(arrayList, h1Var, listA);
                i = true;
            } else if (b3.c || !b3.f4215a || b3.b) {
                if (a(w5VarB) && list3.size() > 0) {
                    w5VarB = h1Var.c(list3, null);
                }
                if (a(w5VarB) && list2.size() > 0 && h) {
                    w5VarB = h1Var.a(list2, (y1) null);
                }
                if (a(w5VarB) && list5.size() > 0) {
                    w5VarB = h1Var.b(list5, null);
                }
                if (a(w5VarB) && list4.size() > 0) {
                    w5VarB = h1Var.b(list4, null);
                }
            }
            boolean z = (f4252a || !b || c) ? false : true;
            if (b6Var.e && a(w5VarB) && z) {
                w5VarB = a(list, h1Var);
                b = false;
            }
            float fMax = 1.0f;
            if (b3.c) {
                zB = false;
                w5Var = null;
            } else {
                zB = h1Var.b();
                int i2 = b3.g - 1;
                if (i2 <= 0) {
                    i2 = 0;
                }
                b3.g = i2;
                if (arrayList.size() > 0) {
                    zB = zB || h1Var.b(arrayList);
                }
                if (zB && h1Var.c(h1Var.a()) < 20.0f) {
                    zB = false;
                }
                if (h1Var.e() > 0.0f) {
                    fMax = Math.max(1.0f, h1Var.e());
                } else {
                    fMax = Math.max(1.0f, Math.max(h1Var.c(), h1Var.d()));
                }
                w5 w5VarA2 = h1.a(arrayList, h1Var);
                w5VarA = h1.a(h1Var);
                w5Var = w5VarA2;
            }
            if (w5VarA == null || w5VarA.h() != -2) {
                d = 0;
            } else {
                d++;
            }
            if (w5VarB != null && w5VarB.k() != null) {
                x3.c("ScankitDecode", "ScanCode successful");
                d = 0;
                w5VarB.b(j);
                w5VarB.a(System.currentTimeMillis());
                w5VarB.a(i);
                return new w5[]{w5VarB};
            }
            if (zB) {
                x3.c("ScankitDecode", "ScanCode need zoom");
                w5 w5Var2 = new w5(fMax);
                w5Var2.c(true);
                d = 0;
                return new w5[]{w5Var2};
            }
            if (arrayList.size() > 0 && w5Var != null) {
                x3.c("ScankitDecode", "ScanCode need exposure");
                d = 0;
                return new w5[]{w5Var};
            }
            if (w5VarA != null && d == 3) {
                w5VarA.b(true);
                w5VarA.a(-1);
                x3.c("ScankitDecode", "ScanCode need globalexposure");
                d = 0;
                return new w5[]{w5VarA};
            }
            x3.c("ScankitDecode", "ScanCode null");
            return new w5[0];
        }
        throw new IllegalArgumentException("widthOrHeight is Illeagle");
    }

    public static w5[] a(ByteBuffer byteBuffer, b6 b6Var) {
        return b(byteBuffer.array(), b6Var);
    }

    public static w5[] a(y3 y3Var, b6 b6Var) {
        w5 w5VarA;
        List arrayList = new ArrayList();
        b3.a(b6Var);
        b3.a(1);
        if (b6Var.f4217a >= 30 && b6Var.b >= 30 && y3Var != null) {
            List<List<BarcodeFormat>> listA = x2.a(b6Var.c);
            List<BarcodeFormat> list = listA.get(0);
            List<BarcodeFormat> list2 = listA.get(1);
            List<BarcodeFormat> list3 = listA.get(2);
            List<BarcodeFormat> list4 = listA.get(3);
            h1 h1Var = new h1(y3Var);
            List<y1> listA2 = h1Var.a(1, b3.m);
            if (listA2.size() > 0) {
                arrayList = a(listA2, h1Var, listA);
            } else if ((b3.c || !b3.f4215a) && (w5VarA = a(h1Var, list, list2, list3, list4)) != null && w5VarA.k() != null) {
                arrayList.add(w5VarA);
            }
            List<w5> listA3 = x6.a(arrayList);
            return listA3.size() > 0 ? (w5[]) listA3.toArray(new w5[0]) : new w5[0];
        }
        throw new IllegalArgumentException("width or Height is Illeagle");
    }

    private static w5 a(h1 h1Var, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        w5 w5VarE = list.size() > 0 ? h1Var.e(list, null) : null;
        if (a(w5VarE) && list3.size() > 0) {
            w5VarE = h1Var.c(list3, null);
        }
        if (a(w5VarE) && list2.size() > 0 && h) {
            w5VarE = h1Var.a(list2, (y1) null);
        }
        return (!a(w5VarE) || list4.size() <= 0) ? w5VarE : h1Var.b(list4, null);
    }

    public static List<w5> a(List<y1> list, h1 h1Var, List<List<BarcodeFormat>> list2) {
        w5 w5VarF;
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            w5 w5VarA = null;
            if (i2 >= list.size()) {
                break;
            }
            h1Var.i.a();
            y1 y1Var = list.get(i2);
            boolean z = y1Var.g() == 5.0f;
            boolean z2 = y1Var.g() == 1.0f;
            boolean z3 = y1Var.g() == 3.0f;
            boolean z4 = y1Var.g() == 2.0f;
            boolean z5 = y1Var.g() == 4.0f;
            if (b3.b) {
                z = y1Var.g() == 1.0f;
                z2 = y1Var.g() == 2.0f;
                z3 = y1Var.g() == 2.0f;
                z5 = y1Var.g() == 1.0f;
                z4 = y1Var.g() == 2.0f;
            }
            h1Var.a(y1Var);
            if (a((w5) null) && list3.size() > 0 && z2) {
                w5VarA = h1Var.d(list3, y1Var);
            }
            if (a(w5VarA) && list6.size() > 0 && z3) {
                w5VarA = h1Var.b(list6, y1Var);
            }
            if (a(w5VarA) && list5.size() > 0 && z5) {
                w5VarA = h1Var.c(list5, y1Var);
            }
            if (a(w5VarA) && list7.size() > 0 && z4) {
                w5VarA = h1Var.b(list7, y1Var);
            }
            if (a(w5VarA) && list4.size() > 0 && z) {
                w5VarA = h1Var.a(list4, y1Var);
            }
            if (w5VarA != null && w5VarA.k() != null) {
                arrayList.add(w5VarA);
            }
            i2++;
        }
        if (arrayList.size() == 0 && list3.size() > 0 && (w5VarF = h1Var.f(list3, null)) != null && w5VarF.k() != null) {
            arrayList.add(w5VarF);
        }
        return arrayList;
    }

    private static y3 a(byte[] bArr, b6 b6Var) {
        int i2 = b6Var.f4217a;
        int i3 = b6Var.b;
        if (b6Var.d) {
            byte[] bArr2 = new byte[i2 * i3];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
                }
            }
            b6Var.f4217a = i3;
            b6Var.b = i2;
            return new j5(bArr2, i3, i2, 0, 0, i3, i2, false);
        }
        return new j5(bArr, i2, i3, 0, 0, i2, i3, false);
    }

    public static w5 b(List<y1> list, h1 h1Var, List<List<BarcodeFormat>> list2) {
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        w5 w5VarA = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 > 0) {
                h1Var.i.a();
            }
            y1 y1Var = list.get(i2);
            boolean z = y1Var.g() == 5.0f;
            boolean z2 = y1Var.g() == 1.0f;
            boolean z3 = y1Var.g() == 2.0f;
            boolean z4 = y1Var.g() == 3.0f;
            boolean z5 = y1Var.g() == 4.0f;
            if (b3.b) {
                z = y1Var.g() == 1.0f;
                z2 = y1Var.g() == 2.0f;
                z3 = y1Var.g() == 2.0f;
                z4 = y1Var.g() == 2.0f;
                z5 = y1Var.g() == 1.0f;
            }
            h1Var.a(y1Var);
            if (a(w5VarA) && list3.size() > 0 && z2) {
                b = true;
                w5VarA = h1Var.d(list3, y1Var);
            }
            if (a(w5VarA) && list6.size() > 0 && z4) {
                w5VarA = h1Var.b(list6, y1Var);
            }
            if (a(w5VarA) && list7.size() > 0 && z3) {
                w5VarA = h1Var.b(list7, y1Var);
            }
            if (a(w5VarA) && list5.size() > 0 && z5) {
                w5VarA = h1Var.c(list5, y1Var);
            }
            if (a(w5VarA) && list4.size() > 0 && z) {
                w5VarA = h1Var.a(list4, y1Var);
            }
            if (w5VarA != null && w5VarA.k() != null) {
                break;
            }
        }
        return w5VarA;
    }

    public static void a(boolean z) {
        b3.f4215a = z;
    }

    private static void a() {
        c = false;
        e = new LinkedList<>();
        f = new LinkedList<>();
        g = new LinkedList<>();
    }

    public static w5[] a(byte[] bArr, b6 b6Var, boolean z) {
        int i2;
        int i3;
        LinkedList linkedList = new LinkedList();
        a();
        int iMin = Math.min(b6Var.f4217a, b6Var.b);
        float f2 = iMin;
        float fMax = Math.max(b6Var.f4217a, b6Var.b) / f2;
        int i4 = (int) (f2 * 1.78f);
        y3 y3VarA = a(bArr, b6Var);
        b6 b6Var2 = new b6(b6Var);
        if (iMin > 500 && b6Var.f4217a >= b6Var.b && b6Var.e && fMax > 3.0f) {
            c = true;
            b6Var2.f4217a = i4;
            int i5 = b6Var.f4217a - 1;
            while (i5 >= 0) {
                i5 -= i4;
                int i6 = i5 >= 0 ? i5 : 0;
                b6Var2.h = i6;
                b6Var2.i = 0;
                a(y3VarA, i6, 0, b6Var2);
            }
            Collections.sort(e);
            w5 w5VarA = a(y3VarA, b6Var2, linkedList, z, true, i4);
            if (w5VarA != null) {
                return new w5[]{w5VarA};
            }
            e = new LinkedList<>();
            Collections.sort(f);
            HashSet hashSet = new HashSet();
            for (h5 h5Var : f) {
                if (hashSet.add(Integer.valueOf(h5Var.b)) && (i3 = h5Var.b) >= i4 && i3 <= (b6Var.f4217a - 1) - i4) {
                    b6Var2.f4217a = i4;
                    b6Var2.j = true;
                    int i7 = i3 - (i4 / 2);
                    b6Var2.h = i7;
                    b6Var2.i = 0;
                    a(y3VarA, i7, 0, b6Var2);
                }
            }
            Collections.sort(e);
            w5 w5VarA2 = a(y3VarA, b6Var2, linkedList, z, true, i4);
            if (w5VarA2 != null) {
                return new w5[]{w5VarA2};
            }
        } else {
            if (iMin <= 500 || !b6Var.e || fMax <= 3.0f) {
                c = false;
                if (z) {
                    return b(y3VarA, b6Var);
                }
                return a(y3VarA, b6Var);
            }
            c = true;
            b6Var2.b = i4;
            int i8 = b6Var.b - 1;
            while (i8 >= 0) {
                i8 -= i4;
                int i9 = i8 >= 0 ? i8 : 0;
                b6Var2.h = 0;
                b6Var2.i = i9;
                a(y3VarA, 0, i9, b6Var2);
            }
            Collections.sort(e);
            w5 w5VarA3 = a(y3VarA, b6Var, linkedList, z, false, i4);
            if (w5VarA3 != null) {
                return new w5[]{w5VarA3};
            }
            e = new LinkedList<>();
            Collections.sort(g);
            HashSet hashSet2 = new HashSet();
            for (h5 h5Var2 : g) {
                if (hashSet2.add(Integer.valueOf(h5Var2.b)) && (i2 = h5Var2.b) >= i4 && i2 <= (b6Var.b - 1) - i4) {
                    int i10 = i2 - (i4 / 2);
                    b6Var2.b = i4;
                    b6Var2.j = true;
                    b6Var2.h = 0;
                    b6Var2.i = i10;
                    a(y3VarA, 0, i10, b6Var2);
                }
            }
            Collections.sort(e);
            w5 w5VarA4 = a(y3VarA, b6Var, linkedList, z, false, i4);
            if (w5VarA4 != null) {
                return new w5[]{w5VarA4};
            }
        }
        w5[] w5VarArr = new w5[linkedList.size()];
        linkedList.toArray(w5VarArr);
        return w5VarArr;
    }

    public static w5[] b(byte[] bArr, b6 b6Var) {
        w5[] w5VarArr = new w5[0];
        try {
            w5[] w5VarArrA = a(bArr, b6Var, false);
            int length = w5VarArrA.length;
            int[] iArr = new int[length];
            int i2 = 0;
            int i3 = 0;
            while (i2 < w5VarArrA.length) {
                int i4 = i2 + 1;
                for (int i5 = i4; i5 < w5VarArrA.length; i5++) {
                    if (x6.a(w5VarArrA[i2].j(), w5VarArrA[i5].j()) > 0.7d) {
                        iArr[i5] = 1;
                        i3++;
                    }
                }
                i2 = i4;
            }
            int length2 = w5VarArrA.length - i3;
            w5VarArr = new w5[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = i6;
                while (i7 < length && iArr[i7] == 1) {
                    i7++;
                }
                w5VarArr[i6] = w5VarArrA[i7];
            }
        } catch (IllegalArgumentException unused) {
            x3.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            x3.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            x3.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            x3.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            x3.b("exception", "UnsupportedArgumentException");
        }
        return w5VarArr;
    }

    private static void a(y3 y3Var, int i2, int i3, b6 b6Var) {
        b3.a(b6Var);
        byte[] bArrB = y3Var.a(i2, i3, b6Var.f4217a, b6Var.b).b();
        int i4 = b6Var.f4217a;
        int i5 = b6Var.b;
        List<y1> listA = new h1(new j5(bArrB, i4, i5, 0, 0, i4, i5, false)).a(0, b3.m);
        if (!b6Var.j) {
            a(listA, b6Var);
        }
        for (y1 y1Var : listA) {
            y1Var.a(b6Var.h, b6Var.i);
            e.offer(y1Var);
        }
    }

    private static w5 a(y3 y3Var, b6 b6Var, LinkedList<w5> linkedList, boolean z, boolean z2, int i2) {
        h1 h1Var = new h1(y3Var);
        List<List<BarcodeFormat>> listA = x2.a(b6Var.c);
        if (z) {
            w5 w5VarB = b(e, h1Var, listA);
            if (w5VarB == null || w5VarB.k() == null) {
                return null;
            }
            return w5VarB;
        }
        Iterator<w5> it = a(e, h1Var, listA).iterator();
        while (it.hasNext()) {
            linkedList.offer(it.next());
        }
        return null;
    }

    private static void a(List<y1> list, b6 b6Var) {
        for (y1 y1Var : list) {
            if (y1Var.d() < b6Var.f4217a * 0.1f) {
                f.offer(new h5(y1Var, b6Var.h));
            } else {
                float fD = y1Var.d() + y1Var.f();
                int i2 = b6Var.f4217a;
                if (fD > i2 * 0.9f) {
                    f.offer(new h5(y1Var, b6Var.h + i2));
                }
            }
            if (y1Var.e() < b6Var.b * 0.1f) {
                g.offer(new h5(y1Var, b6Var.i));
            } else {
                float fE = y1Var.e() + y1Var.c();
                int i3 = b6Var.b;
                if (fE > i3 * 0.9f) {
                    g.offer(new h5(y1Var, b6Var.i + i3));
                }
            }
        }
    }

    private static boolean a(w5 w5Var) {
        return w5Var == null || w5Var.k() == null;
    }
}
