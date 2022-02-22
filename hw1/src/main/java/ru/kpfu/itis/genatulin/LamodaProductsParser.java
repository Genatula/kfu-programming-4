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

public class LamodaProductsParser {
    private static final String TITLE_TEMPLATE = "//div[@class=\"x-product-card-description__microdata-wrap\"]";
    private static final String PRICE_TEMPLATE = "//span[@class=\"price\"]";
    private static final String IMAGE_TEMPLATE = "//img[@class=\"products-list-item__img\"]";

    public List<Product> parse(URL url) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        List<Product> videoList = new ArrayList<>();
        HTMLParser htmlParser = new HTMLParser();

        NodeList titlesList = htmlParser.parse(TITLE_TEMPLATE, url);
        NodeList pricesList = htmlParser.parse(PRICE_TEMPLATE, url);
        NodeList imagesList = htmlParser.parse(IMAGE_TEMPLATE, url);

        Iterator<Node> titleListIterator = new NodeListIterator(titlesList);
        Iterator<Node> pricesListIterator = new NodeListIterator(pricesList);
        Iterator<Node> imagesListIterator = new NodeListIterator(imagesList);

        while (titleListIterator.hasNext()) {
            String title = titleListIterator.next().getTextContent();
            String price = pricesListIterator.next().getTextContent();
            String image = getImageURL(imagesListIterator.next());
            videoList.add(new Product(title, price, image));
        }

        return videoList;
    }

    private String getImageURL(Node next) {
        return next.getAttributes().getNamedItem("src").getTextContent();
    }
}
