package com.hihonor.adsdk.common.b.i;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.hihonor.adsdk.common.b.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements com.hihonor.adsdk.common.b.a {
    private static final String hnadse;
    private static final String hnadsf = " <br> ";
    private static final String hnadsg = "/";
    private static final String hnadsh = ":";
    private static final String hnadsi = " ";
    private final Date hnadsa;
    private final SimpleDateFormat hnadsb;
    private final g hnadsc;
    private String hnadsd;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.b.i.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0455a {
    }

    public static final class b {
        private Date hnadsa;
        private SimpleDateFormat hnadsb;
        private g hnadsc;

        /* synthetic */ b(C0455a c0455a) {
            this();
        }

        public b hnadsa(g gVar) {
            this.hnadsc = gVar;
            return this;
        }

        public b hnadsa(SimpleDateFormat simpleDateFormat) {
            this.hnadsb = simpleDateFormat;
            return this;
        }

        public b hnadsa(Date date) {
            this.hnadsa = date;
            return this;
        }

        private b() {
        }

        public a hnadsa() {
            if (this.hnadsa == null) {
                this.hnadsa = new Date();
            }
            if (this.hnadsb == null) {
                this.hnadsb = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.CHINA);
            }
            if (this.hnadsc == null) {
                HandlerThread handlerThread = new HandlerThread("HiAdsLog");
                handlerThread.start();
                this.hnadsc = new c(new c.a(handlerThread.getLooper()));
            }
            return new a(this, null);
        }
    }

    static {
        hnadse = System.getProperty("line.separator") == null ? IOUtils.LINE_SEPARATOR_UNIX : System.getProperty("line.separator");
    }

    /* synthetic */ a(b bVar, C0455a c0455a) {
        this(bVar);
    }

    public static b hnadsa() {
        return new b(null);
    }

    private a(b bVar) {
        this.hnadsa = bVar.hnadsa;
        this.hnadsb = bVar.hnadsb;
        this.hnadsc = bVar.hnadsc;
        if (com.hihonor.adsdk.common.a.hnadsa().hnadsb() != null) {
            this.hnadsd = com.hihonor.adsdk.common.a.hnadsa().hnadsb().getPackageName();
        }
    }

    @Override // com.hihonor.adsdk.common.b.a
    public void hnadsa(int i, String str, String str2) {
        if (TextUtils.isEmpty(this.hnadsd) && com.hihonor.adsdk.common.a.hnadsa().hnadsb() != null) {
            this.hnadsd = com.hihonor.adsdk.common.a.hnadsa().hnadsb().getPackageName();
        }
        if (this.hnadsc == null) {
            return;
        }
        this.hnadsa.setTime(System.currentTimeMillis());
        this.hnadsc.hnadsa(i, str, this.hnadsb.format(this.hnadsa) + hnadsg + this.hnadsd + " " + com.hihonor.adsdk.common.b.j.b.hnadsa(i) + hnadsg + str + ": " + str2 + hnadse);
    }
}
