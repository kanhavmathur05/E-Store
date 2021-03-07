import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../models/products';
import { ProductServiceService } from '../services/product-service.service';
import { PRODUCTS_LIST } from '../home/mockProducts'

@Component({
  selector: 'app-product-management',
  templateUrl: './product-management.component.html',
  styleUrls: ['./product-management.component.css']
})
export class ProductManagementComponent implements OnInit {

  displayedColumns: string[] = ['id','productName','description','price','availableQuantity','options'];
  productsList:Products[];
  constructor(private productService:ProductServiceService, private router:Router) {
    // this.productService.listAllProducts().subscribe(
    //   (data)=>{
    //     this.productsList=data;
    //   }
    // );
    this.productsList=PRODUCTS_LIST;
   }

   deleteProduct(id:string) {
     this.productService.deleteProduct(id).subscribe(
       (data)=>{
       }
     );
     window.location.reload();
   }

  ngOnInit(): void {
  }

}
