import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ComptesPage } from './comptes.page';

describe('ComptesPage', () => {
  let component: ComptesPage;
  let fixture: ComponentFixture<ComptesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ComptesPage],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ComptesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
