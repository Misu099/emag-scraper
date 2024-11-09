package me.realprice.emag_scraper.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.realprice.emag_scraper.dto.PhoneDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class ResponseParser {

    private static final Logger logger = LoggerFactory.getLogger(ResponseParser.class);

    public static List<PhoneDTO> parse(String response) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<PhoneDTO> phones = null;

        try {
            phones = objectMapper.readValue(response, new TypeReference<>() {
            });

        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return phones;
    }
}
