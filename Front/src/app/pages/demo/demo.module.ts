import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemoComponent } from './demo.component';
import { DemoRouting } from './demo.routing';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  imports: [
    CommonModule,
    DemoRouting,
    HttpModule,
    FormsModule
  ],
  declarations: [DemoComponent]
})
export class DemoModule { }
