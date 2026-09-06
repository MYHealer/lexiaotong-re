package com.opos.cmn.func.dl.base.e;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f6132a;
    private File b;
    private volatile int c = 0;

    public d(File file, File file2) {
        this.f6132a = file;
        this.b = file2;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final synchronized List<c> a() {
        ArrayList arrayList;
        FileInputStream fileInputStream;
        ArrayList arrayList2;
        arrayList = null;
        closeable = null;
        closeable = null;
        closeable = null;
        Closeable closeable = null;
        arrayList = null;
        if (com.opos.cmn.an.e.b.a.a(this.f6132a) && com.opos.cmn.an.e.b.a.a(this.b)) {
            try {
                fileInputStream = new FileInputStream(this.f6132a);
                try {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                        try {
                            try {
                                int i = dataInputStream.readInt();
                                arrayList2 = new ArrayList(i);
                                for (int i2 = 0; i2 < i; i2++) {
                                    try {
                                        arrayList2.add(new c(i2, dataInputStream.readLong(), dataInputStream.readLong(), dataInputStream.readLong()));
                                    } catch (Exception unused) {
                                        closeable = dataInputStream;
                                        com.opos.cmn.an.f.a.c("ThreadStoreImpl", "read pos file error,delete pos file!");
                                        com.opos.cmn.an.e.b.a.e(this.b);
                                        com.opos.cmn.func.dl.base.i.a.a(closeable, fileInputStream);
                                        arrayList = arrayList2;
                                        return arrayList;
                                    }
                                }
                                com.opos.cmn.func.dl.base.i.a.a(dataInputStream, fileInputStream);
                            } catch (Throwable th) {
                                th = th;
                                closeable = dataInputStream;
                                com.opos.cmn.func.dl.base.i.a.a(closeable, fileInputStream);
                                throw th;
                            }
                        } catch (Exception unused2) {
                            arrayList2 = null;
                        }
                    } catch (Exception unused3) {
                        arrayList2 = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
                fileInputStream = null;
                arrayList2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final synchronized void a(List<c> list) {
        OutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        if (list != null) {
            if (list.size() > 0) {
                this.c++;
                if (this.c % 25 == 0) {
                    OutputStream outputStream = null;
                    try {
                        int size = list.size();
                        com.opos.cmn.func.dl.base.i.a.a(this.f6132a);
                        fileOutputStream = new FileOutputStream(this.f6132a);
                        try {
                            dataOutputStream = new DataOutputStream(fileOutputStream);
                            try {
                                dataOutputStream.writeInt(size);
                                for (int i = 0; i < size; i++) {
                                    c cVar = list.get(i);
                                    dataOutputStream.writeLong(cVar.b);
                                    dataOutputStream.writeLong(cVar.d);
                                    dataOutputStream.writeLong(cVar.c);
                                }
                                com.opos.cmn.func.dl.base.i.a.a(dataOutputStream, fileOutputStream);
                            } catch (Exception e) {
                                e = e;
                                outputStream = fileOutputStream;
                                try {
                                    com.opos.cmn.an.f.a.c("ThreadStoreImpl", "saveThreadInfos ", e);
                                    throw new DlException(1004, e);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = outputStream;
                                    outputStream = dataOutputStream;
                                    com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream = dataOutputStream;
                                com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        dataOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                }
            }
        }
    }
}
