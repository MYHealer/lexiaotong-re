package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.api.UbixDefaultConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0o0Oo {
    private static final String OooO00o = "-------广告_Cache：";
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<o00OOO0O>> OooO0O0 = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, CopyOnWriteArraySet<String>> OooO0OO = new ConcurrentHashMap<>();

    private static int OooO00o(String str, int i) {
        CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayList;
        CopyOnWriteArraySet<String> copyOnWriteArraySet = OooO0OO.get(str);
        if (copyOnWriteArraySet != null) {
            for (String str2 : copyOnWriteArraySet) {
                if (OooO0O0.containsKey(str2) && (copyOnWriteArrayList = OooO0O0.get(str2)) != null && copyOnWriteArrayList.size() > 0) {
                    copyOnWriteArrayList.clear();
                    i--;
                }
            }
            OooO0OO.remove(str);
        }
        return i;
    }

    private static String OooO00o(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "1":
            case "2":
            case "6":
            case "7":
                return "1";
            case "3":
            case "4":
                return "4";
            case "5":
            case "10":
                return "3";
            case "03":
            case "12":
                return "2";
            default:
                return "5";
        }
    }

    public static Set<Integer> OooO00o(o0O0OOO0 o0o0ooo0) {
        HashSet hashSet = new HashSet();
        if (o0o0ooo0 != null && !TextUtils.isEmpty(o0o0ooo0.OooO0o0)) {
            for (String str : o0o0ooo0.OooO0o0.split("#")) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (Exception e) {
                    ooooO000.OooO0O0(OooO00o, e.getMessage());
                }
            }
        }
        return hashSet;
    }

    public static synchronized ConcurrentHashMap<String, o00OOO0O> OooO00o(o00O0 o00o0, ConcurrentHashMap<String, o00OOO0O> concurrentHashMap) {
        CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayListOooO00o = OooO00o(o00o0);
        if (copyOnWriteArrayListOooO00o == null) {
            return concurrentHashMap;
        }
        return OooO00o(o00o0, concurrentHashMap, copyOnWriteArrayListOooO00o);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[Catch: all -> 0x007f, Exception -> 0x0081, TRY_ENTER, TryCatch #1 {Exception -> 0x0081, blocks: (B:6:0x000a, B:11:0x0013, B:13:0x0019, B:14:0x001f, B:16:0x0025, B:18:0x0037, B:20:0x003f, B:22:0x0050, B:23:0x0055, B:33:0x0076), top: B:46:0x000a, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0019 A[Catch: all -> 0x007f, Exception -> 0x0081, TryCatch #1 {Exception -> 0x0081, blocks: (B:6:0x000a, B:11:0x0013, B:13:0x0019, B:14:0x001f, B:16:0x0025, B:18:0x0037, B:20:0x003f, B:22:0x0050, B:23:0x0055, B:33:0x0076), top: B:46:0x000a, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0025 A[Catch: all -> 0x007f, Exception -> 0x0081, TryCatch #1 {Exception -> 0x0081, blocks: (B:6:0x000a, B:11:0x0013, B:13:0x0019, B:14:0x001f, B:16:0x0025, B:18:0x0037, B:20:0x003f, B:22:0x0050, B:23:0x0055, B:33:0x0076), top: B:46:0x000a, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0065 A[Catch: Exception -> 0x0073, all -> 0x007f, LOOP:1: B:26:0x005f->B:28:0x0065, LOOP_END, TryCatch #0 {Exception -> 0x0073, blocks: (B:25:0x005b, B:26:0x005f, B:28:0x0065, B:29:0x006f), top: B:44:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0011 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0011, please report this as an issue */
    private static synchronized ConcurrentHashMap<String, o00OOO0O> OooO00o(o00O0 o00o0, ConcurrentHashMap<String, o00OOO0O> concurrentHashMap, CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayList) {
        ArrayList arrayList;
        int i;
        Iterator it;
        o00OOO0O o00ooo0o;
        if (concurrentHashMap != null) {
            if (o00o0.OooO0OO.OooOO0o == 2) {
                return concurrentHashMap;
            }
            if (copyOnWriteArrayList.size() > 0) {
                arrayList = new ArrayList();
                for (i = 0; i < copyOnWriteArrayList.size(); i++) {
                    o00ooo0o = copyOnWriteArrayList.get(i);
                    if (!o00ooo0o.OooO0oO.equals(o00o0.OooO0OO.OooO)) {
                    }
                }
                it = arrayList.iterator();
                while (it.hasNext()) {
                    copyOnWriteArrayList.remove((o00OOO0O) it.next());
                }
                arrayList.clear();
                return concurrentHashMap;
            }
            return concurrentHashMap;
        }
        concurrentHashMap = new ConcurrentHashMap<>();
        try {
            if (o00o0.OooO0OO.OooOO0o == 2) {
                return concurrentHashMap;
            }
            if (copyOnWriteArrayList.size() > 0) {
                arrayList = new ArrayList();
                while (i < copyOnWriteArrayList.size()) {
                    o00ooo0o = copyOnWriteArrayList.get(i);
                    if (!o00ooo0o.OooO0oO.equals(o00o0.OooO0OO.OooO) && !concurrentHashMap.containsKey(o00ooo0o.OooO0oo)) {
                        if (System.currentTimeMillis() - o00ooo0o.OooO0OO < o00ooo0o.OooO0Oo * 60000) {
                            concurrentHashMap.put(o00ooo0o.OooO0oo, o00ooo0o);
                        }
                        arrayList.add(o00ooo0o);
                    }
                }
                try {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        copyOnWriteArrayList.remove((o00OOO0O) it.next());
                    }
                    arrayList.clear();
                } catch (Exception e) {
                    ooooO000.OooO0O0(OooO00o, e.getMessage());
                }
                return concurrentHashMap;
            }
        } catch (Exception e2) {
            ooooO000.OooO0O0(OooO00o, e2.getMessage());
        }
        return concurrentHashMap;
        throw th;
    }

    public static CopyOnWriteArrayList<o00OOO0O> OooO00o(o00O0 o00o0) {
        try {
            String str = o00o0.OooO0OO.OooO;
            if (TextUtils.isEmpty(str) || Math.min(OooO0O0(o00o0), UbixDefaultConstants.cacheLimitCount) <= 0) {
                return null;
            }
            if (!OooO0O0.containsKey(str) || OooO0O0.get(str) == null) {
                OooO0O0.put(str, new CopyOnWriteArrayList<>());
            }
            return OooO0O0.get(str);
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
            return null;
        }
    }

    private static synchronized void OooO00o() {
        int i = UbixDefaultConstants.cacheLimitCount;
        try {
            Iterator<CopyOnWriteArrayList<o00OOO0O>> it = OooO0O0.values().iterator();
            int size = 0;
            while (it.hasNext()) {
                size += it.next().size();
            }
            if (size > i) {
                size = 0;
                for (CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayList : OooO0O0.values()) {
                    if (!copyOnWriteArrayList.isEmpty()) {
                        o00OOO0O o00ooo0o = copyOnWriteArrayList.get(0);
                        copyOnWriteArrayList.clear();
                        copyOnWriteArrayList.add(o00ooo0o);
                        size++;
                    }
                }
            }
            if (size > i) {
                int iOooO00o = OooO00o("5", size);
                if (iOooO00o > i) {
                    iOooO00o = OooO00o("4", iOooO00o);
                }
                if (iOooO00o > i) {
                    iOooO00o = OooO00o("3", iOooO00o);
                }
                if (iOooO00o > i) {
                    iOooO00o = OooO00o("2", iOooO00o);
                }
                if (iOooO00o > i) {
                    OooO0O0.clear();
                }
            }
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
        }
    }

    public static synchronized void OooO00o(o00O0 o00o0, o00O o00o) {
        CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayListOooO00o = OooO00o(o00o0);
        if (copyOnWriteArrayListOooO00o == null) {
            o00o.destory();
        } else {
            OooO00o(o00o0, o00o, copyOnWriteArrayListOooO00o);
            OooO00o();
        }
    }

    private static synchronized void OooO00o(o00O0 o00o0, o00O o00o, CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayList) {
        try {
            if (o00o0.OooO0OO.OooOO0o == 2) {
                ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("c4"));
                o00o.destory();
                return;
            }
            int iMin = Math.min(OooO0O0(o00o0), UbixDefaultConstants.cacheLimitCount);
            if (iMin <= 0) {
                o00o.destory();
                return;
            }
            Set<Integer> set = o00o0.OooO0OO.OooOOO0;
            if (set != null && set.size() > 0 && o00o0.OooO0OO.OooOOO0.contains(Integer.valueOf(o00o.mBaseAdConfig.OooO00o.OooO0OO))) {
                o00o.destory();
                return;
            }
            o00O000 o00o000 = o00o.mBaseAdConfig;
            int i = o00o000.OooO00o.OooOO0O;
            long j = (i == 0 || i == 2) ? o00o000.OooO0OO : o00o000.OooO0o;
            o00OOO0O o00ooo0o = new o00OOO0O();
            o00ooo0o.OooO0OO = System.currentTimeMillis();
            o00ooo0o.OooO00o = j;
            o00ooo0o.OooO0O0 = o00o;
            o00ooo0o.OooO0o = o00o0.OooO0Oo.OooO0OO;
            o00ooo0o.OooO0o0 = o00o0.OooOO0O;
            o00ooo0o.OooO = o00o0.OooO00o;
            o00O00O o00o00o = o00o0.OooO0OO;
            o00ooo0o.OooO0Oo = o00o00o.OooOO0O;
            o00ooo0o.OooO0oO = o00o00o.OooO;
            o00ooo0o.OooO0oo = o00o0.OooO0OO.OooO + o00o.mBaseAdConfig.OooO00o.OooO0o0;
            copyOnWriteArrayList.add(0, o00ooo0o);
            if (copyOnWriteArrayList.size() > iMin) {
                copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1).OooO0O0.destory();
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
            }
            OooO0OO(o00o0);
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
        }
    }

    public static synchronized void OooO00o(o00O0 o00o0, Map<String, o00OOO0O> map) {
        CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayListOooO00o = OooO00o(o00o0);
        if (copyOnWriteArrayListOooO00o != null) {
            OooO00o(o00o0, map, copyOnWriteArrayListOooO00o);
            OooO00o();
            if (ooooO000.OooO00o) {
                OooO0O0();
            }
            return;
        }
        try {
            Iterator<o00OOO0O> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().OooO0O0.destory();
            }
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
        }
    }

    private static synchronized void OooO00o(o00O0 o00o0, Map<String, o00OOO0O> map, CopyOnWriteArrayList<o00OOO0O> copyOnWriteArrayList) {
        try {
            if (o00o0.OooO0OO.OooOO0o == 2) {
                ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("c11"));
                Iterator<Map.Entry<String, o00OOO0O>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().OooO0O0.destory();
                }
                return;
            }
            int iMin = Math.min(OooO0O0(o00o0), UbixDefaultConstants.cacheLimitCount);
            if (iMin <= 0) {
                return;
            }
            if (map != null) {
                for (Map.Entry<String, o00OOO0O> entry : map.entrySet()) {
                    Set<Integer> set = o00o0.OooO0OO.OooOOO0;
                    if (set == null || set.size() <= 0 || !o00o0.OooO0OO.OooOOO0.contains(Integer.valueOf(entry.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0OO))) {
                        copyOnWriteArrayList.add(entry.getValue());
                    }
                }
                List listAsList = Arrays.asList(copyOnWriteArrayList.toArray());
                Collections.sort(listAsList);
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList.addAll(listAsList);
                int size = copyOnWriteArrayList.size() - iMin;
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1).OooO0O0.destory();
                        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
                    }
                }
            }
            OooO0OO(o00o0);
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
        }
    }

    public static void OooO00o(o00O0 o00o0, Set<Integer> set) {
        int i;
        if (set == null) {
            set = new HashSet<>();
        }
        if (!o00o0.OooO0Oo.OooO0O0.equals("03")) {
            set.add(33);
        }
        if (o00o0.OooO0Oo.OooO0O0.equals("1")) {
            set.add(18);
            set.add(9);
            i = 2;
        } else if (!o00o0.OooO0Oo.OooO0O0.equals("5")) {
            return;
        } else {
            i = 15;
        }
        set.add(Integer.valueOf(i));
        set.add(14);
        set.add(30);
    }

    private static int OooO0O0(o00O0 o00o0) {
        try {
            return o00o0.OooOOOO.OooO0o0[0].OooOOO.OooO0Oo;
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
            return 5;
        }
    }

    public static void OooO0O0() {
        try {
            ooooO000.OooO0OO("-------printAllCachePools:", "-----------------start---------------------");
            for (Map.Entry<String, CopyOnWriteArrayList<o00OOO0O>> entry : OooO0O0.entrySet()) {
                ooooO000.OooO0OO("-------printAllCachePools:", "UID: " + entry.getKey() + ", Cache Size: " + entry.getValue().size());
            }
            ooooO000.OooO0OO("-------printAllCachePools:", "-----------------done---------------------");
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, e.getMessage());
        }
    }

    private static void OooO0OO(o00O0 o00o0) {
        String strOooO00o = OooO00o(o00o0.OooO0Oo.OooO0O0);
        CopyOnWriteArraySet<String> copyOnWriteArraySet = OooO0OO.get(strOooO00o);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            OooO0OO.put(strOooO00o, copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(o00o0.OooO0OO.OooO);
    }
}
