import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';
import { LoginRouting } from './login.routing';

@NgModule({
  imports: [
    CommonModule,
    LoginRouting,
    FormsModule
  ],
  declarations: [LoginComponent]
})
export class LoginModule { }
