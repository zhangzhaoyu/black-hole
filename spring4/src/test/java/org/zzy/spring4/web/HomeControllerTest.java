package org.zzy.spring4.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-20
 * @sine 1.0
 */
public class HomeControllerTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void home() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals("index", homeController.home());
    }

    // by mockMvc
    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(homeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(view().name("index"));
    }

}