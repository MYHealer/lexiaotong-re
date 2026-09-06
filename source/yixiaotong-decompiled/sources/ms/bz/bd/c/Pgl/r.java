package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.byazt.nys.tt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class r extends pblz.pgla {
    r() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        Context contextTt = pblw.c().tt();
        String[] strArrSplit = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a1f8c7", new byte[]{76, 47}));
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        SharedPreferences.Editor editorEdit = tt.tt(contextTt, str2, 0).edit();
        editorEdit.putString(str3, (String) obj);
        editorEdit.commit();
        return null;
    }
}
