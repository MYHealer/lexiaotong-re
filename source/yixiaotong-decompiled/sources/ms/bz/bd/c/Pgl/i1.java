package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class i1 implements FilenameFilter {
    final /* synthetic */ String c;

    i1(String str) {
        this.c = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.c);
    }
}
