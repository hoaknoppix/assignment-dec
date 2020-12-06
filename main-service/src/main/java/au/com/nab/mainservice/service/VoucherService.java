package au.com.nab.mainservice.service;

import au.com.nab.mainservice.dto.GetVoucherRequest;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import java.util.List;

public interface VoucherService {

  VoucherResponse createVoucher(VoucherRequest voucherRequest);

  List<GetVoucherResponse> getVouchers(GetVoucherRequest getVoucherRequest);
}
