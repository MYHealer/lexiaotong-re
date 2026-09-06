package com.byazt.hsa;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ut.i;
import com.byazt.ut.sl;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2432, 20})
public class c {
    public final i c;

    public c(i iVar) {
        this.c = iVar;
    }

    public boolean c(sl slVar, Function function) {
        int iC = com.byazt.rj.c.c(function, slVar.f2791a);
        if (iC <= slVar.ve) {
            return false;
        }
        slVar.tt(iC);
        slVar.c(function);
        i iVar = this.c;
        if (iVar == null) {
            return true;
        }
        iVar.c(slVar.f2791a, function, slVar.ve, iC);
        return true;
    }

    public void c(sl slVar, com.byazt.ut.c cVar, Function function) {
        if (slVar.a()) {
            if (!slVar.sp) {
                Object objUj = slVar.uj();
                if (objUj != null) {
                    c(slVar, null, objUj, cVar);
                    return;
                }
                return;
            }
            for (Map.Entry<com.byazt.dna.c, Object> entry : slVar.ve().entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    c(slVar, entry.getKey(), value, cVar);
                }
            }
        }
    }

    private void c(sl slVar, com.byazt.dna.c cVar, Object obj, com.byazt.ut.c cVar2) {
        int iC;
        Pair<Function, Object> pairC = cVar2.n().c(slVar, cVar);
        if (pairC != null && (iC = com.byazt.rj.c.c((Function) pairC.first, slVar.f2791a)) > slVar.c() && pairC.second != null && (obj instanceof Function) && (pairC.second instanceof Function)) {
            Function function = (Function) obj;
            Function function2 = (Function) pairC.second;
            if (function.getClass().getClassLoader() != function2.getClass().getClassLoader()) {
                c(function, function2);
                slVar.c(iC);
                i iVar = this.c;
                if (iVar != null) {
                    iVar.c(slVar.f2791a, obj, pairC.second, slVar.ve, slVar.n());
                }
                c(function, slVar);
                return;
            }
            if (this.c != null) {
                StringBuilder sb = new StringBuilder("source:");
                sb.append(obj);
                sb.append(" target:").append(function2);
                sb.append(" classloader:").append(function.getClass().getClassLoader());
                sb.append(" target classloader:").append(function2.getClass().getClassLoader());
                this.c.c(slVar, 3, sb.toString(), (Throwable) null);
            }
        }
    }

    private boolean c(Function function, sl slVar) {
        Function functionTt = com.byazt.rj.c.tt(function);
        if (functionTt == null) {
            i iVar = this.c;
            if (iVar != null) {
                iVar.c(2, "get origin service impl failed:" + slVar.f2791a, (Throwable) null);
            }
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -1);
        functionTt.apply(sparseArray);
        return true;
    }

    private void c(Function function, Function function2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -4);
        sparseArray.put(1, function2);
        function.apply(sparseArray);
    }
}
