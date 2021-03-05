import { Component, OnInit } from '@angular/core';
import { Products } from '../models/products';

@Component({
  selector: 'app-show-product',
  templateUrl: './show-product.component.html',
  styleUrls: ['./show-product.component.css']
})
export class ShowProductComponent implements OnInit {

  product:Products={
    id:12,
    productName:"jajlksd",
    productImage:"assets/productImages/download.jpeg",
    price:1231,
    updatedDate:"asfdsadf",
    addedDate:"afasdfdsaf",
    availableQuantity:32,
    inStock:true,
    description:"kjahsdfjkashdfjksakjdfhkdshfkjashfhdfask"
  };
  constructor() { }

  ngOnInit(): void {
  }

}
