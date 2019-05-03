import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelEntryComponent } from './panel-entry.component';

describe('PanelEntryComponent', () => {
  let component: PanelEntryComponent;
  let fixture: ComponentFixture<PanelEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanelEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
