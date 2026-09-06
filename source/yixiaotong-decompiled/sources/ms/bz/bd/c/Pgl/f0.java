package ms.bz.bd.c.Pgl;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class f0 extends pblz.pgla {
    f0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        JSONObject jSONObjectVe;
        try {
            q1 q1VarC = q1.c();
            return (!q1VarC.uj() || (jSONObjectVe = q1VarC.ve()) == null) ? "" : jSONObjectVe.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
