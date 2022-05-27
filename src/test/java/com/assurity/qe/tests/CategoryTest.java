package com.assurity.qe.tests;

import common.StatusCode;
import io.restassured.response.Response;
import model.CategoryResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.CategoryUtil;
import util.RequestHandler;

import java.util.HashMap;


public class CategoryTest {

    private RequestHandler requestHandler;

    @BeforeClass
    public void init() {
        requestHandler = new RequestHandler();
    }

    @Test
    public void getCategoryTest() {
        SoftAssert softAssert = new SoftAssert();
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("catalogue", Boolean.FALSE.toString());

        Response response = requestHandler.getCategories("6327", queryParam);
        Assert.assertNotNull(response, "Category response should not be null");

        CategoryResponse categoryResponse = response.getBody().as(CategoryResponse.class);
        Assert.assertNotNull(categoryResponse, "Couldn't read response properly");
        softAssert.assertEquals(response.getStatusCode(), StatusCode.SC_OK, "Invalid status code");
        softAssert.assertEquals(categoryResponse.getName(), "Carbon credits");
        softAssert.assertTrue(categoryResponse.getCanRelist(), "CanRelist Display false");

        String promoDescription = CategoryUtil.getPromotionDescriptionByName(categoryResponse, "Gallery");
        softAssert.assertNotNull(promoDescription, "promotion description is null");
        softAssert.assertEquals(promoDescription, "Good position in category", "wrong promotion description");
        softAssert.assertAll();
    }
}
