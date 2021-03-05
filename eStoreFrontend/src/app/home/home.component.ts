import { Component, OnInit } from '@angular/core';
import { Products } from '../models/products';
import { PRODUCTS_LIST } from './mockProducts';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productsList:Products[];
  constructor() { 
    this.productsList=PRODUCTS_LIST;
  }

  ngOnInit(): void {

  }

}
