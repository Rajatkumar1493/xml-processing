package com.example.xmlprocessor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlUtils {

    public static String getValueByXPath(String xml, String xpathExpression) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        XPath xpath = XPathFactory.newInstance().newXPath();
        return xpath.compile(xpathExpression).evaluate(document);
    }

    public static String updateValueByXPath(String xml, String xpathExpression, String newValue) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        XPath xpath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xpath.compile(xpathExpression).evaluate(document, javax.xml.xpath.XPathConstants.NODE);
        if (node != null) {
            node.setTextContent(newValue);
        }
        java.io.StringWriter writer = new java.io.StringWriter();
        javax.xml.transform.TransformerFactory.newInstance().newTransformer()
                .transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
        return writer.toString();
    }
}
