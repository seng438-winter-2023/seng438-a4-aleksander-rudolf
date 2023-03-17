package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.chart.util.ParamChecks;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	
	/**
	 * Tests for Range() constructor
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void rangeConstructorLowerGreaterThanUpper() {
		
	            Range range = new Range(10,-10);

	}
	
	/**
	 * Tests for the contains() method
	 */
	
	@Test
    public void containsValueBetweenUpperAndLowerBound() {
		Range range = new Range(-10, 10);
        assertEquals("The range contains 5 should be true", true, range.contains(5));
    }

    @Test 
    public void containsValueForUpperBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 10 should be true", true, range.contains(10));
    }

    @Test
    public void containsValueForLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains -10 should be true", true, range.contains(-10));
    }

    @Test
    public void containsLessThanLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains -11 should be false", false, range.contains(-11));
    }

    @Test
    public void containsMoreThanLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 11 should be false", false, range.contains(11));
    }
    
    @Test
    public void containsDecimalInRange() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 0.14 should be true", true, range.contains(0.14));
    }
    
    /**
     * Tests for the getLength() method
     */

    @Test
    public void getLengthSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are the same", 0, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthPositiveLowerUpperBound() {
    	
    	Range range = new Range(1, 10);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are positive but different", 9, range.getLength(), .000000001d);
    }

    @Test
    public void getLengthNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are negative but different", 9, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-10, 10);
    	
        assertEquals("This test is for checking the length of the range when the lower bound is negative and upper bound is positive", 20, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are decimals", 20.81, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNullRange() {
    	
		 try {
	            Range range = null;
	            range.getLength();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the length of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getLowerBound() method
     */

    @Test
    public void getLowerBoundSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are the same", 1, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundPositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are positive but different", 5, range.getLowerBound(), .000000001d);
    }

    @Test
    public void getLowerBoundNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are negative but different", -10, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower bound is negative and upper bound is positive", -20, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are decimals", -10.32, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNullRange() {
    	
		 try {
	            Range range = null;
	            range.getLowerBound();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the lower bound of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getUpperBound() method
     */

    @Test
    public void getUpperBoundSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are the same", 1, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundPositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are positive but different", 10, range.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBoundNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are negative but different", -1, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower bound is negative and upper bound is positive", 10, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are decimals", 10.49, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNullRange() {
    	
		 try {
	            Range range = null;
	            range.getUpperBound();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the upper bound of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getCentralValue() method
     */

    @Test
    public void getCentralValueSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are the same", 1, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValuePositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are positive but different", 7.5, range.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValueNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are negative but different", -5.5, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the central value of the range when the lower bound is negative and upper bound is positive", -5, range.getCentralValue(), .000000001d);
    }
    
//    @Test
//    public void getCentralValueDecimalRange() {
//    	
//    	Range range = new Range(-10.32, 10.49);
//    	
//        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are decimals", 10.40, range.getCentralValue(), .000000001d);
//    }
    
    @Test
    public void getCentralValueNullRange() {
    	
		 try {
	            Range range = null;
	            range.getCentralValue();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the central value of a null range object", NullPointerException.class,
	                    e.getClass());
	        
	        }
    }
    
    // Tests for constrain
    
    @Test
    public void constrainTestLessThanLowerBound() {
    	Range range = new Range(-10, 10);
    	assertEquals("This test is for checking the constrain return value for a value less than the lower bound", -10, range.constrain(-20), .000000001d);
    }

    @Test
    public void constrainTestGreaterThanUpperBound() {
    	Range range = new Range(-10, 10);
    	assertEquals("This test is for checking the constrain return value for a value greater than the upper bound", 10, range.constrain(20), .000000001d);
    }
    
    @Test
    public void constrainBetweenUpperAndLowerBound() {
    	Range range = new Range(-10, 10);
    	double value = 9.5;
    	assertEquals("This test is for checking the constrain return value for a value between the upper and lower bound", value, range.constrain(9.50), .000000001d);
    }
    
    @Test 
    public void constrainIsUpperBound() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is for checking the constrain return value for a value that is the upper bound of the range", 10, range.constrain(10), .000000001d);
    }
    
    @Test 
    public void constrainIsLowerBound() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is for checking the constrain return value for a value that is the lower bound of the range", -10, range.constrain(-10), .000000001d);
    }

    // Tests for  intersects(double a, double b)
    
    @Test
    public void overlappingRangeIntersects() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is to test intersect for a range that is within the specificed range ", true, range.intersects(-9, 9));
    }
    
    @Test
    public void overlappingDecimalIntersects() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is to test intersect for a range that is within the specificed decimal range ", true, range.intersects(-9.5, 9.5));
    }
    
    @Test 
    public void largerRangeIntersects() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is to test intersect for a range that is larger than the specificed range ", false, range.intersects(20, 40));
    }
    
    @Test
    public void smallerRangeIntersects() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is to test intersect for a range that is smallerr than the specificed range ", false, range.intersects(-20, -11));
    }
    
    @Test
    public void sameRangeIntersect() {
    	Range range = new Range(-10,10);
    	assertEquals("This test is to test intersect for a range that is the same as the specificed range ", true, range.intersects(-10, 10));
    }
    
