import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../models/cart';
import { CartProducts } from '../models/cartProducts';
import { Products } from '../models/products';
import { CartServiceService } from '../services/cart-service.service';
import { ProductServiceService } from '../services/product-service.service';


import { PRODUCTS_LIST } from './mockProducts';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  cartProduct:CartProducts;
  product:Products;
  productsList:Products[];
  constructor(private cartService:CartServiceService, private productService:ProductServiceService,private route:Router) { 
    this.productsList=PRODUCTS_LIST;
  }

  addToCart(id:string) {

    console.log('ID Of the Product::::::::::::>>>>>>>>>>',id);

    this.productService.viewProduct(id).subscribe(
      (data)=>{
        this.product=data;
      }
    );
    this.cartProduct.productId=this.product.id;
    this.cartProduct.quantity=1;  //It will be changes when user will get the option to change the quantity of product to order
    this.cartProduct.total=this.product.price;
    this.cartProduct.userId=parseInt(sessionStorage.getItem('userId'));
    this.cartService.getUserCart(JSON.stringify(this.cartProduct.userId)).subscribe(
      (data)=>{
        this.cartProduct.cartId=data.id;
      }
    );
    this.cartService.addToCart(this.cartProduct).subscribe(
      (data)=>{
      }
    );
    this.route.navigate(['cart',this.cartProduct.userId]).then(
      ()=>{window.location.reload();}
    )        
  }
  ngOnInit(): void {

  }

}
