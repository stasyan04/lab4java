package com.stanislav.labwork4;

import java.util.Comparator;
import java.util.List;

public class TextProcessor {
    public static void main(String[] args) {

        String originalText = "Це перше   речення.   Друге речення має більше слів.  А   це третє речення.";

        Text text = new Text(originalText);

        List<Sentence> sentences = text.getSentences();

        sentences.sort(Comparator.comparingInt(Sentence::getWordCount));

        System.out.println("Речення в порядку зростання кількості слів:");
        for (Sentence s : sentences) {
            System.out.println(s.toString());
        }
    }
}