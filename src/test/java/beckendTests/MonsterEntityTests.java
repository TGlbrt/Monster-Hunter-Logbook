package beckendTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logger.Monster;

public class MonsterEntityTests {
	Monster testMonster;
	
	@Before
	public void setup() {
		testMonster = new Monster();
		testMonster.setId(405);
		testMonster.setName("AbsoluteJUnit");
		testMonster.setElementalWeaknesses("Fire:1,Water:1,Ice:1,Thunder:1,Dragon:1");
		testMonster.setRank(10);
	}
	
	@Test
	public void getIdTest() {
		int expectedId = 405;
		assertEquals("get monster id test error",expectedId,testMonster.getId());
	}
	
	@Test
	public void getNameTest() {
		String expectedName = "AbsoluteJUnit";
		assertEquals("get monster name test error",expectedName,testMonster.getName());
	}
	
	@Test
	public void getElementalWeaknessesTest() {
		String expectedElementalWeaknesses = "Fire:1,Water:1,Ice:1,Thunder:1,Dragon:1";
		assertEquals("get monster elemental weaknesses test error",expectedElementalWeaknesses,testMonster.getElementalWeaknesses());
	}
	
	@Test
	public void getRankTest() {
		int expectedRankTest= 10;
		assertEquals("get monster rank test error",expectedRankTest,testMonster.getRank());
	}
	
	@Test
	public void setIdTest() {
		int expectedId = 5;
		testMonster.setId(expectedId);
		assertEquals("set monster id test error",expectedId,testMonster.getId());
	}
	
	@Test
	public void setNameTest() {
		String expectedName = "UltimateJUnit";
		testMonster.setName(expectedName);
		assertEquals("set monster name test error",expectedName,testMonster.getName());
	}
	
	@Test
	public void setElementalWeaknessesTest() {
		String expectedElementalWeaknesses = "Fire:5,Water:4,Ice:3,Thunder:2,Dragon:1";
		testMonster.setElementalWeaknesses(expectedElementalWeaknesses);
		assertEquals("set monster elemental weaknesses error",expectedElementalWeaknesses,testMonster.getElementalWeaknesses());
	}
	
	@Test
	public void setRankTest() {
		int expectedRank = 4;
		testMonster.setRank(expectedRank);
		assertEquals("set monster rank test error",expectedRank,testMonster.getRank());
	}
}
