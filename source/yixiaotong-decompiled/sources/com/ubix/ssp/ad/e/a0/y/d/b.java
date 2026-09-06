package com.ubix.ssp.ad.e.a0.y.d;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.u;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends Instrumentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Instrumentation f8736a;
    private Object b;
    final String c = new String(n.a().a("YW5kcm9pZC5hcHAuSW5zdHJ1bWVudGF0aW9u"));

    public b(Instrumentation instrumentation) {
        this.f8736a = instrumentation;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x026a A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x028a A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x028e A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x018e A[Catch: Exception -> 0x01f6, InvocationTargetException -> 0x02ab, TRY_LEAVE, TryCatch #3 {InvocationTargetException -> 0x02ab, blocks: (B:6:0x001d, B:11:0x0063, B:13:0x0075, B:15:0x0083, B:19:0x00a5, B:21:0x00b6, B:25:0x00c3, B:26:0x00c6, B:27:0x00d7, B:29:0x00e0, B:31:0x0111, B:32:0x0118, B:34:0x0126, B:35:0x012b, B:37:0x0130, B:41:0x013e, B:43:0x014a, B:44:0x014c, B:57:0x017a, B:59:0x018e, B:61:0x0194, B:63:0x0198, B:66:0x01a5, B:69:0x01ac, B:47:0x0153, B:49:0x015f, B:51:0x0167, B:71:0x01b2, B:73:0x01c0, B:75:0x01e0, B:9:0x0044), top: B:117:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0198 A[Catch: Exception -> 0x01a9, InvocationTargetException -> 0x02ab, TryCatch #1 {Exception -> 0x01a9, blocks: (B:61:0x0194, B:63:0x0198, B:66:0x01a5, B:69:0x01ac), top: B:119:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a5 A[Catch: Exception -> 0x01a9, InvocationTargetException -> 0x02ab, TryCatch #1 {Exception -> 0x01a9, blocks: (B:61:0x0194, B:63:0x0198, B:66:0x01a5, B:69:0x01ac), top: B:119:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x020b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0210  */
    /* JADX WARN: Code duplicated, block: B:93:0x022c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x022e A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x024e A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0264 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x0266 A[Catch: Exception -> 0x02a4, TryCatch #5 {Exception -> 0x02a4, blocks: (B:91:0x0214, B:94:0x022e, B:96:0x024e, B:99:0x0266, B:101:0x026a, B:102:0x026c, B:104:0x028a, B:106:0x028e, B:107:0x0290), top: B:124:0x0214 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    private Instrumentation.ActivityResult a(boolean z, Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent[] intentArr, int i, Bundle bundle) {
        ?? r6;
        ?? r15;
        boolean zB;
        Object obj;
        Object obj2;
        ?? r7;
        String dataString;
        Intent intent;
        a aVarB = d.e().b();
        char c = 1;
        try {
            try {
                Method declaredMethod = !z ? Instrumentation.class.getDeclaredMethod(Val.EXEC, Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class) : Instrumentation.class.getDeclaredMethod("execStartActivities", Context.class, IBinder.class, IBinder.class, Activity.class, Intent[].class, Bundle.class);
                try {
                    declaredMethod.setAccessible(true);
                    u.e("guard", "exec in");
                    try {
                        try {
                            if (d.e().b() != null) {
                                Method method = declaredMethod;
                                c = 1;
                                if (aVarB != null) {
                                    aVarB.a();
                                }
                                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                                StringBuilder sb = new StringBuilder();
                                boolean z2 = false;
                                for (int i2 = 0; i2 < Math.min(stackTrace.length, 20); i2++) {
                                    if ((stackTrace[i2].getClassName() + "." + stackTrace[i2].getMethodName()).equals(d.e().i())) {
                                        u.e("guard", "exec has self stack");
                                        z2 = true;
                                    }
                                    sb.append(stackTrace[i2]);
                                    if (i2 != Math.min(stackTrace.length, 20) - 1) {
                                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                                    }
                                }
                                if (!z2 || !d.e().l()) {
                                    u.e("guard", "exec no self stack or not deeplink");
                                    d.e().a();
                                    if (!z) {
                                        return (Instrumentation.ActivityResult) method.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr[0], Integer.valueOf(i), bundle);
                                    }
                                    method.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr, bundle);
                                    return null;
                                }
                                if (!"android.intent.action.VIEW".equals(intentArr[0].getAction())) {
                                    if ("android.intent.action.CHOOSER".equals(intentArr[0].getAction())) {
                                        Bundle extras = intentArr[0].getExtras();
                                        if (extras != null) {
                                            intent = (Intent) extras.get("android.intent.extra.INTENT");
                                            if (intent == null) {
                                                dataString = "unknown intent";
                                            }
                                        } else {
                                            dataString = "unknown bundle";
                                        }
                                    } else {
                                        dataString = "not supported action";
                                    }
                                    d.e().c(dataString);
                                    d.e().b(sb.toString());
                                    if (aVarB != null) {
                                        zB = aVarB.b();
                                        if (zB) {
                                            try {
                                                if (this.b == null) {
                                                    this.b = findTarget(this.f8736a);
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                r7 = method;
                                                if (u.a()) {
                                                    e.printStackTrace();
                                                }
                                                if (aVarB != null) {
                                                    aVarB.c();
                                                }
                                                r15 = r7;
                                            }
                                        }
                                    } else {
                                        zB = false;
                                    }
                                    if (aVarB != null) {
                                        aVarB.a(dataString);
                                    }
                                    u.e("guard", "exec out");
                                    r15 = method;
                                    u.e("guard", "invoke def, deepSeek=" + zB);
                                    if (!zB) {
                                        if (z) {
                                            r15.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr, bundle);
                                            return null;
                                        }
                                        Instrumentation instrumentation = this.f8736a;
                                        Object[] objArr = new Object[7];
                                        objArr[0] = context;
                                        objArr[c] = iBinder;
                                        objArr[2] = iBinder2;
                                        objArr[3] = activity;
                                        objArr[4] = intentArr[0];
                                        objArr[5] = Integer.valueOf(i);
                                        objArr[6] = bundle;
                                        return (Instrumentation.ActivityResult) r15.invoke(instrumentation, objArr);
                                    }
                                    if (z) {
                                        obj = this.b;
                                        if (obj == null) {
                                            obj = this.f8736a;
                                        }
                                        r15.invoke(obj, context, iBinder, iBinder2, activity, intentArr, bundle);
                                        return null;
                                    }
                                    obj2 = this.b;
                                    if (obj2 == null) {
                                        obj2 = this.f8736a;
                                    }
                                    Object[] objArr2 = new Object[7];
                                    objArr2[0] = context;
                                    objArr2[c] = iBinder;
                                    objArr2[2] = iBinder2;
                                    objArr2[3] = activity;
                                    objArr2[4] = intentArr[0];
                                    objArr2[5] = Integer.valueOf(i);
                                    objArr2[6] = bundle;
                                    return (Instrumentation.ActivityResult) r15.invoke(obj2, objArr2);
                                }
                                intent = intentArr[0];
                                dataString = intent.getDataString();
                                d.e().c(dataString);
                                d.e().b(sb.toString());
                                if (aVarB != null) {
                                    zB = aVarB.b();
                                    if (zB) {
                                        if (this.b == null) {
                                            this.b = findTarget(this.f8736a);
                                        }
                                    }
                                } else {
                                    zB = false;
                                }
                                if (aVarB != null) {
                                    aVarB.a(dataString);
                                }
                                u.e("guard", "exec out");
                                r15 = method;
                                u.e("guard", "invoke def, deepSeek=" + zB);
                                if (!zB) {
                                    if (z) {
                                        r15.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr, bundle);
                                        return null;
                                    }
                                    Instrumentation instrumentation2 = this.f8736a;
                                    Object[] objArr3 = new Object[7];
                                    objArr3[0] = context;
                                    objArr3[c] = iBinder;
                                    objArr3[2] = iBinder2;
                                    objArr3[3] = activity;
                                    objArr3[4] = intentArr[0];
                                    objArr3[5] = Integer.valueOf(i);
                                    objArr3[6] = bundle;
                                    return (Instrumentation.ActivityResult) r15.invoke(instrumentation2, objArr3);
                                }
                                if (z) {
                                    obj = this.b;
                                    if (obj == null) {
                                        obj = this.f8736a;
                                    }
                                    r15.invoke(obj, context, iBinder, iBinder2, activity, intentArr, bundle);
                                    return null;
                                }
                                obj2 = this.b;
                                if (obj2 == null) {
                                    obj2 = this.f8736a;
                                }
                                Object[] objArr4 = new Object[7];
                                objArr4[0] = context;
                                objArr4[c] = iBinder;
                                objArr4[2] = iBinder2;
                                objArr4[3] = activity;
                                objArr4[4] = intentArr[0];
                                objArr4[5] = Integer.valueOf(i);
                                objArr4[6] = bundle;
                                return (Instrumentation.ActivityResult) r15.invoke(obj2, objArr4);
                            }
                            u.e("guard", "exec no callback");
                            d.e().a();
                            if (z) {
                                declaredMethod.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr, bundle);
                                return null;
                            }
                            try {
                                return (Instrumentation.ActivityResult) declaredMethod.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr[0], Integer.valueOf(i), bundle);
                            } catch (Exception e2) {
                                e = e2;
                            }
                            u.e("guard", "invoke def, deepSeek=" + zB);
                            if (!zB) {
                                if (z) {
                                    r15.invoke(this.f8736a, context, iBinder, iBinder2, activity, intentArr, bundle);
                                    return null;
                                }
                                Instrumentation instrumentation3 = this.f8736a;
                                Object[] objArr5 = new Object[7];
                                objArr5[0] = context;
                                objArr5[c] = iBinder;
                                objArr5[2] = iBinder2;
                                objArr5[3] = activity;
                                objArr5[4] = intentArr[0];
                                objArr5[5] = Integer.valueOf(i);
                                objArr5[6] = bundle;
                                return (Instrumentation.ActivityResult) r15.invoke(instrumentation3, objArr5);
                            }
                            if (z) {
                                obj = this.b;
                                if (obj == null) {
                                    obj = this.f8736a;
                                }
                                r15.invoke(obj, context, iBinder, iBinder2, activity, intentArr, bundle);
                                return null;
                            }
                            obj2 = this.b;
                            if (obj2 == null) {
                                obj2 = this.f8736a;
                            }
                            Object[] objArr6 = new Object[7];
                            objArr6[0] = context;
                            objArr6[c] = iBinder;
                            objArr6[2] = iBinder2;
                            objArr6[3] = activity;
                            objArr6[4] = intentArr[0];
                            objArr6[5] = Integer.valueOf(i);
                            objArr6[6] = bundle;
                            return (Instrumentation.ActivityResult) r15.invoke(obj2, objArr6);
                        } catch (Exception e3) {
                            throw new RuntimeException(e3);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        r6 = 6;
                        zB = false;
                        r7 = r6;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
                r6 = declaredMethod;
            } catch (Exception e6) {
                e = e6;
                r6 = 0;
            }
        } catch (InvocationTargetException e7) {
            if (aVarB != null) {
                aVarB.c();
            }
            throw new RuntimeException(e7);
        }
        zB = false;
        r7 = r6;
        if (u.a()) {
            e.printStackTrace();
        }
        if (aVarB != null) {
            aVarB.c();
        }
        r15 = r7;
    }

    private Object a(Object obj, int i, List<Object> list) {
        if (obj != null && i > 0 && !list.contains(obj)) {
            list.add(obj);
            if (a(obj)) {
                return obj;
            }
            for (Field field : obj.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object objA = a(field.get(obj), i - 1, list);
                    if (objA != null) {
                        return objA;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private boolean a(Object obj) {
        if (obj != null) {
            return obj.getClass().getName().equals(this.c);
        }
        return false;
    }

    private Object b(Object obj, int i, List<Object> list) {
        if (obj != null && i >= 0 && !list.contains(obj)) {
            list.add(obj);
            if (a(obj)) {
                return obj;
            }
            Class<?> superclass = obj.getClass();
            for (int i2 = 0; i2 < 2 && superclass != null; i2++) {
                for (Field field : superclass.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        Object objB = b(field.get(obj), i - 1, list);
                        if (objB != null) {
                            return objB;
                        }
                    } catch (Exception unused) {
                    }
                }
                superclass = superclass.getSuperclass();
            }
        }
        return null;
    }

    public void execStartActivities(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent[] intentArr, Bundle bundle) {
        a(true, context, iBinder, iBinder2, activity, intentArr, 0, bundle);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        return a(false, context, iBinder, iBinder2, activity, new Intent[]{intent}, i, bundle);
    }

    public Object findTarget(Object obj) {
        ArrayList arrayList = new ArrayList();
        Object objA = a(obj, 5, arrayList);
        if (objA != null) {
            return objA;
        }
        arrayList.clear();
        return b(obj, 3, arrayList);
    }
}
