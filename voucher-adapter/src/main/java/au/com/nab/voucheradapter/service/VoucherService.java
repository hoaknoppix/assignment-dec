package au.com.nab.voucheradapter.service;

import au.com.nab.voucheradapter.client.dto.VoucherRequest;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;

public interface VoucherService {
  
  VoucherResponse createVoucher(VoucherRequest voucherRequest);

}
