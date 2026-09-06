package com.hp.hpl.sparta;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface ParseHandler {
    void characters(char[] cArr, int i, int i2) throws ParseException;

    void endDocument() throws ParseException;

    void endElement(Element element) throws ParseException;

    ParseSource getParseSource();

    void setParseSource(ParseSource parseSource);

    void startDocument() throws ParseException;

    void startElement(Element element) throws ParseException;
}
