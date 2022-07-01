package sdfAsmtTasks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testaverage()
    {
        assertEquals(55,
        AverageNum.findAverage(new int[]{97,35,82,2,45}));
    }
}
