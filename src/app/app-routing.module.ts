import { DeteilComponent } from './deteil/deteil.component';
import { HomeComponent } from './home/home.component';
import { BookComponent } from './book/book.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', component:HomeComponent, pathMatch:'full'},
  {path: 'home', component:HomeComponent},
  {path: 'booklist', component:BookComponent},
  {path: 'bookdeteil/:bookid', component:DeteilComponent},
  {path: '**', component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
