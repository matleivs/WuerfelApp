package com.example.nikbin.wuerfelapp;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * @author lei vs <matleivs@gmail.com>
 */

public class WuerfelActivityTest {

    WuerfelActivity testActivity;


    @Before
    public void setUp(){
        testActivity = new WuerfelActivity();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void rollTheDice_returnNumberBetween1and6() throws Exception {
        int number = testActivity.rollTheDice();
        // check that number returned by method is lower than 6
       assertThat(number, lessThanOrEqualTo(6));
        // check that number returned by method is higher than 0
        assertThat(number, greaterThan(0));
    }
}
