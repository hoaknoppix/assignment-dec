package au.com.nab.voucheradapter.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.com.nab.voucheradapter.client.VoucherClient;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;
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
public class VoucherControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private VoucherClient voucherClient;

  @Test
  public void createVoucher() throws Exception {
    when(voucherClient.createVoucher()).thenReturn(new VoucherResponse());
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/v1/voucher")
        .content("{\"phoneNumber\": \"1234\", \"voucherServiceToken\": \"4567\"}")
        .contentType(
        MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MockHttpServletResponse response = mockMvc.perform(request).andDo(print()).andExpect(status().isCreated()).andReturn().getResponse();
    assertEquals("{\"code\":null,\"expiration\":null}", response.getContentAsString());
  }

}
