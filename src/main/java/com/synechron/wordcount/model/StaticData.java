package com.synechron.wordcount.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticData {

    private static StaticData staticDataInstance;
    private List<String> wordList = null;
    private Map<String,String> translateMap = null;

    public static StaticData getInstance() {
        if(staticDataInstance == null)
            staticDataInstance = new StaticData();

        return staticDataInstance;
    }

    private StaticData() {
        wordList = new ArrayList<>();
        translateMap = new HashMap<>();
        translateMap.put("Flor", "Flower");
        translateMap.put("Blume", "Flower");
        translateMap.put("Flower", "Flower");
    }

    public List<String> getWorList() {
        return this.wordList;
    }

    public void addToWordList(String word) {
        wordList.add(word);
    }

    public Map<String, String> getTranslateMap(){return this.translateMap;}


}
