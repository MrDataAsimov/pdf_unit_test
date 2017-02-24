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
    public void testMockMyClassReturnFalse() {
        MyClass myClassSpy = Mockito.spy(new MyClass());
        Mockito.doReturn(false).when(myClassSpy).getInverse(false);

        assertEquals(false, myClassSpy.getInverse(false));
        assertEquals(false, myClassSpy.getInverse(true));
    }

    @Test
    public void testMockMyClassReturnTrue() {
        MyClass myClassSpy = Mockito.spy(new MyClass());
        Mockito.doReturn(true).when(myClassSpy).getInverse(true);

        assertEquals(true, myClassSpy.getInverse(true));
        assertEquals(true, myClassSpy.getInverse(false));
    }


}
