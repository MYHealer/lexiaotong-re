package com.ubixnow.network.csj;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.ubixnow.ooooo.oO0O0Oo0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjUtils {
    private static double OooO00o(Class cls, Object obj, oo00o oo00oVar) {
        double dOooO00o;
        try {
            Class<?> superclass = obj.getClass();
            do {
                superclass = superclass.getSuperclass();
            } while (!(superclass instanceof Object));
        } catch (Throwable th) {
            OooO00o(th);
        }
        double d = 0.0d;
        try {
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if ((obj2 instanceof List) && obj2 != null && ((List) obj2).size() > 0) {
                    for (Object obj3 : (List) obj2) {
                        if (obj3 instanceof Bridge) {
                            dOooO00o = OooO00o(obj3, oo00oVar);
                            if (dOooO00o > d) {
                                d = dOooO00o;
                            }
                        } else if (obj3.getClass().getName().contains("com.bytedance.msdk")) {
                            oo00oVar.csjPriceMethod = "4";
                            dOooO00o = OooO00o(obj3, oo00oVar);
                            if (dOooO00o > d) {
                                d = dOooO00o;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            oo00oVar.csjPriceMethod = "3";
            OooO00o(th2);
        }
        ooooO000.OooO0O0("---abc2:", d + "");
        return d;
    }

    private static double OooO00o(Object obj, oo00o oo00oVar) {
        ArrayList<Field> arrayList = new ArrayList();
        OooO00o((Class) obj.getClass(), (List<Field>) arrayList, oo00oVar);
        double d = 0.0d;
        for (Field field : arrayList) {
            if (field.getType() == Double.TYPE) {
                try {
                    field.setAccessible(true);
                    double dDoubleValue = ((Double) field.get(obj)).doubleValue();
                    ooooO000.OooO0O0("---abc1:", dDoubleValue + "" + field.getName());
                    if (d <= dDoubleValue) {
                        d = dDoubleValue;
                    }
                } catch (Throwable th) {
                    oo00oVar.csjPriceMethod = "3";
                    OooO00o(th);
                }
            }
        }
        return d;
    }

    private static void OooO00o(Class cls, List<Field> list, oo00o oo00oVar) {
        if (cls != null) {
            try {
                if (cls.getName().equals(Object.class.getName())) {
                    return;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    list.addAll(Arrays.asList(declaredFields));
                }
                OooO00o(cls.getSuperclass(), list, oo00oVar);
            } catch (Throwable th) {
                oo00oVar.csjPriceMethod = "3";
                OooO00o(th);
            }
        }
    }

    private static void OooO00o(Throwable th) {
        ooooO000.OooO00o(th);
    }

    private static double OooO0O0(Object obj, oo00o oo00oVar) {
        if (obj != null) {
            try {
                List<Object> listOooO0OO = OooO0OO(obj, oo00oVar);
                if (listOooO0OO != null && listOooO0OO.size() != 0) {
                    for (Object obj2 : listOooO0OO) {
                        if (obj2 != null) {
                            Class<?> cls = null;
                            for (Class<?> superclass = obj2.getClass(); superclass != null && !superclass.getName().equals("java.lang.Object"); superclass = superclass.getSuperclass()) {
                                if (superclass.getSuperclass().getName().equals("java.lang.Object")) {
                                    cls = superclass;
                                }
                            }
                            if (cls != null) {
                                double dOooO00o = OooO00o(cls, obj2, oo00oVar);
                                if (dOooO00o > 0.0d) {
                                    ooooO000.OooO0O0("---abc3:", dOooO00o + "");
                                    return dOooO00o;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                return 0.0d;
            } catch (Throwable th) {
                oo00oVar.csjPriceMethod = "3";
                OooO00o(th);
            }
        }
        return 0.0d;
    }

    private static List<Object> OooO0OO(Object obj, oo00o oo00oVar) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    arrayList.add(obj2);
                    for (Field field2 : obj2.getClass().getDeclaredFields()) {
                        field2.setAccessible(true);
                        arrayList.add(field2.get(obj2));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            oo00oVar.csjPriceMethod = "3";
            OooO00o(th);
            return arrayList;
        }
    }

    public static double getBestPriceInCacheNew(Object obj, oo00o oo00oVar) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        oo00oVar.csjPriceMethod = "2";
        double d = 0.0d;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    double dOooO0O0 = OooO0O0(obj2, oo00oVar);
                    if (dOooO0O0 > d) {
                        d = dOooO0O0;
                    }
                }
            } catch (Throwable th) {
                oo00oVar.csjPriceMethod = "3";
                OooO00o(th);
            }
        }
        ooooO000.OooO0O0("---abc4:", d + "");
        if (d > 0.0d) {
            return d;
        }
        oo00oVar.csjPriceMethod = "5";
        double dOooO00o = (int) new oO0O0Oo0().OooO00o(obj);
        ooooO000.OooO0O0("---abc9:", dOooO00o + "");
        return dOooO00o;
    }
}
