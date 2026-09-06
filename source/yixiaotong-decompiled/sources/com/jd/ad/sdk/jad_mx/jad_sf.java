package com.jd.ad.sdk.jad_mx;

import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_sf extends Exception {
    public static final StackTraceElement[] jad_fs = new StackTraceElement[0];
    public final List<Throwable> jad_an;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_bo;
    public com.jd.ad.sdk.jad_ju.jad_an jad_cp;
    public Class<?> jad_dq;
    public String jad_er;

    public static final class jad_an implements Appendable {
        public final Appendable jad_an;
        public boolean jad_bo = true;

        public jad_an(Appendable appendable) {
            this.jad_an = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            this.jad_bo = c == '\n';
            this.jad_an.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.jad_bo = z;
            this.jad_an.append(charSequence, i, i2);
            return this;
        }
    }

    public jad_sf(String str, List<Throwable> list) {
        this.jad_er = str;
        setStackTrace(jad_fs);
        this.jad_an = list;
    }

    public static void jad_an(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void jad_an(List<Throwable> list, Appendable appendable) {
        try {
            jad_bo(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void jad_bo(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof jad_sf) {
                ((jad_sf) th).jad_an(appendable);
            } else {
                jad_an(th, appendable);
            }
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sbAppend = new StringBuilder(71).append(this.jad_er).append(this.jad_dq != null ? com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ").append(this.jad_dq).toString() : "").append(this.jad_cp != null ? com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ").append(this.jad_cp).toString() : "").append(this.jad_bo != null ? com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ").append(this.jad_bo).toString() : "");
        ArrayList<Throwable> arrayList = new ArrayList();
        jad_an(this, arrayList);
        if (arrayList.isEmpty()) {
            return sbAppend.toString();
        }
        if (arrayList.size() == 1) {
            sbAppend.append("\nThere was 1 root cause:");
        } else {
            sbAppend.append("\nThere were ").append(arrayList.size()).append(" root causes:");
        }
        for (Throwable th : arrayList) {
            sbAppend.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        sbAppend.append("\n call GlideException#logRootCauses(String) for more detail");
        return sbAppend.toString();
    }

    public final void jad_an(Throwable th, List<Throwable> list) {
        if (!(th instanceof jad_sf)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((jad_sf) th).jad_an.iterator();
        while (it.hasNext()) {
            jad_an(it.next(), list);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        jad_an(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        jad_an(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        jad_an(printWriter);
    }

    public void jad_an(String str) {
        ArrayList arrayList = new ArrayList();
        jad_an(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Logger.i(str, com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Root cause (").append(i2).append(" of ").append(size).append(")").toString(), arrayList.get(i));
            i = i2;
        }
    }

    public final void jad_an(Appendable appendable) {
        jad_an(this, appendable);
        jad_an(this.jad_an, new jad_an(appendable));
    }
}
