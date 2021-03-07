import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../models/products';
import { ProductServiceService } from '../services/product-service.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product:Products={  id:null,
    productImage:'',
  productName:'',
  description:'',
  availableQuantity:null,
  price:null,
  addedDate:'',
  inStock:null,
  updatedDate:''};

  fileName:string;

  constructor(private productService:ProductServiceService,private router:Router) { }

  onFileSelected(event) {
    // this.file=event.target.file;
    this.fileName=event.target.files[0].name;
  }
  addProduct() {
    this.productService.addProduct(this.product,this.fileName).subscribe(
      (data)=>{
      }
    );
    this.router.navigate(['admin/products']).then(()=>{
      window.location.reload();
    });
  }

  ngOnInit(): void {
  }

}
