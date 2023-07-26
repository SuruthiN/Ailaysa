package com.ailaysa.task.Ailaysa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") 
public class WordCountController {

    @PostMapping("/wordcount") 
    public ResponseEntity<Integer> countWords(@RequestBody SentenceRequest request) {
        int wordCount = countWordsInSentence(request.getSentence());
        return ResponseEntity.ok(wordCount);
    }

    private int countWordsInSentence(String sentence) {
        return sentence.trim().isEmpty() ? 0 : sentence.trim().split("\\s+").length;
    }
}