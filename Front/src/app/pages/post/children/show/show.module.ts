import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowComponent } from './show.component';
import { ShowRouting} from './show.routing';

@NgModule({
  imports: [
    CommonModule,
    ShowRouting
  ],
  declarations: [ShowComponent]
})
export class ShowModule { }
