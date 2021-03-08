import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserServiceService } from '../services/user-service.service';
import { MOCK_USERS } from '../mockData/mockuserslist';
@Component({
  selector: 'app-usermanagement',
  templateUrl: './usermanagement.component.html',
  styleUrls: ['./usermanagement.component.css']
})
export class UsermanagementComponent implements OnInit {

  users:User[];
  displayedColumns: string[] = ['id','firstName','lastName','contactNumber','email','password','role','editoption'];
  constructor(private userService:UserServiceService) { 

    // this.users=MOCK_USERS;
    // dataSource = ELEMENT_DATA;
    this.userService.listAllUsers().subscribe(
    (data)=>{
      this.users=data;
    }
    );
  }

  ngOnInit(): void {
  }

}
