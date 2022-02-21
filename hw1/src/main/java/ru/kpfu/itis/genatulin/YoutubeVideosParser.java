package ru.kpfu.itis.genatulin;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YoutubeVideosParser {

    private static final String TITLE_TEMPLATE = "//a[@id=\"video-title\"]";
    private static final String DURATION_TEMPLATE = "//span[@class=\"style-scope ytd-thumbnail-overlay-time-status-renderer\"]";
    private static final String AMOUNT_OF_VIEWS_TEMPLATE = "//div[@id=\"metadata-line\"]/span[1]";

    public List<Video> parse(URL url) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        List<Video> videoList = new ArrayList<>();
        HTMLParser htmlParser = new HTMLParser();

        NodeList titlesList = htmlParser.parse(TITLE_TEMPLATE, url);
        NodeList durationsList = htmlParser.parse(DURATION_TEMPLATE, url);
        NodeList amountsList = htmlParser.parse(AMOUNT_OF_VIEWS_TEMPLATE, url);

        Iterator<Node> titleListIterator = new NodeListIterator(titlesList);
        Iterator<Node> durationsListIterator = new NodeListIterator(durationsList);
        Iterator<Node> amountsListIterator = new NodeListIterator(amountsList);

        while (titleListIterator.hasNext()) {
            String title = titleListIterator.next().getTextContent();
            String duration = durationsListIterator.next().getTextContent();
            String amount = amountsListIterator.next().getTextContent();
            videoList.add(new Video(title, duration, amount));
        }

        return videoList;
    }
}
