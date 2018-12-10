package com.jtj.restdocdocsify;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsWebTestClientConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.restdocs.webtestclient.WebTestClientRestDocumentationConfigurer;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/**
 * Created by jiang (jiang.taojie@foxmail.com)
 * 2018/12/9 23:04 End.
 */
@TestConfiguration
public class CustomRestDocsConfiguration implements RestDocsWebTestClientConfigurationCustomizer {
    @Override
    public void customize(WebTestClientRestDocumentationConfigurer configurer) {
        configurer.snippets().withTemplateFormat(TemplateFormats.markdown())
                .and().operationPreprocessors().withResponseDefaults(prettyPrint());
    }
}
