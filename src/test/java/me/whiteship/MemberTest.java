package me.whiteship;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {


    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName("devin");
        Assert.assertEquals(member.getName(), "devin");

    }

}