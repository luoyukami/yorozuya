import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WriteComponent } from './write.component';
import { WriteRouting } from './write.routing';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  imports: [
    CommonModule,
    WriteRouting,
    HttpModule,
    FormsModule
  ],
  declarations: [WriteComponent]
})
export class WriteModule { }
