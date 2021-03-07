import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Orders } from '../models/orders';
import { OrdersServiceService } from '../services/orders-service.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  ordersHistoryList:Orders[];

  constructor(private route:ActivatedRoute, private orderHistoryService:OrdersServiceService) { 
    console.log('ajhfksdhfkfjsdhf',this.route.snapshot.paramMap.get('id'));
    this.orderHistoryService.getUserOrderHistory(this.route.snapshot.paramMap.get('id')).subscribe(
      (data)=>{
        this.ordersHistoryList=data;
      }
    );

  }

  ngOnInit(): void {
  }

}
