import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentPerfumeComponent } from './payment-perfume.component';

describe('PaymentPerfumeComponent', () => {
  let component: PaymentPerfumeComponent;
  let fixture: ComponentFixture<PaymentPerfumeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentPerfumeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaymentPerfumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
