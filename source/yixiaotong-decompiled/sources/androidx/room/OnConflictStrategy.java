package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@Retention(RetentionPolicy.CLASS)
public @interface OnConflictStrategy {
    public static final int ABORT = 3;

    @Deprecated
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int REPLACE = 1;

    @Deprecated
    public static final int ROLLBACK = 2;
}
