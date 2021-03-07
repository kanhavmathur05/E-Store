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

  // authenticationRequest:AuthenticationRequest;
  constructor(private http:HttpClient) { }

  login(authenticationRequest:AuthenticationRequest):Observable<User> {
       
    // authenticationRequest.email=btoa(authenticationRequest.email);
    console.log('encoded user details:::::',authenticationRequest.email);
    console.log('encoded user details:::::',authenticationRequest.password);
    authenticationRequest.email=btoa(authenticationRequest.email);
        authenticationRequest.password=btoa(authenticationRequest.password);
        console.log('Method invoked!!');
        console.log('encoded user details:::::',authenticationRequest.email);
        console.log('encoded user details:::::',authenticationRequest.password);
    return this.http.post<User>(SERVER_URL+"authenticate",authenticationRequest);
  }
}
