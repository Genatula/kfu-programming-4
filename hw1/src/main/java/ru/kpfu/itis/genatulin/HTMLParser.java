package ru.kpfu.itis.genatulin;

import org.htmlcleaner.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class HTMLParser {
    public NodeList parse(String template, URL url) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String fileName = clean(url);
        File file = new File(fileName);

        FileInputStream in = new FileInputStream(file);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(in);

        XPath xPath = XPathFactory.newInstance().newXPath();
        return (NodeList) xPath.compile(template).evaluate(document, XPathConstants.NODESET);
    }

    private String clean(URL url) throws IOException {
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode tagNode = htmlCleaner.clean(url);

        CleanerProperties properties = new CleanerProperties();
        String filename = url.toString().hashCode() + ".xml";
        new PrettyXmlSerializer(properties).writeToFile(
                tagNode, filename, "utf-8"
        );

        return filename;
    }
}
