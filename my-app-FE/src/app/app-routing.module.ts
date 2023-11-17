import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginAppComponent } from './login-app/login-app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CreateStudentComponent } from './create-student/create-student.component';


const routes: Routes = [
  { path: 'login', component: LoginAppComponent },
  { path: 'student', component: HomePageComponent},
  {path: 'create', component: CreateStudentComponent},
  { path: '', redirectTo:'/login',pathMatch: 'full' },  // Wildcard route for a 404 page
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
