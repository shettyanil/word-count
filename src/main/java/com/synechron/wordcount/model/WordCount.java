package com.synechron.wordcount.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@Data
public class WordCount {

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Word should be Alphabetic")
    private String word;
    private Long wordOccurence;

}
