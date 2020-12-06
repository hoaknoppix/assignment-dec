package au.com.nab.mainservice.service.impl;

import au.com.nab.mainservice.dto.GetVoucherRequest;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.service.VoucherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {

  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
    return null;
  }

  @Override
  public List<GetVoucherResponse> getVouchers(GetVoucherRequest getVoucherRequest) {
    return null;
  }
}
