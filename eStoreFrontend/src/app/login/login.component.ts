import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import  { AuthenticationRequest } from '../models/AuthenticationRequest'
import { User } from '../models/user';
import { LoginServiceService } from '../services/login-service.service';
import { RegisterServiceService } from '../services/register-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login:boolean;
  authenticationRequest:any={};
  user:any={};
  constructor(private loginService:LoginServiceService, private registerService:RegisterServiceService,private router:Router) {
    this.login=true;
  }
  registerOption() {
    this.login=false;
  }
  loginOption() {
    this.login=true;
  }
  loginUser() {
    console.log('VALUES:::::::::::::::::::::::::::',this.authenticationRequest);
    this.loginService.login(this.authenticationRequest).subscribe(
      (data)=>
      {
        this.user=data;
        // if successfull login
        console.log('UserDetails',this.user);
        sessionStorage.setItem('userId',JSON.stringify(this.user.id));
        sessionStorage.setItem('userRole',this.user.role);
        // window.location.reload();
        if(data.role==="ROLE_ADMIN")
        {
          console.log('this is invoked');
          this.router.navigate(['admin/dashboard']);          
        }
        else{
          this.router.navigate(['']).then(
            ()=>{
              window.location.reload();
            }
          );
        }
        // window.location.reload();
      }
    );
  }
  registerUser() {
    console.log('Register User Method called!!',this.user);
    this.registerService.registerUser(this.user).subscribe(
      (data)=>
      {
        this.user=data;
        console.log('User Details::::::',this.user);
      }
    );
     window.location.reload();
  }
  ngOnInit(): void {
  
  }

}
