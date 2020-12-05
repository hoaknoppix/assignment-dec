package au.com.nab.dummyvoucher.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.com.nab.dummyvoucher.service.DummyVoucherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DummyVoucherControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DummyVoucherService dummyVoucherService;

  @Test
  public void createVoucher() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/v1/voucher").content("{}").contentType(
        MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    mockMvc.perform(request).andDo(print()).andExpect(status().isCreated());
    verify(dummyVoucherService).createVoucher(any());
  }

}
