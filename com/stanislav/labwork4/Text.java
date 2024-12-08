package com.stanislav.labwork4;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text(String textString) {
        sentences = new ArrayList<>();
        textString = textString.replaceAll("[ \t]+", " ").trim();
        if (textString.isEmpty()) {
            return;
        }

        String[] sentenceStrings = textString.split("(?<=[.!?])\\s+");
        for (String s : sentenceStrings) {
            s = s.trim();
            if (!s.isEmpty()) {
                sentences.add(new Sentence(s));
            }
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}