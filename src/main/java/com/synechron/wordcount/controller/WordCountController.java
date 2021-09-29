package com.synechron.wordcount.controller;

import com.synechron.wordcount.model.WordCount;
import com.synechron.wordcount.service.WordCountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@AllArgsConstructor
public class WordCountController {

    @Autowired
    private WordCountService wordCountService;

    @GetMapping(path = "/api/word-count/{word}", produces = {"application/json"})
    public ResponseEntity getWordCountFromStaticList(@PathVariable String word) {

        return new ResponseEntity<>(wordCountService.getWordCountFromStaticList(word), HttpStatus.OK);

    }

    @PostMapping("/api/add-word/")
    public ResponseEntity addWord(@Valid @RequestBody WordCount newWord){

        WordCount wordCount = wordCountService.addWordIntoList(newWord);

        return new ResponseEntity<>(wordCount.getWord()+" added", HttpStatus.OK);
    }





}
