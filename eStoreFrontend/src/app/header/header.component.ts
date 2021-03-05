import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  login:boolean;
  user:User={
    id:123,
    firstName:"adsfafds",
    lastName:"afasdf",
    email:"kasdjfnksad",
    password:"asdfaf",
    contactNumber:1231
  };
  constructor(private router:Router) { 
    this.login=false;
    console.log('ROUTER URL By CONSOLE---->',this.router.url);
  }

  ngOnInit(): void {
  }

}
