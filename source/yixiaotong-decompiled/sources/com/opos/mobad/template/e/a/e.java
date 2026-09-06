package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f7541a;

    e() {
    }

    public static e a() {
        if (f7541a == null) {
            synchronized (e.class) {
                if (f7541a == null) {
                    f7541a = new e();
                }
            }
        }
        return f7541a;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0081 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:41:0x0095  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        com.opos.mobad.template.e.c.b.b bVar;
        com.opos.mobad.template.e.c.b.b bVar2;
        if (i != 27) {
            if (i != 28) {
                if (i != 2009) {
                    if (i == 2010) {
                        return new com.opos.mobad.template.e.c.d(context, b(), 0, 1, false);
                    }
                    if (i != 2114 && i != 2115) {
                        if (i != 2138 && i != 2139) {
                            switch (i) {
                                case 7:
                                case 2007:
                                    break;
                                case 48:
                                case 2085:
                                    break;
                                case 56:
                                case 62:
                                case 68:
                                case 2024:
                                case 2041:
                                case 2053:
                                case 2058:
                                case 2061:
                                case 2073:
                                    return new com.opos.mobad.template.e.c.c.d(context, b(), 0);
                                case 59:
                                    return new com.opos.mobad.template.e.c.c.d(context, b(), 1);
                                case 71:
                                    return new com.opos.mobad.template.e.c.c.e(context, b());
                                case 2124:
                                case 2141:
                                case 2142:
                                case 2143:
                                case 2144:
                                case 2145:
                                case 2146:
                                case 2147:
                                    break;
                                case 2148:
                                    bVar2 = new com.opos.mobad.template.e.c.b.b(context, b(), 0, false, null);
                                    if (bVar2.c() != null) {
                                        return bVar2;
                                    }
                                    return null;
                                default:
                                    switch (i) {
                                        case 12:
                                        case 14:
                                            break;
                                        case 13:
                                        case 15:
                                            break;
                                        default:
                                            switch (i) {
                                                case 2028:
                                                case 2030:
                                                    break;
                                                case 2029:
                                                case 2031:
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 2126:
                                                            com.opos.mobad.template.e.c.b.b bVar3 = new com.opos.mobad.template.e.c.b.b(context, b(), 1, true, "#0066FF");
                                                            if (bVar3.c() != null) {
                                                                return bVar3;
                                                            }
                                                            return null;
                                                        default:
                                                            switch (i) {
                                                                default:
                                                                    switch (i) {
                                                                        case 2150:
                                                                        case 2152:
                                                                            bVar2 = new com.opos.mobad.template.e.c.b.b(context, b(), 0, false, null);
                                                                            if (bVar2.c() != null) {
                                                                                return bVar2;
                                                                            }
                                                                            return null;
                                                                        case 2151:
                                                                        case 2153:
                                                                            break;
                                                                        default:
                                                                            return null;
                                                                    }
                                                                case 2132:
                                                                case 2133:
                                                                case 2134:
                                                                case 2135:
                                                                case 2136:
                                                                    bVar = new com.opos.mobad.template.e.c.b.b(context, b(), 0, true, null);
                                                                    if (bVar.c() != null) {
                                                                        return bVar;
                                                                    }
                                                                    return null;
                                                            }
                                                        case 2127:
                                                        case 2128:
                                                            bVar = new com.opos.mobad.template.e.c.b.b(context, b(), 0, true, null);
                                                            if (bVar.c() != null) {
                                                                return bVar;
                                                            }
                                                            return null;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                        bVar = new com.opos.mobad.template.e.c.b.b(context, b(), 0, true, null);
                        if (bVar.c() != null) {
                            return bVar;
                        }
                        return null;
                    }
                }
            }
            return new com.opos.mobad.template.e.c.d(context, b(), 0, 0, false);
        }
        return new com.opos.mobad.template.e.c.d(context, b(), 0, 0, true);
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SHAKE;
    }
}
