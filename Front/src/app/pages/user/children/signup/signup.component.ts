import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

import { User } from '../../../../share/models/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  public user: User = {
    userName: '',
    account: {
      email: '',
      password: '',
      confirmPW: ''
    }
  };

  constructor(private http: Http) {
  }

  public onSubmit({value, vaild}: { value: User, vaild: boolean }) {
    console.dir(value, vaild);
    console.dir(vaild);
    this.signUP();
  }

  public signUP() {
    this.http.get('yorozuya/signUp?name=' + this.user.userName + '&password=' + this.user.account.password)
      .map(res => res.json())
      .subscribe(data => {
        if (data) console.dir(data);
      });
  }


  ngOnInit() {
  }
}
