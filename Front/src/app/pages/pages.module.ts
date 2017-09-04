import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesRouting} from './pages.routing';
import { PagesComponent} from './pages.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  imports: [
    CommonModule,
    PagesRouting
  ],
  declarations: [PagesComponent, PageNotFoundComponent]
})
export class PagesModule { }
