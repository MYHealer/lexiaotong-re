package com.fancy;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ks {
    /* JADX WARN: Code duplicated, block: B:27:0x0041 A[Catch: Exception -> 0x00a4, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x00a4, blocks: (B:5:0x0004, B:6:0x0008, B:8:0x000c, B:13:0x0016, B:18:0x0020, B:56:0x00a1, B:27:0x0041, B:39:0x006e, B:44:0x0078, B:54:0x009e, B:53:0x0098, B:42:0x0074, B:16:0x001c, B:11:0x0012), top: B:77:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0098 A[SYNTHETIC] */
    public static Boolean _a(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        if (viewGroup == null) {
            return null;
        }
        try {
            for (ViewParent parent = viewGroup.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup5 = (ViewGroup) parent;
                if (viewGroup5 == null || !(viewGroup5 instanceof ScrollView)) {
                    ViewGroup viewGroup6 = (ViewGroup) parent;
                    if (viewGroup6 == null || !(viewGroup6 instanceof HorizontalScrollView)) {
                        ViewGroup viewGroup7 = (ViewGroup) parent;
                        if (viewGroup7 == null) {
                            viewGroup2 = (ViewGroup) parent;
                            if (viewGroup2 != null) {
                                try {
                                    if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup2)) {
                                        try {
                                            if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup2)) {
                                                try {
                                                    if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup2)) {
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        } catch (Exception unused2) {
                                        }
                                    }
                                } catch (Exception unused3) {
                                }
                            }
                            viewGroup3 = (ViewGroup) parent;
                            if (viewGroup3 == null || !(viewGroup3 instanceof AbsListView)) {
                                viewGroup4 = (ViewGroup) parent;
                                if (viewGroup4 == null) {
                                    try {
                                        if (Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup4)) {
                                            try {
                                                if (Class.forName("android.support.v7.widget.RecyclerView").isInstance(viewGroup4)) {
                                                }
                                            } catch (Exception unused4) {
                                                continue;
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                            }
                            return Boolean.FALSE;
                        }
                        try {
                            if (!Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup7)) {
                                try {
                                    if (!Class.forName("android.support.v4.widget.NestedScrollView").isInstance(viewGroup7)) {
                                        viewGroup2 = (ViewGroup) parent;
                                        if (viewGroup2 != null) {
                                            if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup2)) {
                                                if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup2)) {
                                                    if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup2)) {
                                                    }
                                                }
                                            }
                                        }
                                        viewGroup3 = (ViewGroup) parent;
                                        if (viewGroup3 == null) {
                                            return Boolean.FALSE;
                                        }
                                        viewGroup4 = (ViewGroup) parent;
                                        if (viewGroup4 == null) {
                                            if (Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup4)) {
                                                if (Class.forName("android.support.v7.widget.RecyclerView").isInstance(viewGroup4)) {
                                                }
                                            }
                                            return Boolean.FALSE;
                                        }
                                    }
                                } catch (Exception unused6) {
                                }
                            }
                        } catch (Exception unused7) {
                        }
                    }
                }
                return Boolean.TRUE;
            }
        } catch (Exception unused8) {
        }
        return null;
    }
}
