import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaxXMLParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("parser entry point");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MediumHandler mediumHandler = new MediumHandler();
        parser.parse("test-java/data/mediumArticles.xml", mediumHandler);
        System.out.println(mediumHandler.getWebsite());

        List<MediumArticle> articles = mediumHandler.getWebsite().getArticlesList();
        List<String> titlesList = articles.stream().map(MediumArticle::getTitle).collect(Collectors.toList());
        List<String> contentList = articles.stream().
                filter(article -> article.getTitle() != null && article.getContent() != null)
                .map(article -> article.getContent().toUpperCase()).collect(Collectors.toList());
        System.out.printf("The titles list is: %s%n", titlesList);
        System.out.printf("The contents list (uppercase) is: %s%n", contentList);
    }
    public static class MediumHandler extends DefaultHandler {
        private static final String ARTICLES = "articles";
        private static final String ARTICLE = "article";
        private static final String TITLE = "title";
        private static final String CONTENT = "content";

        private Medium website;
        private StringBuilder contentBuilder;

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(contentBuilder == null) {
                contentBuilder = new StringBuilder();
            } else {
                contentBuilder.append(ch, start, length);
            }
        }

        @Override
        public void startDocument() throws SAXException {
            this.website = new Medium();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case ARTICLES:
                    website.setArticlesList(new ArrayList<>());
                case ARTICLE:
                    website.articlesList.add(new MediumArticle());
                case TITLE:
                    contentBuilder = new StringBuilder();
                case CONTENT:
                    contentBuilder = new StringBuilder();
                break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            switch (qName) {
                case TITLE:
                    latestArticle().setTitle(contentBuilder.toString());
                case CONTENT:
                    latestArticle().setContent(contentBuilder.toString());
            }
        }

        private MediumArticle latestArticle() {
            List<MediumArticle> articleList = website.getArticlesList();
            int lastIndex = articleList.size() - 1;
            return articleList.get(lastIndex);
        }
        private Medium getWebsite() {
            return website;
        }
    }

    public static class Medium {
        private List<MediumArticle> articlesList;
        public List<MediumArticle> getArticlesList() {
            return articlesList;
        }
        public void setArticlesList(List<MediumArticle> articlesList) {
            this.articlesList = articlesList;
        }
    }

    public static class MediumArticle {
        private String title;
        private String content;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }
}
