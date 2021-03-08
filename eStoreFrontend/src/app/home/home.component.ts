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
  cartDetails:Cart;

  constructor(private cartService:CartServiceService, private productService:ProductServiceService,private route:Router) { 
    this.productService.listAllProducts().subscribe(
      (data)=>{
        this.productsList=data;
      }
    );
    // this.productsList=PRODUCTS_LIST;
  }

  addToCart(id:string) {

    this.cartService.getUserCart(JSON.stringify(sessionStorage.getItem('userId'))).subscribe(
      (data)=>{
        this.cartDetails=data;
        this.cartProduct.cartId=this.cartDetails.id;
        this.cartProduct.userId=this.cartDetails.userId;
      }
    );

    // this.productService.viewProduct(id).subscribe(
    //   (data)=>{
    //     this.product=data;
    //     this.cartProduct.productId=this.product.id;
    //     this.cartProduct.quantity=this.product.availableQuantity;
    //     this.cartProduct.total=this.product.price;
    //   }
    // );
    // let cartProducts:CartProducts={
    //   id:null,
    //   cartId:this.cartDetails.id,
    //   productId:this.product.id,
    //   quantity:this.product.availableQuantity,
    //   total:this.product.price,
    //   userId:this.cartDetails.userId
    // }
    // this.cartService.addToCart(this.cartProduct).subscribe(
    //   (data)=>{
    // //       this.route.navigate(['cart',this.cartProduct.userId]).then(
    // //   ()=>{window.location.reload();}
    // // )
    //   }
    // );        
  }
  ngOnInit(): void {

  }

}
