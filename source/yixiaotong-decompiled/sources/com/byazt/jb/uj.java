package com.byazt.jb;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.widget.j;
import com.baidu.mobads.sdk.internal.cm;
import com.byazt.mk.my;
import com.fancy.adsdk.lib.constants.AdConstant;
import com.google.common.primitives.SignedBytes;
import com.masget.base.AppConfig;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 15})
public final class uj {
    public static final ve[] c = {new ve(ve.f2379a, ""), new ve(ve.ve, "GET"), new ve(ve.ve, "POST"), new ve(ve.uj, "/"), new ve(ve.uj, "/index.html"), new ve(ve.n, "http"), new ve(ve.n, "https"), new ve(ve.tt, "200"), new ve(ve.tt, "204"), new ve(ve.tt, "206"), new ve(ve.tt, AdConstant.NATIVE_TYPE.LEFT_IMAGE), new ve(ve.tt, "400"), new ve(ve.tt, cm.b), new ve(ve.tt, "500"), new ve("accept-charset", ""), new ve("accept-encoding", "gzip, deflate"), new ve("accept-language", ""), new ve("accept-ranges", ""), new ve("accept", ""), new ve("access-control-allow-origin", ""), new ve("age", ""), new ve("allow", ""), new ve("authorization", ""), new ve("cache-control", ""), new ve("content-disposition", ""), new ve("content-encoding", ""), new ve("content-language", ""), new ve("content-length", ""), new ve("content-location", ""), new ve("content-range", ""), new ve(e.d, ""), new ve(AppConfig.CONF_COOKIE, ""), new ve("date", ""), new ve(FileDownloadModel.ETAG, ""), new ve("expect", ""), new ve(ClientCookie.EXPIRES_ATTR, ""), new ve("from", ""), new ve("host", ""), new ve("if-match", ""), new ve("if-modified-since", ""), new ve("if-none-match", ""), new ve("if-range", ""), new ve("if-unmodified-since", ""), new ve("last-modified", ""), new ve("link", ""), new ve("location", ""), new ve("max-forwards", ""), new ve("proxy-authenticate", ""), new ve("proxy-authorization", ""), new ve("range", ""), new ve("referer", ""), new ve(j.l, ""), new ve("retry-after", ""), new ve("server", ""), new ve("set-cookie", ""), new ve("strict-transport-security", ""), new ve("transfer-encoding", ""), new ve("user-agent", ""), new ve("vary", ""), new ve("via", ""), new ve("www-authenticate", "")};
    public static final Map<com.byazt.mk.a, Integer> tt = c();

    @com.byazt.zqa.c(c = {0, 1, 63, AppTypeIdUtil.NewDevice4GBathOTA})
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.byazt.mk.n f2377a;
        public ve[] c;
        public final List<ve> n;
        public final int sp;
        public int tt;
        public int uj;
        public int ve;
        public int x;

        private int ve(int i) {
            return this.tt + 1 + i;
        }

        public c(int i, my myVar) {
            this(i, i, myVar);
        }

        public c(int i, int i2, my myVar) {
            this.n = new ArrayList();
            ve[] veVarArr = new ve[8];
            this.c = veVarArr;
            this.tt = veVarArr.length - 1;
            this.ve = 0;
            this.uj = 0;
            this.sp = i;
            this.x = i2;
            this.f2377a = com.byazt.mk.t.c(myVar);
        }

        private void uj() {
            int i = this.x;
            int i2 = this.uj;
            if (i < i2) {
                if (i == 0) {
                    n();
                } else {
                    c(i2 - i);
                }
            }
        }

        private void n() {
            Arrays.fill(this.c, (Object) null);
            this.tt = this.c.length - 1;
            this.ve = 0;
            this.uj = 0;
        }

