import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartPerfumeComponent } from './cart-perfume.component';

describe('CartPerfumeComponent', () => {
  let component: CartPerfumeComponent;
  let fixture: ComponentFixture<CartPerfumeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CartPerfumeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CartPerfumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
