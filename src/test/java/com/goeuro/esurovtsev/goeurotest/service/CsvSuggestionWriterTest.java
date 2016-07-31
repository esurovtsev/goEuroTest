package com.goeuro.esurovtsev.goeurotest.service;

import com.goeuro.esurovtsev.goeurotest.dto.CsvSuggestionDto;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CsvSuggestionWriterTest {
    private CsvSuggestionWriter sut;

    @Before
    public void setUp() throws Exception {
        sut = new CsvSuggestionWriter();
    }

    @Test
    public void testDoWrite() throws Exception {
        //prepare
        List<CsvSuggestionDto> data = ImmutableList.of(
                new CsvSuggestionDto(376217, "Berlin", "location", 52.52437, 13.41053),
                new CsvSuggestionDto(448103, "Berlingo", "location", 45.50298, 10.04366),
                new CsvSuggestionDto(425332, "Berling\"erode", "location", 51.45775, 10.2384));
        StringWriter actualWriter = new StringWriter();

        //test
        sut.doWrite(new PrintWriter(actualWriter), data);

        //validate
        assertThat(actualWriter.toString(), equalTo(
                "_id,name,type,latitude,longitude\n" +
                        "376217,Berlin,location,52.52437,13.41053\n" +
                        "448103,Berlingo,location,45.50298,10.04366\n" +
                        "425332,\"Berling\"\"erode\",location,51.45775,10.2384\n"
        ));
    }
}