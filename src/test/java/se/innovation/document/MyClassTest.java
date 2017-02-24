package se.innovation.document;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import se.innovation.common.MyClass;
import se.innovation.common.Singleton;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Singleton.class})
public class MyClassTest {

    @Mock
    Singleton singleton;

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

    @Test
    public void testMockSingleton() {
        mockStatic(Singleton.class);
        when(Singleton.instance()).thenReturn(singleton);
        when(singleton.isFalse()).thenReturn(true);
        when(Singleton.isIsFalseStatic()).thenReturn(true);


        assertEquals(true, singleton.isFalse());
        assertEquals(true, Singleton.isIsFalseStatic());
    }
}
