package ms.bz.bd.c.Pgl;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class pblx extends pblz.pgla {
    private static pblx c;

    public static class pgla {
        private long c;
        private String tt;

        public final void c(String str) {
            this.tt = str;
            this.c = System.currentTimeMillis();
        }

        public final void c(String str, int i) {
            pblx pblxVarC = pblx.c();
            if (pblxVarC == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.c;
            pblxVarC.c(jCurrentTimeMillis - j, j, this.tt, str, i);
        }

        public final void tt(String str, int i) {
            pblx pblxVarC = pblx.c();
            if (pblxVarC == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.c;
            pblxVarC.tt(jCurrentTimeMillis - j, j, this.tt, str, i);
        }
    }

    public static synchronized pblx c() {
        return c;
    }

    public static synchronized void c(pblx pblxVar) {
        c = pblxVar;
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !c(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5838bc", new byte[]{11, 17});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                c(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void c(long j, long j2, String str, String str2, int i);

    public abstract void c(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean c(String str);

    public abstract void tt(long j, long j2, String str, String str2, int i);
}
