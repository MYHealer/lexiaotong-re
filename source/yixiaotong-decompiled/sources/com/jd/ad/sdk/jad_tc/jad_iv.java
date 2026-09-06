package com.jd.ad.sdk.jad_tc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.jd.ad.sdk.jad_lu.jad_mz;
import com.jd.ad.sdk.jad_lu.jad_re;
import com.jd.ad.sdk.jad_ox.jad_ob;
import com.jd.ad.sdk.jad_ox.jad_qd;
import com.jd.ad.sdk.jad_ra.jad_kx;
import com.jd.ad.sdk.jad_sb.jad_pc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv extends com.jd.ad.sdk.jad_tc.jad_an {
    public final StringBuilder jad_do;
    public final RectF jad_ep;
    public final Matrix jad_fq;
    public final Paint jad_gr;
    public final Paint jad_hs;
    public final Map<com.jd.ad.sdk.jad_qz.jad_dq, List<com.jd.ad.sdk.jad_nw.jad_dq>> jad_it;
    public final LongSparseArray<String> jad_ju;
    public final jad_ob jad_kv;
    public final jad_mz jad_lw;
    public final com.jd.ad.sdk.jad_lu.jad_jt jad_mx;
    public com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_ny;
    public com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_oz;
    public com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_pa;
    public com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_qb;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_rc;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_sd;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_te;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_uf;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_vg;
    public com.jd.ad.sdk.jad_ox.jad_an<Typeface, Typeface> jad_wh;

    public class jad_an extends Paint {
        public jad_an(jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    public class jad_bo extends Paint {
        public jad_bo(jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public static /* synthetic */ class jad_cp {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public jad_iv(jad_mz jad_mzVar, jad_er jad_erVar) {
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar2;
        super(jad_mzVar, jad_erVar);
        this.jad_do = new StringBuilder(2);
        this.jad_ep = new RectF();
        this.jad_fq = new Matrix();
        this.jad_gr = new jad_an(this, 1);
        this.jad_hs = new jad_bo(this, 1);
        this.jad_it = new HashMap();
        this.jad_ju = new LongSparseArray<>();
        this.jad_lw = jad_mzVar;
        this.jad_mx = jad_erVar.jad_an();
        jad_ob jad_obVarJad_dq = jad_erVar.jad_iv().jad_dq();
        this.jad_kv = jad_obVarJad_dq;
        jad_obVarJad_dq.jad_an(this);
        jad_an(jad_obVarJad_dq);
        jad_kx jad_kxVarJad_jw = jad_erVar.jad_jw();
        if (jad_kxVarJad_jw != null && (jad_anVar2 = jad_kxVarJad_jw.jad_an) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVarJad_an = jad_anVar2.jad_an();
            this.jad_ny = jad_anVarJad_an;
            jad_anVarJad_an.jad_an(this);
            jad_an(this.jad_ny);
        }
        if (jad_kxVarJad_jw != null && (jad_anVar = jad_kxVarJad_jw.jad_bo) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVarJad_an2 = jad_anVar.jad_an();
            this.jad_pa = jad_anVarJad_an2;
            jad_anVarJad_an2.jad_an(this);
            jad_an(this.jad_pa);
        }
        if (jad_kxVarJad_jw != null && (jad_boVar2 = jad_kxVarJad_jw.jad_cp) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an3 = jad_boVar2.jad_an();
            this.jad_rc = jad_anVarJad_an3;
            jad_anVarJad_an3.jad_an(this);
            jad_an(this.jad_rc);
        }
        if (jad_kxVarJad_jw == null || (jad_boVar = jad_kxVarJad_jw.jad_dq) == null) {
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an4 = jad_boVar.jad_an();
        this.jad_te = jad_anVarJad_an4;
        jad_anVarJad_an4.jad_an(this);
        jad_an(this.jad_te);
    }

    public final void jad_an(int i, Canvas canvas, float f) {
        float f2;
        int[] iArr = jad_cp.jad_an;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        if (i2 == 2) {
            f2 = -f;
        } else if (i2 != 3) {
            return;
        } else {
            f2 = (-f) / 2.0f;
        }
        canvas.translate(f2, 0.0f);
    }

    public final void jad_an(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == jad_re.jad_an) {
            com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar = this.jad_oz;
            if (jad_anVar != null) {
                this.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == null) {
                this.jad_oz = null;
                return;
            }
            jad_qd jad_qdVar = new jad_qd(jad_cpVar, null);
            this.jad_oz = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            jad_an(this.jad_oz);
            return;
        }
        if (t == jad_re.jad_bo) {
            com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar2 = this.jad_qb;
            if (jad_anVar2 != null) {
                this.jad_uh.remove(jad_anVar2);
            }
            if (jad_cpVar == null) {
                this.jad_qb = null;
                return;
            }
            jad_qd jad_qdVar2 = new jad_qd(jad_cpVar, null);
            this.jad_qb = jad_qdVar2;
            jad_qdVar2.jad_an.add(this);
            jad_an(this.jad_qb);
            return;
        }
        if (t == jad_re.jad_sf) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar3 = this.jad_sd;
            if (jad_anVar3 != null) {
                this.jad_uh.remove(jad_anVar3);
            }
            if (jad_cpVar == null) {
                this.jad_sd = null;
                return;
            }
            jad_qd jad_qdVar3 = new jad_qd(jad_cpVar, null);
            this.jad_sd = jad_qdVar3;
            jad_qdVar3.jad_an.add(this);
            jad_an(this.jad_sd);
            return;
        }
        if (t == jad_re.jad_tg) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar4 = this.jad_uf;
            if (jad_anVar4 != null) {
                this.jad_uh.remove(jad_anVar4);
            }
            if (jad_cpVar == null) {
                this.jad_uf = null;
                return;
            }
            jad_qd jad_qdVar4 = new jad_qd(jad_cpVar, null);
            this.jad_uf = jad_qdVar4;
            jad_qdVar4.jad_an.add(this);
            jad_an(this.jad_uf);
            return;
        }
        if (t == jad_re.jad_hs) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar5 = this.jad_vg;
            if (jad_anVar5 != null) {
                this.jad_uh.remove(jad_anVar5);
            }
            if (jad_cpVar == null) {
                this.jad_vg = null;
                return;
            }
            jad_qd jad_qdVar5 = new jad_qd(jad_cpVar, null);
            this.jad_vg = jad_qdVar5;
            jad_qdVar5.jad_an.add(this);
            jad_an(this.jad_vg);
            return;
        }
        if (t == jad_re.jad_oz) {
            com.jd.ad.sdk.jad_ox.jad_an<Typeface, Typeface> jad_anVar6 = this.jad_wh;
            if (jad_anVar6 != null) {
                this.jad_uh.remove(jad_anVar6);
            }
            if (jad_cpVar == null) {
                this.jad_wh = null;
                return;
            }
            jad_qd jad_qdVar6 = new jad_qd(jad_cpVar, null);
            this.jad_wh = jad_qdVar6;
            jad_qdVar6.jad_an.add(this);
            jad_an(this.jad_wh);
        }
    }

    public final void jad_an(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(Canvas canvas, Matrix matrix, int i) {
        com.jd.ad.sdk.jad_py.jad_an jad_anVar;
        Typeface typefaceJad_fs;
        int i2;
        String string;
        Paint paint;
        int i3;
        List<com.jd.ad.sdk.jad_nw.jad_dq> list;
        String str;
        Paint paint2;
        List list2;
        canvas.save();
        if (this.jad_lw.jad_bo.jad_jt.size() <= 0) {
            canvas.concat(matrix);
        }
        com.jd.ad.sdk.jad_qz.jad_bo jad_boVarJad_fs = this.jad_kv.jad_fs();
        com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar = this.jad_mx.jad_er.get(jad_boVarJad_fs.jad_bo);
        if (jad_cpVar == null) {
            canvas.restore();
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar2 = this.jad_oz;
        if (jad_anVar2 == null && (jad_anVar2 = this.jad_ny) == null) {
            this.jad_gr.setColor(jad_boVarJad_fs.jad_hu);
        } else {
            this.jad_gr.setColor(jad_anVar2.jad_fs().intValue());
        }
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar3 = this.jad_qb;
        if (jad_anVar3 == null && (jad_anVar3 = this.jad_pa) == null) {
            this.jad_hs.setColor(jad_boVarJad_fs.jad_iv);
        } else {
            this.jad_hs.setColor(jad_anVar3.jad_fs().intValue());
        }
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar4 = this.jad_vi.jad_jw;
        int iIntValue = ((jad_anVar4 == null ? 100 : jad_anVar4.jad_fs().intValue()) * 255) / 100;
        this.jad_gr.setAlpha(iIntValue);
        this.jad_hs.setAlpha(iIntValue);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar5 = this.jad_sd;
        if (jad_anVar5 == null && (jad_anVar5 = this.jad_rc) == null) {
            this.jad_hs.setStrokeWidth(com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_boVarJad_fs.jad_jw * com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix));
        } else {
            this.jad_hs.setStrokeWidth(jad_anVar5.jad_fs().floatValue());
        }
        if (this.jad_lw.jad_bo.jad_jt.size() > 0) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar6 = this.jad_vg;
            float fFloatValue = (jad_anVar6 != null ? jad_anVar6.jad_fs().floatValue() : jad_boVarJad_fs.jad_cp) / 100.0f;
            float fJad_an = com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix);
            String str2 = jad_boVarJad_fs.jad_an;
            float fJad_an2 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_boVarJad_fs.jad_fs;
            List listAsList = Arrays.asList(str2.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\r").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "\r").split("\r"));
            int size = listAsList.size();
            int i4 = 0;
            while (i4 < size) {
                String str3 = (String) listAsList.get(i4);
                float fJad_an3 = 0.0f;
                int i5 = 0;
                while (i5 < str3.length()) {
                    com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = this.jad_mx.jad_jt.get(com.jd.ad.sdk.jad_qz.jad_dq.jad_an(str3.charAt(i5), jad_cpVar.jad_an, jad_cpVar.jad_cp));
                    if (jad_dqVar == null) {
                        list2 = listAsList;
                    } else {
                        list2 = listAsList;
                        fJad_an3 = (float) ((jad_dqVar.jad_cp * ((double) fFloatValue) * ((double) com.jd.ad.sdk.jad_xg.jad_hu.jad_an()) * ((double) fJad_an)) + ((double) fJad_an3));
                    }
                    i5++;
                    i4 = i4;
                    str3 = str3;
                    listAsList = list2;
                }
                List list3 = listAsList;
                int i6 = i4;
                String str4 = str3;
                canvas.save();
                jad_an(jad_boVarJad_fs.jad_dq, canvas, fJad_an3);
                canvas.translate(0.0f, (i6 * fJad_an2) - (((size - 1) * fJad_an2) / 2.0f));
                int i7 = 0;
                while (i7 < str4.length()) {
                    String str5 = str4;
                    com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar2 = this.jad_mx.jad_jt.get(com.jd.ad.sdk.jad_qz.jad_dq.jad_an(str5.charAt(i7), jad_cpVar.jad_an, jad_cpVar.jad_cp));
                    if (jad_dqVar2 == null) {
                        i3 = size;
                        str = str5;
                    } else {
                        if (this.jad_it.containsKey(jad_dqVar2)) {
                            list = this.jad_it.get(jad_dqVar2);
                            i3 = size;
                        } else {
                            List<jad_pc> list4 = jad_dqVar2.jad_an;
                            int size2 = list4.size();
                            ArrayList arrayList = new ArrayList(size2);
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new com.jd.ad.sdk.jad_nw.jad_dq(this.jad_lw, this, list4.get(i8)));
                                i8++;
                                list4 = list4;
                                size = size;
                                size2 = size2;
                            }
                            i3 = size;
                            this.jad_it.put(jad_dqVar2, arrayList);
                            list = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list.size()) {
                            Path pathJad_bo = list.get(i9).jad_bo();
                            pathJad_bo.computeBounds(this.jad_ep, false);
                            this.jad_fq.set(matrix);
                            List<com.jd.ad.sdk.jad_nw.jad_dq> list5 = list;
                            String str6 = str5;
                            this.jad_fq.preTranslate(0.0f, (-jad_boVarJad_fs.jad_jt) * com.jd.ad.sdk.jad_xg.jad_hu.jad_an());
                            this.jad_fq.preScale(fFloatValue, fFloatValue);
                            pathJad_bo.transform(this.jad_fq);
                            if (jad_boVarJad_fs.jad_kx) {
                                jad_an(pathJad_bo, this.jad_gr, canvas);
                                paint2 = this.jad_hs;
                            } else {
                                jad_an(pathJad_bo, this.jad_hs, canvas);
                                paint2 = this.jad_gr;
                            }
                            jad_an(pathJad_bo, paint2, canvas);
                            i9++;
                            list = list5;
                            str5 = str6;
                        }
                        str = str5;
                        float fJad_an4 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * ((float) jad_dqVar2.jad_cp) * fFloatValue * fJad_an;
                        float fFloatValue2 = jad_boVarJad_fs.jad_er / 10.0f;
                        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar7 = this.jad_uf;
                        if (jad_anVar7 != null || (jad_anVar7 = this.jad_te) != null) {
                            fFloatValue2 += jad_anVar7.jad_fs().floatValue();
                        }
                        canvas.translate((fFloatValue2 * fJad_an) + fJad_an4, 0.0f);
                    }
                    i7++;
                    size = i3;
                    str4 = str;
                }
                canvas.restore();
                i4 = i6 + 1;
                listAsList = list3;
            }
        } else {
            com.jd.ad.sdk.jad_ox.jad_an<Typeface, Typeface> jad_anVar8 = this.jad_wh;
            int i10 = 1;
            if (jad_anVar8 == null || (typefaceJad_fs = jad_anVar8.jad_fs()) == null) {
                jad_mz jad_mzVar = this.jad_lw;
                String str7 = jad_cpVar.jad_an;
                String str8 = jad_cpVar.jad_cp;
                if (jad_mzVar.getCallback() == null) {
                    jad_anVar = null;
                } else {
                    if (jad_mzVar.jad_ly == null) {
                        jad_mzVar.jad_ly = new com.jd.ad.sdk.jad_py.jad_an(jad_mzVar.getCallback(), jad_mzVar.jad_mz);
                    }
                    jad_anVar = jad_mzVar.jad_ly;
                }
                if (jad_anVar != null) {
                    com.jd.ad.sdk.jad_qz.jad_iv<String> jad_ivVar = jad_anVar.jad_an;
                    jad_ivVar.jad_an = str7;
                    jad_ivVar.jad_bo = str8;
                    Typeface typefaceCreate = jad_anVar.jad_bo.get(jad_ivVar);
                    if (typefaceCreate == null) {
                        typefaceCreate = jad_anVar.jad_cp.get(str7);
                        if (typefaceCreate == null) {
                            typefaceCreate = jad_anVar.jad_er != null ? Typeface.create(Typeface.DEFAULT, 0) : null;
                            if (typefaceCreate == null) {
                                typefaceCreate = Typeface.createFromAsset(jad_anVar.jad_dq, "fonts/" + str7 + jad_anVar.jad_fs);
                            }
                            jad_anVar.jad_cp.put(str7, typefaceCreate);
                        }
                        boolean zContains = str8.contains("Italic");
                        boolean zContains2 = str8.contains("Bold");
                        if (zContains && zContains2) {
                            i2 = 3;
                        } else if (zContains) {
                            i2 = 2;
                        } else {
                            i2 = zContains2 ? 1 : 0;
                        }
                        if (typefaceCreate.getStyle() != i2) {
                            typefaceCreate = Typeface.create(typefaceCreate, i2);
                        }
                        jad_anVar.jad_bo.put(jad_anVar.jad_an, typefaceCreate);
                    }
                    typefaceJad_fs = typefaceCreate;
                } else {
                    typefaceJad_fs = null;
                }
                if (typefaceJad_fs == null) {
                    typefaceJad_fs = null;
                }
            }
            if (typefaceJad_fs != null) {
                String str9 = jad_boVarJad_fs.jad_an;
                this.jad_lw.getClass();
                this.jad_gr.setTypeface(typefaceJad_fs);
                com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar9 = this.jad_vg;
                float fFloatValue3 = jad_anVar9 != null ? jad_anVar9.jad_fs().floatValue() : jad_boVarJad_fs.jad_cp;
                this.jad_gr.setTextSize(com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * fFloatValue3);
                this.jad_hs.setTypeface(this.jad_gr.getTypeface());
                this.jad_hs.setTextSize(this.jad_gr.getTextSize());
                float fJad_an5 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_boVarJad_fs.jad_fs;
                float fFloatValue4 = jad_boVarJad_fs.jad_er / 10.0f;
                com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar10 = this.jad_uf;
                if (jad_anVar10 != null || (jad_anVar10 = this.jad_te) != null) {
                    fFloatValue4 += jad_anVar10.jad_fs().floatValue();
                }
                float fJad_an6 = ((com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * fFloatValue4) * fFloatValue3) / 100.0f;
                List listAsList2 = Arrays.asList(str9.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\r").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "\r").split("\r"));
                int size3 = listAsList2.size();
                int i11 = 0;
                while (i11 < size3) {
                    String str10 = (String) listAsList2.get(i11);
                    float length = ((str10.length() - i10) * fJad_an6) + this.jad_hs.measureText(str10);
                    canvas.save();
                    jad_an(jad_boVarJad_fs.jad_dq, canvas, length);
                    canvas.translate(0.0f, (i11 * fJad_an5) - (((size3 - 1) * fJad_an5) / 2.0f));
                    int length2 = 0;
                    while (length2 < str10.length()) {
                        int iCodePointAt = str10.codePointAt(length2);
                        int iCharCount = Character.charCount(iCodePointAt) + length2;
                        while (iCharCount < str10.length()) {
                            int iCodePointAt2 = str10.codePointAt(iCharCount);
                            if (Character.getType(iCodePointAt2) != 16 && Character.getType(iCodePointAt2) != 27 && Character.getType(iCodePointAt2) != 6 && Character.getType(iCodePointAt2) != 28 && Character.getType(iCodePointAt2) != 19) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                        }
                        try {
                            long j = iCodePointAt;
                            if (this.jad_ju.indexOfKey(j) >= 0) {
                                string = this.jad_ju.get(j);
                            } else {
                                this.jad_do.setLength(0);
                                int iCharCount2 = length2;
                                while (iCharCount2 < iCharCount) {
                                    int iCodePointAt3 = str10.codePointAt(iCharCount2);
                                    this.jad_do.appendCodePoint(iCodePointAt3);
                                    iCharCount2 += Character.charCount(iCodePointAt3);
                                }
                                string = this.jad_do.toString();
                                this.jad_ju.put(iCodePointAt, string);
                            }
                        } catch (Exception unused) {
                        }
                        length2 += string.length();
                        if (jad_boVarJad_fs.jad_kx) {
                            jad_an(string, this.jad_gr, canvas);
                            paint = this.jad_hs;
                        } else {
                            jad_an(string, this.jad_hs, canvas);
                            paint = this.jad_gr;
                        }
                        jad_an(string, paint, canvas);
                        canvas.translate(this.jad_gr.measureText(string) + fJad_an6, 0.0f);
                    }
                    canvas.restore();
                    i11++;
                    i10 = 1;
                }
            }
        }
        canvas.restore();
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.jad_mx.jad_jw.width(), this.jad_mx.jad_jw.height());
    }
}
