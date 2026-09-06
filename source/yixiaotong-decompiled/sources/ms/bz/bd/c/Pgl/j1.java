package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.byazt.bzd.sp;
import com.byazt.nys.tt;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class j1 {
    protected final HashSet c = new HashSet();
    protected final h1.pblb tt;
    protected final h1.pgla ve;

    protected j1(h1.pblb pblbVar, pbld pbldVar) {
        this.tt = pblbVar;
        this.ve = pbldVar;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        c(context, "Pglbizssdk_ml", null);
    }

    private void c(Context context, String str, String str2) {
        if (this.c.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((x1) this.tt).getClass();
            sp.c(str);
            this.c.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((x1) this.tt).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            File file = (str2 == null || str2.length() == 0) ? new File(tt.c(context, "lib", 0), strMapLibraryName) : new File(tt.c(context, "lib", 0), strMapLibraryName + "." + str2);
            if (!file.exists()) {
                File fileC = tt.c(context, "lib", 0);
                ((x1) this.tt).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                File file2 = (str2 == null || str2.length() == 0) ? new File(tt.c(context, "lib", 0), strMapLibraryName2) : new File(tt.c(context, "lib", 0), strMapLibraryName2 + "." + str2);
                ((x1) this.tt).getClass();
                File[] fileArrListFiles = fileC.listFiles(new i1((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                h1.pgla pglaVar = this.ve;
                String[] strArrC = ((x1) this.tt).c();
                ((x1) this.tt).getClass();
                ((pbld) pglaVar).c(context, strArrC, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file, this);
            }
            h1.pblb pblbVar = this.tt;
            String absolutePath = file.getAbsolutePath();
            ((x1) pblbVar).getClass();
            System.load(absolutePath);
            this.c.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
