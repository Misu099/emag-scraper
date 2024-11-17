package me.realprice.emag_scraper;

import me.realprice.emag_scraper.utils.ResponseParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;

@SpringBootApplication
public class EmagScraperApplication {

    private static final Logger logger = LoggerFactory.getLogger(EmagScraperApplication.class.getName());
    private static final String PHONES_BASE_URL = "https://www.emag.ro/telefoane-mobile/p%d/c";

    public static void main(String[] args) {
        SpringApplication.run(EmagScraperApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            loadData();
        };
    }

    private void loadData() {

        Connection connection = Jsoup.newSession()
                .header("Accept", "")
//				.header("Accept-Encoding", "gzip, deflate, br, zstd")
                .header("Accept-Encoding", "identity")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("cache-control", "no-cache")
                .header("Pragma", "no-cache")
                .header("Priority", "u=0, i")
                .header("Sec-Ch-Ua", "Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99")
                .header("Sec-Ch-Ua-Mobile", "?0")
                .header("Sec-Ch-Ua-Platform", "Windows")
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "none")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
                .method(Connection.Method.GET);

        Element element = null;

        try {
            element = connection.newRequest()
                    .url(String.format(PHONES_BASE_URL, 1))
                    .execute()
                    .parse()
                    .selectFirst("#card_grid");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        Elements elements = null;
        if (element != null) {
            ResponseParser.parse(element);
            elements = element.select(".card-item");
        }
        if (elements == null || elements.isEmpty()) {
            logger.info("No data found");
            return;
        }
        //  logger.info(elements.getFirst().outerHtml());

        try {
            Files.writeString(Path.of("phone.html"), elements.getFirst().outerHtml());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
