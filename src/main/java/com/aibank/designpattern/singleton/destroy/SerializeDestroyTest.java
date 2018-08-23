package com.aibank.designpattern.singleton.destroy;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:35
 * @Description:
 */
public class SerializeDestroyTest {

    @Test
    public void testSerialize() throws Exception {
        Elvis elvis1 = Elvis.instance;
        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(elvis1);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Elvis elvis2 = (Elvis) ois.readObject();

        Assert.assertEquals(false, elvis1 == elvis2);
    }
}