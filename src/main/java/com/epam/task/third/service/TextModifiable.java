package com.epam.task.third.service;

public interface TextModifiable {

    String changeEverySeventhLetterInWords(String text) throws DataException;

    String deleteWordsOfEightLettersBeginningConsonant(String text) throws DataException;

}
