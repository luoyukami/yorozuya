import { Component, OnInit } from '@angular/core';

import { User } from '../../../../share/models/User'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
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
  onSubmit(value) {
    console.dir(value);
  }

}
