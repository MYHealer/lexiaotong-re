package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class p0 implements q0.pgla {
    private final long c;
    private final Context tt;
    private final pblv ve;

    p0(pblv pblvVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.ve = pblvVar;
        this.tt = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = j;
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final Map<String, String> getFeatureHash(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.c;
            int i = pblz.c;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    if (str2 != null && str3 != null) {
                        map.put(str2, str3);
                    }
                }
            }
        }
        return map;
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final String getToken() {
        long j = this.c;
        if (j == -1) {
            return "";
        }
        int i = pblz.c;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j, null, null);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void report(String str) {
        if (this.c == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.c;
        Context context = this.tt;
        int i = pblz.c;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void setBDDeviceID(String str) {
        this.ve.d = str;
        long j = this.c;
        if (j != -1) {
            Context context = this.tt;
            int i = pblz.c;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void setCollectMode(int i) {
        long j = this.c;
        if (j != -1) {
            int i2 = pblz.c;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i, j, null, null);
        }
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void setDeviceID(String str) {
        this.ve.c = str;
        long j = this.c;
        if (j != -1) {
            Context context = this.tt;
            int i = pblz.c;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void setInstallID(String str) {
        this.ve.e = str;
        long j = this.c;
        if (j != -1) {
            Context context = this.tt;
            int i = pblz.c;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j, str, context);
        }
    }
}
