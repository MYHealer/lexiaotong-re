package com.byazt.twu;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 970, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends tt {
    public com.byazt.vb.n tt;
    public com.byazt.rz.c uj;
    public List<String> ve;

    public byte tt() {
        return (byte) 1;
    }

    @Override // com.byazt.twu.tt
    public com.byazt.vb.n uj() {
        return this.tt;
    }

    public byte ve() {
        return (byte) 2;
    }

    public sp(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, nVar, cVar == null ? com.byazt.rz.c.ve() : cVar);
        this.ve = new ArrayList();
        this.uj = cVar;
        this.tt = nVar;
        if (cVar == null) {
            this.uj = com.byazt.rz.c.ve();
        }
    }

    @Override // com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.a(ttVar);
    }

    @Override // com.byazt.twu.tt
    public String c() {
        return this.tt.tt().uj();
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(int i, String str, int i2, boolean z) {
        long jC = com.byazt.mv.c.c(i, getContext(), this.tt);
        if (jC <= 0) {
            jC = 1;
        } else if (jC > 100) {
            jC = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.ve.clear();
        Cursor cursorQuery = com.byazt.ym.tt.query(getContext(), c(), new String[]{"id", oOOOoo00.OooOo0o, "encrypt", "retry"}, null, null, null, null, str + " DESC limit " + jC, this.tt);
        if (cursorQuery != null) {
            while (true) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                    int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    if (i3 == 1) {
                        string2 = this.tt.uj().c(string2);
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.ve.add(string);
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        com.byazt.fo.c cVar = new com.byazt.fo.c(string, new JSONObject(string2));
                        cVar.tt(i4 + 1);
                        cVar.tt(ve());
                        cVar.c(tt());
                        arrayList.add(cVar);
                    }
                } finally {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            if (!this.ve.isEmpty()) {
                                ve(this.ve);
                                this.ve.clear();
                            }
                            if (com.byazt.ml.c.c(i2) && !z) {
                                c(arrayList, 10, 604800000L);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void ve(List<String> list) {
        c();
        list.size();
        com.byazt.ym.tt.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) list, 1000, true), this.tt);
        com.byazt.ml.tt.c(com.byazt.mv.tt.c.z(), list.size(), this.tt);
        c(list);
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(String str, int i, boolean z) {
        com.byazt.rz.c cVar = this.uj;
        if (cVar == null) {
            return new ArrayList();
        }
        return c(cVar.tt(), str, i, z);
    }

    @Override // com.byazt.twu.ve
    public String delete(List<com.byazt.vb.tt> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vb.tt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ve());
        }
        com.byazt.ml.c.c(list, this.tt, c());
        String strC = com.byazt.ym.tt.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) linkedList, 1000, true), this.tt);
        c(linkedList);
        return strC;
    }

    private void c(int i, long j) {
        com.byazt.ym.tt.delete(getContext(), c(), "gen_time <? OR retry >?", new String[]{new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()}, this.tt);
    }

    public void c(List<com.byazt.vb.tt> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            uj(list);
            c(i, j);
        } catch (Exception unused) {
        }
    }

    private void uj(List<com.byazt.vb.tt> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vb.tt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ve());
        }
        com.byazt.ym.tt.c(getContext(), "UPDATE " + c() + " SET retry = retry+1 WHERE " + c("id", (List<?>) linkedList, 1000, true), this.tt);
    }

    public static String uj(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String n(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    private static String c(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strC = c(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strC).append("')");
        }
        return c(sb.toString(), str + str2 + "('')");
    }

    private static String c(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
