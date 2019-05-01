import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material';
import {RecoverPasswordComponent} from '../recover-password/recover-password.component';
import {UserSignUpComponent} from '../user-signup/user-sign-up.component';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {DataService} from '../services/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  @Input() labelTitle: string;
  @Input() labelUser: string;
  @Input() labelPassword: string;

  hide: boolean;
  frGroup: FormGroup;
  loginError: boolean;
  routeQueryParams$: Subscription;

  constructor(private dialog: MatDialog, private frBuilder: FormBuilder, private dataService: DataService) {}

  ngOnInit() {
    this.hide = true;
    this.loginError = false;
    this.frGroup = this.frBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  get fgc() {
    return this.frGroup.controls;
  }

  openRecoverPassword() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    this.dialog.open(RecoverPasswordComponent, dialogConfig);
  }

  openUserSignUp() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(UserSignUpComponent, dialogConfig);

    // const dialogRef = this.dialog.open(UserSignUpComponent, {
    //   width: '250px'
    // });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    //   this.router.navigate(['.'], { relativeTo: this.route });
    // });

  }

  sendLogin(data) {
    console.log(data);
    this.loginError = false ;
    this.fgc.username.reset();
    this.fgc.password.reset();
  }

  desactivateError() {
    if (this.loginError) {
      this.loginError = false;
    }
  }

  ngOnDestroy(): void {
    // this.routeQueryParams$.unsubscribe();
  }
}