// Tests for Intersect(Range range)
    
    @Test
    public void overlappingRangeIntersects2() {
    	Range range = new Range(-10,10);
    	Range testRange = new Range(-9,9);
    	assertEquals("This test is to test intersect for a range that is within the specificed range ", true, range.intersects(testRange));
    }
    
    @Test
    public void overlappingRangeIntersectsDecimal2() {
    	Range range = new Range(-10,10);
    	Range testRange = new Range(-9.5,9.5);
    	assertEquals("This test is to test intersect for a range that is within the specificed range ", true, range.intersects(testRange));
    }
    
    @Test 
    public void largerRangeIntersects2() {
    	Range range = new Range(-10,10);
    	Range testRange = new Range(20, 30);
    	assertEquals("This test is to test intersect for a range that is larger than the specificed range ", false, range.intersects(testRange));
    }
    
    @Test 
    public void smallerRangeIntersects2() {
    	Range range = new Range(-10,10);
    	Range testRange = new Range(-30, -20);
    	assertEquals("This test is to test intersect for a range that is smaller than the specificed range ", false, range.intersects(testRange));
    }
    
    @Test 
    public void sameRangeIntersects2() {
    	Range range = new Range(-10,10);
    	Range testRange = new Range(-10, 10);
    	assertEquals("This test is to test intersect for a range that is smaller than the specificed range ", true, range.intersects(testRange));
    }
    
	
	@Test
	public void rangeIntersectsBoundary() {
		Range range = new Range(3, 4);
		Range testRange = new Range(3, 3);
    	assertEquals("This test is to test intersect for boundary ", false, range.intersects(testRange));
	}
    
 // Test's for combing ranges
    
    @Test
    public void combineTwoNullRanges() {
    	Range range = null;
    	Range range2 = null;
    	assertEquals("This test is for combining two null ranges", null, Range.combine(range, range2));
    }
    
    @Test
    public void combineOneNullandOneNonNullRange() {
    	Range range = null;
    	Range range2 = new Range(-10,10);
    	assertEquals("This test is for combining a null range and a none null range", range2, Range.combine(range, range2));
    }
    
    @Test
    public void combineOneNullandOneNonNullRange2() {
    	Range range = new Range(-10,10);
    	Range range2 = null;
    	assertEquals("This test is for combining a null range and a none null range", range, Range.combine(range, range2));
    }
    
    @Test
    public void combineTwoNonOverlappingNonNullRanges() {
    	Range range = new Range(-5, 5);
    	Range range2 = new Range(5,10);
    	Range result = new Range(-5,10);
    	assertEquals("This test is for combining two non null and non overlapping ranges", result, Range.combine(range, range2));
    }
    
    @Test
    public void combineTwoOverlappingNullRanges() {
    	Range range = new Range(-5, 5);
    	Range range2 = new Range(-20,10);
    	Range result = new Range(-20,10);
    	assertEquals("This test is for combining two non null and overlapping ranges", result, Range.combine(range, range2));
    }
    

    /**
	 * Tests for the equals() method
	 */
	
	@Test
    public void equalsNullObject() {
		Range range = new Range(-10, 10);
        assertEquals("The range equals null should be false", false, range.equals(null));
    }
	
	@Test
    public void equalsRangeWithDifferentLowerBounds() {
		Range range1 = new Range(-10, 10);
		Range range2 = new Range(-20, 10);
        assertEquals("range1 does not equal range2 so the result should be false", false, range1.equals(range2));
    }
	
	@Test
    public void equalsRangeWithDifferentUpperBounds() {
		Range range1 = new Range(-10, 10);
		Range range2 = new Range(-10, 20);
        assertEquals("range1 does not equal range2 so the result should be false", false, range1.equals(range2));
    }
	
	@Test
    public void equalsRangeWithSameBounds() {
		Range range1 = new Range(-10, 10);
		Range range2 = new Range(-10, 10);
        assertEquals("range1 does range2 so the result should be true", true, range1.equals(range2));
    }
	
	@Test
    public void equalsRangeWithNull() {
		Range range1 = new Range(-10, 10);
		Range range2 = null;
        assertEquals("range1 does range2 so the result should be false", false, range1.equals(range2));
    }
	

	
	// tests for min function
	
	@Test
	public void scaleRangeByNull() {
		 try {
	            Range range = new Range(-10,10);
	            Range.scale(range, 0);

	        } catch (Exception e) {
	            assertEquals("This test is for checking the scale method when the scale factor is 0", IllegalArgumentException.class,
	                    e.getClass());
	        }
	}
	
	
	@Test
	public void scaleRangeByNegative() {
		 try {
	            Range range = new Range(-10,10);
	            Range.scale(range, -10);

	        } catch (Exception e) {
	            assertEquals("This test is for checking the scale method when the scale factor is negative", IllegalArgumentException.class,
	                    e.getClass());
	        }
	}
	
	@Test
	public void scaleRangeByDecimal() {
		Range range = new Range(-10,10);
		Range expectedRange = new Range(-5,5);
		assertEquals("This test is for checking the scale method when a decimal factor is given", expectedRange, Range.scale(range, 0.5));
	}
	
	@Test
	public void scaleRangeWholeNumber() {
		Range range = new Range(-10,10);
		Range expectedRange = new Range(-20,20);
		assertEquals("This test is for checking the scale method when a whole number factor is given", expectedRange, Range.scale(range, 2));
	}

	@Test
	public void scaleByOne() {
		Range range = new Range(-10,10);
		assertEquals("This test is for checking the scale method when a factor of 1 is given", range, Range.scale(range, 1));
	}
	
