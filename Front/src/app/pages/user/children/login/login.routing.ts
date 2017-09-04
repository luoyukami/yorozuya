import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from './login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  }
];

export const LoginRouting: ModuleWithProviders = RouterModule.forChild(routes)