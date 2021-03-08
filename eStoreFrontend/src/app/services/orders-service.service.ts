import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderHistory } from '../models/OrderHistory';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class OrdersServiceService {

  constructor(private http:HttpClient) { }

  getUserOrderHistory(id:string):Observable<OrderHistory[]> {
    return this.http.get<OrderHistory[]>(SERVER_URL+"/order-history/"+id);
  }
  
}
