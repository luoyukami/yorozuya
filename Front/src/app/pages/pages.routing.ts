import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PagesComponent} from './pages.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: 'pages',
    component: PagesComponent,
    children: [
      {path: '', redirectTo: 'demo', pathMatch: 'full'},
      {path: 'demo', loadChildren: './demo/demo.module#DemoModule'},
      {path: 'user', loadChildren: './user/user.module#UserModule'},
      {path: 'post', loadChildren: './post/post.module#PostModule'},
      {path: '**', component: PageNotFoundComponent}
    ]
  }
];

export const PagesRouting: ModuleWithProviders = RouterModule.forChild(routes)
