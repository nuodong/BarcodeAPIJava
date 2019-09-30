package com.numob.api.barcode.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Converter(autoApply = true)
public class StringToJsonAttributeConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return  (String) mapper.readValue(dbData, String.class);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
