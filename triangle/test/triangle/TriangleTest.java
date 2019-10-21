package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {
    // basic test
    @Test
    public void test1() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }

    // invalid inputs
    @Test
    public void test_invalid_input1() {
        Type actual = Triangle.classify(-1, 10, 10);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    @Test
    public void test_invalid_input2() {
        Type actual = Triangle.classify(10, -1, 10);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }
    @Test
    public void test_invalid_input3() {
        Type actual = Triangle.classify(10, 10, -1);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }

    // unique length invliad
    @Test
    public void test_unique_length_invalid() {
        Type actual = Triangle.classify(1, 2, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }

    @Test
    public void test_unique_length_invalid1() {
        Type actual = Triangle.classify(1, 7, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }

    @Test
    public void test_unique_length_invalid2() {
        Type actual = Triangle.classify(9, 2, 5);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }

    // unique length valid
    @Test
    public void test_unique_length_valid1() {
        Type actual = Triangle.classify(12, 7, 8);
        Type expected = SCALENE;
        assertEquals(actual, expected);
    }

    // tran >  3 part 1
    @Test
    public void test_tran3_1() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }

    // trian == 1 && a + b > c)
    @Test
    public void test_ISO_1() {
        Type actual = Triangle.classify(10, 10, 1);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }

    // trian == 2 && a + c > b
    @Test
    public void test_ISO_2() {
        Type actual = Triangle.classify(10, 1, 10);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }

    // trian == 3 && b + c > a
    @Test
    public void test_ISO_3() {
        Type actual = Triangle.classify(1, 10, 10);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
    }
    
    @Test
    public void INVALID() {
        Type actual = Triangle.classify(100, 10, 10);
        Type expected = INVALID;
        assertEquals(actual, expected);
    }

      @Test
    // mutation test for isosceles
    public void testIsosceles(){
	// triangle type: scalene, isosceles, equilateral
	// condition: triple negative, single negative, double negative, inequality
	// a = b, valid isosceles
	assertEquals(Triangle.classify(3,3,5), ISOSCELES);
	// a = c, valid isosceles
	assertEquals(Triangle.classify(5,3,5), ISOSCELES);
	// b = c, valid isosceles
        assertEquals(Triangle.classify(3,5,5), ISOSCELES);
   	// a = b, but a+b=c
	assertEquals(Triangle.classify(3,3,6), INVALID);
	// a = c, but a+c=b
	assertEquals(Triangle.classify(3,6,3), INVALID);
	// b = c, but b+c=a
	assertEquals(Triangle.classify(6,3,3), INVALID);
	// a = b, but a+b<c
	assertEquals(Triangle.classify(3,3,7), INVALID);
	// a = c, but a+c<b
	assertEquals(Triangle.classify(3,7,3), INVALID);
	// b = c, but b+c<a
	assertEquals(Triangle.classify(7,3,3), INVALID);

    }
  

   @Test
   // mutation test for EQUILATERAL
    public void testEquilateral(){
	// triangle type: scalene, isosceles, equilateral
	// condition: triple negative, single negative, double negative, inequality
	// valid equilateral
	assertEquals(Triangle.classify(6,6,6), EQUILATERAL);
	// all negative equilateral
	assertEquals(Triangle.classify(-6,-6,-6), INVALID);
	// double negative equilateral
	assertEquals(Triangle.classify(6,-6,-6), INVALID);
	// double negative equilateral
	assertEquals(Triangle.classify(-6,6,-6), INVALID);
	// double negative equilateral
	assertEquals(Triangle.classify(-6,-6,6), INVALID);
	// single negative equilateral
	assertEquals(Triangle.classify(6,6,-6), INVALID);
	// single negative equilateral
	assertEquals(Triangle.classify(6,-6,6), INVALID);
	// single negative equilateral
	assertEquals(Triangle.classify(-6,6,6), INVALID);
	// small length
	assertEquals(Triangle.classify(1,1,1), EQUILATERAL);
	// zero length
	assertEquals(Triangle.classify(0,1,1), INVALID);
	// zero length
	assertEquals(Triangle.classify(1,0,1), INVALID);
	// zero length
	assertEquals(Triangle.classify(1,1,0), INVALID);
    }

   
   @Test
   // mutation test for SCALENE
    public void testSCALENE(){
   	// regular triangle
	assertEquals(Triangle.classify(3,4,5),SCALENE);
	// triple negative regular triangle
	assertEquals(Triangle.classify(-3,-4,-5),INVALID);
	// single negative regular triangle
	assertEquals(Triangle.classify(-3,4,5),INVALID);
	// single negative regular triangle
	assertEquals(Triangle.classify(3,-4,5),INVALID);
	// single negative regular triangle
	assertEquals(Triangle.classify(3,4,-5),INVALID);
	// double negative regular triangle
	assertEquals(Triangle.classify(3,-4,-5),INVALID);
	// double negative regular triangle
	assertEquals(Triangle.classify(-3,4,-5),INVALID);
	// double negative regular triangle
	assertEquals(Triangle.classify(-3,-4,5),INVALID);
	// a+b<c
	assertEquals(Triangle.classify(3,4,8), INVALID);
	// a+c<b
	assertEquals(Triangle.classify(3,8,4), INVALID);
	// b+c<a
	assertEquals(Triangle.classify(8,4,3), INVALID);  
	// a+b=c
	assertEquals(Triangle.classify(3,4,7), INVALID);
	// a+c=b
	assertEquals(Triangle.classify(3,7,4), INVALID);
	// b+c=a
	assertEquals(Triangle.classify(7,4,3), INVALID);  
	//mutant 76
	//mutant 11 not caught
	//mutant 80
	assertEquals(Triangle.classify(91,10,100),SCALENE);
	assertEquals(Triangle.classify(100,10,91),SCALENE);
	assertEquals(Triangle.classify(100,91,10),SCALENE);
   }

}