        private int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.tt;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.c[length].i;
                    this.uj -= this.c[length].i;
                    this.ve--;
                    i3++;
                }
                ve[] veVarArr = this.c;
                System.arraycopy(veVarArr, i2 + 1, veVarArr, i2 + 1 + i3, this.ve);
                this.tt += i3;
            }
            return i3;
        }

        public void c() throws IOException {
            while (!this.f2377a.n()) {
                byte bX = this.f2377a.x();
                int i = bX & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((bX & 128) == 128) {
                    tt(c(i, 127) - 1);
                } else if (i == 64) {
                    sp();
                } else if ((bX & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    n(c(i, 63) - 1);
                } else if ((bX & 32) == 32) {
                    int iC = c(i, 31);
                    this.x = iC;
                    if (iC < 0 || iC > this.sp) {
                        throw new IOException("Invalid dynamic table size update " + this.x);
                    }
                    uj();
                } else if (i == 16 || i == 0) {
                    a();
                } else {
                    uj(c(i, 15) - 1);
                }
            }
        }

        public List<ve> tt() {
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            return arrayList;
        }

        private void tt(int i) throws IOException {
            if (sp(i)) {
                this.n.add(uj.c[i]);
                return;
            }
            int iVe = ve(i - uj.c.length);
            if (iVe >= 0) {
                ve[] veVarArr = this.c;
                if (iVe <= veVarArr.length - 1) {
                    this.n.add(veVarArr[iVe]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void uj(int i) throws IOException {
            this.n.add(new ve(a(i), ve()));
        }

        private void a() throws IOException {
            this.n.add(new ve(uj.c(ve()), ve()));
        }

        private void n(int i) throws IOException {
            c(-1, new ve(a(i), ve()));
        }

        private void sp() throws IOException {
            c(-1, new ve(uj.c(ve()), ve()));
        }

        private com.byazt.mk.a a(int i) {
            if (sp(i)) {
                return uj.c[i].sp;
            }
            return this.c[ve(i - uj.c.length)].sp;
        }

        private boolean sp(int i) {
            return i >= 0 && i <= uj.c.length - 1;
        }

        private void c(int i, ve veVar) {
            this.n.add(veVar);
            int i2 = veVar.i;
            if (i != -1) {
                i2 -= this.c[ve(i)].i;
            }
            int i3 = this.x;
            if (i2 > i3) {
                n();
                return;
            }
            int iC = c((this.uj + i2) - i3);
            if (i == -1) {
                int i4 = this.ve + 1;
                ve[] veVarArr = this.c;
                if (i4 > veVarArr.length) {
                    ve[] veVarArr2 = new ve[veVarArr.length * 2];
                    System.arraycopy(veVarArr, 0, veVarArr2, veVarArr.length, veVarArr.length);
                    this.tt = this.c.length - 1;
                    this.c = veVarArr2;
                }
                int i5 = this.tt;
                this.tt = i5 - 1;
                this.c[i5] = veVar;
                this.ve++;
            } else {
                this.c[i + ve(i) + iC] = veVar;
            }
            this.uj += i2;
        }

        private int x() throws IOException {
            return this.f2377a.x() & 255;
        }

        public int c(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iX = x();
                if ((iX & 128) == 0) {
                    return i2 + (iX << i4);
                }
                i2 += (iX & 127) << i4;
                i4 += 7;
            }
        }

        public com.byazt.mk.a ve() throws IOException {
            int iX = x();
            boolean z = (iX & 128) == 128;
            int iC = c(iX, 127);
            if (z) {
                return com.byazt.mk.a.c(sl.c().c(this.f2377a.sp(iC)));
            }
            return this.f2377a.ve(iC);
        }
    }

    private static Map<com.byazt.mk.a, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(c.length);
        int i = 0;
        while (true) {
            ve[] veVarArr = c;
            if (i < veVarArr.length) {
                if (!linkedHashMap.containsKey(veVarArr[i].sp)) {
                    linkedHashMap.put(veVarArr[i].sp, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 153})
    static final class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2378a;
        public int c;
        public boolean da;
        public int i;
        public int n;
        public final com.byazt.mk.ve sp;
        public int tt;
        public int uj;
        public ve[] ve;
        public final boolean x;

        public tt(com.byazt.mk.ve veVar) {
            this(4096, true, veVar);
        }

        public tt(int i, boolean z, com.byazt.mk.ve veVar) {
            this.i = Integer.MAX_VALUE;
            ve[] veVarArr = new ve[8];
            this.ve = veVarArr;
            this.uj = veVarArr.length - 1;
            this.n = 0;
            this.f2378a = 0;
            this.c = i;
            this.tt = i;
            this.x = z;
            this.sp = veVar;
        }

        private void c() {
            Arrays.fill(this.ve, (Object) null);
            this.uj = this.ve.length - 1;
            this.n = 0;
            this.f2378a = 0;
        }

        private int tt(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.ve.length;
                while (true) {
                    length--;
                    i2 = this.uj;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.ve[length].i;
                    this.f2378a -= this.ve[length].i;
                    this.n--;
                    i3++;
                }
                ve[] veVarArr = this.ve;
                System.arraycopy(veVarArr, i2 + 1, veVarArr, i2 + 1 + i3, this.n);
                ve[] veVarArr2 = this.ve;
                int i4 = this.uj;
                Arrays.fill(veVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.uj += i3;
            }
            return i3;
        }

        private void c(ve veVar) {
            int i = veVar.i;
            int i2 = this.tt;
            if (i > i2) {
                c();
                return;
            }
            tt((this.f2378a + i) - i2);
            int i3 = this.n + 1;
            ve[] veVarArr = this.ve;
            if (i3 > veVarArr.length) {
                ve[] veVarArr2 = new ve[veVarArr.length * 2];
                System.arraycopy(veVarArr, 0, veVarArr2, veVarArr.length, veVarArr.length);
                this.uj = this.ve.length - 1;
                this.ve = veVarArr2;
            }
            int i4 = this.uj;
            this.uj = i4 - 1;
            this.ve[i4] = veVar;
            this.n++;
            this.f2378a += i;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x006b  */
        public void c(List<ve> list) throws IOException {
            int length;
            int length2;
            if (this.da) {
                int i = this.i;
                if (i < this.tt) {
                    c(i, 31, 32);
                }
                this.da = false;
                this.i = Integer.MAX_VALUE;
                c(this.tt, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ve veVar = list.get(i2);
                com.byazt.mk.a aVarA = veVar.sp.a();
                com.byazt.mk.a aVar = veVar.x;
                Integer num = uj.tt.get(aVarA);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 <= 1 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else if (com.byazt.kh.ve.c(uj.c[iIntValue].x, aVar)) {
                        length = length2;
                    } else if (com.byazt.kh.ve.c(uj.c[length2].x, aVar)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.ve.length;
                    for (int i3 = this.uj + 1; i3 < length3; i3++) {
                        if (com.byazt.kh.ve.c(this.ve[i3].sp, aVarA)) {
                            if (com.byazt.kh.ve.c(this.ve[i3].x, aVar)) {
                                length2 = (i3 - this.uj) + uj.c.length;
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.uj) + uj.c.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    c(length2, 127, 128);
                } else if (length == -1) {
                    this.sp.i(64);
                    c(aVarA);
                    c(aVar);
                    c(veVar);
                } else if (aVarA.c(ve.c) && !ve.f2379a.equals(aVarA)) {
                    c(length, 15, 0);
                    c(aVar);
                } else {
                    c(length, 63, 64);
                    c(aVar);
                    c(veVar);
                }
            }
        }

        public void c(int i, int i2, int i3) {
            if (i < i2) {
                this.sp.i(i | i3);
                return;
            }
            this.sp.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.sp.i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.sp.i(i4);
        }

        public void c(com.byazt.mk.a aVar) throws IOException {
            if (this.x && sl.c().c(aVar) < aVar.sp()) {
                com.byazt.mk.ve veVar = new com.byazt.mk.ve();
                sl.c().c(aVar, veVar);
                com.byazt.mk.a aVarYp = veVar.yp();
                c(aVarYp.sp(), 127, 128);
                this.sp.tt(aVarYp);
                return;
            }
            c(aVar.sp(), 127, 0);
            this.sp.tt(aVar);
        }

        public void c(int i) {
            this.c = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.tt;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.i = Math.min(this.i, iMin);
            }
            this.da = true;
            this.tt = iMin;
            tt();
        }

        private void tt() {
            int i = this.tt;
            int i2 = this.f2378a;
            if (i < i2) {
                if (i == 0) {
                    c();
                } else {
                    tt(i2 - i);
                }
            }
        }
    }

    public static com.byazt.mk.a c(com.byazt.mk.a aVar) throws IOException {
        int iSp = aVar.sp();
        for (int i = 0; i < iSp; i++) {
            byte bC = aVar.c(i);
            if (bC >= 65 && bC <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + aVar.c());
            }
        }
        return aVar;
    }
}
