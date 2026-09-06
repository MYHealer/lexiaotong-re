package com.byazt.jb;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface u {
    public static final u c = new u() { // from class: com.byazt.jb.u.1
        @Override // com.byazt.jb.u
        public boolean c(int i, List<ve> list) {
            return true;
        }

        @Override // com.byazt.jb.u
        public boolean c(int i, List<ve> list, boolean z) {
            return true;
        }

        @Override // com.byazt.jb.u
        public boolean c(int i, com.byazt.mk.n nVar, int i2, boolean z) throws IOException {
            nVar.x(i2);
            return true;
        }
    };

    boolean c(int i, com.byazt.mk.n nVar, int i2, boolean z) throws IOException;

    boolean c(int i, List<ve> list);

    boolean c(int i, List<ve> list, boolean z);
}
