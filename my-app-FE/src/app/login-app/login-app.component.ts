import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../model/User/user.model';
import { HttpServerService } from '../Services/http-server.service';
import { Route, Router } from '@angular/router';
import { DataServiceService } from '../Services/data-service.service'; 
import { JWT } from '../model/JWT/jwt.model';
@Component({
  selector: 'app-login-app',
  templateUrl: './login-app.component.html',
  styleUrls: ['./login-app.component.css']
})
export class LoginAppComponent {
  login = "signin"
  message = '';
  constructor(private httpService : HttpServerService, private router : Router, private dataService: DataServiceService){
  }
  getUser(user: string, pass: string){
      this.httpService.postUser(new User(user,pass,[],false,false,false,false)).subscribe(data =>{
        if(data != null){
          this.dataService.changeMessage(data);
          this.router.navigateByUrl('student');
        }else{
          this.message = "Login fail! Please try again";
          this.router.navigateByUrl('login');
        }
      })
  }

  createUser(user: string, pass: string){
    this.httpService.createUser(new User(user,pass,[],false,false,false,false)).subscribe(data =>{
      if(data != null){
        this.message = "SignUp success! Your account has been created"
        this.signIn();
      }else{
        this.message = "SignUp fail!"
        this.signUp();
      }
    })
  }

  signIn(){
    this.login = 'signin'
    
  }
  signUp(){
    this.login = 'signup'
  }

}
