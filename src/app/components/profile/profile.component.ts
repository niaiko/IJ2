import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from 'src/app/_services/token-strorage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  username : any ;
  Usertoken : any;
  roles: any;
  email :any ;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.username = this.currentUser.body["username"]
    this.Usertoken =this.currentUser.body["accessToken"]
    this.email=this.currentUser.body["email"]
    this.roles= this.currentUser.body["roles"]
  }
}
