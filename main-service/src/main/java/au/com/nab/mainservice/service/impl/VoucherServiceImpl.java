package au.com.nab.mainservice.service.impl;

import au.com.nab.mainservice.client.VoucherClient;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.entity.Voucher;
import au.com.nab.mainservice.exception.TokenNotFoundException;
import au.com.nab.mainservice.repository.VoucherRepository;
import au.com.nab.mainservice.service.VoucherService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import au.com.nab.mainservice.service.TokenService;

@Service
public class VoucherServiceImpl implements VoucherService {
  private TokenService tokenService;
  private VoucherRepository voucherRepository;
  private VoucherClient voucherClient;

  public VoucherServiceImpl(TokenService tokenService, VoucherRepository voucherRepository, VoucherClient voucherClient) {
    this.tokenService = tokenService;
    this.voucherRepository = voucherRepository;
    this.voucherClient = voucherClient;
  }

  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
    au.com.nab.mainservice.client.dto.VoucherResponse externalVoucherResponse = voucherClient.createVoucher();
    Voucher voucher = new Voucher();
    voucher.setCode(externalVoucherResponse.getCode());
    voucher.setExpirationDate(externalVoucherResponse.getExpiration());
    voucher.setPhoneNumber(voucherRequest.getPhoneNumber());
    voucherRepository.saveAndFlush(voucher);
    VoucherResponse voucherResponse = new VoucherResponse();
    voucherResponse.setVoucherCode(externalVoucherResponse.getCode());
    voucherResponse.setExpirationDate(externalVoucherResponse.getExpiration());
    voucherResponse.setStatus("Valid");
    return voucherResponse;
  }

  @Override
  public List<GetVoucherResponse> getVouchers(String token, String salt,String encryptPassword) {
    Token tokenObject = tokenService
        .find(token, encryptPassword, salt).orElseThrow(TokenNotFoundException::new);
    List<Voucher> vouchers = voucherRepository.findAllByPhoneNumber(tokenObject.getPhoneNumber());
    return vouchers.stream().map(v -> {
      String voucher = v.getCode();
      GetVoucherResponse getVoucherResponse = new GetVoucherResponse();
      getVoucherResponse.setVoucherCode(voucher);
      return getVoucherResponse;
    }).collect(Collectors.toList());
  }
}
