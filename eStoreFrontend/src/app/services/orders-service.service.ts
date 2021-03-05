import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../models/orders';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class OrdersServiceService {

  constructor(private http:HttpClient) { }

  getUserOrderHistory(id:number):Observable<Orders[]> {
    return this.http.get<Orders[]>(SERVER_URL+"/order-history/"+id);
  }
  
}
