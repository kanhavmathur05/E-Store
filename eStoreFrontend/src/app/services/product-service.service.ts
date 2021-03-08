import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../models/products';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  product:Products;

  constructor(private http:HttpClient) { }

  addProduct(product:Products,fileName:string):Observable<Products> {
    product.productImage=fileName;
    console.log('ADD PRODUCT SERVICE METHOD:::::',product);
    return this.http.post<Products>(SERVER_URL+"admin/add-product",product);
  }

  viewProduct(id:string):Observable<Products> {
    return this.http.get<Products>(SERVER_URL+"view-product/"+id);
  }

  deleteProduct(id:string):Observable<Products> {
    return this.http.delete<Products>(SERVER_URL+"admin/delete-product/"+id);
  }

  listAllProducts():Observable<Products[]> {
    return this.http.get<Products[]>(SERVER_URL+"list-all-products");
  }

  updateProduct(product:Products):Observable<Products> {
    return this.http.post<Products>(SERVER_URL+"admin/update-product",product);
  }

  

}
