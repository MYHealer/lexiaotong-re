package com.kwad.framework.filedownloader.f;

import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.ads.ez;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {
    public final int aDs;
    public final long aDt;
    public final boolean aDu;
    public final boolean aDv;
    public final int aDw;
    public final boolean aDx;
    public final boolean aDy;

    public static class a {
        private static final e aDz = new e(0);
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e Dz() {
        return a.aDz;
    }

    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0075 A[Catch: all -> 0x0188, TryCatch #6 {all -> 0x0188, blocks: (B:7:0x002d, B:8:0x0034, B:9:0x003a, B:10:0x0040, B:11:0x0046, B:12:0x004a, B:37:0x0071, B:39:0x0075, B:41:0x0079, B:42:0x0081), top: B:95:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0079 A[Catch: all -> 0x0188, TryCatch #6 {all -> 0x0188, blocks: (B:7:0x002d, B:8:0x0034, B:9:0x003a, B:10:0x0040, B:11:0x0046, B:12:0x004a, B:37:0x0071, B:39:0x0075, B:41:0x0079, B:42:0x0081), top: B:95:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081 A[Catch: all -> 0x0188, TRY_LEAVE, TryCatch #6 {all -> 0x0188, blocks: (B:7:0x002d, B:8:0x0034, B:9:0x003a, B:10:0x0040, B:11:0x0046, B:12:0x004a, B:37:0x0071, B:39:0x0075, B:41:0x0079, B:42:0x0081), top: B:95:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:74:0x0120  */
    /* JADX WARN: Code duplicated, block: B:76:0x0125  */
    /* JADX WARN: Code duplicated, block: B:78:0x012b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0147  */
    /* JADX WARN: Code duplicated, block: B:87:0x014e  */
    private e() throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpen;
        String property;
        String property2;
        String property3;
        String property4;
        String property5;
        String str;
        String property6;
        int i;
        if (c.Dx() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Properties properties = new Properties();
        try {
            inputStreamOpen = c.Dx().getAssets().open("filedownloader.properties");
            if (inputStreamOpen != null) {
                try {
                    try {
                        properties.load(inputStreamOpen);
                        property = properties.getProperty("http.lenient");
                        try {
                            property2 = properties.getProperty("download.min-progress-step");
                            try {
                                property3 = properties.getProperty("download.min-progress-time");
                                try {
                                    property4 = properties.getProperty("download.max-network-thread-count");
                                    try {
                                        property5 = properties.getProperty("file.non-pre-allocation");
                                        try {
                                            property6 = properties.getProperty("broadcast.completed");
                                            str = property;
                                        } catch (IOException e) {
                                            e = e;
                                            if (e instanceof FileNotFoundException) {
                                                if (d.aDr) {
                                                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                                }
                                            } else {
                                                e.printStackTrace();
                                            }
                                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                            str = property;
                                            property6 = null;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        property5 = null;
                                        if (e instanceof FileNotFoundException) {
                                            if (d.aDr) {
                                                d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                            }
                                        } else {
                                            e.printStackTrace();
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                        str = property;
                                        property6 = null;
                                        if (str == null) {
                                            if (str.equals(ez.Code)) {
                                            }
                                            this.aDu = str.equals(ez.Code);
                                            i = 0;
                                        } else {
                                            i = 0;
                                            this.aDu = false;
                                        }
                                        this.aDv = true;
                                        if (property2 != null) {
                                            this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
                                        } else {
                                            this.aDs = 65536;
                                        }
                                        if (property3 != null) {
                                            this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
                                        } else {
                                            this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                        }
                                        if (property4 != null) {
                                            this.aDw = dd(Integer.valueOf(property4).intValue());
                                        } else {
                                            this.aDw = 3;
                                        }
                                        if (property5 == null) {
                                            if (property5.equals(ez.Code)) {
                                            }
                                            this.aDx = property5.equals(ez.Code);
                                        } else {
                                            this.aDx = false;
                                        }
                                        if (property6 == null) {
                                            if (property6.equals(ez.Code)) {
                                            }
                                            this.aDy = property6.equals(ez.Code);
                                        } else {
                                            this.aDy = false;
                                        }
                                        if (d.aDr) {
                                            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    property4 = null;
                                    property5 = null;
                                    if (e instanceof FileNotFoundException) {
                                        if (d.aDr) {
                                            d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                        }
                                    } else {
                                        e.printStackTrace();
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                    str = property;
                                    property6 = null;
                                    if (str == null) {
                                        if (str.equals(ez.Code)) {
                                        }
                                        this.aDu = str.equals(ez.Code);
                                        i = 0;
                                    } else {
                                        i = 0;
                                        this.aDu = false;
                                    }
                                    this.aDv = true;
                                    if (property2 != null) {
                                        this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
                                    } else {
                                        this.aDs = 65536;
                                    }
                                    if (property3 != null) {
                                        this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
                                    } else {
                                        this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                    }
                                    if (property4 != null) {
                                        this.aDw = dd(Integer.valueOf(property4).intValue());
                                    } else {
                                        this.aDw = 3;
                                    }
                                    if (property5 == null) {
                                        if (property5.equals(ez.Code)) {
                                        }
                                        this.aDx = property5.equals(ez.Code);
                                    } else {
                                        this.aDx = false;
                                    }
                                    if (property6 == null) {
                                        if (property6.equals(ez.Code)) {
                                        }
                                        this.aDy = property6.equals(ez.Code);
                                    } else {
                                        this.aDy = false;
                                    }
                                    if (d.aDr) {
                                        d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
                                    }
                                }
                            } catch (IOException e4) {
                                e = e4;
                                property3 = null;
                                property4 = null;
                                property5 = null;
                                if (e instanceof FileNotFoundException) {
                                    if (d.aDr) {
                                        d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                    }
                                } else {
                                    e.printStackTrace();
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                str = property;
                                property6 = null;
                                if (str == null) {
                                    if (str.equals(ez.Code)) {
                                    }
                                    this.aDu = str.equals(ez.Code);
                                    i = 0;
                                } else {
                                    i = 0;
                                    this.aDu = false;
                                }
                                this.aDv = true;
                                if (property2 != null) {
                                    this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
                                } else {
                                    this.aDs = 65536;
                                }
                                if (property3 != null) {
                                    this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
                                } else {
                                    this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                }
                                if (property4 != null) {
                                    this.aDw = dd(Integer.valueOf(property4).intValue());
                                } else {
                                    this.aDw = 3;
                                }
                                if (property5 == null) {
                                    if (property5.equals(ez.Code)) {
                                    }
                                    this.aDx = property5.equals(ez.Code);
                                } else {
                                    this.aDx = false;
                                }
                                if (property6 == null) {
                                    if (property6.equals(ez.Code)) {
                                    }
                                    this.aDy = property6.equals(ez.Code);
                                } else {
                                    this.aDy = false;
                                }
                                if (d.aDr) {
                                    d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
                                }
                            }
                        } catch (IOException e5) {
                            e = e5;
                            property2 = null;
                            property3 = null;
                            property4 = null;
                            property5 = null;
                            if (e instanceof FileNotFoundException) {
                                if (d.aDr) {
                                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                }
                            } else {
                                e.printStackTrace();
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                            str = property;
                            property6 = null;
                            if (str == null) {
                                if (str.equals(ez.Code)) {
                                }
                                this.aDu = str.equals(ez.Code);
                                i = 0;
                            } else {
                                i = 0;
                                this.aDu = false;
                            }
                            this.aDv = true;
                            if (property2 != null) {
                                this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
                            } else {
                                this.aDs = 65536;
                            }
                            if (property3 != null) {
                                this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
                            } else {
                                this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                            }
                            if (property4 != null) {
                                this.aDw = dd(Integer.valueOf(property4).intValue());
                            } else {
                                this.aDw = 3;
                            }
                            if (property5 == null) {
                                if (property5.equals(ez.Code)) {
                                }
                                this.aDx = property5.equals(ez.Code);
                            } else {
                                this.aDx = false;
                            }
                            if (property6 == null) {
                                if (property6.equals(ez.Code)) {
                                }
                                this.aDy = property6.equals(ez.Code);
                            } else {
                                this.aDy = false;
                            }
                            if (d.aDr) {
                                d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        property = null;
                        property2 = null;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                            if (d.aDr) {
                                d.c(e.class, "not found filedownloader.properties", new Object[0]);
                            }
                        } else {
                            e.printStackTrace();
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        property6 = null;
                        if (str == null) {
                            if (str.equals(ez.Code)) {
                            }
                            this.aDu = str.equals(ez.Code);
                            i = 0;
                        } else {
                            i = 0;
                            this.aDu = false;
                        }
                        this.aDv = true;
                        if (property2 != null) {
                            this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
                        } else {
                            this.aDs = 65536;
                        }
                        if (property3 != null) {
                            this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
                        } else {
                            this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                        }
                        if (property4 != null) {
                            this.aDw = dd(Integer.valueOf(property4).intValue());
                        } else {
                            this.aDw = 3;
                        }
                        if (property5 == null) {
                            if (property5.equals(ez.Code)) {
                            }
                            this.aDx = property5.equals(ez.Code);
                        } else {
                            this.aDx = false;
                        }
                        if (property6 == null) {
                            if (property6.equals(ez.Code)) {
                            }
                            this.aDy = property6.equals(ez.Code);
                        } else {
                            this.aDy = false;
                        }
                        if (d.aDr) {
                            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } else {
                property6 = null;
                str = null;
                property2 = null;
                property3 = null;
                property4 = null;
                property5 = null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
        } catch (IOException e7) {
            e = e7;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (str == null) {
            i = 0;
            this.aDu = false;
        } else {
            if (str.equals(ez.Code) && !str.equals(ez.V)) {
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", "http.lenient", ez.Code, ez.V));
            }
            this.aDu = str.equals(ez.Code);
            i = 0;
        }
        this.aDv = true;
        if (property2 != null) {
            this.aDs = Math.max(i, Integer.valueOf(property2).intValue());
        } else {
            this.aDs = 65536;
        }
        if (property3 != null) {
            this.aDt = Math.max(0L, Long.valueOf(property3).longValue());
        } else {
            this.aDt = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
        if (property4 != null) {
            this.aDw = dd(Integer.valueOf(property4).intValue());
        } else {
            this.aDw = 3;
        }
        if (property5 == null) {
            this.aDx = false;
        } else {
            if (property5.equals(ez.Code) && !property5.equals(ez.V)) {
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", "file.non-pre-allocation", ez.Code, ez.V));
            }
            this.aDx = property5.equals(ez.Code);
        }
        if (property6 == null) {
            this.aDy = false;
        } else {
            if (property6.equals(ez.Code) && !property6.equals(ez.V)) {
                throw new IllegalStateException(f.c(r10, "broadcast.completed", ez.Code, ez.V));
            }
            this.aDy = property6.equals(ez.Code);
        }
        if (d.aDr) {
            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "http.lenient", Boolean.valueOf(this.aDu), "process.non-separate", true, "download.min-progress-step", Integer.valueOf(this.aDs), "download.min-progress-time", Long.valueOf(this.aDt), "download.max-network-thread-count", Integer.valueOf(this.aDw));
        }
    }

    public static int dd(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i > 0) {
            return i;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }
}
