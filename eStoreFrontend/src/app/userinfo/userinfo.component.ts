import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../models/user';
import { UserServiceService } from '../services/user-service.service';
import { MOCK_USERS } from '../mockData/mockuserslist';
import { AddressServiceService } from '../services/address-service.service';
import { Address } from '../models/Address';
import { MOCK_ADDRESS } from '../mockData/mockAddress';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  user:User;
  addresses:Address[];
  constructor(private route:ActivatedRoute, private userService:UserServiceService, private addressService:AddressServiceService) {
    console.log('This is the id------>',this.route.snapshot.paramMap.get('id'));
    // this.userService.getUserById(this.route.snapshot.paramMap.get('id')).subscribe(
    //   (data)=>{
    //     this.user=data;
    //     console.log(data);
    //   }
    // );
        // this.addressService.getAllAddressesOfUser(this.route.snapshot.paramMap.get('id')).subscribe(
        //   (data)=>{
        //       this.address=data;
        //   }
        // );

    this.user=MOCK_USERS[0];
    this.addresses=MOCK_ADDRESS;
    console.log('adsafsadfasdfsdafdsfsadfasdfasdf',this.user);
   }

  ngOnInit(): void {
  }

}
