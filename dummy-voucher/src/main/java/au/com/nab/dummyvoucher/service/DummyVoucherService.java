package au.com.nab.dummyvoucher.service;

import au.com.nab.dummyvoucher.dto.VoucherRequest;
import au.com.nab.dummyvoucher.dto.VoucherResponse;

public interface DummyVoucherService {

  VoucherResponse createVoucher(VoucherRequest voucherRequest) throws InterruptedException;
}
