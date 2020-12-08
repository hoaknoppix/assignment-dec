package au.com.nab.mainservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.com.nab.mainservice.client.VoucherClient;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.entity.Voucher;
import au.com.nab.mainservice.repository.VoucherRepository;
import au.com.nab.mainservice.service.TokenService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
  private TokenService tokenService;

  @MockBean
  private VoucherRepository voucherRepository;

  @MockBean
  private VoucherClient voucherClient;

  @Test
  public void createVoucher() throws Exception {
    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setToken("sample_token");
    when(tokenService.create(any())).thenReturn(tokenResponse);
    when(voucherClient.createVoucher()).thenReturn(new au.com.nab.mainservice.client.dto.VoucherResponse());
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/v1/voucher").content("{\"phoneNumber\": \"123\", \"token\": \"456\"}").contentType(
        MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MockHttpServletResponse response = mockMvc.perform(request).andDo(print()).andExpect(status().isCreated()).andReturn().getResponse();
    assertEquals("{\"status\":\"Valid\",\"voucherCode\":null,\"expirationDate\":null}", response.getContentAsString());
  }

  @Test
  public void getVouchers() throws Exception {
    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setToken("sample_token");
    Token token = new Token();
    when(tokenService.find(any(), any(), any())).thenReturn(Optional.of(token));
    List<Voucher> voucherList = new ArrayList<>();
    Voucher voucher = new Voucher();
    voucher.setCode("123");
    voucher.setPhoneNumber("123");
    voucher.setExpirationDate(new Date());
    voucherList.add(voucher);
    when(voucherRepository.findAllByPhoneNumber(any())).thenReturn(voucherList);
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/v1/vouchers").param("token", "123").param("salt", "123").param("encryptPassword", "123").contentType(
        MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MockHttpServletResponse response = mockMvc.perform(request).andDo(print()).andExpect(status().isOk()).andReturn().getResponse();
    assertEquals("[{\"voucherCode\":\"123\"}]", response.getContentAsString());
  }

}
