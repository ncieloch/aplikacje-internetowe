import { TestBed } from '@angular/core/testing';

import { BillOfSaleReportService } from './bill-of-sale-report.service';

describe('BillOfSaleReportService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BillOfSaleReportService = TestBed.get(BillOfSaleReportService);
    expect(service).toBeTruthy();
  });
});
