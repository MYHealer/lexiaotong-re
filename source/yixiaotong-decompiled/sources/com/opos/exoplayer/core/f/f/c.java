package com.opos.exoplayer.core.f.f;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6445a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final b f;
    public final String g;
    private final String[] h;
    private final HashMap<String, Integer> i;
    private final HashMap<String, Integer> j;
    private List<c> k;

    private c(String str, String str2, long j, long j2, b bVar, String[] strArr, String str3) {
        this.f6445a = str;
        this.b = str2;
        this.f = bVar;
        this.h = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.g = (String) com.opos.exoplayer.core.i.a.a(str3);
        this.i = new HashMap<>();
        this.j = new HashMap<>();
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int length = spannableStringBuilder.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                    i6++;
                }
                int i7 = i6 - i5;
                if (i7 > 0) {
                    spannableStringBuilder.delete(i4, i4 + i7);
                    length -= i7;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i8 = 0;
        while (true) {
            i = length - 1;
            if (i8 >= i) {
                break;
            }
            if (spannableStringBuilder.charAt(i8) == '\n') {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == ' ') {
                    spannableStringBuilder.delete(i9, i8 + 2);
                    length--;
                }
            }
            i8++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i) == ' ') {
            spannableStringBuilder.delete(i, length);
            length--;
        }
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i3) == ' ') {
                int i10 = i3 + 1;
                if (spannableStringBuilder.charAt(i10) == '\n') {
                    spannableStringBuilder.delete(i3, i10);
                    length--;
                }
            }
            i3++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == '\n') {
            spannableStringBuilder.delete(i2, length);
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    public static c a(String str) {
        return new c(null, e.a(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static c a(String str, long j, long j2, b bVar, String[] strArr, String str2) {
        return new c(str, null, j, j2, bVar, strArr, str2);
    }

    private void a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.i.clear();
        this.j.clear();
        String str2 = this.g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.c && z) {
            a(str, map).append((CharSequence) this.b);
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f6445a) && z) {
            a(str, map).append('\n');
            return;
        }
        if (!TtmlNode.TAG_METADATA.equals(this.f6445a) && a(j)) {
            boolean zEquals = "p".equals(this.f6445a);
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            for (int i = 0; i < a(); i++) {
                a(i).a(j, z || zEquals, str, map);
            }
            if (zEquals) {
                e.a(a(str, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private void a(Map<String, b> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        b bVarA;
        if (i == i2 || (bVarA = e.a(this.f, this.h, map)) == null) {
            return;
        }
        e.a(spannableStringBuilder, i, i2, bVarA);
    }

    private void a(Map<String, b> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.j.entrySet()) {
            String key = entry.getKey();
            a(map, map2.get(key), this.i.containsKey(key) ? this.i.get(key).intValue() : 0, entry.getValue().intValue());
            for (int i = 0; i < a(); i++) {
                a(i).a(map, map2);
            }
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean zEquals = "p".equals(this.f6445a);
        if (z || zEquals) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.k == null) {
            return;
        }
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).a(treeSet, z || zEquals);
        }
    }

    public int a() {
        List<c> list = this.k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public c a(int i) {
        List<c> list = this.k;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<com.opos.exoplayer.core.f.b> a(long j, Map<String, b> map, Map<String, d> map2) {
        TreeMap treeMap = new TreeMap();
        a(j, false, this.g, (Map<String, SpannableStringBuilder>) treeMap);
        a(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            d dVar = map2.get(entry.getKey());
            arrayList.add(new com.opos.exoplayer.core.f.b(a((SpannableStringBuilder) entry.getValue()), null, dVar.c, dVar.d, dVar.e, dVar.b, Integer.MIN_VALUE, dVar.f));
        }
        return arrayList;
    }

    public void a(c cVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(cVar);
    }

    public boolean a(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }

    public long[] b() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }
}
