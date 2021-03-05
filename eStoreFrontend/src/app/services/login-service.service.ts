import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../models/AuthenticationRequest';
import { User } from '../models/user';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  authenticationRequest:AuthenticationRequest;
  constructor(private http:HttpClient) { }

  login(authenticationRequest):Observable<User> {
    return this.http.post<User>("http://localhost:8080/authenticate",authenticationRequest);
  }
}
