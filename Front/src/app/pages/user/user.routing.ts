import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserComponent} from './user.component';

const routes: Routes = [
  {
    path: '',
    component: UserComponent,
    children: [
      {path: '233', redirectTo: 'signup', pathMatch: 'full'},
      {path: 'login', loadChildren: 'app/pages/user/children/login/login.module#LoginModule'},
      {path: 'signup', loadChildren: 'app/pages/user/children/signup/signup.module#SignupModule'}
    ]
  }
];

export const UserRouting: ModuleWithProviders = RouterModule.forChild(routes)
