import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SignupComponent } from './signup.component';
import { SignupRouting } from './signup.routing';
import { HttpModule } from '@angular/http';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SignupRouting,
    HttpModule
  ],
  declarations: [SignupComponent]
})
export class SignupModule { }
