package se.innovation.document;

import org.junit.Test;
import org.mockito.Mockito;
import se.innovation.common.MyClass;

import static org.junit.Assert.assertEquals;

public class MyClassTest {

    @Test
    public void testMyClass() {
        MyClass myClass = new MyClass();

        assertEquals(false, myClass.getInverse(true));
    }

    @Test
    public void testMockMyClass() {
        MyClass myClassSpy = Mockito.spy(new MyClass());
        Mockito.doReturn(false).when(myClassSpy).getInverse(false);

        assertEquals(false, myClassSpy.getInverse(false));
    }
}
