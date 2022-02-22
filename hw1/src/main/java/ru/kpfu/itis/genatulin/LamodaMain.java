package ru.kpfu.itis.genatulin;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LamodaMain {
    public static void main(String[] args) {
        try {
            LamodaProductsParser lamodaProductsParser = new LamodaProductsParser();
            List<Product> videoList = lamodaProductsParser.parse(new URL("https://www.lamoda.ru/c/513/clothes-muzhskie-d-insy/"));
            videoList.forEach(video -> System.out.println(video.toString()));
        } catch (MalformedURLException e) {
            System.out.println("There's no resource with such URL");
        } catch (IOException e) {
            System.out.println("The resource is not available");
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("The parser is not available at the moment");
        } catch (XPathExpressionException e) {
            System.out.println("The expression is not accurate");
        }
    }
}
