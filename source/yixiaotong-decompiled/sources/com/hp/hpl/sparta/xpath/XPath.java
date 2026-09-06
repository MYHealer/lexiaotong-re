package com.hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class XPath {
    private static final int ASSERTION = 0;
    private static Hashtable cache_ = new Hashtable();
    private boolean absolute_;
    private Stack steps_;
    private String string_;

    private XPath(String str) throws XPathException {
        this(str, new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x0051 A[Catch: IOException -> 0x006f, TryCatch #0 {IOException -> 0x006f, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0044, B:13:0x004b, B:16:0x0051, B:17:0x005a, B:18:0x005b, B:20:0x0061, B:22:0x0067, B:8:0x003a), top: B:27:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:18:0x005b A[Catch: IOException -> 0x006f, TryCatch #0 {IOException -> 0x006f, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0044, B:13:0x004b, B:16:0x0051, B:17:0x005a, B:18:0x005b, B:20:0x0061, B:22:0x0067, B:8:0x003a), top: B:27:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061 A[Catch: IOException -> 0x006f, TryCatch #0 {IOException -> 0x006f, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0044, B:13:0x004b, B:16:0x0051, B:17:0x005a, B:18:0x005b, B:20:0x0061, B:22:0x0067, B:8:0x003a), top: B:27:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x004b A[EDGE_INSN: B:29:0x004b->B:13:0x004b BREAK  A[LOOP:0: B:11:0x0044->B:22:0x0067], SYNTHETIC] */
    private XPath(String str, Reader reader) throws XPathException {
        boolean z;
        Stack stack;
        Step step;
        boolean z2;
        this.steps_ = new Stack();
        try {
            this.string_ = str;
            SimpleStreamTokenizer simpleStreamTokenizer = new SimpleStreamTokenizer(reader);
            simpleStreamTokenizer.ordinaryChar(IOUtils.DIR_SEPARATOR_UNIX);
            simpleStreamTokenizer.ordinaryChar(FilenameUtils.EXTENSION_SEPARATOR);
            simpleStreamTokenizer.wordChars(':', ':');
            simpleStreamTokenizer.wordChars('_', '_');
            if (simpleStreamTokenizer.nextToken() == 47) {
                this.absolute_ = true;
                if (simpleStreamTokenizer.nextToken() == 47) {
                    simpleStreamTokenizer.nextToken();
                    z = true;
                }
                stack = this.steps_;
                step = new Step(this, z, simpleStreamTokenizer);
                while (true) {
                    stack.push(step);
                    if (simpleStreamTokenizer.ttype != 47) {
                        break;
                    }
                    if (simpleStreamTokenizer.nextToken() == 47) {
                        simpleStreamTokenizer.nextToken();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    stack = this.steps_;
                    step = new Step(this, z2, simpleStreamTokenizer);
                }
                if (simpleStreamTokenizer.ttype == -1) {
                } else {
                    throw new XPathException(this, "at end of XPATH expression", simpleStreamTokenizer, "end of expression");
                }
            }
            this.absolute_ = false;
            z = false;
            stack = this.steps_;
            step = new Step(this, z, simpleStreamTokenizer);
            while (true) {
                stack.push(step);
                if (simpleStreamTokenizer.ttype != 47) {
                    break;
                    break;
                }
                if (simpleStreamTokenizer.nextToken() == 47) {
                    simpleStreamTokenizer.nextToken();
                    z2 = true;
                } else {
                    z2 = false;
                }
                stack = this.steps_;
                step = new Step(this, z2, simpleStreamTokenizer);
            }
            if (simpleStreamTokenizer.ttype == -1) {
            } else {
                throw new XPathException(this, "at end of XPATH expression", simpleStreamTokenizer, "end of expression");
            }
        } catch (IOException e) {
            throw new XPathException(this, e);
        }
    }

    private XPath(boolean z, Step[] stepArr) {
        this.steps_ = new Stack();
        for (Step step : stepArr) {
            this.steps_.addElement(step);
        }
        this.absolute_ = z;
        this.string_ = null;
    }

    private String generateString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumerationElements = this.steps_.elements();
        boolean z = true;
        while (enumerationElements.hasMoreElements()) {
            Step step = (Step) enumerationElements.nextElement();
            if (!z || this.absolute_) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                if (step.isMultiLevel()) {
                    stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
            }
            stringBuffer.append(step.toString());
            z = false;
        }
        return stringBuffer.toString();
    }

    public static XPath get(String str) throws XPathException {
        XPath xPath;
        synchronized (cache_) {
            xPath = (XPath) cache_.get(str);
            if (xPath == null) {
                xPath = new XPath(str);
                cache_.put(str, xPath);
            }
        }
        return xPath;
    }

    public static XPath get(boolean z, Step[] stepArr) {
        XPath xPath = new XPath(z, stepArr);
        String string = xPath.toString();
        synchronized (cache_) {
            XPath xPath2 = (XPath) cache_.get(string);
            if (xPath2 != null) {
                return xPath2;
            }
            cache_.put(string, xPath);
            return xPath;
        }
    }

    public static boolean isStringValue(String str) throws XPathException, IOException {
        return get(str).isStringValue();
    }

    public Object clone() {
        int size = this.steps_.size();
        Step[] stepArr = new Step[size];
        Enumeration enumerationElements = this.steps_.elements();
        for (int i = 0; i < size; i++) {
            stepArr[i] = (Step) enumerationElements.nextElement();
        }
        return new XPath(this.absolute_, stepArr);
    }

    public String getIndexingAttrName() throws XPathException {
        BooleanExpr predicate = ((Step) this.steps_.peek()).getPredicate();
        if (predicate instanceof AttrExistsExpr) {
            return ((AttrExistsExpr) predicate).getAttrName();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String getIndexingAttrNameOfEquals() throws XPathException {
        BooleanExpr predicate = ((Step) this.steps_.peek()).getPredicate();
        if (predicate instanceof AttrEqualsExpr) {
            return ((AttrEqualsExpr) predicate).getAttrName();
        }
        return null;
    }

    public Enumeration getSteps() {
        return this.steps_.elements();
    }

    public boolean isAbsolute() {
        return this.absolute_;
    }

    public boolean isStringValue() {
        return ((Step) this.steps_.peek()).isStringValue();
    }

    public String toString() {
        if (this.string_ == null) {
            this.string_ = generateString();
        }
        return this.string_;
    }
}
