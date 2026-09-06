package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f3977a;
        public final Object b;

        public /* synthetic */ ToStringHelper(Object obj, a aVar) {
            this(obj);
        }

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String strValueOf = String.valueOf(obj);
            this.f3977a.add(new StringBuilder(str2.length() + strValueOf.length() + 1).append(str2).append("=").append(strValueOf).toString());
            return this;
        }

        public final String toString() {
            StringBuilder sbAppend = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.f3977a.size();
            for (int i = 0; i < size; i++) {
                sbAppend.append(this.f3977a.get(i));
                if (i < size - 1) {
                    sbAppend.append(", ");
                }
            }
            return sbAppend.append('}').toString();
        }

        public ToStringHelper(Object obj) {
            this.b = Preconditions.checkNotNull(obj);
            this.f3977a = new ArrayList();
        }
    }

    public static /* synthetic */ class a {
    }

    public Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj, null);
    }
}
