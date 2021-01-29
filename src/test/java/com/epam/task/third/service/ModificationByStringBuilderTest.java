package com.epam.task.third.service;

import org.junit.Assert;
import org.junit.Test;


public class ModificationByStringBuilderTest {
    ModificationByStringBuilder modificationByStringBuilder = new ModificationByStringBuilder();

    private final static String TESTED_TEXT = "Coupling is the degree of interdependence between software modules.";

    @Test
    public void shouldChangeEverySevenLetterInWords() throws DataException {
        String expectedText = "CoupliXg is the degree of interdXpendence betweeX softwaXe moduleX.";
        String actualText = modificationByStringBuilder.changeEverySeventhLetterInWords(TESTED_TEXT);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void shouldDeleteWordsOfEightLettersBeginningConsonant() throws DataException {
        String expectedText = "is the degree of interdependence between modules.";
        String actualText = modificationByStringBuilder.deleteWordsOfEightLettersBeginningConsonant(TESTED_TEXT);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void shouldSplitTextWithSpace(){
        String[] expectedArray = new String[]{"Coupling", "is", "the", "degree", "of", "interdependence", "between", "software", "modules."};
        String[] actualArray = modificationByStringBuilder.splitTextWithSpace(TESTED_TEXT);
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldCleanWordFromPunctuationMark(){
        String testedWord = "modules.";
        String expectedWord = "modules";
        String actualWord = modificationByStringBuilder.cleanWordFromPunctuationMark(testedWord);
        Assert.assertEquals(expectedWord, actualWord);
    }

    @Test
    public void checkIfEightLetterWordBeginsConsonantShouldReturnTrue(){
        String testedWord = "Coupling";
        boolean actualResult = modificationByStringBuilder.checkIfEightLetterWordBeginsConsonant(testedWord);
        Assert.assertTrue(actualResult);
    }

    @Test(expected = DataException.class)
    public void changeEverySevenLetterInWordsThrowsException() throws DataException {
        String noText = "";
        String actualText = modificationByStringBuilder.changeEverySeventhLetterInWords(noText);
    }

    @Test(expected = DataException.class)
    public void deleteWordsOfEightLettersBeginningConsonantThrowsException() throws DataException {
        String noText = "";
        String actualText = modificationByStringBuilder.deleteWordsOfEightLettersBeginningConsonant(noText);
    }
}
