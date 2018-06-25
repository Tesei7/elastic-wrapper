package com.tesei7.elasticwrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ElasticWrapperController.class)
@EnableSpringDataWebSupport
public class ElasticWrapperApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void shouldReturnBuildings() throws Exception {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("[]", HttpStatus.OK);
        //given
        given(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class)))
                .willReturn(responseEntity);
        //when
        this.mockMvc.perform(get("/_search"))
                .andExpect(status().isOk()).andExpect(content().string("[]"));
        //then
//		then(pageableArgumentCaptor.getValue().getPageSize()).isEqualTo(20);
    }
}
