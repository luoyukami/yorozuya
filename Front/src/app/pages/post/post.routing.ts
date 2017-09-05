import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PostComponent} from './post.component';

const routes: Routes = [
  {
    path: '',
    component: PostComponent,
    children: [
      {path: '', redirectTo: 'show', pathMatch: 'full'},
      {path: 'show', loadChildren: 'app/pages/post/children/show/show.module#ShowModule'},
      {path: 'write', loadChildren: 'app/pages/post/children/write/write.module#WriteModule'},
      {path: 'read', loadChildren: 'app/pages/post/children/read/read.module#ReadModule'}
    ]
  }
];

export const PostRouting: ModuleWithProviders = RouterModule.forChild(routes);
