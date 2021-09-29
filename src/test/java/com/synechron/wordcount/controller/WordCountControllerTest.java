package com.synechron.wordcount.controller;

import com.synechron.wordcount.model.WordCount;
import com.synechron.wordcount.service.WordCountService;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class WordCountControllerTest {

    @InjectMocks
    private WordCountController wordCountController;

    private WordCountService wordCountService;

    private Validator validator;

    @Before
    public void setUp(){
        wordCountService = new WordCountService();
        wordCountController = new WordCountController(wordCountService);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void getWordCountTest()  {
        ResponseEntity<JSONObject> responseEntity = wordCountController.getWordCountFromStaticList("Flor");
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void addWordTest(){
        ResponseEntity<JSONObject> responseEntity = wordCountController.addWord(new WordCount("Flower", 0L));
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void addValidWordTest(){
        WordCount wordCount = new WordCount("Anil", 0L);
        Set<ConstraintViolation<WordCount>> violations = validator.validate(wordCount);
        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void addBadWordTest(){
        WordCount wordCount = new WordCount("Flower99", 0L);
        Set<ConstraintViolation<WordCount>> violations = validator.validate(wordCount);
        Assert.assertFalse(violations.isEmpty());
        Assert.assertEquals("Word should be Alphabetic",violations.stream().collect(Collectors.toList()).get(0).getMessageTemplate());
    }

    @Test
    public void addEmptyWordTest(){
        WordCount wordCount = new WordCount("", 0L);
        Set<ConstraintViolation<WordCount>> violations = validator.validate(wordCount);
        Assert.assertFalse(violations.isEmpty());
        Assert.assertEquals("Word should be Alphabetic",violations.stream().collect(Collectors.toList()).get(0).getMessageTemplate());
    }



}
