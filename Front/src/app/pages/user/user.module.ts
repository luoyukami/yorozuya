import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user.component';
import { UserRouting } from './user.routing';

@NgModule({
  imports: [
    CommonModule,
    UserRouting
  ],
  declarations: [UserComponent]
})
export class UserModule { }
