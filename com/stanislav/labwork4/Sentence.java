package com.stanislav.labwork4;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> elements;

    public Sentence(String sentenceString) {
        elements = new ArrayList<>();
        sentenceString = sentenceString.replaceAll("[ \t]+", " ").trim();
        if (sentenceString.isEmpty()) {
            return;
        }

        String[] tokens = sentenceString.split(" ");
        for (String token : tokens) {
            if (token.length() > 1 && isPunctuation(token.charAt(token.length() - 1))) {
                String wordPart = token.substring(0, token.length() - 1);
                char punctChar = token.charAt(token.length() - 1);
                if (!wordPart.isEmpty()) {
                    elements.add(new Word(wordPart));
                }
                elements.add(new PunctuationMark(punctChar));
            } else if (token.length() == 1 && isPunctuation(token.charAt(0))) {
                elements.add(new PunctuationMark(token.charAt(0)));
            } else {
                elements.add(new Word(token));
            }
        }
    }

    private boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == '!' || c == '?';
    }

    public int getWordCount() {
        int count = 0;
        for (Object elem : elements) {
            if (elem instanceof Word) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstElement = true;
        for (Object elem : elements) {
            if (elem instanceof Word) {
                if (!firstElement) {
                    sb.append(" ");
                }
                sb.append(elem.toString());
                firstElement = false;
            } else if (elem instanceof PunctuationMark) {
                sb.append(elem.toString());
            }
        }
        return sb.toString();
    }
}