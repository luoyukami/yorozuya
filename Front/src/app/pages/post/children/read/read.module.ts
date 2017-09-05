import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReadComponent } from './read.component';
import { ReadRouting } from './read.routing';

@NgModule({
  imports: [
    CommonModule,
    ReadRouting
  ],
  declarations: [ReadComponent]
})
export class ReadModule { }
