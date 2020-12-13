package au.com.nab.dummyvoucher.service;

import au.com.nab.dummyvoucher.dto.VoucherResponse;

public interface DummyVoucherService {

  VoucherResponse createVoucher() throws InterruptedException;
}
