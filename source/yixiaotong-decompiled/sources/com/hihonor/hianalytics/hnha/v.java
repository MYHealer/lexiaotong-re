package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class v {
    public static int a(List<p0> list, long j) {
        int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.a("StoreUtils", "findTagTypeIndexByID empty list");
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i).a() == j) {
                return i;
            }
        }
        return -1;
    }

    public static ContentValues a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_dataState", Integer.valueOf(i));
        return contentValues;
    }

    public static Pair<String, String[]> a() throws IllegalAccessException, InvocationTargetException {
        LinkedList linkedList = new LinkedList();
        List<String> listB = SystemUtils.b();
        for (o0 o0Var : j.a()) {
            long jA = o0Var.a();
            if (jA > 0 && !o0Var.c() && !listB.contains(o0Var.c)) {
                linkedList.add(Long.valueOf(jA));
            }
        }
        String[] strArr = !linkedList.isEmpty() ? new String[linkedList.size()] : null;
        long jB = com.hihonor.hianalytics.util.r.b() - 360000;
        StringBuilder sb = new StringBuilder("_state = 1 AND (_uTime < ");
        sb.append(jB);
        if (strArr != null) {
            sb.append(" OR _sPId IN (");
            int i = 0;
            while (i < strArr.length) {
                strArr[i] = String.valueOf(linkedList.get(i));
                sb.append("?").append(i == strArr.length + (-1) ? ")" : ",");
                i++;
            }
        }
        sb.append(")");
        return Pair.create(sb.toString(), strArr);
    }

    public static Pair<String, String[]> a(long j) {
        return Pair.create("_sTime < ?", new String[]{String.valueOf(j)});
    }

    public static Pair<String, String[]> a(String str) {
        return Pair.create("_eTtId IN (SELECT _id FROM tagTypes WHERE _tag = ?)", new String[]{str});
    }

    public static Pair<String, String[]> a(String str, Set<String> set, Set<String> set2, Set<String> set3) {
        int size = set.size();
        int size2 = set2.size();
        int size3 = set3.size();
        int i = size + size2 + size3;
        String[] strArr = null;
        if (TextUtils.isEmpty(str) || i <= 0) {
            j2.g("StoreUtils", "getStatQuery illegal tableName=" + str + ",totalSize=" + i);
            return Pair.create(null, null);
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (size3 > 0 && size3 < 600) {
            String[] strArr2 = new String[size3];
            sb.append("SELECT * FROM ").append(str).append(" WHERE _reportType IN(");
            Iterator<String> it = set3.iterator();
            while (it.hasNext()) {
                int i3 = i2 + 1;
                strArr2[i2] = it.next();
                sb.append("?").append(i3 == size3 ? ")" : ",");
                i2 = i3;
            }
            sb.append(" AND _state = 0 AND _dataState != 1");
            return Pair.create(sb.toString(), strArr2);
        }
        if (size <= 0 || size >= 600) {
            if (size2 >= 600 || size2 <= 0) {
                sb.append("SELECT * FROM ").append(str).append(" WHERE _state = 0 AND _dataState != 1");
            } else {
                String[] strArr3 = new String[size2];
                sb.append("SELECT * FROM ").append(str).append(" WHERE _sTime IN(");
                Iterator<String> it2 = set2.iterator();
                while (it2.hasNext()) {
                    int i4 = i2 + 1;
                    strArr3[i2] = it2.next();
                    sb.append("?").append(i4 == size2 ? ")" : ",");
                    i2 = i4;
                }
                strArr = strArr3;
            }
            return Pair.create(sb.toString(), strArr);
        }
        String[] strArr4 = new String[size];
        sb.append("SELECT * FROM ").append(str).append(" WHERE _statType IN(");
        Iterator<String> it3 = set.iterator();
        while (it3.hasNext()) {
            int i5 = i2 + 1;
            strArr4[i2] = it3.next();
            sb.append("?").append(i5 == size ? ")" : ",");
            i2 = i5;
        }
        strArr = strArr4;
        sb.append(" AND _state = 0 AND _dataState != 1");
        return Pair.create(sb.toString(), strArr);
    }

    public static Pair<String, String[]> a(List<p0> list, long j, long j2) {
        int size = list.size();
        String[] strArr = new String[size + 2];
        int i = 0;
        strArr[0] = String.valueOf(j);
        strArr[1] = String.valueOf(j2);
        StringBuilder sb = new StringBuilder("SELECT idsInfo._id as idsId,idsInfo._cTime as idsTime,_iiTtId,_appId,_url,_idsInfo,idsInfo._crMd as idsCMd,idsInfo._kMd as idsKMd,idsInfo._ksMd as idsKsMd,events._id as evtId,events._cTime as evtCTime,_cTimeZone,_uTime,_evtId,_sourceType,_cnt,_state,_sId,_sState,_reqId,_eTtId,_evtAppId,events._crMd as evtCMd,events._kMd as evtKMd,events._ksMd as evtKsMd FROM events INNER JOIN idsInfo ON events._eIdsId = idsInfo._id WHERE _reqId IS NULL AND evtId >? AND evtId <? AND _state IN (0,2) AND _dataState != 1 AND events._eTtId IN (");
        while (i < size) {
            p0 p0Var = list.get(i);
            strArr[i + 2] = String.valueOf(p0Var == null ? 0L : p0Var.a());
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i++;
        }
        sb.append(" ORDER BY evtId ASC");
        return Pair.create(sb.toString(), strArr);
    }

    public static Pair<String, String[]> a(List<p0> list, List<String> list2) {
        int size = list.size();
        int size2 = list2.size();
        String[] strArr = new String[size + size2];
        StringBuilder sb = new StringBuilder("SELECT idsInfo._id as idsId,idsInfo._cTime as idsTime,_iiTtId,_appId,_url,_idsInfo,idsInfo._crMd as idsCMd,idsInfo._kMd as idsKMd,idsInfo._ksMd as idsKsMd,events._id as evtId,events._cTime as evtCTime,_cTimeZone,_uTime,_evtId,_sourceType,_cnt,_state,_sId,_sState,_reqId,_eTtId,_evtAppId,events._crMd as evtCMd,events._kMd as evtKMd,events._ksMd as evtKsMd FROM events INNER JOIN idsInfo ON events._eIdsId = idsInfo._id WHERE _reqId IS NOT NULL AND _state IN (0,2) AND _dataState != 1 AND events._eTtId IN (");
        int i = 0;
        int i2 = 0;
        while (true) {
            String str = ")";
            if (i2 >= size) {
                break;
            }
            p0 p0Var = list.get(i2);
            strArr[i2] = String.valueOf(p0Var == null ? 0L : p0Var.a());
            StringBuilder sbAppend = sb.append("?");
            if (i2 != size - 1) {
                str = ",";
            }
            sbAppend.append(str);
            i2++;
        }
        sb.append(" AND _reqId IN (");
        while (i < size2) {
            strArr[i + size] = list2.get(i);
            sb.append("?").append(i == size2 + (-1) ? ")" : ",");
            i++;
        }
        sb.append(" ORDER BY evtId ASC");
        return Pair.create(sb.toString(), strArr);
    }

    public static String a(int i, int i2) {
        return "SELECT events._id,events._cTime as eTime,events._uTime,events._cTimeZone,events._evtId,events._sourceType,events._cnt,events._state,events._sId,events._sState,events._reqId,tagTypes._tag,tagTypes._type FROM events INNER JOIN tagTypes ON events._eTtId = tagTypes._id WHERE events._state IN (0,2) AND events._dataState != 1 ORDER BY eTime ASC LIMIT " + Math.max(i, 1) + " OFFSET " + Math.max(i2, 0);
    }

    public static List<h3> a(List<h3> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (h3 h3Var : list) {
            if (h3Var.g()) {
                linkedList.add(h3Var);
            }
        }
        return linkedList;
    }

    public static ContentValues b(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_state", Integer.valueOf(i));
        contentValues.put("_uTime", Long.valueOf(System.currentTimeMillis()));
        if (i == 1) {
            contentValues.put("_sPId", Long.valueOf(j.b().a()));
        } else {
            contentValues.put("_sPId", (Integer) 0);
        }
        return contentValues;
    }

    public static Pair<String, String[]> b() {
        return Pair.create("_state = 1 AND (_uTime < " + (com.hihonor.hianalytics.util.r.b() - 360000) + " OR _sPId IN (SELECT _id FROM processes WHERE _pName=\"" + j.b().c + "\"))", null);
    }

    public static Pair<String, String[]> b(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        StringBuilder sb = new StringBuilder("SELECT _eIdsId,COUNT(*) as totalCount FROM events WHERE _eIdsId IN (");
        int i = 0;
        while (i < size) {
            strArr[i] = list.get(i);
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i++;
        }
        sb.append(" GROUP BY _eIdsId");
        return Pair.create(sb.toString(), strArr);
    }

    public static p0 b(List<p0> list, long j) {
        int iA = a(list, j);
        if (iA < 0) {
            return null;
        }
        return list.get(iA);
    }

    public static Pair<String, String[]> c(int i) {
        return Pair.create("SELECT _id,_iiTtId FROM idsInfo WHERE _iiTtId IN (SELECT _iiTtId FROM idsInfo GROUP BY _iiTtId HAVING count(_iiTtId) > ?) ORDER BY _cTime DESC", new String[]{String.valueOf(i)});
    }

    public static Pair<String, String[]> c(List<p0> list) {
        int size = list.size();
        String[] strArr = new String[size];
        StringBuilder sb = new StringBuilder("SELECT _eTtId,COUNT(*) as totalCount,SUM(_size) as totalSize FROM events WHERE _dataState != 1 AND _eTtId IN (");
        int i = 0;
        while (i < size) {
            p0 p0Var = list.get(i);
            strArr[i] = String.valueOf(p0Var == null ? 0L : p0Var.a());
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i++;
        }
        sb.append(" GROUP BY _eTtId");
        return Pair.create(sb.toString(), strArr);
    }

    public static Pair<String, String[]> c(List<p0> list, long j) {
        int size = list.size();
        String[] strArr = new String[size + 1];
        int i = 0;
        strArr[0] = String.valueOf(j);
        StringBuilder sb = new StringBuilder("SELECT events._id as evtId,_size FROM events INNER JOIN idsInfo ON events._eIdsId = idsInfo._id WHERE _reqId IS NULL AND evtId >? AND _state IN (0,2) AND _dataState != 1 AND events._eTtId IN (");
        while (i < size) {
            p0 p0Var = list.get(i);
            int i2 = i + 1;
            strArr[i2] = String.valueOf(p0Var == null ? 0L : p0Var.a());
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i = i2;
        }
        sb.append(" ORDER BY evtId ASC");
        return Pair.create(sb.toString(), strArr);
    }

    public static List<Pair<String, String[]>> d(List<n0> list) {
        return f(new LinkedList(list));
    }

    public static Pair<String, String[]> e(List<String> list) {
        int size = list.size();
        StringBuilder sb = new StringBuilder("_id IN (");
        String[] strArr = new String[size];
        int i = 0;
        while (i < size) {
            strArr[i] = String.valueOf(list.get(i));
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i++;
        }
        return Pair.create(sb.toString(), strArr);
    }

    public static List<Pair<String, String[]>> f(List<i0> list) {
        Pair<List<Pair<String, String>>, List<String>> pairI = i(list);
        LinkedList linkedList = new LinkedList();
        int size = ((List) pairI.first).size();
        int size2 = ((List) pairI.second).size();
        int i = (size * 2) + size2;
        if (i <= 0) {
            linkedList.add(Pair.create(null, null));
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i > 0) {
                int iMin = Math.min(i, 600);
                String[] strArr = new String[iMin];
                StringBuilder sb = new StringBuilder();
                int i4 = 0;
                boolean z = false;
                while (i2 < size && i4 + 2 <= iMin) {
                    if (i4 != 0) {
                        sb.append(" OR ");
                    }
                    Pair pair = (Pair) ((List) pairI.first).get(i2);
                    int i5 = i4 + 1;
                    strArr[i4] = (String) pair.first;
                    i4 += 2;
                    strArr[i5] = (String) pair.second;
                    sb.append("_id BETWEEN ? AND ?");
                    i2++;
                    z = true;
                }
                boolean z2 = false;
                while (i3 < size2) {
                    int i6 = i4 + 1;
                    if (i6 > iMin) {
                        break;
                    }
                    if (!z2) {
                        if (z) {
                            sb.append(" OR ");
                        }
                        sb.append("_id IN(");
                        z2 = true;
                    }
                    strArr[i4] = (String) ((List) pairI.second).get(i3);
                    sb.append("?").append((i3 == size2 + (-1) || i6 == iMin) ? ")" : ",");
                    i3++;
                    i4 = i6;
                }
                linkedList.add(Pair.create(sb.toString(), strArr));
                i -= iMin;
            }
        }
        return linkedList;
    }

    public static List<Pair<String, String[]>> g(List<h3> list) {
        return f(new LinkedList(list));
    }

    public static Pair<String, String[]> h(List<p0> list) {
        int size = list.size();
        String[] strArr = new String[size];
        StringBuilder sb = new StringBuilder("SELECT _reqId,SUM(_size) as reqIdSize FROM events WHERE _reqId IS NOT NULL AND _state IN (0,2) AND _dataState != 1 AND _eTtId IN (");
        int i = 0;
        while (i < size) {
            p0 p0Var = list.get(i);
            strArr[i] = String.valueOf(p0Var == null ? 0L : p0Var.a());
            sb.append("?").append(i == size + (-1) ? ")" : ",");
            i++;
        }
        sb.append(" GROUP BY _reqId");
        return Pair.create(sb.toString(), strArr);
    }

    private static Pair<List<Pair<String, String>>, List<String>> i(List<i0> list) {
        int size = list.size();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (size < 10) {
            Iterator<i0> it = list.iterator();
            while (it.hasNext()) {
                i0 next = it.next();
                linkedList2.add(next == null ? "0" : String.valueOf(next.a()));
            }
        } else {
            List<Pair<String, String>> listB = com.hihonor.hianalytics.util.g.b(list);
            if (listB.size() <= 0) {
                Iterator<i0> it2 = list.iterator();
                while (it2.hasNext()) {
                    i0 next2 = it2.next();
                    linkedList2.add(next2 == null ? "0" : String.valueOf(next2.a()));
                }
            } else {
                for (Pair<String, String> pair : listB) {
                    if (Objects.equals(pair.first, pair.second)) {
                        linkedList2.add((String) pair.first);
                    } else {
                        linkedList.add(pair);
                    }
                }
            }
        }
        return Pair.create(linkedList, linkedList2);
    }
}
