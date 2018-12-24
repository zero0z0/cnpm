/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
import java.lang.NullPointerException;
import newpackage.IReceiver;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MyBigNumberTest implements IReceiver{
    
    public void test1() {
        
            System.out.println("Test 1 :");
            String str1 = "20";
            String str2 = "20";
            String expResult = "40";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            
		test.send(result);
        
    }

    @Test
    public void test2() {
        
            System.out.println("Test 2 :");
            String str1 = "99";
            String str2 = "200";
            String expResult = "299";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
            test.send(result);
        
    }

    @Test
    public void test3() {
        
            System.out.println("Test 3 :");
            String str1 = "999";
            String str2 = "99";
            String expResult = "1098";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            test.send(result);
    }

    @Test
    public void test4() {
        try {
            System.out.println("Test 4 :");
            String str1 = "99";
            String str2 = "54a";            
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);   
            test.send(result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void test5() {
        
        try {
            System.out.println("Test 5 :");
            String str1 = "132";
            String str2 = "1235)";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            test.send(result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    @Test
    public void test6() {
        
        System.out.println("Test 6 :");
        String str1 = "042";
        String str2 = "123";
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
        test.send(result);
    }
    
    @Test
    public void test7() {
       
        try {
            System.out.println("Test 7 :");
            String str1 = "12";
            String str2 = "-45";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            test.send(result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    @Test
    public void test8() {
       
        try {
            System.out.println("Test 8 :");
            String str1 = "-2";
            String str2 = "45";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            test.send(result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    @Test
    public void test9() {
        
        System.out.println("Test 9 :");
        String str1 = "0";
        String str2 = "0";
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
        test.send(result);
    }
    
    
    
    
    @Override
    public void send(String msg) {
        System.out.println(msg + "\n");
    }

    
}
