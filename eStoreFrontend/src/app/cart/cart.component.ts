import { Component, OnInit } from '@angular/core';
import { Products } from '../models/products';
import { PRODUCTS_LIST } from '../home/mockProducts';
import { OrdersServiceService } from '../services/orders-service.service';
import { CartServiceService } from '../services/cart-service.service';
import { ActivatedRoute } from '@angular/router';
import { CartProducts } from '../models/cartProducts';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  productsList:Products[];
  cartProducts:CartProducts[];
  constructor(private ordersService:OrdersServiceService,private cartService:CartServiceService,private router:ActivatedRoute) { 
    this.productsList=PRODUCTS_LIST;
    
    this.cartService.viewCartProducts(this.router.snapshot.paramMap.get('id')).subscribe(
      (data)=>{

      }
    );
  }
  removeItemFronUserCart()
  {
    this.cartService.deleteFromCart("").subscribe(
      (data)=>{
        console.log('item removed from cart!!');
      }
      // window.location.reload();
    );
  }
//  METHOD TO CALCULATE ORDER TOTAL
  // calculateOrderTotal()
  // {
  //   // get products in cart array;
  //   ordertotal=0
  //   for(i=0;i<total items;i++)
  //   {
  //     ordertotal=ordertotal+(product[i].getQuantity*product[i].price)
  //   }
  //   this.orderTotal=ordertotal;
  // }
  ngOnInit(): void {
  }

}
