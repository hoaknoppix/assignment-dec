package au.com.nab.mainservice.service.impl;

import au.com.nab.mainservice.dto.GetVoucherRequest;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.entity.Voucher;
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

  public VoucherServiceImpl(TokenService tokenService, VoucherRepository voucherRepository) {
    this.tokenService = tokenService;
    this.voucherRepository = voucherRepository;
  }

  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
    return null;
  }

  @Override
  public List<GetVoucherResponse> getVouchers(GetVoucherRequest getVoucherRequest) {
    Token token = tokenService
        .find(getVoucherRequest.getToken(), getVoucherRequest.getEncryptPassword(), getVoucherRequest.getSalt()).orElseThrow(() -> new RuntimeException("Token is not valid."));
    List<Voucher> vouchers = voucherRepository.findAllByPhoneNumber(token.getPhoneNumber());
    return vouchers.stream().map(v -> {
      String voucher = v.getVoucher();
      GetVoucherResponse getVoucherResponse = new GetVoucherResponse();
      getVoucherResponse.setVoucherCode(voucher);
      return getVoucherResponse;
    }).collect(Collectors.toList());
  }
}
