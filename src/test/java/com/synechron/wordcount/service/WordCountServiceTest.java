package com.synechron.wordcount.service;

import com.synechron.wordcount.model.StaticData;
import com.synechron.wordcount.model.WordCount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WordCountServiceTest {

    private WordCountService wordCountService;

    @Before
    public void setUp(){
       wordCountService = new WordCountService();
    }
    @Test
    public void addWordIntoListTest(){

        WordCount wordCount = wordCountService.addWordIntoList(new WordCount("Flor", 0L));
        Assert.assertNotNull(wordCount);
        Assert.assertEquals("Flor", wordCount.getWord());
    }

    @Test
    public void getWordCountFromStaticListTest(){
        wordCountService.addWordIntoList(new WordCount("Flor", 0L));
        WordCount wordCount = wordCountService.getWordCountFromStaticList("Flor");
        Assert.assertNotNull(wordCount);
        Assert.assertEquals("Flor", wordCount.getWord());
        Assert.assertTrue(1l== StaticData.getInstance().getWorList().size());
    }

    @Test
    public void getWordCountFromStaticListFailedTest(){
        wordCountService.addWordIntoList(new WordCount("Flor", 0L));
        WordCount wordCount = wordCountService.getWordCountFromStaticList("Anil");
        Assert.assertNotNull(wordCount);
        Assert.assertFalse(1l== StaticData.getInstance().getWorList().size());
    }



}
