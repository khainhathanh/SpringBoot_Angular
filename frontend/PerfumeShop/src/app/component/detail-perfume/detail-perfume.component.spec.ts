import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailPerfumeComponent } from './detail-perfume.component';

describe('DetailPerfumeComponent', () => {
  let component: DetailPerfumeComponent;
  let fixture: ComponentFixture<DetailPerfumeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailPerfumeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailPerfumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
