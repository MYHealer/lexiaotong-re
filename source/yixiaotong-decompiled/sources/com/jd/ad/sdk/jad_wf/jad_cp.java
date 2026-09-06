package com.jd.ad.sdk.jad_wf;

import com.jd.ad.sdk.jad_lu.jad_zm;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_cp implements Closeable {
    public static final String[] jad_er = new String[128];
    public int jad_an;
    public int[] jad_bo = new int[32];
    public String[] jad_cp = new String[32];
    public int[] jad_dq = new int[32];

    public static final class jad_an {
        public final String[] jad_an;
        public final com.jd.ad.sdk.jad_hk.jad_fs jad_bo;

        public jad_an(String[] strArr, com.jd.ad.sdk.jad_hk.jad_fs jad_fsVar) {
            this.jad_an = strArr;
            this.jad_bo = jad_fsVar;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003a A[Catch: IOException -> 0x007b, TryCatch #1 {IOException -> 0x007b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0046, B:19:0x003a, B:20:0x003d, B:23:0x004b, B:24:0x004e, B:25:0x0056, B:26:0x005c, B:28:0x0065, B:29:0x006a, B:30:0x006b), top: B:37:0x0000, inners: #0 }] */
        public static jad_an jad_an(String... strArr) {
            String str;
            try {
                com.jd.ad.sdk.jad_hk.jad_cp[] jad_cpVarArr = new com.jd.ad.sdk.jad_hk.jad_cp[strArr.length];
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = new com.jd.ad.sdk.jad_hk.jad_an();
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    String[] strArr2 = jad_cp.jad_er;
                    jad_anVar.jad_bo(34);
                    int length = str2.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        char cCharAt = str2.charAt(i3);
                        if (cCharAt < 128) {
                            str = strArr2[cCharAt];
                            if (str != null) {
                                if (i2 < i3) {
                                    jad_anVar.jad_an(str2, i2, i3);
                                }
                                jad_anVar.jad_an(str, 0, str.length());
                                i2 = i3 + 1;
                            }
                        } else {
                            if (cCharAt == 8232) {
                                str = "\\u2028";
                            } else if (cCharAt == 8233) {
                                str = "\\u2029";
                            }
                            if (i2 < i3) {
                                jad_anVar.jad_an(str2, i2, i3);
                            }
                            jad_anVar.jad_an(str, 0, str.length());
                            i2 = i3 + 1;
                        }
                    }
                    if (i2 < length) {
                        jad_anVar.jad_an(str2, i2, length);
                    }
                    jad_anVar.jad_bo(34);
                    jad_anVar.jad_bo();
                    try {
                        jad_cpVarArr[i] = new com.jd.ad.sdk.jad_hk.jad_cp(jad_anVar.jad_cp(jad_anVar.jad_bo));
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                return new jad_an((String[]) strArr.clone(), com.jd.ad.sdk.jad_hk.jad_fs.jad_an(jad_cpVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            jad_er[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = jad_er;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract int jad_an(jad_an jad_anVar);

    public final jad_bo jad_an(String str) throws jad_bo {
        throw new jad_bo(str + " at path " + jad_fs());
    }

    public final void jad_an(int i) {
        int i2 = this.jad_an;
        int[] iArr = this.jad_bo;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new com.jd.ad.sdk.jad_wf.jad_an(jad_zm.jad_an("Nesting too deep at ").append(jad_fs()).toString());
            }
            this.jad_bo = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.jad_cp;
            this.jad_cp = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.jad_dq;
            this.jad_dq = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.jad_bo;
        int i3 = this.jad_an;
        this.jad_an = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract void jad_bo();

    public abstract void jad_cp();

    public abstract void jad_dq();

    public abstract void jad_er();

    public final String jad_fs() {
        int i = this.jad_an;
        int[] iArr = this.jad_bo;
        String[] strArr = this.jad_cp;
        int[] iArr2 = this.jad_dq;
        StringBuilder sb = new StringBuilder("$");
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[').append(iArr2[i2]).append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                String str = strArr[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public abstract boolean jad_hu();

    public abstract double jad_iv();

    public abstract boolean jad_jt();

    public abstract int jad_jw();

    public abstract String jad_kx();

    public abstract String jad_ly();

    public abstract int jad_mz();

    public abstract void jad_na();

    public abstract void jad_ob();
}
