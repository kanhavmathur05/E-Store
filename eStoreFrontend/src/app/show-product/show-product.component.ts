import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Products } from '../models/products';
import { ProductServiceService } from '../services/product-service.service';

@Component({
  selector: 'app-show-product',
  templateUrl: './show-product.component.html',
  styleUrls: ['./show-product.component.css']
})
export class ShowProductComponent implements OnInit {

  admin:boolean;
//  product:Products;
  product:Products={
    id:12,
    productName:"jajlksd",
    productImage:"download.png",
    price:1231,
    updatedDate:"asfdsadf",
    addedDate:"afasdfdsaf",
    availableQuantity:32,
    inStock:true,
    description:"kjahsdfjkashdfjksakjdfhkdshfkjashfhdfask"
  };
  constructor(private route:ActivatedRoute,private productService:ProductServiceService) {
    // this.productService.viewProduct(this.route.snapshot.paramMap.get('id')).subscribe(
    //   (data)=>{
    //     this.product=data;
    //   }
    // );
  }

  ngOnInit(): void {
  }

}
