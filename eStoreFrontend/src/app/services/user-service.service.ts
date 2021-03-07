import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { SERVER_URL } from './environmentvariable';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }
// Admin Functionalities

  listAllUsers():Observable<User[]> {
     return this.http.get<User[]>(SERVER_URL+"get-all-users");
  }

  searchUser(query:string):Observable<User[]> {
     return this.http.get<User[]>(SERVER_URL+"search-user/"+query);
  }

  activateDeactivateUser(id:string):Observable<User> {
     return this.http.get<User>(SERVER_URL+"activate-deactivate-user/"+id);
  }

  getUserById(userId:string):Observable<User> {
    return this.http.get<User>(SERVER_URL+"get-user-by-id/"+userId);
  }
}
