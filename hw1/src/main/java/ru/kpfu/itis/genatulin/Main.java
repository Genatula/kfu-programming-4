package ru.kpfu.itis.genatulin;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            HTMLParser htmlParser = new HTMLParser();
            htmlParser.parse("", new URL("https://en.wikipedia.org/wiki/Main_Page"));
        } catch (MalformedURLException e) {
            System.out.println("There's no resource with such URL");
        } catch (IOException e) {
            System.out.println("The resource is not available");
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("The parser is not available at the moment");
        }
    }
}
