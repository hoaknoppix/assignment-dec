package au.com.nab.mainservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.service.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TokenService tokenService;

  @Test
  public void createToken() throws Exception {
    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setToken("sample_token");
    when(tokenService.create(any())).thenReturn(tokenResponse);
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/v1/token").content("{\"phoneNumber\": \"123\", \"encryptPassword\": \"456\"}").contentType(
        MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MockHttpServletResponse response = mockMvc.perform(request).andDo(print()).andExpect(status().isCreated()).andReturn().getResponse();
    assertEquals("{\"token\":\"sample_token\"}", response.getContentAsString());
  }
}
