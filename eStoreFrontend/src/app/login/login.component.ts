import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login:boolean;
  constructor() {
    this.login=true;
  }
  registerOption() {
    this.login=false;
  }
  loginOption() {
    this.login=true;
  }
  ngOnInit(): void {
  
  }

}