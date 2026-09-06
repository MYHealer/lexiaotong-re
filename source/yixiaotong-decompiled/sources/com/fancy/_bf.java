package com.fancy;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bf {
    public static Object _a;
    public static Object _b;

    public static void _a(Context context) {
        String str;
        String str2;
        Object obj;
        Object obj_a;
        Class<?> cls;
        Field declaredField;
        try {
            int i = Build.VERSION.SDK_INT;
            Field declaredField2 = null;
            if (i >= 29) {
                str = "android.app.ActivityTaskManager";
                str2 = "IActivityTaskManagerSingleton";
            } else {
                str = "android.app.ActivityManager";
                str2 = "IActivityManagerSingleton";
            }
            try {
                Class<?> cls2 = Class.forName(str);
                while (true) {
                    if (cls2 == null) {
                        declaredField = null;
                        break;
                    } else {
                        try {
                            declaredField = cls2.getDeclaredField(str2);
                            break;
                        } catch (NoSuchFieldException unused) {
                            cls2 = cls2.getSuperclass();
                        }
                    }
                }
                if (declaredField == null) {
                    throw new NoSuchFieldException("Member not found: " + str2);
                }
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                _b = obj;
                if (obj != null && (obj_a = _a(obj, i)) != null) {
                    _a = obj_a;
                    try {
                        cls = Class.forName(i >= 29 ? "android.app.IActivityTaskManager" : "android.app.IActivityManager");
                    } catch (Exception unused2) {
                        cls = null;
                    }
                    if (cls == null) {
                        return;
                    }
                    Object objNewProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new _bd(context, obj_a));
                    Object obj2 = _b;
                    try {
                        for (Class<?> cls3 = Class.forName("android.util.Singleton"); cls3 != null; cls3 = cls3.getSuperclass()) {
                            try {
                                declaredField2 = cls3.getDeclaredField("mInstance");
                                break;
                            } catch (NoSuchFieldException unused3) {
                            }
                        }
                        if (declaredField2 == null) {
                            throw new NoSuchFieldException("Member not found: mInstance");
                        }
                        declaredField2.setAccessible(true);
                        declaredField2.set(obj2, objNewProxyInstance);
                    } catch (Exception e) {
                        try {
                            throw e;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            } catch (Exception e3) {
                try {
                    throw e3;
                } catch (Exception unused4) {
                    obj = null;
                }
            }
        } catch (Exception unused5) {
        }
    }

    public static Object _a(Class cls, String str) throws Exception {
        Method declaredMethod;
        while (true) {
            if (cls == null) {
                declaredMethod = null;
                break;
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
                break;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            } catch (Exception e) {
                throw e;
            }
        }
        if (declaredMethod == null) {
            throw new NoSuchMethodException("Function not found: " + str);
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object _a(Object obj, int i) {
        Field declaredField;
        Object obj_a;
        Field declaredField2;
        try {
            try {
                Class<?> cls = Class.forName("android.util.Singleton");
                while (true) {
                    if (cls == null) {
                        declaredField = null;
                        break;
                    }
                    try {
                        declaredField = cls.getDeclaredField("mInstance");
                        break;
                    } catch (NoSuchFieldException unused) {
                        cls = cls.getSuperclass();
                    }
                }
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 == null) {
                        try {
                            if (i >= 29) {
                                obj_a = _a(Class.forName("android.app.ActivityTaskManager"), "getService");
                            } else if (i >= 26) {
                                obj_a = _a(Class.forName("android.app.ActivityManager"), "getService");
                            } else {
                                obj_a = _a(Class.forName("android.app.ActivityManagerNative"), "getDefault");
                            }
                        } catch (Exception unused2) {
                            obj_a = null;
                        }
                        obj2 = obj_a;
                        if (obj2 != null) {
                            try {
                                Class<?> cls2 = Class.forName("android.util.Singleton");
                                while (true) {
                                    if (cls2 == null) {
                                        declaredField2 = null;
                                        break;
                                    }
                                    try {
                                        declaredField2 = cls2.getDeclaredField("mInstance");
                                        break;
                                    } catch (NoSuchFieldException unused3) {
                                        cls2 = cls2.getSuperclass();
                                    }
                                }
                                if (declaredField2 == null) {
                                    throw new NoSuchFieldException("Member not found: mInstance");
                                }
                                declaredField2.setAccessible(true);
                                declaredField2.set(obj, obj2);
                            } catch (Exception e) {
                                try {
                                    throw e;
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            }
                        }
                    }
                    return obj2;
                }
                throw new NoSuchFieldException("Member not found: mInstance");
            } catch (Exception unused4) {
                return null;
            }
        } catch (Exception e3) {
            try {
                throw e3;
            } catch (Exception e4) {
                throw e4;
            }
        }
    }
}
