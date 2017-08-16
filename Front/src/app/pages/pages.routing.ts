import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PagesComponent} from './pages.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: 'pages',
    component: PagesComponent,
    children: [
      // {path: '', redirectTo: '', pathMatch: 'full'},
      {path: 'not', component: PageNotFoundComponent},
      {path: 'user', loadChildren: './user/user.module#UserModule'}
    ]
  }
];

export const PagesRouting: ModuleWithProviders = RouterModule.forChild(routes)
