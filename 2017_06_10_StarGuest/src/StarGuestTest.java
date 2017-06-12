import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class StarGuestTest {
	StarGuest starGuest;
	int COUNT_GUEST = 100;
	int STAR1 = 0;
	int STAR2 = COUNT_GUEST / 2;
	int STAR3 = COUNT_GUEST - 1;

	@Before
	public void setUp() throws Exception {
		starGuest = new StarGuest(COUNT_GUEST);

		Random r = new Random();
		for (int i = 0; i < COUNT_GUEST; i++) {
			for (int j = 0; j < COUNT_GUEST; j++) {
				if (i == j) {
					starGuest.setKnown(i, i);
				} else {
					starGuest.set(i, j, r.nextBoolean());
				}
			}
		}
	}

	@Test
	public void testStar1() {
		setStar(STAR1);
		assertTrue(starGuest.isStar(STAR1));
	}

	@Test
	public void testStar2() {
		setStar(STAR2);
		assertTrue(starGuest.isStar(STAR2));
	}

	@Test
	public void testStar3() {
		setStar(STAR3);
		assertTrue(starGuest.isStar(STAR3));
	}

	private void setStar(int star) {
		for (int i = 0; i < COUNT_GUEST; i++) {
			starGuest.setUnKnown(star, i);
			starGuest.setKnown(i, star); //if i==star - true
		}
	}
}
