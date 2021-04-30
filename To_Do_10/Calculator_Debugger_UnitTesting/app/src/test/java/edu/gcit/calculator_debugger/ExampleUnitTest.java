package edu.gcit.calculator_debugger;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    public calculator mCalculator;

    @Before
    public void setUp(){
        mCalculator = new calculator();
    }

    @Test
    public void addTwoNumbers(){
        double result = mCalculator.add(2d, 5d);
        assertThat(result, is(equalTo(7d)));
    }

    @Test
    public void subtractTwoNumbers(){
        double result = mCalculator.sub(5d,3d);
        assertThat(result, is(equalTo(2d)));
    }

    @Test
    public  void subWorksWithNegativeResults(){
        double result = mCalculator.sub(3d,5d);
        assertThat(result, is(equalTo(-2d)));
    }

    @Test
    public  void divideTwoNumber(){
        double result = mCalculator.div(20d,4d);
        assertThat(result, is(equalTo(5d)));
    }

    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(6d,0d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void multiplyTwoNumber(){
        double result = mCalculator.mul(3d,4d);
        assertThat(result, is(equalTo(12d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(3d,0d);
        assertThat(result, is(equalTo(0d)));
    }


}