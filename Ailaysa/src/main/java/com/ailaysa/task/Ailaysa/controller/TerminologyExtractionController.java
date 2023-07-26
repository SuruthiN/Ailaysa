package com.ailaysa.task.Ailaysa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class TerminologyExtractionController {

    @PostMapping("/extract-terminology")
    public ResponseEntity<List<String>> extractTerminology(@RequestBody String plainText) {
        try {
            List<String> terminologyList = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");

            Matcher matcher = pattern.matcher(plainText);
            while (matcher.find()) {
                String term = matcher.group();
                terminologyList.add(term);
            }

            return ResponseEntity.ok(terminologyList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
