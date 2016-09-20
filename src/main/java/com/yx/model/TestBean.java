package com.yx.model;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * User: LiWenC
 * Date: 16-9-20
 */
public class TestBean {
    public static void main(String[] args) {
        List<GroupMember> persons = new ArrayList<GroupMember>();
        persons.add(new GroupMember("18810931058", "hello", 86, 76787897L, "a", "http://test.jpg"));
        persons.add(new GroupMember("18810931059", "world", 86, 76897L, "b", "http://test.jpg"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("persons", persons);
        System.out.println(jsonObject.toString());
    }
}
