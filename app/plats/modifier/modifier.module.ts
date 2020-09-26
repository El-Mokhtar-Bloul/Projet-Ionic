import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifierPageRoutingModule } from './modifier-routing.module';

import { ModifierPage } from './modifier.page';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    IonicModule,
    ModifierPageRoutingModule
  ],
  declarations: [ModifierPage]
})
export class ModifierPageModule {}
