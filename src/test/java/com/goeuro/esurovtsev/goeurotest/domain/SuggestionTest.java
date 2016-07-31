package com.goeuro.esurovtsev.goeurotest.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuggestionTest {
    @Test
    public void testJsonFormat() throws Exception {
        // prepare
        String source = "{" +
                "\"_id\": 376217," +
                "\"key\": \"ber-key\"," +
                "\"name\": \"Berlin\"," +
                "\"fullName\": \"Berlin, Germany\"," +
                "\"iata_airport_code\": null," +
                "\"type\": \"location\"," +
                "\"country\": \"Germany\"," +
                "\"geo_position\": {\"latitude\": 52.52437,\"longitude\": 13.41053}," +
                "\"locationId\": 8384," +
                "\"inEurope\": true," +
                "\"countryId\": 56," +
                "\"countryCode\": \"DE\"," +
                "\"coreCountry\": true," +
                "\"distance\": 12538," +
                "\"names\": {\"pt\": \"Berlim\",\"ru\": \"Берлин\",\"it\": \"Berlino\"}," +
                "\"alternativeNames\": {\"is\": \"Berlín\",\"fi\": \"Berliini\",\"zh\": \"柏林\"}" +
                "}";
        Suggestion expected = Suggestion.builder()
                .id(376217)
                .key("ber-key")
                .name("Berlin")
                .fullName("Berlin, Germany")
                .iataAirportCode(null)
                .type("location")
                .country("Germany")
                .geoPosition(new GeoPosition(52.52437, 13.41053))
                .locationId(8384)
                .inEurope(true)
                .countryId(56)
                .countryCode("DE")
                .coreCountry(true)
                .distance(12538)
                .names(ImmutableMap.of("pt", "Berlim", "ru", "Берлин", "it", "Berlino"))
                .alternativeNames(ImmutableMap.of("is", "Berlín", "fi", "Berliini", "zh", "柏林"))
                .build();

        // test & validate
        ObjectMapper mapper = new ObjectMapper();
        assertThat(mapper.readValue(source, Suggestion.class), equalTo(expected));
    }
}