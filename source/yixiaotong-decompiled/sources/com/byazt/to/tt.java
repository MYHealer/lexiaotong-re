package com.byazt.to;

import com.byazt.lw.a;
import com.byazt.lw.i;
import com.byazt.lw.my;
import com.byazt.lw.n;
import com.byazt.lw.nu;
import com.byazt.lw.rh;
import com.byazt.lw.sl;
import com.byazt.lw.t;
import com.byazt.lw.u;
import com.byazt.lw.x;
import com.byazt.lw.yp;
import com.byazt.zg.uj;
import com.byazt.zg.ve;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 607, 13})
public class tt {
    public static com.byazt.dr.c c(List<com.byazt.dr.c> list, String str, int i) {
        ve(list, str, i);
        Deque<com.byazt.dr.c> dequeC = c(tt(list, str, i));
        if (dequeC.size() != 1) {
            throw new IllegalStateException();
        }
        return dequeC.getFirst();
    }

    private static Deque<com.byazt.dr.c> c(Deque<com.byazt.dr.c> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.byazt.dr.c cVar : deque) {
            if (!linkedList.isEmpty() && ((com.byazt.dr.c) linkedList.peekLast()).c() == ve.COLON) {
                linkedList.pollLast();
                com.byazt.dr.c cVar2 = (com.byazt.dr.c) linkedList.pollLast();
                if (((com.byazt.dr.c) linkedList.pollLast()).c() != ve.QUESTION) {
                    throw new IllegalStateException();
                }
                com.byazt.dr.c cVar3 = (com.byazt.dr.c) linkedList.pollLast();
                my myVar = new my();
                myVar.c(cVar3);
                myVar.tt(cVar2);
                myVar.ve(cVar);
                linkedList.addLast(myVar);
            } else {
                linkedList.addLast(cVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.byazt.dr.c> tt(List<com.byazt.dr.c> list, String str, int i) {
        LinkedList<com.byazt.dr.c> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.byazt.dr.c cVar : linkedList) {
                if (!linkedList2.isEmpty() && ve.c(((com.byazt.dr.c) linkedList2.peekLast()).c()) && ((ve) ((com.byazt.dr.c) linkedList2.peekLast()).c()).tt() == i2) {
                    com.byazt.dr.c cVar2 = (com.byazt.dr.c) linkedList2.pollLast();
                    com.byazt.dr.c cVar3 = (com.byazt.dr.c) linkedList2.pollLast();
                    if (!ve.c(cVar3.c()) && !ve.c(cVar.c())) {
                        linkedList2.addLast(c(cVar3, cVar2, cVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(cVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void ve(List<com.byazt.dr.c> list, String str, int i) {
        Iterator<com.byazt.dr.c> it = list.iterator();
        while (it.hasNext()) {
            if (uj.c(it.next().c())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.to.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 607, 28})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ve.values().length];
            c = iArr;
            try {
                iArr[ve.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ve.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ve.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[ve.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[ve.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[ve.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[ve.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[ve.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[ve.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[ve.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[ve.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[ve.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                c[ve.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.byazt.dr.c c(com.byazt.dr.c cVar, com.byazt.dr.c cVar2, com.byazt.dr.c cVar3) {
        nu slVar;
        switch (AnonymousClass1.c[((ve) cVar2.c()).ordinal()]) {
            case 1:
                slVar = new sl();
                break;
            case 2:
                slVar = new rh();
                break;
            case 3:
                slVar = new com.byazt.lw.c();
                break;
            case 4:
                slVar = new u();
                break;
            case 5:
                slVar = new t();
                break;
            case 6:
                slVar = new com.byazt.lw.uj();
                break;
            case 7:
                slVar = new yp();
                break;
            case 8:
                slVar = new a();
                break;
            case 9:
                slVar = new i();
                break;
            case 10:
                slVar = new n();
                break;
            case 11:
                slVar = new x();
                break;
            case 12:
                slVar = new com.byazt.lw.tt();
                break;
            case 13:
                slVar = new com.byazt.lw.ve();
                break;
            default:
                throw new UnsupportedOperationException(cVar2.c().toString());
        }
        slVar.c(cVar);
        slVar.tt(cVar3);
        return slVar;
    }

    public static boolean c(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
