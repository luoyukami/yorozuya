import { Component, OnInit } from '@angular/core';

import { User } from '../../../../share/models/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  public user: User = {
    userName: 'luoyu',
    account: {
      email: '',
      password: '',
      confirmPW: ''
    }
  };
  constructor() { }

  ngOnInit() {
  }
}
