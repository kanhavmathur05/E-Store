import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../models/cart';
import { CartProducts } from '../models/cartProducts';
import { Products } from '../models/products';
import { SERVER_URL } from './environmentvariable'

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

  constructor(private http:HttpClient) { }

  addToCart(cartProduct:CartProducts):Observable<CartProducts> {
    return this.http.post<CartProducts>("/add-product",cartProduct);
  }

  deleteFromCart(id:string) :Observable<CartProducts> {
    return this.http.delete<CartProducts>("/delete-product-from-cart/"+id);  //id=cartProductId
  }

  viewCartProducts(id:string):Observable<CartProducts[]> {
    return this.http.get<CartProducts[]>("products-in-user-cart/"+id);
  }

  updateProductIncart(product:Products):Observable<Products> {
    return this.http.post<Products>("/update-product-in-cart",product);
  }

  getUserCart(id:string):Observable<Cart> {
    return this.http.get<Cart>("/get-cart/"+id);
  }
  // checkout(): Observable<> {

  // }
}
