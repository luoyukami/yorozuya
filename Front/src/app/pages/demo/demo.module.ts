import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemoComponent } from './demo.component';
import { DemoRouting } from './demo.routing';
import { HttpModule } from '@angular/http';


@NgModule({
  imports: [
    CommonModule,
    DemoRouting,
    HttpModule
  ],
  declarations: [DemoComponent]
})
export class DemoModule { }
