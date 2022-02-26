package org.mytests.tests.example;

import com.jdiai.tools.Safe;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.mytests.tests.TestsInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.mytests.tests.states.States.loginKKR;
import static org.mytests.uiobjects.example.site.SiteKKR.kkrPage;

public class KKRTests implements TestsInit {
    @Test
    public void loginTest() throws InterruptedException {
        loginKKR();
    }

//    @Test
//    public void test1() {
//        SoftAssert sa = new SoftAssert();
//        sa.assertTrue(false, "Test1 failed");
//        sa.assertFalse(true, "Test1 failed again");
//        sa.assertAll();
//    }
//
//    @Test
//    public void test2() throws IllegalAccessException {
//        SoftAssert sa = new SoftAssert();
//        com.epam.jdi.light.asserts.core.SoftAssert jdiSa = new com.epam.jdi.light.asserts.core.SoftAssert();
//        jdiSa.assertSoft();
//        kkrPage.download.is().displayed();
//        sa.assertTrue(false, "Test2 failed");
//        sa.assertFalse(true, "Test2 failed again");
//        if (!((Map<AssertionError,IAssert<?>>)FieldUtils.readField(sa,"m_errors", true)).isEmpty()) {
//            sa.assertAll();
//        }
//        if (!((Safe<List<String>>)FieldUtils.readField(jdiSa, "listOfErrors", true)).getDefault().isEmpty()) {
//            jdiSa.assertResults();
//        }
//    }
//
//    @Test
//    public void test3() {
//        Assert.assertTrue(true, "Test2 passed");
//        Assert.assertFalse(false, "Test2 passed again");
//    }
}
