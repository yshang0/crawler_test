import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.PrintWriter;
import java.net.URLEncoder;

public class google {

    //scrape the title and URL of search result;
    //find exact URL : static web page & dynamic web page
    //find the css selector
    //URL: https://www.google.com/search?q=apple
    //select: h3.r a
    //real browser user agent;
    //href: Hypertext Reference; URL
    //export results to text file;

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    public static void main(String[] args) throws Exception{

        final String query = "apple";
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        final PrintWriter out = new PrintWriter("result.text");
        for(Element searchResult : page.select("h3.r a")) {
            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            out.write(title + " - > " + url + "\n");
        }
        out.close();

    }
}
