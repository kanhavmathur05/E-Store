import { Component, OnInit } from '@angular/core';
import { Products } from '../models/products';
import { PRODUCTS_LIST } from '../home/mockProducts';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  productsList:Products[];
  constructor() { 
    this.productsList=PRODUCTS_LIST;
  }

  ngOnInit(): void {
  }

}
