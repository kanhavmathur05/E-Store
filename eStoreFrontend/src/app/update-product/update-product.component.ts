import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../models/products';
import { ProductServiceService } from '../services/product-service.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  product:Products;

  constructor(private productService:ProductServiceService,private router:Router,private route:ActivatedRoute) { 
    this.productService.viewProduct(this.route.snapshot.paramMap.get('id')).subscribe(
      (data)=>{
        console.log(data.productImage);
        this.product=data;
      }
    );
  }

  updateProduct()
  {
    this.productService.updateProduct(this.product).subscribe(
      (data)=>{
        this.router.navigate(['admin/products']).then(
          ()=>{window.location.reload();}
        );
      }
    );
  }

  ngOnInit(): void {
  }

}
