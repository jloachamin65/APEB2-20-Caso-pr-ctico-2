package com.org.arquitectura.web.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;


public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
