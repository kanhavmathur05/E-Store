import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from '../models/Address';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class AddressServiceService {

  constructor(private http:HttpClient) { }

  addAddress(address:Address):Observable<Address> {
    return this.http.post<Address>(SERVER_URL+"/add-address",address);
  }

  deleteAddress(id:number):Observable<Address> {
    return this.http.delete<Address>(SERVER_URL+"/delete-address/"+id);
  }

  getAddress(id:number):Observable<Address> {
    return this.http.get<Address>(SERVER_URL+"/address/"+id);
  }

  updateAddress(address:Address) :Observable<Address> {
    return this.http.post<Address>(SERVER_URL+"/update-address",address);
  }

  getAllAddressesOfUser(id:number):Observable<Address[]> {
    return this.http.get<Address[]>(SERVER_URL+"/all-address/"+id);
  }
}
