import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedIn:boolean;
  user:User={
    id:123,
    firstName:"adsfafds",
    lastName:"afasdf",
    email:"kasdjfnksad",
    password:"asdfaf",
    contactNumber:1231,
    role:"ROLE_USER"
  };
  constructor(private router:Router) { 
    if(sessionStorage.getItem('userId')!=null)
    {
      this.loggedIn=true;
    }
    else
    {
      this.loggedIn=false;
    }
//    console.log('ROUTER URL By CONSOLE---->',this.router.url);
  }
  logoutUser()
  {
    sessionStorage.clear();
    this.loggedIn=false;
    this.router.navigate(['']);
    window.location.reload();
  }
  ngOnInit(): void {
  }

}
