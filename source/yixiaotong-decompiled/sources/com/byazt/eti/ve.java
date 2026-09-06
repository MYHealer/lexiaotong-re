package com.byazt.eti;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 384, 54})
public class ve implements tt {
    @Override // com.byazt.eti.tt
    public void c(String str, sp.tt ttVar, a aVar, sp.c cVar, c cVar2) {
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int count = (cursorQuery.getCount() - cVar.uj()) + 1;
            if (count > 0) {
                do {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID));
                    if (cVar2 != null) {
                        cVar2.c(new sp.tt(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID))));
                    }
                    com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "rit=? AND uuid=?", new String[]{str, string});
                    count--;
                    if (count <= 0) {
                        break;
                    }
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(Constant.MAP_KEY_UUID, ttVar.n);
        contentValues.put("create_time", Long.valueOf(ttVar.c));
        contentValues.put("save_version", Integer.valueOf(ttVar.uj));
        contentValues.put("expire_time", Long.valueOf(ttVar.tt));
        contentValues.put("slot_type", cVar.c());
        contentValues.put("is_using", Integer.valueOf(aVar.c ? 1 : 0));
        contentValues.put("priority", Integer.valueOf(aVar.tt));
        contentValues.put("ad_index", Integer.valueOf(aVar.ve));
        contentValues.put("meta_data", ttVar.ve);
        com.byazt.pe.c.insert(gt.getContext(), "union_meta_cache", contentValues);
    }

    @Override // com.byazt.eti.tt
    public sp.tt c(String str, sp.c cVar, long j, List<String> list) {
        Cursor cursorC = c(cVar, str);
        if (cursorC == null) {
            return null;
        }
        while (cursorC.moveToNext()) {
            try {
                try {
                    String string = cursorC.getString(cursorC.getColumnIndex(Constant.MAP_KEY_UUID));
                    if (list == null || string == null || !list.contains(string)) {
                        String string2 = cursorC.getString(cursorC.getColumnIndex("meta_data"));
                        long j2 = cursorC.getLong(cursorC.getColumnIndex("create_time"));
                        long j3 = cursorC.getLong(cursorC.getColumnIndex("expire_time"));
                        if (j <= 0 || j2 >= j) {
                            sp.tt ttVar = new sp.tt(string2, j2, j3, string);
                            cursorC.close();
                            return ttVar;
                        }
                    }
                } catch (Exception e) {
                    m.ve("RewardFullLoadManager-DB", "db get error", e);
                }
            } catch (Throwable th) {
                cursorC.close();
                throw th;
            }
        }
        cursorC.close();
        return null;
    }

    @Override // com.byazt.eti.tt
    public void c(String str) {
        com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.byazt.eti.tt
    public void c(sp.c cVar) {
        com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "slot_type =?", new String[]{cVar.c()});
    }

    @Override // com.byazt.eti.tt
    public void c(String str, sp.c cVar, c cVar2) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (cVar2 != null && (cursorQuery = com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                cVar2.c(new sp.tt(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex(Constant.MAP_KEY_UUID))));
            }
            cursorQuery.close();
        }
        if (cVar.ve()) {
            com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7611", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.byazt.eti.tt
    public void c(String str, String str2) {
        com.byazt.pe.c.delete(gt.getContext(), "union_meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.eti.tt
    public void tt(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.byazt.pe.c.update(gt.getContext(), "union_meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.byazt.eti.tt
    public void c(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.byazt.pe.c.update(gt.getContext(), "union_meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.eti.tt
    public boolean c(String str, sp.c cVar) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (cVar.ve()) {
            cursorQuery = com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7611"}, null, null, null);
        } else {
            cursorQuery = com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        boolean z = false;
        if (cursorQuery != null) {
            cursorQuery.getCount();
            z = cursorQuery.getCount() > 0;
            cursorQuery.close();
        }
        return z;
    }

    private Cursor c(sp.c cVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iN = cVar.n();
        if (iN == 1) {
            if (cVar.ve()) {
                return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7611"}, null, null, "create_time DESC");
            }
            return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (iN == 2) {
            if (cVar.ve()) {
                return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7611"}, null, null, "priority DESC");
            }
            return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC");
        }
        if (iN == 3) {
            if (cVar.ve()) {
                return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7611"}, null, null, "ad_index ASC, create_time DESC");
            }
            return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "ad_index ASC, create_time DESC");
        }
        if (cVar.ve()) {
            return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7611"}, null, null, null);
        }
        return com.byazt.pe.c.query(gt.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
    }
}
