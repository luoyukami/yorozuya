/**
 * Created by 落羽 on 2017/8/17.
 */
import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {DemoComponent} from './demo.component';

const routes: Routes = [
  {
    path: '',
    component: DemoComponent
  }
];

export const DemoRouting: ModuleWithProviders = RouterModule.forChild(routes)
