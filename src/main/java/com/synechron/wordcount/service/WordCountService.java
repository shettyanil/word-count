package com.synechron.wordcount.service;

import com.synechron.wordcount.model.StaticData;
import com.synechron.wordcount.model.WordCount;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WordCountService {

    
    public WordCount addWordIntoList(WordCount newWord){

        StaticData.getInstance().addToWordList(getTranslateMap().containsKey(newWord.getWord())?getTranslateMap().get(newWord.getWord()):newWord.getWord());

        return newWord;

    }

    public WordCount getWordCountFromStaticList(String word) {

        return new WordCount(word, findWordOccurrences(getWordList(), getTranslateMap().containsKey(word)?getTranslateMap().get(word):word));
    }

    private Map<String, String> getTranslateMap() { return StaticData.getInstance().getTranslateMap();}

    private static List<String> getWordList() {
        return StaticData.getInstance().getWorList();
    }

    private Long findWordOccurrences(List<String> wordList, String word) {

        Map<String, Long>  frequencyMap = wordList.stream()
                .map(String::toLowerCase)
                .filter(wordFromList -> word.equalsIgnoreCase(wordFromList))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.containsKey(word.toLowerCase())?frequencyMap.get(word.toLowerCase()):0l;
    }
}
