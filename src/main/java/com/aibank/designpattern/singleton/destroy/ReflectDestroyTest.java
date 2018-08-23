package com.aibank.designpattern.singleton.destroy;

import com.aibank.designpattern.singleton.methods.Usoppu;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:17
 * @Description:
 */
public class ReflectDestroyTest {

    @Test
    public void testReflect() throws Exception {
        Elvis elvis1 = Elvis.instance;
        Elvis elvis2 = Elvis.instance;
        Assert.assertEquals(true, elvis1 == elvis2);

        Class<Elvis> clz = Elvis.class;
        Constructor<Elvis> constructor = clz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Elvis elvis3 = constructor.newInstance(null);
        Assert.assertEquals(false, elvis1 == elvis3);

    }

    @Test
    public void testReflect2() throws Exception {
        Usoppu usoppu1 = Usoppu.instance;
        Usoppu usoppu2 = Usoppu.instance;
        Assert.assertEquals(true, usoppu1 == usoppu2);

        Class<Usoppu> clz = Usoppu.class;
        Constructor<Usoppu> constructor = clz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Usoppu usoppu3 = constructor.newInstance(null);
    }
}