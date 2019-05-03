import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  login: { label_title: string, label_user: string, label_password: string } = {
    label_title: 'Login',
    label_user: 'Username',
    label_password: 'Password'
  };

  constructor(private route: ActivatedRoute, private router: Router) {
  }
}
