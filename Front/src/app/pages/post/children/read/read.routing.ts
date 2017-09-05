import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ReadComponent} from './read.component';

const routes: Routes = [
  {
    path: '',
    component: ReadComponent
  }
];

export const ReadRouting: ModuleWithProviders = RouterModule.forChild(routes)
