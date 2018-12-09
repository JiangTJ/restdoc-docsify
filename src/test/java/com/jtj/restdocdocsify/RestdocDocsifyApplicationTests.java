package com.jtj.restdocdocsify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.annotation.Resource;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@AutoConfigureRestDocs(outputDir = "docs/snippets")
@Import(CustomRestDocsConfiguration.class)
public class RestdocDocsifyApplicationTests {

    @Resource
    private WebTestClient webTestClient;

    @Test
    public void contextLoads() {
        this.webTestClient.get().uri("/").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Server is running!");
    }

    @Test
    public void getUser() {
        this.webTestClient.get().uri("/user").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(document("user",responseFields(
                        fieldWithPath("name").description("The user's name"),
                        fieldWithPath("sex").description("The user's sex"),
                        fieldWithPath("age").description("The user's age"))
                ));
    }
}