// Tests for isNaNRange
    
    @Test
    public void lowerValueNaN() {
    	Range range = new Range(0.0/0.0, 10);
    	assertEquals("This test is checking the results of isNaNRange when the lower bound is NaN", false, range.isNaNRange());
    }
    
    @Test
    public void upperValueNaN() {
    	Range range = new Range(-10, 0.0/0.0);
    	assertEquals("This test is checking the results of isNaNRange when the upper bound is NaN", false, range.isNaNRange());
    }
    
    @Test
    public void upperAndLowerValueNaN() {
    	Range range = new Range(0.0/0.0, 0.0/0.0);
    	assertEquals("This test is checking the results of isNaNRange when the upper and lower bound is NaN", true, range.isNaNRange());
    }
    
    /**
	 * Tests for the expandToInclude() method
	 */
	
	@Test
    public void expandToIncludeNullRange() {
		Range expectedRange = new Range(30, 30);
        assertEquals("A new range should be created with a lower bound of 30, and upper bound of 30", expectedRange, Range.expandToInclude(null, 30));
    }
	
	@Test
    public void expandToIncludeRangeSmallerLowerBound() {
		Range range = new Range(-30, 30);
		Range expectedRange = new Range(-40, 30);
        assertEquals("The range should now have a lower bound of -40", expectedRange, Range.expandToInclude(range, -40));
    }
	
	@Test
    public void expandToIncludeRangeLargerUpperBound() {
		Range range = new Range(-30, 30);
		Range expectedRange = new Range(-30, 40);
        assertEquals("The range should now have an upper bound of 40", expectedRange, Range.expandToInclude(range, 40));
    }
	
	@Test
    public void expandToIncludeRangeSameLowerUpperBound() {
		Range range = new Range(30, 30);
		Range expectedRange = new Range(30, 30);
        assertEquals("The range should be the same as the original expectedRange", expectedRange, Range.expandToInclude(range, 30));
    }
	
	// Tests for combingIgnoringNaNB
	
	
	@Test 
	public void combineIgnoringNaNBothNullRanges() {
		Range range = null;
		Range range2 = null;
		assertEquals("This text is for combining two null ranges using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
	}
	
	@Test 
	public void combineIgnoringNaNFirstIsNullRange() {
		Range range = null;
		Range range2 = new Range(-10,10);
		assertEquals("This text is for combining 2 ranges (the first is null and the second is not null) using the NaN combine function", range2, Range.combineIgnoringNaN(range, range2));
	}
	
//	@Test 
//	public void combineIgnoringNaNFirstIsNulSecondIsNaNLowerBoundlRange() {
//		Range range = null;
//		Range range2 = new Range(0.0/0.0, 10);
//		Range expected = new Range(0,10);
//		assertEquals("This text is for combining 2 ranges (the first is null and the second has NaN as Lower Bound) using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
//	
//	@Test 
//	public void combineIgnoringNaNFirstIsNulSecondIsNaNUpperlRange() {
//		Range range = null;
//		Range range2 = new Range(0, Double.NaN);
//		Range expected = new Range(0,10);
//		assertEquals("This text is for combining 2 ranges (the first is null and the second has NaN as an Upper Bound) using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
//	
	@Test 
	public void combineIgnoringNaNSecondIsNullRange() {
		Range range = new Range(-10,10);
		Range range2 = null;
		assertEquals("This test is for combining 2 ranges (the second is null and the first is not null) using the NaN combine function", range, Range.combineIgnoringNaN(range, range2));
	}
	
//	@Test 
//	public void combineIgnoringNaNSecondIsNullFirsthasNaNUpperRange() {
//		Range range = new Range(-10,10/0.0);
//		Range range2 = null;
//		Range expected = new Range(-10,10);
//		assertEquals("This test is for combining 2 ranges (the second is null and the first is has NaN upper bound) using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
//	
//	@Test 
//	public void combineIgnoringNaNSecondIsNullFirsthasNaNRange() {
//		Range range = new Range(Double.NaN,10);
//		Range range2 = null;
//		Range expected = new Range(-10,10);
//		assertEquals("This test is for combining 2 ranges (the second is null and the first is has NaN lower bound) using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
	
	
	@Test
	public void firstRangeHasNaNLowerBound() {
		Range range = new Range(0.0/0.0, 10);
		Range range2 = new Range(-20, 20);
		assertEquals("This test is for combining 2 ranges first has NaN lower bound using the NaN combine function", range2, Range.combineIgnoringNaN(range, range2));
	}
	
	@Test
	public void firstRangeHasNaNupperBound() {
		Range range = new Range(10, Double.NaN);
		Range range2 = new Range(-20, 20);
		assertEquals("This test is for combining 2 ranges first has NaN upper bound using the NaN combine function", range2, Range.combineIgnoringNaN(range, range2));
	}
	
	
	@Test
	public void secondRangeHasLowerBoundNaN() {
		Range range = new Range(-10, 10);
		Range range2 = new Range(0.0/0.0, 5);
		assertEquals("This test is for combining 2 ranges second has NaN lower bound using the NaN combine function", range, Range.combineIgnoringNaN(range, range2));
	}
	
	@Test
	public void secondRangeHasUpperBoundNaN() {
		Range range = new Range(-10, 10);
		Range range2 = new Range(5, Double.NaN);
		assertEquals("This test is for combining 2 ranges second has NaN upper bound using the NaN combine function", range, Range.combineIgnoringNaN(range, range2));
	}
	
//	@Test
//	public void firstRangeHasNaNUpperAndOverlappingRange() {
//		Range range = new Range(-10, Double.NaN);
//		Range range2 = new Range(-20, 9);
//		Range expected = new Range(-20,10);
//		assertEquals("This test is for combining 2 ranges first has NaN upper bound and ranges are overrlapping using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
	
	@Test
	public void firstRangeHasNaNLowerAndOverlappingRange() {
		Range range = new Range(0.0/0.0, 10);
		Range range2 = new Range(-20, 9);
		Range expected = new Range(-20,10);
		assertEquals("This test is for combining 2 ranges first has NaN lower bound and ranges are overrlapping using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
	}
	

	
	@Test
	public void secondRangeHasNaNLowerAndOverlappingRange() {
		Range range = new Range(-20, 9);
		Range range2 = new Range(0.0/0.0, 10);
		Range expected = new Range(-20,10);
		assertEquals("This test is for combining 2 ranges second has NaN lower bound and ranges are overlapping using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
	}
	
//	@Test
//	public void secondRangeHasNaNUpperAndOverlappingRange() {
//		Range range = new Range(-20, 9);
//		Range range2 = new Range(10, Double.NaN);
//		Range expected = new Range(-20,10);
//		assertEquals("This test is for combining 2 ranges second has NaN upper bound and ranges are overlapping using the NaN combine function", expected, Range.combineIgnoringNaN(range, range2));
//	}
//	
	@Test
	public void secondRangeUpperAndLowerBoundInvalid() {
		Range range = null;
		Range range2 = new Range(Double.NaN, Double.NaN);
		assertEquals("This test is for combining 2 ranges second has NaN upper bound and ranges are overlapping using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
	}
	
	@Test
	public void firstRangeUpperAndLowerBoundInvalid() {
		Range range2 = null;
		Range range = new Range(Double.NaN, Double.NaN);
		assertEquals("This test is for combining 2 ranges second has NaN upper bound and ranges are overlapping using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
	}
	
//	@Test
//	public void bothRangesHaveNaNLowerBound() {
//		Range range = new Range(0.0/0.0, 5);
//		Range range2 = new Range(0.0/0.0, 10);
//		assertEquals("This test is for combining 2 ranges that both have NaN lower bound using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
//	}
	
//	@Test
//	public void bothRangesHaveNaNUpperBound() {
//		Range range = new Range(5, 0.0/0.0);
//		Range range2 = new Range(5, Double.NaN);
//		assertEquals("This test is for combining 2 ranges that both have NaN upper bound using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
//	}
//	
//	@Test
//	public void bothRangesHaveNaNUpperAndLowerBound() {
//		Range range = new Range(5, 0.0/0.0);
//		Range range2 = new Range(5, Double.NaN);
//		assertEquals("This test is for combining 2 ranges that both have NaN upper and lower bound using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
//	}
	
//	@Test
//	public void bothRangesHaveNaNUpper1AndLower2Bound() {
//		Range range = new Range(Double.NaN, 10);
//		Range range2 = new Range(5, Double.NaN);
//		assertEquals("This test is for combining 2 ranges that both have NaN upper and lower bound using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
//	}
	
//	@Test
//	public void bothRangesHaveNaNUpper1AndLower2BoundFlipped() {
//		Range range = new Range(0, Double.NaN);
//		Range range2 = new Range(Double.NaN, 5);
//		assertEquals("This test is for combining 2 ranges that both have NaN upper and lower bound using the NaN combine function", null, Range.combineIgnoringNaN(range, range2));
//	}
	
	
	
	@Test

    public void toStringWhenObjectIsNull() {
    	
		 try {
	            Range range = null;
	            range.toString();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the  of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }

    @Test

    public void toStringWhenObjectIsNotNull() {
    	
	            Range range = new Range(-10,10);            
	            assertEquals("This test is for checking the  of a not null range object", "Range[-10.0,10.0]",
	            		range.toString());
	            
    }
    
    
    @Test
    public void hashCodeRangeIsNull() {
		 try {
	            Range range = null;
	            range.hashCode();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the  of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
	@Test
	public void hashCodeWithAValue() {
		Range range = new Range(2, 6);
		int testHashCodeResult = range.hashCode();
		assertEquals("this test checks thw functionality of hashcode when a particular range object", -2145910784, testHashCodeResult);

	}
	
	@Test (expected = IllegalArgumentException.class)
	public void scaleByNegativeZeroPointFive() {
		
	            Range range = new Range(-10,10);
	            Range.scale(range, -0.5);

	}
    @Test   
    public void hashCodeWhenObjectIsNotNull() {
    	
        Range range = new Range(-10,10);            
        assertNotEquals("This test is for checking the  of a not null range object", null,
        		range.hashCode());
    }

    
	

	@Test

    public void shiftWhenallowZeroCrossingIsTrue() {
    	
	            Range range = new Range(-10,10);
	            Range rangeExpected = new Range(-5,15); 
	            assertEquals("This test is for checking when allowZeroCrossing is True ", rangeExpected,
	            		Range.shift(range,5,true));
    }
	@Test

    public void shiftWhenallowZeroCrossingIsFalse() {
    	
	            Range range = new Range(-10,10);            
	            assertEquals("This test is for checking when allowZeroCrossing is False", new Range(-5,15),
	            		Range.shift(range,5,false));
    }
	
	@Test
	
    public void shiftWhenallowZeroCrossingIsFalseAndOneBoundIsZero() {
    	
        Range range = new Range(0,10);            
        assertEquals("This test is for checking when allowZeroCrossing is False", new Range(5,15),
        		Range.shift(range,5,false));
    }
	
	
	@Test

    public void shiftWhenallowZeroCrossing() {
    	
	            Range range = new Range(-10,10);
	            Range rangeExpected = new Range(-5,15); 
	            assertEquals("This test is for checking when allowZeroCrossing is not given ", rangeExpected,
	            		Range.shift(range,5));
    }
	
	/**
	 * Tests for the expand() method
	 */
	
	@Test
    public void expandNullRange() {
		
		try {
			Range expectedRange = new Range(-11, 11);
		}
		catch(Exception e) {
           assertEquals("A new range should be created with a lower bound of -11, and upper bound of 11", NullPointerException.class,
                   e.getClass());
           
		}   
    }
	
	@Test
    public void expandRangePositiveLowerUpperBoundMargins() {
		Range range = new Range(-10, 10);
		Range expectedRange = new Range(-32, 32);
        assertEquals("The range should now have a lower bound of -32, and an upper bound of 32", expectedRange, Range.expand(range, 1.1, 1.1));
    }
	
	@Test
    public void expandRangeNegativeLowerPositiveUpperBoundMargins() {
		Range range = new Range(1, 2);
		Range expectedRange = new Range(6.55, 6.55);
        assertEquals("The range should now have a lower bound of 6.55, and an upper bound of 6.55", expectedRange, Range.expand(range, -10.0, 0.1));
    }
	
	@Test
    public void isNaNRangeTestLowerBoundForNaN() {
	    Range range = new Range(Double.NaN,Double.NaN);
		assertTrue("The Range lower bound is NaN so should be true.",range.isNaNRange());
   }
   
   @Test
   public void isNaNRangeTestUpperBoundForNaN() {
	   Range range=new Range(Double.NaN, Double.NaN);
	   assertTrue("The Range upper bound is NaN so should be true",range.isNaNRange());
   }
   
   @Test
   public void containsLowerIsGreaterThanUpper() {
		
		try {
		   Range range = new Range(10, -10);
		
		}
		catch(Exception e) {
			  assertEquals("This test is for checking invalid range", IllegalArgumentException.class,
	                    e.getClass());
		}
       
   }   
//   
//   @Test
//   public void getLengthLowerIsGreaterThanUpper() {
//	   
//	   
//	       try {
//	    	   
//	    	   Range range = new Range(10, -10);
//	    	   range.getLength();
//	       }
//		   catch(Exception e) {
//			   
//			   assertEquals("This test is for checking invalid range", NullPointerException.class,e.getClass());
//		   }
//		   
//	       
//       
//   }
   
   @Test
   public void getLowerBoundLowerIsGreaterThanUpper() {
		
		try {
		   Range range = new Range(10, -10);
		   range.getLowerBound();
		}
		catch(Exception e) {
			  assertEquals("This test is for checking invalid range", IllegalArgumentException.class,
	                    e.getClass());
		}
       
   }
   
   @Test
   public void getUpperBoundLowerIsGreaterThanUpper() {
		
		try {
		   Range range = new Range(10, -10);
		   range.getUpperBound();
		}
		catch(Exception e) {
			  assertEquals("This test is for checking invalid range", IllegalArgumentException.class,
	                    e.getClass());
		}
       
   }
   
   public void getCentralValueLowerIsGreaterThanUpper() {
		
		try {
		   Range range = new Range(10, -10);
		   range.getCentralValue();
		}
		catch(Exception e) {
			  assertEquals("This test is for checking invalid range", IllegalArgumentException.class,
	                    e.getClass());
		}
       
   }
   
   @Test
   public void isNanRangeTestLowerBoundForDouble() {
	   Range range= new Range(0,0);
	   assertFalse("The Range is a double so should be false", range.isNaNRange());
   }
   
   @Test
   public void isNaNRangeTestUpperBoundForDouble() {
	   Range range = new Range(0,0);
	   assertFalse("The Range upper bound is a double so should be false.", range.isNaNRange());
   }
   
	

    
    
}