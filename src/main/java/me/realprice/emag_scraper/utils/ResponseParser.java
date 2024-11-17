package me.realprice.emag_scraper.utils;

import me.realprice.emag_scraper.dto.PhoneDTO;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
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
            String offerId = phoneElement.attr("data-offer-id");
            String url = phoneElement.attr("data-url");
            Element elementPrice = phoneElement.selectFirst(".product-new-price");
            Element elementRecommendedPrice = phoneElement.selectFirst(".rrp-lp30d-content");
            Element elementAverageRating = phoneElement.selectFirst(".star-rating-text .average-rating.semibold");


            if (isNull(elementTitle) || isNull(id) || isNull(offerId) || isNull(url) || isNull(elementPrice)) {
                continue;
            }

            String phoneName = elementTitle.text();
            int phoneId = Integer.parseInt(id);
            int phoneOfferId = Integer.parseInt(offerId);
            float phonePrice = Float.parseFloat(elementPrice.ownText());
            String phoneBrand = elementTitle.ownText().split(" ")[2];

            PhoneDTO phoneDTO = new PhoneDTO(phoneName, phoneId, phoneOfferId, url, phonePrice, phoneBrand);

            if (!isNull(elementRecommendedPrice)) {
                if ((elementRecommendedPrice.ownText().split(" ").length) > 1) {
                    String phoneRecommendedPrice = elementRecommendedPrice.ownText().split(" ")[1];
                    phoneDTO.setRecommendedRetailPrice(phoneRecommendedPrice);
                }
            }

            if (!isNull(elementAverageRating)) {
                float phoneAverageRating = Float.parseFloat(elementAverageRating.ownText());
                phoneDTO.setAverageRating(phoneAverageRating);

            }

            phones.add(phoneDTO);

        }
        System.out.println(phones);
        System.out.println(phones.size());
        return phones;
    }

    private static boolean isNull(Object object) {
        return object == null;
    }


}
