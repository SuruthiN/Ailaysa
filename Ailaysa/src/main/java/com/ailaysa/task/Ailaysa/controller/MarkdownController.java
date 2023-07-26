package com.ailaysa.task.Ailaysa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MarkdownController {

    @GetMapping("/markdown")
    public String getMarkdownContent() throws IOException {
        ClassPathResource resource = new ClassPathResource("sample.md");
        if (!resource.exists()) {
            throw new IOException("sample.md not found in the classpath");
        }

        try (InputStream inputStream = resource.getInputStream()) {
            String markdownContent = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

            // Print the content of the "sample.md" file for debugging purposes
            System.out.println(markdownContent);

            MarkdownDocument markdownDocument = new MarkdownDocument(markdownContent);
            return markdownDocument.getPlainText();
        }
    }
}
