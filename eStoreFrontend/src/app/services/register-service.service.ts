import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { SERVER_URL } from './environmentvariable';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private http:HttpClient) { }

  registerUser(user:User):Observable<User> {
    console.log('USER TO BE REGISTER:::::::::', user);
    return this.http.post<User>(SERVER_URL+"register",user);
  }
}
