package com.example.baseconcept.config;

import com.example.baseconcept.model.AuditDocument;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.Date;
import java.util.Objects;

@Configuration
//@EnableMongock
public class MongoConfig {

    public static class BeforeConvertListener extends AbstractMongoEventListener<AuditDocument> {
        @Override
        public void onBeforeConvert(BeforeConvertEvent<AuditDocument> event) {
            AuditDocument source = event.getSource();
            if (Objects.isNull(source.getCreatedAt()))
                source.setCreatedAt(new Date());

            source.setUpdatedAt(new Date());
        }
    }

    @Bean
    public BeforeConvertListener updatePreSave() {
        return new BeforeConvertListener();
    }
}
