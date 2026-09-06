package com.yfanads.android.libs.thirdpart.lottie.model.content;

import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.model.CubicCurveData;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData() {
        this.curves = new ArrayList();
    }

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        ArrayList arrayList = new ArrayList();
        this.curves = arrayList;
        this.initialPoint = pointF;
        this.closed = z;
        arrayList.addAll(list);
    }

    private void setInitialPoint(float f, float f2) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.initialPoint.set(f, f2);
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.closed = shapeData.isClosed() || shapeData2.isClosed();
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            L.warn("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        if (this.curves.isEmpty()) {
            int iMin = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
            for (int i = 0; i < iMin; i++) {
                this.curves.add(new CubicCurveData());
            }
        }
        PointF initialPoint = shapeData.getInitialPoint();
        PointF initialPoint2 = shapeData2.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(initialPoint.x, initialPoint2.x, f), MiscUtils.lerp(initialPoint.y, initialPoint2.y, f));
        for (int size = this.curves.size() - 1; size >= 0; size--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint3 = cubicCurveData2.getControlPoint1();
            PointF controlPoint4 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.curves.get(size).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint3.x, f), MiscUtils.lerp(controlPoint1.y, controlPoint3.y, f));
            this.curves.get(size).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint4.x, f), MiscUtils.lerp(controlPoint2.y, controlPoint4.y, f));
            this.curves.get(size).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f), MiscUtils.lerp(vertex.y, vertex2.y, f));
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
    }
}
