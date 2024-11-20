package me.realprice.emag_scraper.utils;

import me.realprice.emag_scraper.dto.PhoneDTO;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ResponseParser {

    public static List<PhoneDTO> parse(Element cardGrid) {

        List<PhoneDTO> phones = new ArrayList<>();

        Elements phonesElement = cardGrid.select(".card-item");
        if (phonesElement.isEmpty()) {
            return null;
        }

        for (Element phoneElement : phonesElement) {

            Element elementTitle = phoneElement.selectFirst(".card-v2-title");
            String id = phoneElement.attr("data-product-id");
            String url = phoneElement.attr("data-url");
            Element elementPrice = phoneElement.selectFirst(".product-new-price");
            Element elementAverageRating = phoneElement.selectFirst(".star-rating-text .average-rating.semibold");


            if (isNull(elementTitle) || isNull(id) || isNull(url) || isNull(elementPrice)) {
                continue;
            }

            String phoneName = elementTitle.text();
            int phoneId = Integer.parseInt(id);
            float phonePrice = Float.parseFloat(elementPrice.ownText());
            String phoneBrand = elementTitle.ownText().split(" ")[2];

            PhoneDTO phoneDTO = new PhoneDTO(phoneName, phoneId, url, phonePrice, phoneBrand);

            if (!isNull(elementAverageRating)) {
                float phoneAverageRating = Float.parseFloat(elementAverageRating.ownText());
                phoneDTO.setAverageRating(phoneAverageRating);

            }

            phones.add(phoneDTO);

        }

        return phones;
    }

    private static boolean isNull(Object object) {
        return object == null;
    }


}
