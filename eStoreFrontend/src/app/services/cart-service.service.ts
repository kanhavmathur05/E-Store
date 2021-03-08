import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../models/cart';
import { CartProducts } from '../models/cartProducts';
import { Orders } from '../models/orders';
import { Products } from '../models/products';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

  constructor(private http:HttpClient) { }

  addToCart(cartProduct:CartProducts):Observable<CartProducts> {
    return this.http.post<CartProducts>(SERVER_URL+"add-product-to-cart",cartProduct);
  }

  deleteFromCart(id:string) :Observable<CartProducts> {
    return this.http.delete<CartProducts>(SERVER_URL+"delete-product-from-cart/"+id);  //id=cartProductId
  }

  viewCartProducts(id:string):Observable<CartProducts[]> {
    return this.http.get<CartProducts[]>(SERVER_URL+"products-in-user-cart/"+id);
  }

  updateProductIncart(product:Products):Observable<Products> {
    return this.http.post<Products>(SERVER_URL+"update-product-in-cart",product);
  }

  getUserCart(id:string):Observable<Cart> {
    return this.http.get<Cart>(SERVER_URL+"get-cart/"+id);
  }
  checkout(id:number): Observable<Orders> {
    return this.http.get<Orders>(SERVER_URL+"place-order/"+id);
  }
}
