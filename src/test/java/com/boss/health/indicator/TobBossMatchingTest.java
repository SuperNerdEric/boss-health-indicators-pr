package com.boss.health.indicator;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TobBossMatchingTest
{
	@Test
	public void maidenNameMatchesExactConfigAndRegex()
	{
		String maiden = "The Maiden of Sugadinti";
		assertTrue(BossHealthIndicatorPlugin.nameMatches(maiden, maiden));
		assertTrue(BossHealthIndicatorPlugin.nameMatches("The Maiden.*", maiden));
		assertFalse(BossHealthIndicatorPlugin.nameMatches(maiden, "70.0%"));
		assertFalse(BossHealthIndicatorPlugin.nameMatches("The Maiden.*", "Pestilent Bloat"));
	}

	@Test
	public void theatreBarUsesTheBossNpcInsteadOfAdds()
	{
		assertEquals("The Maiden of Sugadinti", BossHealthIndicatorPlugin.selectTobBossName(
			Arrays.asList("Nylocas Matomenos", "The Maiden of Sugadinti", "Nylocas Matomenos"),
			null));
		assertEquals("Verzik Vitur", BossHealthIndicatorPlugin.selectTobBossName(
			Arrays.asList("The Maiden of Sugadinti", "Verzik Vitur"),
			"Verzik Vitur"));
		assertNull(BossHealthIndicatorPlugin.selectTobBossName(
			Arrays.asList("Nylocas Matomenos", "Nylocas Ischyros"),
			null));
		assertNull(BossHealthIndicatorPlugin.selectTobBossName(
			Arrays.asList("Xarpus", "Sotetseg"),
			null));
		assertEquals("Pestilent Bloat", BossHealthIndicatorPlugin.selectTobBossName(
			Collections.singletonList("Pestilent Bloat"),
			null));
	}
}
