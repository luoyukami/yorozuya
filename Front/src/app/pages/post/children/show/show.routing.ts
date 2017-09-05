import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ShowComponent} from './show.component';

const routes: Routes = [
  {
    path: '',
    component: ShowComponent
  }
];

export const ShowRouting: ModuleWithProviders = RouterModule.forChild(routes)
