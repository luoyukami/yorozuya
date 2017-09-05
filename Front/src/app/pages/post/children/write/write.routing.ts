import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {WriteComponent} from './write.component';

const routes: Routes = [
  {
    path: '',
    component: WriteComponent
  }
];

export const WriteRouting: ModuleWithProviders = RouterModule.forChild(routes)
