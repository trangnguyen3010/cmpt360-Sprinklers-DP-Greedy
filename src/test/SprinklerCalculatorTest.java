package test;

import main.Garden;
import main.Sprinkler;
import main.SprinklerCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SprinklerCalculatorTest {
    @Test
    public void test_1() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 1.0));
        Garden garden = new Garden(2.0, 2.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_2() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        Garden garden = new Garden(2.0, 2.0, sprinklerList);
        Assert.assertEquals(1, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_3() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(0.0, 2.0));
        sprinklerList.add(new Sprinkler(1.5, 1.5));
        Garden garden = new Garden(2.0, 2.0, sprinklerList);
        Assert.assertEquals(2, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_4() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        sprinklerList.add(new Sprinkler(1.5, 1.5));
        Garden garden = new Garden(3.0, 2.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_5() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        sprinklerList.add(new Sprinkler(1.5, 1.5));
        sprinklerList.add(new Sprinkler(2.0, 2.0));
        Garden garden = new Garden(3.0, 2.0, sprinklerList);
        Assert.assertEquals(2, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenOneSprinklerCoveredExactlyGarden_expectOne() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 5.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(1, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenOneSprinklerCoveredMoreThanGarden_expectOne() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 10.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(1, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenOneSprinklerCoveredLessThanGarden1_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 3.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenOneSprinklerCoveredLessThanGarden2_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 1.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklerEachCoveredMoreThanGarden_expectOne() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(2.0, 10.0));
        sprinklerList.add(new Sprinkler(7.0, 15.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(1, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklerBothCoveredThanGarden_expectTwo() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(0.0, 7.0));
        sprinklerList.add(new Sprinkler(8.0, 7.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(2, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklerBothNotCoveredThanGardenNotOverlapped_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        sprinklerList.add(new Sprinkler(4.0, 1.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklerBothNotCoveredThanGardenOverlapped1_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        sprinklerList.add(new Sprinkler(2.0, 4.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklerBothNotCoveredThanGardenOverlapped2_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 6.0));
        sprinklerList.add(new Sprinkler(2.0, 2.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFourSprinklersCoveringPartially_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(2.0, 3.0));
        sprinklerList.add(new Sprinkler(4.0, 3.0));
        sprinklerList.add(new Sprinkler(7.0, 4.0));
        sprinklerList.add(new Sprinkler(8.0, 3.0));
        Garden garden = new Garden(10.0, 5.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFiveSprinklersCoverGarden_expectFour() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(2.0, 3.0));
        sprinklerList.add(new Sprinkler(4.0, 3.0));
        sprinklerList.add(new Sprinkler(7.0, 3.0));
        sprinklerList.add(new Sprinkler(8.0, 2.0));
        sprinklerList.add(new Sprinkler(9.0, 2.0));
        Garden garden = new Garden(10.0, 1.0, sprinklerList);
        Assert.assertEquals(3, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwo_OneSmallerThanWidth_OneCoveredPartially_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(2.0, 2.0));
        sprinklerList.add(new Sprinkler(6.0, 5.0));
        Garden garden = new Garden(10.0, 5.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenTwoSprinklersBothNotCovered_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 6.0));
        sprinklerList.add(new Sprinkler(2.0, 2.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }


    @Test
    public void test_givenFourSprinklers_AllWithinEachOther_NotCoveredGarden_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 1.0));
        sprinklerList.add(new Sprinkler(5.0, 3.0));
        sprinklerList.add(new Sprinkler(6.0, 4.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFourSprinklers_AllWithinEachOther_OneCoveredGarden_expectOne() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(4.0, 1.0));
        sprinklerList.add(new Sprinkler(5.0, 3.0));
        sprinklerList.add(new Sprinkler(6.0, 4.0));
        sprinklerList.add(new Sprinkler(6.0, 11.0));
        Garden garden = new Garden(8.0, 6.0, sprinklerList);
        Assert.assertEquals(1, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFourSprinklers_AllSeparateEachOther_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 3.0));
        sprinklerList.add(new Sprinkler(7.0, 3.0));
        sprinklerList.add(new Sprinkler(13.0, 3.0));
        sprinklerList.add(new Sprinkler(15.0, 1.0));
        Garden garden = new Garden(15.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFourSprinklers_AllSeparateEachOtherSmallerThanWidth_expectZero() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(1.0, 2.0));
        sprinklerList.add(new Sprinkler(7.0, 2.0));
        sprinklerList.add(new Sprinkler(13.0, 1.0));
        sprinklerList.add(new Sprinkler(15.0, 1.0));
        Garden garden = new Garden(15.0, 6.0, sprinklerList);
        Assert.assertEquals(0, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }

    @Test
    public void test_givenFourSprinklers_TwoCoveredGarden_expectTwo() {
        List<Sprinkler> sprinklerList = new ArrayList<>();
        sprinklerList.add(new Sprinkler(0.0, 10.0));
        sprinklerList.add(new Sprinkler(7.0, 4.0));
        sprinklerList.add(new Sprinkler(13.0, 4.0));
        sprinklerList.add(new Sprinkler(15.0, 10.0));
        Garden garden = new Garden(15.0, 6.0, sprinklerList);
        Assert.assertEquals(2, SprinklerCalculator.calculateMinimumSprinklers(garden));
    }
}