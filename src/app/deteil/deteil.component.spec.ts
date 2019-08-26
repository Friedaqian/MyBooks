import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeteilComponent } from './deteil.component';

describe('DeteilComponent', () => {
  let component: DeteilComponent;
  let fixture: ComponentFixture<DeteilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeteilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeteilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
