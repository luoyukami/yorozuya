import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {SignupComponent} from './signup.component';

const routes: Routes = [
  {
    path: '',
    component: SignupComponent
  }
];

export const SignupRouting: ModuleWithProviders = RouterModule.forChild(routes)
