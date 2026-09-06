package com.opos.exoplayer.core.f.e;

import android.text.Html;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bg;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.p;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6440a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder b;

    public a() {
        super("SubripDecoder");
        this.b = new StringBuilder();
    }

    private static long a(Matcher matcher, int i) {
        return ((Long.parseLong(matcher.group(i + 1)) * bg.s) + (Long.parseLong(matcher.group(i + 2)) * 60000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(byte[] bArr, int i, boolean z) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        p pVar = new p(bArr, i);
        while (true) {
            String strZ = pVar.z();
            if (strZ == null) {
                break;
            }
            if (strZ.length() != 0) {
                try {
                    Integer.parseInt(strZ);
                    strZ = pVar.z();
                    if (strZ == null) {
                        com.opos.cmn.an.f.a.c("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f6440a.matcher(strZ);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        kVar.a(a(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            z2 = false;
                        } else {
                            kVar.a(a(matcher, 6));
                        }
                        this.b.setLength(0);
                        while (true) {
                            String strZ2 = pVar.z();
                            if (TextUtils.isEmpty(strZ2)) {
                                break;
                            }
                            if (this.b.length() > 0) {
                                this.b.append("<br>");
                            }
                            this.b.append(strZ2.trim());
                        }
                        arrayList.add(new com.opos.exoplayer.core.f.b(Html.fromHtml(this.b.toString())));
                        if (z2) {
                            arrayList.add(null);
                        }
                    } else {
                        sb = new StringBuilder("Skipping invalid timing: ");
                        com.opos.cmn.an.f.a.c("SubripDecoder", sb.append(strZ).toString());
                    }
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder("Skipping invalid index: ");
                }
            }
        }
        com.opos.exoplayer.core.f.b[] bVarArr = new com.opos.exoplayer.core.f.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, kVar.b());
    }
}
